/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Compte;
/*     */ import entities.Utilisateur;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.CompteFacadeLocal;
/*     */ import sessions.UtilisateurFacadeLocal;
/*     */ import utilitaire.ShaHash;
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
/*     */ public class CompteController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private UtilisateurFacadeLocal utilisateurFacadeLocal;
/*  33 */   private Utilisateur utilisateur = new Utilisateur();
/*  34 */   private List<Utilisateur> utilisateurs = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private CompteFacadeLocal compteFacadeLocal;
/*  38 */   private Compte compte = new Compte();
/*  39 */   private List<Compte> comptes = new ArrayList<>();
/*  40 */   private String repeatPassword = "";
/*     */   
/*  42 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  51 */     this.utilisateur = new Utilisateur();
/*  52 */     this.compte = new Compte();
/*  53 */     this.repeatPassword = "";
/*  54 */     this.mode = "Create";
/*  55 */     filterUserWithoutAccount();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareEdit() {
/*  60 */     if (this.compte != null) {
/*  61 */       this.mode = "Edit";
/*  62 */       this.utilisateur = this.compte.getIdUtilisateur();
/*  63 */       this.utilisateurs.clear();
/*  64 */       this.utilisateurs.add(this.compte.getIdUtilisateur());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void filterUserWithoutAccount() {
/*     */     try {
/*  70 */       List<Utilisateur> utAll = this.utilisateurFacadeLocal.findByEtat("Actif");
/*  71 */       this.utilisateurs.clear();
/*  72 */       for (Utilisateur ut : utAll) {
/*  73 */         if (this.compteFacadeLocal.findByIdutilisateur(ut.getIdUtilisateur().longValue()) == null) {
/*  74 */           this.utilisateurs.add(ut);
/*     */         }
/*     */       } 
/*  77 */     } catch (Exception e) {
/*  78 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  84 */       if ("Create".equals(this.mode)) {
/*     */         
/*  86 */         if (this.compte.getMdp().equals(this.repeatPassword)) {
/*  87 */           this.compte.setIdCompte(Long.valueOf(this.compteFacadeLocal.nextId()));
/*  88 */           this.compte.setIdUtilisateur(this.utilisateur);
/*  89 */           this.compte.setMdp((new ShaHash()).hash(this.compte.getMdp()));
/*  90 */           this.compte.setEtat("Actif");
/*  91 */           this.compte.setDateEnregistre(new Date());
/*  92 */           this.compte.setDernieremodif(new Date());
/*  93 */           this.compte.setLangue("fr");
/*  94 */           this.compte.setConnexion("false");
/*  95 */           this.compteFacadeLocal.create(this.compte);
/*     */           
/*  97 */           this.compte = new Compte();
/*  98 */           this.utilisateur = new Utilisateur();
/*  99 */           this.detail = true;
/* 100 */           RequestContext.getCurrentInstance().execute("PF('CompteUtilisateurCreateDialog').hide()");
/* 101 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */           
/*     */           return;
/*     */         } 
/* 105 */         JsfUtil.addWarningMessage("Les deux mot de passe ne sont pas identifiques");
/*     */       }
/* 107 */       else if ("Edit".equals(this.mode)) {
/* 108 */         if (this.compte != null) {
/*     */           
/* 110 */           this.compteFacadeLocal.edit(this.compte);
/* 111 */           this.utilisateur = new Utilisateur();
/* 112 */           this.compte = new Compte();
/* 113 */           this.detail = true;
/* 114 */           RequestContext.getCurrentInstance().execute("PF('CompteUtilisateurCreateDialog').hide()");
/* 115 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 117 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 120 */     } catch (Exception e) {
/* 121 */       e.printStackTrace();
/* 122 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 128 */       if (this.compte != null) {
/* 129 */         this.compteFacadeLocal.remove(this.compte);
/* 130 */         this.utilisateur = new Utilisateur();
/* 131 */         this.compte = new Compte();
/* 132 */         this.detail = true;
/*     */       } else {
/* 134 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 136 */     } catch (Exception e) {
/* 137 */       e.printStackTrace();
/* 138 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 143 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 147 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 151 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 155 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Utilisateur getUtilisateur() {
/* 159 */     return this.utilisateur;
/*     */   }
/*     */   
/*     */   public void setUtilisateur(Utilisateur utilisateur) {
/* 163 */     this.utilisateur = utilisateur;
/*     */   }
/*     */   
/*     */   public List<Utilisateur> getUtilisateurs() {
/* 167 */     return this.utilisateurs;
/*     */   }
/*     */   
/*     */   public void setUtilisateurs(List<Utilisateur> utilisateurs) {
/* 171 */     this.utilisateurs = utilisateurs;
/*     */   }
/*     */   
/*     */   public Compte getCompte() {
/* 175 */     return this.compte;
/*     */   }
/*     */   
/*     */   public void setCompte(Compte compte) {
/* 179 */     this.compte = compte;
/*     */   }
/*     */   
/*     */   public List<Compte> getComptes() {
/* 183 */     this.comptes = this.compteFacadeLocal.findAll();
/* 184 */     return this.comptes;
/*     */   }
/*     */   
/*     */   public void setComptes(List<Compte> comptes) {
/* 188 */     this.comptes = comptes;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 192 */     return this.mode;
/*     */   }
/*     */   
/*     */   public String getRepeatPassword() {
/* 196 */     return this.repeatPassword;
/*     */   }
/*     */   
/*     */   public void setRepeatPassword(String repeatPassword) {
/* 200 */     this.repeatPassword = repeatPassword;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\CompteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */