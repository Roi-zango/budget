/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Compte;
/*     */ import entities.MenuB;
/*     */ import entities.PrivilegeB;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import org.primefaces.model.DualListModel;
/*     */ import sessions.CompteFacadeLocal;
/*     */ import sessions.MenuBFacadeLocal;
/*     */ import sessions.PrivilegeBFacadeLocal;
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
/*     */ @ViewScoped
/*     */ public class PrivilegeController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   protected CompteFacadeLocal compteFacadeLocal;
/*  36 */   protected Compte compte = new Compte();
/*  37 */   protected List<Compte> comptes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected PrivilegeBFacadeLocal privilegeFacadeLocal;
/*  41 */   protected List<PrivilegeB> privileges = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   protected MenuBFacadeLocal menuFacadeLocal;
/*  45 */   protected List<MenuB> menus = new ArrayList<>();
/*  46 */   protected DualListModel<MenuB> dualMenu = new DualListModel();
/*     */   
/*     */   protected String fileName;
/*     */   
/*     */   protected boolean detail = true;
/*     */   protected boolean supprimer = true;
/*     */   protected boolean imprimer = true;
/*     */   
/*     */   @PostConstruct
/*     */   private void initAcces() {
/*  56 */     this.compte = new Compte();
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*  60 */     if (Utilitaires.isAccess(Long.valueOf(5L))) {
/*  61 */       this.compte = new Compte();
/*  62 */       this.dualMenu.getSource().clear();
/*  63 */       this.dualMenu.getTarget().clear();
/*  64 */       RequestContext.getCurrentInstance().execute("PF('AccessCreateDialog').show()");
/*     */       return;
/*     */     } 
/*  67 */     JsfUtil.addErrorMessage("Vous n'avez pas le droit d'attribuer les privilèges aux utilisateurs");
/*     */   }
/*     */ 
/*     */   
/*     */   public void viewAccess(Compte compte) {
/*     */     try {
/*  73 */       this.compte = compte;
/*  74 */       this.privileges = this.privilegeFacadeLocal.findByUser(compte.getIdCompte().longValue());
/*  75 */     } catch (Exception e) {
/*  76 */       e.printStackTrace();
/*  77 */       JsfUtil.addErrorMessage("Echec");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handleUserChange() {
/*  82 */     this.dualMenu.getSource().clear();
/*  83 */     this.dualMenu.getTarget().clear();
/*     */     try {
/*  85 */       if (this.compte.getIdCompte() != null) {
/*     */         
/*  87 */         List<PrivilegeB> privilegeTemp = this.privilegeFacadeLocal.findByUser(this.compte.getIdCompte().longValue());
/*  88 */         if (privilegeTemp.isEmpty()) {
/*  89 */           this.dualMenu.setSource(this.menuFacadeLocal.findAll());
/*     */         } else {
/*     */           
/*  92 */           List<MenuB> menusTarget = new ArrayList<>();
/*     */           
/*  94 */           for (PrivilegeB p : privilegeTemp) {
/*  95 */             menusTarget.add(p.getMenu());
/*     */           }
/*     */           
/*  98 */           this.dualMenu.getTarget().addAll(menusTarget);
/*  99 */           this.dualMenu.getSource().addAll(this.menuFacadeLocal.findAll());
/* 100 */           this.dualMenu.getSource().removeAll(menusTarget);
/*     */         } 
/*     */       } 
/* 103 */     } catch (Exception e) {
/* 104 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save() {
/*     */     try {
/* 111 */       if (this.compte.getIdCompte() != null) {
/* 112 */         this.compte = this.compteFacadeLocal.find(this.compte.getIdCompte());
/*     */         
/* 114 */         for (MenuB m : this.dualMenu.getSource()) {
/* 115 */           PrivilegeB p = this.privilegeFacadeLocal.findByUser(this.compte.getIdCompte().longValue(), m.getIdmenuB().intValue());
/* 116 */           if (p != null) {
/* 117 */             this.privilegeFacadeLocal.remove(p);
/*     */           }
/*     */         } 
/*     */         
/* 121 */         Boolean flag = Boolean.valueOf(false);
/* 122 */         for (MenuB m : this.dualMenu.getTarget()) {
/* 123 */           if (m.getIdmenuB().intValue() == 1) {
/* 124 */             flag = Boolean.valueOf(true);
/* 125 */             PrivilegeB p = this.privilegeFacadeLocal.findByUser(this.compte.getIdCompte().longValue(), 1);
/* 126 */             if (p == null) {
/* 127 */               p = new PrivilegeB();
/* 128 */               p.setIdprivilegeB(this.privilegeFacadeLocal.nextVal());
/* 129 */               p.setMenu(m);
/* 130 */               p.setCompte(this.compte);
/* 131 */               this.privilegeFacadeLocal.create(p);
/*     */             } 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 138 */         if (!flag.booleanValue()) {
/* 139 */           for (MenuB m : this.dualMenu.getTarget()) {
/* 140 */             PrivilegeB p = this.privilegeFacadeLocal.findByUser(this.compte.getIdCompte().longValue(), m.getIdmenuB().intValue());
/* 141 */             if (p == null) {
/* 142 */               p = new PrivilegeB();
/* 143 */               p.setIdprivilegeB(this.privilegeFacadeLocal.nextVal());
/* 144 */               p.setMenu(m);
/* 145 */               p.setCompte(this.compte);
/* 146 */               this.privilegeFacadeLocal.create(p);
/*     */             } 
/*     */           } 
/*     */         }
/* 150 */         RequestContext.getCurrentInstance().execute("PF('AccessCreateDialog').hide()");
/* 151 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 153 */         JsfUtil.addErrorMessage("Aucun utilisateur selectionné");
/*     */       } 
/* 155 */     } catch (Exception e) {
/* 156 */       e.printStackTrace();
/* 157 */       JsfUtil.addErrorMessage("Echec");
/*     */     } 
/*     */   }
/*     */   
/*     */   public Compte getCompte() {
/* 162 */     return this.compte;
/*     */   }
/*     */   
/*     */   public void setCompte(Compte compte) {
/* 166 */     this.compte = compte;
/*     */   }
/*     */   
/*     */   public List<Compte> getComptes() {
/* 170 */     this.comptes = this.compteFacadeLocal.findByEtat("Actif");
/* 171 */     return this.comptes;
/*     */   }
/*     */   
/*     */   public void setComptes(List<Compte> comptes) {
/* 175 */     this.comptes = comptes;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 179 */     return this.detail;
/*     */   }
/*     */   
/*     */   public boolean isSupprimer() {
/* 183 */     return this.supprimer;
/*     */   }
/*     */   
/*     */   public boolean isImprimer() {
/* 187 */     this.imprimer = this.privilegeFacadeLocal.findAll().isEmpty();
/* 188 */     return this.imprimer;
/*     */   }
/*     */   
/*     */   public List<MenuB> getMenus() {
/* 192 */     return this.menus;
/*     */   }
/*     */   
/*     */   public void setMenus(List<MenuB> menus) {
/* 196 */     this.menus = menus;
/*     */   }
/*     */   
/*     */   public DualListModel<MenuB> getDualMenu() {
/* 200 */     return this.dualMenu;
/*     */   }
/*     */   
/*     */   public void setDualMenu(DualListModel<MenuB> dualMenu) {
/* 204 */     this.dualMenu = dualMenu;
/*     */   }
/*     */   
/*     */   public List<PrivilegeB> getPrivileges() {
/* 208 */     return this.privileges;
/*     */   }
/*     */   
/*     */   public void setPrivileges(List<PrivilegeB> privileges) {
/* 212 */     this.privileges = privileges;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\PrivilegeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */