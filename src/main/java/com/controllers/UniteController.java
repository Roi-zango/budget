/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Unite;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.UniteFacadeLocal;
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
/*     */ @ManagedBean
/*     */ @ViewScoped
/*     */ public class UniteController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private UniteFacadeLocal uniteFacadeLocal;
/*  30 */   private Unite unite = new Unite();
/*  31 */   private List<Unite> unites = new ArrayList<>();
/*     */   
/*  33 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  42 */     if (!Utilitaires.isAccess(Long.valueOf(2L))) {
/*  43 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit d'enregistrer les unités");
/*     */       return;
/*     */     } 
/*  46 */     this.unite = new Unite();
/*  47 */     this.mode = "Create";
/*  48 */     RequestContext.getCurrentInstance().execute("PF('UniteCreateDialog').show()");
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareEdit() {
/*  53 */     if (!Utilitaires.isAccess(Long.valueOf(2L))) {
/*  54 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les unités");
/*     */       return;
/*     */     } 
/*  57 */     if (this.unite != null) {
/*  58 */       this.mode = "Edit";
/*  59 */       RequestContext.getCurrentInstance().execute("PF('UniteCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  65 */       if ("Create".equals(this.mode)) {
/*     */         
/*  67 */         this.unite.setIdunite(Integer.valueOf(this.uniteFacadeLocal.nextId()));
/*  68 */         this.uniteFacadeLocal.create(this.unite);
/*  69 */         this.unite = new Unite();
/*  70 */         this.detail = true;
/*  71 */         RequestContext.getCurrentInstance().execute("PF('UniteCreateDialog').hide()");
/*  72 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       }
/*  74 */       else if ("Edit".equals(this.mode)) {
/*  75 */         if (this.unite != null) {
/*  76 */           this.uniteFacadeLocal.edit(this.unite);
/*  77 */           this.unite = new Unite();
/*  78 */           this.detail = true;
/*  79 */           RequestContext.getCurrentInstance().execute("PF('UniteCreateDialog').hide()");
/*  80 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  82 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/*  85 */     } catch (Exception e) {
/*  86 */       e.printStackTrace();
/*  87 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  93 */       if (!Utilitaires.isAccess(Long.valueOf(2L))) {
/*  94 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer les unités");
/*     */         
/*     */         return;
/*     */       } 
/*  98 */       this.detail = true;
/*  99 */       if (this.unite != null) {
/* 100 */         this.uniteFacadeLocal.remove(this.unite);
/* 101 */         this.detail = true;
/* 102 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 104 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 106 */     } catch (Exception e) {
/* 107 */       e.printStackTrace();
/* 108 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 113 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 117 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 121 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 125 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Unite getUnite() {
/* 129 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(Unite unite) {
/* 133 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public List<Unite> getUnites() {
/* 137 */     this.unites = this.uniteFacadeLocal.findAllRange();
/* 138 */     return this.unites;
/*     */   }
/*     */   
/*     */   public void setUnites(List<Unite> unites) {
/* 142 */     this.unites = unites;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\UniteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */