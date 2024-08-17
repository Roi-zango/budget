/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.CascadeType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlTransient;
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
/*     */ @Table(name = "continent")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Continent.findAll", query = "SELECT c FROM Continent c"), @NamedQuery(name = "Continent.findByIdContinent", query = "SELECT c FROM Continent c WHERE c.idContinent = :idContinent"), @NamedQuery(name = "Continent.findByLibelle", query = "SELECT c FROM Continent c WHERE c.libelle = :libelle"), @NamedQuery(name = "Continent.findByEtat", query = "SELECT c FROM Continent c WHERE c.etat = :etat"), @NamedQuery(name = "Continent.findByDateEnregistre", query = "SELECT c FROM Continent c WHERE c.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Continent.findByDerniereModif", query = "SELECT c FROM Continent c WHERE c.derniereModif = :derniereModif")})
/*     */ public class Continent
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_continent")
/*     */   private Long idContinent;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idContinent", fetch = FetchType.LAZY)
/*     */   private List<Pays> paysList;
/*     */   
/*     */   public Continent() {}
/*     */   
/*     */   public Continent(Long idContinent) {
/*  68 */     this.idContinent = idContinent;
/*     */   }
/*     */   
/*     */   public Long getIdContinent() {
/*  72 */     return this.idContinent;
/*     */   }
/*     */   
/*     */   public void setIdContinent(Long idContinent) {
/*  76 */     this.idContinent = idContinent;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  80 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  84 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  88 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  92 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/*  96 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 100 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 104 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 108 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Pays> getPaysList() {
/* 113 */     return this.paysList;
/*     */   }
/*     */   
/*     */   public void setPaysList(List<Pays> paysList) {
/* 117 */     this.paysList = paysList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 122 */     int hash = 0;
/* 123 */     hash += (this.idContinent != null) ? this.idContinent.hashCode() : 0;
/* 124 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 130 */     if (!(object instanceof Continent)) {
/* 131 */       return false;
/*     */     }
/* 133 */     Continent other = (Continent)object;
/* 134 */     if ((this.idContinent == null && other.idContinent != null) || (this.idContinent != null && !this.idContinent.equals(other.idContinent))) {
/* 135 */       return false;
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     return "entities.Continent[ idContinent=" + this.idContinent + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Continent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */