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
/*     */ @Entity
/*     */ @Table(name = "revuefait")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revuefait.findAll", query = "SELECT r FROM Revuefait r"), @NamedQuery(name = "Revuefait.findByIdrevuefait", query = "SELECT r FROM Revuefait r WHERE r.idrevuefait = :idrevuefait"), @NamedQuery(name = "Revuefait.findByFait", query = "SELECT r FROM Revuefait r WHERE r.fait = :fait"), @NamedQuery(name = "Revuefait.findByImplication", query = "SELECT r FROM Revuefait r WHERE r.implication = :implication"), @NamedQuery(name = "Revuefait.findByObservation", query = "SELECT r FROM Revuefait r WHERE r.observation = :observation"), @NamedQuery(name = "Revuefait.findByEtat", query = "SELECT r FROM Revuefait r WHERE r.etat = :etat"), @NamedQuery(name = "Revuefait.findByDateEnregistre", query = "SELECT r FROM Revuefait r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revuefait.findByDerniereModif", query = "SELECT r FROM Revuefait r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Revuefait
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idrevuefait")
/*     */   private Integer idrevuefait;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "fait")
/*     */   private String fait;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "implication")
/*     */   private String implication;
/*     */   @Size(max = 1024)
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
/*     */   @JoinColumns({@JoinColumn(name = "idrevue", referencedColumnName = "idrevue"), @JoinColumn(name = "idprogramme", referencedColumnName = "idprogramme")})
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Revueprogramme revueprogramme;
/*     */   
/*     */   public Revuefait() {}
/*     */   
/*     */   public Revuefait(Integer idrevuefait) {
/*  79 */     this.idrevuefait = idrevuefait;
/*     */   }
/*     */   
/*     */   public Integer getIdrevuefait() {
/*  83 */     return this.idrevuefait;
/*     */   }
/*     */   
/*     */   public void setIdrevuefait(Integer idrevuefait) {
/*  87 */     this.idrevuefait = idrevuefait;
/*     */   }
/*     */   
/*     */   public String getFait() {
/*  91 */     return this.fait;
/*     */   }
/*     */   
/*     */   public void setFait(String fait) {
/*  95 */     this.fait = fait;
/*     */   }
/*     */   
/*     */   public String getImplication() {
/*  99 */     return this.implication;
/*     */   }
/*     */   
/*     */   public void setImplication(String implication) {
/* 103 */     this.implication = implication;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 107 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 111 */     this.observation = observation;
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
/* 149 */     hash += (this.idrevuefait != null) ? this.idrevuefait.hashCode() : 0;
/* 150 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 156 */     if (!(object instanceof Revuefait)) {
/* 157 */       return false;
/*     */     }
/* 159 */     Revuefait other = (Revuefait)object;
/* 160 */     if ((this.idrevuefait == null && other.idrevuefait != null) || (this.idrevuefait != null && !this.idrevuefait.equals(other.idrevuefait))) {
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 168 */     return "entities.Revuefait[ idrevuefait=" + this.idrevuefait + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revuefait.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */