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
/*     */ @Table(name = "indicateuractivite")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateuractivite.findAll", query = "SELECT i FROM Indicateuractivite i"), @NamedQuery(name = "Indicateuractivite.findByIdindicateuractivite", query = "SELECT i FROM Indicateuractivite i WHERE i.idindicateuractivite = :idindicateuractivite"), @NamedQuery(name = "Indicateuractivite.findByNom", query = "SELECT i FROM Indicateuractivite i WHERE i.nom = :nom"), @NamedQuery(name = "Indicateuractivite.findByPeriodicitecollecte", query = "SELECT i FROM Indicateuractivite i WHERE i.periodicitecollecte = :periodicitecollecte"), @NamedQuery(name = "Indicateuractivite.findByMoyens", query = "SELECT i FROM Indicateuractivite i WHERE i.moyens = :moyens"), @NamedQuery(name = "Indicateuractivite.findBySourcedonnees", query = "SELECT i FROM Indicateuractivite i WHERE i.sourcedonnees = :sourcedonnees"), @NamedQuery(name = "Indicateuractivite.findByDifficultes", query = "SELECT i FROM Indicateuractivite i WHERE i.difficultes = :difficultes"), @NamedQuery(name = "Indicateuractivite.findByPap", query = "SELECT i FROM Indicateuractivite i WHERE i.pap = :pap"), @NamedQuery(name = "Indicateuractivite.findByCoefmulti", query = "SELECT i FROM Indicateuractivite i WHERE i.coefmulti = :coefmulti"), @NamedQuery(name = "Indicateuractivite.findByModecalcul", query = "SELECT i FROM Indicateuractivite i WHERE i.modecalcul = :modecalcul"), @NamedQuery(name = "Indicateuractivite.findByDenominateur", query = "SELECT i FROM Indicateuractivite i WHERE i.denominateur = :denominateur"), @NamedQuery(name = "Indicateuractivite.findByNumerateur", query = "SELECT i FROM Indicateuractivite i WHERE i.numerateur = :numerateur"), @NamedQuery(name = "Indicateuractivite.findByObjectif", query = "SELECT i FROM Indicateuractivite i WHERE i.objectif = :objectif"), @NamedQuery(name = "Indicateuractivite.findBySourceverification", query = "SELECT i FROM Indicateuractivite i WHERE i.sourceverification = :sourceverification"), @NamedQuery(name = "Indicateuractivite.findByReference", query = "SELECT i FROM Indicateuractivite i WHERE i.reference = :reference"), @NamedQuery(name = "Indicateuractivite.findByUnite", query = "SELECT i FROM Indicateuractivite i WHERE i.unite = :unite"), @NamedQuery(name = "Indicateuractivite.findByPourcentage", query = "SELECT i FROM Indicateuractivite i WHERE i.pourcentage = :pourcentage"), @NamedQuery(name = "Indicateuractivite.findByAnnebaseline", query = "SELECT i FROM Indicateuractivite i WHERE i.annebaseline = :annebaseline"), @NamedQuery(name = "Indicateuractivite.findByAnnecible", query = "SELECT i FROM Indicateuractivite i WHERE i.annecible = :annecible"), @NamedQuery(name = "Indicateuractivite.findByCible", query = "SELECT i FROM Indicateuractivite i WHERE i.cible = :cible"), @NamedQuery(name = "Indicateuractivite.findByBaseline", query = "SELECT i FROM Indicateuractivite i WHERE i.baseline = :baseline"), @NamedQuery(name = "Indicateuractivite.findByValeurrealise", query = "SELECT i FROM Indicateuractivite i WHERE i.valeurrealise = :valeurrealise"), @NamedQuery(name = "Indicateuractivite.findByObservation", query = "SELECT i FROM Indicateuractivite i WHERE i.observation = :observation"), @NamedQuery(name = "Indicateuractivite.findByActif", query = "SELECT i FROM Indicateuractivite i WHERE i.actif = :actif"), @NamedQuery(name = "Indicateuractivite.findByPeriodicitemesure", query = "SELECT i FROM Indicateuractivite i WHERE i.periodicitemesure = :periodicitemesure"), @NamedQuery(name = "Indicateuractivite.findByCoutcollecte", query = "SELECT i FROM Indicateuractivite i WHERE i.coutcollecte = :coutcollecte"), @NamedQuery(name = "Indicateuractivite.findByCommentaire", query = "SELECT i FROM Indicateuractivite i WHERE i.commentaire = :commentaire"), @NamedQuery(name = "Indicateuractivite.findByInterpretation", query = "SELECT i FROM Indicateuractivite i WHERE i.interpretation = :interpretation"), @NamedQuery(name = "Indicateuractivite.findByLimite", query = "SELECT i FROM Indicateuractivite i WHERE i.limite = :limite"), @NamedQuery(name = "Indicateuractivite.findByAnalyses", query = "SELECT i FROM Indicateuractivite i WHERE i.analyses = :analyses"), @NamedQuery(name = "Indicateuractivite.findByServiceanalyse", query = "SELECT i FROM Indicateuractivite i WHERE i.serviceanalyse = :serviceanalyse"), @NamedQuery(name = "Indicateuractivite.findByServicesynthese", query = "SELECT i FROM Indicateuractivite i WHERE i.servicesynthese = :servicesynthese"), @NamedQuery(name = "Indicateuractivite.findByServicevalidation", query = "SELECT i FROM Indicateuractivite i WHERE i.servicevalidation = :servicevalidation"), @NamedQuery(name = "Indicateuractivite.findByServicerespo", query = "SELECT i FROM Indicateuractivite i WHERE i.servicerespo = :servicerespo"), @NamedQuery(name = "Indicateuractivite.findByModecollecte", query = "SELECT i FROM Indicateuractivite i WHERE i.modecollecte = :modecollecte"), @NamedQuery(name = "Indicateuractivite.findByExplication", query = "SELECT i FROM Indicateuractivite i WHERE i.explication = :explication"), @NamedQuery(name = "Indicateuractivite.findByEtat", query = "SELECT i FROM Indicateuractivite i WHERE i.etat = :etat"), @NamedQuery(name = "Indicateuractivite.findByDateEnregistre", query = "SELECT i FROM Indicateuractivite i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Indicateuractivite.findByDerniereModif", query = "SELECT i FROM Indicateuractivite i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Indicateuractivite
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateuractivite")
/*     */   private Long idindicateuractivite;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "periodicitecollecte")
/*     */   private String periodicitecollecte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "moyens")
/*     */   private String moyens;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "sourcedonnees")
/*     */   private String sourcedonnees;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "difficultes")
/*     */   private String difficultes;
/*     */   @Column(name = "pap")
/*     */   private Boolean pap;
/*     */   @Column(name = "coefmulti")
/*     */   private Double coefmulti;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "modecalcul")
/*     */   private String modecalcul;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "denominateur")
/*     */   private String denominateur;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "numerateur")
/*     */   private String numerateur;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "objectif")
/*     */   private String objectif;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "sourceverification")
/*     */   private String sourceverification;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "reference")
/*     */   private String reference;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "unite")
/*     */   private String unite;
/*     */   @Column(name = "pourcentage")
/*     */   private Double pourcentage;
/*     */   @Column(name = "annebaseline")
/*     */   private Integer annebaseline;
/*     */   @Column(name = "annecible")
/*     */   private Integer annecible;
/*     */   @Column(name = "cible")
/*     */   private Double cible;
/*     */   @Column(name = "baseline")
/*     */   private Double baseline;
/*     */   @Column(name = "valeurrealise")
/*     */   private Double valeurrealise;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "observation")
/*     */   private String observation;
/*     */   @Column(name = "actif")
/*     */   private Boolean actif;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "periodicitemesure")
/*     */   private String periodicitemesure;
/*     */   @Column(name = "coutcollecte")
/*     */   private Double coutcollecte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "commentaire")
/*     */   private String commentaire;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "interpretation")
/*     */   private String interpretation;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "limite")
/*     */   private String limite;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "analyses")
/*     */   private String analyses;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "serviceanalyse")
/*     */   private String serviceanalyse;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "servicesynthese")
/*     */   private String servicesynthese;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "servicevalidation")
/*     */   private String servicevalidation;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "servicerespo")
/*     */   private String servicerespo;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "modecollecte")
/*     */   private String modecollecte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "explication")
/*     */   private String explication;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idindicateuractivite", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractiviteannee> indicateuractiviteanneeList;
/*     */   @JoinColumn(name = "idactivite", referencedColumnName = "idactivite")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Activite idactivite;
/*     */   @JoinColumn(name = "idtypedonnees", referencedColumnName = "idtypedonnees")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typedonnees idtypedonnees;
/*     */   @Size(max = 4044)
/*     */   @Column(name = "hypothese_risque")
/*     */   private String hypotheseRisque;
/*     */   
/*     */   public Indicateuractivite() {}
/*     */   
/*     */   public Indicateuractivite(Long idindicateuractivite) {
/* 203 */     this.idindicateuractivite = idindicateuractivite;
/*     */   }
/*     */   
/*     */   public Long getIdindicateuractivite() {
/* 207 */     return this.idindicateuractivite;
/*     */   }
/*     */   
/*     */   public void setIdindicateuractivite(Long idindicateuractivite) {
/* 211 */     this.idindicateuractivite = idindicateuractivite;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 215 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 219 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getPeriodicitecollecte() {
/* 223 */     return this.periodicitecollecte;
/*     */   }
/*     */   
/*     */   public void setPeriodicitecollecte(String periodicitecollecte) {
/* 227 */     this.periodicitecollecte = periodicitecollecte;
/*     */   }
/*     */   
/*     */   public String getMoyens() {
/* 231 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(String moyens) {
/* 235 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public String getSourcedonnees() {
/* 239 */     return this.sourcedonnees;
/*     */   }
/*     */   
/*     */   public void setSourcedonnees(String sourcedonnees) {
/* 243 */     this.sourcedonnees = sourcedonnees;
/*     */   }
/*     */   
/*     */   public String getDifficultes() {
/* 247 */     return this.difficultes;
/*     */   }
/*     */   
/*     */   public void setDifficultes(String difficultes) {
/* 251 */     this.difficultes = difficultes;
/*     */   }
/*     */   
/*     */   public Boolean getPap() {
/* 255 */     return this.pap;
/*     */   }
/*     */   
/*     */   public void setPap(Boolean pap) {
/* 259 */     this.pap = pap;
/*     */   }
/*     */   
/*     */   public Double getCoefmulti() {
/* 263 */     return this.coefmulti;
/*     */   }
/*     */   
/*     */   public void setCoefmulti(Double coefmulti) {
/* 267 */     this.coefmulti = coefmulti;
/*     */   }
/*     */   
/*     */   public String getModecalcul() {
/* 271 */     return this.modecalcul;
/*     */   }
/*     */   
/*     */   public void setModecalcul(String modecalcul) {
/* 275 */     this.modecalcul = modecalcul;
/*     */   }
/*     */   
/*     */   public String getDenominateur() {
/* 279 */     return this.denominateur;
/*     */   }
/*     */   
/*     */   public void setDenominateur(String denominateur) {
/* 283 */     this.denominateur = denominateur;
/*     */   }
/*     */   
/*     */   public String getNumerateur() {
/* 287 */     return this.numerateur;
/*     */   }
/*     */   
/*     */   public void setNumerateur(String numerateur) {
/* 291 */     this.numerateur = numerateur;
/*     */   }
/*     */   
/*     */   public String getObjectif() {
/* 295 */     return this.objectif;
/*     */   }
/*     */   
/*     */   public void setObjectif(String objectif) {
/* 299 */     this.objectif = objectif;
/*     */   }
/*     */   
/*     */   public String getSourceverification() {
/* 303 */     return this.sourceverification;
/*     */   }
/*     */   
/*     */   public void setSourceverification(String sourceverification) {
/* 307 */     this.sourceverification = sourceverification;
/*     */   }
/*     */   
/*     */   public String getReference() {
/* 311 */     return this.reference;
/*     */   }
/*     */   
/*     */   public void setReference(String reference) {
/* 315 */     this.reference = reference;
/*     */   }
/*     */   
/*     */   public String getUnite() {
/* 319 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(String unite) {
/* 323 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public Double getPourcentage() {
/* 327 */     return this.pourcentage;
/*     */   }
/*     */   
/*     */   public void setPourcentage(Double pourcentage) {
/* 331 */     this.pourcentage = pourcentage;
/*     */   }
/*     */   
/*     */   public Integer getAnnebaseline() {
/* 335 */     return this.annebaseline;
/*     */   }
/*     */   
/*     */   public void setAnnebaseline(Integer annebaseline) {
/* 339 */     this.annebaseline = annebaseline;
/*     */   }
/*     */   
/*     */   public Integer getAnnecible() {
/* 343 */     return this.annecible;
/*     */   }
/*     */   
/*     */   public void setAnnecible(Integer annecible) {
/* 347 */     this.annecible = annecible;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/* 351 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/* 355 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public Double getBaseline() {
/* 359 */     return this.baseline;
/*     */   }
/*     */   
/*     */   public void setBaseline(Double baseline) {
/* 363 */     this.baseline = baseline;
/*     */   }
/*     */   
/*     */   public Double getValeurrealise() {
/* 367 */     return this.valeurrealise;
/*     */   }
/*     */   
/*     */   public void setValeurrealise(Double valeurrealise) {
/* 371 */     this.valeurrealise = valeurrealise;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 375 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 379 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public Boolean getActif() {
/* 383 */     return this.actif;
/*     */   }
/*     */   
/*     */   public void setActif(Boolean actif) {
/* 387 */     this.actif = actif;
/*     */   }
/*     */   
/*     */   public String getPeriodicitemesure() {
/* 391 */     return this.periodicitemesure;
/*     */   }
/*     */   
/*     */   public void setPeriodicitemesure(String periodicitemesure) {
/* 395 */     this.periodicitemesure = periodicitemesure;
/*     */   }
/*     */   
/*     */   public Double getCoutcollecte() {
/* 399 */     return this.coutcollecte;
/*     */   }
/*     */   
/*     */   public void setCoutcollecte(Double coutcollecte) {
/* 403 */     this.coutcollecte = coutcollecte;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 407 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 411 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public String getInterpretation() {
/* 415 */     return this.interpretation;
/*     */   }
/*     */   
/*     */   public void setInterpretation(String interpretation) {
/* 419 */     this.interpretation = interpretation;
/*     */   }
/*     */   
/*     */   public String getLimite() {
/* 423 */     return this.limite;
/*     */   }
/*     */   
/*     */   public void setLimite(String limite) {
/* 427 */     this.limite = limite;
/*     */   }
/*     */   
/*     */   public String getAnalyses() {
/* 431 */     return this.analyses;
/*     */   }
/*     */   
/*     */   public void setAnalyses(String analyses) {
/* 435 */     this.analyses = analyses;
/*     */   }
/*     */   
/*     */   public String getServiceanalyse() {
/* 439 */     return this.serviceanalyse;
/*     */   }
/*     */   
/*     */   public void setServiceanalyse(String serviceanalyse) {
/* 443 */     this.serviceanalyse = serviceanalyse;
/*     */   }
/*     */   
/*     */   public String getServicesynthese() {
/* 447 */     return this.servicesynthese;
/*     */   }
/*     */   
/*     */   public void setServicesynthese(String servicesynthese) {
/* 451 */     this.servicesynthese = servicesynthese;
/*     */   }
/*     */   
/*     */   public String getServicevalidation() {
/* 455 */     return this.servicevalidation;
/*     */   }
/*     */   
/*     */   public void setServicevalidation(String servicevalidation) {
/* 459 */     this.servicevalidation = servicevalidation;
/*     */   }
/*     */   
/*     */   public String getServicerespo() {
/* 463 */     return this.servicerespo;
/*     */   }
/*     */   
/*     */   public void setServicerespo(String servicerespo) {
/* 467 */     this.servicerespo = servicerespo;
/*     */   }
/*     */   
/*     */   public String getModecollecte() {
/* 471 */     return this.modecollecte;
/*     */   }
/*     */   
/*     */   public void setModecollecte(String modecollecte) {
/* 475 */     this.modecollecte = modecollecte;
/*     */   }
/*     */   
/*     */   public String getExplication() {
/* 479 */     return this.explication;
/*     */   }
/*     */   
/*     */   public void setExplication(String explication) {
/* 483 */     this.explication = explication;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 487 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 491 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 495 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 499 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 503 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 507 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractiviteannee> getIndicateuractiviteanneeList() {
/* 512 */     return this.indicateuractiviteanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractiviteanneeList(List<Indicateuractiviteannee> indicateuractiviteanneeList) {
/* 516 */     this.indicateuractiviteanneeList = indicateuractiviteanneeList;
/*     */   }
/*     */   
/*     */   public Activite getIdactivite() {
/* 520 */     return this.idactivite;
/*     */   }
/*     */   
/*     */   public void setIdactivite(Activite idactivite) {
/* 524 */     this.idactivite = idactivite;
/*     */   }
/*     */   
/*     */   public Typedonnees getIdtypedonnees() {
/* 528 */     return this.idtypedonnees;
/*     */   }
/*     */   
/*     */   public void setIdtypedonnees(Typedonnees idtypedonnees) {
/* 532 */     this.idtypedonnees = idtypedonnees;
/*     */   }
/*     */   
/*     */   public String getHypotheseRisque() {
/* 536 */     return this.hypotheseRisque;
/*     */   }
/*     */   
/*     */   public void setHypotheseRisque(String hypotheseRisque) {
/* 540 */     this.hypotheseRisque = hypotheseRisque;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 545 */     int hash = 0;
/* 546 */     hash += (this.idindicateuractivite != null) ? this.idindicateuractivite.hashCode() : 0;
/* 547 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 553 */     if (!(object instanceof Indicateuractivite)) {
/* 554 */       return false;
/*     */     }
/* 556 */     Indicateuractivite other = (Indicateuractivite)object;
/* 557 */     if ((this.idindicateuractivite == null && other.idindicateuractivite != null) || (this.idindicateuractivite != null && !this.idindicateuractivite.equals(other.idindicateuractivite))) {
/* 558 */       return false;
/*     */     }
/* 560 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 565 */     return "entities.Indicateuractivite[ idindicateuractivite=" + this.idindicateuractivite + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateuractivite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */