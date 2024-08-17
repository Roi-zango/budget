/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Imputation;
/*     */ import entities.Moyens;
/*     */ import entities.Signataire;
/*     */ import entities.Structure;
/*     */ import entities.Tache;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.transaction.Transactional;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.SignataireFacadeLocal;
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
/*     */ public class SalaireController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  53 */   private Boncommande boncommande = new Boncommande();
/*  54 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SignataireFacadeLocal signataireFacadeLocal;
/*  58 */   private Signataire signataire = new Signataire();
/*  59 */   private List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  63 */   private Structure structure = new Structure();
/*  64 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  68 */   private Imputation imputation = new Imputation();
/*  69 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*  73 */   protected Tache tache = new Tache();
/*  74 */   protected List<Tache> taches = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*  78 */   protected Moyens moyens = new Moyens();
/*  79 */   protected List<Moyens> moyenses = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*     */   
/*  84 */   private String mode = "";
/*  85 */   private List<String> notif = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private boolean renderedNotif = false;
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  95 */     if (SessionMBean.getBudget() != null) {
/*     */       
/*  97 */       if (!Utilitaires.isAccess(Long.valueOf(32L))) {
/*  98 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'etablir un engagement de salaire");
/*     */         
/*     */         return;
/*     */       } 
/* 102 */       this.mode = "Create";
/* 103 */       this.notif.clear();
/* 104 */       this.taches.clear();
/* 105 */       this.moyenses.clear();
/* 106 */       this.moyens = new Moyens();
/* 107 */       this.tache = new Tache();
/* 108 */       this.signataire = new Signataire();
/* 109 */       this.structure = new Structure();
/* 110 */       this.imputation = new Imputation();
/* 111 */       this.boncommande = new Boncommande();
/* 112 */       this.boncommande.setAvance(0.0D);
/* 113 */       this.boncommande.setTotalht(0.0D);
/* 114 */       this.boncommande.setTotalair(0.0D);
/* 115 */       this.boncommande.setMontantenlettre("-");
/* 116 */       this.boncommande.setReference("-");
/* 117 */       this.boncommande.setCoefficientreducteur(0.0D);
/* 118 */       this.boncommande.setDelailivraison(5);
/* 119 */       this.boncommande.setVerif(false);
/* 120 */       this.boncommande.setNombreverif(0);
/* 121 */       this.boncommande.setValide(false);
/* 122 */       this.boncommande.setEngage(true);
/*     */       
/* 124 */       this.boncommande.setImputations("-");
/*     */       
/* 126 */       this.boncommande.setBc(false);
/* 127 */       this.boncommande.setMission(false);
/* 128 */       this.boncommande.setLettrecommande(false);
/* 129 */       this.boncommande.setDecision(false);
/* 130 */       this.boncommande.setGreAgre(false);
/* 131 */       this.boncommande.setSalaire(true);
/*     */       
/* 133 */       this.boncommande.setEspece(false);
/* 134 */       this.boncommande.setVirement(true);
/* 135 */       this.boncommande.setCheque(false);
/*     */       
/* 137 */       this.boncommande.setPaye(false);
/* 138 */       this.boncommande.setAttentepayement(false);
/* 139 */       this.boncommande.setTauxair(0.0D);
/* 140 */       this.boncommande.setTauxtva(0.0D);
/*     */       
/* 142 */       this.boncommande.setCode(Utilitaires.generateSANumero(this.boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), SessionMBean.getAnnee().getNom()));
/*     */       
/* 144 */       RequestContext.getCurrentInstance().execute("PF('SalaireCreateDialog').show()");
/*     */     } else {
/* 146 */       JsfUtil.addWarningMessage("Aucune année budgetaire en session");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMontantEnLettre() {
/*     */     try {
/* 152 */       if (this.boncommande.getTtc().doubleValue() != 0.0D) {
/* 153 */         String montantEnLettre = Convert.FR("" + this.boncommande.getTtc().intValue());
/* 154 */         this.boncommande.setMontantenlettre(montantEnLettre);
/* 155 */         this.boncommande.setTotalht(this.boncommande.getTtc().doubleValue());
/*     */       } else {
/* 157 */         this.boncommande.setMontantenlettre("-");
/* 158 */         this.boncommande.setTotalht(0.0D);
/*     */       } 
/* 160 */     } catch (Exception e) {
/* 161 */       this.boncommande.setMontantenlettre("-");
/* 162 */       this.boncommande.setTotalht(0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareEdit() {
/* 168 */     if (this.boncommande != null) {
/*     */       
/* 170 */       if (!Utilitaires.isAccess(Long.valueOf(32L))) {
/* 171 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier un engagement de salaire");
/*     */         
/*     */         return;
/*     */       } 
/* 175 */       if (this.boncommande.isValide()) {
/* 176 */         JsfUtil.addWarningMessage("Operation impossible; Cet engagement est deja validé");
/*     */         
/*     */         return;
/*     */       } 
/* 180 */       this.taches.clear();
/* 181 */       this.moyenses.clear();
/*     */       
/* 183 */       this.structure = this.boncommande.getStructure();
/* 184 */       this.imputation = this.boncommande.getImputation();
/* 185 */       this.signataire = this.boncommande.getSignataire();
/*     */       
/* 187 */       this.tache = this.boncommande.getMoyens().getIdtache();
/* 188 */       this.moyens = this.boncommande.getMoyens();
/*     */       
/* 190 */       this.taches.add(this.boncommande.getMoyens().getIdtache());
/* 191 */       this.moyenses.add(this.boncommande.getMoyens());
/* 192 */       this.mode = "Edit";
/* 193 */       RequestContext.getCurrentInstance().execute("PF('SalaireCreateDialog').show()");
/*     */     } else {
/* 195 */       JsfUtil.addFatalErrorMessage("Aucune ligne sélectionnée");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateTotal() {
/* 200 */     double value_ht = this.boncommande.getTotalht();
/* 201 */     this.boncommande.setTotalht(value_ht);
/* 202 */     this.boncommande.setTva(0.0D);
/* 203 */     this.boncommande.setTotalair(0.0D);
/* 204 */     this.boncommande.setTtc(Double.valueOf(value_ht));
/* 205 */     this.boncommande.setNetapayer(value_ht);
/*     */   }
/*     */   
/*     */   public void updateMP1() {
/* 209 */     if (this.boncommande.isCheque()) {
/* 210 */       this.boncommande.setVirement(false);
/* 211 */       this.boncommande.setEspece(false);
/*     */     } 
/* 213 */     initModePayement();
/*     */   }
/*     */   
/*     */   public void updateMP2() {
/* 217 */     if (this.boncommande.isEspece()) {
/* 218 */       this.boncommande.setCheque(false);
/* 219 */       this.boncommande.setVirement(false);
/*     */     } 
/* 221 */     initModePayement();
/*     */   }
/*     */   
/*     */   public void updateMP3() {
/* 225 */     if (this.boncommande.isVirement()) {
/* 226 */       this.boncommande.setCheque(false);
/* 227 */       this.boncommande.setEspece(false);
/*     */     } 
/* 229 */     initModePayement();
/*     */   }
/*     */   
/*     */   private void initModePayement() {
/* 233 */     if (!this.boncommande.isCheque() && !this.boncommande.isVirement() && !this.boncommande.isEspece()) {
/* 234 */       this.boncommande.setVirement(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateTache() {
/*     */     try {
/* 240 */       if (this.structure.getIdstructure() != null) {
/* 241 */         this.taches.clear();
/* 242 */         this.imputation = new Imputation();
/* 243 */         this.moyenses.clear();
/* 244 */         this.moyens = new Moyens();
/* 245 */         this.taches = this.tacheFacadeLocal.findByStructureAnnee(this.structure.getIdstructure().longValue(), SessionMBean.getAnnee().getIdannee().longValue());
/*     */         return;
/*     */       } 
/* 248 */       JsfUtil.addWarningMessage("Veuillez selectionner une structure");
/* 249 */     } catch (Exception e) {
/* 250 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void save() {
/*     */     try {
/* 257 */       if ("Create".equals(this.mode)) {
/*     */         
/* 259 */         this.renderedNotif = false;
/* 260 */         this.notif.clear();
/* 261 */         updateTotal();
/*     */         
/* 263 */         if (this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue() > this.moyens.getCt().doubleValue()) {
/* 264 */           JsfUtil.addWarningMessage("Montant insuffisant pour engager ce bon de commande");
/*     */           
/*     */           return;
/*     */         } 
/* 268 */         this.boncommande.setCode(Utilitaires.generateSANumero(this.boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), SessionMBean.getAnnee().getNom()));
/* 269 */         if (this.boncommandeFacadeLocal.findByCode(this.structure.getIdstructure(), this.boncommande.getCode()) == null) {
/*     */           
/* 271 */           this.boncommande.setIdboncommande(Long.valueOf(this.boncommandeFacadeLocal.nextId()));
/* 272 */           this.boncommande.setStructure(this.structure);
/* 273 */           this.boncommande.setSignataire(this.signataire);
/* 274 */           this.boncommande.setImputation(this.imputation);
/* 275 */           this.boncommande.setBudget(SessionMBean.getBudget());
/* 276 */           this.boncommande.setMoyens(this.moyens);
/* 277 */           this.boncommande.setTaxeOrdonne(0.0D);
/* 278 */           this.boncommande.setNapOrdonne(0.0D);
/* 279 */           if (this.boncommande.getDelailivraison() > 0) {
/* 280 */             this.boncommande.setDatelivraison(Utilitaires.addDayToDate(this.boncommande.getDateemission(), this.boncommande.getDelailivraison()));
/*     */           }
/*     */           
/* 283 */           this.boncommande.setEngage(true);
/* 284 */           this.boncommandeFacadeLocal.create(this.boncommande);
/*     */           
/* 286 */           this.moyens.setMontantexecute(Double.valueOf(this.moyens.getMontantexecute().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 287 */           this.moyensFacadeLocal.edit(this.moyens);
/*     */           
/* 289 */           this.moyens.getIdtache().setCpconsommee(Double.valueOf(this.moyens.getIdtache().getCpconsommee().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 290 */           this.moyens.getIdtache().setMontantengage(this.moyens.getIdtache().getMontantengage() + this.boncommande.getTtc().doubleValue());
/* 291 */           this.tacheFacadeLocal.edit(this.moyens.getIdtache());
/*     */           
/* 293 */           this.boncommande = new Boncommande();
/* 294 */           this.signataire = new Signataire();
/* 295 */           this.structure = new Structure();
/* 296 */           this.detail = true;
/* 297 */           RequestContext.getCurrentInstance().execute("PF('SalaireCreateDialog').hide()");
/* 298 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 300 */           JsfUtil.addErrorMessage("Un bon de commande ayant cette reference existe dejà");
/*     */         } 
/* 302 */       } else if ("Edit".equals(this.mode)) {
/* 303 */         if (this.boncommande != null) {
/*     */           
/* 305 */           updateTotal();
/*     */           
/* 307 */           if (this.boncommande.getDelailivraison() > 0) {
/* 308 */             this.boncommande.setDatelivraison(Utilitaires.addDayToDate(this.boncommande.getDateemission(), this.boncommande.getDelailivraison()));
/*     */           }
/* 310 */           this.boncommande.setSignataire(this.signataireFacadeLocal.find(this.signataire.getIdsignataire()));
/* 311 */           this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */           
/* 313 */           Boncommande b = this.boncommandeFacadeLocal.find(this.boncommande.getIdboncommande());
/* 314 */           if (!Objects.equals(b.getTtc(), this.boncommande.getTtc())) {
/* 315 */             Moyens m = this.boncommande.getMoyens();
/* 316 */             m.setMontantexecute(Double.valueOf(m.getMontantexecute().doubleValue() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 317 */             this.moyensFacadeLocal.edit(m);
/*     */             
/* 319 */             Tache t = this.boncommande.getMoyens().getIdtache();
/* 320 */             t.setCpconsommee(Double.valueOf(t.getCpconsommee().doubleValue() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue()));
/* 321 */             t.setMontantengage(t.getMontantengage() - b.getTtc().doubleValue() + this.boncommande.getTtc().doubleValue());
/* 322 */             this.tacheFacadeLocal.edit(t);
/*     */           } 
/*     */           
/* 325 */           this.boncommande = new Boncommande();
/* 326 */           this.signataire = new Signataire();
/* 327 */           this.structure = new Structure();
/* 328 */           this.detail = true;
/* 329 */           RequestContext.getCurrentInstance().execute("PF('SalaireCreateDialog').hide()");
/* 330 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 332 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 335 */     } catch (Exception e) {
/* 336 */       e.printStackTrace();
/* 337 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 344 */       if (this.boncommande != null) {
/*     */         
/* 346 */         if (!Utilitaires.isAccess(Long.valueOf(33L))) {
/* 347 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler un engagement de salaire");
/*     */           
/*     */           return;
/*     */         } 
/* 351 */         if (this.boncommande.isPaye()) {
/* 352 */           JsfUtil.addErrorMessage("Cet engagement de salaire est dejà payé");
/*     */           
/*     */           return;
/*     */         } 
/* 356 */         this.boncommandeFacadeLocal.remove(this.boncommande);
/*     */         
/* 358 */         Moyens m = this.boncommande.getMoyens();
/* 359 */         m.setMontantexecute(Double.valueOf(m.getMontantexecute().doubleValue() - this.boncommande.getTtc().doubleValue()));
/* 360 */         if (this.boncommande.isLiquide()) {
/* 361 */           m.setMontantLiquide(m.getMontantLiquide() - this.boncommande.getTtc().doubleValue());
/*     */         }
/* 363 */         this.moyensFacadeLocal.edit(m);
/*     */         
/* 365 */         Tache t = this.boncommande.getMoyens().getIdtache();
/* 366 */         t.setCpconsommee(Double.valueOf(t.getCpconsommee().doubleValue() - this.boncommande.getTtc().doubleValue()));
/* 367 */         t.setMontantengage(t.getMontantengage() - this.boncommande.getTtc().doubleValue());
/*     */         
/* 369 */         if (this.boncommande.isPaye()) {
/* 370 */           t.setMontantpayettc(t.getMontantpayettc() - this.boncommande.getTtc().doubleValue());
/* 371 */           t.setMontantpayeht(t.getMontantpayeht() - this.boncommande.getNetapayer());
/*     */         } 
/* 373 */         this.tacheFacadeLocal.edit(t);
/*     */         
/* 375 */         this.boncommande = new Boncommande();
/* 376 */         this.detail = true;
/* 377 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 379 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 381 */     } catch (Exception e) {
/* 382 */       e.printStackTrace();
/* 383 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateMoyens() {
/*     */     try {
/* 389 */       this.moyenses.clear();
/* 390 */       if (this.tache != null) {
/* 391 */         this.moyenses = this.moyensFacadeLocal.findByTache(this.tache.getIdtache().longValue());
/* 392 */         if (!this.moyenses.isEmpty() && 
/* 393 */           this.moyenses.size() == 1) {
/* 394 */           this.imputation = ((Moyens)this.moyenses.get(0)).getIdimputation();
/* 395 */           this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/*     */         }
/*     */       
/*     */       } 
/* 399 */     } catch (Exception e) {
/* 400 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateImputationData() {
/* 405 */     if (this.moyens != null) {
/* 406 */       this.imputation = this.moyens.getIdimputation();
/* 407 */       this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 413 */       if (this.imputation.getIdimputation() != null && 
/* 414 */         this.structure.getIdstructure() != null) {
/* 415 */         this.imputation = this.imputationFacadeLocal.find(this.imputation.getIdimputation());
/* 416 */         this.boncommande.setImputations(this.imputation.getCode() + " SITE 3");
/* 417 */         this.taches.clear();
/* 418 */         this.moyens = new Moyens();
/* 419 */         List<Moyens> moyenses = this.moyensFacadeLocal.findByStructureAnneeIdimputation(this.structure.getIdstructure(), SessionMBean.getAnnee().getIdannee(), this.imputation.getIdimputation());
/* 420 */         if (!moyenses.isEmpty()) {
/* 421 */           for (Moyens m : moyenses) {
/* 422 */             if (!this.taches.contains(m.getIdtache())) {
/* 423 */               this.taches.add(m.getIdtache());
/*     */             }
/*     */           }
/*     */         
/*     */         }
/*     */       } 
/* 429 */     } catch (Exception e) {
/* 430 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void printCe() {
/*     */     try {
/* 437 */       if (!Utilitaires.isAccess(Long.valueOf(18L))) {
/* 438 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engament");
/*     */         
/*     */         return;
/*     */       } 
/* 442 */       Map<Object, Object> parameter = new HashMap<>();
/* 443 */       parameter.put("idboncommande", this.boncommande.getIdboncommande());
/* 444 */       parameter.put("logo", SessionMBean.getLogo());
/* 445 */       Printer p = new Printer();
/* 446 */       p.print("/rapport/report_camer_soft/certificat_engagement_autre.jasper", parameter);
/* 447 */     } catch (Exception e) {
/* 448 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 453 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 457 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 461 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 465 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 469 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 473 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 477 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 478 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 482 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 486 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 490 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 494 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 495 */     return this.structures;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 499 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 503 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 507 */     this.boncommandes = this.boncommandeFacadeLocal.findByIdAnneeSal(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 508 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public void setBoncommandes(List<Boncommande> boncommandes) {
/* 512 */     this.boncommandes = boncommandes;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 516 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 520 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 524 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 525 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 529 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 533 */     return this.mode;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/* 537 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/* 541 */     this.tache = tache;
/*     */   }
/*     */   
/*     */   public List<Tache> getTaches() {
/* 545 */     return this.taches;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 549 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 553 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public List<Moyens> getMoyenses() {
/* 557 */     return this.moyenses;
/*     */   }
/*     */   
/*     */   public void setMoyenses(List<Moyens> moyenses) {
/* 561 */     this.moyenses = moyenses;
/*     */   }
/*     */   
/*     */   public List<String> getNotif() {
/* 565 */     return this.notif;
/*     */   }
/*     */   
/*     */   public boolean isRenderedNotif() {
/* 569 */     return this.renderedNotif;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\SalaireController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */