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
/*     */ public class ImpressionController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private VerificationbcFacadeLocal verificationbcFacadeLocal;
/*  61 */   private Verificationbc verificationbc = new Verificationbc();
/*  62 */   private List<Verificationbc> verificationbcs = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  66 */   private Boncommande boncommande = new Boncommande();
/*  67 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  71 */   private Signataire signataire = new Signataire();
/*  72 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  76 */   private Structure structure = new Structure();
/*  77 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  81 */   private Imputation imputation = new Imputation();
/*  82 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  86 */   private Budget budget = new Budget();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*  90 */   protected Tache tache = new Tache();
/*  91 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*  95 */   protected Moyens moyens = new Moyens();
/*  96 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneboncommandeFacadeLocal ligneboncommandeFacadeLocal;
/* 100 */   private List<Ligneboncommande> ligneboncommandes = new ArrayList<>();
/* 101 */   private List<Ligneboncommande> ligneboncommandePb = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LignedecisionFacadeLocal lignedecisionFacadeLocal;
/* 105 */   private List<Lignedecision> lignedecisions = new ArrayList<>();
/* 106 */   private List<Lignedecision> lignedecisionPb = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneverificationbcFacadeLocal ligneverificationbcFacadeLocal;
/*     */   
/* 111 */   private Societe societe = new Societe();
/*     */   
/* 113 */   private String mode = "";
/*     */   
/*     */   private boolean detail = true;
/*     */   
/*     */   private boolean imprimer = true;
/* 118 */   private Date date_de_debut = new Date();
/* 119 */   private Date date_de_fin = new Date();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void affiche(boolean item1) {
/* 126 */     System.err.println("affiche : " + item1);
/*     */   }
/*     */   
/*     */   public void recherche() {
/*     */     try {
/* 131 */       this.verificationbcs = this.verificationbcFacadeLocal.findByIdAnnee(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), this.date_de_debut, this.date_de_fin);
/* 132 */     } catch (Exception e) {
/* 133 */       e.printStackTrace();
/* 134 */       this.verificationbcs.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/* 139 */     if (SessionMBean.getBudget() != null) {
/* 140 */       this.mode = "Create";
/* 141 */       this.signataire = new Signataire();
/* 142 */       this.structure = new Structure();
/* 143 */       this.imputation = new Imputation();
/* 144 */       this.boncommande = new Boncommande();
/* 145 */       this.taches.clear();
/* 146 */       this.tache = new Tache();
/* 147 */       this.moyens = new Moyens();
/* 148 */       this.moyenses.clear();
/* 149 */       this.budget = SessionMBean.getBudget();
/* 150 */       this.tache = new Tache();
/* 151 */       this.moyens = new Moyens();
/* 152 */       this.ligneboncommandes.clear();
/* 153 */       this.lignedecisions.clear();
/* 154 */       this.lignedecisionPb.clear();
/* 155 */       this.ligneboncommandePb.clear();
/* 156 */       this.verificationbc = new Verificationbc();
/* 157 */       this.verificationbc.setDateverification(new Date());
/* 158 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } else {
/* 160 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 165 */     if (this.verificationbc != null) {
/* 166 */       this.mode = "Edit";
/* 167 */       this.boncommande = this.verificationbc.getBoncommande();
/* 168 */       this.structure = this.boncommande.getStructure();
/* 169 */       this.imputation = this.boncommande.getImputation();
/* 170 */       this.signataire = this.boncommande.getSignataire();
/* 171 */       this.budget = this.boncommande.getBudget();
/* 172 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareRejet() {
/* 177 */     this.ligneboncommandePb.clear();
/* 178 */     this.lignedecisionPb.clear();
/*     */     
/* 180 */     if (this.boncommande.isGreAgre()) {
/* 181 */       for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 182 */         Ligneboncommande lbc_temp = lbc;
/* 183 */         this.ligneboncommandePb.add(lbc_temp);
/*     */       } 
/*     */     } else {
/* 186 */       for (Lignedecision ld : this.lignedecisions) {
/* 187 */         if (!ld.isVerif()) {
/* 188 */           this.lignedecisionPb.add(ld);
/*     */         }
/*     */       } 
/*     */     } 
/* 192 */     RequestContext.getCurrentInstance().execute("PF('RejetCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 197 */       if (this.boncommande != null) {
/* 198 */         this.signataire = this.boncommande.getSignataire();
/* 199 */         this.ligneboncommandes.clear();
/* 200 */         this.lignedecisions.clear();
/* 201 */         this.imputation = this.boncommande.getImputation();
/* 202 */         this.structure = this.boncommande.getStructure();
/* 203 */         this.societe = this.boncommande.getSociete();
/* 204 */         if (this.boncommande.isGreAgre()) {
/* 205 */           this.ligneboncommandes = this.ligneboncommandeFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         } else {
/* 207 */           this.lignedecisions = this.lignedecisionFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         } 
/* 209 */         this.tache = this.boncommande.getMoyens().getIdtache();
/* 210 */         this.moyens = this.boncommande.getMoyens();
/*     */       } 
/* 212 */     } catch (Exception e) {
/* 213 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 219 */       this.moyenses.clear();
/* 220 */       if (this.tache != null) {
/* 221 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/*     */       }
/* 223 */     } catch (Exception e) {
/* 224 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveRejet() {
/*     */     try {
/* 231 */       this.ligneboncommandePb.clear();
/* 232 */       this.lignedecisionPb.clear();
/*     */       
/* 234 */       if (this.boncommande.isGreAgre()) {
/* 235 */         for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 236 */           Ligneboncommande lbc_temp = lbc;
/* 237 */           this.ligneboncommandePb.add(lbc_temp);
/*     */         } 
/*     */       } else {
/* 240 */         for (Lignedecision ld : this.lignedecisions) {
/* 241 */           if (!ld.isVerif()) {
/* 242 */             this.lignedecisionPb.add(ld);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 247 */       this.ut.begin();
/* 248 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 249 */       this.verificationbc.setValide(false);
/* 250 */       this.verificationbc.setBoncommande(this.boncommande);
/* 251 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/* 252 */       if (this.boncommande.isGreAgre()) {
/* 253 */         if (!this.ligneboncommandePb.isEmpty()) {
/* 254 */           for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 255 */             Ligneverificationbc lvbc = new Ligneverificationbc();
/* 256 */             lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 257 */             lvbc.setVerificationbc(this.verificationbc);
/* 258 */             lvbc.setLigneboncommande(lbc);
/* 259 */             this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */           }
/*     */         
/*     */         }
/* 263 */       } else if (!this.lignedecisionPb.isEmpty()) {
/* 264 */         for (Lignedecision ld : this.lignedecisionPb) {
/* 265 */           Ligneverificationbc lvbc = new Ligneverificationbc();
/* 266 */           lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 267 */           lvbc.setVerificationbc(this.verificationbc);
/* 268 */           lvbc.setLignedecision(ld);
/* 269 */           this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 274 */       this.boncommande.setVerif(true);
/* 275 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 276 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 278 */       this.ut.commit();
/* 279 */       this.verificationbc = new Verificationbc();
/* 280 */       this.boncommande = new Boncommande();
/* 281 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/*     */       
/* 283 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 284 */     } catch (Exception e) {
/* 285 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveValidation() {
/*     */     try {
/* 291 */       this.ut.begin();
/* 292 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 293 */       this.verificationbc.setValide(true);
/* 294 */       this.verificationbc.setBoncommande(this.boncommande);
/* 295 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/*     */       
/* 297 */       this.boncommande.setVerif(true);
/* 298 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 299 */       this.boncommandeFacadeLocal.edit(this.boncommande);
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
/*     */   public void delete() {
/*     */     try {
/* 312 */       if (this.verificationbc != null) {
/* 313 */         this.ut.begin();
/*     */         
/* 315 */         if (this.verificationbc.getBoncommande().isGreAgre()) {
/* 316 */           this.ligneverificationbcFacadeLocal.deleteByIdVerificationBc(this.verificationbc.getIdverificationbc().longValue());
/*     */         } else {
/* 318 */           this.lignedecisionFacadeLocal.deleteByIdBoncommande(this.verificationbc.getIdverificationbc().longValue());
/*     */         } 
/* 320 */         this.verificationbcFacadeLocal.remove(this.verificationbc);
/*     */         
/* 322 */         if (this.verificationbc.isValide()) {
/* 323 */           this.verificationbc.getBoncommande().setValide(false);
/* 324 */           this.boncommandeFacadeLocal.edit(this.verificationbc.getBoncommande());
/*     */         } 
/*     */         
/* 327 */         this.ut.commit();
/* 328 */         this.verificationbc = new Verificationbc();
/* 329 */         this.detail = true;
/* 330 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 332 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 334 */     } catch (Exception e) {
/* 335 */       e.printStackTrace();
/* 336 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void print() {
/*     */     try {
/* 342 */       Map<Object, Object> parameter = new HashMap<>();
/* 343 */       parameter.put("date_debut", this.date_de_debut);
/* 344 */       parameter.put("date_fin", this.date_de_fin);
/* 345 */       Printer p = new Printer();
/* 346 */       p.print("/rapport/report_camer_soft/certificat_rejet_interval.jasper", parameter);
/* 347 */     } catch (Exception e) {
/* 348 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 353 */     this.detail = false;
/*     */     try {
/* 355 */       this.imprimer = true;
/* 356 */       if (this.verificationbc != null) {
/* 357 */         if (this.verificationbc.isValide()) {
/* 358 */           this.imprimer = true;
/*     */         } else {
/* 360 */           this.imprimer = false;
/*     */         } 
/*     */       }
/* 363 */     } catch (Exception e) {
/* 364 */       this.imprimer = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 369 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 373 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 377 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 381 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 385 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 389 */     this.signataires = this.signataireFacadeLocal.findAllRangeEtatInstitutionIsActif();
/* 390 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 394 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 398 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 402 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 406 */     this.structures = this.structureFacadeLocal.findAllRangeEtatInstitutionIsActif();
/* 407 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 411 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 415 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 419 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 423 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeLcNotValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 424 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 428 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 432 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 436 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 440 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 441 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 445 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 449 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 453 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 457 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 461 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 465 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 469 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 473 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 477 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 481 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 485 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 489 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 493 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 497 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 501 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public Verificationbc getVerificationbc() {
/* 505 */     return this.verificationbc;
/*     */   }
/*     */   
/*     */   public void setVerificationbc(Verificationbc verificationbc) {
/* 509 */     this.verificationbc = verificationbc;
/*     */   }
/*     */   
/*     */   public List<Verificationbc> getVerificationbcs() {
/* 513 */     return this.verificationbcs;
/*     */   }
/*     */   
/*     */   public void setVerificationbcs(List<Verificationbc> verificationbcs) {
/* 517 */     this.verificationbcs = verificationbcs;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandePb() {
/* 521 */     return this.ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandePb(List<Ligneboncommande> ligneboncommandePb) {
/* 525 */     this.ligneboncommandePb = ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisions() {
/* 529 */     return this.lignedecisions;
/*     */   }
/*     */   
/*     */   public void setLignedecisions(List<Lignedecision> lignedecisions) {
/* 533 */     this.lignedecisions = lignedecisions;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisionPb() {
/* 537 */     return this.lignedecisionPb;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 541 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public Date getDate_de_debut() {
/* 545 */     return this.date_de_debut;
/*     */   }
/*     */   
/*     */   public void setDate_de_debut(Date date_de_debut) {
/* 549 */     this.date_de_debut = date_de_debut;
/*     */   }
/*     */   
/*     */   public Date getDate_de_fin() {
/* 553 */     return this.date_de_fin;
/*     */   }
/*     */   
/*     */   public void setDate_de_fin(Date date_de_fin) {
/* 557 */     this.date_de_fin = date_de_fin;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ImpressionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */