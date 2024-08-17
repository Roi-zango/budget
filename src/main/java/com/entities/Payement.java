/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Entity
/*     */ public class Payement
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   private Long idpayement;
/*     */   @Column(length = 50)
/*     */   private String code;
/*     */   @Column(length = 50)
/*     */   private String reference;
/*     */   @Column(length = 500)
/*     */   private String objet;
/*     */   private double montant;
/*     */   private boolean bc;
/*     */   private boolean lc;
/*     */   private boolean decision;
/*     */   private boolean mission;
/*     */   private boolean salaire;
/*     */   private boolean facture;
/*     */   private String ribbeneficiaire;
/*     */   private String nombeneficiaire;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date datesaisie;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date datevalidation;
/*     */   @Column(name = "virement_id")
/*     */   private int virementId;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "idboncommande", referencedColumnName = "idboncommande")
/*     */   private Boncommande boncommande;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_ordre_payement", referencedColumnName = "id_ordre_payement")
/*     */   private OrdrePayement odrePayement;
/*     */   
/*     */   public Long getIdpayement() {
/*  62 */     return this.idpayement;
/*     */   }
/*     */   
/*     */   public void setIdpayement(Long idpayement) {
/*  66 */     this.idpayement = idpayement;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  70 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  74 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getReference() {
/*  78 */     return this.reference;
/*     */   }
/*     */   
/*     */   public void setReference(String reference) {
/*  82 */     this.reference = reference;
/*     */   }
/*     */   
/*     */   public String getObjet() {
/*  86 */     return this.objet;
/*     */   }
/*     */   
/*     */   public void setObjet(String objet) {
/*  90 */     this.objet = objet;
/*     */   }
/*     */   
/*     */   public double getMontant() {
/*  94 */     return this.montant;
/*     */   }
/*     */   
/*     */   public void setMontant(double montant) {
/*  98 */     this.montant = montant;
/*     */   }
/*     */   
/*     */   public boolean isBc() {
/* 102 */     return this.bc;
/*     */   }
/*     */   
/*     */   public void setBc(boolean bc) {
/* 106 */     this.bc = bc;
/*     */   }
/*     */   
/*     */   public boolean isLc() {
/* 110 */     return this.lc;
/*     */   }
/*     */   
/*     */   public void setLc(boolean lc) {
/* 114 */     this.lc = lc;
/*     */   }
/*     */   
/*     */   public boolean isDecision() {
/* 118 */     return this.decision;
/*     */   }
/*     */   
/*     */   public void setDecision(boolean decision) {
/* 122 */     this.decision = decision;
/*     */   }
/*     */   
/*     */   public boolean isMission() {
/* 126 */     return this.mission;
/*     */   }
/*     */   
/*     */   public void setMission(boolean mission) {
/* 130 */     this.mission = mission;
/*     */   }
/*     */   
/*     */   public boolean isSalaire() {
/* 134 */     return this.salaire;
/*     */   }
/*     */   
/*     */   public void setSalaire(boolean salaire) {
/* 138 */     this.salaire = salaire;
/*     */   }
/*     */   
/*     */   public boolean isFacture() {
/* 142 */     return this.facture;
/*     */   }
/*     */   
/*     */   public void setFacture(boolean facture) {
/* 146 */     this.facture = facture;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 150 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 154 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public String getRibbeneficiaire() {
/* 158 */     return this.ribbeneficiaire;
/*     */   }
/*     */   
/*     */   public void setRibbeneficiaire(String ribbeneficiaire) {
/* 162 */     this.ribbeneficiaire = ribbeneficiaire;
/*     */   }
/*     */   
/*     */   public String getNombeneficiaire() {
/* 166 */     return this.nombeneficiaire;
/*     */   }
/*     */   
/*     */   public void setNombeneficiaire(String nombeneficiaire) {
/* 170 */     this.nombeneficiaire = nombeneficiaire;
/*     */   }
/*     */   
/*     */   public Date getDatesaisie() {
/* 174 */     return this.datesaisie;
/*     */   }
/*     */   
/*     */   public void setDatesaisie(Date datesaisie) {
/* 178 */     this.datesaisie = datesaisie;
/*     */   }
/*     */   
/*     */   public Date getDateValidation() {
/* 182 */     return this.datevalidation;
/*     */   }
/*     */   
/*     */   public void setDateValidation(Date dataValidation) {
/* 186 */     this.datevalidation = dataValidation;
/*     */   }
/*     */   
/*     */   public int getVirementId() {
/* 190 */     return this.virementId;
/*     */   }
/*     */   
/*     */   public void setVirementId(int virementId) {
/* 194 */     this.virementId = virementId;
/*     */   }
/*     */   
/*     */   public Date getDatevalidation() {
/* 198 */     return this.datevalidation;
/*     */   }
/*     */   
/*     */   public void setDatevalidation(Date datevalidation) {
/* 202 */     this.datevalidation = datevalidation;
/*     */   }
/*     */   
/*     */   public OrdrePayement getOdrePayement() {
/* 206 */     return this.odrePayement;
/*     */   }
/*     */   
/*     */   public void setOdrePayement(OrdrePayement odrePayement) {
/* 210 */     this.odrePayement = odrePayement;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 215 */     return "Payement{idpayement=" + this.idpayement + ", code=" + this.code + ", reference=" + this.reference + ", objet=" + this.objet + ", montant=" + this.montant + ", mission=" + this.mission + ", ribbeneficiaire=" + this.ribbeneficiaire + ", nombeneficiaire=" + this.nombeneficiaire + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 220 */     int hash = 5;
/* 221 */     hash = 47 * hash + Objects.hashCode(this.idpayement);
/* 222 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 227 */     if (obj == null) {
/* 228 */       return false;
/*     */     }
/* 230 */     if (getClass() != obj.getClass()) {
/* 231 */       return false;
/*     */     }
/* 233 */     Payement other = (Payement)obj;
/* 234 */     if (!Objects.equals(this.idpayement, other.idpayement)) {
/* 235 */       return false;
/*     */     }
/* 237 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Payement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */