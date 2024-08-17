/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Elementcout;
/*     */ import entities.Imputation;
/*     */ import entities.Sousrubriquemercurial;
/*     */ import entities.Unite;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ElementcoutFacadeLocal;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.SousrubriquemercurialFacadeLocal;
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
/*     */ @SessionScoped
/*     */ public class ElementcoutController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private ElementcoutFacadeLocal elementcoutFacadeLocal;
/*  36 */   private Elementcout elementcout = new Elementcout();
/*  37 */   private List<Elementcout> elementcouts = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  41 */   private Imputation imputation = new Imputation();
/*  42 */   private List<Imputation> imputations = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SousrubriquemercurialFacadeLocal sousrubriquemercurialFacadeLocal;
/*  46 */   private Sousrubriquemercurial sousrubriquemercurial = new Sousrubriquemercurial();
/*  47 */   private List<Sousrubriquemercurial> sousrubriquemercurials = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private UniteFacadeLocal uniteFacadeLocal;
/*  51 */   private Unite unite = new Unite();
/*  52 */   private List<Unite> unites = new ArrayList<>();
/*     */   
/*  54 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  64 */     if (!Utilitaires.isAccess(Long.valueOf(5L))) {
/*  65 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de saisir les references mercuriales");
/*     */       return;
/*     */     } 
/*  68 */     this.elementcout = new Elementcout();
/*  69 */     this.imputation = new Imputation();
/*  70 */     this.unite = new Unite();
/*  71 */     this.sousrubriquemercurial = new Sousrubriquemercurial();
/*  72 */     this.mode = "Create";
/*  73 */     RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  77 */     if (this.elementcout != null) {
/*     */       
/*  79 */       if (!Utilitaires.isAccess(Long.valueOf(5L))) {
/*  80 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les references mercuriales");
/*     */         
/*     */         return;
/*     */       } 
/*  84 */       this.mode = "Edit";
/*  85 */       this.imputation = this.elementcout.getImputation();
/*     */       try {
/*  87 */         this.sousrubriquemercurial = this.elementcout.getSousrubriquemercurial();
/*  88 */       } catch (Exception e) {
/*  89 */         this.sousrubriquemercurial = new Sousrubriquemercurial();
/*     */       } 
/*     */       
/*     */       try {
/*  93 */         this.unite = this.elementcout.getUnite();
/*  94 */       } catch (Exception e) {
/*  95 */         this.unite = new Unite();
/*     */       } 
/*  97 */       RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/* 103 */       if ("Create".equals(this.mode)) {
/* 104 */         if (this.elementcoutFacadeLocal.findByCode(this.elementcout.getCode()) == null) {
/* 105 */           this.elementcout.setIdelementcout(Integer.valueOf(this.elementcoutFacadeLocal.nextId()));
/* 106 */           this.elementcout.setImputation(this.imputation);
/* 107 */           this.elementcout.setUnite(this.unite);
/* 108 */           this.elementcout.setSousrubriquemercurial(this.sousrubriquemercurial);
/* 109 */           this.elementcoutFacadeLocal.create(this.elementcout);
/* 110 */           this.elementcout = new Elementcout();
/* 111 */           this.imputation = new Imputation();
/* 112 */           this.detail = true;
/* 113 */           RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').hide()");
/* 114 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 116 */           JsfUtil.addWarningMessage("Un élément de cout possedant ce code existe");
/*     */         } 
/* 118 */       } else if ("Edit".equals(this.mode)) {
/* 119 */         if (this.elementcout != null) {
/* 120 */           this.elementcout.setImputation(this.imputationFacadeLocal.find(this.imputation.getIdimputation()));
/* 121 */           this.elementcout.setSousrubriquemercurial(this.sousrubriquemercurialFacadeLocal.find(this.sousrubriquemercurial.getIdsousrubriquemercurial()));
/* 122 */           this.elementcout.setUnite(this.uniteFacadeLocal.find(this.unite.getIdunite()));
/* 123 */           this.elementcoutFacadeLocal.edit(this.elementcout);
/* 124 */           this.elementcout = new Elementcout();
/* 125 */           this.imputation = new Imputation();
/* 126 */           this.detail = true;
/* 127 */           RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').hide()");
/* 128 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 130 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 133 */     } catch (Exception e) {
/* 134 */       e.printStackTrace();
/* 135 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 141 */       if (this.elementcout != null) {
/* 142 */         if (!Utilitaires.isAccess(Long.valueOf(5L))) {
/* 143 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer les references mercuriales");
/*     */           return;
/*     */         } 
/* 146 */         this.elementcoutFacadeLocal.remove(this.elementcout);
/* 147 */         this.elementcout = new Elementcout();
/* 148 */         this.detail = true;
/*     */       } else {
/* 150 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 152 */     } catch (Exception e) {
/* 153 */       e.printStackTrace();
/* 154 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 159 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 163 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 167 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 171 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Elementcout getElementcout() {
/* 175 */     return this.elementcout;
/*     */   }
/*     */   
/*     */   public void setElementcout(Elementcout elementcout) {
/* 179 */     this.elementcout = elementcout;
/*     */   }
/*     */   
/*     */   public List<Elementcout> getElementcouts() {
/* 183 */     this.elementcouts = this.elementcoutFacadeLocal.findAllRange();
/* 184 */     return this.elementcouts;
/*     */   }
/*     */   
/*     */   public void setElementcouts(List<Elementcout> elementcouts) {
/* 188 */     this.elementcouts = elementcouts;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 192 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 196 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 200 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 201 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(List<Imputation> imputations) {
/* 205 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public Sousrubriquemercurial getSousrubriquemercurial() {
/* 209 */     return this.sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
/* 213 */     this.sousrubriquemercurial = sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public List<Sousrubriquemercurial> getSousrubriquemercurials() {
/* 217 */     this.sousrubriquemercurials = this.sousrubriquemercurialFacadeLocal.findAllRange();
/* 218 */     return this.sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurials(List<Sousrubriquemercurial> sousrubriquemercurials) {
/* 222 */     this.sousrubriquemercurials = sousrubriquemercurials;
/*     */   }
/*     */   
/*     */   public Unite getUnite() {
/* 226 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(Unite unite) {
/* 230 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public List<Unite> getUnites() {
/* 234 */     this.unites = this.uniteFacadeLocal.findAll();
/* 235 */     return this.unites;
/*     */   }
/*     */   
/*     */   public void setUnites(List<Unite> unites) {
/* 239 */     this.unites = unites;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ElementcoutController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */