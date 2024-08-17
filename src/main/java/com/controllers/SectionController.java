/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Article;
/*     */ import entities.Section;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ArticleFacadeLocal;
/*     */ import sessions.SectionFacadeLocal;
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
/*     */ public class SectionController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private SectionFacadeLocal sectionFacadeLocal;
/*  31 */   private Section section = new Section();
/*  32 */   private List<Section> sections = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ArticleFacadeLocal articleFacadeLocal;
/*  36 */   private Article article = new Article();
/*  37 */   private List<Article> articles = new ArrayList<>();
/*     */   
/*  39 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  48 */     this.section = new Section();
/*  49 */     this.article = new Article();
/*  50 */     this.mode = "Create";
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  54 */     if (this.section != null) {
/*  55 */       this.article = this.section.getArticle();
/*  56 */       this.mode = "Edit";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  62 */       if ("Create".equals(this.mode)) {
/*  63 */         if (this.sectionFacadeLocal.findByCode(this.section.getCode()) == null) {
/*  64 */           this.section.setIdsection(Integer.valueOf(this.sectionFacadeLocal.nextId()));
/*  65 */           this.section.setArticle(this.article);
/*  66 */           this.sectionFacadeLocal.create(this.section);
/*  67 */           this.section = new Section();
/*  68 */           this.article = new Article();
/*  69 */           this.detail = true;
/*  70 */           RequestContext.getCurrentInstance().execute("PF('SousRubriqueMCreateDialog').hide()");
/*  71 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  73 */           JsfUtil.addWarningMessage("Une section possedant ce code existe");
/*     */         } 
/*  75 */       } else if ("Edit".equals(this.mode)) {
/*  76 */         if (this.section != null) {
/*  77 */           this.section.setArticle(this.articleFacadeLocal.find(this.article.getIdarticle()));
/*  78 */           this.sectionFacadeLocal.edit(this.section);
/*  79 */           this.section = new Section();
/*  80 */           this.article = new Article();
/*  81 */           this.detail = true;
/*  82 */           RequestContext.getCurrentInstance().execute("PF('SousRubriqueMCreateDialog').hide()");
/*  83 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  85 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/*  88 */     } catch (Exception e) {
/*  89 */       e.printStackTrace();
/*  90 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  96 */       if (this.section != null) {
/*  97 */         this.sectionFacadeLocal.remove(this.section);
/*  98 */         this.section = new Section();
/*  99 */         this.detail = true;
/*     */       } else {
/* 101 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 103 */     } catch (Exception e) {
/* 104 */       e.printStackTrace();
/* 105 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 110 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 114 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 118 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 122 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Section getSection() {
/* 126 */     return this.section;
/*     */   }
/*     */   
/*     */   public void setSection(Section section) {
/* 130 */     this.section = section;
/*     */   }
/*     */   
/*     */   public List<Section> getSections() {
/* 134 */     this.sections = this.sectionFacadeLocal.findAllRange();
/* 135 */     return this.sections;
/*     */   }
/*     */   
/*     */   public void setSections(List<Section> sections) {
/* 139 */     this.sections = sections;
/*     */   }
/*     */   
/*     */   public Article getArticle() {
/* 143 */     return this.article;
/*     */   }
/*     */   
/*     */   public void setArticle(Article article) {
/* 147 */     this.article = article;
/*     */   }
/*     */   
/*     */   public List<Article> getArticles() {
/* 151 */     this.articles = this.articleFacadeLocal.findAllRange();
/* 152 */     return this.articles;
/*     */   }
/*     */   
/*     */   public void setArticles(List<Article> articles) {
/* 156 */     this.articles = articles;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\SectionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */