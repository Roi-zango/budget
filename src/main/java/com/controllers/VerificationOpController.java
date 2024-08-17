/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Moyens;
/*     */ import entities.OrdrePayement;
/*     */ import entities.Tache;
/*     */ import entities.VerificationOp;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.transaction.Transactional;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.OrdrePayementFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import sessions.VerificationOpFacadeLocal;
/*     */ import utilitaire.Printer;
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
/*     */ 
/*     */ @ManagedBean
/*     */ @ViewScoped
/*     */ public class VerificationOpController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private VerificationOpFacadeLocal verificationOpFacadeLocal;
/*  50 */   private VerificationOp verificationOp = new VerificationOp();
/*  51 */   private List<VerificationOp> verificationOps = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private OrdrePayementFacadeLocal ordrePayementFacadeLocal;
/*  55 */   private OrdrePayement ordrePayement = new OrdrePayement();
/*  56 */   private List<OrdrePayement> ordrePayements = new ArrayList<>();
/*     */   
/*     */   private long idOp;
/*     */   
/*     */   private int modeOp;
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private MoyensFacadeLocal moyensFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private TacheFacadeLocal tacheFacadeLocal;
/*  70 */   private String mode = "";
/*     */   private boolean detail = true;
/*  72 */   private String typeFiltre = "BC";
/*     */ 
/*     */   
/*     */   private boolean valide = true;
/*     */ 
/*     */   
/*     */   private boolean rejet = false;
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void initBon() {
/*  83 */     this.ordrePayement = new OrdrePayement();
/*  84 */     this.verificationOp = new VerificationOp();
/*  85 */     this.verificationOp.setDateVerification(new Date());
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*  89 */     if (!Utilitaires.isAccess(Long.valueOf(38L))) {
/*  90 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit d'etablir un ordre de payement");
/*     */       
/*     */       return;
/*     */     } 
/*  94 */     this.modeOp = 1;
/*  95 */     this.mode = "Create";
/*  96 */     this.typeFiltre = "Tout";
/*  97 */     this.valide = true;
/*  98 */     this.rejet = false;
/*  99 */     initBon();
/*     */     
/* 101 */     this.ordrePayements = this.ordrePayementFacadeLocal.findAllEtat(SessionMBean.getInstitution().getIdinstitution().longValue(), SessionMBean.getBudget().getIdbudget().intValue(), false);
/* 102 */     RequestContext.getCurrentInstance().execute("PF('ValidationOPCreateDialog').show()");
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateDataType() {
/* 107 */     if (this.typeFiltre.equals("Tout"));
/*     */ 
/*     */ 
/*     */     
/* 111 */     if (this.typeFiltre.equals("BC"));
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (this.typeFiltre.equals("LC"));
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (this.typeFiltre.equals("DEC"));
/*     */ 
/*     */ 
/*     */     
/* 123 */     if (this.typeFiltre.equals("SAL"));
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (this.typeFiltre.equals("MIS"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateRenderPanel(String chaine) {
/* 133 */     if (chaine.equals("valide")) {
/* 134 */       if (this.valide) {
/* 135 */         this.rejet = false;
/*     */       } else {
/* 137 */         this.rejet = true;
/*     */       }
/*     */     
/* 140 */     } else if (this.rejet) {
/* 141 */       this.valide = false;
/*     */     } else {
/* 143 */       this.valide = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 151 */       if (this.ordrePayement != null) {
/*     */         
/* 153 */         if (!Utilitaires.isAccess(Long.valueOf(33L))) {
/* 154 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler un engagement de salaire");
/*     */           
/*     */           return;
/*     */         } 
/* 158 */         if (this.ordrePayement.getBoncommande().isPaye()) {
/* 159 */           JsfUtil.addErrorMessage("Ce bon de commandé est dejà payé");
/*     */           
/*     */           return;
/*     */         } 
/* 163 */         this.ordrePayementFacadeLocal.remove(this.ordrePayement);
/*     */         
/* 165 */         Boncommande bc = this.ordrePayement.getBoncommande();
/* 166 */         Moyens m = bc.getMoyens();
/* 167 */         Tache t = bc.getMoyens().getIdtache();
/*     */         
/* 169 */         if (this.ordrePayement.isNap()) {
/* 170 */           bc.setNapOrdonne(bc.getNapOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 171 */           m.setNapOrdonne(m.getNapOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 172 */           t.setNapOrdonne(t.getNapOrdonne() - this.ordrePayement.getMontant().doubleValue());
/*     */         } else {
/* 174 */           bc.setTaxeOrdonne(bc.getTaxeOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 175 */           m.setTaxeOrdonne(m.getTaxeOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 176 */           t.setTaxeOrdonne(t.getTaxeOrdonne() - this.ordrePayement.getMontant().doubleValue());
/*     */         } 
/*     */         
/* 179 */         this.boncommandeFacadeLocal.edit(bc);
/* 180 */         this.moyensFacadeLocal.edit(m);
/* 181 */         this.tacheFacadeLocal.edit(t);
/*     */         
/* 183 */         this.detail = true;
/* 184 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 186 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 188 */     } catch (Exception e) {
/* 189 */       e.printStackTrace();
/* 190 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 196 */       if (this.idOp != 0L) {
/* 197 */         this.ordrePayement = this.ordrePayementFacadeLocal.find(Long.valueOf(this.idOp));
/* 198 */         if (this.ordrePayement.isNap()) {
/* 199 */           this.modeOp = 1;
/*     */         }
/*     */         
/* 202 */         if (this.ordrePayement.isTaxe()) {
/* 203 */           this.modeOp = 2;
/*     */         }
/*     */       }
/*     */     
/* 207 */     } catch (Exception e) {
/* 208 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printCe() {
/*     */     try {
/* 214 */       if (!Utilitaires.isAccess(Long.valueOf(39L))) {
/* 215 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engament");
/*     */         
/*     */         return;
/*     */       } 
/* 219 */       Map<Object, Object> parameter = new HashMap<>();
/* 220 */       parameter.put("idOp", this.ordrePayement.getIdOrdrePayement());
/* 221 */       parameter.put("logo", SessionMBean.getLogo());
/* 222 */       Printer p = new Printer();
/*     */       
/* 224 */       if (this.ordrePayement.isNap()) {
/* 225 */         p.print("/rapport/report_camer_soft/op_nap.jasper", parameter);
/*     */       } else {
/* 227 */         p.print("/rapport/report_camer_soft/op_taxes.jasper", parameter);
/*     */       } 
/* 229 */     } catch (Exception e) {
/* 230 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveRejet() {
/* 235 */     this.verificationOp.setIdverificationOp(Long.valueOf(this.verificationOpFacadeLocal.nextId()));
/* 236 */     this.verificationOp.setOdrePayement(this.ordrePayement);
/* 237 */     this.verificationOp.setValide(false);
/* 238 */     this.verificationOpFacadeLocal.create(this.verificationOp);
/*     */     
/* 240 */     RequestContext.getCurrentInstance().execute("PF('ValidationOPCreateDialog').hide()");
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void saveValidation() {
/* 245 */     this.verificationOp.setIdverificationOp(Long.valueOf(this.verificationOpFacadeLocal.nextId()));
/* 246 */     this.verificationOp.setOdrePayement(this.ordrePayement);
/* 247 */     this.verificationOp.setValide(true);
/* 248 */     this.verificationOpFacadeLocal.create(this.verificationOp);
/*     */     
/* 250 */     Moyens moyens = this.ordrePayement.getBoncommande().getMoyens();
/* 251 */     Boncommande bc = this.ordrePayement.getBoncommande();
/*     */     
/* 253 */     moyens.setMontantOrdonne(moyens.getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 254 */     moyens.getIdtache().setMontantOrdonne(moyens.getIdtache().getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */     
/* 256 */     if (this.ordrePayement.isNap()) {
/* 257 */       bc.setMontantOrdonne(bc.getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 258 */       bc.setNapOrdonne(bc.getNapOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 259 */       moyens.setNapOrdonne(moyens.getNapOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 260 */       moyens.getIdtache().setNapOrdonne(moyens.getIdtache().getNapOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 261 */     } else if (this.ordrePayement.isTaxe()) {
/* 262 */       bc.setMontantOrdonne(bc.getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 263 */       bc.setTaxeOrdonne(bc.getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 264 */       moyens.setTaxeOrdonne(moyens.getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 265 */       moyens.getIdtache().setTaxeOrdonne(moyens.getIdtache().getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */     } 
/*     */     
/* 268 */     this.ordrePayement.setEtat(true);
/* 269 */     this.ordrePayement.setNombre_verification(this.ordrePayement.getNombre_verification() + 1);
/* 270 */     this.ordrePayementFacadeLocal.edit(this.ordrePayement);
/*     */     
/* 272 */     this.moyensFacadeLocal.edit(moyens);
/* 273 */     this.tacheFacadeLocal.edit(moyens.getIdtache());
/* 274 */     this.boncommandeFacadeLocal.edit(bc);
/*     */     
/* 276 */     RequestContext.getCurrentInstance().execute("PF('ValidationOPCreateDialog').hide()");
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 280 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 284 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 288 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 292 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 296 */     return this.mode;
/*     */   }
/*     */   
/*     */   public List<OrdrePayement> getOrdrePayements() {
/* 300 */     this.ordrePayements = this.ordrePayementFacadeLocal.findAllEtat(SessionMBean.getInstitution().getIdinstitution().longValue(), SessionMBean.getBudget().getIdbudget().intValue(), false);
/* 301 */     return this.ordrePayements;
/*     */   }
/*     */   
/*     */   public int getModeOp() {
/* 305 */     return this.modeOp;
/*     */   }
/*     */   
/*     */   public void setModeOp(int modeOp) {
/* 309 */     this.modeOp = modeOp;
/*     */   }
/*     */   
/*     */   public OrdrePayement getOrdrePayement() {
/* 313 */     return this.ordrePayement;
/*     */   }
/*     */   
/*     */   public void setOrdrePayement(OrdrePayement ordrePayement) {
/* 317 */     this.ordrePayement = ordrePayement;
/*     */   }
/*     */   
/*     */   public String getTypeFiltre() {
/* 321 */     return this.typeFiltre;
/*     */   }
/*     */   
/*     */   public void setTypeFiltre(String typeFiltre) {
/* 325 */     this.typeFiltre = typeFiltre;
/*     */   }
/*     */   
/*     */   public VerificationOp getVerificationOp() {
/* 329 */     return this.verificationOp;
/*     */   }
/*     */   
/*     */   public void setVerificationOp(VerificationOp verificationOp) {
/* 333 */     this.verificationOp = verificationOp;
/*     */   }
/*     */   
/*     */   public List<VerificationOp> getVerificationOps() {
/* 337 */     this.verificationOps = this.verificationOpFacadeLocal.findByIdBudget(SessionMBean.getInstitution().getIdinstitution().longValue(), SessionMBean.getBudget().getIdbudget().intValue());
/* 338 */     return this.verificationOps;
/*     */   }
/*     */   
/*     */   public long getIdOp() {
/* 342 */     return this.idOp;
/*     */   }
/*     */   
/*     */   public void setIdOp(long idOp) {
/* 346 */     this.idOp = idOp;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/* 350 */     return this.valide;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/* 354 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public boolean isRejet() {
/* 358 */     return this.rejet;
/*     */   }
/*     */   
/*     */   public void setRejet(boolean rejet) {
/* 362 */     this.rejet = rejet;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\VerificationOpController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */