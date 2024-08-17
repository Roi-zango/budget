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
/*     */ @Entity
/*     */ @Table(name = "revueaction")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revueaction.findAll", query = "SELECT r FROM Revueaction r"), @NamedQuery(name = "Revueaction.findByIdrevueaction", query = "SELECT r FROM Revueaction r WHERE r.idrevueaction = :idrevueaction"), @NamedQuery(name = "Revueaction.findByActivitesupprimes", query = "SELECT r FROM Revueaction r WHERE r.activitesupprimes = :activitesupprimes"), @NamedQuery(name = "Revueaction.findByObservation", query = "SELECT r FROM Revueaction r WHERE r.observation = :observation"), @NamedQuery(name = "Revueaction.findByEtat", query = "SELECT r FROM Revueaction r WHERE r.etat = :etat"), @NamedQuery(name = "Revueaction.findByDateEnregistre", query = "SELECT r FROM Revueaction r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revueaction.findByDerniereModif", query = "SELECT r FROM Revueaction r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Revueaction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idrevueaction")
/*     */   private Integer idrevueaction;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "activitesupprimes")
/*     */   private String activitesupprimes;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "observation")
/*     */   private String observation;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumn(name = "idaction", referencedColumnName = "idaction")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Action idaction;
/*     */   @JoinColumns({@JoinColumn(name = "idrevue", referencedColumnName = "idrevue"), @JoinColumn(name = "idprogramme", referencedColumnName = "idprogramme")})
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Revueprogramme revueprogramme;
/*     */   
/*     */   public Revueaction() {}
/*     */   
/*     */   public Revueaction(Integer idrevueaction) {
/*  78 */     this.idrevueaction = idrevueaction;
/*     */   }
/*     */   
/*     */   public Integer getIdrevueaction() {
/*  82 */     return this.idrevueaction;
/*     */   }
/*     */   
/*     */   public void setIdrevueaction(Integer idrevueaction) {
/*  86 */     this.idrevueaction = idrevueaction;
/*     */   }
/*     */   
/*     */   public String getActivitesupprimes() {
/*  90 */     return this.activitesupprimes;
/*     */   }
/*     */   
/*     */   public void setActivitesupprimes(String activitesupprimes) {
/*  94 */     this.activitesupprimes = activitesupprimes;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/*  98 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 102 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 106 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 110 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 114 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 118 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 122 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 126 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Action getIdaction() {
/* 130 */     return this.idaction;
/*     */   }
/*     */   
/*     */   public void setIdaction(Action idaction) {
/* 134 */     this.idaction = idaction;
/*     */   }
/*     */   
/*     */   public Revueprogramme getRevueprogramme() {
/* 138 */     return this.revueprogramme;
/*     */   }
/*     */   
/*     */   public void setRevueprogramme(Revueprogramme revueprogramme) {
/* 142 */     this.revueprogramme = revueprogramme;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     int hash = 0;
/* 148 */     hash += (this.idrevueaction != null) ? this.idrevueaction.hashCode() : 0;
/* 149 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 155 */     if (!(object instanceof Revueaction)) {
/* 156 */       return false;
/*     */     }
/* 158 */     Revueaction other = (Revueaction)object;
/* 159 */     if ((this.idrevueaction == null && other.idrevueaction != null) || (this.idrevueaction != null && !this.idrevueaction.equals(other.idrevueaction))) {
/* 160 */       return false;
/*     */     }
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     return "entities.Revueaction[ idrevueaction=" + this.idrevueaction + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */