/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "ordre_payement")
/*     */ public class OrdrePayement
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_ordre_payement")
/*     */   private Long idOrdrePayement;
/*     */   @Column(length = 100)
/*     */   private String beneficiaire;
/*     */   private Double montant;
/*     */   private boolean taxe;
/*     */   private boolean nap;
/*     */   @Column(length = 20)
/*     */   private String code;
/*     */   @Column(name = "montant_en_lettre", length = 150)
/*     */   private String montantEnLettre;
/*     */   @Column(name = "detail_nap")
/*     */   private double detailNap;
/*     */   @Column(name = "detail_tva")
/*     */   private double detailTva;
/*     */   @Column(name = "detail_air")
/*     */   private double detailAir;
/*     */   @Column(length = 100)
/*     */   private String pieces;
/*     */   @Column(length = 500)
/*     */   private String objet;
/*     */   @Column(name = "mode_paiement", length = 40)
/*     */   private String modePaiement;
/*     */   @Column(name = "nombre_verification")
/*     */   private int nombre_verification;
/*     */   private boolean etat;
/*     */   private boolean paye;
/*     */   @Temporal(TemporalType.DATE)
/*     */   @Column(name = "date_ordonnation")
/*     */   private Date dateOrdonnation;
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   @JoinColumn(name = "idboncommande", referencedColumnName = "idboncommande")
/*     */   private Boncommande boncommande;
/*     */   
/*     */   public String getCode() {
/*  68 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  72 */     this.code = code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrdrePayement() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrdrePayement(Long idOrdrePayement) {
/*  87 */     this.idOrdrePayement = idOrdrePayement;
/*     */   }
/*     */   
/*     */   public Long getIdOrdrePayement() {
/*  91 */     return this.idOrdrePayement;
/*     */   }
/*     */   
/*     */   public void setIdOrdrePayement(Long idOrdrePayement) {
/*  95 */     this.idOrdrePayement = idOrdrePayement;
/*     */   }
/*     */   
/*     */   public String getBeneficiaire() {
/*  99 */     return this.beneficiaire;
/*     */   }
/*     */   
/*     */   public void setBeneficiaire(String beneficiaire) {
/* 103 */     this.beneficiaire = beneficiaire;
/*     */   }
/*     */   
/*     */   public Date getDateOrdonnation() {
/* 107 */     return this.dateOrdonnation;
/*     */   }
/*     */   
/*     */   public void setDateOrdonnation(Date dateOrdonnation) {
/* 111 */     this.dateOrdonnation = dateOrdonnation;
/*     */   }
/*     */   
/*     */   public Double getMontant() {
/* 115 */     return this.montant;
/*     */   }
/*     */   
/*     */   public void setMontant(Double montant) {
/* 119 */     this.montant = montant;
/*     */   }
/*     */   
/*     */   public boolean isTaxe() {
/* 123 */     return this.taxe;
/*     */   }
/*     */   
/*     */   public void setTaxe(boolean taxe) {
/* 127 */     this.taxe = taxe;
/*     */   }
/*     */   
/*     */   public boolean isNap() {
/* 131 */     return this.nap;
/*     */   }
/*     */   
/*     */   public void setNap(boolean nap) {
/* 135 */     this.nap = nap;
/*     */   }
/*     */   
/*     */   public double getDetailNap() {
/* 139 */     return this.detailNap;
/*     */   }
/*     */   
/*     */   public void setDetailNap(double detailNap) {
/* 143 */     this.detailNap = detailNap;
/*     */   }
/*     */   
/*     */   public double getDetailTva() {
/* 147 */     return this.detailTva;
/*     */   }
/*     */   
/*     */   public void setDetailTva(double detailTva) {
/* 151 */     this.detailTva = detailTva;
/*     */   }
/*     */   
/*     */   public double getDetailAir() {
/* 155 */     return this.detailAir;
/*     */   }
/*     */   
/*     */   public void setDetailAir(double detailAir) {
/* 159 */     this.detailAir = detailAir;
/*     */   }
/*     */   
/*     */   public String getMontantEnLettre() {
/* 163 */     return this.montantEnLettre;
/*     */   }
/*     */   
/*     */   public void setMontantEnLettre(String montantEnLettre) {
/* 167 */     this.montantEnLettre = montantEnLettre;
/*     */   }
/*     */   
/*     */   public String getPieces() {
/* 171 */     return this.pieces;
/*     */   }
/*     */   
/*     */   public void setPieces(String pieces) {
/* 175 */     this.pieces = pieces;
/*     */   }
/*     */   
/*     */   public boolean isEtat() {
/* 179 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(boolean etat) {
/* 183 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public String getObjet() {
/* 187 */     return this.objet;
/*     */   }
/*     */   
/*     */   public void setObjet(String objet) {
/* 191 */     this.objet = objet;
/*     */   }
/*     */   
/*     */   public String getModePaiement() {
/* 195 */     return this.modePaiement;
/*     */   }
/*     */   
/*     */   public void setModePaiement(String modePaiement) {
/* 199 */     this.modePaiement = modePaiement;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 203 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 207 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public int getNombre_verification() {
/* 211 */     return this.nombre_verification;
/*     */   }
/*     */   
/*     */   public void setNombre_verification(int nombre_verification) {
/* 215 */     this.nombre_verification = nombre_verification;
/*     */   }
/*     */   
/*     */   public boolean isPaye() {
/* 219 */     return this.paye;
/*     */   }
/*     */   
/*     */   public void setPaye(boolean paye) {
/* 223 */     this.paye = paye;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 228 */     int hash = 5;
/* 229 */     hash = 23 * hash + Objects.hashCode(this.idOrdrePayement);
/* 230 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 235 */     if (obj == null) {
/* 236 */       return false;
/*     */     }
/* 238 */     if (getClass() != obj.getClass()) {
/* 239 */       return false;
/*     */     }
/* 241 */     OrdrePayement other = (OrdrePayement)obj;
/* 242 */     if (!Objects.equals(this.idOrdrePayement, other.idOrdrePayement)) {
/* 243 */       return false;
/*     */     }
/* 245 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 250 */     return "OrdrePayement{idOrdrePayement=" + this.idOrdrePayement + ", beneficiaire=" + this.beneficiaire + ", montant=" + this.montant + ", taxe=" + this.taxe + ", nap=" + this.nap + ", montantEnLettre=" + this.montantEnLettre + ", detailNap=" + this.detailNap + ", detailTva=" + this.detailTva + ", detailAir=" + this.detailAir + ", pieces=" + this.pieces + ", etat=" + this.etat + ", dateOrdonnation=" + this.dateOrdonnation + ", boncommande=" + this.boncommande + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\OrdrePayement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */