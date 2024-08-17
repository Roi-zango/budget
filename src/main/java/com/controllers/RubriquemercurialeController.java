/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Rubriquemercurial;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.RubriquemercurialFacadeLocal;
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
/*     */ @SessionScoped
/*     */ public class RubriquemercurialeController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private RubriquemercurialFacadeLocal rubriquemercurialFacadeLocal;
/*  30 */   private Rubriquemercurial rubriquemercurial = new Rubriquemercurial();
/*  31 */   private List<Rubriquemercurial> rubriquemercurials = new ArrayList<>();
/*     */   
/*  33 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  43 */     if (!Utilitaires.isAccess(Long.valueOf(3L))) {
/*  44 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit d'enregistrer les rubriques mercuriales");
/*     */       return;
/*     */     } 
/*  47 */     this.rubriquemercurial = new Rubriquemercurial();
/*  48 */     this.mode = "Create";
/*  49 */     RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  53 */     if (!Utilitaires.isAccess(Long.valueOf(3L))) {
/*  54 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les rubriques mercuriales");
/*     */       return;
/*     */     } 
/*  57 */     if (this.rubriquemercurial != null) {
/*  58 */       this.mode = "Edit";
/*  59 */       RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  65 */       if ("Create".equals(this.mode)) {
/*  66 */         if (this.rubriquemercurialFacadeLocal.findByCode(this.rubriquemercurial.getCode()) == null) {
/*  67 */           this.rubriquemercurial.setIdrubriquemercurial(Integer.valueOf(this.rubriquemercurialFacadeLocal.nextId()));
/*  68 */           this.rubriquemercurialFacadeLocal.create(this.rubriquemercurial);
/*  69 */           this.rubriquemercurial = new Rubriquemercurial();
/*  70 */           this.detail = true;
/*  71 */           RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').hide()");
/*  72 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  74 */           JsfUtil.addWarningMessage("Une Rubrique possedant ce code existe");
/*     */         } 
/*  76 */       } else if ("Edit".equals(this.mode)) {
/*  77 */         if (this.rubriquemercurial != null) {
/*  78 */           this.rubriquemercurialFacadeLocal.edit(this.rubriquemercurial);
/*  79 */           this.rubriquemercurial = new Rubriquemercurial();
/*  80 */           this.detail = true;
/*  81 */           RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').hide()");
/*  82 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  84 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/*  87 */     } catch (Exception e) {
/*  88 */       e.printStackTrace();
/*  89 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  95 */       if (!Utilitaires.isAccess(Long.valueOf(3L))) {
/*  96 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer les rubriques mercuriales");
/*     */         return;
/*     */       } 
/*  99 */       this.detail = true;
/* 100 */       if (this.rubriquemercurial != null) {
/* 101 */         this.rubriquemercurialFacadeLocal.remove(this.rubriquemercurial);
/* 102 */         this.detail = true;
/* 103 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 105 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 107 */     } catch (Exception e) {
/* 108 */       e.printStackTrace();
/* 109 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 114 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 118 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 122 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 126 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Rubriquemercurial getRubriquemercurial() {
/* 130 */     return this.rubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurial(Rubriquemercurial rubriquemercurial) {
/* 134 */     this.rubriquemercurial = rubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Rubriquemercurial> getRubriquemercurials() {
/* 138 */     this.rubriquemercurials = this.rubriquemercurialFacadeLocal.findAllRange();
/* 139 */     return this.rubriquemercurials;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurials(List<Rubriquemercurial> rubriquemercurials) {
/* 143 */     this.rubriquemercurials = rubriquemercurials;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\RubriquemercurialeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */