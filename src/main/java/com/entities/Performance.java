/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.EmbeddedId;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinColumns;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
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
/*     */ @Table(name = "performance")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Performance.findAll", query = "SELECT p FROM Performance p"), @NamedQuery(name = "Performance.findByIdindicateurperformance", query = "SELECT p FROM Performance p WHERE p.performancePK.idindicateurperformance = :idindicateurperformance"), @NamedQuery(name = "Performance.findByIdstructure", query = "SELECT p FROM Performance p WHERE p.performancePK.idstructure = :idstructure"), @NamedQuery(name = "Performance.findByIdmission", query = "SELECT p FROM Performance p WHERE p.performancePK.idmission = :idmission"), @NamedQuery(name = "Performance.findByIdactivite", query = "SELECT p FROM Performance p WHERE p.performancePK.idactivite = :idactivite"), @NamedQuery(name = "Performance.findByJustification", query = "SELECT p FROM Performance p WHERE p.justification = :justification"), @NamedQuery(name = "Performance.findByAnnepta", query = "SELECT p FROM Performance p WHERE p.annepta = :annepta"), @NamedQuery(name = "Performance.findBySourceverification", query = "SELECT p FROM Performance p WHERE p.sourceverification = :sourceverification"), @NamedQuery(name = "Performance.findByCible", query = "SELECT p FROM Performance p WHERE p.cible = :cible"), @NamedQuery(name = "Performance.findByBaseline", query = "SELECT p FROM Performance p WHERE p.baseline = :baseline"), @NamedQuery(name = "Performance.findByConditionreussite", query = "SELECT p FROM Performance p WHERE p.conditionreussite = :conditionreussite"), @NamedQuery(name = "Performance.findBySourceverificationanterieur", query = "SELECT p FROM Performance p WHERE p.sourceverificationanterieur = :sourceverificationanterieur"), @NamedQuery(name = "Performance.findByCibleanterieur", query = "SELECT p FROM Performance p WHERE p.cibleanterieur = :cibleanterieur"), @NamedQuery(name = "Performance.findByReductionecart", query = "SELECT p FROM Performance p WHERE p.reductionecart = :reductionecart"), @NamedQuery(name = "Performance.findByEcart", query = "SELECT p FROM Performance p WHERE p.ecart = :ecart"), @NamedQuery(name = "Performance.findByValeurrealise", query = "SELECT p FROM Performance p WHERE p.valeurrealise = :valeurrealise"), @NamedQuery(name = "Performance.findByObservations", query = "SELECT p FROM Performance p WHERE p.observations = :observations"), @NamedQuery(name = "Performance.findByBaselineanterieur", query = "SELECT p FROM Performance p WHERE p.baselineanterieur = :baselineanterieur"), @NamedQuery(name = "Performance.findByObjectifspecifique", query = "SELECT p FROM Performance p WHERE p.objectifspecifique = :objectifspecifique"), @NamedQuery(name = "Performance.findByConditionsreussite", query = "SELECT p FROM Performance p WHERE p.conditionsreussite = :conditionsreussite"), @NamedQuery(name = "Performance.findByEnonceprojet", query = "SELECT p FROM Performance p WHERE p.enonceprojet = :enonceprojet"), @NamedQuery(name = "Performance.findByActioncorrectrices", query = "SELECT p FROM Performance p WHERE p.actioncorrectrices = :actioncorrectrices"), @NamedQuery(name = "Performance.findByConclusion", query = "SELECT p FROM Performance p WHERE p.conclusion = :conclusion"), @NamedQuery(name = "Performance.findByRecommandation", query = "SELECT p FROM Performance p WHERE p.recommandation = :recommandation")})
/*     */ public class Performance
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected PerformancePK performancePK;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "justification")
/*     */   private String justification;
/*     */   @Size(max = 254)
/*     */   @Column(name = "annepta")
/*     */   private String annepta;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "sourceverification")
/*     */   private String sourceverification;
/*     */   @Column(name = "cible")
/*     */   private Double cible;
/*     */   @Column(name = "baseline")
/*     */   private Double baseline;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "conditionreussite")
/*     */   private String conditionreussite;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "sourceverificationanterieur")
/*     */   private String sourceverificationanterieur;
/*     */   @Column(name = "cibleanterieur")
/*     */   private Double cibleanterieur;
/*     */   @Column(name = "reductionecart")
/*     */   private Double reductionecart;
/*     */   @Column(name = "ecart")
/*     */   private Double ecart;
/*     */   @Column(name = "valeurrealise")
/*     */   private Double valeurrealise;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "observations")
/*     */   private String observations;
/*     */   @Column(name = "baselineanterieur")
/*     */   private Double baselineanterieur;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "objectifspecifique")
/*     */   private String objectifspecifique;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "conditionsreussite")
/*     */   private String conditionsreussite;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "enonceprojet")
/*     */   private String enonceprojet;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "actioncorrectrices")
/*     */   private String actioncorrectrices;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "conclusion")
/*     */   private String conclusion;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "recommandation")
/*     */   private String recommandation;
/*     */   @JoinColumn(name = "idindicateurperformance", referencedColumnName = "idindicateurperformance", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Indicateurperformance indicateurperformance;
/*     */   @JoinColumns({@JoinColumn(name = "idstructure", referencedColumnName = "idstructure", insertable = false, updatable = false), @JoinColumn(name = "idmission", referencedColumnName = "idmission", insertable = false, updatable = false), @JoinColumn(name = "idactivite", referencedColumnName = "idactivite", insertable = false, updatable = false)})
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Structuremissionactivite structuremissionactivite;
/*     */   
/*     */   public Performance() {}
/*     */   
/*     */   public Performance(PerformancePK performancePK) {
/* 123 */     this.performancePK = performancePK;
/*     */   }
/*     */   
/*     */   public Performance(long idindicateurperformance, long idstructure, long idmission, long idactivite) {
/* 127 */     this.performancePK = new PerformancePK(idindicateurperformance, idstructure, idmission, idactivite);
/*     */   }
/*     */   
/*     */   public PerformancePK getPerformancePK() {
/* 131 */     return this.performancePK;
/*     */   }
/*     */   
/*     */   public void setPerformancePK(PerformancePK performancePK) {
/* 135 */     this.performancePK = performancePK;
/*     */   }
/*     */   
/*     */   public String getJustification() {
/* 139 */     return this.justification;
/*     */   }
/*     */   
/*     */   public void setJustification(String justification) {
/* 143 */     this.justification = justification;
/*     */   }
/*     */   
/*     */   public String getAnnepta() {
/* 147 */     return this.annepta;
/*     */   }
/*     */   
/*     */   public void setAnnepta(String annepta) {
/* 151 */     this.annepta = annepta;
/*     */   }
/*     */   
/*     */   public String getSourceverification() {
/* 155 */     return this.sourceverification;
/*     */   }
/*     */   
/*     */   public void setSourceverification(String sourceverification) {
/* 159 */     this.sourceverification = sourceverification;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/* 163 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/* 167 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public Double getBaseline() {
/* 171 */     return this.baseline;
/*     */   }
/*     */   
/*     */   public void setBaseline(Double baseline) {
/* 175 */     this.baseline = baseline;
/*     */   }
/*     */   
/*     */   public String getConditionreussite() {
/* 179 */     return this.conditionreussite;
/*     */   }
/*     */   
/*     */   public void setConditionreussite(String conditionreussite) {
/* 183 */     this.conditionreussite = conditionreussite;
/*     */   }
/*     */   
/*     */   public String getSourceverificationanterieur() {
/* 187 */     return this.sourceverificationanterieur;
/*     */   }
/*     */   
/*     */   public void setSourceverificationanterieur(String sourceverificationanterieur) {
/* 191 */     this.sourceverificationanterieur = sourceverificationanterieur;
/*     */   }
/*     */   
/*     */   public Double getCibleanterieur() {
/* 195 */     return this.cibleanterieur;
/*     */   }
/*     */   
/*     */   public void setCibleanterieur(Double cibleanterieur) {
/* 199 */     this.cibleanterieur = cibleanterieur;
/*     */   }
/*     */   
/*     */   public Double getReductionecart() {
/* 203 */     return this.reductionecart;
/*     */   }
/*     */   
/*     */   public void setReductionecart(Double reductionecart) {
/* 207 */     this.reductionecart = reductionecart;
/*     */   }
/*     */   
/*     */   public Double getEcart() {
/* 211 */     return this.ecart;
/*     */   }
/*     */   
/*     */   public void setEcart(Double ecart) {
/* 215 */     this.ecart = ecart;
/*     */   }
/*     */   
/*     */   public Double getValeurrealise() {
/* 219 */     return this.valeurrealise;
/*     */   }
/*     */   
/*     */   public void setValeurrealise(Double valeurrealise) {
/* 223 */     this.valeurrealise = valeurrealise;
/*     */   }
/*     */   
/*     */   public String getObservations() {
/* 227 */     return this.observations;
/*     */   }
/*     */   
/*     */   public void setObservations(String observations) {
/* 231 */     this.observations = observations;
/*     */   }
/*     */   
/*     */   public Double getBaselineanterieur() {
/* 235 */     return this.baselineanterieur;
/*     */   }
/*     */   
/*     */   public void setBaselineanterieur(Double baselineanterieur) {
/* 239 */     this.baselineanterieur = baselineanterieur;
/*     */   }
/*     */   
/*     */   public String getObjectifspecifique() {
/* 243 */     return this.objectifspecifique;
/*     */   }
/*     */   
/*     */   public void setObjectifspecifique(String objectifspecifique) {
/* 247 */     this.objectifspecifique = objectifspecifique;
/*     */   }
/*     */   
/*     */   public String getConditionsreussite() {
/* 251 */     return this.conditionsreussite;
/*     */   }
/*     */   
/*     */   public void setConditionsreussite(String conditionsreussite) {
/* 255 */     this.conditionsreussite = conditionsreussite;
/*     */   }
/*     */   
/*     */   public String getEnonceprojet() {
/* 259 */     return this.enonceprojet;
/*     */   }
/*     */   
/*     */   public void setEnonceprojet(String enonceprojet) {
/* 263 */     this.enonceprojet = enonceprojet;
/*     */   }
/*     */   
/*     */   public String getActioncorrectrices() {
/* 267 */     return this.actioncorrectrices;
/*     */   }
/*     */   
/*     */   public void setActioncorrectrices(String actioncorrectrices) {
/* 271 */     this.actioncorrectrices = actioncorrectrices;
/*     */   }
/*     */   
/*     */   public String getConclusion() {
/* 275 */     return this.conclusion;
/*     */   }
/*     */   
/*     */   public void setConclusion(String conclusion) {
/* 279 */     this.conclusion = conclusion;
/*     */   }
/*     */   
/*     */   public String getRecommandation() {
/* 283 */     return this.recommandation;
/*     */   }
/*     */   
/*     */   public void setRecommandation(String recommandation) {
/* 287 */     this.recommandation = recommandation;
/*     */   }
/*     */   
/*     */   public Indicateurperformance getIndicateurperformance() {
/* 291 */     return this.indicateurperformance;
/*     */   }
/*     */   
/*     */   public void setIndicateurperformance(Indicateurperformance indicateurperformance) {
/* 295 */     this.indicateurperformance = indicateurperformance;
/*     */   }
/*     */   
/*     */   public Structuremissionactivite getStructuremissionactivite() {
/* 299 */     return this.structuremissionactivite;
/*     */   }
/*     */   
/*     */   public void setStructuremissionactivite(Structuremissionactivite structuremissionactivite) {
/* 303 */     this.structuremissionactivite = structuremissionactivite;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 308 */     int hash = 0;
/* 309 */     hash += (this.performancePK != null) ? this.performancePK.hashCode() : 0;
/* 310 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 316 */     if (!(object instanceof Performance)) {
/* 317 */       return false;
/*     */     }
/* 319 */     Performance other = (Performance)object;
/* 320 */     if ((this.performancePK == null && other.performancePK != null) || (this.performancePK != null && !this.performancePK.equals(other.performancePK))) {
/* 321 */       return false;
/*     */     }
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 328 */     return "entities.Performance[ performancePK=" + this.performancePK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Performance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */