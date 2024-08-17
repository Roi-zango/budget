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
/*     */ @Table(name = "revuedifficilte")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revuedifficilte.findAll", query = "SELECT r FROM Revuedifficilte r"), @NamedQuery(name = "Revuedifficilte.findByIdrevuedifficilte", query = "SELECT r FROM Revuedifficilte r WHERE r.idrevuedifficilte = :idrevuedifficilte"), @NamedQuery(name = "Revuedifficilte.findByDifficulte", query = "SELECT r FROM Revuedifficilte r WHERE r.difficulte = :difficulte"), @NamedQuery(name = "Revuedifficilte.findBySolution", query = "SELECT r FROM Revuedifficilte r WHERE r.solution = :solution"), @NamedQuery(name = "Revuedifficilte.findByObservation", query = "SELECT r FROM Revuedifficilte r WHERE r.observation = :observation"), @NamedQuery(name = "Revuedifficilte.findByEtat", query = "SELECT r FROM Revuedifficilte r WHERE r.etat = :etat"), @NamedQuery(name = "Revuedifficilte.findByDateEnregistre", query = "SELECT r FROM Revuedifficilte r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revuedifficilte.findByDerniereModif", query = "SELECT r FROM Revuedifficilte r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Revuedifficilte
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idrevuedifficilte")
/*     */   private Integer idrevuedifficilte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "difficulte")
/*     */   private String difficulte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "solution")
/*     */   private String solution;
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
/*     */   @JoinColumn(name = "idrubriquedifficulte", referencedColumnName = "idrubriquedifficulte")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Rubriquedifficulte idrubriquedifficulte;
/*     */   
/*     */   public Revuedifficilte() {}
/*     */   
/*     */   public Revuedifficilte(Integer idrevuedifficilte) {
/*  82 */     this.idrevuedifficilte = idrevuedifficilte;
/*     */   }
/*     */   
/*     */   public Integer getIdrevuedifficilte() {
/*  86 */     return this.idrevuedifficilte;
/*     */   }
/*     */   
/*     */   public void setIdrevuedifficilte(Integer idrevuedifficilte) {
/*  90 */     this.idrevuedifficilte = idrevuedifficilte;
/*     */   }
/*     */   
/*     */   public String getDifficulte() {
/*  94 */     return this.difficulte;
/*     */   }
/*     */   
/*     */   public void setDifficulte(String difficulte) {
/*  98 */     this.difficulte = difficulte;
/*     */   }
/*     */   
/*     */   public String getSolution() {
/* 102 */     return this.solution;
/*     */   }
/*     */   
/*     */   public void setSolution(String solution) {
/* 106 */     this.solution = solution;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 110 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 114 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 118 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 122 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 126 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 130 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 134 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 138 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Revueprogramme getRevueprogramme() {
/* 142 */     return this.revueprogramme;
/*     */   }
/*     */   
/*     */   public void setRevueprogramme(Revueprogramme revueprogramme) {
/* 146 */     this.revueprogramme = revueprogramme;
/*     */   }
/*     */   
/*     */   public Rubriquedifficulte getIdrubriquedifficulte() {
/* 150 */     return this.idrubriquedifficulte;
/*     */   }
/*     */   
/*     */   public void setIdrubriquedifficulte(Rubriquedifficulte idrubriquedifficulte) {
/* 154 */     this.idrubriquedifficulte = idrubriquedifficulte;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 159 */     int hash = 0;
/* 160 */     hash += (this.idrevuedifficilte != null) ? this.idrevuedifficilte.hashCode() : 0;
/* 161 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 167 */     if (!(object instanceof Revuedifficilte)) {
/* 168 */       return false;
/*     */     }
/* 170 */     Revuedifficilte other = (Revuedifficilte)object;
/* 171 */     if ((this.idrevuedifficilte == null && other.idrevuedifficilte != null) || (this.idrevuedifficilte != null && !this.idrevuedifficilte.equals(other.idrevuedifficilte))) {
/* 172 */       return false;
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 179 */     return "entities.Revuedifficilte[ idrevuedifficilte=" + this.idrevuedifficilte + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revuedifficilte.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */