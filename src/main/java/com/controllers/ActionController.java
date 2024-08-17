/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Action;
/*     */ import entities.Programme;
/*     */ import entities.Zone;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.ActionFacadeLocal;
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
/*     */ public class ActionController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private ActionFacadeLocal actionFacadeLocal;
/*  33 */   private Action action = new Action();
/*  34 */   private List<Action> actions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ProgrammeFacadeLocal programmeFacadeLocal;
/*  38 */   private Programme programme = new Programme();
/*  39 */   private List<Programme> programmes = new ArrayList<>();
/*     */   
/*  41 */   private String mode = "";
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  49 */     this.mode = "Create";
/*  50 */     this.programme = new Programme();
/*  51 */     this.action = new Action();
/*  52 */     this.action.setObjectifs("-");
/*  53 */     this.action.setIndicateur("-");
/*  54 */     this.action.setEtat("Actif");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  58 */     if (this.action != null) {
/*  59 */       this.programme = this.action.getIdprogramme();
/*  60 */       this.mode = "Edit";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  66 */       if ("Create".equals(this.mode)) {
/*  67 */         if (this.actionFacadeLocal.findByInstitution(SessionMBean.getInstitution().getIdinstitution(), this.action.getCode()) == null) {
/*  68 */           this.action.setIdaction(this.actionFacadeLocal.nextId());
/*  69 */           this.action.setIdprogramme(this.programme);
/*  70 */           this.action.setIdzone(new Zone(Long.valueOf(1L)));
/*  71 */           this.actionFacadeLocal.create(this.action);
/*  72 */           this.programme = new Programme();
/*  73 */           this.action = new Action();
/*  74 */           this.detail = true;
/*  75 */           RequestContext.getCurrentInstance().execute("PF('ActionCreateDialog').hide()");
/*  76 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  78 */           JsfUtil.addWarningMessage("Une action ayant ce code existe déjà");
/*     */         } 
/*  80 */       } else if ("Edit".equals(this.mode)) {
/*  81 */         if (this.action != null) {
/*  82 */           this.action.setIdprogramme(this.programmeFacadeLocal.find(this.programme.getIdprogramme()));
/*  83 */           this.actionFacadeLocal.edit(this.action);
/*  84 */           this.action = new Action();
/*  85 */           this.programme = new Programme();
/*  86 */           this.detail = true;
/*  87 */           RequestContext.getCurrentInstance().execute("PF('ActionCreateDialog').hide()");
/*  88 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/*  90 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/*  93 */     } catch (Exception e) {
/*  94 */       e.printStackTrace();
/*  95 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 101 */       this.detail = true;
/* 102 */       if (this.action != null) {
/* 103 */         this.actionFacadeLocal.remove(this.action);
/* 104 */         this.detail = true;
/* 105 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 107 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 109 */     } catch (Exception e) {
/* 110 */       e.printStackTrace();
/* 111 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 116 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 120 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 124 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 128 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Action getAction() {
/* 132 */     return this.action;
/*     */   }
/*     */   
/*     */   public void setAction(Action action) {
/* 136 */     this.action = action;
/*     */   }
/*     */   
/*     */   public List<Action> getActions() {
/*     */     try {
/* 141 */       this.actions = this.actionFacadeLocal.findByInstitution(SessionMBean.getInstitution().getIdinstitution());
/* 142 */     } catch (Exception e) {}
/*     */     
/* 144 */     return this.actions;
/*     */   }
/*     */   
/*     */   public Programme getProgramme() {
/* 148 */     return this.programme;
/*     */   }
/*     */   
/*     */   public void setProgramme(Programme programme) {
/* 152 */     this.programme = programme;
/*     */   }
/*     */   
/*     */   public List<Programme> getProgrammes() {
/* 156 */     this.programmes = this.programmeFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 157 */     return this.programmes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ActionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */