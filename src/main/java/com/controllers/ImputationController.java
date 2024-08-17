/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Imputation;
/*     */ import entities.Rubrique;
/*     */ import entities.Section;
/*     */ import entities.Sousrubrique;
/*     */ import entities.Typeimputation;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ImputationFacadeLocal;
/*     */ import sessions.RubriqueFacadeLocal;
/*     */ import sessions.SectionFacadeLocal;
/*     */ import sessions.SousrubriqueFacadeLocal;
/*     */ import sessions.TypeimputationFacadeLocal;
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
/*     */ public class ImputationController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private ImputationFacadeLocal imputationFacadeLocal;
/*  39 */   private Imputation imputation = new Imputation();
/*  40 */   private List<Imputation> imputations = new ArrayList<>();
/*  41 */   private List<Imputation> imputationTest = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SousrubriqueFacadeLocal sousrubriqueFacadeLocal;
/*  45 */   private Sousrubrique sousrubrique = new Sousrubrique();
/*  46 */   private List<Sousrubrique> sousrubriques = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RubriqueFacadeLocal rubriqueFacadeLocal;
/*  50 */   private Rubrique rubrique = new Rubrique();
/*  51 */   private List<Rubrique> rubriques = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SectionFacadeLocal sectionFacadeLocal;
/*  55 */   private Section section = new Section();
/*  56 */   private List<Section> sections = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private TypeimputationFacadeLocal typeimputationFacadeLocal;
/*  60 */   private Typeimputation typeimputation = new Typeimputation();
/*  61 */   private List<Typeimputation> typeimputations = new ArrayList<>();
/*     */   
/*  63 */   private String mode = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void init() {
/*  76 */     this.imputations = this.imputationFacadeLocal.findAllOrder();
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*     */     try {
/*  81 */       if (!Utilitaires.isAccess(Long.valueOf(10L))) {
/*  82 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'enregistrer le paragraphe");
/*     */         return;
/*     */       } 
/*  85 */       this.mode = "Create";
/*  86 */       this.imputation = new Imputation();
/*  87 */       this.imputation.setEtat("Actif");
/*  88 */       this.section = new Section();
/*  89 */       this.typeimputation = new Typeimputation();
/*  90 */       RequestContext.getCurrentInstance().execute("PF('ParagrapheCreateDialog').show()");
/*  91 */     } catch (Exception e) {
/*  92 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  97 */     if (!Utilitaires.isAccess(Long.valueOf(10L))) {
/*  98 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier le paragraphe");
/*     */       return;
/*     */     } 
/* 101 */     if (this.imputation != null) {
/* 102 */       this.mode = "Edit";
/* 103 */       this.sousrubrique = this.imputation.getIdsousrubrique();
/*     */       
/* 105 */       this.rubrique = this.sousrubrique.getIdrubrique();
/* 106 */       this.sousrubriques = this.sousrubriqueFacadeLocal.findByRubrique(this.rubrique.getIdrubrique().intValue());
/*     */       try {
/* 108 */         this.section = this.imputation.getSection();
/* 109 */         if (this.section == null) {
/* 110 */           this.section = new Section();
/*     */         }
/* 112 */       } catch (Exception e) {
/* 113 */         this.section = new Section();
/*     */       } 
/*     */       
/*     */       try {
/* 117 */         this.typeimputation = this.imputation.getIdtypeimputation();
/* 118 */         if (this.typeimputation == null) {
/* 119 */           this.typeimputation = new Typeimputation();
/*     */         }
/* 121 */       } catch (Exception e) {
/* 122 */         this.typeimputation = new Typeimputation();
/*     */       } 
/* 124 */       RequestContext.getCurrentInstance().execute("PF('ParagrapheCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void filterSousrubriqueByRubrique() {
/*     */     try {
/* 130 */       this.sousrubriques.clear();
/* 131 */       if (this.rubrique != null) {
/* 132 */         this.sousrubriques = this.sousrubriqueFacadeLocal.findByRubrique(this.rubrique.getIdrubrique().intValue());
/*     */       }
/* 134 */     } catch (Exception e) {
/* 135 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void afficher() {
/* 141 */     this.imputations.clear();
/*     */     try {
/* 143 */       if (this.rubrique != null && this.sousrubrique != null) {
/* 144 */         this.imputations = this.imputationFacadeLocal.find(this.rubrique.getIdrubrique().intValue(), this.sousrubrique.getIdsousrubrique().intValue());
/* 145 */         if (this.imputations.isEmpty()) {
/* 146 */           JsfUtil.addErrorMessage("Aucun résultat trouvé");
/*     */         }
/*     */       } else {
/* 149 */         JsfUtil.addErrorMessage("Sousrubrique  nul");
/*     */       } 
/* 151 */     } catch (Exception e) {
/* 152 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/* 158 */       if (this.imputation != null) {
/* 159 */         if ("Create".equals(this.mode)) {
/* 160 */           this.imputation.setIdimputation(Long.valueOf(this.imputationFacadeLocal.nextId()));
/* 161 */           this.imputation.setIdsousrubrique(this.sousrubrique);
/* 162 */           this.imputation.setEtat("Actif");
/* 163 */           this.imputation.setSection(this.section);
/* 164 */           this.imputation.setIdtypeimputation(this.typeimputation);
/* 165 */           this.imputationFacadeLocal.create(this.imputation);
/*     */           
/* 167 */           this.mode = "";
/* 168 */           this.detail = true;
/* 169 */           this.imputation = new Imputation();
/* 170 */           JsfUtil.addSuccessMessage("Opération réussie");
/* 171 */           RequestContext.getCurrentInstance().execute("PF('ParagrapheCreateDialog').hide()");
/* 172 */           this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 173 */         } else if ("Edit".equals(this.mode)) {
/* 174 */           this.imputation.setIdsousrubrique(this.sousrubrique);
/* 175 */           this.imputation.setSection(this.sectionFacadeLocal.find(this.section.getIdsection()));
/* 176 */           this.imputation.setIdtypeimputation(this.typeimputation);
/* 177 */           this.imputationFacadeLocal.edit(this.imputation);
/*     */           
/* 179 */           this.mode = "";
/* 180 */           this.detail = true;
/* 181 */           this.imputation = new Imputation();
/* 182 */           JsfUtil.addSuccessMessage("Opération réussie");
/* 183 */           RequestContext.getCurrentInstance().execute("PF('ParagrapheCreateDialog').hide()");
/* 184 */           this.imputations = this.imputationFacadeLocal.findAllOrder();
/*     */         } else {
/* 186 */           JsfUtil.addErrorMessage("Veuillez verifier les données");
/*     */         } 
/*     */       }
/* 189 */     } catch (Exception e) {
/* 190 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 196 */       if (this.imputation != null) {
/*     */         
/* 198 */         if (!Utilitaires.isAccess(Long.valueOf(10L))) {
/* 199 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer les paragraphes");
/*     */           return;
/*     */         } 
/* 202 */         this.imputationFacadeLocal.remove(this.imputation);
/* 203 */         this.imputations = this.imputationFacadeLocal.findAllOrder();
/* 204 */         this.imputation = new Imputation();
/* 205 */         this.detail = true;
/* 206 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 208 */         JsfUtil.addErrorMessage("Aucune ligne selectionée");
/*     */       } 
/* 210 */     } catch (Exception e) {
/* 211 */       e.printStackTrace();
/* 212 */       JsfUtil.addFatalErrorMessage("Exception, Impossible de suppimer");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 217 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 221 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 225 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 229 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public List<Imputation> getImputations() {
/* 233 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public Sousrubrique getSousrubrique() {
/* 237 */     return this.sousrubrique;
/*     */   }
/*     */   
/*     */   public void setSousrubrique(Sousrubrique sousrubrique) {
/* 241 */     this.sousrubrique = sousrubrique;
/*     */   }
/*     */   
/*     */   public List<Sousrubrique> getSousrubriques() {
/* 245 */     return this.sousrubriques;
/*     */   }
/*     */   
/*     */   public Rubrique getRubrique() {
/* 249 */     return this.rubrique;
/*     */   }
/*     */   
/*     */   public void setRubrique(Rubrique rubrique) {
/* 253 */     this.rubrique = rubrique;
/*     */   }
/*     */   
/*     */   public List<Rubrique> getRubriques() {
/* 257 */     this.rubriques = this.rubriqueFacadeLocal.findAllRangeCode();
/* 258 */     return this.rubriques;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 262 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 266 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Section getSection() {
/* 270 */     return this.section;
/*     */   }
/*     */   
/*     */   public void setSection(Section section) {
/* 274 */     this.section = section;
/*     */   }
/*     */   
/*     */   public List<Section> getSections() {
/* 278 */     this.sections = this.sectionFacadeLocal.findAllRange();
/* 279 */     return this.sections;
/*     */   }
/*     */   
/*     */   public void setSections(List<Section> sections) {
/* 283 */     this.sections = sections;
/*     */   }
/*     */   
/*     */   public Typeimputation getTypeimputation() {
/* 287 */     return this.typeimputation;
/*     */   }
/*     */   
/*     */   public void setTypeimputation(Typeimputation typeimputation) {
/* 291 */     this.typeimputation = typeimputation;
/*     */   }
/*     */   
/*     */   public List<Typeimputation> getTypeimputations() {
/* 295 */     this.typeimputations = this.typeimputationFacadeLocal.findAllRageCode();
/* 296 */     return this.typeimputations;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 300 */     return this.mode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ImputationController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */