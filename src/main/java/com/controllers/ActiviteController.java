/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Action;
/*     */ import entities.Activite;
/*     */ import entities.Programme;
/*     */ import entities.Rang;
/*     */ import entities.Structure;
/*     */ import entities.Typeactivite;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ActionFacadeLocal;
/*     */ import sessions.ActiviteFacadeLocal;
/*     */ import sessions.ProgrammeFacadeLocal;
/*     */ import sessions.RangFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.TypeactiviteFacadeLocal;
/*     */ import utilitaire.Utilitaires;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class ActiviteController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private ProgrammeFacadeLocal programmeFacadeLocal;
/*  42 */   private Programme programme = new Programme();
/*  43 */   private List<Programme> programmes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ActiviteFacadeLocal activiteFacadeLocal;
/*  47 */   private Activite activite = new Activite();
/*  48 */   private List<Activite> activites = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ActionFacadeLocal actionFacadeLocal;
/*  52 */   private Action action = new Action();
/*  53 */   private List<Action> actions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  57 */   private Structure structure = new Structure();
/*  58 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private TypeactiviteFacadeLocal typeactiviteFacadeLocal;
/*  62 */   private Typeactivite typeactivite = new Typeactivite();
/*  63 */   private List<Typeactivite> typeactivites = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RangFacadeLocal rangFacadeLocal;
/*  67 */   private Rang rang = new Rang();
/*  68 */   private List<Rang> listRang = new ArrayList<>();
/*     */   
/*     */   private boolean detail = true;
/*     */   
/*  72 */   private String mode = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void init() {
/*  80 */     this.activite.setIdrang(new Rang());
/*  81 */     this.activite.setIdtypeactivite(new Typeactivite());
/*     */   }
/*     */   
/*     */   public void activeButton() {
/*  85 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/*  89 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*  93 */     if (!Utilitaires.isAccess(Long.valueOf(15L))) {
/*  94 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de saisir les activités");
/*     */       
/*     */       return;
/*     */     } 
/*  98 */     this.mode = "Create";
/*     */     
/* 100 */     this.activite = new Activite();
/* 101 */     this.activite.setCode("--");
/* 102 */     this.typeactivite = new Typeactivite(Long.valueOf(1L));
/* 103 */     this.rang = new Rang(Long.valueOf(1L));
/* 104 */     this.activite.setIdtypeactivite(this.typeactivite);
/* 105 */     this.activite.setIdrang(this.rang);
/*     */     
/* 107 */     this.activite.setResponsables("--");
/* 108 */     this.activite.setJustification("--");
/* 109 */     this.activite.setEtat("Actif");
/*     */     
/* 111 */     this.action = new Action();
/* 112 */     this.actions.clear();
/*     */     
/* 114 */     this.programme = new Programme();
/*     */     
/* 116 */     RequestContext.getCurrentInstance().execute("PF('ActiviteCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*     */     try {
/* 121 */       if (!Utilitaires.isAccess(Long.valueOf(15L))) {
/* 122 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les activités");
/*     */         
/*     */         return;
/*     */       } 
/* 126 */       if (this.activite != null) {
/*     */         
/* 128 */         this.mode = "Edit";
/*     */         
/* 130 */         this.action = this.activite.getIdaction();
/* 131 */         this.structure = this.activite.getIdstructure();
/* 132 */         this.typeactivite = this.activite.getIdtypeactivite();
/* 133 */         this.rang = this.activite.getIdrang();
/*     */         
/* 135 */         this.programme = this.programmeFacadeLocal.find(this.action.getIdprogramme().getIdprogramme());
/*     */         
/* 137 */         filterAction();
/* 138 */         RequestContext.getCurrentInstance().execute("PF('ActiviteCreateDialog').show()");
/*     */       } 
/* 140 */     } catch (Exception e) {
/* 141 */       e.printStackTrace();
/* 142 */       JsfUtil.addErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public String formatter(Double valeur) {
/* 147 */     return Utilitaires.formaterStringMoney(valeur);
/*     */   }
/*     */   
/*     */   public String formatter(Long valeur) {
/* 151 */     return Utilitaires.formaterStringMoney(valeur);
/*     */   }
/*     */   
/*     */   public void filterAction() {
/*     */     try {
/* 156 */       if (this.programme.getIdprogramme() != null) {
/* 157 */         this.actions = this.actionFacadeLocal.findByProgramme(this.programme.getIdprogramme());
/*     */       } else {
/* 159 */         System.err.println("programme nulle");
/*     */       } 
/* 161 */     } catch (Exception e) {
/* 162 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void filterActivite() {
/*     */     try {
/* 168 */       if (this.action.getIdaction() != null) {
/* 169 */         this.action.getIdprogramme();
/* 170 */         this.action = this.actionFacadeLocal.find(this.action.getIdaction());
/* 171 */         this.activites = this.activiteFacadeLocal.findByAction(this.action.getIdaction());
/*     */       } 
/* 173 */     } catch (Exception e) {
/* 174 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void findActivite() {
/*     */     try {
/* 180 */       this.activites.clear();
/* 181 */       if (this.structure.getIdstructure().longValue() == -1L) {
/* 182 */         JsfUtil.addErrorMessage("Aucune structure sélectionnée");
/*     */         
/*     */         return;
/*     */       } 
/* 186 */       if (this.structure.getIdstructure() == null) {
/* 187 */         JsfUtil.addErrorMessage("Aucune structure sélectionnée");
/*     */         
/*     */         return;
/*     */       } 
/* 191 */       this.activites = this.activiteFacadeLocal.findByIdStructure(this.structure.getIdstructure());
/* 192 */     } catch (Exception e) {
/* 193 */       e.printStackTrace();
/* 194 */       JsfUtil.addErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save() {
/*     */     try {
/* 201 */       if (this.typeactivite.getIdtypeactivite().longValue() == -1L) {
/* 202 */         this.activite.setIdtypeactivite(new Typeactivite(Long.valueOf(1L)));
/*     */       }
/*     */       
/* 205 */       if (this.rang.getIdrang().longValue() == -1L) {
/* 206 */         this.activite.setIdrang(new Rang(Long.valueOf(1L)));
/*     */       }
/*     */       
/* 209 */       if ("Create".equals(this.mode)) {
/* 210 */         this.activite.setIdactivite(this.activiteFacadeLocal.nextId());
/* 211 */         this.activite.setIdrang(this.rang);
/* 212 */         this.activite.setIdtypeactivite(this.typeactivite);
/* 213 */         this.activite.setIdstructure(this.structure);
/* 214 */         this.activite.setIdaction(this.action);
/* 215 */         this.activite.setEtat("Actif");
/* 216 */         this.activiteFacadeLocal.create(this.activite);
/* 217 */         RequestContext.getCurrentInstance().execute("PF('ActiviteCreateDialog').hide()");
/* 218 */         JsfUtil.addSuccessMessage("Opération réussie");
/* 219 */         this.detail = true;
/* 220 */         this.activite = new Activite();
/*     */       } else {
/* 222 */         this.activite.setIdstructure(this.structure);
/* 223 */         this.activite.setIdaction(this.action);
/* 224 */         this.activite.setIdrang(this.rang);
/* 225 */         this.activite.setIdtypeactivite(this.typeactivite);
/* 226 */         this.activiteFacadeLocal.edit(this.activite);
/* 227 */         RequestContext.getCurrentInstance().execute("PF('TacheCreateDialog').hide()");
/* 228 */         JsfUtil.addSuccessMessage("Opération réussie");
/* 229 */         this.activite = new Activite();
/* 230 */         this.detail = true;
/*     */       } 
/* 232 */     } catch (Exception e) {
/* 233 */       e.printStackTrace();
/* 234 */       JsfUtil.addErrorMessage("Exception , veuillez verifier le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 240 */       if (this.activite != null) {
/*     */         
/* 242 */         if (!Utilitaires.isAccess(Long.valueOf(15L))) {
/* 243 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer une tache");
/*     */           
/*     */           return;
/*     */         } 
/* 247 */         this.activiteFacadeLocal.remove(this.activite);
/* 248 */         this.detail = true;
/* 249 */         this.activite = new Activite();
/* 250 */         JsfUtil.addSuccessMessage("Opération réussie");
/* 251 */         findActivite();
/*     */         return;
/*     */       } 
/* 254 */       JsfUtil.addWarningMessage("Aucune ligne selectionnée");
/*     */     }
/* 256 */     catch (Exception e) {
/* 257 */       e.printStackTrace();
/* 258 */       JsfUtil.addErrorMessage("Impossible de supprimer");
/*     */     } 
/*     */   }
/*     */   
/*     */   public Programme getProgramme() {
/* 263 */     return this.programme;
/*     */   }
/*     */   
/*     */   public void setProgramme(Programme programme) {
/* 267 */     this.programme = programme;
/*     */   }
/*     */   
/*     */   public List<Programme> getProgrammes() {
/* 271 */     this.programmes = this.programmeFacadeLocal.findByIdinstitutionEtat(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 272 */     return this.programmes;
/*     */   }
/*     */   
/*     */   public Activite getActivite() {
/* 276 */     return this.activite;
/*     */   }
/*     */   
/*     */   public void setActivite(Activite activite) {
/* 280 */     this.activite = activite;
/*     */   }
/*     */   
/*     */   public List<Activite> getActivites() {
/* 284 */     return this.activites;
/*     */   }
/*     */   
/*     */   public Action getAction() {
/* 288 */     return this.action;
/*     */   }
/*     */   
/*     */   public void setAction(Action action) {
/* 292 */     this.action = action;
/*     */   }
/*     */   
/*     */   public List<Action> getActions() {
/* 296 */     return this.actions;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 300 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 304 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 308 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 309 */     return this.structures;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 313 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 317 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public List<Typeactivite> getTypeactivites() {
/* 321 */     this.typeactivites = this.typeactiviteFacadeLocal.findAll();
/* 322 */     return this.typeactivites;
/*     */   }
/*     */   
/*     */   public List<Rang> getListRang() {
/* 326 */     this.listRang = this.rangFacadeLocal.findAll();
/* 327 */     return this.listRang;
/*     */   }
/*     */   
/*     */   public Typeactivite getTypeactivite() {
/* 331 */     return this.typeactivite;
/*     */   }
/*     */   
/*     */   public void setTypeactivite(Typeactivite typeactivite) {
/* 335 */     this.typeactivite = typeactivite;
/*     */   }
/*     */   
/*     */   public Rang getRang() {
/* 339 */     return this.rang;
/*     */   }
/*     */   
/*     */   public void setRang(Rang rang) {
/* 343 */     this.rang = rang;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 347 */     return this.mode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ActiviteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */