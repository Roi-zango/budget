/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Annee;
/*     */ import entities.Bailleurfond;
/*     */ import entities.Imputation;
/*     */ import entities.Recette;
/*     */ import entities.Risque;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.AnneeFacadeLocal;
/*     */ import sessions.BailleurfondFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.RecetteFacadeLocal;
/*     */ import sessions.RisqueFacadeLocal;
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
/*     */ public class RecetteController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private RecetteFacadeLocal recetteFacadeLocal;
/*     */   private Recette recette;
/*     */   @EJB
/*     */   private AnneeFacadeLocal anneeFacadeLocal;
/*  44 */   private Annee annee = SessionMBean.getAnnee();
/*  45 */   private List<Annee> annees = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*     */   private Imputation imputation;
/*  50 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RisqueFacadeLocal risqueFacadeLocal;
/*  54 */   private Risque risque = new Risque();
/*  55 */   private List<Risque> risques = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BailleurfondFacadeLocal bailleurfondFacadeLocal;
/*  59 */   private Bailleurfond bailleurfond = new Bailleurfond();
/*  60 */   private List<Bailleurfond> bailleurfonds = new ArrayList<>();
/*     */   
/*  62 */   private Boolean showCreateButton = Boolean.valueOf(true);
/*  63 */   private Boolean showEditButton = Boolean.valueOf(true);
/*     */   
/*  65 */   private String mode = "";
/*     */   
/*  67 */   private Integer ann = Integer.valueOf(0);
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
/*  78 */     this.imputation = new Imputation();
/*  79 */     this.recette = new Recette();
/*     */     try {
/*  81 */       returnDouble();
/*  82 */     } catch (Exception e) {
/*  83 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void returnDouble() {
/*     */     try {
/*  89 */       if (!this.annee.getIdannee().equals(null)) {
/*  90 */         this.ann = Integer.valueOf(Integer.parseInt(this.annee.getNom()));
/*     */       }
/*  92 */     } catch (Exception e) {
/*  93 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateAnnee() {
/*     */     try {
/*  99 */       if (this.annee.getIdannee() != null) {
/* 100 */         this.annee = this.anneeFacadeLocal.find(this.annee.getIdannee());
/* 101 */         returnDouble();
/*     */       } 
/* 103 */     } catch (Exception e) {
/* 104 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*     */     try {
/* 110 */       if (this.imputation != null) {
/* 111 */         if (this.annee != null) {
/*     */           
/* 113 */           if (!Utilitaires.isAccess(Long.valueOf(14L))) {
/* 114 */             JsfUtil.addErrorMessage("Vous n'avez pas le droit de saisir les recettes");
/*     */             
/*     */             return;
/*     */           } 
/* 118 */           this.recette = new Recette();
/*     */           
/* 120 */           this.recette.setCt(Float.valueOf(0.0F));
/* 121 */           this.recette.setCu(Float.valueOf(0.0F));
/* 122 */           this.recette.setQte(Float.valueOf(1.0F));
/*     */           
/* 124 */           this.bailleurfond = new Bailleurfond();
/*     */           
/* 126 */           this.recette.setMontantConsommeAvant(Double.valueOf(0.0D));
/* 127 */           this.recette.setRanneeavant(Float.valueOf(0.0F));
/* 128 */           this.recette.setRanneeavantCu(Double.valueOf(0.0D));
/* 129 */           this.recette.setRanneeavantQte(Double.valueOf(1.0D));
/*     */           
/* 131 */           this.recette.setReaanneeavant(Float.valueOf(0.0F));
/* 132 */           this.recette.setReaanneeavantCu(Double.valueOf(0.0D));
/* 133 */           this.recette.setReaanneeavantQte(Double.valueOf(1.0D));
/*     */           
/* 135 */           this.recette.setPranneePlus1Cout(Double.valueOf(0.0D));
/* 136 */           this.recette.setPranneePlus1Qte(Double.valueOf(1.0D));
/* 137 */           this.recette.setPranneePlus1Total(Double.valueOf(0.0D));
/*     */           
/* 139 */           this.recette.setPranneePlus2Cout(Double.valueOf(0.0D));
/* 140 */           this.recette.setPranneePlus2Qte(Double.valueOf(1.0D));
/* 141 */           this.recette.setPranneePlus2Total(Double.valueOf(0.0D));
/*     */           
/* 143 */           this.mode = "Create";
/* 144 */           RequestContext.getCurrentInstance().execute("PF('RecetteCreateDialog').show()");
/*     */         } else {
/* 146 */           JsfUtil.addErrorMessage("Aucune année sélectioné");
/*     */         } 
/*     */       } else {
/* 149 */         JsfUtil.addSuccessMessage("Aucune ligne selectionné");
/*     */       } 
/* 151 */     } catch (Exception e) {
/* 152 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*     */     try {
/* 158 */       if (this.imputation != null) {
/* 159 */         if (this.annee != null) {
/*     */           
/* 161 */           if (!Utilitaires.isAccess(Long.valueOf(14L))) {
/* 162 */             JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les recettes");
/*     */             
/*     */             return;
/*     */           } 
/* 166 */           Recette temp = this.recetteFacadeLocal.findByImputationAnne(this.imputation, this.annee);
/* 167 */           if (temp != null) {
/* 168 */             this.annee = temp.getIdannee();
/* 169 */             this.recette = temp;
/*     */             
/* 171 */             this.mode = "Edit";
/*     */             
/* 173 */             if (temp.getIdbailleurfond() != null) {
/* 174 */               this.bailleurfond = temp.getIdbailleurfond();
/*     */             }
/*     */           } 
/*     */         } else {
/* 178 */           JsfUtil.addErrorMessage("Aucune année selectionnée");
/*     */         } 
/*     */       } else {
/* 181 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 183 */     } catch (Exception e) {
/* 184 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void nothing() {}
/*     */ 
/*     */   
/*     */   public Recette find(Imputation imputation) {
/* 193 */     Recette recette = new Recette();
/*     */     try {
/* 195 */       if (this.annee != null) {
/* 196 */         recette = this.recetteFacadeLocal.findByImputationAnne(imputation, this.annee);
/*     */       }
/* 198 */     } catch (Exception e) {
/* 199 */       e.printStackTrace();
/*     */     } 
/* 201 */     return recette;
/*     */   }
/*     */   
/*     */   public void create() {
/*     */     try {
/* 206 */       if (this.annee != null && 
/* 207 */         this.imputation != null) {
/* 208 */         if ("Create".equals(this.mode)) {
/* 209 */           if (this.recetteFacadeLocal.findByImputationAnne(this.imputation, this.annee) == null) {
/*     */             
/* 211 */             this.recette.setIdrecette(this.recetteFacadeLocal.nextId());
/* 212 */             this.recette.setIdannee(this.annee);
/* 213 */             this.recette.setIdimputation(this.imputation);
/* 214 */             this.recette.setCt(Float.valueOf(this.recette.getCu().floatValue() * this.recette.getQte().floatValue()));
/* 215 */             this.recette.setIdbailleurfond(this.bailleurfond);
/* 216 */             this.recetteFacadeLocal.create(this.recette);
/* 217 */             this.mode = "";
/* 218 */             JsfUtil.addSuccessMessage("Opération réussie");
/*     */           } else {
/*     */             
/* 221 */             JsfUtil.addWarningMessage("Les données des cette sont deja saisies ; veuillez cliquez sur modifier");
/*     */           }
/*     */         
/* 224 */         } else if ("Edit".equals(this.mode)) {
/* 225 */           this.recette.setIdannee(this.annee);
/* 226 */           this.recette.setIdimputation(this.imputation);
/* 227 */           this.bailleurfond = this.bailleurfondFacadeLocal.find(this.bailleurfond.getIdbailleurfond());
/* 228 */           this.recette.setIdbailleurfond(this.bailleurfond);
/* 229 */           this.recetteFacadeLocal.edit(this.recette);
/* 230 */           JsfUtil.addSuccessMessage("Opération réussie");
/* 231 */           this.mode = "";
/*     */         } else {
/* 233 */           JsfUtil.addErrorMessage("Veuillez verifier les données");
/*     */         }
/*     */       
/*     */       }
/* 237 */     } catch (Exception e) {
/* 238 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRecetteAnneeN() {
/*     */     try {
/* 244 */       if (this.recette.getCu() != null && 
/* 245 */         this.recette.getQte() != null) {
/* 246 */         this.recette.setCt(Float.valueOf(this.recette.getQte().floatValue() * this.recette.getCu().floatValue()));
/*     */       }
/*     */     }
/* 249 */     catch (Exception e) {
/* 250 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRecetteAnneeAvant() {
/*     */     try {
/* 256 */       if (this.recette.getRanneeavantCu() != null && 
/* 257 */         this.recette.getRanneeavantQte() != null) {
/* 258 */         this.recette.setRanneeavant(Float.valueOf(this.recette.getRanneeavantCu().floatValue() * this.recette.getRanneeavantQte().floatValue()));
/*     */       }
/*     */     }
/* 261 */     catch (Exception e) {
/* 262 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRealisationAnneeAvant() {
/*     */     try {
/* 268 */       if (this.recette.getReaanneeavantCu() != null && 
/* 269 */         this.recette.getReaanneeavantQte() != null) {
/* 270 */         this.recette.setReaanneeavant(Float.valueOf(this.recette.getReaanneeavantCu().floatValue() * this.recette.getReaanneeavantQte().floatValue()));
/*     */       }
/*     */     }
/* 273 */     catch (Exception e) {
/* 274 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updatePrevionAnneePlus_1() {
/*     */     try {
/* 280 */       if (this.recette.getPranneePlus1Cout() != null && 
/* 281 */         this.recette.getPranneePlus1Qte() != null) {
/* 282 */         this.recette.setPranneePlus1Total(Double.valueOf(this.recette.getPranneePlus1Cout().doubleValue() * this.recette.getPranneePlus1Qte().doubleValue()));
/*     */       }
/*     */     }
/* 285 */     catch (Exception e) {
/* 286 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updatePrevionAnneePlus_2() {
/*     */     try {
/* 292 */       if (this.recette.getPranneePlus2Cout() != null && 
/* 293 */         this.recette.getPranneePlus2Qte() != null) {
/* 294 */         this.recette.setPranneePlus2Total(Double.valueOf(this.recette.getPranneePlus2Cout().doubleValue() * this.recette.getPranneePlus2Qte().doubleValue()));
/*     */       }
/*     */     }
/* 297 */     catch (Exception e) {
/* 298 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Boolean getShowCreateButton() {
/*     */     try {
/* 304 */       this.showCreateButton = Boolean.valueOf(true);
/* 305 */       if (this.annee.getIdannee() != null && this.imputation != null) {
/* 306 */         if (this.recetteFacadeLocal.findByImputationAnne(this.imputation, this.annee) != null) {
/* 307 */           this.showCreateButton = Boolean.valueOf(true);
/*     */         } else {
/* 309 */           this.showCreateButton = Boolean.valueOf(false);
/*     */         } 
/*     */       }
/* 312 */     } catch (Exception e) {
/* 313 */       e.printStackTrace();
/*     */     } 
/* 315 */     return this.showCreateButton;
/*     */   }
/*     */   
/*     */   public void setShowCreateButton(Boolean showCreateButton) {
/* 319 */     this.showCreateButton = showCreateButton;
/*     */   }
/*     */   
/*     */   public Boolean getShowEditButton() {
/*     */     try {
/* 324 */       this.showEditButton = Boolean.valueOf(true);
/*     */       
/* 326 */       if (this.annee.getIdannee() != null && this.imputation != null) {
/* 327 */         if (this.recetteFacadeLocal.findByImputationAnne(this.imputation, this.annee) != null) {
/* 328 */           this.showEditButton = Boolean.valueOf(false);
/*     */         }
/*     */       } else {
/* 331 */         this.showEditButton = Boolean.valueOf(true);
/*     */       } 
/* 333 */     } catch (Exception e) {
/* 334 */       e.printStackTrace();
/*     */     } 
/* 336 */     return this.showEditButton;
/*     */   }
/*     */   
/*     */   public void setShowEditButton(Boolean showEditButton) {
/* 340 */     this.showEditButton = showEditButton;
/*     */   }
/*     */   
/*     */   public Annee getAnnee() {
/* 344 */     return this.annee;
/*     */   }
/*     */   
/*     */   public void setAnnee(Annee annee) {
/* 348 */     this.annee = annee;
/*     */   }
/*     */   
/*     */   public List<Annee> getAnnees() {
/* 352 */     this.annees = this.anneeFacadeLocal.findAll("Actif");
/* 353 */     return this.annees;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 357 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 361 */     this.imputation = imputation;
/* 362 */     getShowEditButton();
/* 363 */     getShowCreateButton();
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 367 */     this.imputations = this.imputationFacadeLocal.findAllOrder("Actif");
/* 368 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public Recette getRecette() {
/* 372 */     return this.recette;
/*     */   }
/*     */   
/*     */   public void setRecette(Recette recette) {
/* 376 */     this.recette = recette;
/*     */   }
/*     */   
/*     */   public Risque getRisque() {
/* 380 */     return this.risque;
/*     */   }
/*     */   
/*     */   public void setRisque(Risque risque) {
/* 384 */     this.risque = risque;
/*     */   }
/*     */   
/*     */   public List<Risque> getRisques() {
/* 388 */     this.risques = this.risqueFacadeLocal.findAll();
/* 389 */     return this.risques;
/*     */   }
/*     */   
/*     */   public Bailleurfond getBailleurfond() {
/* 393 */     return this.bailleurfond;
/*     */   }
/*     */   
/*     */   public void setBailleurfond(Bailleurfond bailleurfond) {
/* 397 */     this.bailleurfond = bailleurfond;
/*     */   }
/*     */   
/*     */   public List<Bailleurfond> getBailleurfonds() {
/* 401 */     this.bailleurfonds = this.bailleurfondFacadeLocal.findAll();
/* 402 */     return this.bailleurfonds;
/*     */   }
/*     */   
/*     */   public Integer getAnn() {
/* 406 */     return this.ann;
/*     */   }
/*     */   
/*     */   public void setAnn(Integer ann) {
/* 410 */     this.ann = ann;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\RecetteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */