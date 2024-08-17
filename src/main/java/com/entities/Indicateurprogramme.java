/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigInteger;
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
/*     */ @Entity
/*     */ @Table(name = "indicateurprogramme")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateurprogramme.findAll", query = "SELECT i FROM Indicateurprogramme i"), @NamedQuery(name = "Indicateurprogramme.findByIdindicateurprogramme", query = "SELECT i FROM Indicateurprogramme i WHERE i.idindicateurprogramme = :idindicateurprogramme"), @NamedQuery(name = "Indicateurprogramme.findByIdprogramme", query = "SELECT i FROM Indicateurprogramme i WHERE i.idprogramme = :idprogramme"), @NamedQuery(name = "Indicateurprogramme.findByNom", query = "SELECT i FROM Indicateurprogramme i WHERE i.nom = :nom"), @NamedQuery(name = "Indicateurprogramme.findByObjectif", query = "SELECT i FROM Indicateurprogramme i WHERE i.objectif = :objectif"), @NamedQuery(name = "Indicateurprogramme.findByPeriodicitecollecte", query = "SELECT i FROM Indicateurprogramme i WHERE i.periodicitecollecte = :periodicitecollecte"), @NamedQuery(name = "Indicateurprogramme.findByMoyens", query = "SELECT i FROM Indicateurprogramme i WHERE i.moyens = :moyens"), @NamedQuery(name = "Indicateurprogramme.findByDifficultes", query = "SELECT i FROM Indicateurprogramme i WHERE i.difficultes = :difficultes"), @NamedQuery(name = "Indicateurprogramme.findByPap", query = "SELECT i FROM Indicateurprogramme i WHERE i.pap = :pap"), @NamedQuery(name = "Indicateurprogramme.findByCoefmulti", query = "SELECT i FROM Indicateurprogramme i WHERE i.coefmulti = :coefmulti"), @NamedQuery(name = "Indicateurprogramme.findBySourcedonnees", query = "SELECT i FROM Indicateurprogramme i WHERE i.sourcedonnees = :sourcedonnees"), @NamedQuery(name = "Indicateurprogramme.findByModecalcul", query = "SELECT i FROM Indicateurprogramme i WHERE i.modecalcul = :modecalcul"), @NamedQuery(name = "Indicateurprogramme.findByDenominateur", query = "SELECT i FROM Indicateurprogramme i WHERE i.denominateur = :denominateur"), @NamedQuery(name = "Indicateurprogramme.findByNumerateur", query = "SELECT i FROM Indicateurprogramme i WHERE i.numerateur = :numerateur"), @NamedQuery(name = "Indicateurprogramme.findBySourceverification", query = "SELECT i FROM Indicateurprogramme i WHERE i.sourceverification = :sourceverification"), @NamedQuery(name = "Indicateurprogramme.findByReference", query = "SELECT i FROM Indicateurprogramme i WHERE i.reference = :reference"), @NamedQuery(name = "Indicateurprogramme.findByAnnebaseline", query = "SELECT i FROM Indicateurprogramme i WHERE i.annebaseline = :annebaseline"), @NamedQuery(name = "Indicateurprogramme.findByAnnecible", query = "SELECT i FROM Indicateurprogramme i WHERE i.annecible = :annecible"), @NamedQuery(name = "Indicateurprogramme.findByUnite", query = "SELECT i FROM Indicateurprogramme i WHERE i.unite = :unite"), @NamedQuery(name = "Indicateurprogramme.findByPourcentage", query = "SELECT i FROM Indicateurprogramme i WHERE i.pourcentage = :pourcentage"), @NamedQuery(name = "Indicateurprogramme.findByCible", query = "SELECT i FROM Indicateurprogramme i WHERE i.cible = :cible"), @NamedQuery(name = "Indicateurprogramme.findByBaseline", query = "SELECT i FROM Indicateurprogramme i WHERE i.baseline = :baseline"), @NamedQuery(name = "Indicateurprogramme.findByValeurrealise", query = "SELECT i FROM Indicateurprogramme i WHERE i.valeurrealise = :valeurrealise"), @NamedQuery(name = "Indicateurprogramme.findByObservation", query = "SELECT i FROM Indicateurprogramme i WHERE i.observation = :observation"), @NamedQuery(name = "Indicateurprogramme.findByActif", query = "SELECT i FROM Indicateurprogramme i WHERE i.actif = :actif"), @NamedQuery(name = "Indicateurprogramme.findByPeriodicitemesure", query = "SELECT i FROM Indicateurprogramme i WHERE i.periodicitemesure = :periodicitemesure"), @NamedQuery(name = "Indicateurprogramme.findByCoutcollecte", query = "SELECT i FROM Indicateurprogramme i WHERE i.coutcollecte = :coutcollecte"), @NamedQuery(name = "Indicateurprogramme.findByCommentaire", query = "SELECT i FROM Indicateurprogramme i WHERE i.commentaire = :commentaire"), @NamedQuery(name = "Indicateurprogramme.findByInterpretation", query = "SELECT i FROM Indicateurprogramme i WHERE i.interpretation = :interpretation"), @NamedQuery(name = "Indicateurprogramme.findByLimite", query = "SELECT i FROM Indicateurprogramme i WHERE i.limite = :limite"), @NamedQuery(name = "Indicateurprogramme.findByAnalyses", query = "SELECT i FROM Indicateurprogramme i WHERE i.analyses = :analyses"), @NamedQuery(name = "Indicateurprogramme.findByServiceanalyse", query = "SELECT i FROM Indicateurprogramme i WHERE i.serviceanalyse = :serviceanalyse"), @NamedQuery(name = "Indicateurprogramme.findByServicesynthese", query = "SELECT i FROM Indicateurprogramme i WHERE i.servicesynthese = :servicesynthese"), @NamedQuery(name = "Indicateurprogramme.findByServicevalidation", query = "SELECT i FROM Indicateurprogramme i WHERE i.servicevalidation = :servicevalidation"), @NamedQuery(name = "Indicateurprogramme.findByServicerespo", query = "SELECT i FROM Indicateurprogramme i WHERE i.servicerespo = :servicerespo"), @NamedQuery(name = "Indicateurprogramme.findByModecollecte", query = "SELECT i FROM Indicateurprogramme i WHERE i.modecollecte = :modecollecte"), @NamedQuery(name = "Indicateurprogramme.findByExplication", query = "SELECT i FROM Indicateurprogramme i WHERE i.explication = :explication"), @NamedQuery(name = "Indicateurprogramme.findByEtat", query = "SELECT i FROM Indicateurprogramme i WHERE i.etat = :etat"), @NamedQuery(name = "Indicateurprogramme.findByDateEnregistre", query = "SELECT i FROM Indicateurprogramme i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Indicateurprogramme.findByDerniereModif", query = "SELECT i FROM Indicateurprogramme i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Indicateurprogramme
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateurprogramme")
/*     */   private Long idindicateurprogramme;
/*     */   @Column(name = "idprogramme")
/*     */   private BigInteger idprogramme;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "objectif")
/*     */   private String objectif;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "periodicitecollecte")
/*     */   private String periodicitecollecte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "moyens")
/*     */   private String moyens;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "difficultes")
/*     */   private String difficultes;
/*     */   @Column(name = "pap")
/*     */   private Boolean pap;
/*     */   @Column(name = "coefmulti")
/*     */   private Double coefmulti;
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
/*     */   @Column(name = "sourceverification")
/*     */   private String sourceverification;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "reference")
/*     */   private String reference;
/*     */   @Column(name = "annebaseline")
/*     */   private Integer annebaseline;
/*     */   @Column(name = "annecible")
/*     */   private Integer annecible;
/*     */   @Size(max = 254)
/*     */   @Column(name = "unite")
/*     */   private String unite;
/*     */   @Column(name = "pourcentage")
/*     */   private Double pourcentage;
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
/*     */   @OneToMany(mappedBy = "idindicateurprogramme", fetch = FetchType.LAZY)
/*     */   private List<Action> actionList;
/*     */   @OneToMany(mappedBy = "idindicateurprogramme", fetch = FetchType.LAZY)
/*     */   private List<Indicateurprogrammeannee> indicateurprogrammeanneeList;
/*     */   @JoinColumn(name = "idtypedonnees", referencedColumnName = "idtypedonnees")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typedonnees idtypedonnees;
/*     */   
/*     */   public Indicateurprogramme() {}
/*     */   
/*     */   public Indicateurprogramme(Long idindicateurprogramme) {
/* 201 */     this.idindicateurprogramme = idindicateurprogramme;
/*     */   }
/*     */   
/*     */   public Long getIdindicateurprogramme() {
/* 205 */     return this.idindicateurprogramme;
/*     */   }
/*     */   
/*     */   public void setIdindicateurprogramme(Long idindicateurprogramme) {
/* 209 */     this.idindicateurprogramme = idindicateurprogramme;
/*     */   }
/*     */   
/*     */   public BigInteger getIdprogramme() {
/* 213 */     return this.idprogramme;
/*     */   }
/*     */   
/*     */   public void setIdprogramme(BigInteger idprogramme) {
/* 217 */     this.idprogramme = idprogramme;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 221 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 225 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getObjectif() {
/* 229 */     return this.objectif;
/*     */   }
/*     */   
/*     */   public void setObjectif(String objectif) {
/* 233 */     this.objectif = objectif;
/*     */   }
/*     */   
/*     */   public String getPeriodicitecollecte() {
/* 237 */     return this.periodicitecollecte;
/*     */   }
/*     */   
/*     */   public void setPeriodicitecollecte(String periodicitecollecte) {
/* 241 */     this.periodicitecollecte = periodicitecollecte;
/*     */   }
/*     */   
/*     */   public String getMoyens() {
/* 245 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(String moyens) {
/* 249 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public String getDifficultes() {
/* 253 */     return this.difficultes;
/*     */   }
/*     */   
/*     */   public void setDifficultes(String difficultes) {
/* 257 */     this.difficultes = difficultes;
/*     */   }
/*     */   
/*     */   public Boolean getPap() {
/* 261 */     return this.pap;
/*     */   }
/*     */   
/*     */   public void setPap(Boolean pap) {
/* 265 */     this.pap = pap;
/*     */   }
/*     */   
/*     */   public Double getCoefmulti() {
/* 269 */     return this.coefmulti;
/*     */   }
/*     */   
/*     */   public void setCoefmulti(Double coefmulti) {
/* 273 */     this.coefmulti = coefmulti;
/*     */   }
/*     */   
/*     */   public String getSourcedonnees() {
/* 277 */     return this.sourcedonnees;
/*     */   }
/*     */   
/*     */   public void setSourcedonnees(String sourcedonnees) {
/* 281 */     this.sourcedonnees = sourcedonnees;
/*     */   }
/*     */   
/*     */   public String getModecalcul() {
/* 285 */     return this.modecalcul;
/*     */   }
/*     */   
/*     */   public void setModecalcul(String modecalcul) {
/* 289 */     this.modecalcul = modecalcul;
/*     */   }
/*     */   
/*     */   public String getDenominateur() {
/* 293 */     return this.denominateur;
/*     */   }
/*     */   
/*     */   public void setDenominateur(String denominateur) {
/* 297 */     this.denominateur = denominateur;
/*     */   }
/*     */   
/*     */   public String getNumerateur() {
/* 301 */     return this.numerateur;
/*     */   }
/*     */   
/*     */   public void setNumerateur(String numerateur) {
/* 305 */     this.numerateur = numerateur;
/*     */   }
/*     */   
/*     */   public String getSourceverification() {
/* 309 */     return this.sourceverification;
/*     */   }
/*     */   
/*     */   public void setSourceverification(String sourceverification) {
/* 313 */     this.sourceverification = sourceverification;
/*     */   }
/*     */   
/*     */   public String getReference() {
/* 317 */     return this.reference;
/*     */   }
/*     */   
/*     */   public void setReference(String reference) {
/* 321 */     this.reference = reference;
/*     */   }
/*     */   
/*     */   public Integer getAnnebaseline() {
/* 325 */     return this.annebaseline;
/*     */   }
/*     */   
/*     */   public void setAnnebaseline(Integer annebaseline) {
/* 329 */     this.annebaseline = annebaseline;
/*     */   }
/*     */   
/*     */   public Integer getAnnecible() {
/* 333 */     return this.annecible;
/*     */   }
/*     */   
/*     */   public void setAnnecible(Integer annecible) {
/* 337 */     this.annecible = annecible;
/*     */   }
/*     */   
/*     */   public String getUnite() {
/* 341 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(String unite) {
/* 345 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public Double getPourcentage() {
/* 349 */     return this.pourcentage;
/*     */   }
/*     */   
/*     */   public void setPourcentage(Double pourcentage) {
/* 353 */     this.pourcentage = pourcentage;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/* 357 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/* 361 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public Double getBaseline() {
/* 365 */     return this.baseline;
/*     */   }
/*     */   
/*     */   public void setBaseline(Double baseline) {
/* 369 */     this.baseline = baseline;
/*     */   }
/*     */   
/*     */   public Double getValeurrealise() {
/* 373 */     return this.valeurrealise;
/*     */   }
/*     */   
/*     */   public void setValeurrealise(Double valeurrealise) {
/* 377 */     this.valeurrealise = valeurrealise;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 381 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 385 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public Boolean getActif() {
/* 389 */     return this.actif;
/*     */   }
/*     */   
/*     */   public void setActif(Boolean actif) {
/* 393 */     this.actif = actif;
/*     */   }
/*     */   
/*     */   public String getPeriodicitemesure() {
/* 397 */     return this.periodicitemesure;
/*     */   }
/*     */   
/*     */   public void setPeriodicitemesure(String periodicitemesure) {
/* 401 */     this.periodicitemesure = periodicitemesure;
/*     */   }
/*     */   
/*     */   public Double getCoutcollecte() {
/* 405 */     return this.coutcollecte;
/*     */   }
/*     */   
/*     */   public void setCoutcollecte(Double coutcollecte) {
/* 409 */     this.coutcollecte = coutcollecte;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 413 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 417 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public String getInterpretation() {
/* 421 */     return this.interpretation;
/*     */   }
/*     */   
/*     */   public void setInterpretation(String interpretation) {
/* 425 */     this.interpretation = interpretation;
/*     */   }
/*     */   
/*     */   public String getLimite() {
/* 429 */     return this.limite;
/*     */   }
/*     */   
/*     */   public void setLimite(String limite) {
/* 433 */     this.limite = limite;
/*     */   }
/*     */   
/*     */   public String getAnalyses() {
/* 437 */     return this.analyses;
/*     */   }
/*     */   
/*     */   public void setAnalyses(String analyses) {
/* 441 */     this.analyses = analyses;
/*     */   }
/*     */   
/*     */   public String getServiceanalyse() {
/* 445 */     return this.serviceanalyse;
/*     */   }
/*     */   
/*     */   public void setServiceanalyse(String serviceanalyse) {
/* 449 */     this.serviceanalyse = serviceanalyse;
/*     */   }
/*     */   
/*     */   public String getServicesynthese() {
/* 453 */     return this.servicesynthese;
/*     */   }
/*     */   
/*     */   public void setServicesynthese(String servicesynthese) {
/* 457 */     this.servicesynthese = servicesynthese;
/*     */   }
/*     */   
/*     */   public String getServicevalidation() {
/* 461 */     return this.servicevalidation;
/*     */   }
/*     */   
/*     */   public void setServicevalidation(String servicevalidation) {
/* 465 */     this.servicevalidation = servicevalidation;
/*     */   }
/*     */   
/*     */   public String getServicerespo() {
/* 469 */     return this.servicerespo;
/*     */   }
/*     */   
/*     */   public void setServicerespo(String servicerespo) {
/* 473 */     this.servicerespo = servicerespo;
/*     */   }
/*     */   
/*     */   public String getModecollecte() {
/* 477 */     return this.modecollecte;
/*     */   }
/*     */   
/*     */   public void setModecollecte(String modecollecte) {
/* 481 */     this.modecollecte = modecollecte;
/*     */   }
/*     */   
/*     */   public String getExplication() {
/* 485 */     return this.explication;
/*     */   }
/*     */   
/*     */   public void setExplication(String explication) {
/* 489 */     this.explication = explication;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 493 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 497 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 501 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 505 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 509 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 513 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Action> getActionList() {
/* 518 */     return this.actionList;
/*     */   }
/*     */   
/*     */   public void setActionList(List<Action> actionList) {
/* 522 */     this.actionList = actionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurprogrammeannee> getIndicateurprogrammeanneeList() {
/* 527 */     return this.indicateurprogrammeanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateurprogrammeanneeList(List<Indicateurprogrammeannee> indicateurprogrammeanneeList) {
/* 531 */     this.indicateurprogrammeanneeList = indicateurprogrammeanneeList;
/*     */   }
/*     */   
/*     */   public Typedonnees getIdtypedonnees() {
/* 535 */     return this.idtypedonnees;
/*     */   }
/*     */   
/*     */   public void setIdtypedonnees(Typedonnees idtypedonnees) {
/* 539 */     this.idtypedonnees = idtypedonnees;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 544 */     int hash = 0;
/* 545 */     hash += (this.idindicateurprogramme != null) ? this.idindicateurprogramme.hashCode() : 0;
/* 546 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 552 */     if (!(object instanceof Indicateurprogramme)) {
/* 553 */       return false;
/*     */     }
/* 555 */     Indicateurprogramme other = (Indicateurprogramme)object;
/* 556 */     if ((this.idindicateurprogramme == null && other.idindicateurprogramme != null) || (this.idindicateurprogramme != null && !this.idindicateurprogramme.equals(other.idindicateurprogramme))) {
/* 557 */       return false;
/*     */     }
/* 559 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 564 */     return "entities.Indicateurprogramme[ idindicateurprogramme=" + this.idindicateurprogramme + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurprogramme.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */