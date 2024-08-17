/*     */ package controllers;
/*     */ 
/*     */ import com.google.common.io.Files;
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Annee;
/*     */ import entities.Budget;
/*     */ import entities.Compte;
/*     */ import entities.Institution;
/*     */ import entities.MenuB;
/*     */ import entities.Parametrage;
/*     */ import entities.PrivilegeB;
/*     */ import entities.Utilisateur;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.inject.Inject;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import sessions.AnneeFacadeLocal;
/*     */ import sessions.BudgetFacadeLocal;
/*     */ import sessions.CompteFacadeLocal;
/*     */ import sessions.InstitutionFacadeLocal;
/*     */ import sessions.MenuBFacadeLocal;
/*     */ import sessions.ParametrageFacadeLocal;
/*     */ import sessions.PrivilegeBFacadeLocal;
/*     */ import sessions.UtilisateurFacadeLocal;
/*     */ import utilitaire.ShaHash;
/*     */ import utilitaire.Utilitaires;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class LoginController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private MenuBFacadeLocal menuBFacadeLocal;
/*     */   @EJB
/*     */   private AnneeFacadeLocal anneeFacadeLocal;
/*  54 */   private Annee annee = new Annee();
/*  55 */   private List<Annee> annees = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private UtilisateurFacadeLocal utilisateurFacade;
/*  59 */   private Utilisateur utilisateur = new Utilisateur();
/*     */   
/*     */   @EJB
/*     */   private PrivilegeBFacadeLocal privilegeFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private InstitutionFacadeLocal institutionFacadeLocal;
/*  66 */   private Institution institution = new Institution();
/*  67 */   private List<Institution> institutions = new ArrayList<>();
/*     */   
/*     */   @Inject
/*     */   private CompteFacadeLocal compteFacadeLocal;
/*  71 */   private Compte compte = new Compte();
/*     */   
/*  73 */   private String filename = "logo.jpeg";
/*  74 */   private String filenameInstitution = "logo1.png";
/*     */   
/*     */   private boolean showSessionPanel = true;
/*     */   
/*  78 */   String sc = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
/*     */   
/*     */   @EJB
/*     */   private BudgetFacadeLocal budgetFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private ParametrageFacadeLocal parametrageFacadeLocal;
/*     */   
/*  86 */   private String language = "fr";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void login() throws NoSuchAlgorithmException {
/*  94 */     Compte cpte = new Compte();
/*     */     
/*  96 */     cpte.setLogin(this.compte.getLogin());
/*  97 */     cpte.setMdp((new ShaHash()).hash(this.compte.getMdp()));
/*  98 */     Compte usr = this.compteFacadeLocal.connexion(cpte);
/*     */     
/* 100 */     if (usr != null) {
/*     */       
/*     */       try {
/* 103 */         this.utilisateur = usr.getIdUtilisateur();
/* 104 */         HttpSession session = SessionMBean.getSession();
/*     */         
/* 106 */         session.setAttribute("login", this.utilisateur.getNom());
/* 107 */         session.setAttribute("user", usr);
/*     */         
/* 109 */         List<Annee> annees = this.anneeFacadeLocal.findByEtat(true);
/* 110 */         if (!annees.isEmpty()) {
/* 111 */           this.annee = annees.get(0);
/*     */         }
/*     */         
/* 114 */         List<Institution> list = getInstitutions();
/* 115 */         if (!list.isEmpty()) {
/* 116 */           this.institution = list.get(0);
/*     */         }
/*     */         
/* 119 */         List<MenuB> menu_mapped = this.menuBFacadeLocal.findAll();
/* 120 */         List<String> menu_all_mapped = new ArrayList<>();
/*     */         
/* 122 */         for (MenuB m : menu_mapped) {
/* 123 */           String[] menus = m.getRessource().split(";");
/* 124 */           for (String temp : menus) {
/* 125 */             if (!menu_all_mapped.contains(temp)) {
/* 126 */               menu_all_mapped.add(temp);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 131 */         List<PrivilegeB> privilegesTemp = this.privilegeFacadeLocal.findByUser(usr.getIdCompte().longValue());
/* 132 */         List<Long> accesses = new ArrayList<>();
/* 133 */         List<String> access = new ArrayList<>();
/*     */         
/* 135 */         for (PrivilegeB p : privilegesTemp) {
/* 136 */           accesses.add(Long.valueOf(p.getMenu().getIdmenuB().longValue()));
/* 137 */           String[] menus = p.getMenu().getRessource().split(";");
/* 138 */           for (String temp : menus) {
/* 139 */             if (!access.contains(temp)) {
/* 140 */               access.add(temp);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 145 */         session.setAttribute("user_access_id", accesses);
/* 146 */         session.setAttribute("user_all_menu", access);
/* 147 */         session.setAttribute("system_all_menu", menu_all_mapped);
/*     */         
/* 149 */         FacesContext.getCurrentInstance().getExternalContext().redirect(this.sc + "/faces/index.xhtml");
/*     */       }
/* 151 */       catch (IOException ex) {
/* 152 */         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 153 */         JsfUtil.addErrorMessage("Echec de l'opération");
/* 154 */         this.compte = new Compte();
/*     */       } 
/*     */     } else {
/* 157 */       System.err.println("echec d'authentification");
/* 158 */       this.compte = new Compte();
/* 159 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login et mot de passe incorrets", "Please enter correct username and Password"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void initSession() {
/*     */     try {
/* 166 */       HttpSession session = SessionMBean.getSession();
/*     */       
/* 168 */       this.institution = this.institutionFacadeLocal.find(this.institution.getIdinstitution());
/*     */       try {
/* 170 */         this.filename = this.institution.getPhoto();
/* 171 */         this.filenameInstitution = this.institution.getPhotoInstitutionMere();
/* 172 */       } catch (Exception e) {}
/*     */       
/* 174 */       session.setAttribute("institution", this.institution);
/*     */       
/* 176 */       this.annee = this.anneeFacadeLocal.find(this.annee.getIdannee());
/* 177 */       session.setAttribute("annee", this.annee);
/*     */       
/* 179 */       Budget b = null;
/* 180 */       if (this.annee != null) {
/* 181 */         b = this.budgetFacadeLocal.findByAnnee("" + this.annee.getIdannee());
/*     */       }
/* 183 */       session.setAttribute("budget", b);
/*     */       
/* 185 */       Parametrage parametrage = null;
/* 186 */       List<Parametrage> parametrages = this.parametrageFacadeLocal.findAll();
/* 187 */       if (!parametrages.isEmpty()) {
/* 188 */         parametrage = parametrages.get(0);
/*     */       }
/* 190 */       session.setAttribute("parametrage", parametrage);
/*     */       
/* 192 */       this.showSessionPanel = false;
/*     */       
/* 194 */       File file1 = new File(parametrage.getRepertoirePhoto() + "" + this.institution.getPhoto());
/* 195 */       if (!file1.exists()) {
/* 196 */         session.setAttribute("logo", this.institution.getPhoto());
/* 197 */         File file = new File(Utilitaires.path + "/photos/" + this.institution.getPhoto());
/* 198 */         if (!file.exists()) {
/* 199 */           Files.copy(file1, file);
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 204 */         session.setAttribute("logo", "logo.PNG");
/*     */       } 
/*     */       
/* 207 */       File file2 = new File(Utilitaires.path + "/photos/" + this.institution.getPhotoInstitutionMere());
/* 208 */       if (!file2.exists()) {
/* 209 */         File file3 = new File(parametrage.getRepertoirePhoto() + "" + this.institution.getPhotoInstitutionMere());
/* 210 */         if (file3.exists()) {
/* 211 */           Files.copy(file3, file2);
/*     */         }
/*     */       } 
/* 214 */     } catch (Exception e) {
/* 215 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void logout() {
/* 220 */     HttpSession session = SessionMBean.getSession();
/* 221 */     Compte usr = SessionMBean.getUser();
/* 222 */     session.invalidate();
/* 223 */     String sc = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
/*     */     
/*     */     try {
/* 226 */       FacesContext.getCurrentInstance().getExternalContext().redirect(sc + "/faces/login.xhtml");
/* 227 */     } catch (IOException ex) {
/* 228 */       Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void watcher() {
/*     */     try {
/* 234 */       if (SessionMBean.getUser() == null) {
/* 235 */         String sc = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
/* 236 */         FacesContext.getCurrentInstance().getExternalContext().redirect(sc + "/faces/login.xhtml");
/*     */       } 
/* 238 */     } catch (Exception e) {
/* 239 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String switchFr() {
/* 244 */     this.language = "fr";
/* 245 */     return null;
/*     */   }
/*     */   
/*     */   public String switchEn() {
/* 249 */     this.language = "en";
/* 250 */     return null;
/*     */   }
/*     */   
/*     */   public Utilisateur getUtilisateur() {
/* 254 */     return this.utilisateur;
/*     */   }
/*     */   
/*     */   public void setUtilisateur(Utilisateur utilisateur) {
/* 258 */     this.utilisateur = utilisateur;
/*     */   }
/*     */   
/*     */   public Compte getCompte() {
/* 262 */     return this.compte;
/*     */   }
/*     */   
/*     */   public void setCompte(Compte compte) {
/* 266 */     this.compte = compte;
/*     */   }
/*     */   
/*     */   public String getLanguage() {
/* 270 */     return this.language;
/*     */   }
/*     */   
/*     */   public void setLanguage(String language) {
/* 274 */     this.language = language;
/*     */   }
/*     */   
/*     */   public Annee getAnnee() {
/* 278 */     return this.annee;
/*     */   }
/*     */   
/*     */   public void setAnnee(Annee annee) {
/* 282 */     this.annee = annee;
/*     */   }
/*     */   
/*     */   public List<Annee> getAnnees() {
/* 286 */     this.annees = this.anneeFacadeLocal.findAll("Actif");
/* 287 */     return this.annees;
/*     */   }
/*     */   
/*     */   public Institution getInstitution() {
/* 291 */     return this.institution;
/*     */   }
/*     */   
/*     */   public void setInstitution(Institution institution) {
/* 295 */     this.institution = institution;
/*     */   }
/*     */   
/*     */   public List<Institution> getInstitutions() {
/* 299 */     this.institutions = this.institutionFacadeLocal.findAllEtatIsActif();
/* 300 */     return this.institutions;
/*     */   }
/*     */   
/*     */   public boolean isShowSessionPanel() {
/* 304 */     return this.showSessionPanel;
/*     */   }
/*     */   
/*     */   public void setShowSessionPanel(boolean showSessionPanel) {
/* 308 */     this.showSessionPanel = showSessionPanel;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 312 */     return this.filename;
/*     */   }
/*     */   
/*     */   public String getFilenameInstitution() {
/* 316 */     return this.filenameInstitution;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\LoginController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */