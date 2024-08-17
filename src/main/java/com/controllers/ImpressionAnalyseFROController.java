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
/*     */ public class ImpressionAnalyseFROController
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
/*  98 */       p.print("/rapport/report_fr_ouest/certificat_rejet_interval.jasper", parameter);
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
/* 109 */       parameter.put("logo", SessionMBean.getLogo());
/* 110 */       Printer p = new Printer();
/* 111 */       p.print("/rapport/report_fr_ouest/execution_budgetaire_p_a.jasper", parameter);
/* 112 */     } catch (Exception e) {
/* 113 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printSyntheseByActivite() {
/*     */     try {
/* 119 */       Map<Object, Object> parameter = new HashMap<>();
/* 120 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 121 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 122 */       parameter.put("idprogramme", this.programme.getIdprogramme());
/* 123 */       parameter.put("logo", SessionMBean.getLogo());
/* 124 */       Printer p = new Printer();
/* 125 */       p.print("/rapport/report_fr_ouest/execution_budgetaire_programme_activite.jasper", parameter);
/* 126 */     } catch (Exception e) {
/* 127 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printAnalyseBudgetParParagraphe() {
/*     */     try {
/* 133 */       Map<Object, Object> parameter = new HashMap<>();
/* 134 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 135 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 136 */       Printer p = new Printer();
/* 137 */       p.print("/rapport/report_fr_ouest/execution_budgetaire_p_a_p.jasper", parameter);
/* 138 */     } catch (Exception e) {
/* 139 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printExecutionBudgetaire() {
/*     */     try {
/* 145 */       Map<Object, Object> parameter = new HashMap<>();
/* 146 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 147 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 148 */       parameter.put("idprogramme", this.programme.getIdprogramme());
/* 149 */       parameter.put("logo", SessionMBean.getLogo());
/* 150 */       Printer p = new Printer();
/* 151 */       p.print("/rapport/report_fr_ouest/execution_budgetaire_p_a_a_t.jasper", parameter);
/* 152 */     } catch (Exception e) {
/* 153 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printSynthsesByProgram() {
/*     */     try {
/* 159 */       Map<Object, Object> parameter = new HashMap<>();
/* 160 */       parameter.put("idannee", SessionMBean.getAnnee().getIdannee());
/* 161 */       parameter.put("idinstitution", SessionMBean.getInstitution().getIdinstitution());
/* 162 */       parameter.put("logo", SessionMBean.getLogo());
/* 163 */       Printer p = new Printer();
/* 164 */       p.print("/rapport/report_fr_ouest/buget_par_programme.jasper", parameter);
/* 165 */     } catch (Exception e) {
/* 166 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 171 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 175 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 179 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 183 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 187 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 191 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 195 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 196 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 200 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 204 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 208 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 212 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 216 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 220 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public Date getDate_de_debut() {
/* 224 */     return this.date_de_debut;
/*     */   }
/*     */   
/*     */   public void setDate_de_debut(Date date_de_debut) {
/* 228 */     this.date_de_debut = date_de_debut;
/*     */   }
/*     */   
/*     */   public Date getDate_de_fin() {
/* 232 */     return this.date_de_fin;
/*     */   }
/*     */   
/*     */   public void setDate_de_fin(Date date_de_fin) {
/* 236 */     this.date_de_fin = date_de_fin;
/*     */   }
/*     */   
/*     */   public Programme getProgramme() {
/* 240 */     return this.programme;
/*     */   }
/*     */   
/*     */   public void setProgramme(Programme programme) {
/* 244 */     this.programme = programme;
/*     */   }
/*     */   
/*     */   public List<Programme> getProgrammes() {
/* 248 */     this.programmes = this.programmeFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 249 */     return this.programmes;
/*     */   }
/*     */   
/*     */   public void setProgrammes(List<Programme> programmes) {
/* 253 */     this.programmes = programmes;
/*     */   }
/*     */   
/*     */   public Action getAction() {
/* 257 */     return this.action;
/*     */   }
/*     */   
/*     */   public void setAction(Action action) {
/* 261 */     this.action = action;
/*     */   }
/*     */   
/*     */   public List<Action> getActions() {
/* 265 */     return this.actions;
/*     */   }
/*     */   
/*     */   public void setActions(List<Action> actions) {
/* 269 */     this.actions = actions;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ImpressionAnalyseFROController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */