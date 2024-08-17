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
/*     */ @Entity
/*     */ @Table(name = "revueactivite")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revueactivite.findAll", query = "SELECT r FROM Revueactivite r"), @NamedQuery(name = "Revueactivite.findByIdrevueactivite", query = "SELECT r FROM Revueactivite r WHERE r.idrevueactivite = :idrevueactivite"), @NamedQuery(name = "Revueactivite.findByActivites", query = "SELECT r FROM Revueactivite r WHERE r.activites = :activites"), @NamedQuery(name = "Revueactivite.findByCout", query = "SELECT r FROM Revueactivite r WHERE r.cout = :cout"), @NamedQuery(name = "Revueactivite.findByObservations", query = "SELECT r FROM Revueactivite r WHERE r.observations = :observations"), @NamedQuery(name = "Revueactivite.findByEtat", query = "SELECT r FROM Revueactivite r WHERE r.etat = :etat"), @NamedQuery(name = "Revueactivite.findByDateEnregistre", query = "SELECT r FROM Revueactivite r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revueactivite.findByDerniereModif", query = "SELECT r FROM Revueactivite r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Revueactivite
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idrevueactivite")
/*     */   private Integer idrevueactivite;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "activites")
/*     */   private String activites;
/*     */   @Column(name = "cout")
/*     */   private Double cout;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "observations")
/*     */   private String observations;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumns({@JoinColumn(name = "idrevue", referencedColumnName = "idrevue"), @JoinColumn(name = "idprogramme", referencedColumnName = "idprogramme")})
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Revueprogramme revueprogramme;
/*     */   
/*     */   public Revueactivite() {}
/*     */   
/*     */   public Revueactivite(Integer idrevueactivite) {
/*  79 */     this.idrevueactivite = idrevueactivite;
/*     */   }
/*     */   
/*     */   public Integer getIdrevueactivite() {
/*  83 */     return this.idrevueactivite;
/*     */   }
/*     */   
/*     */   public void setIdrevueactivite(Integer idrevueactivite) {
/*  87 */     this.idrevueactivite = idrevueactivite;
/*     */   }
/*     */   
/*     */   public String getActivites() {
/*  91 */     return this.activites;
/*     */   }
/*     */   
/*     */   public void setActivites(String activites) {
/*  95 */     this.activites = activites;
/*     */   }
/*     */   
/*     */   public Double getCout() {
/*  99 */     return this.cout;
/*     */   }
/*     */   
/*     */   public void setCout(Double cout) {
/* 103 */     this.cout = cout;
/*     */   }
/*     */   
/*     */   public String getObservations() {
/* 107 */     return this.observations;
/*     */   }
/*     */   
/*     */   public void setObservations(String observations) {
/* 111 */     this.observations = observations;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 115 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 119 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 123 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 127 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 131 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 135 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Revueprogramme getRevueprogramme() {
/* 139 */     return this.revueprogramme;
/*     */   }
/*     */   
/*     */   public void setRevueprogramme(Revueprogramme revueprogramme) {
/* 143 */     this.revueprogramme = revueprogramme;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 148 */     int hash = 0;
/* 149 */     hash += (this.idrevueactivite != null) ? this.idrevueactivite.hashCode() : 0;
/* 150 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 156 */     if (!(object instanceof Revueactivite)) {
/* 157 */       return false;
/*     */     }
/* 159 */     Revueactivite other = (Revueactivite)object;
/* 160 */     if ((this.idrevueactivite == null && other.idrevueactivite != null) || (this.idrevueactivite != null && !this.idrevueactivite.equals(other.idrevueactivite))) {
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 168 */     return "entities.Revueactivite[ idrevueactivite=" + this.idrevueactivite + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueactivite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */