/*     */ package controllers.util;
/*     */ 
/*     */ import entities.Annee;
/*     */ import entities.Budget;
/*     */ import entities.Compte;
/*     */ import entities.Institution;
/*     */ import entities.Parametrage;
/*     */ import java.util.List;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SessionMBean
/*     */ {
/*     */   public static HttpSession getSession() {
/*  21 */     return (HttpSession)FacesContext.getCurrentInstance()
/*  22 */       .getExternalContext().getSession(false);
/*     */   }
/*     */   
/*     */   public static HttpServletRequest getRequest() {
/*  26 */     return (HttpServletRequest)FacesContext.getCurrentInstance()
/*  27 */       .getExternalContext().getRequest();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getUserName() {
/*  32 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
/*  33 */     return session.getAttribute("login").toString();
/*     */   }
/*     */   
/*     */   public static String getUserId() {
/*  37 */     HttpSession session = getSession();
/*  38 */     if (session != null) {
/*  39 */       return (String)session.getAttribute("utilisateurid");
/*     */     }
/*  41 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Compte getUser() {
/*  46 */     HttpSession session = getSession();
/*  47 */     if (session != null) {
/*  48 */       return (Compte)session.getAttribute("user");
/*     */     }
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Budget getBudget() {
/*  55 */     HttpSession session = getSession();
/*  56 */     if (session != null) {
/*  57 */       return (Budget)session.getAttribute("budget");
/*     */     }
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Annee getAnnee() {
/*  64 */     HttpSession session = getSession();
/*  65 */     if (session != null) {
/*  66 */       return (Annee)session.getAttribute("annee");
/*     */     }
/*  68 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Institution getInstitution() {
/*  73 */     HttpSession session = getSession();
/*  74 */     if (session != null) {
/*  75 */       return (Institution)session.getAttribute("institution");
/*     */     }
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Institution getInstitutionSession() {
/*  82 */     HttpSession session = getSession();
/*  83 */     if (session != null) {
/*  84 */       return (Institution)session.getAttribute("i_session");
/*     */     }
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Parametrage getParametrage() {
/*  91 */     HttpSession session = getSession();
/*  92 */     if (session != null) {
/*  93 */       return (Parametrage)session.getAttribute("parametrage");
/*     */     }
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<Long> getUserAccessId() {
/* 100 */     HttpSession session = getSession();
/* 101 */     if (session != null) {
/* 102 */       return (List<Long>)session.getAttribute("user_access_id");
/*     */     }
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<String> getAll_Link() {
/* 109 */     HttpSession session = getSession();
/* 110 */     if (session != null) {
/* 111 */       return (List<String>)session.getAttribute("system_all_menu");
/*     */     }
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Compte getCompte() {
/* 118 */     HttpSession session = getSession();
/* 119 */     if (session != null) {
/* 120 */       return (Compte)session.getAttribute("user");
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getLogo() {
/* 127 */     HttpSession session = getSession();
/* 128 */     if (session != null) {
/* 129 */       return (String)session.getAttribute("logo");
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controller\\util\SessionMBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */