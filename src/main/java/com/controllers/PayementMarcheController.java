/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Moyens;
/*     */ import entities.OrdrePayement;
/*     */ import entities.Payement;
/*     */ import entities.Tache;
/*     */ import java.io.Serializable;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.transaction.Transactional;
/*     */ import javax.transaction.UserTransaction;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.OrdrePayementFacadeLocal;
/*     */ import sessions.PayementFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import utilitaire.Printer;
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
/*     */ 
/*     */ @ManagedBean
/*     */ @ViewScoped
/*     */ public class PayementMarcheController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private PayementFacadeLocal payementFacadeLocal;
/*  53 */   private Payement payement = new Payement();
/*  54 */   private List<Payement> payements = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   protected TacheFacadeLocal tacheFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   protected MoyensFacadeLocal moyensFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   protected OrdrePayementFacadeLocal ordrePayementFacadeLocal;
/*     */   
/*  68 */   private String mode = "";
/*     */ 
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
/*     */   
/*     */   @Transactional
/*     */   public void importFromGendata() {
/*     */     try {
/*  84 */       if (!Utilitaires.isAccess(Long.valueOf(40L))) {
/*  85 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'importer les données de paiement");
/*     */         
/*     */         return;
/*     */       } 
/*  89 */       Connection connection = Utilitaires.connexionDB(SessionMBean.getParametrage().getDriverClassNameGendata(), SessionMBean.getParametrage().getChaineConnexionGendata(), SessionMBean.getParametrage().getUserGendata(), SessionMBean.getParametrage().getPasswordGendata());
/*     */       
/*  91 */       if (connection == null) {
/*  92 */         JsfUtil.addErrorMessage("Echec de connexion à gendata");
/*     */         
/*     */         return;
/*     */       } 
/*  96 */       List<OrdrePayement> listOp = this.ordrePayementFacadeLocal.findAllEtatPaid(SessionMBean.getInstitution().getIdinstitution().longValue(), SessionMBean.getBudget().getIdbudget().intValue(), true, false);
/*  97 */       for (OrdrePayement op : listOp) {
/*  98 */         String requette = "SELECT * FROM gd_virements WHERE num_engagement = '" + op.getBoncommande().getCode() + "' OR num_engagement = '" + op.getBoncommande().getReference() + "'";
/*  99 */         Statement statement = connection.createStatement();
/* 100 */         ResultSet resultat = statement.executeQuery(requette);
/*     */         
/* 102 */         if (resultat != null)
/*     */         {
/* 104 */           while (resultat.next()) {
/* 105 */             if (resultat.getDouble("montant") == op.getMontant().doubleValue()) {
/*     */               
/* 107 */               double montant = resultat.getLong("montant");
/* 108 */               Payement payement = new Payement();
/* 109 */               payement.setIdpayement(Long.valueOf(this.payementFacadeLocal.nextId()));
/* 110 */               payement.setOdrePayement(op);
/* 111 */               payement.setBoncommande(op.getBoncommande());
/* 112 */               payement.setBc(op.getBoncommande().isBc());
/* 113 */               payement.setLc(op.getBoncommande().isLettrecommande());
/* 114 */               payement.setMission(op.getBoncommande().isMission());
/* 115 */               payement.setDecision(op.getBoncommande().isDecision());
/* 116 */               payement.setSalaire(op.getBoncommande().isSalaire());
/* 117 */               payement.setFacture(false);
/* 118 */               payement.setMontant(resultat.getLong("montant"));
/* 119 */               payement.setVirementId(resultat.getInt("id"));
/* 120 */               payement.setReference(op.getBoncommande().getCode());
/*     */ 
/*     */               
/* 123 */               payement.setNombeneficiaire(resultat.getString("nombeneficiaire"));
/* 124 */               payement.setRibbeneficiaire(resultat.getString("ribbeneficiaire"));
/* 125 */               payement.setObjet(resultat.getString("motif"));
/* 126 */               payement.setCode("-");
/* 127 */               this.payementFacadeLocal.create(payement);
/*     */               
/* 129 */               Boncommande bc = this.boncommandeFacadeLocal.find(op.getBoncommande().getIdboncommande());
/* 130 */               bc.setMontantPaye(bc.getMontantPaye() + montant);
/*     */               
/* 132 */               Tache t = this.tacheFacadeLocal.find(bc.getMoyens().getIdtache().getIdtache());
/* 133 */               t.setMontantpayeht(t.getMontantpayeht() + montant);
/* 134 */               t.setMontantpayettc(t.getMontantpayettc() + montant);
/*     */               
/* 136 */               Moyens m = this.moyensFacadeLocal.find(bc.getMoyens().getIdmoyens());
/* 137 */               m.setMontantPaye(m.getMontantPaye() + montant);
/*     */               
/* 139 */               op.setPaye(true);
/* 140 */               this.ordrePayementFacadeLocal.edit(op);
/*     */               
/* 142 */               this.boncommandeFacadeLocal.edit(bc);
/* 143 */               this.moyensFacadeLocal.edit(m);
/* 144 */               this.tacheFacadeLocal.edit(t);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/* 149 */       JsfUtil.addSuccessMessage("Importation réussie");
/* 150 */       connection.close();
/* 151 */     } catch (SQLException ex) {
/* 152 */       Logger.getLogger(PayementMarcheController.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 153 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void print() {
/*     */     try {
/* 160 */       if (!Utilitaires.isAccess(Long.valueOf(25L))) {
/* 161 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engagement");
/*     */         
/*     */         return;
/*     */       } 
/* 165 */       Map<Object, Object> parameter = new HashMap<>();
/* 166 */       parameter.put("idboncommande", null);
/* 167 */       Printer p = new Printer();
/* 168 */       p.print("/rapport/report_camer_soft/bon_commande.jasper", parameter);
/* 169 */     } catch (Exception e) {
/* 170 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 175 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 179 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 183 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 187 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 191 */     return this.mode;
/*     */   }
/*     */   
/*     */   public List<Payement> getPayements() {
/* 195 */     this.payements = this.payementFacadeLocal.findByIdAnnee(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue());
/* 196 */     return this.payements;
/*     */   }
/*     */   
/*     */   public void setPayements(List<Payement> payements) {
/* 200 */     this.payements = payements;
/*     */   }
/*     */   
/*     */   public Payement getPayement() {
/* 204 */     return this.payement;
/*     */   }
/*     */   
/*     */   public void setPayement(Payement payement) {
/* 208 */     this.payement = payement;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\PayementMarcheController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */