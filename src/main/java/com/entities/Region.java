/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "region")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"), @NamedQuery(name = "Region.findByIdregion", query = "SELECT r FROM Region r WHERE r.idregion = :idregion"), @NamedQuery(name = "Region.findByNom", query = "SELECT r FROM Region r WHERE r.nom = :nom"), @NamedQuery(name = "Region.findBySuperficie", query = "SELECT r FROM Region r WHERE r.superficie = :superficie"), @NamedQuery(name = "Region.findByPopulation", query = "SELECT r FROM Region r WHERE r.population = :population"), @NamedQuery(name = "Region.findByEtat", query = "SELECT r FROM Region r WHERE r.etat = :etat"), @NamedQuery(name = "Region.findByDateEnregistre", query = "SELECT r FROM Region r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Region.findByDerniereModif", query = "SELECT r FROM Region r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Region
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idregion")
/*     */   private Long idregion;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "superficie")
/*     */   private BigInteger superficie;
/*     */   @Column(name = "population")
/*     */   private BigInteger population;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idregion", fetch = FetchType.LAZY)
/*     */   private List<Departement> departementList;
/*     */   @JoinColumn(name = "id_pays", referencedColumnName = "id_pays")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Pays idPays;
/*     */   @OneToMany(mappedBy = "idregion", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   
/*     */   public Region() {}
/*     */   
/*     */   public Region(Long idregion) {
/*  81 */     this.idregion = idregion;
/*     */   }
/*     */   
/*     */   public Long getIdregion() {
/*  85 */     return this.idregion;
/*     */   }
/*     */   
/*     */   public void setIdregion(Long idregion) {
/*  89 */     this.idregion = idregion;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  93 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  97 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public BigInteger getSuperficie() {
/* 101 */     return this.superficie;
/*     */   }
/*     */   
/*     */   public void setSuperficie(BigInteger superficie) {
/* 105 */     this.superficie = superficie;
/*     */   }
/*     */   
/*     */   public BigInteger getPopulation() {
/* 109 */     return this.population;
/*     */   }
/*     */   
/*     */   public void setPopulation(BigInteger population) {
/* 113 */     this.population = population;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 117 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 121 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 125 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 129 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 133 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 137 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Departement> getDepartementList() {
/* 142 */     return this.departementList;
/*     */   }
/*     */   
/*     */   public void setDepartementList(List<Departement> departementList) {
/* 146 */     this.departementList = departementList;
/*     */   }
/*     */   
/*     */   public Pays getIdPays() {
/* 150 */     return this.idPays;
/*     */   }
/*     */   
/*     */   public void setIdPays(Pays idPays) {
/* 154 */     this.idPays = idPays;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 159 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 163 */     this.structureList = structureList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 168 */     int hash = 0;
/* 169 */     hash += (this.idregion != null) ? this.idregion.hashCode() : 0;
/* 170 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 176 */     if (!(object instanceof Region)) {
/* 177 */       return false;
/*     */     }
/* 179 */     Region other = (Region)object;
/* 180 */     if ((this.idregion == null && other.idregion != null) || (this.idregion != null && !this.idregion.equals(other.idregion))) {
/* 181 */       return false;
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 188 */     return "entities.Region[ idregion=" + this.idregion + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Region.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */