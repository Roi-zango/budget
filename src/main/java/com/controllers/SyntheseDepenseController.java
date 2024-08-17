/*    */ package controllers;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class SyntheseDepenseController
/*    */   implements Serializable
/*    */ {
/* 27 */   Printer printer = new Printer();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void print() {
/*    */     try {
/* 35 */       Map<Object, Object> parameter = new HashMap<>();
/*    */       
/* 37 */       this.printer.print("/rapport/report3.jasper", parameter);
/*    */     }
/* 39 */     catch (Exception e) {
/* 40 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\SyntheseDepenseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */