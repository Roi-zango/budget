/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Annee;
/*     */ import entities.Budget;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.AnneeFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
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
/*     */ public class ExercicebudgetaireController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  31 */   private Budget budget = new Budget();
/*  32 */   private List<Budget> budgets = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private AnneeFacadeLocal anneeFacadeLocal;
/*  36 */   private Annee annee = new Annee();
/*  37 */   private List<Annee> annees = new ArrayList<>();
/*     */   
/*  39 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  48 */     this.budget = new Budget();
/*  49 */     this.annee = new Annee();
/*  50 */     this.mode = "Create";
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  54 */     if (this.budget != null) {
/*  55 */       this.mode = "Edit";
/*  56 */       this.annee = this.anneeFacadeLocal.find(Long.valueOf(this.budget.getAnnee()));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  62 */       if ("Create".equals(this.mode)) {
/*     */         
/*  64 */         if (this.budgetFacadeLocal.findByAnnee("" + this.annee.getIdannee()) == null) {
/*     */           
/*  66 */           this.budget.setAnnee(Long.toString(this.annee.getIdannee().longValue()));
/*  67 */           this.budgetFacadeLocal.create(this.budget);
/*  68 */           this.budget = new Budget();
/*  69 */           this.annee = new Annee();
/*  70 */           this.detail = true;
/*  71 */           RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').hide()");
/*  72 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */           return;
/*     */         } 
/*  75 */         JsfUtil.addErrorMessage("Un exercice Budgetaire avec cette année existe déjà");
/*  76 */       } else if ("Edit".equals(this.mode)) {
/*  77 */         if (this.budget != null) {
/*  78 */           this.budgetFacadeLocal.edit(this.budget);
/*  79 */           this.budget = new Budget();
/*  80 */           this.annee = new Annee();
/*  81 */           this.detail = true;
/*  82 */           RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').hide()");
/*  83 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  85 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/*  88 */     } catch (Exception e) {
/*  89 */       e.printStackTrace();
/*  90 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  96 */       this.detail = true;
/*  97 */       if (this.budget != null) {
/*  98 */         this.budgetFacadeLocal.remove(this.budget);
/*  99 */         this.detail = true;
/* 100 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 102 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 104 */     } catch (Exception e) {
/* 105 */       e.printStackTrace();
/* 106 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 111 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 115 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 119 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 123 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 127 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 131 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public List<Budget> getBudgets() {
/* 135 */     this.budgets = this.budgetFacadeLocal.findAllRange();
/* 136 */     return this.budgets;
/*     */   }
/*     */   
/*     */   public void setBudgets(List<Budget> budgets) {
/* 140 */     this.budgets = budgets;
/*     */   }
/*     */   
/*     */   public Annee getAnnee() {
/* 144 */     return this.annee;
/*     */   }
/*     */   
/*     */   public void setAnnee(Annee annee) {
/* 148 */     this.annee = annee;
/*     */   }
/*     */   
/*     */   public List<Annee> getAnnees() {
/* 152 */     this.annees = this.anneeFacadeLocal.findAllRange();
/* 153 */     return this.annees;
/*     */   }
/*     */   
/*     */   public void setAnnees(List<Annee> annees) {
/* 157 */     this.annees = annees;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 161 */     return this.mode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ExercicebudgetaireController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */