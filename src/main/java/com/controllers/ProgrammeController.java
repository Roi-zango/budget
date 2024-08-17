/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Axestrategique;
/*     */ import entities.Programme;
/*     */ import entities.Soussecteur;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ProgrammeFacadeLocal;
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
/*     */ public class ProgrammeController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private ProgrammeFacadeLocal programmeFacadeLocal;
/*  32 */   private Programme programme = new Programme();
/*  33 */   private List<Programme> programmes = new ArrayList<>();
/*     */   
/*  35 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  44 */     this.programme = new Programme();
/*  45 */     this.programme.setEtat("Actif");
/*  46 */     this.programme.setObjectifs("-");
/*  47 */     this.programme.setIndicateur("-");
/*  48 */     this.mode = "Create";
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  52 */     if (this.programme != null) {
/*  53 */       this.mode = "Edit";
/*     */     }
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  59 */       if ("Create".equals(this.mode)) {
/*  60 */         if (this.programmeFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), this.programme.getCode()) == null) {
/*  61 */           this.programme.setIdprogramme(this.programmeFacadeLocal.nextId());
/*  62 */           this.programme.setIdaxestrategique(new Axestrategique(Long.valueOf(1L)));
/*  63 */           this.programme.setIdsoussecteur(new Soussecteur(Long.valueOf(1L)));
/*  64 */           this.programme.setIdinstitution(SessionMBean.getInstitution());
/*  65 */           this.programmeFacadeLocal.create(this.programme);
/*  66 */           this.programme = new Programme();
/*     */           
/*  68 */           this.detail = true;
/*  69 */           RequestContext.getCurrentInstance().execute("PF('ProgrammeCreateDialog').hide()");
/*  70 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  72 */           JsfUtil.addWarningMessage("Un programme possedant ce code existe déjà");
/*     */         } 
/*  74 */       } else if ("Edit".equals(this.mode)) {
/*  75 */         if (this.programme != null) {
/*  76 */           this.programmeFacadeLocal.edit(this.programme);
/*  77 */           this.programme = new Programme();
/*  78 */           this.detail = true;
/*  79 */           RequestContext.getCurrentInstance().execute("PF('ProgrammeCreateDialog').hide()");
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
/*  93 */       this.detail = true;
/*  94 */       if (this.programme != null) {
/*  95 */         this.programmeFacadeLocal.remove(this.programme);
/*  96 */         this.detail = true;
/*  97 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/*  99 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 101 */     } catch (Exception e) {
/* 102 */       e.printStackTrace();
/* 103 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 108 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 112 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 116 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 120 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Programme getProgramme() {
/* 124 */     return this.programme;
/*     */   }
/*     */   
/*     */   public void setProgramme(Programme programme) {
/* 128 */     this.programme = programme;
/*     */   }
/*     */   
/*     */   public List<Programme> getProgrammes() {
/* 132 */     this.programmes = this.programmeFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 133 */     return this.programmes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ProgrammeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */