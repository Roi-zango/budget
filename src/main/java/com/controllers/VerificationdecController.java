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
/*     */ public class VerificationdecController
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
/* 213 */         this.lignedecisions = this.lignedecisionFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/* 214 */         this.tache = this.boncommande.getMoyens().getIdtache();
/* 215 */         this.moyens = this.boncommande.getMoyens();
/*     */       } 
/* 217 */     } catch (Exception e) {
/* 218 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 224 */       this.moyenses.clear();
/* 225 */       if (this.tache != null) {
/* 226 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/*     */       }
/* 228 */     } catch (Exception e) {
/* 229 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRenderPanel(String chaine) {
/* 234 */     if (chaine.equals("valide")) {
/* 235 */       if (this.valide) {
/* 236 */         this.rejet = false;
/*     */       } else {
/* 238 */         this.rejet = true;
/*     */       }
/*     */     
/* 241 */     } else if (this.rejet) {
/* 242 */       this.valide = false;
/*     */     } else {
/* 244 */       this.valide = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveRejet() {
/*     */     try {
/* 252 */       this.ligneboncommandePb.clear();
/* 253 */       this.lignedecisionPb.clear();
/*     */       
/* 255 */       if (this.boncommande.isGreAgre()) {
/* 256 */         for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 257 */           Ligneboncommande lbc_temp = lbc;
/* 258 */           this.ligneboncommandePb.add(lbc_temp);
/*     */         } 
/*     */       } else {
/* 261 */         for (Lignedecision ld : this.lignedecisions) {
/* 262 */           if (!ld.isVerif()) {
/* 263 */             this.lignedecisionPb.add(ld);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 268 */       this.ut.begin();
/* 269 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 270 */       this.verificationbc.setValide(false);
/* 271 */       this.verificationbc.setBoncommande(this.boncommande);
/* 272 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/* 273 */       if (this.boncommande.isGreAgre()) {
/* 274 */         if (!this.ligneboncommandePb.isEmpty()) {
/* 275 */           for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 276 */             Ligneverificationbc lvbc = new Ligneverificationbc();
/* 277 */             lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 278 */             lvbc.setVerificationbc(this.verificationbc);
/* 279 */             lvbc.setLigneboncommande(lbc);
/* 280 */             this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */           }
/*     */         
/*     */         }
/* 284 */       } else if (!this.lignedecisionPb.isEmpty()) {
/* 285 */         for (Lignedecision ld : this.lignedecisionPb) {
/* 286 */           Ligneverificationbc lvbc = new Ligneverificationbc();
/* 287 */           lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 288 */           lvbc.setVerificationbc(this.verificationbc);
/* 289 */           lvbc.setLignedecision(ld);
/* 290 */           this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 295 */       this.boncommande.setVerif(true);
/* 296 */       this.boncommande.setValide(false);
/* 297 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 298 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 300 */       this.ut.commit();
/* 301 */       this.verificationbc = new Verificationbc();
/* 302 */       this.boncommande = new Boncommande();
/* 303 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/* 304 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 305 */     } catch (Exception e) {
/* 306 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public void saveValidation() {
/*     */     try {
/* 314 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 315 */       this.verificationbc.setValide(true);
/* 316 */       this.verificationbc.setBoncommande(this.boncommande);
/* 317 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/*     */       
/* 319 */       this.boncommande.setVerif(true);
/* 320 */       this.boncommande.setValide(true);
/* 321 */       this.boncommande.setLiquide(true);
/* 322 */       this.boncommande.setAttentepayement(true);
/* 323 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 324 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 326 */       Moyens m = this.boncommande.getMoyens();
/* 327 */       m.setMontantLiquide(m.getMontantLiquide() + this.boncommande.getTtc().doubleValue());
/* 328 */       this.moyensFacadeLocal.edit(m);
/*     */       
/* 330 */       Tache t = this.boncommande.getMoyens().getIdtache();
/* 331 */       t.setMontantliquide(t.getMontantliquide() + this.boncommande.getTtc().doubleValue());
/* 332 */       this.tacheFacadeLocal.edit(t);
/*     */       
/* 334 */       this.verificationbc = new Verificationbc();
/* 335 */       this.boncommande = new Boncommande();
/* 336 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/* 337 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 338 */     } catch (Exception e) {
/* 339 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 345 */       if (this.verificationbc != null) {
/* 346 */         this.ut.begin();
/*     */         
/* 348 */         if (this.verificationbc.getBoncommande().isGreAgre()) {
/* 349 */           this.ligneverificationbcFacadeLocal.deleteByIdVerificationBc(this.verificationbc.getIdverificationbc().longValue());
/*     */         } else {
/* 351 */           this.lignedecisionFacadeLocal.deleteByIdBoncommande(this.verificationbc.getIdverificationbc().longValue());
/*     */         } 
/* 353 */         this.verificationbcFacadeLocal.remove(this.verificationbc);
/*     */         
/* 355 */         if (this.verificationbc.isValide()) {
/* 356 */           this.verificationbc.getBoncommande().setValide(false);
/* 357 */           this.verificationbc.getBoncommande().setAttentepayement(false);
/* 358 */           this.boncommandeFacadeLocal.edit(this.verificationbc.getBoncommande());
/*     */         } 
/*     */         
/* 361 */         this.ut.commit();
/* 362 */         this.verificationbc = new Verificationbc();
/* 363 */         this.detail = true;
/* 364 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 366 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 368 */     } catch (Exception e) {
/* 369 */       e.printStackTrace();
/* 370 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void print() {
/*     */     try {
/* 377 */       if (!Utilitaires.isAccess(Long.valueOf(22L))) {
/* 378 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat de rejet");
/*     */         
/*     */         return;
/*     */       } 
/* 382 */       Map<Object, Object> parameter = new HashMap<>();
/* 383 */       Printer p = new Printer();
/* 384 */       parameter.put("date_debut", this.date_de_debut);
/* 385 */       parameter.put("date_fin", this.date_de_fin);
/* 386 */       parameter.put("logo", SessionMBean.getLogo());
/* 387 */       p.print("/rapport/report_camer_soft/certificat_rejet.jasper", parameter);
/* 388 */     } catch (Exception e) {
/* 389 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 394 */     this.detail = false;
/*     */     try {
/* 396 */       this.imprimer = true;
/* 397 */       if (this.verificationbc != null) {
/* 398 */         if (this.verificationbc.isValide()) {
/* 399 */           this.imprimer = true;
/*     */         } else {
/* 401 */           this.imprimer = false;
/*     */         } 
/*     */       }
/* 404 */     } catch (Exception e) {
/* 405 */       this.imprimer = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 410 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 414 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 418 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 422 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 426 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 430 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 431 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 435 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 439 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 443 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 447 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 448 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 452 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 456 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 460 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 464 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeDecNotValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 465 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 469 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 473 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 477 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 481 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 482 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 486 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 490 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 494 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 498 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 502 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 506 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 510 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 514 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 518 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 522 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 526 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 530 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 534 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 538 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 542 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public Verificationbc getVerificationbc() {
/* 546 */     return this.verificationbc;
/*     */   }
/*     */   
/*     */   public void setVerificationbc(Verificationbc verificationbc) {
/* 550 */     this.verificationbc = verificationbc;
/*     */   }
/*     */   
/*     */   public List<Verificationbc> getVerificationbcs() {
/* 554 */     this.verificationbcs = this.verificationbcFacadeLocal.findByIdAnneeDec(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 555 */     return this.verificationbcs;
/*     */   }
/*     */   
/*     */   public void setVerificationbcs(List<Verificationbc> verificationbcs) {
/* 559 */     this.verificationbcs = verificationbcs;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandePb() {
/* 563 */     return this.ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandePb(List<Ligneboncommande> ligneboncommandePb) {
/* 567 */     this.ligneboncommandePb = ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisions() {
/* 571 */     return this.lignedecisions;
/*     */   }
/*     */   
/*     */   public void setLignedecisions(List<Lignedecision> lignedecisions) {
/* 575 */     this.lignedecisions = lignedecisions;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisionPb() {
/* 579 */     return this.lignedecisionPb;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 583 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public Date getDate_de_debut() {
/* 587 */     return this.date_de_debut;
/*     */   }
/*     */   
/*     */   public void setDate_de_debut(Date date_de_debut) {
/* 591 */     this.date_de_debut = date_de_debut;
/*     */   }
/*     */   
/*     */   public Date getDate_de_fin() {
/* 595 */     return this.date_de_fin;
/*     */   }
/*     */   
/*     */   public void setDate_de_fin(Date date_de_fin) {
/* 599 */     this.date_de_fin = date_de_fin;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/* 603 */     return this.valide;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/* 607 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public boolean isRejet() {
/* 611 */     return this.rejet;
/*     */   }
/*     */   
/*     */   public void setRejet(boolean rejet) {
/* 615 */     this.rejet = rejet;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\VerificationdecController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */