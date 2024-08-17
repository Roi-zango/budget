/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Budget;
/*     */ import entities.Certificatengagement;
/*     */ import entities.Imputation;
/*     */ import entities.Moyens;
/*     */ import entities.Signataire;
/*     */ import entities.Societe;
/*     */ import entities.Structure;
/*     */ import entities.Tache;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
/*     */ import sessions.CertificatengagementFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.SignataireFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import utilitaire.Printer;
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
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class EngagementController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private CertificatengagementFacadeLocal certificatengagementFacadeLocal;
/*  55 */   private Certificatengagement certificatengagement = new Certificatengagement();
/*  56 */   private List<Certificatengagement> certificatengagements = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  60 */   private Boncommande boncommande = new Boncommande();
/*  61 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  65 */   private Signataire signataire = new Signataire();
/*  66 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  70 */   private Structure structure = new Structure();
/*  71 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  75 */   private Imputation imputation = new Imputation();
/*  76 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  80 */   private Budget budget = new Budget();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*  84 */   protected Tache tache = new Tache();
/*  85 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*  89 */   protected Moyens moyens = new Moyens();
/*  90 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*  92 */   private Societe societe = new Societe();
/*     */   
/*  94 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/* 103 */     if (SessionMBean.getBudget() != null) {
/* 104 */       this.mode = "Create";
/* 105 */       this.signataire = new Signataire();
/*     */       
/* 107 */       this.structure = new Structure();
/* 108 */       this.imputation = new Imputation();
/* 109 */       this.boncommande = new Boncommande();
/* 110 */       this.certificatengagement = new Certificatengagement();
/* 111 */       this.certificatengagement.setDateengagement(new Date());
/* 112 */       this.taches.clear();
/* 113 */       this.tache = new Tache();
/* 114 */       this.moyens = new Moyens();
/* 115 */       this.moyenses.clear();
/* 116 */       this.budget = SessionMBean.getBudget();
/* 117 */       RequestContext.getCurrentInstance().execute("PF('EngagementCreateDialog').show()");
/*     */     } else {
/* 119 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 124 */     if (this.certificatengagement != null) {
/* 125 */       this.mode = "Edit";
/* 126 */       this.boncommande = this.certificatengagement.getBoncommande();
/* 127 */       this.structure = this.boncommande.getStructure();
/* 128 */       this.imputation = this.boncommande.getImputation();
/* 129 */       this.signataire = this.boncommande.getSignataire();
/* 130 */       this.budget = this.boncommande.getBudget();
/* 131 */       RequestContext.getCurrentInstance().execute("PF('EngagementCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 137 */       if (this.boncommande != null) {
/* 138 */         this.signataire = this.boncommande.getSignataire();
/* 139 */         this.imputation = this.boncommande.getImputation();
/* 140 */         this.structure = this.boncommande.getStructure();
/* 141 */         this.societe = this.boncommande.getSociete();
/* 142 */         this.taches.clear();
/* 143 */         List<Moyens> moyenses = this.moyensFacadeLocal.findByStructureAnneeIdimputation(this.boncommande.getStructure().getIdstructure(), SessionMBean.getAnnee().getIdannee(), this.boncommande.getImputation().getIdimputation());
/* 144 */         if (!moyenses.isEmpty()) {
/* 145 */           for (Moyens m : moyenses) {
/* 146 */             if (!this.taches.contains(m.getIdtache())) {
/* 147 */               this.taches.add(m.getIdtache());
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/* 152 */     } catch (Exception e) {
/* 153 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 159 */       this.moyenses.clear();
/* 160 */       if (this.tache != null) {
/* 161 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/*     */       }
/* 163 */     } catch (Exception e) {
/* 164 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/* 170 */       if ("Create".equals(this.mode)) {
/*     */         
/* 172 */         if (this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue() > this.moyens.getCt().doubleValue()) {
/* 173 */           JsfUtil.addWarningMessage("Montant insuffisant pour engagager ce bon de commande");
/*     */           
/*     */           return;
/*     */         } 
/* 177 */         this.ut.begin();
/*     */         
/* 179 */         this.certificatengagement.setIdcertificatengagement(Long.valueOf(this.certificatengagementFacadeLocal.nextId()));
/* 180 */         this.certificatengagement.setBoncommande(this.boncommande);
/* 181 */         this.certificatengagement.setMoyens(this.moyens);
/* 182 */         this.certificatengagementFacadeLocal.create(this.certificatengagement);
/*     */         
/* 184 */         this.boncommande.setEngage(true);
/* 185 */         this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */         
/* 187 */         this.moyens.setMontantexecute(Double.valueOf(this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 188 */         this.moyensFacadeLocal.edit(this.moyens);
/*     */         
/* 190 */         this.ut.commit();
/*     */         
/* 192 */         this.certificatengagement = new Certificatengagement();
/* 193 */         this.signataire = new Signataire();
/* 194 */         this.structure = new Structure();
/* 195 */         this.detail = true;
/* 196 */         RequestContext.getCurrentInstance().execute("PF('EngagementCreateDialog').hide()");
/* 197 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       }
/* 199 */       else if ("Edit".equals(this.mode)) {
/* 200 */         if (this.boncommande != null) {
/*     */           
/* 202 */           this.detail = true;
/* 203 */           RequestContext.getCurrentInstance().execute("PF('EngagementCreateDialog').hide()");
/* 204 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 206 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 209 */     } catch (Exception e) {
/* 210 */       e.printStackTrace();
/* 211 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 217 */       if (this.certificatengagement != null) {
/* 218 */         this.ut.begin();
/* 219 */         this.certificatengagementFacadeLocal.remove(this.certificatengagement);
/* 220 */         this.certificatengagement.getBoncommande().setEngage(false);
/* 221 */         this.boncommandeFacadeLocal.edit(this.certificatengagement.getBoncommande());
/*     */         
/* 223 */         this.certificatengagement.getMoyens().setMontantexecute(Double.valueOf(this.certificatengagement.getMoyens().getMontantexecute().doubleValue() - this.certificatengagement.getBoncommande().getTtc().doubleValue()));
/* 224 */         this.moyensFacadeLocal.edit(this.certificatengagement.getMoyens());
/* 225 */         this.ut.commit();
/* 226 */         this.certificatengagement = new Certificatengagement();
/* 227 */         this.detail = true;
/* 228 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 230 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 232 */     } catch (Exception e) {
/* 233 */       e.printStackTrace();
/* 234 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void print() {
/*     */     try {
/* 241 */       Map<Object, Object> parameter = new HashMap<>();
/* 242 */       parameter.put("idcertificatengagement", this.certificatengagement.getIdcertificatengagement());
/* 243 */       Printer p = new Printer();
/* 244 */       p.print("/rapport/report_camer_soft/certificat_engagement.jasper", parameter);
/* 245 */     } catch (Exception e) {
/* 246 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 251 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 255 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 259 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 263 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 267 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 271 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 275 */     this.signataires = this.signataireFacadeLocal.findAllRangeEtatInstitutionIsActif();
/* 276 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 280 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 284 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 288 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 292 */     this.structures = this.structureFacadeLocal.findAllRangeEtatInstitutionIsActif();
/* 293 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 297 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 301 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 305 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 309 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeEngageIsFalse(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 310 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 314 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 318 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 322 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 326 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 327 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 331 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 335 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 339 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 343 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 347 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 351 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 355 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 359 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 363 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 367 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 371 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Certificatengagement getCertificatengagement() {
/* 375 */     return this.certificatengagement;
/*     */   }
/*     */   
/*     */   public void setCertificatengagement(Certificatengagement certificatengagement) {
/* 379 */     this.certificatengagement = certificatengagement;
/*     */   }
/*     */   
/*     */   public List<Certificatengagement> getCertificatengagements() {
/* 383 */     this.certificatengagements = this.certificatengagementFacadeLocal.findByIdAnnee(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 384 */     return this.certificatengagements;
/*     */   }
/*     */   
/*     */   public void setCertificatengagements(List<Certificatengagement> certificatengagements) {
/* 388 */     this.certificatengagements = certificatengagements;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 392 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 396 */     this.societe = societe;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\EngagementController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */