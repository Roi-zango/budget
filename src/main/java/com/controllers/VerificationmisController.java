/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Budget;
/*     */ import entities.Imputation;
/*     */ import entities.Moyens;
/*     */ import entities.Signataire;
/*     */ import entities.Societe;
/*     */ import entities.Structure;
/*     */ import entities.Tache;
/*     */ import entities.Verificationbc;
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
/*     */ import javax.transaction.Transactional;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.LigneverificationbcFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.SignataireFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import sessions.VerificationbcFacadeLocal;
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
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class VerificationmisController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private VerificationbcFacadeLocal verificationbcFacadeLocal;
/*  58 */   private Verificationbc verificationbc = new Verificationbc();
/*  59 */   private List<Verificationbc> verificationbcs = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  63 */   private Boncommande boncommande = new Boncommande();
/*  64 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  68 */   private Signataire signataire = new Signataire();
/*  69 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  73 */   private Structure structure = new Structure();
/*  74 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  78 */   private Imputation imputation = new Imputation();
/*  79 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  83 */   private Budget budget = new Budget();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*  87 */   protected Tache tache = new Tache();
/*  88 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*  92 */   protected Moyens moyens = new Moyens();
/*  93 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneverificationbcFacadeLocal ligneverificationbcFacadeLocal;
/*     */   
/*  98 */   private Societe societe = new Societe();
/*     */   
/* 100 */   private String mode = "";
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */   
/*     */   private boolean imprimer = true;
/*     */   
/*     */   private boolean valide = true;
/*     */   
/*     */   private boolean rejet = false;
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/* 113 */     if (SessionMBean.getBudget() != null) {
/*     */       
/* 115 */       if (!Utilitaires.isAccess(Long.valueOf(34L))) {
/* 116 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de valider un bon de commande");
/*     */         
/*     */         return;
/*     */       } 
/* 120 */       this.mode = "Create";
/* 121 */       this.signataire = new Signataire();
/* 122 */       this.structure = new Structure();
/* 123 */       this.imputation = new Imputation();
/* 124 */       this.boncommande = new Boncommande();
/* 125 */       this.taches.clear();
/* 126 */       this.tache = new Tache();
/* 127 */       this.moyens = new Moyens();
/* 128 */       this.moyenses.clear();
/* 129 */       this.budget = SessionMBean.getBudget();
/* 130 */       this.tache = new Tache();
/* 131 */       this.moyens = new Moyens();
/*     */       
/* 133 */       this.verificationbc = new Verificationbc();
/* 134 */       this.verificationbc.setDateverification(new Date());
/*     */       
/* 136 */       this.valide = true;
/* 137 */       this.rejet = false;
/* 138 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } else {
/* 140 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 145 */     if (this.verificationbc != null) {
/* 146 */       this.mode = "Edit";
/* 147 */       this.boncommande = this.verificationbc.getBoncommande();
/* 148 */       this.structure = this.boncommande.getStructure();
/* 149 */       this.imputation = this.boncommande.getImputation();
/* 150 */       this.signataire = this.boncommande.getSignataire();
/* 151 */       this.budget = this.boncommande.getBudget();
/* 152 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareRejet() {
/* 157 */     RequestContext.getCurrentInstance().execute("PF('RejetCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 162 */       if (this.boncommande != null) {
/* 163 */         this.signataire = this.boncommande.getSignataire();
/* 164 */         this.imputation = this.boncommande.getImputation();
/* 165 */         this.structure = this.boncommande.getStructure();
/* 166 */         this.tache = this.boncommande.getMoyens().getIdtache();
/* 167 */         this.moyens = this.boncommande.getMoyens();
/*     */       } 
/* 169 */     } catch (Exception e) {
/* 170 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 176 */       this.moyenses.clear();
/* 177 */       if (this.tache != null) {
/* 178 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/*     */       }
/* 180 */     } catch (Exception e) {
/* 181 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRenderPanel(String chaine) {
/* 186 */     if (chaine.equals("valide")) {
/* 187 */       if (this.valide) {
/* 188 */         this.rejet = false;
/*     */       } else {
/* 190 */         this.rejet = true;
/*     */       }
/*     */     
/* 193 */     } else if (this.rejet) {
/* 194 */       this.valide = false;
/*     */     } else {
/* 196 */       this.valide = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveRejet() {
/*     */     try {
/* 203 */       this.ut.begin();
/* 204 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 205 */       this.verificationbc.setValide(false);
/* 206 */       this.verificationbc.setBoncommande(this.boncommande);
/* 207 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/*     */       
/* 209 */       this.boncommande.setVerif(true);
/* 210 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 211 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 213 */       this.ut.commit();
/* 214 */       this.verificationbc = new Verificationbc();
/* 215 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/*     */       
/* 217 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 218 */     } catch (Exception e) {
/* 219 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public void saveValidation() {
/*     */     try {
/* 227 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 228 */       this.verificationbc.setValide(true);
/* 229 */       this.verificationbc.setBoncommande(this.boncommande);
/* 230 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/*     */       
/* 232 */       this.boncommande.setVerif(true);
/* 233 */       this.boncommande.setValide(true);
/* 234 */       this.boncommande.setLiquide(true);
/* 235 */       this.boncommande.setAttentepayement(true);
/* 236 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 237 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 239 */       Moyens m = this.boncommande.getMoyens();
/* 240 */       m.setMontantLiquide(m.getMontantLiquide() + this.boncommande.getTtc().doubleValue());
/* 241 */       this.moyensFacadeLocal.edit(m);
/*     */       
/* 243 */       Tache t = this.boncommande.getMoyens().getIdtache();
/* 244 */       t.setMontantliquide(t.getMontantliquide() + this.boncommande.getTtc().doubleValue());
/* 245 */       this.tacheFacadeLocal.edit(t);
/*     */       
/* 247 */       this.verificationbc = new Verificationbc();
/* 248 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/* 249 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 250 */     } catch (Exception e) {
/* 251 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 258 */       if (this.verificationbc != null) {
/*     */         
/* 260 */         this.verificationbcFacadeLocal.remove(this.verificationbc);
/*     */         
/* 262 */         if (this.verificationbc.isValide()) {
/* 263 */           this.verificationbc.getBoncommande().setValide(false);
/* 264 */           this.verificationbc.getBoncommande().setAttentepayement(false);
/* 265 */           this.boncommandeFacadeLocal.edit(this.verificationbc.getBoncommande());
/*     */         } 
/*     */         
/* 268 */         this.verificationbc = new Verificationbc();
/* 269 */         this.detail = true;
/* 270 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 272 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 274 */     } catch (Exception e) {
/* 275 */       e.printStackTrace();
/* 276 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void print() {
/*     */     try {
/* 283 */       if (!Utilitaires.isAccess(Long.valueOf(23L))) {
/* 284 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat de rejet");
/*     */         
/*     */         return;
/*     */       } 
/* 288 */       Map<Object, Object> parameter = new HashMap<>();
/* 289 */       parameter.put("idverificationbc", this.verificationbc.getIdverificationbc());
/* 290 */       parameter.put("logo", SessionMBean.getLogo());
/* 291 */       Printer p = new Printer();
/* 292 */       p.print("/rapport/report_camer_soft/certificat_rejet.jasper", parameter);
/* 293 */     } catch (Exception e) {
/* 294 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/*     */     try {
/* 300 */       this.detail = false;
/* 301 */       this.imprimer = true;
/* 302 */       if (this.verificationbc != null) {
/* 303 */         if (this.verificationbc.isValide()) {
/* 304 */           this.imprimer = true;
/*     */         } else {
/* 306 */           this.imprimer = false;
/*     */         } 
/*     */       }
/* 309 */     } catch (Exception e) {
/* 310 */       this.imprimer = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 315 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 319 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 323 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 327 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 331 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 335 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 336 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 340 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 344 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 348 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 352 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 353 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 357 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 361 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 365 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 369 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeMisNotValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 370 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 374 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 378 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 382 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 386 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 387 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 391 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 395 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 399 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 403 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 407 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 411 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 415 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 419 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 423 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 427 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 431 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 435 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 439 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public Verificationbc getVerificationbc() {
/* 443 */     return this.verificationbc;
/*     */   }
/*     */   
/*     */   public void setVerificationbc(Verificationbc verificationbc) {
/* 447 */     this.verificationbc = verificationbc;
/*     */   }
/*     */   
/*     */   public List<Verificationbc> getVerificationbcs() {
/* 451 */     this.verificationbcs = this.verificationbcFacadeLocal.findByIdAnneeSal(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 452 */     return this.verificationbcs;
/*     */   }
/*     */   
/*     */   public void setVerificationbcs(List<Verificationbc> verificationbcs) {
/* 456 */     this.verificationbcs = verificationbcs;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 460 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/* 464 */     return this.valide;
/*     */   }
/*     */   
/*     */   public boolean isRejet() {
/* 468 */     return this.rejet;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/* 472 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public void setRejet(boolean rejet) {
/* 476 */     this.rejet = rejet;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\VerificationmisController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */