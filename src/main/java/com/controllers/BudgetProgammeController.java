/*    */ package controllers;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import utilitaire.Printer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ManagedBean
/*    */ @ViewScoped
/*    */ public class BudgetProgammeController
/*    */   implements Serializable
/*    */ {
/* 28 */   private Printer printer = new Printer();
/*    */   
/*    */   @PostConstruct
/*    */   private void init() {
/* 32 */     this.printer = new Printer();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void print() {
/*    */     try {
/* 41 */       String cdmdt = "1";
/* 42 */       Map<Object, Object> parameter = new HashMap<>();
/* 43 */       this.printer.print("/rapport/s_cdmt_etat_action_activite_tachebp.jasper", parameter);
/* 44 */     } catch (Exception e) {
/* 45 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void print1() {
/*    */     try {
/* 51 */       String cdmdt = "1";
/* 52 */       Map<Object, Object> parameter = new HashMap<>();
/*    */       
/* 54 */       this.printer.print("/rapport/resumesdesetats.jasper", parameter);
/*    */     }
/* 56 */     catch (Exception e) {
/* 57 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void print2() {
/*    */     try {
/* 64 */       String cdmdt = "1";
/* 65 */       Map<Object, Object> parameter = new HashMap<>();
/*    */       
/* 67 */       this.printer.print("/rapport/codificationbudget.jasper", parameter);
/*    */     }
/* 69 */     catch (Exception e) {
/* 70 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\BudgetProgammeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */