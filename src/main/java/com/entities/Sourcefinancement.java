/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
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
/*     */ @Table(name = "sourcefinancement")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Sourcefinancement.findAll", query = "SELECT s FROM Sourcefinancement s"), @NamedQuery(name = "Sourcefinancement.findByIdsourcefinancement", query = "SELECT s FROM Sourcefinancement s WHERE s.idsourcefinancement = :idsourcefinancement"), @NamedQuery(name = "Sourcefinancement.findByNom", query = "SELECT s FROM Sourcefinancement s WHERE s.nom = :nom"), @NamedQuery(name = "Sourcefinancement.findByEtat", query = "SELECT s FROM Sourcefinancement s WHERE s.etat = :etat"), @NamedQuery(name = "Sourcefinancement.findByDateEnregistre", query = "SELECT s FROM Sourcefinancement s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Sourcefinancement.findByDerniereModif", query = "SELECT s FROM Sourcefinancement s WHERE s.derniereModif = :derniereModif")})
/*     */ public class Sourcefinancement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idsourcefinancement")
/*     */   private Long idsourcefinancement;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idsourcefinancement", fetch = FetchType.LAZY)
/*     */   private List<Bailleurfond> bailleurfondList;
/*     */   
/*     */   public Sourcefinancement() {}
/*     */   
/*     */   public Sourcefinancement(Long idsourcefinancement) {
/*  67 */     this.idsourcefinancement = idsourcefinancement;
/*     */   }
/*     */   
/*     */   public Long getIdsourcefinancement() {
/*  71 */     return this.idsourcefinancement;
/*     */   }
/*     */   
/*     */   public void setIdsourcefinancement(Long idsourcefinancement) {
/*  75 */     this.idsourcefinancement = idsourcefinancement;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  79 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  83 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  87 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  91 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/*  95 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/*  99 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 103 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 107 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Bailleurfond> getBailleurfondList() {
/* 112 */     return this.bailleurfondList;
/*     */   }
/*     */   
/*     */   public void setBailleurfondList(List<Bailleurfond> bailleurfondList) {
/* 116 */     this.bailleurfondList = bailleurfondList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idsourcefinancement != null) ? this.idsourcefinancement.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Sourcefinancement)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Sourcefinancement other = (Sourcefinancement)object;
/* 133 */     if ((this.idsourcefinancement == null && other.idsourcefinancement != null) || (this.idsourcefinancement != null && !this.idsourcefinancement.equals(other.idsourcefinancement))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Sourcefinancement[ idsourcefinancement=" + this.idsourcefinancement + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Sourcefinancement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */