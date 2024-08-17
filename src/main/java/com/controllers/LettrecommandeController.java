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
/*     */ import javax.annotation.PostConstruct;
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
/*     */ public class LettrecommandeController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  65 */   private Boncommande boncommande = new Boncommande();
/*  66 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneboncommandeFacadeLocal ligneboncommandeFacadeLocal;
/*  70 */   private List<Ligneboncommande> ligneboncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LignedecisionFacadeLocal lignedecisionFacadeLocal;
/*  74 */   private Lignedecision lignedecision = new Lignedecision();
/*  75 */   private List<Lignedecision> lignedecisions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ElementcoutFacadeLocal elementcoutFacadeLocal;
/*  79 */   private List<Elementcout> elementcouts = new ArrayList<>();
/*  80 */   private List<Elementcout> selectedElementcouts = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  84 */   private Signataire signataire = new Signataire();
/*  85 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  89 */   private Structure structure = new Structure();
/*  90 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  94 */   private Imputation imputation = new Imputation();
/*  95 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SocieteFacadeLocal societeFacadeLocal;
/*  99 */   private Societe societe = new Societe();
/* 100 */   private List<Societe> societes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/* 104 */   protected Tache tache = new Tache();
/* 105 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/* 109 */   protected Moyens moyens = new Moyens();
/* 110 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SousrubriquemercurialFacadeLocal sousrubriquemercurialFacadeLocal;
/* 114 */   private Sousrubriquemercurial sousrubriquemercurial = new Sousrubriquemercurial();
/* 115 */   private List<Sousrubriquemercurial> sousrubriquemercurials = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RubriquemercurialFacadeLocal rubriquemercurialFacadeLocal;
/* 119 */   private Rubriquemercurial rubriquemercurial = new Rubriquemercurial();
/* 120 */   private List<Rubriquemercurial> rubriquemercurials = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*     */   
/* 125 */   private String mode = "";
/* 126 */   private List<String> notif = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean renderedNotif = false;
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void load() {
/* 139 */     this.elementcouts = this.elementcoutFacadeLocal.findAllRange();
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/* 143 */     if (SessionMBean.getBudget() != null) {
/*     */       
/* 145 */       if (!Utilitaires.isAccess(Long.valueOf(20L))) {
/* 146 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de saisir une lettre commande");
/*     */         
/*     */         return;
/*     */       } 
/* 150 */       this.mode = "Create";
/* 151 */       this.ligneboncommandes.clear();
/* 152 */       this.notif.clear();
/* 153 */       this.taches.clear();
/* 154 */       this.moyenses.clear();
/* 155 */       this.moyens = new Moyens();
/* 156 */       this.moyens.setCt(Double.valueOf(0.0D));
/* 157 */       this.moyens.setMontantexecute(Double.valueOf(0.0D));
/* 158 */       this.tache = new Tache();
/* 159 */       this.societe = new Societe();
/* 160 */       this.signataire = new Signataire();
/* 161 */       this.structure = new Structure();
/* 162 */       this.imputation = new Imputation();
/* 163 */       this.boncommande = new Boncommande();
/* 164 */       this.boncommande.setAvance(0.0D);
/* 165 */       this.boncommande.setTotalht(0.0D);
/* 166 */       this.boncommande.setTotalair(0.0D);
/* 167 */       this.boncommande.setMontantenlettre("-");
/* 168 */       this.boncommande.setReference("-");
/* 169 */       this.boncommande.setCoefficientreducteur(SessionMBean.getParametrage().getPourcentagemercurial());
/* 170 */       this.boncommande.setDelailivraison(15);
/* 171 */       this.boncommande.setVerif(false);
/* 172 */       this.boncommande.setNombreverif(0);
/* 173 */       this.boncommande.setValide(false);
/* 174 */       this.boncommande.setEngage(true);
/*     */       
/* 176 */       this.boncommande.setImputations("-");
/*     */       
/* 178 */       this.boncommande.setBc(false);
/* 179 */       this.boncommande.setMission(false);
/* 180 */       this.boncommande.setLettrecommande(true);
/* 181 */       this.boncommande.setDecision(false);
/* 182 */       this.boncommande.setGreAgre(true);
/*     */       
/* 184 */       this.boncommande.setEspece(false);
/* 185 */       this.boncommande.setVirement(true);
/* 186 */       this.boncommande.setCheque(false);
/*     */       
/* 188 */       this.boncommande.setPaye(false);
/* 189 */       this.boncommande.setAttentepayement(false);
/*     */       
/* 191 */       this.boncommande.setCode(Utilitaires.generateLCNumero(this.boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), SessionMBean.getAnnee().getNom()));
/*     */       
/* 193 */       if (SessionMBean.getParametrage() != null) {
/* 194 */         this.boncommande.setTauxtva(SessionMBean.getParametrage().getTauxtva());
/* 195 */         this.boncommande.setTauxair(SessionMBean.getParametrage().getTauxair());
/*     */       } else {
/* 197 */         this.boncommande.setTauxair(5.5D);
/* 198 */         this.boncommande.setTauxtva(19.25D);
/*     */       } 
/*     */       
/* 201 */       this.lignedecisions.clear();
/*     */       
/* 203 */       RequestContext.getCurrentInstance().execute("PF('LettrecommandeCreateDialog').show()");
/*     */     } else {
/* 205 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 210 */     if (this.boncommande != null) {
/*     */       
/* 212 */       if (!Utilitaires.isAccess(Long.valueOf(20L))) {
/* 213 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier une lettre commande");
/*     */         
/*     */         return;
/*     */       } 
/* 217 */       if (this.boncommande.isValide()) {
/* 218 */         JsfUtil.addWarningMessage("Operation impossible; Cette Lettre commande est deja validée");
/*     */         
/*     */         return;
/*     */       } 
/* 222 */       this.taches.clear();
/* 223 */       this.moyenses.clear();
/*     */       
/* 225 */       this.structure = this.boncommande.getStructure();
/* 226 */       this.imputation = this.boncommande.getImputation();
/* 227 */       this.signataire = this.boncommande.getSignataire();
/*     */       
/* 229 */       this.societe = this.boncommande.getSociete();
/*     */ 
/*     */       
/* 232 */       if (this.boncommande.isGreAgre()) {
/* 233 */         this.ligneboncommandes = this.ligneboncommandeFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         
/* 235 */         this.selectedElementcouts.clear();
/* 236 */         for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 237 */           this.selectedElementcouts.add(lbc.getElementcout());
/*     */         }
/*     */       } else {
/* 240 */         this.lignedecisions = this.lignedecisionFacadeLocal.findByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */       } 
/*     */       
/* 243 */       this.tache = this.boncommande.getMoyens().getIdtache();
/* 244 */       this.moyens = this.boncommande.getMoyens();
/*     */       
/* 246 */       this.taches.add(this.boncommande.getMoyens().getIdtache());
/* 247 */       this.moyenses.add(this.boncommande.getMoyens());
/*     */       
/* 249 */       this.mode = "Edit";
/* 250 */       RequestContext.getCurrentInstance().execute("PF('LettrecommandeCreateDialog').show()");
/*     */     } else {
/* 252 */       JsfUtil.addFatalErrorMessage("Aucune ligne sélectionnée");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateTache() {
/*     */     try {
/* 258 */       if (this.structure.getIdstructure() != null) {
/* 259 */         this.taches.clear();
/* 260 */         this.imputation = new Imputation();
/* 261 */         this.moyenses.clear();
/* 262 */         this.moyens = new Moyens();
/* 263 */         this.taches = this.tacheFacadeLocal.findByStructureAnnee(this.structure.getIdstructure().longValue(), SessionMBean.getAnnee().getIdannee().longValue());
/*     */         return;
/*     */       } 
/* 266 */       JsfUtil.addWarningMessage("Veuillez selectionner une structure");
/* 267 */     } catch (Exception e) {
/* 268 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 274 */       this.moyenses.clear();
/* 275 */       if (this.tache != null) {
/* 276 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/* 277 */         if (!this.moyenses.isEmpty() && 
/* 278 */           this.moyenses.size() == 1) {
/* 279 */           this.imputation = ((Moyens)this.moyenses.get(0)).getIdimputation();
/* 280 */           this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/*     */         }
/*     */       
/*     */       } 
/* 284 */     } catch (Exception e) {
/* 285 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateImputationData() {
/* 290 */     if (this.moyens != null) {
/* 291 */       this.imputation = this.moyens.getIdimputation();
/* 292 */       this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void resetLcData() {
/* 297 */     this.boncommande.setTotalht(0.0D);
/* 298 */     this.boncommande.setTtc(Double.valueOf(0.0D));
/* 299 */     this.boncommande.setTva(0.0D);
/* 300 */     this.boncommande.setTotalair(0.0D);
/* 301 */     this.boncommande.setNetapayer(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareAddReferences() {
/* 309 */     RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareAddElements() {
/* 313 */     this.lignedecision = new Lignedecision();
/* 314 */     this.lignedecision.setQuantite(1);
/* 315 */     RequestContext.getCurrentInstance().execute("PF('ElementCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void removeElement(Ligneboncommande l) {
/* 319 */     int i = 0;
/* 320 */     for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 321 */       if (lbc.getElementcout().equals(l.getElementcout())) {
/* 322 */         if (l.getIdligneboncommande().longValue() != 0L) {
/* 323 */           this.ligneboncommandeFacadeLocal.remove(lbc);
/*     */         }
/* 325 */         this.ligneboncommandes.remove(i);
/*     */         break;
/*     */       } 
/* 328 */       i++;
/*     */     } 
/* 330 */     updateTotal();
/*     */   }
/*     */   
/*     */   public void removeElementC(Lignedecision l) {
/* 334 */     int i = 0;
/* 335 */     for (Lignedecision ldc : this.lignedecisions) {
/* 336 */       if (ldc.getCode().equals(l.getCode())) {
/* 337 */         if (l.getIdligneDecision().longValue() != 0L) {
/* 338 */           this.lignedecisionFacadeLocal.remove(ldc);
/*     */         }
/* 340 */         this.lignedecisions.remove(i);
/*     */         break;
/*     */       } 
/* 343 */       i++;
/*     */     } 
/* 345 */     updateTotal();
/*     */   }
/*     */   
/*     */   public void addElement() {
/* 349 */     for (Elementcout e : this.selectedElementcouts) {
/* 350 */       if (!checkIfExistElementInLigne(e)) {
/* 351 */         Ligneboncommande l = new Ligneboncommande();
/* 352 */         l.setIdligneboncommande(Long.valueOf(0L));
/* 353 */         l.setElementcout(e);
/* 354 */         l.setPrixunitaire(0.0D);
/* 355 */         l.setQuantite(0.0D);
/* 356 */         l.setTotal(0.0D);
/* 357 */         l.setPrixunitaire(e.getPrixunitaire());
/* 358 */         l.setPrixmercurial(e.getPrixunitaire());
/* 359 */         this.ligneboncommandes.add(l);
/*     */       } 
/*     */     } 
/*     */     
/* 363 */     RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').hide()");
/* 364 */     JsfUtil.addSuccessMessage("Ajout avec succès");
/*     */   }
/*     */   
/*     */   public void addElementCout() {
/* 368 */     Lignedecision ld = this.lignedecision;
/* 369 */     ld.setIdligneDecision(Long.valueOf(0L));
/* 370 */     ld.setCode("" + this.lignedecisions.size() + '\001');
/* 371 */     ld.setTotal(ld.getCoutunitaire() * ld.getQuantite());
/* 372 */     this.lignedecisions.add(ld);
/* 373 */     updateTotal();
/* 374 */     RequestContext.getCurrentInstance().execute("PF('ElementCreateDialog').hide()");
/* 375 */     JsfUtil.addSuccessMessage("Ajout avec succès");
/*     */   }
/*     */   
/*     */   private boolean checkIfExistElementInLigne(Elementcout elementcout) {
/* 379 */     boolean result = false;
/* 380 */     for (Ligneboncommande l : this.ligneboncommandes) {
/* 381 */       if (l.getElementcout().equals(elementcout)) {
/* 382 */         result = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 386 */     return result;
/*     */   }
/*     */   
/*     */   public void updateTotal() {
/* 390 */     double value_ht = 0.0D;
/* 391 */     int i = 0;
/*     */     
/* 393 */     if (this.boncommande.isGreAgre()) {
/* 394 */       for (Ligneboncommande l : this.ligneboncommandes) {
/* 395 */         value_ht += l.getPrixunitaire() * l.getQuantite();
/* 396 */         ((Ligneboncommande)this.ligneboncommandes.get(i)).setTotal(l.getPrixunitaire() * l.getQuantite());
/* 397 */         i++;
/*     */       } 
/*     */     } else {
/* 400 */       for (Lignedecision ld : this.lignedecisions) {
/* 401 */         value_ht += ld.getCoutunitaire() * ld.getQuantite();
/* 402 */         ((Lignedecision)this.lignedecisions.get(i)).setTotal(ld.getCoutunitaire() * ld.getQuantite());
/* 403 */         i++;
/*     */       } 
/*     */     } 
/*     */     
/* 407 */     this.boncommande.setTotalht(value_ht);
/* 408 */     this.boncommande.setTva(value_ht * this.boncommande.getTauxtva() / 100.0D);
/* 409 */     this.boncommande.setTotalair(value_ht * this.boncommande.getTauxair() / 100.0D);
/* 410 */     this.boncommande.setTtc(Double.valueOf(value_ht + this.boncommande.getTva()));
/* 411 */     this.boncommande.setNetapayer(value_ht - this.boncommande.getTotalair());
/*     */     
/* 413 */     String montantEnLettre = Convert.FR("" + this.boncommande.getTtc().intValue());
/* 414 */     this.boncommande.setMontantenlettre(montantEnLettre);
/*     */   }
/*     */   
/*     */   public void updateSousRubiqueM() {
/*     */     try {
/* 419 */       this.sousrubriquemercurials.clear();
/* 420 */       this.elementcouts.clear();
/* 421 */       if (this.rubriquemercurial.getIdrubriquemercurial() != null) {
/* 422 */         this.sousrubriquemercurials = this.sousrubriquemercurialFacadeLocal.findByIdrubrique(this.rubriquemercurial.getIdrubriquemercurial().intValue());
/*     */         
/* 424 */         this.elementcouts = this.elementcoutFacadeLocal.findByIdrubrique(this.rubriquemercurial.getIdrubriquemercurial().intValue());
/*     */       } 
/* 426 */     } catch (Exception e) {
/* 427 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateReference() {
/*     */     try {
/* 433 */       this.elementcouts.clear();
/* 434 */       if (this.sousrubriquemercurial.getIdsousrubriquemercurial() != null)
/*     */       {
/* 436 */         this.elementcouts = this.elementcoutFacadeLocal.findByIdsousrubrique(this.sousrubriquemercurial.getIdsousrubriquemercurial().intValue());
/*     */       }
/* 438 */     } catch (Exception e) {
/* 439 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<String> notifyChecking() {
/* 444 */     List<String> notifs = new ArrayList<>();
/* 445 */     int i = 0;
/* 446 */     for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 447 */       double montant = lbc.getPrixunitaire();
/* 448 */       double pourcentage = lbc.getElementcout().getPrixunitaire() * SessionMBean.getParametrage().getPourcentagemercurial() / 100.0D;
/* 449 */       if (lbc.getQuantite() == 0.0D) {
/* 450 */         notifs.add("Ligne " + (i + 1) + " : Défaut de quantité ; ");
/*     */       }
/* 452 */       else if (montant > lbc.getElementcout().getPrixunitaire()) {
/* 453 */         double reste = montant - lbc.getElementcout().getPrixunitaire();
/* 454 */         if (reste > pourcentage) {
/* 455 */           notifs.add("Ligne " + (i + 1) + " : Le prix Maximal est : " + (lbc.getElementcout().getPrixunitaire() + pourcentage) + " ; ");
/*     */         }
/* 457 */       } else if (montant < lbc.getElementcout().getPrixunitaire()) {
/* 458 */         double reste = lbc.getElementcout().getPrixunitaire() - montant;
/* 459 */         if (reste > pourcentage) {
/* 460 */           notifs.add("Ligne " + (i + 1) + " : Le prix Minimal est : " + (lbc.getElementcout().getPrixunitaire() - pourcentage) + " ; ");
/*     */         }
/*     */       } 
/*     */       
/* 464 */       i++;
/*     */     } 
/* 466 */     return notifs;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void save() {
/*     */     try {
/* 472 */       if ("Create".equals(this.mode)) {
/*     */         
/* 474 */         this.renderedNotif = false;
/* 475 */         this.notif.clear();
/* 476 */         updateTotal();
/* 477 */         this.notif = notifyChecking();
/* 478 */         if (!this.notif.isEmpty()) {
/* 479 */           this.renderedNotif = true;
/* 480 */           JsfUtil.addWarningMessage("Les prix sont incorrects par rapport aux references mercuriales");
/*     */           
/*     */           return;
/*     */         } 
/* 484 */         if (this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue() > this.moyens.getCt().doubleValue()) {
/* 485 */           JsfUtil.addWarningMessage("Montant insuffisant pour engager ce bon de commande");
/*     */           
/*     */           return;
/*     */         } 
/* 489 */         this.boncommande.setCode(Utilitaires.generateLCNumero(this.boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), SessionMBean.getAnnee().getNom()));
/*     */         
/* 491 */         if (this.boncommandeFacadeLocal.findByCode(this.structure.getIdstructure(), this.boncommande.getCode()) == null) {
/*     */           
/* 493 */           this.boncommande.setIdboncommande(Long.valueOf(this.boncommandeFacadeLocal.nextId()));
/* 494 */           this.boncommande.setStructure(this.structure);
/* 495 */           this.boncommande.setSignataire(this.signataire);
/* 496 */           this.boncommande.setImputation(this.imputation);
/* 497 */           this.boncommande.setBudget(SessionMBean.getBudget());
/*     */           
/* 499 */           this.boncommande.setSociete(this.societe);
/* 500 */           this.boncommande.setMoyens(this.moyens);
/* 501 */           this.boncommande.setTaxeOrdonne(0.0D);
/* 502 */           this.boncommande.setNapOrdonne(0.0D);
/* 503 */           if (this.boncommande.getDelailivraison() > 0) {
/* 504 */             this.boncommande.setDatelivraison(Utilitaires.addDayToDate(this.boncommande.getDateemission(), this.boncommande.getDelailivraison()));
/*     */           }
/*     */           
/* 507 */           this.boncommande.setEngage(true);
/* 508 */           this.boncommandeFacadeLocal.create(this.boncommande);
/*     */           
/* 510 */           if (this.boncommande.isGreAgre()) {
/* 511 */             for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 512 */               lbc.setIdligneboncommande(Long.valueOf(this.ligneboncommandeFacadeLocal.nextId()));
/* 513 */               lbc.setBoncommande(this.boncommande);
/* 514 */               lbc.setVerif(true);
/* 515 */               lbc.setReference(lbc.getElementcout().getCode());
/* 516 */               this.ligneboncommandeFacadeLocal.create(lbc);
/*     */             } 
/*     */           } else {
/* 519 */             for (Lignedecision ld : this.lignedecisions) {
/* 520 */               ld.setIdligneDecision(Long.valueOf(this.lignedecisionFacadeLocal.nextId()));
/* 521 */               ld.setBoncommande(this.boncommande);
/* 522 */               ld.setVerif(true);
/* 523 */               this.lignedecisionFacadeLocal.create(ld);
/*     */             } 
/*     */           } 
/*     */           
/* 527 */           this.moyens.setMontantexecute(Double.valueOf(this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 528 */           this.moyensFacadeLocal.edit(this.moyens);
/*     */           
/* 530 */           this.moyens.getIdtache().setCpconsommee(Double.valueOf(this.moyens.getIdtache().getCpconsommee().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 531 */           this.moyens.getIdtache().setMontantengage(this.moyens.getIdtache().getMontantengage() + this.boncommande.getTtc().doubleValue());
/* 532 */           this.tacheFacadeLocal.edit(this.moyens.getIdtache());
/*     */           
/* 534 */           this.boncommande = new Boncommande();
/* 535 */           this.signataire = new Signataire();
/* 536 */           this.structure = new Structure();
/* 537 */           this.detail = true;
/* 538 */           RequestContext.getCurrentInstance().execute("PF('LettrecommandeCreateDialog').hide()");
/* 539 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 541 */           JsfUtil.addErrorMessage("Un bon de commande ayant cette reference existe dejà");
/*     */         } 
/* 543 */       } else if ("Edit".equals(this.mode)) {
/* 544 */         if (this.boncommande != null) {
/*     */           
/* 546 */           updateTotal();
/*     */           
/* 548 */           if (this.boncommande.getDelailivraison() > 0) {
/* 549 */             this.boncommande.setDatelivraison(Utilitaires.addDayToDate(this.boncommande.getDateemission(), this.boncommande.getDelailivraison()));
/*     */           }
/* 551 */           this.boncommande.setSociete(this.societeFacadeLocal.find(this.societe.getIdsociete()));
/* 552 */           this.boncommande.setSignataire(this.signataireFacadeLocal.find(this.signataire.getIdsignataire()));
/* 553 */           this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */           
/* 555 */           if (this.boncommande.isGreAgre()) {
/* 556 */             for (Ligneboncommande lbc : this.ligneboncommandes) {
/* 557 */               if (lbc.getIdligneboncommande().longValue() == 0L) {
/* 558 */                 lbc.setIdligneboncommande(Long.valueOf(this.ligneboncommandeFacadeLocal.nextId()));
/* 559 */                 lbc.setBoncommande(this.boncommande);
/* 560 */                 lbc.setReference(lbc.getElementcout().getCode());
/* 561 */                 this.ligneboncommandeFacadeLocal.create(lbc); continue;
/*     */               } 
/* 563 */               this.ligneboncommandeFacadeLocal.edit(lbc);
/*     */             } 
/*     */           } else {
/*     */             
/* 567 */             for (Lignedecision ld : this.lignedecisions) {
/* 568 */               if (ld.getIdligneDecision().longValue() == 0L) {
/* 569 */                 ld.setIdligneDecision(Long.valueOf(this.ligneboncommandeFacadeLocal.nextId()));
/* 570 */                 ld.setBoncommande(this.boncommande);
/* 571 */                 this.lignedecisionFacadeLocal.create(ld); continue;
/*     */               } 
/* 573 */               this.lignedecisionFacadeLocal.edit(ld);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 578 */           Boncommande b = this.boncommandeFacadeLocal.find(this.boncommande.getIdboncommande());
/* 579 */           if (b.getTtc() != this.boncommande.getTtc()) {
/* 580 */             Moyens m = this.boncommande.getMoyens();
/* 581 */             m.setMontantexecute(Double.valueOf(m.getMontantexecute().doubleValue() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 582 */             this.moyensFacadeLocal.edit(m);
/*     */             
/* 584 */             Tache t = this.boncommande.getMoyens().getIdtache();
/* 585 */             t.setCpconsommee(Double.valueOf(t.getCpconsommee().doubleValue() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 586 */             t.setMontantengage(t.getMontantengage() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue());
/* 587 */             this.tacheFacadeLocal.edit(t);
/*     */           } 
/*     */           
/* 590 */           this.boncommande = new Boncommande();
/* 591 */           this.signataire = new Signataire();
/* 592 */           this.structure = new Structure();
/* 593 */           this.detail = true;
/* 594 */           RequestContext.getCurrentInstance().execute("PF('LettrecommandeCreateDialog').hide()");
/* 595 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 597 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 600 */     } catch (Exception e) {
/* 601 */       e.printStackTrace();
/* 602 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 609 */       if (this.boncommande != null) {
/*     */         
/* 611 */         if (!Utilitaires.isAccess(Long.valueOf(21L))) {
/* 612 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler une lettre commande");
/*     */           
/*     */           return;
/*     */         } 
/* 616 */         if (this.boncommande.isPaye()) {
/* 617 */           JsfUtil.addErrorMessage("Cette lettre commande est dejà payée");
/*     */           
/*     */           return;
/*     */         } 
/* 621 */         if (this.boncommande.isGreAgre()) {
/* 622 */           this.ligneboncommandeFacadeLocal.deleteByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         } else {
/* 624 */           this.lignedecisionFacadeLocal.deleteByIdBoncommande(this.boncommande.getIdboncommande().longValue());
/*     */         } 
/* 626 */         this.boncommandeFacadeLocal.remove(this.boncommande);
/*     */         
/* 628 */         Moyens m = this.boncommande.getMoyens();
/* 629 */         m.setMontantexecute(Double.valueOf(m.getMontantexecute().doubleValue() - this.boncommande.getTtc().doubleValue()));
/* 630 */         if (this.boncommande.isLiquide()) {
/* 631 */           m.setMontantLiquide(m.getMontantLiquide() - this.boncommande.getTtc().doubleValue());
/*     */         }
/* 633 */         this.moyensFacadeLocal.edit(m);
/*     */         
/* 635 */         Tache t = this.boncommande.getMoyens().getIdtache();
/* 636 */         t.setCpconsommee(Double.valueOf(t.getCpconsommee().doubleValue() - this.boncommande.getTtc().doubleValue()));
/* 637 */         t.setMontantengage(t.getMontantengage() - this.boncommande.getTtc().doubleValue());
/*     */         
/* 639 */         if (this.boncommande.isPaye()) {
/* 640 */           t.setMontantpayettc(t.getMontantpayettc() - this.boncommande.getTtc().doubleValue());
/* 641 */           t.setMontantpayeht(t.getMontantpayeht() - this.boncommande.getNetapayer());
/*     */         } 
/* 643 */         this.tacheFacadeLocal.edit(t);
/*     */         
/* 645 */         this.boncommande = new Boncommande();
/* 646 */         this.detail = true;
/* 647 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 649 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 651 */     } catch (Exception e) {
/* 652 */       e.printStackTrace();
/* 653 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 659 */       if (this.imputation.getIdimputation() != null && 
/* 660 */         this.structure.getIdstructure() != null) {
/* 661 */         this.imputation = this.imputationFacadeLocal.find(this.imputation.getIdimputation());
/* 662 */         this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/* 663 */         this.taches.clear();
/* 664 */         this.moyens = new Moyens();
/* 665 */         List<Moyens> moyenses = this.moyensFacadeLocal.findByStructureAnneeIdimputation(this.structure.getIdstructure(), SessionMBean.getAnnee().getIdannee(), this.imputation.getIdimputation());
/* 666 */         if (!moyenses.isEmpty()) {
/* 667 */           for (Moyens m : moyenses) {
/* 668 */             if (!this.taches.contains(m.getIdtache())) {
/* 669 */               this.taches.add(m.getIdtache());
/*     */             }
/*     */           }
/*     */         
/*     */         }
/*     */       } 
/* 675 */     } catch (Exception e) {
/* 676 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMP1() {
/* 681 */     if (this.boncommande.isCheque()) {
/* 682 */       this.boncommande.setVirement(false);
/* 683 */       this.boncommande.setEspece(false);
/*     */     } 
/* 685 */     initModePayement();
/*     */   }
/*     */   
/*     */   public void updateMP2() {
/* 689 */     if (this.boncommande.isEspece()) {
/* 690 */       this.boncommande.setCheque(false);
/* 691 */       this.boncommande.setVirement(false);
/*     */     } 
/* 693 */     initModePayement();
/*     */   }
/*     */   
/*     */   public void updateMP3() {
/* 697 */     if (this.boncommande.isVirement()) {
/* 698 */       this.boncommande.setCheque(false);
/* 699 */       this.boncommande.setEspece(false);
/*     */     } 
/* 701 */     initModePayement();
/*     */   }
/*     */   
/*     */   private void initModePayement() {
/* 705 */     if (!this.boncommande.isCheque() && !this.boncommande.isVirement() && !this.boncommande.isEspece()) {
/* 706 */       this.boncommande.setVirement(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void printCe() {
/*     */     try {
/* 713 */       if (!Utilitaires.isAccess(Long.valueOf(18L))) {
/* 714 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engagement");
/*     */         
/*     */         return;
/*     */       } 
/* 718 */       Map<Object, Object> parameter = new HashMap<>();
/* 719 */       parameter.put("idboncommande", this.boncommande.getIdboncommande());
/* 720 */       parameter.put("logo", SessionMBean.getLogo());
/* 721 */       Printer p = new Printer();
/* 722 */       p.print("/rapport/report_camer_soft/certificat_engagement.jasper", parameter);
/* 723 */     } catch (Exception e) {
/* 724 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 729 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 733 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 737 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 741 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 745 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 749 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 753 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 754 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 758 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 762 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 766 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 767 */     return this.structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 771 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 775 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 779 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeLc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 780 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 784 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 788 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public List<Elementcout> getElementcouts() {
/* 792 */     return this.elementcouts;
/*     */   }
/*     */   
/*     */   public void setElementcouts(List<Elementcout> elementcouts) {
/* 796 */     this.elementcouts = elementcouts;
/*     */   }
/*     */   
/*     */   public List<Elementcout> getSelectedElementcouts() {
/* 800 */     return this.selectedElementcouts;
/*     */   }
/*     */   
/*     */   public void setSelectedElementcouts(List<Elementcout> selectedElementcouts) {
/* 804 */     this.selectedElementcouts = selectedElementcouts;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 808 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 812 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 816 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 817 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 821 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 825 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 829 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Societe> getSocietes() {
/* 833 */     this.societes = this.societeFacadeLocal.findAllRange();
/* 834 */     return this.societes;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 838 */     return this.mode;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 842 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 846 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 850 */     return this.taches;
/*     */   }
/*     */   
/*     */   public void setTaches(List<Tache> taches) {
/* 854 */     this.taches = taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 858 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 862 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 866 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 870 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public Sousrubriquemercurial getSousrubriquemercurial() {
/* 874 */     return this.sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
/* 878 */     this.sousrubriquemercurial = sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Sousrubriquemercurial> getSousrubriquemercurials() {
/* 882 */     return this.sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurials(List<Sousrubriquemercurial> sousrubriquemercurials) {
/* 886 */     this.sousrubriquemercurials = sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public Rubriquemercurial getRubriquemercurial() {
/* 890 */     return this.rubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurial(Rubriquemercurial rubriquemercurial) {
/* 894 */     this.rubriquemercurial = rubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Rubriquemercurial> getRubriquemercurials() {
/* 898 */     this.rubriquemercurials = this.rubriquemercurialFacadeLocal.findAllRange();
/* 899 */     return this.rubriquemercurials;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurials(List<Rubriquemercurial> rubriquemercurials) {
/* 903 */     this.rubriquemercurials = rubriquemercurials;
/*     */   }
/*     */   
/*     */   public List<String> getNotif() {
/* 907 */     return this.notif;
/*     */   }
/*     */   
/*     */   public boolean isRenderedNotif() {
/* 911 */     return this.renderedNotif;
/*     */   }
/*     */   
/*     */   public Lignedecision getLignedecision() {
/* 915 */     return this.lignedecision;
/*     */   }
/*     */   
/*     */   public void setLignedecision(Lignedecision lignedecision) {
/* 919 */     this.lignedecision = lignedecision;
/*     */   }
/*     */   
/*     */   public List<Lignedecision> getLignedecisions() {
/* 923 */     return this.lignedecisions;
/*     */   }
/*     */   
/*     */   public void setLignedecisions(List<Lignedecision> lignedecisions) {
/* 927 */     this.lignedecisions = lignedecisions;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\LettrecommandeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */