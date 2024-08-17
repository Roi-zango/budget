/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Societe;
/*     */ import java.io.Serializable;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.SocieteFacadeLocal;
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
/*     */ public class SocieteController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private SocieteFacadeLocal societeFacadeLocal;
/*  34 */   private Societe societe = new Societe();
/*  35 */   private List<Societe> societes = new ArrayList<>();
/*     */   
/*  37 */   private String mode = "";
/*     */   
/*     */   private boolean detail = true;
/*     */   
/*     */   Connection connexion;
/*     */ 
/*     */   
/*     */   public SocieteController() {
/*  45 */     this.connexion = null;
/*     */   }
/*     */   public void prepareCreate() {
/*  48 */     if (!Utilitaires.isAccess(Long.valueOf(30L))) {
/*  49 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de créer les prestataires");
/*     */       return;
/*     */     } 
/*  52 */     this.societe = new Societe();
/*  53 */     this.societe.setRib1("-");
/*  54 */     this.societe.setRib2("-");
/*  55 */     this.societe.setAd1("-");
/*  56 */     this.societe.setAd2("-");
/*  57 */     this.societe.setAd3("-");
/*  58 */     this.societe.setAuxiconsolide("-");
/*  59 */     this.societe.setAuxi("-");
/*  60 */     this.societe.setTel("-");
/*  61 */     this.societe.setEmail("-");
/*  62 */     this.societe.setPays("-");
/*  63 */     this.societe.setFax("-");
/*  64 */     this.societe.setRc("-");
/*  65 */     this.societe.setCoge("-");
/*  66 */     this.societe.setStatut(true);
/*  67 */     this.societe.setStat("-");
/*  68 */     this.societe.setBqnom("-");
/*  69 */     this.societe.setBqpays("-");
/*  70 */     this.societe.setBqswift("-");
/*  71 */     this.societe.setBqville("-");
/*  72 */     this.societe.setNif("-");
/*  73 */     this.societe.setContact("-");
/*  74 */     this.mode = "Create";
/*  75 */     RequestContext.getCurrentInstance().execute("PF('SocieteCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  79 */     if (!Utilitaires.isAccess(Long.valueOf(30L))) {
/*  80 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier les prestataires");
/*     */       return;
/*     */     } 
/*  83 */     if (this.societe != null) {
/*  84 */       this.mode = "Edit";
/*  85 */       RequestContext.getCurrentInstance().execute("PF('SocieteCreateDialog').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  91 */       if ("Create".equals(this.mode)) {
/*     */         
/*  93 */         if (this.societeFacadeLocal.findByNuid(this.societe.getNumerocontribuable()) == null) {
/*  94 */           this.societe.setIdsociete(Integer.valueOf(this.societeFacadeLocal.nextId()));
/*  95 */           this.societeFacadeLocal.create(this.societe);
/*     */           
/*  97 */           this.detail = true;
/*     */           
/*  99 */           this.connexion = Utilitaires.connexionDB(SessionMBean.getParametrage().getDriverClassNameTompro(), SessionMBean.getParametrage().getChaineConnexionTompro(), SessionMBean.getParametrage().getUserTompro(), SessionMBean.getParametrage().getPasswordTompro());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 115 */           String requette = "INSERT INTO RTIERS(COGEAUXI,COGE,NOM,CONTACT,AD1,PAYS,TEL,FAX,EMAIL,RIB1,RIB2,RC,NIF)VALUES('" + this.societe.getNumerocontribuable() + "','" + this.societe.getCoge() + "','" + this.societe.getNom() + "','" + this.societe.getContact() + "','" + this.societe.getAd1() + "','" + this.societe.getPays() + "','" + this.societe.getTel() + "','" + this.societe.getFax() + "','" + this.societe.getEmail() + "','" + this.societe.getRib1() + "','" + this.societe.getRib2() + "','" + this.societe.getRc() + "','" + this.societe.getNif() + "')";
/*     */           
/* 117 */           System.out.println(requette);
/*     */           
/* 119 */           Statement statement = this.connexion.createStatement();
/* 120 */           statement.executeUpdate(requette);
/* 121 */           this.connexion.close();
/* 122 */           this.societe = new Societe();
/* 123 */           RequestContext.getCurrentInstance().execute("PF('SocieteCreateDialog').hide()");
/* 124 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 126 */           JsfUtil.addWarningMessage("Une entreprise possedant ce numero contribuable existe");
/*     */         }
/*     */       
/* 129 */       } else if ("Edit".equals(this.mode)) {
/* 130 */         if (this.societe != null) {
/* 131 */           this.societeFacadeLocal.edit(this.societe);
/* 132 */           this.societe = new Societe();
/* 133 */           this.detail = true;
/* 134 */           RequestContext.getCurrentInstance().execute("PF('SocieteCreateDialog').hide()");
/* 135 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 137 */           JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */         } 
/*     */       } 
/* 140 */     } catch (Exception e) {
/* 141 */       e.printStackTrace();
/* 142 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 148 */       if (!Utilitaires.isAccess(Long.valueOf(30L))) {
/* 149 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit de supprimer les prestataires");
/*     */         return;
/*     */       } 
/* 152 */       this.detail = true;
/* 153 */       if (this.societe != null) {
/* 154 */         this.societeFacadeLocal.remove(this.societe);
/* 155 */         this.detail = true;
/* 156 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 158 */         JsfUtil.addErrorMessage("Aucune ligne selectionnée");
/*     */       } 
/* 160 */     } catch (Exception e) {
/* 161 */       e.printStackTrace();
/* 162 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   private String findString(String chaine) {
/* 167 */     String resulut = "";
/*     */     try {
/* 169 */       resulut = chaine;
/* 170 */     } catch (Exception e) {
/* 171 */       resulut = "-";
/*     */     } 
/* 173 */     return resulut;
/*     */   }
/*     */ 
/*     */   
/*     */   public void importTiers() {
/*     */     try {
/* 179 */       if (!Utilitaires.isAccess(Long.valueOf(30L))) {
/* 180 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'importer les prestataires");
/*     */         
/*     */         return;
/*     */       } 
/* 184 */       this.connexion = Utilitaires.connexionDB(SessionMBean.getParametrage().getDriverClassNameTompro(), SessionMBean.getParametrage().getChaineConnexionTompro(), SessionMBean.getParametrage().getUserTompro(), SessionMBean.getParametrage().getPasswordTompro());
/* 185 */       Statement statement = this.connexion.createStatement();
/* 186 */       ResultSet resultatTiers = statement.executeQuery("SELECT * FROM RTIERS");
/*     */       
/* 188 */       while (resultatTiers.next()) {
/* 189 */         Societe s = this.societeFacadeLocal.findByNuid(resultatTiers.getString("COGEAUXI"));
/* 190 */         if (s == null) {
/*     */           
/* 192 */           s = new Societe();
/* 193 */           s.setIdsociete(Integer.valueOf(this.societeFacadeLocal.nextId()));
/* 194 */           s.setNumerocontribuable(findString(resultatTiers.getString("COGEAUXI")));
/* 195 */           s.setCoge(findString(resultatTiers.getString("COGE")));
/* 196 */           s.setNom(findString(resultatTiers.getString("NOM")));
/* 197 */           s.setContact(findString(resultatTiers.getString("CONTACT")));
/* 198 */           s.setAd1(findString(resultatTiers.getString("AD1")));
/* 199 */           s.setAd2(findString(resultatTiers.getString("AD2")));
/* 200 */           s.setAd3(findString(resultatTiers.getString("AD3")));
/* 201 */           s.setPays(findString(resultatTiers.getString("PAYS")));
/* 202 */           s.setTel(findString(resultatTiers.getString("TEL")));
/* 203 */           s.setFax(findString(resultatTiers.getString("FAX")));
/* 204 */           s.setEmail(findString(resultatTiers.getString("EMAIL")));
/* 205 */           s.setRib1(findString(resultatTiers.getString("RIB1")));
/* 206 */           s.setRib2(findString(resultatTiers.getString("RIB2")));
/* 207 */           s.setStatut(resultatTiers.getBoolean("STATUT"));
/* 208 */           s.setRc(findString(resultatTiers.getString("RC")));
/* 209 */           s.setNif(findString(resultatTiers.getString("NIF")));
/* 210 */           s.setStat(findString(resultatTiers.getString("STAT")));
/* 211 */           this.societeFacadeLocal.create(s);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 237 */       this.connexion.close();
/* 238 */       JsfUtil.addSuccessMessage("Importation réussie");
/* 239 */     } catch (Exception e) {
/* 240 */       e.printStackTrace();
/* 241 */       JsfUtil.addFatalErrorMessage("Echec de l'opération");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 246 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 250 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 254 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 258 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 262 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 266 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public List<Societe> getSocietes() {
/* 270 */     this.societes = this.societeFacadeLocal.findAllRange();
/* 271 */     return this.societes;
/*     */   }
/*     */   
/*     */   public void setSocietes(List<Societe> societes) {
/* 275 */     this.societes = societes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\SocieteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */