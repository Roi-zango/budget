/*     */ package controllers;
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Action;
/*     */ import entities.Activite;
/*     */ import entities.Annee;
/*     */ import entities.Bailleurfond;
// /*     */ import entities.CodeAnalytique;
/*     */ import entities.Imputation;
/*     */ import entities.Moyens;
/*     */ import entities.Programme;
/*     */ import entities.Risque;
/*     */ import entities.Structure;
/*     */ import entities.Tache;
/*     */ import entities.Typefinancement;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ActionFacadeLocal;
/*     */ import sessions.ActiviteFacadeLocal;
/*     */ import sessions.AnneeFacadeLocal;
/*     */ import sessions.BailleurfondFacadeLocal;
// /*     */ import sessions.CodeAnalytiqueFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.ProgrammeFacadeLocal;
/*     */ import sessions.RisqueFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import sessions.TypefinancementFacadeLocal;
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
/*     */ @SessionScoped
/*     */ public class TacheController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private AnneeFacadeLocal anneeFacadeLocal;
/*  59 */   private Annee annee = SessionMBean.getAnnee();
/*     */   
/*     */   @EJB
/*     */   private TacheFacadeLocal tacheFacadeLocal;
/*  63 */   private Tache tache = new Tache();
/*  64 */   private List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private static final Logger logger = LoggerFactory.getLogger(TacheController.class);
/*     */   private ProgrammeFacadeLocal programmeFacadeLocal;
/*  68 */   private Programme programme = new Programme();
/*  69 */   private List<Programme> programmes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ActiviteFacadeLocal activiteFacadeLocal;
/*  73 */   private Activite activite = new Activite();
/*  74 */   private List<Activite> activites = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ActionFacadeLocal actionFacadeLocal;
/*  78 */   private Action action = new Action();
/*  79 */   private List<Action> actions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  83 */   private Structure structure = new Structure();
/*  84 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private TypefinancementFacadeLocal typefinancementFacadeLocal;
/*  88 */   private Typefinancement typefinancement = new Typefinancement();
/*  89 */   private List<Typefinancement> typefinancements = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BailleurfondFacadeLocal bailleurfondFacadeLocal;
/*  93 */   private Bailleurfond bailleurfond = new Bailleurfond();
/*  94 */   private List<Bailleurfond> bailleurfonds = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RisqueFacadeLocal risqueFacadeLocal;
/*  98 */   private Risque risque = new Risque();
/*  99 */   private List<Risque> risques = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private MoyensFacadeLocal moyensFacadeLocal;
/* 103 */   private Moyens moyens = new Moyens();
/* 104 */   private List<Moyens> moyenses = new ArrayList<>();
/* 105 */   private List<Moyens> moyenses1 = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/* 109 */   private Imputation imputation = new Imputation();
/* 110 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
// /*     */   private CodeAnalytiqueFacadeLocal codeAnalytiqueFacadeLocal;
// /* 114 */   private CodeAnalytique codeAnalytique = new CodeAnalytique();
// /* 115 */   private List<CodeAnalytique> codeAnalytiques = new ArrayList<>();
/*     */   
/*     */   private boolean detail = true;
/*     */   
/* 119 */   private String mode = "";
/*     */   
/* 121 */   private String mode1 = "";
/*     */   
/* 123 */   private Double total = Double.valueOf(0.0D);
/*     */   
/* 125 */   private Integer ann = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void init() {
/* 136 */     this.moyens = new Moyens();
/* 137 */     this.imputation = new Imputation();
/* 138 */     this.imputationFacadeLocal.findAll();
/*     */     try {
/* 140 */       this.ann = Integer.valueOf(Integer.parseInt(this.annee.getNom()));
/* 141 */     } catch (Exception e) {
/* 142 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 147 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 151 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public void prepareCreateTache() {
/* 155 */     if (!Utilitaires.isAccess(Long.valueOf(15L))) {
/* 156 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de saisir une tache");
/*     */       
/*     */       return;
/*     */     } 
/* 160 */     this.mode = "Create";
// /* 161 */     this.codeAnalytique = new CodeAnalytique();
/* 162 */     this.moyenses.clear();
/* 163 */     this.moyenses1.clear();
/*     */     
/* 165 */     this.total = Double.valueOf(0.0D);
/* 166 */     initTcahe();
/* 167 */     RequestContext.getCurrentInstance().execute("PF('TacheCreateDialog').show()");
/*     */   }
/*     */   
/*     */   private void initTcahe() {
/* 171 */     this.programme = new Programme();
/* 172 */     this.activite = new Activite();
/* 173 */     this.tache = new Tache();
/* 174 */     this.tache.setIndicateurresult("-");
/* 175 */     this.tache.setResultprocess("-");
/* 176 */     this.tache.setTotalmontantaloue(Double.valueOf(0.0D));
/* 177 */     this.tache.setCpanneeplus1(0.0D);
/* 178 */     this.tache.setCpconsommee(Double.valueOf(0.0D));
/*     */     
/* 180 */     this.typefinancement = new Typefinancement(Long.valueOf(1L));
/* 181 */     this.bailleurfond = new Bailleurfond(Long.valueOf(1L));
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareEdit() {
/*     */     try {
/* 187 */       if (!Utilitaires.isAccess(Long.valueOf(15L))) {
/* 188 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les taches");
/*     */         
/*     */         return;
/*     */       } 
/* 192 */       if (this.tache != null) {
/*     */         
/* 194 */         this.mode = "Edit";
/*     */         
/* 196 */         if (this.tache.getIdtypefinancement() != null) {
/* 197 */           this.typefinancement = this.tache.getIdtypefinancement();
/*     */         }
/*     */         
/* 200 */         if (this.tache.getIdbailleurfond() != null) {
/* 201 */           this.bailleurfond = this.tache.getIdbailleurfond();
/*     */         }
/*     */         
// /* 204 */         this.codeAnalytique = this.tache.getCodeAnalytique();
/* 205 */         this.activite = this.tache.getIdactivite();
/* 206 */         this.structure = this.tache.getIdstructure();
/* 207 */         this.action = this.activite.getIdaction();
/* 208 */         this.programme = this.action.getIdprogramme();
/*     */         
/* 210 */         if (this.tache.getIdrisque() != null) {
/* 211 */           this.risque = this.tache.getIdrisque();
/*     */         }
/*     */         
/* 214 */         if (this.tache.getTotalmontantaloue() != null) {
/* 215 */           this.total = this.tache.getTotalmontantaloue();
/*     */         }
/*     */         
/* 218 */         filterAction();
/* 219 */         filterActivite();
/*     */         
/* 221 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/* 222 */         RequestContext.getCurrentInstance().execute("PF('TacheCreateDialog').show()");
/*     */       } 
/* 224 */     } catch (Exception e) {
/* 225 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void initActivite() {
/*     */     try {
/* 231 */       if (this.activite.getIdactivite() != null) {
/* 232 */         this.activite = this.activiteFacadeLocal.find(this.activite.getIdactivite());
/*     */       }
/* 234 */     } catch (Exception e) {
/* 235 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String formatter(Double valeur) {
/* 240 */     return Utilitaires.formaterStringMoney(valeur);
/*     */   }
/*     */   
/*     */   public String formatter(Long valeur) {
/* 244 */     return Utilitaires.formaterStringMoney(valeur);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addParagraphe() {
/*     */     try {
/* 250 */       this.imputation = this.imputationFacadeLocal.find(this.imputation.getIdimputation());
/* 251 */       if ("Create".equals(this.mode)) {
/*     */         
/* 253 */         Moyens m = new Moyens();
/* 254 */         m = this.moyens;
/* 255 */         m.setIdimputation(this.imputation);
/* 256 */         m.setCt(Double.valueOf(m.getQte().doubleValue() * m.getCu().doubleValue()));
/*     */         
/* 258 */         boolean drapeau = false;
/* 259 */         for (Moyens m1 : this.moyenses) {
/* 260 */           if (m1.getIdimputation().getIdimputation().equals(m.getIdimputation().getIdimputation())) {
/* 261 */             drapeau = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 266 */         if (!drapeau) {
/* 267 */           this.moyenses.add(m);
/* 268 */           JsfUtil.addSuccessMessage("Tache ajoutée avec succès");
/*     */         } else {
/* 270 */           JsfUtil.addErrorMessage("Cet imputation est deja dans la liste");
/*     */         } 
/*     */         
/* 273 */         this.total = calculTotal(this.moyenses);
/*     */         
/* 275 */         m = new Moyens();
/* 276 */         this.moyens = new Moyens();
/* 277 */         this.imputation = new Imputation();
/* 278 */         RequestContext.getCurrentInstance().execute("PF('ParagrapheCreateDialog').hide()");
/*     */       } else {
/*     */         
/* 281 */         Moyens m = new Moyens();
/* 282 */         m = this.moyens;
/* 283 */         m.setIdimputation(this.imputation);
/*     */         
/* 285 */         m.setCt(Double.valueOf(m.getQte().doubleValue() * m.getCu().doubleValue()));
/*     */         
/* 287 */         boolean drapeau = false;
/* 288 */         for (Moyens m1 : this.moyenses) {
/* 289 */           if (m1.getIdimputation().getIdimputation().equals(m.getIdimputation().getIdimputation())) {
/* 290 */             drapeau = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 295 */         if (!drapeau) {
/* 296 */           this.moyenses.add(m);
/* 297 */           JsfUtil.addSuccessMessage("Tache ajoutée avec succès");
/*     */         } else {
/* 299 */           JsfUtil.addErrorMessage("Cet imputation est deja dans la liste");
/*     */         } 
/*     */         
/* 302 */         this.total = calculTotal(this.moyenses);
/*     */         
/* 304 */         m = new Moyens();
/* 305 */         this.moyens = new Moyens();
/* 306 */         this.imputation = new Imputation();
/* 307 */         RequestContext.getCurrentInstance().execute("PF('ParagrapheCreateDialog').hide()");
/*     */       }
/*     */     
/*     */     }
/* 311 */     catch (Exception e) {
/* 312 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeParagraphe(Moyens moyens) {
/*     */     try {
/* 318 */       int i = 0;
/* 319 */       for (Moyens m : this.moyenses) {
/* 320 */         if (m.getIdimputation().getIdimputation().equals(moyens.getIdimputation().getIdimputation())) {
/*     */           
/* 322 */           if (m.getIdmoyens() != null) {
/* 323 */             this.moyensFacadeLocal.remove(moyens);
/* 324 */             this.tache.setTotalmontantaloue(Double.valueOf(this.tache.getTotalmontantaloue().doubleValue() - m.getCt().doubleValue()));
/* 325 */             this.tacheFacadeLocal.edit(this.tache);
/*     */           } 
/* 327 */           this.moyenses.remove(i);
/*     */           break;
/*     */         } 
/* 330 */         i++;
/*     */       } 
/* 332 */       this.total = calculTotal(this.moyenses);
/* 333 */       JsfUtil.addSuccessMessage("Supprimé");
/* 334 */     } catch (Exception e) {
/* 335 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void editParagraphe() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void filterAction() {
/*     */     try {
/* 349 */       if (this.programme.getIdprogramme() != null) {
/* 350 */         this.programme = this.programmeFacadeLocal.find(this.programme.getIdprogramme());
/* 351 */         this.actions = this.actionFacadeLocal.findByProgramme(this.programme.getIdprogramme());
/*     */       } else {
/* 353 */         System.err.println("programme nulle");
/*     */       } 
/* 355 */     } catch (Exception e) {
/* 356 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void filterActivite() {
/*     */     try {
/* 362 */       if (this.action.getIdaction() != null) {
/* 363 */         this.action = this.actionFacadeLocal.find(this.action.getIdaction());
/* 364 */         this.activites = this.activiteFacadeLocal.findByAction(this.action.getIdaction());
/*     */       } 
/* 366 */     } catch (Exception e) {
/* 367 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void findTache() {
/*     */     try {
/* 373 */       this.taches.clear();
/* 374 */       this.tache = new Tache();
/*     */       
/* 376 */       if (this.structure.getIdstructure().equals(Integer.valueOf(0))) {
/* 377 */         this.taches = this.tacheFacadeLocal.findByIdInstitutionIdAnnee(SessionMBean.getInstitution().getIdinstitution().longValue(), this.annee.getIdannee().longValue());
/* 378 */         if (this.taches.isEmpty()) {
/* 379 */           JsfUtil.addErrorMessage("Aucun résultat trouvé");
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 384 */       this.taches = this.tacheFacadeLocal.findByStructureAnnee(this.structure.getIdstructure().longValue(), this.annee.getIdannee().longValue());
/* 385 */       if (this.taches.isEmpty()) {
/* 386 */         JsfUtil.addErrorMessage("Aucun résultat trouvé");
/*     */       }
/* 388 */     } catch (Exception e) {
/* 389 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enlever(Moyens moyens) {
/*     */     try {
/* 395 */       List<Moyens> m1 = this.moyenses;
/* 396 */       int i = 0;
/* 397 */       for (Moyens m : this.moyenses) {
/* 398 */         if (m.getIdimputation().getIdimputation().equals(moyens.getIdimputation().getIdimputation())) {
/* 399 */           m1.remove(i);
/*     */         }
/*     */       } 
/* 402 */       this.moyenses = m1;
/* 403 */     } catch (Exception e) {
/* 404 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateTotaux() {
/*     */     try {
/* 410 */       if (this.moyens.getCu() != null) {
/* 411 */         if (this.moyens.getQte() != null) {
/* 412 */           this.moyens.setCp(Double.valueOf(this.moyens.getCu().doubleValue() * this.moyens.getQte().doubleValue()));
/* 413 */           this.moyens.setCpanneeplus1(Double.valueOf(this.moyens.getCu().doubleValue() * this.moyens.getQte().doubleValue()));
/* 414 */           this.moyens.setCpanneeplus2(Double.valueOf(this.moyens.getCu().doubleValue() * this.moyens.getQte().doubleValue()));
/* 415 */           this.moyens.setCt(Double.valueOf(this.moyens.getCu().doubleValue() * this.moyens.getQte().doubleValue()));
/*     */         } else {
/* 417 */           this.moyens.setCp(this.moyens.getCu());
/* 418 */           this.moyens.setCpanneeplus1(this.moyens.getCu());
/* 419 */           this.moyens.setCpanneeplus2(this.moyens.getCu());
/* 420 */           this.moyens.setCt(this.moyens.getCu());
/*     */         } 
/*     */       }
/* 423 */     } catch (Exception e) {
/* 424 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareCreateParagraphe() {
/* 429 */     this.mode1 = "Create";
/* 430 */     this.imputation = new Imputation();
/* 431 */     this.moyens.setCp(Double.valueOf(0.0D));
/* 432 */     this.moyens.setQte(Double.valueOf(1.0D));
/* 433 */     this.moyens.setCpanneeplus1(Double.valueOf(0.0D));
/* 434 */     this.moyens.setCpanneeplus2(Double.valueOf(0.0D));
/* 435 */     this.moyens = new Moyens();
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveTache() {
/*     */     try {
/* 441 */       if ("Create".equals(this.mode)) {
/*     */         
/* 443 */         this.tache.setIdannee(this.annee);
/*     */         
/* 445 */         if (this.typefinancement.getIdtypefinancement() != null) {
/* 446 */           this.tache.setIdtypefinancement(this.typefinancement);
/*     */         }
/*     */         
/* 449 */         this.tache.setIdtache(this.tacheFacadeLocal.nextId());
/*     */         
/* 451 */         if (this.bailleurfond.getIdbailleurfond() != null) {
/* 452 */           this.tache.setIdbailleurfond(this.bailleurfond);
/*     */         }
/*     */         
/* 455 */         this.tache.setIdactivite(this.activite);
/*     */         
/* 457 */         if (this.structure.getIdstructure() != null) {
/* 458 */           this.tache.setIdstructure(this.structure);
/*     */         }
/*     */         
// /* 461 */         this.tache.setCodeAnalytique(this.codeAnalytique);
/*     */         
/* 463 */         this.tache.setIdrisque(new Risque(Long.valueOf(1L)));
/*     */         
/* 465 */         double d1 = 0.0D;
/* 466 */         double d2 = 0.0D;
/* 467 */         double d3 = 0.0D;
/*     */         
/* 469 */         if (!this.moyenses.isEmpty()) {
/* 470 */           for (Moyens m : this.moyenses) {
/* 471 */             d1 += m.getCu().doubleValue() * m.getQte().doubleValue();
/* 472 */             d2 += m.getCpanneeplus1().doubleValue();
/* 473 */             d3 += m.getCpanneeplus2().doubleValue();
/*     */           } 
/* 475 */           this.tache.setTotalmontantaloue(Double.valueOf(d1));
/* 476 */           this.tache.setCpanneeplus1(d2);
/* 477 */           this.tache.setCpanneeplus2(d3);
/*     */         } 
/*     */         
/* 480 */         this.ut.begin();
/* 481 */         intChronogramme(this.tache);
/* 482 */         this.tache.setCpconsommee(Double.valueOf(0.0D));
/* 483 */         this.tache.setEtat("Actif");
/* 484 */         this.tacheFacadeLocal.create(this.tache);
/*     */         
/* 486 */         for (Moyens m : this.moyenses) {
/* 487 */           Moyens m1 = m;
/* 488 */           m1.setIdtache(this.tache);
/* 489 */           m1.setIdmoyens(this.moyensFacadeLocal.nextId());
/* 490 */           m1.setCt(Double.valueOf(m1.getCu().doubleValue() * m1.getQte().doubleValue()));
/* 491 */           m1.setMontantexecute(Double.valueOf(0.0D));
/* 492 */           m1.setIdbudget(Double.valueOf(SessionMBean.getBudget().getIdbudget().doubleValue()));
/* 493 */           this.moyensFacadeLocal.create(m1);
/*     */         } 
/* 495 */         this.ut.commit();
/* 496 */         this.detail = true;
/* 497 */         this.tache = new Tache();
/* 498 */         RequestContext.getCurrentInstance().execute("PF('TacheCreateDialog').hide()");
/* 499 */         JsfUtil.addSuccessMessage("Tcahe enregistrée avec succès");
/*     */         
/*     */         return;
/*     */       } 
/* 503 */       if (this.typefinancement.getIdtypefinancement() != null) {
/* 504 */         this.typefinancement = this.typefinancementFacadeLocal.find(this.typefinancement.getIdtypefinancement());
/*     */       }
/*     */       
/* 507 */       if (this.bailleurfond != null) {
/* 508 */         this.tache.setIdbailleurfond(this.bailleurfond);
/*     */       }
/*     */       
// /* 511 */       this.tache.setCodeAnalytique(this.codeAnalytiqueFacadeLocal.find(this.codeAnalytique.getIdcodeAnalytique()));
/*     */       
/* 513 */       double montant = 0.0D;
/* 514 */       double cp_a1 = 0.0D;
/* 515 */       double cp_a2 = 0.0D;
/*     */       
/* 517 */       if (!this.moyenses.isEmpty()) {
/* 518 */         for (Moyens m : this.moyenses) {
/* 519 */           montant += m.getCu().doubleValue() * m.getQte().doubleValue();
/* 520 */           cp_a1 += m.getCpanneeplus1().doubleValue();
/* 521 */           cp_a2 += m.getCpanneeplus2().doubleValue();
/*     */         } 
/* 523 */         this.tache.setTotalmontantaloue(Double.valueOf(montant));
/* 524 */         this.tache.setCpanneeplus1(cp_a1);
/* 525 */         this.tache.setCpanneeplus2(cp_a2);
/*     */       } 
/*     */       
/* 528 */       this.tache.setIdstructure(this.structureFacadeLocal.find(this.structure.getIdstructure()));
/* 529 */       this.tacheFacadeLocal.edit(this.tache);
/*     */       
/* 531 */       for (Moyens m : this.moyenses) {
/* 532 */         Moyens m1 = m;
/* 533 */         m1.setIdtache(this.tache);
/* 534 */         if (m1.getIdmoyens() != null) {
/* 535 */           m1.setCt(Double.valueOf(m1.getCu().doubleValue() * m1.getQte().doubleValue()));
/* 536 */           this.moyensFacadeLocal.edit(m1); continue;
/*     */         } 
/* 538 */         m1.setIdmoyens(this.moyensFacadeLocal.nextId());
/* 539 */         m1.setCt(Double.valueOf(m1.getCu().doubleValue() * m1.getQte().doubleValue()));
/* 540 */         this.moyensFacadeLocal.create(m1);
/*     */       } 
/*     */       
/* 543 */       this.detail = true;
/* 544 */       this.tache = new Tache();
/* 545 */       RequestContext.getCurrentInstance().execute("PF('TacheCreateDialog').hide()");
/* 546 */       JsfUtil.addSuccessMessage("Tcahe enregistrée avec succès");
/*     */       
/*     */       return;
/* 549 */     } catch (Exception e) {
/* 550 */       e.printStackTrace();
/* 551 */       JsfUtil.addErrorMessage("Erreur surevenue, veuilleur vérifier le formulaire");
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public void deleteTache() {
/*     */     try {
/* 557 */       if (this.tache != null) {
/*     */         
/* 559 */         if (!Utilitaires.isAccess(Long.valueOf(15L))) {
/* 560 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer une tache");
/*     */           
/*     */           return;
/*     */         } 
/* 564 */         if (this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue()).isEmpty()) {
/* 565 */           this.tacheFacadeLocal.remove(this.tache);
/* 566 */           JsfUtil.addSuccessMessage("Opération réussie");
/* 567 */           findTache();
/*     */           return;
/*     */         } 
/* 570 */         for (Moyens m : this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue())) {
/* 571 */           this.moyensFacadeLocal.remove(m);
/*     */         }
/* 573 */         this.tacheFacadeLocal.remove(this.tache);
/* 574 */         JsfUtil.addSuccessMessage("Opération réussie");
/* 575 */         findTache();
/*     */         
/*     */         return;
/*     */       } 
/* 579 */       JsfUtil.addErrorMessage("Aucune tache sélectionnée");
/*     */       
/* 581 */       this.detail = true;
/* 582 */     } catch (Exception e) {
/* 583 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateTotal() {
/*     */     try {
/* 589 */       this.total = calculTotal(this.moyenses);
/* 590 */     } catch (Exception e) {
/* 591 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Double calculTotal(List<Moyens> moyenses) {
/* 596 */     Double resultat = Double.valueOf(0.0D);
/* 597 */     if (!moyenses.isEmpty()) {
/* 598 */       for (Moyens m : moyenses) {
/* 599 */         resultat = Double.valueOf(resultat.doubleValue() + m.getCu().doubleValue() * m.getQte().doubleValue());
/*     */       }
/*     */     }
/* 602 */     return resultat;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 606 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 610 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 614 */     return this.taches;
/*     */   }
/*     */   
/*     */    public List<Programme> getProgrammes() {
/* 618 */
/* 618 */
/* 618 */        try {
/* 618 */         long institutionId = SessionMBean.getInstitution().getIdinstitution().longValue();
/* 618 */            logger.info("Fetching programmes for institution ID: {}", institutionId);
/* 618 */   this.programmes = this.programmeFacadeLocal.findByIdinstitution(institutionId);
/* 618 */            logger.info("Successfully fetched {} programmes.", programmes.size());
/* 618 */        } catch (EJBTransactionRolledbackException e) {
/* 618 */            logger.error("Transaction rolled back while fetching programmes for institution ID: {}", SessionMBean.getInstitution().getIdinstitution().longValue(), e);
/* 618 */            throw new EJBException("Transaction rolled back while fetching programmes", e);
/* 618 */        } catch (Exception e) {
/* 618 */            logger.error("Error fetching programmes for institution ID: {}", SessionMBean.getInstitution().getIdinstitution().longValue(), e);
/* 618 */            throw new EJBException("Error fetching programmes", e);
/* 618 */        }
/* 618 */        return this.programmes;
/* 618 */    }
/* 618 */
/* 618 */    public Programme getProgramme() {
/* 618 */        return this.programme;
/* 618 */    }
/* 618 */
/* 618 */    public void setProgramme(Programme programme) {
/* 618 */        this.programme = programme;
/* 618 */    }
/* 618 */
/* 618 */ 
// /* 618 */ }
/* 618 */    
/*     */   public Activite getActivite() {
/* 631 */     return this.activite;
/*     */   }
/*     */   
/*     */   public void setActivite(Activite activite) {
/* 635 */     this.activite = activite;
/*     */   }
/*     */   
/*     */   public List<Activite> getActivites() {
/* 639 */     return this.activites;
/*     */   }
/*     */   
/*     */   public Action getAction() {
/* 643 */     return this.action;
/*     */   }
/*     */   
/*     */   public void setAction(Action action) {
/* 647 */     this.action = action;
/*     */   }
/*     */   
/*     */   public List<Action> getActions() {
/* 651 */     return this.actions;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 655 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 659 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 663 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 664 */     return this.structures;
/*     */   }
/*     */   
/*     */   public Typefinancement getTypefinancement() {
/* 668 */     return this.typefinancement;
/*     */   }
/*     */   
/*     */   public void setTypefinancement(Typefinancement typefinancement) {
/* 672 */     this.typefinancement = typefinancement;
/*     */   }
/*     */   
/*     */   public List<Typefinancement> getTypefinancements() {
/* 676 */     this.typefinancements = this.typefinancementFacadeLocal.findAll();
/* 677 */     return this.typefinancements;
/*     */   }
/*     */   
/*     */   public Bailleurfond getBailleurfond() {
/* 681 */     return this.bailleurfond;
/*     */   }
/*     */   
/*     */   public void setBailleurfond(Bailleurfond bailleurfond) {
/* 685 */     this.bailleurfond = bailleurfond;
/*     */   }
/*     */   
/*     */   public List<Bailleurfond> getBailleurfonds() {
/* 689 */     this.bailleurfonds = this.bailleurfondFacadeLocal.findAll();
/* 690 */     return this.bailleurfonds;
/*     */   }
/*     */   
/*     */   public Risque getRisque() {
/* 694 */     return this.risque;
/*     */   }
/*     */   
/*     */   public void setRisque(Risque risque) {
/* 698 */     this.risque = risque;
/*     */   }
/*     */   
/*     */   public List<Risque> getRisques() {
/* 702 */     this.risques = this.risqueFacadeLocal.findAll();
/* 703 */     return this.risques;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 707 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 711 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 715 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 719 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 723 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 727 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public Double getTotal() {
/* 731 */     return this.total;
/*     */   }
/*     */   
/*     */   public void setTotal(Double total) {
/* 735 */     this.total = total;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses1() {
/* 739 */     return this.moyenses1;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 743 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 747 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Integer getAnn() {
/* 751 */     return this.ann;
/*     */   }
/*     */   
/*     */   public Annee getAnnee() {
/* 755 */     return this.annee;
/*     */   }
/*     */   
/*     */   private void intChronogramme(Tache tache) {
/* 759 */     tache.setM1(Boolean.valueOf(true));
/* 760 */     tache.setM2(Boolean.valueOf(true));
/* 761 */     tache.setM3(Boolean.valueOf(true));
/* 762 */     tache.setM4(Boolean.valueOf(true));
/* 763 */     tache.setM5(Boolean.valueOf(true));
/* 764 */     tache.setM6(Boolean.valueOf(true));
/* 765 */     tache.setM7(Boolean.valueOf(true));
/* 766 */     tache.setM8(Boolean.valueOf(true));
/* 767 */     tache.setM9(Boolean.valueOf(true));
/* 768 */     tache.setM10(Boolean.valueOf(true));
/* 769 */     tache.setM11(Boolean.valueOf(true));
/* 770 */     tache.setM12(Boolean.valueOf(true));
/*     */   }
/*     */   
// /*     */   public CodeAnalytique getCodeAnalytique() {
// /* 774 */     return this.codeAnalytique;
// /*     */   }
// /*     */   
// /*     */   public void setCodeAnalytique(CodeAnalytique codeAnalytique) {
// /* 778 */     this.codeAnalytique = codeAnalytique;
// /*     */   }
// /*     */   
// /*     */   public List<CodeAnalytique> getCodeAnalytiques() {
// /* 782 */     this.codeAnalytiques = this.codeAnalytiqueFacadeLocal.findAll();
// /* 783 */     return this.codeAnalytiques;
// /*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\TacheController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */