/*    */ package controllers;
/*    */ 
/*    */ import controllers.util.JsfUtil;
/*    */ import entities.Parametrage;
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.ejb.EJB;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import sessions.ParametrageFacadeLocal;
/*    */ import utilitaire.Utilitaires;
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
/*    */ public class ParamController
/*    */   implements Serializable
/*    */ {
/*    */   @EJB
/*    */   private ParametrageFacadeLocal parametrageFacadeLocal;
/* 28 */   private Parametrage parametrage = new Parametrage();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @PostConstruct
/*    */   private void init() {
/* 39 */     construct();
/*    */   }
/*    */   
/*    */   private void construct() {
/* 43 */     this.parametrage = this.parametrageFacadeLocal.findAll().get(0);
/*    */   }
/*    */   
/*    */   public void edit() {
/*    */     try {
/* 48 */       if (!Utilitaires.isAccess(Long.valueOf(1L))) {
/* 49 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les paramètres de base");
/*    */         return;
/*    */       } 
/* 52 */       if (this.parametrage != null) {
/* 53 */         this.parametrageFacadeLocal.edit(this.parametrage);
/* 54 */         construct();
/* 55 */         JsfUtil.addSuccessMessage("Opération réussie");
/*    */       } 
/* 57 */     } catch (Exception e) {
/* 58 */       JsfUtil.addFatalErrorMessage("Une exception survénue");
/*    */     } 
/*    */   }
/*    */   
/*    */   public Parametrage getParametrage() {
/* 63 */     return this.parametrage;
/*    */   }
/*    */   
/*    */   public void setParametrage(Parametrage parametrage) {
/* 67 */     this.parametrage = parametrage;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ParamController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */