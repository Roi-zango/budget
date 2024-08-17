/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Adresse;
/*     */ import entities.Pays;
/*     */ import entities.Rue;
/*     */ import entities.StatutMatrimonial;
/*     */ import entities.Structure;
/*     */ import entities.Utilisateur;
/*     */ import java.io.Serializable;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.AdresseFacadeLocal;
/*     */ import sessions.RueFacadeLocal;
/*     */ import sessions.StatutMatrimonialFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.UtilisateurFacadeLocal;
/*     */ import utilitaire.Printer;
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
/*     */ public class UtilisateurController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private UtilisateurFacadeLocal utilisateurFacadeLocal;
/*  44 */   private Utilisateur utilisateur = new Utilisateur();
/*  45 */   private List<Utilisateur> utilisateurs = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private AdresseFacadeLocal adresseFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private RueFacadeLocal rueFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private StatutMatrimonialFacadeLocal statutMatrimonialFacadeLocal;
/*  58 */   private StatutMatrimonial statutMatrimonial = new StatutMatrimonial();
/*  59 */   private List<StatutMatrimonial> statutMatrimonials = new ArrayList<>();
/*     */   
/*  61 */   private String mode = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  70 */     this.utilisateur = new Utilisateur();
/*  71 */     this.statutMatrimonial = new StatutMatrimonial();
/*  72 */     this.utilisateur.setCni("-");
/*  73 */     this.utilisateur.setDateNaissance(new Date());
/*  74 */     this.mode = "Create";
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  78 */     if (this.utilisateur != null) {
/*  79 */       this.statutMatrimonial = this.utilisateur.getIdStatutMatrimonial();
/*  80 */       this.mode = "Edit";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  86 */       if ("Create".equals(this.mode)) {
/*     */         
/*  88 */         this.utilisateur.setIdUtilisateur(Long.valueOf(this.utilisateurFacadeLocal.nextId()));
/*  89 */         this.utilisateur.setIdStatutMatrimonial(this.statutMatrimonial);
/*     */         
/*  91 */         Adresse adresse = new Adresse();
/*     */ 
/*     */         
/*  94 */         Rue r = this.rueFacadeLocal.find(Long.valueOf(1L));
/*     */         
/*  96 */         adresse.setIdAdresse(Long.valueOf(this.adresseFacadeLocal.nextId()));
/*  97 */         r.getIdQuartier().getIdVille();
/*  98 */         adresse.setIdRue(r);
/*  99 */         adresse.setIdQuartier(r.getIdQuartier());
/* 100 */         adresse.setIdVille(r.getIdQuartier().getIdVille());
/* 101 */         this.adresseFacadeLocal.create(adresse);
/*     */         
/* 103 */         this.utilisateur.setIdPays(new Pays(Long.valueOf(1L)));
/* 104 */         this.utilisateur.setIdAdresse(adresse);
/* 105 */         this.utilisateur.setDateEnregistre(new Date());
/* 106 */         this.utilisateur.setDerniereModif(new Date());
/* 107 */         this.utilisateur.setEtat("Actif");
/* 108 */         this.utilisateur.setPhoto("-");
/* 109 */         this.utilisateur.setPhotoRelatif("-");
/* 110 */         this.utilisateurFacadeLocal.create(this.utilisateur);
/*     */         
/* 112 */         Connection con = DriverManager.getConnection(Printer.url, Printer.user, Printer.password);
/* 113 */         Statement statement = con.createStatement();
/*     */         
/* 115 */         List<Structure> list = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 116 */         for (Structure s : list) {
/*     */ 
/*     */           
/* 119 */           String requette = "INSERT INTO utilisateurstructure(id_utilisateur,idstructure) VALUES(" + this.utilisateur.getIdUtilisateur() + "," + s.getIdstructure() + ")";
/* 120 */           statement.executeUpdate(requette);
/*     */         } 
/*     */         
/* 123 */         this.utilisateur = new Utilisateur();
/* 124 */         con.close();
/*     */         
/* 126 */         this.detail = true;
/* 127 */         RequestContext.getCurrentInstance().execute("PF('UtilisateurCreateDialog').hide()");
/* 128 */         JsfUtil.addSuccessMessage("Opération réussie");
/* 129 */       } else if ("Edit".equals(this.mode)) {
/* 130 */         if (this.utilisateur != null) {
/* 131 */           if (this.statutMatrimonial.getIdStatutMatrimonial() != null) {
/* 132 */             this.utilisateur.setIdStatutMatrimonial(this.statutMatrimonialFacadeLocal.find(this.statutMatrimonial.getIdStatutMatrimonial()));
/*     */           }
/* 134 */           this.utilisateurFacadeLocal.edit(this.utilisateur);
/* 135 */           this.utilisateur = new Utilisateur();
/* 136 */           this.detail = true;
/* 137 */           RequestContext.getCurrentInstance().execute("PF('UtilisateurCreateDialog').hide()");
/* 138 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 140 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 143 */     } catch (Exception e) {
/* 144 */       e.printStackTrace();
/* 145 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 151 */       if (this.utilisateur != null) {
/* 152 */         this.utilisateurFacadeLocal.remove(this.utilisateur);
/* 153 */         this.utilisateur = new Utilisateur();
/* 154 */         this.detail = true;
/*     */       } else {
/* 156 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 158 */     } catch (Exception e) {
/* 159 */       e.printStackTrace();
/* 160 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 165 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 169 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 173 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 177 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Utilisateur getUtilisateur() {
/* 181 */     return this.utilisateur;
/*     */   }
/*     */   
/*     */   public void setUtilisateur(Utilisateur utilisateur) {
/* 185 */     this.utilisateur = utilisateur;
/*     */   }
/*     */   
/*     */   public List<Utilisateur> getUtilisateurs() {
/* 189 */     this.utilisateurs = this.utilisateurFacadeLocal.findAll();
/* 190 */     return this.utilisateurs;
/*     */   }
/*     */   
/*     */   public void setUtilisateurs(List<Utilisateur> utilisateurs) {
/* 194 */     this.utilisateurs = utilisateurs;
/*     */   }
/*     */   
/*     */   public StatutMatrimonial getStatutMatrimonial() {
/* 198 */     return this.statutMatrimonial;
/*     */   }
/*     */   
/*     */   public void setStatutMatrimonial(StatutMatrimonial statutMatrimonial) {
/* 202 */     this.statutMatrimonial = statutMatrimonial;
/*     */   }
/*     */   
/*     */   public List<StatutMatrimonial> getStatutMatrimonials() {
/* 206 */     this.statutMatrimonials = this.statutMatrimonialFacadeLocal.findAll();
/* 207 */     return this.statutMatrimonials;
/*     */   }
/*     */   
/*     */   public void setStatutMatrimonials(List<StatutMatrimonial> statutMatrimonials) {
/* 211 */     this.statutMatrimonials = statutMatrimonials;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\UtilisateurController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */