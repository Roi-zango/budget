/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Elementcout;
/*     */ import entities.Imputation;
/*     */ import entities.Ligneboncommande;
/*     */ import entities.Lignedecision;
/*     */ import entities.Moyens;
/*     */ import entities.Rubriquemercurial;
/*     */ import entities.Signataire;
/*     */ import entities.Societe;
/*     */ import entities.Sousrubriquemercurial;
/*     */ import entities.Structure;
/*     */ import entities.Tache;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.transaction.Transactional;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
/*     */ import sessions.ElementcoutFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.LigneboncommandeFacadeLocal;
/*     */ import sessions.LignedecisionFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.RubriquemercurialFacadeLocal;
/*     */ import sessions.SignataireFacadeLocal;
/*     */ import sessions.SocieteFacadeLocal;
/*     */ import sessions.SousrubriquemercurialFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import utilitaire.Convert;
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
/*     */ public class DecisionController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  64 */   private Boncommande boncommande = new Boncommande();
/*  65 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneboncommandeFacadeLocal ligneboncommandeFacadeLocal;
/*  69 */   private List<Ligneboncommande> ligneboncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LignedecisionFacadeLocal lignedecisionFacadeLocal;
/*  73 */   private Lignedecision lignedecision = new Lignedecision();
/*  74 */   private List<Lignedecision> lignedecisions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ElementcoutFacadeLocal elementcoutFacadeLocal;
/*  78 */   private List<Elementcout> elementcouts = new ArrayList<>();
/*  79 */   private List<Elementcout> selectedElementcouts = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  83 */   private Signataire signataire = new Signataire();
/*  84 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  88 */   private Structure structure = new Structure();
/*  89 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  93 */   private Imputation imputation = new Imputation();
/*  94 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SocieteFacadeLocal societeFacadeLocal;
/*  98 */   private Societe societe = new Societe();
/*  99 */   private List<Societe> societes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/* 103 */   protected Tache tache = new Tache();
/* 104 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/* 108 */   protected Moyens moyens = new Moyens();
/* 109 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SousrubriquemercurialFacadeLocal sousrubriquemercurialFacadeLocal;
/* 113 */   private Sousrubriquemercurial sousrubriquemercurial = new Sousrubriquemercurial();
/* 114 */   private List<Sousrubriquemercurial> sousrubriquemercurials = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RubriquemercurialFacadeLocal rubriquemercurialFacadeLocal;
/* 118 */   private Rubriquemercurial rubriquemercurial = new Rubriquemercurial();
/* 119 */   private List<Rubriquemercurial> rubriquemercurials = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*     */   
/* 124 */   private String mode = "";
/* 125 */   private List<String> notif = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private boolean renderedNotif = false;
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/* 135 */     if (SessionMBean.getBudget() != null) {
/*     */       
/* 137 */       if (!Utilitaires.isAccess(Long.valueOf(24L))) {
/* 138 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de saisir une décision");
/*     */         
/*     */         return;
/*     */       } 
/* 142 */       this.mode = "Create";
/* 143 */       this.ligneboncommandes.clear();
/* 144 */       this.notif.clear();
/* 145 */       this.taches.clear();
/* 146 */       this.moyenses.clear();
/* 147 */       this.moyens = new Moyens();
/* 148 */       this.moyens.setCt(Double.valueOf(0.0D));
/* 149 */       this.moyens.setMontantexecute(Double.valueOf(0.0D));
/* 150 */       this.tache = new Tache();
/* 151 */       this.societe = new Societe();
/* 152 */       this.signataire = new Signataire();
/* 153 */       this.structure = new Structure();
/* 154 */       this.imputation = new Imputation();
/* 155 */       this.boncommande = new Boncommande();
/* 156 */       this.boncommande.setAvance(0.0D);
/* 157 */       this.boncommande.setTotalht(0.0D);
/* 158 */       this.boncommande.setTotalair(0.0D);
/* 159 */       this.boncommande.setMontantenlettre("-");
/* 160 */       this.boncommande.setReference("-");
/* 161 */       this.boncommande.setCoefficientreducteur(SessionMBean.getParametrage().getPourcentagemercurial());
/* 162 */       this.boncommande.setDelailivraison(15);
/* 163 */       this.boncommande.setVerif(false);
/* 164 */       this.boncommande.setNombreverif(0);
/* 165 */       this.boncommande.setValide(false);
/* 166 */       this.boncommande.setEngage(true);
/*     */       
/* 168 */       this.boncommande.setImputations("-");
/*     */       
/* 170 */       this.boncommande.setBc(false);
/* 171 */       this.boncommande.setMission(false);
/* 172 */       this.boncommande.setLettrecommande(false);
/* 173 */       this.boncommande.setDecision(true);
/* 174 */       this.boncommande.setGreAgre(true);
/* 175 */       this.boncommande.setSalaire(false);
/*     */       
/* 177 */       this.boncommande.setEspece(false);
/* 178 */       this.boncommande.setVirement(true);
/* 179 */       this.boncommande.setCheque(false);
/*     */       
/* 181 */       this.boncommande.setAttentepayement(false);
/* 182 */       this.boncommande.setPaye(false);
/* 183 */       this.boncommande.setValide(false);
/*     */       
/* 185 */       this.boncommande.setCode(Utilitaires.generateDENumero(this.boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), SessionMBean.getAnnee().getNom()));
/*     */       
/* 187 */       if (SessionMBean.getParametrage() != null) {
/* 188 */         this.boncommande.setTauxtva(SessionMBean.getParametrage().getTauxtva());
/* 189 */         this.boncommande.setTauxair(SessionMBean.getParametrage().getTauxair());
/*     */       } else {
/* 191 */         this.boncommande.setTauxair(5.5D);
/* 192 */         this.boncommande.setTauxtva(19.25D);
/*     */       } 
/*     */       
/* 195 */       this.lignedecisions.clear();
/*     */       
/* 197 */       RequestContext.getCurrentInstance().execute("PF('DecisionCreateDialog').show()");
/*     */     } else {
/* 199 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 204 */     if (this.boncommande != null) {
/*     */       
/* 206 */       if (!Utilitaires.isAccess(Long.valueOf(24L))) {
/* 207 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier une décision");
/*     */         
/*     */         return;
/*     */       } 
/* 211 */       if (this.boncommande.isValide()) {
/* 212 */         JsfUtil.addWarningMessage("Operation impossible; Cette décision est déjà validée");
/*     */         
/*     */         return;
/*     */       } 
/* 216 */       this.moyenses.clear();
/* 217 */       this.taches.clear();
/*     */       
/* 219 */       this.structure = this.boncommande.getStructure();
/* 220 */       this.imputation = this.boncommande.getImputation();
/* 221 */       this.signataire = this.boncommande.getSignataire();
/*     */       
/* 223 */       this.societe = this.boncommande.getSociete();
/*     */       
/* 225 */       this.elementcouts = this.elementcoutFacadeLocal.findByIdimputation(this.imputation.getIdimputation().longValue());
/* 226 */       if (this.boncommande.isGreAgre()) {
/* 227 */         this.ligneboncommandes = this.ligneboncommandeFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         
/* 229 */         this.selectedElementcouts.clear();
/* 230 */         for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 231 */           this.selectedElementcouts.add(lbc.getElementcout());
/*     */         }
/*     */       } else {
/* 234 */         this.lignedecisions = this.lignedecisionFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */       } 
/*     */       
/* 237 */       this.tache = this.boncommande.getMoyens().getIdtache();
/* 238 */       this.moyens = this.boncommande.getMoyens();
/*     */       
/* 240 */       this.taches.add(this.boncommande.getMoyens().getIdtache());
/* 241 */       this.moyenses.add(this.boncommande.getMoyens());
/*     */       
/* 243 */       this.mode = "Edit";
/* 244 */       RequestContext.getCurrentInstance().execute("PF('DecisionCreateDialog').show()");
/*     */     } else {
/* 246 */       JsfUtil.addFatalErrorMessage("Aucune ligne sélectionnée");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareAddReferences() {
/* 251 */     this.elementcouts.clear();
/* 252 */     if (this.imputation.getIdimputation() != null) {
/* 253 */       this.elementcouts = this.elementcoutFacadeLocal.findByIdimputation(this.imputation.getIdimputation().longValue());
/*     */     }
/* 255 */     RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareAddElements() {
/* 259 */     this.lignedecision = new Lignedecision();
/* 260 */     this.lignedecision.setQuantite(1);
/* 261 */     RequestContext.getCurrentInstance().execute("PF('ElementCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void removeElement(Ligneboncommande l) {
/* 265 */     int i = 0;
/* 266 */     for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 267 */       if (lbc.getElementcout().equals(l.getElementcout())) {
/* 268 */         if (l.getIdligneboncommande().longValue() != 0L) {
/* 269 */           this.ligneboncommandeFacadeLocal.remove(lbc);
/*     */         }
/* 271 */         this.ligneboncommandes.remove(i);
/*     */         break;
/*     */       } 
/* 274 */       i++;
/*     */     } 
/* 276 */     updateTotal();
/*     */   }
/*     */   
/*     */   public void removeElementC(Lignedecision l) {
/* 280 */     int i = 0;
/* 281 */     for (Lignedecision ldc : this.lignedecisions) {
/* 282 */       if (ldc.getCode().equals(l.getCode())) {
/* 283 */         if (l.getIdligneDecision().longValue() != 0L) {
/* 284 */           this.lignedecisionFacadeLocal.remove(ldc);
/*     */         }
/* 286 */         this.lignedecisions.remove(i);
/*     */         break;
/*     */       } 
/* 289 */       i++;
/*     */     } 
/* 291 */     updateTotal();
/*     */   }
/*     */   
/*     */   public void updateTache() {
/*     */     try {
/* 296 */       if (this.structure.getIdstructure() != null) {
/* 297 */         this.taches.clear();
/* 298 */         this.imputation = new Imputation();
/* 299 */         this.moyenses.clear();
/* 300 */         this.moyens = new Moyens();
/* 301 */         this.taches = this.tacheFacadeLocal.findByStructureAnnee(this.structure.getIdstructure().longValue(), SessionMBean.getAnnee().getIdannee().longValue());
/*     */         return;
/*     */       } 
/* 304 */       JsfUtil.addWarningMessage("Veuillez selectionner une structure");
/* 305 */     } catch (Exception e) {
/* 306 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addElement() {
/* 311 */     for (Elementcout e : this.selectedElementcouts) {
/* 312 */       if (!checkIfExistElementInLigne(e)) {
/* 313 */         Ligneboncommande l = new Ligneboncommande();
/* 314 */         l.setIdligneboncommande(Long.valueOf(0L));
/* 315 */         l.setElementcout(e);
/* 316 */         l.setPrixunitaire(0.0D);
/* 317 */         l.setQuantite(0.0D);
/* 318 */         l.setTotal(0.0D);
/* 319 */         l.setPrixunitaire(e.getPrixunitaire());
/* 320 */         l.setPrixmercurial(e.getPrixunitaire());
/* 321 */         this.ligneboncommandes.add(l);
/*     */       } 
/*     */     } 
/*     */     
/* 325 */     RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').hide()");
/* 326 */     JsfUtil.addSuccessMessage("Ajout avec succès");
/*     */   }
/*     */   
/*     */   public void addElementCout() {
/* 330 */     Lignedecision ld = this.lignedecision;
/* 331 */     ld.setIdligneDecision(Long.valueOf(0L));
/* 332 */     ld.setCode("" + this.lignedecisions.size() + '\001');
/* 333 */     ld.setTotal(ld.getCoutunitaire() * ld.getQuantite());
/* 334 */     this.lignedecisions.add(ld);
/* 335 */     updateTotal();
/* 336 */     RequestContext.getCurrentInstance().execute("PF('ElementCreateDialog').hide()");
/* 337 */     JsfUtil.addSuccessMessage("Ajout avec succès");
/*     */   }
/*     */   
/*     */   private boolean checkIfExistElementInLigne(Elementcout elementcout) {
/* 341 */     boolean result = false;
/* 342 */     for (Ligneboncommande l : this.ligneboncommandes) {
/* 343 */       if (l.getElementcout().equals(elementcout)) {
/* 344 */         result = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 348 */     return result;
/*     */   }
/*     */   
/*     */   public void updateTotal() {
/* 352 */     double value_ht = 0.0D;
/* 353 */     int i = 0;
/*     */     
/* 355 */     for (Lignedecision ld : this.lignedecisions) {
/* 356 */       value_ht += ld.getCoutunitaire() * ld.getQuantite();
/* 357 */       ((Lignedecision)this.lignedecisions.get(i)).setTotal(ld.getCoutunitaire() * ld.getQuantite());
/* 358 */       i++;
/*     */     } 
/*     */     
/* 361 */     this.boncommande.setTotalht(value_ht);
/* 362 */     this.boncommande.setTva(value_ht * this.boncommande.getTauxtva() / 100.0D);
/* 363 */     this.boncommande.setTotalair(value_ht * this.boncommande.getTauxair() / 100.0D);
/* 364 */     this.boncommande.setTtc(Double.valueOf(value_ht + this.boncommande.getTva()));
/* 365 */     this.boncommande.setNetapayer(value_ht - this.boncommande.getTotalair());
/*     */     
/* 367 */     String montantEnLettre = Convert.FR("" + this.boncommande.getTtc().intValue());
/* 368 */     this.boncommande.setMontantenlettre(montantEnLettre);
/*     */   }
/*     */   
/*     */   public void updateSousRubiqueM() {
/*     */     try {
/* 373 */       this.sousrubriquemercurials.clear();
/* 374 */       this.elementcouts.clear();
/* 375 */       if (this.rubriquemercurial.getIdrubriquemercurial() != null) {
/* 376 */         this.sousrubriquemercurials = this.sousrubriquemercurialFacadeLocal.findByIdrubrique(this.rubriquemercurial.getIdrubriquemercurial().intValue());
/* 377 */         this.elementcouts = this.elementcoutFacadeLocal.findByIdimputationIdrubrique(this.imputation.getIdimputation().longValue(), this.rubriquemercurial.getIdrubriquemercurial().intValue());
/*     */       } 
/* 379 */     } catch (Exception e) {
/* 380 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateReference() {
/*     */     try {
/* 386 */       this.elementcouts.clear();
/* 387 */       if (this.sousrubriquemercurial.getIdsousrubriquemercurial() != null) {
/* 388 */         this.elementcouts = this.elementcoutFacadeLocal.findByIdimputationIdsousrubrique(this.imputation.getIdimputation().longValue(), this.sousrubriquemercurial.getIdsousrubriquemercurial().intValue());
/*     */       }
/* 390 */     } catch (Exception e) {
/* 391 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<String> notifyChecking() {
/* 396 */     List<String> notifs = new ArrayList<>();
/* 397 */     int i = 0;
/* 398 */     for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 399 */       double montant = lbc.getPrixunitaire();
/* 400 */       double pourcentage = lbc.getElementcout().getPrixunitaire() * SessionMBean.getParametrage().getPourcentagemercurial() / 100.0D;
/* 401 */       if (lbc.getQuantite() == 0.0D) {
/* 402 */         notifs.add("Ligne " + (i + 1) + " : Défaut de quantité ; ");
/*     */       }
/* 404 */       else if (montant > lbc.getElementcout().getPrixunitaire()) {
/* 405 */         double reste = montant - lbc.getElementcout().getPrixunitaire();
/* 406 */         if (reste > pourcentage) {
/* 407 */           notifs.add("Ligne " + (i + 1) + " : Le prix Maximal est : " + (lbc.getElementcout().getPrixunitaire() + pourcentage) + " ; ");
/*     */         }
/* 409 */       } else if (montant < lbc.getElementcout().getPrixunitaire()) {
/* 410 */         double reste = lbc.getElementcout().getPrixunitaire() - montant;
/* 411 */         if (reste > pourcentage) {
/* 412 */           notifs.add("Ligne " + (i + 1) + " : Le prix Minimal est : " + (lbc.getElementcout().getPrixunitaire() - pourcentage) + " ; ");
/*     */         }
/*     */       } 
/*     */       
/* 416 */       i++;
/*     */     } 
/* 418 */     return notifs;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void save() {
/*     */     try {
/* 424 */       if ("Create".equals(this.mode)) {
/*     */         
/* 426 */         this.renderedNotif = false;
/* 427 */         this.notif.clear();
/* 428 */         updateTotal();
/* 429 */         this.notif = notifyChecking();
/* 430 */         if (!this.notif.isEmpty()) {
/* 431 */           this.renderedNotif = true;
/* 432 */           JsfUtil.addWarningMessage("Les prix sont incorrects par rapport aux references mercuriales");
/*     */           
/*     */           return;
/*     */         } 
/* 436 */         if (this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue() > this.moyens.getCt().doubleValue()) {
/* 437 */           JsfUtil.addWarningMessage("Montant insuffisant pour engager ce bon de commande");
/*     */           
/*     */           return;
/*     */         } 
/* 441 */         this.boncommande.setCode(Utilitaires.generateDENumero(this.boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), SessionMBean.getAnnee().getNom()));
/* 442 */         if (this.boncommandeFacadeLocal.findByCode(this.structure.getIdstructure(), this.boncommande.getCode()) == null) {
/*     */           
/* 444 */           this.boncommande.setIdboncommande(Long.valueOf(this.boncommandeFacadeLocal.nextId()));
/* 445 */           this.boncommande.setStructure(this.structure);
/* 446 */           this.boncommande.setSignataire(this.signataire);
/* 447 */           this.boncommande.setImputation(this.imputation);
/* 448 */           this.boncommande.setBudget(SessionMBean.getBudget());
/* 449 */           this.boncommande.setSociete(this.societe);
/* 450 */           this.boncommande.setMoyens(this.moyens);
/* 451 */           this.boncommande.setTaxeOrdonne(0.0D);
/* 452 */           this.boncommande.setNapOrdonne(0.0D);
/* 453 */           if (this.boncommande.getDelailivraison() > 0) {
/* 454 */             this.boncommande.setDatelivraison(Utilitaires.addDayToDate(this.boncommande.getDateemission(), this.boncommande.getDelailivraison()));
/*     */           }
/*     */           
/* 457 */           this.boncommande.setEngage(true);
/* 458 */           this.boncommandeFacadeLocal.create(this.boncommande);
/*     */           
/* 460 */           for (Lignedecision ld : this.lignedecisions) {
/* 461 */             ld.setIdligneDecision(Long.valueOf(this.lignedecisionFacadeLocal.nextId()));
/* 462 */             ld.setBoncommande(this.boncommande);
/* 463 */             this.lignedecisionFacadeLocal.create(ld);
/*     */           } 
/*     */           
/* 466 */           this.moyens.setMontantexecute(Double.valueOf(this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 467 */           this.moyensFacadeLocal.edit(this.moyens);
/*     */           
/* 469 */           this.moyens.getIdtache().setCpconsommee(Double.valueOf(this.moyens.getIdtache().getCpconsommee().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 470 */           this.moyens.getIdtache().setMontantengage(this.moyens.getIdtache().getMontantengage() + this.boncommande.getTtc().doubleValue());
/* 471 */           this.tacheFacadeLocal.edit(this.moyens.getIdtache());
/*     */           
/* 473 */           this.boncommande = new Boncommande();
/* 474 */           this.signataire = new Signataire();
/* 475 */           this.structure = new Structure();
/* 476 */           this.detail = true;
/* 477 */           RequestContext.getCurrentInstance().execute("PF('DecisionCreateDialog').hide()");
/* 478 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 480 */           JsfUtil.addErrorMessage("Un bon de commande ayant cette reference existe dejà");
/*     */         } 
/* 482 */       } else if ("Edit".equals(this.mode)) {
/* 483 */         if (this.boncommande != null) {
/*     */           
/* 485 */           updateTotal();
/*     */           
/* 487 */           if (this.boncommande.getDelailivraison() > 0) {
/* 488 */             this.boncommande.setDatelivraison(Utilitaires.addDayToDate(this.boncommande.getDateemission(), this.boncommande.getDelailivraison()));
/*     */           }
/* 490 */           this.boncommande.setSociete(this.societeFacadeLocal.find(this.societe.getIdsociete()));
/* 491 */           this.boncommande.setSignataire(this.signataireFacadeLocal.find(this.signataire.getIdsignataire()));
/* 492 */           this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */           
/* 494 */           for (Lignedecision ld : this.lignedecisions) {
/* 495 */             if (ld.getIdligneDecision().longValue() == 0L) {
/* 496 */               ld.setIdligneDecision(Long.valueOf(this.ligneboncommandeFacadeLocal.nextId()));
/* 497 */               ld.setBoncommande(this.boncommande);
/* 498 */               this.lignedecisionFacadeLocal.create(ld); continue;
/*     */             } 
/* 500 */             this.lignedecisionFacadeLocal.edit(ld);
/*     */           } 
/*     */ 
/*     */           
/* 504 */           Boncommande b = this.boncommandeFacadeLocal.find(this.boncommande.getIdboncommande());
/* 505 */           if (b.getTtc() != this.boncommande.getTtc()) {
/*     */             
/* 507 */             Moyens m = this.boncommande.getMoyens();
/* 508 */             m.setMontantexecute(Double.valueOf(m.getMontantexecute().doubleValue() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 509 */             this.moyensFacadeLocal.edit(m);
/*     */             
/* 511 */             Tache t = this.boncommande.getMoyens().getIdtache();
/* 512 */             t.setCpconsommee(Double.valueOf(t.getCpconsommee().doubleValue() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 513 */             t.setMontantengage(t.getMontantengage() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue());
/* 514 */             this.tacheFacadeLocal.edit(t);
/*     */           } 
/*     */           
/* 517 */           this.boncommande = new Boncommande();
/* 518 */           this.signataire = new Signataire();
/* 519 */           this.structure = new Structure();
/* 520 */           this.detail = true;
/* 521 */           RequestContext.getCurrentInstance().execute("PF('DecisionCreateDialog').hide()");
/* 522 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 524 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 527 */     } catch (Exception e) {
/* 528 */       e.printStackTrace();
/* 529 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 536 */       if (this.boncommande != null) {
/*     */         
/* 538 */         if (!Utilitaires.isAccess(Long.valueOf(25L))) {
/* 539 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler une décision");
/*     */           
/*     */           return;
/*     */         } 
/* 543 */         if (this.boncommande.isPaye()) {
/* 544 */           JsfUtil.addErrorMessage("Cette décision est dejà payée");
/*     */           
/*     */           return;
/*     */         } 
/* 548 */         this.lignedecisionFacadeLocal.deleteByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/* 549 */         this.boncommandeFacadeLocal.remove(this.boncommande);
/*     */         
/* 551 */         Moyens m = this.boncommande.getMoyens();
/* 552 */         m.setMontantexecute(Double.valueOf(m.getMontantexecute().doubleValue() - this.boncommande.getTtc().doubleValue()));
/* 553 */         if (this.boncommande.isLiquide()) {
/* 554 */           m.setMontantLiquide(m.getMontantLiquide() - this.boncommande.getTtc().doubleValue());
/*     */         }
/* 556 */         this.moyensFacadeLocal.edit(m);
/*     */         
/* 558 */         Tache t = this.boncommande.getMoyens().getIdtache();
/* 559 */         t.setCpconsommee(Double.valueOf(t.getCpconsommee().doubleValue() - this.boncommande.getTtc().doubleValue()));
/* 560 */         t.setMontantengage(t.getMontantengage() - this.boncommande.getTtc().doubleValue());
/*     */         
/* 562 */         if (this.boncommande.isPaye()) {
/* 563 */           t.setMontantpayettc(t.getMontantpayettc() - this.boncommande.getTtc().doubleValue());
/* 564 */           t.setMontantpayeht(t.getMontantpayeht() - this.boncommande.getNetapayer());
/*     */         } 
/* 566 */         this.tacheFacadeLocal.edit(t);
/*     */         
/* 568 */         this.boncommande = new Boncommande();
/* 569 */         this.detail = true;
/* 570 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 572 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 574 */     } catch (Exception e) {
/* 575 */       e.printStackTrace();
/* 576 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 582 */       this.moyenses.clear();
/* 583 */       if (this.tache != null) {
/* 584 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/* 585 */         if (!this.moyenses.isEmpty() && 
/* 586 */           this.moyenses.size() == 1) {
/* 587 */           this.imputation = ((Moyens)this.moyenses.get(0)).getIdimputation();
/* 588 */           this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/*     */         }
/*     */       
/*     */       } 
/* 592 */     } catch (Exception e) {
/* 593 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateImputationData() {
/* 598 */     if (this.moyens != null) {
/* 599 */       this.imputation = this.moyens.getIdimputation();
/* 600 */       this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 606 */       if (this.imputation.getIdimputation() != null && 
/* 607 */         this.structure.getIdstructure() != null) {
/* 608 */         this.imputation = this.imputationFacadeLocal.find(this.imputation.getIdimputation());
/* 609 */         this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/* 610 */         this.taches.clear();
/* 611 */         this.moyens = new Moyens();
/* 612 */         List<Moyens> moyenses = this.moyensFacadeLocal.findByStructureAnneeIdimputation(this.structure.getIdstructure(), SessionMBean.getAnnee().getIdannee(), this.imputation.getIdimputation());
/* 613 */         if (!moyenses.isEmpty()) {
/* 614 */           for (Moyens m : moyenses) {
/* 615 */             if (!this.taches.contains(m.getIdtache())) {
/* 616 */               this.taches.add(m.getIdtache());
/*     */             }
/*     */           }
/*     */         
/*     */         }
/*     */       } 
/* 622 */     } catch (Exception e) {
/* 623 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMP1() {
/* 628 */     if (this.boncommande.isCheque()) {
/* 629 */       this.boncommande.setVirement(false);
/* 630 */       this.boncommande.setEspece(false);
/*     */     } 
/* 632 */     initModePayement();
/*     */   }
/*     */   
/*     */   public void updateMP2() {
/* 636 */     if (this.boncommande.isEspece()) {
/* 637 */       this.boncommande.setCheque(false);
/* 638 */       this.boncommande.setVirement(false);
/*     */     } 
/* 640 */     initModePayement();
/*     */   }
/*     */   
/*     */   public void updateMP3() {
/* 644 */     if (this.boncommande.isVirement()) {
/* 645 */       this.boncommande.setCheque(false);
/* 646 */       this.boncommande.setEspece(false);
/*     */     } 
/* 648 */     initModePayement();
/*     */   }
/*     */   
/*     */   private void initModePayement() {
/* 652 */     if (!this.boncommande.isCheque() && !this.boncommande.isVirement() && !this.boncommande.isEspece()) {
/* 653 */       this.boncommande.setVirement(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void print() {
/*     */     try {
/* 659 */       if (!Utilitaires.isAccess(Long.valueOf(18L))) {
/* 660 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engagement");
/*     */         
/*     */         return;
/*     */       } 
/* 664 */       Map<Object, Object> parameter = new HashMap<>();
/* 665 */       parameter.put("idboncommande", this.boncommande.getIdboncommande());
/* 666 */       parameter.put("logo", SessionMBean.getLogo());
/* 667 */       Printer p = new Printer();
/* 668 */       p.print("/rapport/report_camer_soft/certificat_engagement.jasper", parameter);
/* 669 */     } catch (Exception e) {
/* 670 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 675 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 679 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 683 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 687 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 691 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 695 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 699 */     this.signataires = this.signataireFacadeLocal.findAllRangeEtatInstitutionIsActif();
/* 700 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 704 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 708 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 712 */     this.structures = this.structureFacadeLocal.findAllRangeEtatInstitutionIsActif();
/* 713 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 717 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 721 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 725 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 729 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeDec(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 730 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 734 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 738 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 742 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public List<Elementcout> getElementcouts() {
/* 746 */     return this.elementcouts;
/*     */   }
/*     */   
/*     */   public void setElementcouts(List<Elementcout> elementcouts) {
/* 750 */     this.elementcouts = elementcouts;
/*     */   }
/*     */   
/*     */   public List<Elementcout> getSelectedElementcouts() {
/* 754 */     return this.selectedElementcouts;
/*     */   }
/*     */   
/*     */   public void setSelectedElementcouts(List<Elementcout> selectedElementcouts) {
/* 758 */     this.selectedElementcouts = selectedElementcouts;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 762 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 766 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 770 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 771 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 775 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 779 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 783 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Societe> getSocietes() {
/* 787 */     this.societes = this.societeFacadeLocal.findAllRange();
/* 788 */     return this.societes;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 792 */     return this.mode;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 796 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 800 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 804 */     return this.taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 808 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 812 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 816 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 820 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Sousrubriquemercurial getSousrubriquemercurial() {
/* 824 */     return this.sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
/* 828 */     this.sousrubriquemercurial = sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Sousrubriquemercurial> getSousrubriquemercurials() {
/* 832 */     return this.sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public Rubriquemercurial getRubriquemercurial() {
/* 836 */     return this.rubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurial(Rubriquemercurial rubriquemercurial) {
/* 840 */     this.rubriquemercurial = rubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Rubriquemercurial> getRubriquemercurials() {
/* 844 */     this.rubriquemercurials = this.rubriquemercurialFacadeLocal.findAllRange();
/* 845 */     return this.rubriquemercurials;
/*     */   }
/*     */   
/*     */   public List<String> getNotif() {
/* 849 */     return this.notif;
/*     */   }
/*     */   
/*     */   public boolean isRenderedNotif() {
/* 853 */     return this.renderedNotif;
/*     */   }
/*     */   
/*     */   public Lignedecision getLignedecision() {
/* 857 */     return this.lignedecision;
/*     */   }
/*     */   
/*     */   public void setLignedecision(Lignedecision lignedecision) {
/* 861 */     this.lignedecision = lignedecision;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisions() {
/* 865 */     return this.lignedecisions;
/*     */   }
/*     */   
/*     */   public void setLignedecisions(List<Lignedecision> lignedecisions) {
/* 869 */     this.lignedecisions = lignedecisions;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\DecisionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */