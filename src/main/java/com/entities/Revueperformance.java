/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinColumns;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "revueperformance")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revueperformance.findAll", query = "SELECT r FROM Revueperformance r"), @NamedQuery(name = "Revueperformance.findByIdrevueperformance", query = "SELECT r FROM Revueperformance r WHERE r.idrevueperformance = :idrevueperformance"), @NamedQuery(name = "Revueperformance.findByTauxrealise", query = "SELECT r FROM Revueperformance r WHERE r.tauxrealise = :tauxrealise"), @NamedQuery(name = "Revueperformance.findByObservation", query = "SELECT r FROM Revueperformance r WHERE r.observation = :observation"), @NamedQuery(name = "Revueperformance.findByIndicateur", query = "SELECT r FROM Revueperformance r WHERE r.indicateur = :indicateur"), @NamedQuery(name = "Revueperformance.findByEtat", query = "SELECT r FROM Revueperformance r WHERE r.etat = :etat"), @NamedQuery(name = "Revueperformance.findByDateEnregistre", query = "SELECT r FROM Revueperformance r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revueperformance.findByDerniereModif", query = "SELECT r FROM Revueperformance r WHERE r.derniereModif = :derniereModif"), @NamedQuery(name = "Revueperformance.findByValeurcible", query = "SELECT r FROM Revueperformance r WHERE r.valeurcible = :valeurcible"), @NamedQuery(name = "Revueperformance.findByValeurrealise", query = "SELECT r FROM Revueperformance r WHERE r.valeurrealise = :valeurrealise")})
/*     */ public class Revueperformance
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idrevueperformance")
/*     */   private Integer idrevueperformance;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "tauxrealise")
/*     */   private String tauxrealise;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "observation")
/*     */   private String observation;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "indicateur")
/*     */   private String indicateur;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Column(name = "valeurcible")
/*     */   private Double valeurcible;
/*     */   @Column(name = "valeurrealise")
/*     */   private Double valeurrealise;
/*     */   @JoinColumns({@JoinColumn(name = "idrevue", referencedColumnName = "idrevue"), @JoinColumn(name = "idprogramme", referencedColumnName = "idprogramme")})
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Revueprogramme revueprogramme;
/*     */   
/*     */   public Revueperformance() {}
/*     */   
/*     */   public Revueperformance(Integer idrevueperformance) {
/*  86 */     this.idrevueperformance = idrevueperformance;
/*     */   }
/*     */   
/*     */   public Integer getIdrevueperformance() {
/*  90 */     return this.idrevueperformance;
/*     */   }
/*     */   
/*     */   public void setIdrevueperformance(Integer idrevueperformance) {
/*  94 */     this.idrevueperformance = idrevueperformance;
/*     */   }
/*     */   
/*     */   public String getTauxrealise() {
/*  98 */     return this.tauxrealise;
/*     */   }
/*     */   
/*     */   public void setTauxrealise(String tauxrealise) {
/* 102 */     this.tauxrealise = tauxrealise;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 106 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 110 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public String getIndicateur() {
/* 114 */     return this.indicateur;
/*     */   }
/*     */   
/*     */   public void setIndicateur(String indicateur) {
/* 118 */     this.indicateur = indicateur;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 122 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 126 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 130 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 134 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 138 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 142 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Double getValeurcible() {
/* 146 */     return this.valeurcible;
/*     */   }
/*     */   
/*     */   public void setValeurcible(Double valeurcible) {
/* 150 */     this.valeurcible = valeurcible;
/*     */   }
/*     */   
/*     */   public Double getValeurrealise() {
/* 154 */     return this.valeurrealise;
/*     */   }
/*     */   
/*     */   public void setValeurrealise(Double valeurrealise) {
/* 158 */     this.valeurrealise = valeurrealise;
/*     */   }
/*     */   
/*     */   public Revueprogramme getRevueprogramme() {
/* 162 */     return this.revueprogramme;
/*     */   }
/*     */   
/*     */   public void setRevueprogramme(Revueprogramme revueprogramme) {
/* 166 */     this.revueprogramme = revueprogramme;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 171 */     int hash = 0;
/* 172 */     hash += (this.idrevueperformance != null) ? this.idrevueperformance.hashCode() : 0;
/* 173 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 179 */     if (!(object instanceof Revueperformance)) {
/* 180 */       return false;
/*     */     }
/* 182 */     Revueperformance other = (Revueperformance)object;
/* 183 */     if ((this.idrevueperformance == null && other.idrevueperformance != null) || (this.idrevueperformance != null && !this.idrevueperformance.equals(other.idrevueperformance))) {
/* 184 */       return false;
/*     */     }
/* 186 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 191 */     return "entities.Revueperformance[ idrevueperformance=" + this.idrevueperformance + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueperformance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */