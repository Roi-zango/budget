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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "indicateuractiviteannee")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateuractiviteannee.findAll", query = "SELECT i FROM Indicateuractiviteannee i"), @NamedQuery(name = "Indicateuractiviteannee.findByIdindicateuractiviteannee", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.idindicateuractiviteannee = :idindicateuractiviteannee"), @NamedQuery(name = "Indicateuractiviteannee.findByAnnecible", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.annecible = :annecible"), @NamedQuery(name = "Indicateuractiviteannee.findByAnnebaseline", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.annebaseline = :annebaseline"), @NamedQuery(name = "Indicateuractiviteannee.findByValeurintermediaire", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.valeurintermediaire = :valeurintermediaire"), @NamedQuery(name = "Indicateuractiviteannee.findByUnite", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.unite = :unite"), @NamedQuery(name = "Indicateuractiviteannee.findByCible", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.cible = :cible"), @NamedQuery(name = "Indicateuractiviteannee.findByBaseline", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.baseline = :baseline"), @NamedQuery(name = "Indicateuractiviteannee.findByValeurrealise", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.valeurrealise = :valeurrealise"), @NamedQuery(name = "Indicateuractiviteannee.findByObservation", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.observation = :observation"), @NamedQuery(name = "Indicateuractiviteannee.findByEtat", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.etat = :etat"), @NamedQuery(name = "Indicateuractiviteannee.findByDateEnregistre", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Indicateuractiviteannee.findByDerniereModif", query = "SELECT i FROM Indicateuractiviteannee i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Indicateuractiviteannee
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateuractiviteannee")
/*     */   private Integer idindicateuractiviteannee;
/*     */   @Column(name = "annecible")
/*     */   private Integer annecible;
/*     */   @Column(name = "annebaseline")
/*     */   private Integer annebaseline;
/*     */   @Column(name = "valeurintermediaire")
/*     */   private Double valeurintermediaire;
/*     */   @Size(max = 254)
/*     */   @Column(name = "unite")
/*     */   private String unite;
/*     */   @Column(name = "cible")
/*     */   private Double cible;
/*     */   @Column(name = "baseline")
/*     */   private Double baseline;
/*     */   @Column(name = "valeurrealise")
/*     */   private Double valeurrealise;
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
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @JoinColumn(name = "idindicateuractivite", referencedColumnName = "idindicateuractivite")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Indicateuractivite idindicateuractivite;
/*     */   @JoinColumn(name = "idtypedonnees", referencedColumnName = "idtypedonnees")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typedonnees idtypedonnees;
/*     */   
/*     */   public Indicateuractiviteannee() {}
/*     */   
/*     */   public Indicateuractiviteannee(Integer idindicateuractiviteannee) {
/*  96 */     this.idindicateuractiviteannee = idindicateuractiviteannee;
/*     */   }
/*     */   
/*     */   public Integer getIdindicateuractiviteannee() {
/* 100 */     return this.idindicateuractiviteannee;
/*     */   }
/*     */   
/*     */   public void setIdindicateuractiviteannee(Integer idindicateuractiviteannee) {
/* 104 */     this.idindicateuractiviteannee = idindicateuractiviteannee;
/*     */   }
/*     */   
/*     */   public Integer getAnnecible() {
/* 108 */     return this.annecible;
/*     */   }
/*     */   
/*     */   public void setAnnecible(Integer annecible) {
/* 112 */     this.annecible = annecible;
/*     */   }
/*     */   
/*     */   public Integer getAnnebaseline() {
/* 116 */     return this.annebaseline;
/*     */   }
/*     */   
/*     */   public void setAnnebaseline(Integer annebaseline) {
/* 120 */     this.annebaseline = annebaseline;
/*     */   }
/*     */   
/*     */   public Double getValeurintermediaire() {
/* 124 */     return this.valeurintermediaire;
/*     */   }
/*     */   
/*     */   public void setValeurintermediaire(Double valeurintermediaire) {
/* 128 */     this.valeurintermediaire = valeurintermediaire;
/*     */   }
/*     */   
/*     */   public String getUnite() {
/* 132 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(String unite) {
/* 136 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/* 140 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/* 144 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public Double getBaseline() {
/* 148 */     return this.baseline;
/*     */   }
/*     */   
/*     */   public void setBaseline(Double baseline) {
/* 152 */     this.baseline = baseline;
/*     */   }
/*     */   
/*     */   public Double getValeurrealise() {
/* 156 */     return this.valeurrealise;
/*     */   }
/*     */   
/*     */   public void setValeurrealise(Double valeurrealise) {
/* 160 */     this.valeurrealise = valeurrealise;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 164 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 168 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 172 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 176 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 180 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 184 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 188 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 192 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 196 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 200 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Indicateuractivite getIdindicateuractivite() {
/* 204 */     return this.idindicateuractivite;
/*     */   }
/*     */   
/*     */   public void setIdindicateuractivite(Indicateuractivite idindicateuractivite) {
/* 208 */     this.idindicateuractivite = idindicateuractivite;
/*     */   }
/*     */   
/*     */   public Typedonnees getIdtypedonnees() {
/* 212 */     return this.idtypedonnees;
/*     */   }
/*     */   
/*     */   public void setIdtypedonnees(Typedonnees idtypedonnees) {
/* 216 */     this.idtypedonnees = idtypedonnees;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 221 */     int hash = 0;
/* 222 */     hash += (this.idindicateuractiviteannee != null) ? this.idindicateuractiviteannee.hashCode() : 0;
/* 223 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 229 */     if (!(object instanceof Indicateuractiviteannee)) {
/* 230 */       return false;
/*     */     }
/* 232 */     Indicateuractiviteannee other = (Indicateuractiviteannee)object;
/* 233 */     if ((this.idindicateuractiviteannee == null && other.idindicateuractiviteannee != null) || (this.idindicateuractiviteannee != null && !this.idindicateuractiviteannee.equals(other.idindicateuractiviteannee))) {
/* 234 */       return false;
/*     */     }
/* 236 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 241 */     return "entities.Indicateuractiviteannee[ idindicateuractiviteannee=" + this.idindicateuractiviteannee + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateuractiviteannee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */