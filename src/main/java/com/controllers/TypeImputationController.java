/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Typeimputation;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.TypeimputationFacadeLocal;
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
/*     */ public class TypeImputationController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private TypeimputationFacadeLocal typeimputationFacadeLocal;
/*  29 */   private Typeimputation typeimputation = new Typeimputation();
/*  30 */   private List<Typeimputation> typeimputations = new ArrayList<>();
/*     */   
/*  32 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  42 */     this.mode = "Create";
/*  43 */     this.typeimputation = new Typeimputation();
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  47 */     if (this.typeimputation != null) {
/*  48 */       this.mode = "Edit";
/*     */     }
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  54 */       if ("Create".equals(this.mode)) {
/*  55 */         this.typeimputation.setIdtypeimputation(Integer.valueOf(this.typeimputationFacadeLocal.nextId()));
/*  56 */         this.typeimputationFacadeLocal.create(this.typeimputation);
/*  57 */         this.typeimputation = new Typeimputation();
/*  58 */         this.detail = true;
/*  59 */         RequestContext.getCurrentInstance().execute("PF('TypeimputationCreateDialog').hide()");
/*  60 */         JsfUtil.addSuccessMessage("Opération réussie");
/*  61 */       } else if ("Edit".equals(this.mode)) {
/*  62 */         if (this.typeimputation != null) {
/*  63 */           this.typeimputationFacadeLocal.edit(this.typeimputation);
/*  64 */           this.typeimputation = new Typeimputation();
/*  65 */           this.detail = true;
/*  66 */           RequestContext.getCurrentInstance().execute("PF('TypeimputationCreateDialog').hide()");
/*  67 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  69 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/*  72 */     } catch (Exception e) {
/*  73 */       e.printStackTrace();
/*  74 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  80 */       this.detail = true;
/*  81 */       if (this.typeimputation != null) {
/*  82 */         this.typeimputationFacadeLocal.remove(this.typeimputation);
/*  83 */         this.typeimputation = new Typeimputation();
/*  84 */         this.detail = true;
/*  85 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/*  87 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/*  89 */     } catch (Exception e) {
/*  90 */       e.printStackTrace();
/*  91 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/*  96 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 100 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 104 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 108 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Typeimputation getTypeimputation() {
/* 112 */     return this.typeimputation;
/*     */   }
/*     */   
/*     */   public void setTypeimputation(Typeimputation typeimputation) {
/* 116 */     this.typeimputation = typeimputation;
/*     */   }
/*     */   
/*     */   public List<Typeimputation> getTypeimputations() {
/* 120 */     this.typeimputations = this.typeimputationFacadeLocal.findAllRageCode();
/* 121 */     return this.typeimputations;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\TypeImputationController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */