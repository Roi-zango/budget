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
/*     */ @Table(name = "indicateurprogrammeannee")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateurprogrammeannee.findAll", query = "SELECT i FROM Indicateurprogrammeannee i"), @NamedQuery(name = "Indicateurprogrammeannee.findByIdindicateurprogrammeannee", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.idindicateurprogrammeannee = :idindicateurprogrammeannee"), @NamedQuery(name = "Indicateurprogrammeannee.findByAnnecible", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.annecible = :annecible"), @NamedQuery(name = "Indicateurprogrammeannee.findByAnnebaseline", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.annebaseline = :annebaseline"), @NamedQuery(name = "Indicateurprogrammeannee.findByValeurintermediaire", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.valeurintermediaire = :valeurintermediaire"), @NamedQuery(name = "Indicateurprogrammeannee.findByUnite", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.unite = :unite"), @NamedQuery(name = "Indicateurprogrammeannee.findByCible", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.cible = :cible"), @NamedQuery(name = "Indicateurprogrammeannee.findByBaseline", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.baseline = :baseline"), @NamedQuery(name = "Indicateurprogrammeannee.findByValeurrealise", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.valeurrealise = :valeurrealise"), @NamedQuery(name = "Indicateurprogrammeannee.findByObservation", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.observation = :observation"), @NamedQuery(name = "Indicateurprogrammeannee.findByEtat", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.etat = :etat"), @NamedQuery(name = "Indicateurprogrammeannee.findByDateEnregistre", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Indicateurprogrammeannee.findByDerniereModif", query = "SELECT i FROM Indicateurprogrammeannee i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Indicateurprogrammeannee
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateurprogrammeannee")
/*     */   private Integer idindicateurprogrammeannee;
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
/*     */   @JoinColumn(name = "idindicateurprogramme", referencedColumnName = "idindicateurprogramme")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Indicateurprogramme idindicateurprogramme;
/*     */   @JoinColumn(name = "idtypedonnees", referencedColumnName = "idtypedonnees")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typedonnees idtypedonnees;
/*     */   
/*     */   public Indicateurprogrammeannee() {}
/*     */   
/*     */   public Indicateurprogrammeannee(Integer idindicateurprogrammeannee) {
/*  96 */     this.idindicateurprogrammeannee = idindicateurprogrammeannee;
/*     */   }
/*     */   
/*     */   public Integer getIdindicateurprogrammeannee() {
/* 100 */     return this.idindicateurprogrammeannee;
/*     */   }
/*     */   
/*     */   public void setIdindicateurprogrammeannee(Integer idindicateurprogrammeannee) {
/* 104 */     this.idindicateurprogrammeannee = idindicateurprogrammeannee;
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
/*     */   public Indicateurprogramme getIdindicateurprogramme() {
/* 204 */     return this.idindicateurprogramme;
/*     */   }
/*     */   
/*     */   public void setIdindicateurprogramme(Indicateurprogramme idindicateurprogramme) {
/* 208 */     this.idindicateurprogramme = idindicateurprogramme;
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
/* 222 */     hash += (this.idindicateurprogrammeannee != null) ? this.idindicateurprogrammeannee.hashCode() : 0;
/* 223 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 229 */     if (!(object instanceof Indicateurprogrammeannee)) {
/* 230 */       return false;
/*     */     }
/* 232 */     Indicateurprogrammeannee other = (Indicateurprogrammeannee)object;
/* 233 */     if ((this.idindicateurprogrammeannee == null && other.idindicateurprogrammeannee != null) || (this.idindicateurprogrammeannee != null && !this.idindicateurprogrammeannee.equals(other.idindicateurprogrammeannee))) {
/* 234 */       return false;
/*     */     }
/* 236 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 241 */     return "entities.Indicateurprogrammeannee[ idindicateurprogrammeannee=" + this.idindicateurprogrammeannee + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurprogrammeannee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */