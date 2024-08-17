/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Article;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ArticleFacadeLocal;
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
/*     */ public class ArticleController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private ArticleFacadeLocal articleFacadeLocal;
/*  29 */   private Article article = new Article();
/*  30 */   private List<Article> articles = new ArrayList<>();
/*     */   
/*  32 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  41 */     this.article = new Article();
/*  42 */     this.mode = "Create";
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  46 */     if (this.article != null) {
/*  47 */       this.mode = "Edit";
/*     */     }
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  53 */       if ("Create".equals(this.mode)) {
/*  54 */         if (this.articleFacadeLocal.findByCode(this.article.getCode()) == null) {
/*  55 */           this.article.setIdarticle(Integer.valueOf(this.articleFacadeLocal.nextId()));
/*  56 */           this.articleFacadeLocal.create(this.article);
/*  57 */           this.article = new Article();
/*  58 */           this.detail = true;
/*  59 */           RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').hide()");
/*  60 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  62 */           JsfUtil.addWarningMessage("Une Rubrique possedant ce code existe");
/*     */         } 
/*  64 */       } else if ("Edit".equals(this.mode)) {
/*  65 */         if (this.article != null) {
/*  66 */           this.articleFacadeLocal.edit(this.article);
/*  67 */           this.article = new Article();
/*  68 */           this.detail = true;
/*  69 */           RequestContext.getCurrentInstance().execute("PF('RubriqueMercurialCreateDialog').hide()");
/*  70 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  72 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/*  75 */     } catch (Exception e) {
/*  76 */       e.printStackTrace();
/*  77 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  83 */       this.detail = true;
/*  84 */       if (this.article != null) {
/*  85 */         this.articleFacadeLocal.remove(this.article);
/*  86 */         this.detail = true;
/*  87 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/*  89 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/*  91 */     } catch (Exception e) {
/*  92 */       e.printStackTrace();
/*  93 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/*  98 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 102 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 106 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 110 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Article getArticle() {
/* 114 */     return this.article;
/*     */   }
/*     */   
/*     */   public void setArticle(Article article) {
/* 118 */     this.article = article;
/*     */   }
/*     */   
/*     */   public List<Article> getArticles() {
/* 122 */     this.articles = this.articleFacadeLocal.findAllRange();
/* 123 */     return this.articles;
/*     */   }
/*     */   
/*     */   public void setArticles(List<Article> articles) {
/* 127 */     this.articles = articles;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ArticleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */