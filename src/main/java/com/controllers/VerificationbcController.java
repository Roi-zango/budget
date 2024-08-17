/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Budget;
/*     */ import entities.Imputation;
/*     */ import entities.Ligneboncommande;
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
/*     */ public class VerificationbcController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private VerificationbcFacadeLocal verificationbcFacadeLocal;
/*  60 */   private Verificationbc verificationbc = new Verificationbc();
/*  61 */   private List<Verificationbc> verificationbcs = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  65 */   private Boncommande boncommande = new Boncommande();
/*  66 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  70 */   private Signataire signataire = new Signataire();
/*  71 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  75 */   private Structure structure = new Structure();
/*  76 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  80 */   private Imputation imputation = new Imputation();
/*  81 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  85 */   private Budget budget = new Budget();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*  89 */   protected Tache tache = new Tache();
/*  90 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*  94 */   protected Moyens moyens = new Moyens();
/*  95 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneboncommandeFacadeLocal ligneboncommandeFacadeLocal;
/*  99 */   private List<Ligneboncommande> ligneboncommandes = new ArrayList<>();
/* 100 */   private List<Ligneboncommande> ligneboncommandePb = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneverificationbcFacadeLocal ligneverificationbcFacadeLocal;
/*     */   
/* 105 */   private Societe societe = new Societe();
/*     */   
/* 107 */   private String mode = "";
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
/* 120 */     if (SessionMBean.getBudget() != null) {
/*     */       
/* 122 */       if (!Utilitaires.isAccess(Long.valueOf(19L))) {
/* 123 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de valider un bon de commande");
/*     */         
/*     */         return;
/*     */       } 
/* 127 */       this.mode = "Create";
/* 128 */       this.signataire = new Signataire();
/* 129 */       this.structure = new Structure();
/* 130 */       this.imputation = new Imputation();
/* 131 */       this.boncommande = new Boncommande();
/* 132 */       this.taches.clear();
/* 133 */       this.tache = new Tache();
/* 134 */       this.moyens = new Moyens();
/* 135 */       this.moyenses.clear();
/* 136 */       this.budget = SessionMBean.getBudget();
/* 137 */       this.tache = new Tache();
/* 138 */       this.moyens = new Moyens();
/* 139 */       this.ligneboncommandes.clear();
/* 140 */       this.verificationbc = new Verificationbc();
/* 141 */       this.verificationbc.setDateverification(new Date());
/*     */       
/* 143 */       this.valide = true;
/* 144 */       this.rejet = false;
/* 145 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } else {
/* 147 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 152 */     if (this.verificationbc != null) {
/* 153 */       this.mode = "Edit";
/* 154 */       this.boncommande = this.verificationbc.getBoncommande();
/* 155 */       this.structure = this.boncommande.getStructure();
/* 156 */       this.imputation = this.boncommande.getImputation();
/* 157 */       this.signataire = this.boncommande.getSignataire();
/* 158 */       this.budget = this.boncommande.getBudget();
/* 159 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareRejet() {
/* 164 */     this.ligneboncommandePb.clear();
/* 165 */     for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 166 */       Ligneboncommande lbc_temp = lbc;
/* 167 */       this.ligneboncommandePb.add(lbc_temp);
/*     */     } 
/* 169 */     RequestContext.getCurrentInstance().execute("PF('RejetCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 174 */       if (this.boncommande != null) {
/* 175 */         this.signataire = this.boncommande.getSignataire();
/* 176 */         this.imputation = this.boncommande.getImputation();
/* 177 */         this.structure = this.boncommande.getStructure();
/* 178 */         this.societe = this.boncommande.getSociete();
/* 179 */         this.ligneboncommandes = this.ligneboncommandeFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/* 180 */         this.tache = this.boncommande.getMoyens().getIdtache();
/* 181 */         this.moyens = this.boncommande.getMoyens();
/*     */       } 
/* 183 */     } catch (Exception e) {
/* 184 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 190 */       this.moyenses.clear();
/* 191 */       if (this.tache != null) {
/* 192 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/*     */       }
/* 194 */     } catch (Exception e) {
/* 195 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRenderPanel(String chaine) {
/* 200 */     if (chaine.equals("valide")) {
/* 201 */       if (this.valide) {
/* 202 */         this.rejet = false;
/*     */       } else {
/* 204 */         this.rejet = true;
/*     */       }
/*     */     
/* 207 */     } else if (this.rejet) {
/* 208 */       this.valide = false;
/*     */     } else {
/* 210 */       this.valide = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveRejet() {
/*     */     try {
/* 218 */       this.ligneboncommandePb.clear();
/* 219 */       for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 220 */         Ligneboncommande lbc_temp = lbc;
/* 221 */         this.ligneboncommandePb.add(lbc_temp);
/*     */       } 
/* 223 */       this.ut.begin();
/* 224 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 225 */       this.verificationbc.setValide(false);
/* 226 */       this.verificationbc.setBoncommande(this.boncommande);
/* 227 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/* 228 */       if (!this.ligneboncommandePb.isEmpty()) {
/* 229 */         for (Ligneboncommande lbc : this.ligneboncommandePb) {
/* 230 */           Ligneverificationbc lvbc = new Ligneverificationbc();
/* 231 */           lvbc.setIdligneVerificationBc(Long.valueOf(this.ligneverificationbcFacadeLocal.nextId()));
/* 232 */           lvbc.setVerificationbc(this.verificationbc);
/* 233 */           lvbc.setLigneboncommande(lbc);
/* 234 */           this.ligneverificationbcFacadeLocal.create(lvbc);
/*     */         } 
/*     */       }
/*     */       
/* 238 */       this.boncommande.setVerif(true);
/* 239 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 240 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 242 */       this.ut.commit();
/* 243 */       this.verificationbc = new Verificationbc();
/* 244 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/*     */       
/* 246 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 247 */     } catch (Exception e) {
/* 248 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveValidation() {
/*     */     try {
/* 254 */       this.ut.begin();
/* 255 */       this.verificationbc.setIdverificationbc(Long.valueOf(this.verificationbcFacadeLocal.nextId()));
/* 256 */       this.verificationbc.setValide(true);
/* 257 */       this.verificationbc.setBoncommande(this.boncommande);
/* 258 */       this.verificationbcFacadeLocal.create(this.verificationbc);
/*     */       
/* 260 */       this.boncommande.setVerif(true);
/* 261 */       this.boncommande.setValide(true);
/* 262 */       this.boncommande.setLiquide(true);
/* 263 */       this.boncommande.setAttentepayement(true);
/* 264 */       this.boncommande.setNombreverif(this.boncommande.getNombreverif() + 1);
/* 265 */       this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */       
/* 267 */       Moyens m = this.boncommande.getMoyens();
/* 268 */       m.setMontantLiquide(m.getMontantLiquide() + this.boncommande.getTtc().doubleValue());
/* 269 */       this.moyensFacadeLocal.edit(m);
/*     */       
/* 271 */       Tache t = this.boncommande.getMoyens().getIdtache();
/* 272 */       t.setMontantliquide(t.getMontantliquide() + this.boncommande.getTtc().doubleValue());
/* 273 */       this.tacheFacadeLocal.edit(t);
/*     */       
/* 275 */       this.ut.commit();
/* 276 */       this.verificationbc = new Verificationbc();
/* 277 */       this.boncommande = new Boncommande();
/* 278 */       RequestContext.getCurrentInstance().execute("PF('VerificationCreateDialog').hide()");
/* 279 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 280 */     } catch (Exception e) {
/* 281 */       JsfUtil.addFatalErrorMessage("Echec de l'opération : veuillez controller le formulaire");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 287 */       if (this.verificationbc != null) {
/* 288 */         this.ut.begin();
/*     */         
/* 290 */         this.ligneverificationbcFacadeLocal.deleteByIdVerificationBc(this.verificationbc.getIdverificationbc().longValue());
/* 291 */         this.verificationbcFacadeLocal.remove(this.verificationbc);
/*     */         
/* 293 */         if (this.verificationbc.isValide()) {
/* 294 */           this.verificationbc.getBoncommande().setValide(false);
/* 295 */           this.verificationbc.getBoncommande().setAttentepayement(false);
/* 296 */           this.boncommandeFacadeLocal.edit(this.verificationbc.getBoncommande());
/*     */         } 
/*     */         
/* 299 */         this.ut.commit();
/* 300 */         this.verificationbc = new Verificationbc();
/* 301 */         this.detail = true;
/* 302 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 304 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 306 */     } catch (Exception e) {
/* 307 */       e.printStackTrace();
/* 308 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void print() {
/*     */     try {
/* 315 */       if (!Utilitaires.isAccess(Long.valueOf(23L))) {
/* 316 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat de rejet");
/*     */         
/*     */         return;
/*     */       } 
/* 320 */       Map<Object, Object> parameter = new HashMap<>();
/* 321 */       parameter.put("idverificationbc", this.verificationbc.getIdverificationbc());
/* 322 */       parameter.put("logo", SessionMBean.getLogo());
/* 323 */       Printer p = new Printer();
/* 324 */       p.print("/rapport/report_camer_soft/certificat_rejet.jasper", parameter);
/* 325 */     } catch (Exception e) {
/* 326 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/*     */     try {
/* 332 */       this.detail = false;
/* 333 */       this.imprimer = true;
/* 334 */       if (this.verificationbc != null) {
/* 335 */         if (this.verificationbc.isValide()) {
/* 336 */           this.imprimer = true;
/*     */         } else {
/* 338 */           this.imprimer = false;
/*     */         } 
/*     */       }
/* 341 */     } catch (Exception e) {
/* 342 */       this.imprimer = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 347 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 351 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 355 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 359 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 363 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 367 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 368 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 372 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 376 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 380 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 384 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 385 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 389 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 393 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 397 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 401 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeBcNotValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 402 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 406 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 410 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 414 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 418 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 419 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 423 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 427 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 431 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 435 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 439 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 443 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 447 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 451 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 455 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 459 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 463 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 467 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 471 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 475 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 479 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public Verificationbc getVerificationbc() {
/* 483 */     return this.verificationbc;
/*     */   }
/*     */   
/*     */   public void setVerificationbc(Verificationbc verificationbc) {
/* 487 */     this.verificationbc = verificationbc;
/*     */   }
/*     */   
/*     */   public List<Verificationbc> getVerificationbcs() {
/* 491 */     this.verificationbcs = this.verificationbcFacadeLocal.findByIdAnneeBc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 492 */     return this.verificationbcs;
/*     */   }
/*     */   
/*     */   public void setVerificationbcs(List<Verificationbc> verificationbcs) {
/* 496 */     this.verificationbcs = verificationbcs;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandePb() {
/* 500 */     return this.ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandePb(List<Ligneboncommande> ligneboncommandePb) {
/* 504 */     this.ligneboncommandePb = ligneboncommandePb;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 508 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/* 512 */     return this.valide;
/*     */   }
/*     */   
/*     */   public boolean isRejet() {
/* 516 */     return this.rejet;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/* 520 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public void setRejet(boolean rejet) {
/* 524 */     this.rejet = rejet;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\VerificationbcController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */