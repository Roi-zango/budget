/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Signataire;
/*     */ import entities.Structure;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.SignataireFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
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
/*     */ public class SignataireController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   protected SignataireFacadeLocal signataireFacadeLocal;
/*  32 */   protected Signataire signataire = new Signataire();
/*  33 */   protected List<Signataire> signataires = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected StructureFacadeLocal structureFacadeLocal;
/*  37 */   protected Structure structure = new Structure();
/*  38 */   protected List<Structure> structures = new ArrayList<>();
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
/*  49 */     this.signataire = new Signataire();
/*  50 */     this.structure = new Structure();
/*  51 */     this.mode = "Create";
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  55 */     if (this.signataire != null) {
/*  56 */       this.structure = this.signataire.getStructure();
/*  57 */       this.mode = "Edit";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  63 */       if ("Create".equals(this.mode)) {
/*  64 */         this.signataire.setIdsignataire(Integer.valueOf(this.signataireFacadeLocal.nextId()));
/*  65 */         this.signataire.setStructure(this.structure);
/*  66 */         this.signataireFacadeLocal.create(this.signataire);
/*  67 */         this.signataire = new Signataire();
/*  68 */         this.structure = new Structure();
/*  69 */         this.detail = true;
/*  70 */         RequestContext.getCurrentInstance().execute("PF('SignataireCreateDialog').hide()");
/*  71 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       }
/*  73 */       else if ("Edit".equals(this.mode)) {
/*  74 */         if (this.signataire != null) {
/*  75 */           this.signataire.setStructure(this.structureFacadeLocal.find(this.structure.getIdstructure()));
/*  76 */           this.signataireFacadeLocal.edit(this.signataire);
/*  77 */           this.signataire = new Signataire();
/*  78 */           this.structure = new Structure();
/*  79 */           this.detail = true;
/*  80 */           RequestContext.getCurrentInstance().execute("PF('SignataireCreateDialog').hide()");
/*  81 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  83 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/*  86 */     } catch (Exception e) {
/*  87 */       e.printStackTrace();
/*  88 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/*  94 */       if (this.signataire != null) {
/*  95 */         this.signataireFacadeLocal.remove(this.signataire);
/*  96 */         this.signataire = new Signataire();
/*  97 */         this.detail = true;
/*  98 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 100 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 102 */     } catch (Exception e) {
/* 103 */       e.printStackTrace();
/* 104 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 109 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 113 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 117 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 121 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 125 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 129 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public List<Signataire> getSignataires() {
/* 133 */     this.signataires = this.signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 134 */     return this.signataires;
/*     */   }
/*     */   
/*     */   public void setSignataires(List<Signataire> signataires) {
/* 138 */     this.signataires = signataires;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 142 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 146 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 150 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue(), "Actif");
/* 151 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 155 */     this.structures = structures;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\SignataireController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */