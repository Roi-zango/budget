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
/*     */ @Entity
/*     */ @Table(name = "indicateuraction")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateuraction.findAll", query = "SELECT i FROM Indicateuraction i"), @NamedQuery(name = "Indicateuraction.findByIdindicateuraction", query = "SELECT i FROM Indicateuraction i WHERE i.idindicateuraction = :idindicateuraction"), @NamedQuery(name = "Indicateuraction.findByNom", query = "SELECT i FROM Indicateuraction i WHERE i.nom = :nom"), @NamedQuery(name = "Indicateuraction.findByPeriodicitecollecte", query = "SELECT i FROM Indicateuraction i WHERE i.periodicitecollecte = :periodicitecollecte"), @NamedQuery(name = "Indicateuraction.findByMoyens", query = "SELECT i FROM Indicateuraction i WHERE i.moyens = :moyens"), @NamedQuery(name = "Indicateuraction.findBySourcedonnees", query = "SELECT i FROM Indicateuraction i WHERE i.sourcedonnees = :sourcedonnees"), @NamedQuery(name = "Indicateuraction.findByModecalcul", query = "SELECT i FROM Indicateuraction i WHERE i.modecalcul = :modecalcul"), @NamedQuery(name = "Indicateuraction.findByDenominateur", query = "SELECT i FROM Indicateuraction i WHERE i.denominateur = :denominateur"), @NamedQuery(name = "Indicateuraction.findByNumerateur", query = "SELECT i FROM Indicateuraction i WHERE i.numerateur = :numerateur"), @NamedQuery(name = "Indicateuraction.findByDifficultes", query = "SELECT i FROM Indicateuraction i WHERE i.difficultes = :difficultes"), @NamedQuery(name = "Indicateuraction.findByPap", query = "SELECT i FROM Indicateuraction i WHERE i.pap = :pap"), @NamedQuery(name = "Indicateuraction.findByCoefmulti", query = "SELECT i FROM Indicateuraction i WHERE i.coefmulti = :coefmulti"), @NamedQuery(name = "Indicateuraction.findByObjectif", query = "SELECT i FROM Indicateuraction i WHERE i.objectif = :objectif"), @NamedQuery(name = "Indicateuraction.findBySourceverification", query = "SELECT i FROM Indicateuraction i WHERE i.sourceverification = :sourceverification"), @NamedQuery(name = "Indicateuraction.findByReference", query = "SELECT i FROM Indicateuraction i WHERE i.reference = :reference"), @NamedQuery(name = "Indicateuraction.findByUnite", query = "SELECT i FROM Indicateuraction i WHERE i.unite = :unite"), @NamedQuery(name = "Indicateuraction.findByPourcentage", query = "SELECT i FROM Indicateuraction i WHERE i.pourcentage = :pourcentage"), @NamedQuery(name = "Indicateuraction.findByAnnebaseline", query = "SELECT i FROM Indicateuraction i WHERE i.annebaseline = :annebaseline"), @NamedQuery(name = "Indicateuraction.findByAnnecible", query = "SELECT i FROM Indicateuraction i WHERE i.annecible = :annecible"), @NamedQuery(name = "Indicateuraction.findByCible", query = "SELECT i FROM Indicateuraction i WHERE i.cible = :cible"), @NamedQuery(name = "Indicateuraction.findByBaseline", query = "SELECT i FROM Indicateuraction i WHERE i.baseline = :baseline"), @NamedQuery(name = "Indicateuraction.findByValeurrealise", query = "SELECT i FROM Indicateuraction i WHERE i.valeurrealise = :valeurrealise"), @NamedQuery(name = "Indicateuraction.findByObservation", query = "SELECT i FROM Indicateuraction i WHERE i.observation = :observation"), @NamedQuery(name = "Indicateuraction.findByActif", query = "SELECT i FROM Indicateuraction i WHERE i.actif = :actif"), @NamedQuery(name = "Indicateuraction.findByPeriodicitemesure", query = "SELECT i FROM Indicateuraction i WHERE i.periodicitemesure = :periodicitemesure"), @NamedQuery(name = "Indicateuraction.findByCoutcollecte", query = "SELECT i FROM Indicateuraction i WHERE i.coutcollecte = :coutcollecte"), @NamedQuery(name = "Indicateuraction.findByCommentaire", query = "SELECT i FROM Indicateuraction i WHERE i.commentaire = :commentaire"), @NamedQuery(name = "Indicateuraction.findByInterpretation", query = "SELECT i FROM Indicateuraction i WHERE i.interpretation = :interpretation"), @NamedQuery(name = "Indicateuraction.findByLimite", query = "SELECT i FROM Indicateuraction i WHERE i.limite = :limite"), @NamedQuery(name = "Indicateuraction.findByAnalyses", query = "SELECT i FROM Indicateuraction i WHERE i.analyses = :analyses"), @NamedQuery(name = "Indicateuraction.findByServiceanalyse", query = "SELECT i FROM Indicateuraction i WHERE i.serviceanalyse = :serviceanalyse"), @NamedQuery(name = "Indicateuraction.findByServicesynthese", query = "SELECT i FROM Indicateuraction i WHERE i.servicesynthese = :servicesynthese"), @NamedQuery(name = "Indicateuraction.findByServicevalidation", query = "SELECT i FROM Indicateuraction i WHERE i.servicevalidation = :servicevalidation"), @NamedQuery(name = "Indicateuraction.findByServicerespo", query = "SELECT i FROM Indicateuraction i WHERE i.servicerespo = :servicerespo"), @NamedQuery(name = "Indicateuraction.findByModecollecte", query = "SELECT i FROM Indicateuraction i WHERE i.modecollecte = :modecollecte"), @NamedQuery(name = "Indicateuraction.findByExplication", query = "SELECT i FROM Indicateuraction i WHERE i.explication = :explication"), @NamedQuery(name = "Indicateuraction.findByEtat", query = "SELECT i FROM Indicateuraction i WHERE i.etat = :etat"), @NamedQuery(name = "Indicateuraction.findByDateEnregistre", query = "SELECT i FROM Indicateuraction i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Indicateuraction.findByDerniereModif", query = "SELECT i FROM Indicateuraction i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Indicateuraction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateuraction")
/*     */   private Long idindicateuraction;
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
/*     */   @Column(name = "modecalcul")
/*     */   private String modecalcul;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "denominateur")
/*     */   private String denominateur;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "numerateur")
/*     */   private String numerateur;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "difficultes")
/*     */   private String difficultes;
/*     */   @Column(name = "pap")
/*     */   private Boolean pap;
/*     */   @Column(name = "coefmulti")
/*     */   private Double coefmulti;
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
/*     */   @OneToMany(mappedBy = "idindicateuraction", fetch = FetchType.LAZY)
/*     */   private List<Activite> activiteList;
/*     */   @JoinColumn(name = "idaction", referencedColumnName = "idaction")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Action idaction;
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @JoinColumn(name = "idtypedonnees", referencedColumnName = "idtypedonnees")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typedonnees idtypedonnees;
/*     */   @OneToMany(mappedBy = "idindicateuraction", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractionannee> indicateuractionanneeList;
/*     */   
/*     */   public Indicateuraction() {}
/*     */   
/*     */   public Indicateuraction(Long idindicateuraction) {
/* 203 */     this.idindicateuraction = idindicateuraction;
/*     */   }
/*     */   
/*     */   public Long getIdindicateuraction() {
/* 207 */     return this.idindicateuraction;
/*     */   }
/*     */   
/*     */   public void setIdindicateuraction(Long idindicateuraction) {
/* 211 */     this.idindicateuraction = idindicateuraction;
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
/*     */   public String getModecalcul() {
/* 247 */     return this.modecalcul;
/*     */   }
/*     */   
/*     */   public void setModecalcul(String modecalcul) {
/* 251 */     this.modecalcul = modecalcul;
/*     */   }
/*     */   
/*     */   public String getDenominateur() {
/* 255 */     return this.denominateur;
/*     */   }
/*     */   
/*     */   public void setDenominateur(String denominateur) {
/* 259 */     this.denominateur = denominateur;
/*     */   }
/*     */   
/*     */   public String getNumerateur() {
/* 263 */     return this.numerateur;
/*     */   }
/*     */   
/*     */   public void setNumerateur(String numerateur) {
/* 267 */     this.numerateur = numerateur;
/*     */   }
/*     */   
/*     */   public String getDifficultes() {
/* 271 */     return this.difficultes;
/*     */   }
/*     */   
/*     */   public void setDifficultes(String difficultes) {
/* 275 */     this.difficultes = difficultes;
/*     */   }
/*     */   
/*     */   public Boolean getPap() {
/* 279 */     return this.pap;
/*     */   }
/*     */   
/*     */   public void setPap(Boolean pap) {
/* 283 */     this.pap = pap;
/*     */   }
/*     */   
/*     */   public Double getCoefmulti() {
/* 287 */     return this.coefmulti;
/*     */   }
/*     */   
/*     */   public void setCoefmulti(Double coefmulti) {
/* 291 */     this.coefmulti = coefmulti;
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
/*     */   public List<Activite> getActiviteList() {
/* 512 */     return this.activiteList;
/*     */   }
/*     */   
/*     */   public void setActiviteList(List<Activite> activiteList) {
/* 516 */     this.activiteList = activiteList;
/*     */   }
/*     */   
/*     */   public Action getIdaction() {
/* 520 */     return this.idaction;
/*     */   }
/*     */   
/*     */   public void setIdaction(Action idaction) {
/* 524 */     this.idaction = idaction;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 528 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 532 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Typedonnees getIdtypedonnees() {
/* 536 */     return this.idtypedonnees;
/*     */   }
/*     */   
/*     */   public void setIdtypedonnees(Typedonnees idtypedonnees) {
/* 540 */     this.idtypedonnees = idtypedonnees;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractionannee> getIndicateuractionanneeList() {
/* 545 */     return this.indicateuractionanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractionanneeList(List<Indicateuractionannee> indicateuractionanneeList) {
/* 549 */     this.indicateuractionanneeList = indicateuractionanneeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 554 */     int hash = 0;
/* 555 */     hash += (this.idindicateuraction != null) ? this.idindicateuraction.hashCode() : 0;
/* 556 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 562 */     if (!(object instanceof Indicateuraction)) {
/* 563 */       return false;
/*     */     }
/* 565 */     Indicateuraction other = (Indicateuraction)object;
/* 566 */     if ((this.idindicateuraction == null && other.idindicateuraction != null) || (this.idindicateuraction != null && !this.idindicateuraction.equals(other.idindicateuraction))) {
/* 567 */       return false;
/*     */     }
/* 569 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 574 */     return "entities.Indicateuraction[ idindicateuraction=" + this.idindicateuraction + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateuraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */