/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Rubriquemercurial;
/*     */ import entities.Sousrubriquemercurial;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.RubriquemercurialFacadeLocal;
/*     */ import sessions.SousrubriquemercurialFacadeLocal;
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
/*     */ public class SousrubriquemercurialController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private SousrubriquemercurialFacadeLocal sousrubriquemercurialFacadeLocal;
/*  32 */   private Sousrubriquemercurial sousrubriquemercurial = new Sousrubriquemercurial();
/*  33 */   private List<Sousrubriquemercurial> sousrubriquemercurials = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RubriquemercurialFacadeLocal rubriquemercurialFacadeLocal;
/*  37 */   private Rubriquemercurial rubriquemercurial = new Rubriquemercurial();
/*  38 */   private List<Rubriquemercurial> rubriquemercurials = new ArrayList<>();
/*     */   
/*  40 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  49 */     if (!Utilitaires.isAccess(Long.valueOf(4L))) {
/*  50 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit d'enregistrer les sous - rubriques mercuriales");
/*     */       return;
/*     */     } 
/*  53 */     this.sousrubriquemercurial = new Sousrubriquemercurial();
/*  54 */     this.rubriquemercurial = new Rubriquemercurial();
/*  55 */     this.mode = "Create";
/*  56 */     RequestContext.getCurrentInstance().execute("PF('SousRubriqueMCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  60 */     if (!Utilitaires.isAccess(Long.valueOf(4L))) {
/*  61 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les sous - rubriques mercuriales");
/*     */       return;
/*     */     } 
/*  64 */     if (this.sousrubriquemercurial != null) {
/*  65 */       this.rubriquemercurial = this.sousrubriquemercurial.getRubriquemercurial();
/*  66 */       this.mode = "Edit";
/*     */     } 
/*  68 */     RequestContext.getCurrentInstance().execute("PF('SousRubriqueMCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  73 */       if ("Create".equals(this.mode)) {
/*  74 */         if (this.sousrubriquemercurialFacadeLocal.findByCode(this.rubriquemercurial.getIdrubriquemercurial().intValue(), this.sousrubriquemercurial.getCode()) == null) {
/*  75 */           this.sousrubriquemercurial.setIdsousrubriquemercurial(Integer.valueOf(this.sousrubriquemercurialFacadeLocal.nextId()));
/*  76 */           this.sousrubriquemercurial.setRubriquemercurial(this.rubriquemercurial);
/*  77 */           this.sousrubriquemercurialFacadeLocal.create(this.sousrubriquemercurial);
/*  78 */           this.sousrubriquemercurial = new Sousrubriquemercurial();
/*  79 */           this.rubriquemercurial = new Rubriquemercurial();
/*  80 */           this.detail = true;
/*  81 */           RequestContext.getCurrentInstance().execute("PF('SousRubriqueMCreateDialog').hide()");
/*  82 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  84 */           JsfUtil.addWarningMessage("Une sous rubrique possedant ce code existe");
/*     */         } 
/*  86 */       } else if ("Edit".equals(this.mode)) {
/*  87 */         if (this.sousrubriquemercurial != null) {
/*  88 */           this.sousrubriquemercurial.setRubriquemercurial(this.rubriquemercurialFacadeLocal.find(this.rubriquemercurial.getIdrubriquemercurial()));
/*  89 */           this.sousrubriquemercurialFacadeLocal.edit(this.sousrubriquemercurial);
/*  90 */           this.sousrubriquemercurial = new Sousrubriquemercurial();
/*  91 */           this.rubriquemercurial = new Rubriquemercurial();
/*  92 */           this.detail = true;
/*  93 */           RequestContext.getCurrentInstance().execute("PF('SousRubriqueMCreateDialog').hide()");
/*  94 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  96 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/*  99 */     } catch (Exception e) {
/* 100 */       e.printStackTrace();
/* 101 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 107 */       if (!Utilitaires.isAccess(Long.valueOf(4L))) {
/* 108 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer les sous - rubriques mercuriales");
/*     */         return;
/*     */       } 
/* 111 */       if (this.sousrubriquemercurial != null) {
/* 112 */         this.sousrubriquemercurialFacadeLocal.remove(this.sousrubriquemercurial);
/* 113 */         this.sousrubriquemercurial = new Sousrubriquemercurial();
/* 114 */         this.detail = true;
/*     */       } else {
/* 116 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 118 */     } catch (Exception e) {
/* 119 */       e.printStackTrace();
/* 120 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 125 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 129 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 133 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 137 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Sousrubriquemercurial getSousrubriquemercurial() {
/* 141 */     return this.sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
/* 145 */     this.sousrubriquemercurial = sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Sousrubriquemercurial> getSousrubriquemercurials() {
/* 149 */     this.sousrubriquemercurials = this.sousrubriquemercurialFacadeLocal.findAllRange();
/* 150 */     return this.sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurials(List<Sousrubriquemercurial> sousrubriquemercurials) {
/* 154 */     this.sousrubriquemercurials = sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public Rubriquemercurial getRubriquemercurial() {
/* 158 */     return this.rubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurial(Rubriquemercurial rubriquemercurial) {
/* 162 */     this.rubriquemercurial = rubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Rubriquemercurial> getRubriquemercurials() {
/* 166 */     this.rubriquemercurials = this.rubriquemercurialFacadeLocal.findAllRange();
/* 167 */     return this.rubriquemercurials;
/*     */   }
/*     */   
/*     */   public void setRubriquemercurials(List<Rubriquemercurial> rubriquemercurials) {
/* 171 */     this.rubriquemercurials = rubriquemercurials;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\SousrubriquemercurialController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */