/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Action;
/*     */ import entities.Budget;
/*     */ import entities.Imputation;
/*     */ import entities.Programme;
/*     */ import entities.Societe;
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
/*     */ import sessions.ActionFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.LigneverificationbcFacadeLocal;
/*     */ import sessions.ProgrammeFacadeLocal;
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
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class ImpressionAnalyseController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  45 */   private Imputation imputation = new Imputation();
/*  46 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*  50 */   private Budget budget = new Budget();
/*     */   
/*     */   @EJB
/*     */   private ProgrammeFacadeLocal programmeFacadeLocal;
/*  54 */   private Programme programme = new Programme();
/*  55 */   private List<Programme> programmes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ActionFacadeLocal actionFacadeLocal;
/*  59 */   private Action action = new Action();
/*  60 */   private List<Action> actions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private LigneverificationbcFacadeLocal ligneverificationbcFacadeLocal;
/*     */   
/*  65 */   private Societe societe = new Societe();
/*     */   
/*  67 */   private String mode = "";
/*     */   
/*     */   private boolean detail = true;
/*     */   
/*     */   private boolean imprimer = true;
/*  72 */   private Date date_de_debut = new Date();
/*  73 */   private Date date_de_fin = new Date();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void affiche(boolean item1) {
/*  80 */     System.err.println("affiche : " + item1);
/*     */   }
/*     */   
/*     */   public void filterActionByProgram() {
/*  84 */     this.actions.clear();
/*     */     try {
/*  86 */       this.actions = this.actionFacadeLocal.findByProgramme(this.programme.getIdprogramme());
/*  87 */     } catch (Exception e) {
/*  88 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void print() {
/*     */     try {
/*  94 */       Map<Object, Object> parameter = new HashMap<>();
/*  95 */       parameter.put("date_debut", this.date_de_debut);
/*  96 */       parameter.put("date_fin", this.date_de_fin);
/*  97 */       Printer p = new Printer();
/*  98 */       p.print("/rapport/report_camer_soft/certificat_rejet_interval.jasper", parameter);
/*  99 */     } catch (Exception e) {
/* 100 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printBudgetByAction() {
/*     */     try {
/* 106 */       Map<Object, Object> parameter = new HashMap<>();
/* 107 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 108 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 109 */       parameter.put("idaction", this.action.getIdaction());
/* 110 */       parameter.put("logo", SessionMBean.getLogo());
/* 111 */       Printer p = new Printer();
/* 112 */       p.print("/rapport/report_camer_soft/budget_par_action_paragraphe_param.jasper", parameter);
/* 113 */     } catch (Exception e) {
/* 114 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printAnalyseBudgetByProgram() {
/*     */     try {
/* 120 */       Map<Object, Object> parameter = new HashMap<>();
/* 121 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 122 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 123 */       parameter.put("idprogramme", this.programme.getIdprogramme());
/* 124 */       parameter.put("logo", SessionMBean.getLogo());
/* 125 */       Printer p = new Printer();
/* 126 */       p.print("/rapport/report_camer_soft/analyse_budget_par_programme.jasper", parameter);
/* 127 */     } catch (Exception e) {
/* 128 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printAnalyseBudgetGlobal() {
/*     */     try {
/* 134 */       Map<Object, Object> parameter = new HashMap<>();
/* 135 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 136 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 137 */       parameter.put("logo", SessionMBean.getLogo());
/* 138 */       Printer p = new Printer();
/* 139 */       p.print("/rapport/report_camer_soft/analyse_budgetaire_par_paragraphe.jasper", parameter);
/* 140 */     } catch (Exception e) {
/* 141 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printExecutionBudgetaire() {
/*     */     try {
/* 147 */       Map<Object, Object> parameter = new HashMap<>();
/* 148 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 149 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 150 */       parameter.put("logo", SessionMBean.getLogo());
/* 151 */       Printer p = new Printer();
/* 152 */       p.print("/rapport/report_camer_soft/execution_budgetaire.jasper", parameter);
/* 153 */     } catch (Exception e) {
/* 154 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printExecutionByProgram() {
/*     */     try {
/* 160 */       Map<Object, Object> parameter = new HashMap<>();
/* 161 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 162 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 163 */       parameter.put("logo", SessionMBean.getLogo());
/* 164 */       Printer p = new Printer();
/* 165 */       p.print("/rapport/report_camer_soft/execution_par_programme.jasper", parameter);
/* 166 */     } catch (Exception e) {
/* 167 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 172 */     this.detail = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void deactiveButton() {
/* 177 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 181 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 185 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 189 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 193 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 197 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 198 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 202 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 206 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 210 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 214 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 218 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public Date getDate_de_debut() {
/* 222 */     return this.date_de_debut;
/*     */   }
/*     */   
/*     */   public void setDate_de_debut(Date date_de_debut) {
/* 226 */     this.date_de_debut = date_de_debut;
/*     */   }
/*     */   
/*     */   public Date getDate_de_fin() {
/* 230 */     return this.date_de_fin;
/*     */   }
/*     */   
/*     */   public void setDate_de_fin(Date date_de_fin) {
/* 234 */     this.date_de_fin = date_de_fin;
/*     */   }
/*     */   
/*     */   public Programme getProgramme() {
/* 238 */     return this.programme;
/*     */   }
/*     */   
/*     */   public void setProgramme(Programme programme) {
/* 242 */     this.programme = programme;
/*     */   }
/*     */   
/*     */   public List<Programme> getProgrammes() {
/* 246 */     this.programmes = this.programmeFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 247 */     return this.programmes;
/*     */   }
/*     */   
/*     */   public void setProgrammes(List<Programme> programmes) {
/* 251 */     this.programmes = programmes;
/*     */   }
/*     */   
/*     */   public Action getAction() {
/* 255 */     return this.action;
/*     */   }
/*     */   
/*     */   public void setAction(Action action) {
/* 259 */     this.action = action;
/*     */   }
/*     */   
/*     */   public List<Action> getActions() {
/* 263 */     return this.actions;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ImpressionAnalyseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */