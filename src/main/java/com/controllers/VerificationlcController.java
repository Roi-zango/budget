/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Budget;
/*     */ import entities.Imputation;
/*     */ import entities.Ligneboncommande;
/*     */ import entities.Lignedecision;
/*     */ import entities.Ligneverificationbc;
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
/*     */ import sessions.LigneboncommandeFacadeLocal;
/*     */ import sessions.LignedecisionFacadeLocal;
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
/*     */ public class VerificationlcController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private VerificationbcFacadeLocal verificationbcFacadeLocal;
/*  63 */   private Verificationbc verificationbc = new Verificationbc();
/*  64 */   private List<Verificationbc> verificationbcs = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  68 */   private Boncommande boncommande = new Boncommande();
/*  69 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  73 */   private Signataire signataire = new Signataire();
/*  74 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  78 */   private Structure structure = new Structure();
/*  79 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  83 */   private Imputation imputation = new Imputation();
/*  84 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  88 */   private Budget budget = new Budget();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*  92 */   protected Tache tache = new Tache();
/*  93 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*  97 */   protected Moyens moyens = new Moyens();
/*  98 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneboncommandeFacadeLocal ligneboncommandeFacadeLocal;
/* 102 */   private List<Ligneboncommande> ligneboncommandes = new ArrayList<>();
/* 103 */   private List<Ligneboncommande> ligneboncommandePb = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LignedecisionFacadeLocal lignedecisionFacadeLocal;
/* 107 */   private List<Lignedecision> lignedecisions = new ArrayList<>();
/* 108 */   private List<Lignedecision> lignedecisionPb = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneverificationbcFacadeLocal ligneverificationbcFacadeLocal;
/*     */   
/* 113 */   private Societe societe = new Societe();
/*     */   
/* 115 */   private String mode = "";
/*     */   
/*     */   private boolean detail = true;
/*     */   
/*     */   private boolean imprimer = true;
/*     */   
/*     */   private boolean valide = true;
/*     */   private boolean rejet = false;
/* 123 */   private Date date_de_debut = new Date();
/* 124 */   private Date date_de_fin = new Date();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void affiche(boolean item1) {
/* 131 */     System.err.println("affiche : " + item1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void recherche() {}
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/* 139 */     if (SessionMBean.getBudget() != null) {
/*     */       
/* 141 */       if (!Utilitaires.isAccess(Long.valueOf(22L))) {
/* 142 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de valider une lettre commande");
/*     */         
/*     */         return;
/*     */       } 
/* 146 */       this.mode = "Create";
/* 147 */       this.signataire = new Signataire();
/* 148 */       this.structure = new Structure();
/* 149 */       this.imputation = new Imputation();
/* 150 */       this.boncommande = new Boncommande();
/* 151 */       this.taches.clear();
/* 152 */       this.tache = new Tache();
/* 153 */       this.moyens = new Moyens();
/* 154 */       this.moyenses.clear();
/* 155 */       this.budget = SessionMBean.getBudget();
/* 156 */       this.tache = new Tache();
/* 157 */       this.moyens = new Moyens();
/* 158 */       this.ligneboncommandes.clear();
/* 159 */       this.lignedecisions.clear();
/* 160 */       this.lignedecisionPb.clear();
/* 161 */       this.ligneboncommandePb.clear();
/* 162 */       this.verificationbc = new Verificationbc();
/* 163 */       this.verificationbc.setDateverification(new Date());
/*     */       
/* 165 */       this.valide = true;
/* 166 */       this.rejet = false;
/* 167 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } else {
/* 169 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 174 */     if (this.verificationbc != null) {
/* 175 */       this.mode = "Edit";
/* 176 */       this.boncommande = this.verificationbc.getBoncommande();
/* 177 */       this.structure = this.boncommande.getStructure();
/* 178 */       this.imputation = this.boncommande.getImputation();
/* 179 */       this.signataire = this.boncommande.getSignataire();
/* 180 */       this.budget = this.boncommande.getBudget();
/* 181 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareRejet() {
/* 186 */     this.ligneboncommandePb.clear();
/* 187 */     this.lignedecisionPb.clear();
/*     */     
/* 189 */     if (this.boncommande.isGreAgre()) {
/* 190 */       for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 191 */         Ligneboncommande lbc_temp = lbc;
/* 192 */         this.ligneboncommandePb.add(lbc_temp);
/*     */       } 
/*     */     } else {
/* 195 */       for (Lignedecision ld : this.lignedecisions) {
/* 196 */         if (!ld.isVerif()) {
/* 197 */           this.lignedecisionPb.add(ld);
/*     */         }
/*     */       } 
/*     */     } 
/* 201 */     RequestContext.getCurrentInstance().execute("PF('RejetCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 206 */       if (this.boncommande != null) {
/* 207 */         this.signataire = this.boncommande.getSignataire();
/* 208 */         this.ligneboncommandes.clear();
/* 209 */         this.lignedecisions.clear();
/* 210 */         this.imputation = this.boncommande.getImputation();
/* 211 */         this.structure = this.boncommande.getStructure();
/* 212 */         this.societe = this.boncommande.getSociete();
/* 213 */         if (this.boncommande.isGreAgre()) {
/* 214 */           this.ligneboncommandes = this.ligneboncommandeFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         } else {
/* 216 */           this.lignedecisions = this.lignedecisionFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         } 
/* 218 */         this.tache = this.boncommande.getMoyens().getIdtache();
/* 219 */         this.moyens = this.boncommande.getMoyens();
/*     */       } 
/* 221 */     } catch (Exception e) {
/* 222 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 228 */       this.moyenses.clear();
/* 229 */       if (this.tache != null) {
/* 230 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/*     */       }
/* 232 */     } catch (Exception e) {
/* 233 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRenderPanel(String chaine) {
/* 238 */     if (chaine.equals("valide")) {
/* 239 */       if (this.valide) {
/* 240 */         this.rejet = false;
/*     */       } else {
/* 242 */         this.rejet = true;
/*     */       }
/*     */     
/* 245 */     } else if (this.rejet) {
/* 246 */       this.valide = false;
/*     */     } else {
/* 248 */       this.valide = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveRejet() {
/*     */     try {
/* 256 */       this.ligneboncommandePb.clear();
/* 257 */       this.lignedecisionPb.clear();
/*     */       
/* 259 */       if (this.boncommande.isGreAgre()) {
/* 260 */         for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 261 */           Ligneboncommande lbc_temp = lbc;
/* 262 */           this.ligneboncommandePb.add(lbc_temp);
/*     */         } 
/*     */       } else {
/* 265 */         for (Lignedecision ld : this.lignedecisions) {
/* 266 */           if (!ld.isVerif()) {
/* 267 */             this.lignedecisionPb.add(ld);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 272 */       this.ut.begin();
/* 273 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 274 */       this.verificationbc.setValide(false);
/* 275 */       this.verificationbc.setBoncommande(this.boncommande);
/* 276 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/* 277 */       if (this.boncommande.isGreAgre()) {
/* 278 */         if (!this.ligneboncommandePb.isEmpty()) {
/* 279 */           for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 280 */             Ligneverificationbc lvbc = new Ligneverificationbc();
/* 281 */             lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 282 */             lvbc.setVerificationbc(this.verificationbc);
/* 283 */             lvbc.setLigneboncommande(lbc);
/* 284 */             this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */           }
/*     */         
/*     */         }
/* 288 */       } else if (!this.lignedecisionPb.isEmpty()) {
/* 289 */         for (Lignedecision ld : this.lignedecisionPb) {
/* 290 */           Ligneverificationbc lvbc = new Ligneverificationbc();
/* 291 */           lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 292 */           lvbc.setVerificationbc(this.verificationbc);
/* 293 */           lvbc.setLignedecision(ld);
/* 294 */           this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 299 */       this.boncommande.setVerif(true);
/* 300 */       this.boncommande.setValide(false);
/* 301 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 302 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 304 */       this.ut.commit();
/* 305 */       this.verificationbc = new Verificationbc();
/* 306 */       this.boncommande = new Boncommande();
/* 307 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/* 308 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 309 */     } catch (Exception e) {
/* 310 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public void saveValidation() {
/*     */     try {
/* 318 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 319 */       this.verificationbc.setValide(true);
/* 320 */       this.verificationbc.setBoncommande(this.boncommande);
/* 321 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/*     */       
/* 323 */       this.boncommande.setVerif(true);
/* 324 */       this.boncommande.setValide(true);
/* 325 */       this.boncommande.setLiquide(true);
/* 326 */       this.boncommande.setAttentepayement(true);
/* 327 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 328 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 330 */       Moyens m = this.boncommande.getMoyens();
/* 331 */       m.setMontantLiquide(m.getMontantLiquide() + this.boncommande.getTtc().doubleValue());
/* 332 */       this.moyensFacadeLocal.edit(m);
/*     */       
/* 334 */       Tache t = this.boncommande.getMoyens().getIdtache();
/* 335 */       t.setMontantliquide(t.getMontantliquide() + this.boncommande.getTtc().doubleValue());
/* 336 */       this.tacheFacadeLocal.edit(t);
/*     */       
/* 338 */       this.verificationbc = new Verificationbc();
/* 339 */       this.boncommande = new Boncommande();
/* 340 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/* 341 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 342 */     } catch (Exception e) {
/* 343 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 350 */       if (this.verificationbc != null) {
/*     */         
/* 352 */         if (this.verificationbc.getBoncommande().isGreAgre()) {
/* 353 */           this.ligneverificationbcFacadeLocal.deleteByIdVerificationBc(this.verificationbc.getIdverificationbc().longValue());
/*     */         } else {
/* 355 */           this.lignedecisionFacadeLocal.deleteByIdBoncommande(this.verificationbc.getIdverificationbc().longValue());
/*     */         } 
/* 357 */         this.verificationbcFacadeLocal.remove(this.verificationbc);
/*     */         
/* 359 */         if (this.verificationbc.isValide()) {
/* 360 */           this.verificationbc.getBoncommande().setValide(false);
/* 361 */           this.verificationbc.getBoncommande().setAttentepayement(false);
/* 362 */           this.boncommandeFacadeLocal.edit(this.verificationbc.getBoncommande());
/*     */         } 
/*     */         
/* 365 */         this.verificationbc = new Verificationbc();
/* 366 */         this.detail = true;
/* 367 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 369 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 371 */     } catch (Exception e) {
/* 372 */       e.printStackTrace();
/* 373 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void print() {
/*     */     try {
/* 379 */       if (!Utilitaires.isAccess(Long.valueOf(22L))) {
/* 380 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat de rejet");
/*     */         
/*     */         return;
/*     */       } 
/* 384 */       Map<Object, Object> parameter = new HashMap<>();
/* 385 */       parameter.put("date_debut", this.date_de_debut);
/* 386 */       parameter.put("date_fin", this.date_de_fin);
/* 387 */       parameter.put("logo", SessionMBean.getLogo());
/* 388 */       Printer p = new Printer();
/* 389 */       p.print("/rapport/report_camer_soft/certificat_rejet.jasper", parameter);
/* 390 */     } catch (Exception e) {
/* 391 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 396 */     this.detail = false;
/*     */     try {
/* 398 */       this.imprimer = true;
/* 399 */       if (this.verificationbc != null) {
/* 400 */         if (this.verificationbc.isValide()) {
/* 401 */           this.imprimer = true;
/*     */         } else {
/* 403 */           this.imprimer = false;
/*     */         } 
/*     */       }
/* 406 */     } catch (Exception e) {
/* 407 */       this.imprimer = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 412 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 416 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 420 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 424 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 428 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 432 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 433 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 437 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 441 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 445 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 449 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 450 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 454 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 458 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 462 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 466 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeLcNotValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 467 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 471 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 475 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 479 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 483 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 484 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 488 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 492 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 496 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 500 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 504 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 508 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 512 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 516 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 520 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 524 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 528 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 532 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 536 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 540 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 544 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public Verificationbc getVerificationbc() {
/* 548 */     return this.verificationbc;
/*     */   }
/*     */   
/*     */   public void setVerificationbc(Verificationbc verificationbc) {
/* 552 */     this.verificationbc = verificationbc;
/*     */   }
/*     */   
/*     */   public List<Verificationbc> getVerificationbcs() {
/* 556 */     this.verificationbcs = this.verificationbcFacadeLocal.findByIdAnneeLc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 557 */     return this.verificationbcs;
/*     */   }
/*     */   
/*     */   public void setVerificationbcs(List<Verificationbc> verificationbcs) {
/* 561 */     this.verificationbcs = verificationbcs;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandePb() {
/* 565 */     return this.ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandePb(List<Ligneboncommande> ligneboncommandePb) {
/* 569 */     this.ligneboncommandePb = ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisions() {
/* 573 */     return this.lignedecisions;
/*     */   }
/*     */   
/*     */   public void setLignedecisions(List<Lignedecision> lignedecisions) {
/* 577 */     this.lignedecisions = lignedecisions;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisionPb() {
/* 581 */     return this.lignedecisionPb;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 585 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public Date getDate_de_debut() {
/* 589 */     return this.date_de_debut;
/*     */   }
/*     */   
/*     */   public void setDate_de_debut(Date date_de_debut) {
/* 593 */     this.date_de_debut = date_de_debut;
/*     */   }
/*     */   
/*     */   public Date getDate_de_fin() {
/* 597 */     return this.date_de_fin;
/*     */   }
/*     */   
/*     */   public void setDate_de_fin(Date date_de_fin) {
/* 601 */     this.date_de_fin = date_de_fin;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/* 605 */     return this.valide;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/* 609 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public boolean isRejet() {
/* 613 */     return this.rejet;
/*     */   }
/*     */   
/*     */   public void setRejet(boolean rejet) {
/* 617 */     this.rejet = rejet;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\VerificationlcController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */