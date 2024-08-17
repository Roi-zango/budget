/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ @Entity
/*     */ @Table(name = "operations")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o"), @NamedQuery(name = "Operations.findByIdOperations", query = "SELECT o FROM Operations o WHERE o.idOperations = :idOperations"), @NamedQuery(name = "Operations.findByLibelle", query = "SELECT o FROM Operations o WHERE o.libelle = :libelle"), @NamedQuery(name = "Operations.findByCible", query = "SELECT o FROM Operations o WHERE o.cible = :cible"), @NamedQuery(name = "Operations.findByAdresseIp", query = "SELECT o FROM Operations o WHERE o.adresseIp = :adresseIp"), @NamedQuery(name = "Operations.findByAdresseMac", query = "SELECT o FROM Operations o WHERE o.adresseMac = :adresseMac"), @NamedQuery(name = "Operations.findByAdressenom", query = "SELECT o FROM Operations o WHERE o.adressenom = :adressenom"), @NamedQuery(name = "Operations.findByEtat", query = "SELECT o FROM Operations o WHERE o.etat = :etat"), @NamedQuery(name = "Operations.findByDateOpration", query = "SELECT o FROM Operations o WHERE o.dateOpration = :dateOpration"), @NamedQuery(name = "Operations.findByHeureOpration", query = "SELECT o FROM Operations o WHERE o.heureOpration = :heureOpration")})
/*     */ public class Operations
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_operations")
/*     */   private Long idOperations;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "cible")
/*     */   private String cible;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "adresse_ip")
/*     */   private String adresseIp;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "adresse_mac")
/*     */   private String adresseMac;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "adressenom")
/*     */   private String adressenom;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_opration")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateOpration;
/*     */   @Column(name = "heure_opration")
/*     */   @Temporal(TemporalType.TIME)
/*     */   private Date heureOpration;
/*     */   @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Compte idCompte;
/*     */   
/*     */   public Operations() {}
/*     */   
/*     */   public Operations(Long idOperations) {
/*  83 */     this.idOperations = idOperations;
/*     */   }
/*     */   
/*     */   public Long getIdOperations() {
/*  87 */     return this.idOperations;
/*     */   }
/*     */   
/*     */   public void setIdOperations(Long idOperations) {
/*  91 */     this.idOperations = idOperations;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  95 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  99 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public String getCible() {
/* 103 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(String cible) {
/* 107 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public String getAdresseIp() {
/* 111 */     return this.adresseIp;
/*     */   }
/*     */   
/*     */   public void setAdresseIp(String adresseIp) {
/* 115 */     this.adresseIp = adresseIp;
/*     */   }
/*     */   
/*     */   public String getAdresseMac() {
/* 119 */     return this.adresseMac;
/*     */   }
/*     */   
/*     */   public void setAdresseMac(String adresseMac) {
/* 123 */     this.adresseMac = adresseMac;
/*     */   }
/*     */   
/*     */   public String getAdressenom() {
/* 127 */     return this.adressenom;
/*     */   }
/*     */   
/*     */   public void setAdressenom(String adressenom) {
/* 131 */     this.adressenom = adressenom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 135 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 139 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateOpration() {
/* 143 */     return this.dateOpration;
/*     */   }
/*     */   
/*     */   public void setDateOpration(Date dateOpration) {
/* 147 */     this.dateOpration = dateOpration;
/*     */   }
/*     */   
/*     */   public Date getHeureOpration() {
/* 151 */     return this.heureOpration;
/*     */   }
/*     */   
/*     */   public void setHeureOpration(Date heureOpration) {
/* 155 */     this.heureOpration = heureOpration;
/*     */   }
/*     */   
/*     */   public Compte getIdCompte() {
/* 159 */     return this.idCompte;
/*     */   }
/*     */   
/*     */   public void setIdCompte(Compte idCompte) {
/* 163 */     this.idCompte = idCompte;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 168 */     int hash = 0;
/* 169 */     hash += (this.idOperations != null) ? this.idOperations.hashCode() : 0;
/* 170 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 176 */     if (!(object instanceof Operations)) {
/* 177 */       return false;
/*     */     }
/* 179 */     Operations other = (Operations)object;
/* 180 */     if ((this.idOperations == null && other.idOperations != null) || (this.idOperations != null && !this.idOperations.equals(other.idOperations))) {
/* 181 */       return false;
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 188 */     return "entities.Operations[ idOperations=" + this.idOperations + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Operations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */