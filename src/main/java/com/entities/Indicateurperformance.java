/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.CascadeType;
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
/*     */ @Entity
/*     */ @Table(name = "indicateurperformance")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateurperformance.findAll", query = "SELECT i FROM Indicateurperformance i"), @NamedQuery(name = "Indicateurperformance.findByIdindicateurperformance", query = "SELECT i FROM Indicateurperformance i WHERE i.idindicateurperformance = :idindicateurperformance"), @NamedQuery(name = "Indicateurperformance.findByNom", query = "SELECT i FROM Indicateurperformance i WHERE i.nom = :nom"), @NamedQuery(name = "Indicateurperformance.findByUnite", query = "SELECT i FROM Indicateurperformance i WHERE i.unite = :unite"), @NamedQuery(name = "Indicateurperformance.findByPeriodicitecollecte", query = "SELECT i FROM Indicateurperformance i WHERE i.periodicitecollecte = :periodicitecollecte"), @NamedQuery(name = "Indicateurperformance.findByDifficultes", query = "SELECT i FROM Indicateurperformance i WHERE i.difficultes = :difficultes"), @NamedQuery(name = "Indicateurperformance.findByPap", query = "SELECT i FROM Indicateurperformance i WHERE i.pap = :pap"), @NamedQuery(name = "Indicateurperformance.findByCoefmulti", query = "SELECT i FROM Indicateurperformance i WHERE i.coefmulti = :coefmulti"), @NamedQuery(name = "Indicateurperformance.findByMoyens", query = "SELECT i FROM Indicateurperformance i WHERE i.moyens = :moyens"), @NamedQuery(name = "Indicateurperformance.findBySourcedonnees", query = "SELECT i FROM Indicateurperformance i WHERE i.sourcedonnees = :sourcedonnees"), @NamedQuery(name = "Indicateurperformance.findByModecalcul", query = "SELECT i FROM Indicateurperformance i WHERE i.modecalcul = :modecalcul"), @NamedQuery(name = "Indicateurperformance.findByDenominateur", query = "SELECT i FROM Indicateurperformance i WHERE i.denominateur = :denominateur"), @NamedQuery(name = "Indicateurperformance.findByNumerateur", query = "SELECT i FROM Indicateurperformance i WHERE i.numerateur = :numerateur"), @NamedQuery(name = "Indicateurperformance.findByPeriodicitemesure", query = "SELECT i FROM Indicateurperformance i WHERE i.periodicitemesure = :periodicitemesure"), @NamedQuery(name = "Indicateurperformance.findByCoutcollecte", query = "SELECT i FROM Indicateurperformance i WHERE i.coutcollecte = :coutcollecte"), @NamedQuery(name = "Indicateurperformance.findByCommentaire", query = "SELECT i FROM Indicateurperformance i WHERE i.commentaire = :commentaire"), @NamedQuery(name = "Indicateurperformance.findByInterpretation", query = "SELECT i FROM Indicateurperformance i WHERE i.interpretation = :interpretation"), @NamedQuery(name = "Indicateurperformance.findByLimite", query = "SELECT i FROM Indicateurperformance i WHERE i.limite = :limite"), @NamedQuery(name = "Indicateurperformance.findByAnalyses", query = "SELECT i FROM Indicateurperformance i WHERE i.analyses = :analyses"), @NamedQuery(name = "Indicateurperformance.findByServiceanalyse", query = "SELECT i FROM Indicateurperformance i WHERE i.serviceanalyse = :serviceanalyse"), @NamedQuery(name = "Indicateurperformance.findByServicesynthese", query = "SELECT i FROM Indicateurperformance i WHERE i.servicesynthese = :servicesynthese"), @NamedQuery(name = "Indicateurperformance.findByServicevalidation", query = "SELECT i FROM Indicateurperformance i WHERE i.servicevalidation = :servicevalidation"), @NamedQuery(name = "Indicateurperformance.findByServicerespo", query = "SELECT i FROM Indicateurperformance i WHERE i.servicerespo = :servicerespo"), @NamedQuery(name = "Indicateurperformance.findByModecollecte", query = "SELECT i FROM Indicateurperformance i WHERE i.modecollecte = :modecollecte"), @NamedQuery(name = "Indicateurperformance.findByExplication", query = "SELECT i FROM Indicateurperformance i WHERE i.explication = :explication"), @NamedQuery(name = "Indicateurperformance.findByEtat", query = "SELECT i FROM Indicateurperformance i WHERE i.etat = :etat"), @NamedQuery(name = "Indicateurperformance.findByDateEnregistre", query = "SELECT i FROM Indicateurperformance i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Indicateurperformance.findByDerniereModif", query = "SELECT i FROM Indicateurperformance i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Indicateurperformance
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateurperformance")
/*     */   private Long idindicateurperformance;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "unite")
/*     */   private String unite;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "periodicitecollecte")
/*     */   private String periodicitecollecte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "difficultes")
/*     */   private String difficultes;
/*     */   @Column(name = "pap")
/*     */   private Boolean pap;
/*     */   @Column(name = "coefmulti")
/*     */   private Double coefmulti;
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
/*     */   @JoinColumn(name = "idniveaupyramide", referencedColumnName = "idniveaupyramide")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Niveaupyramide idniveaupyramide;
/*     */   @JoinColumn(name = "idorigineindicateur", referencedColumnName = "idorigineindicateur")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Origineindicateur idorigineindicateur;
/*     */   @JoinColumn(name = "idtypedonnees", referencedColumnName = "idtypedonnees")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typedonnees idtypedonnees;
/*     */   @JoinColumn(name = "idtypestructure", referencedColumnName = "idtypestructure")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typestructure idtypestructure;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "indicateurperformance", fetch = FetchType.LAZY)
/*     */   private List<Tacheindicateurperformance> tacheindicateurperformanceList;
/*     */   @OneToMany(mappedBy = "idindicateurperformance", fetch = FetchType.LAZY)
/*     */   private List<Extrant> extrantList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "indicateurperformance", fetch = FetchType.LAZY)
/*     */   private List<Performance> performanceList;
/*     */   
/*     */   public Indicateurperformance() {}
/*     */   
/*     */   public Indicateurperformance(Long idindicateurperformance) {
/* 172 */     this.idindicateurperformance = idindicateurperformance;
/*     */   }
/*     */   
/*     */   public Long getIdindicateurperformance() {
/* 176 */     return this.idindicateurperformance;
/*     */   }
/*     */   
/*     */   public void setIdindicateurperformance(Long idindicateurperformance) {
/* 180 */     this.idindicateurperformance = idindicateurperformance;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 184 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 188 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getUnite() {
/* 192 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(String unite) {
/* 196 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public String getPeriodicitecollecte() {
/* 200 */     return this.periodicitecollecte;
/*     */   }
/*     */   
/*     */   public void setPeriodicitecollecte(String periodicitecollecte) {
/* 204 */     this.periodicitecollecte = periodicitecollecte;
/*     */   }
/*     */   
/*     */   public String getDifficultes() {
/* 208 */     return this.difficultes;
/*     */   }
/*     */   
/*     */   public void setDifficultes(String difficultes) {
/* 212 */     this.difficultes = difficultes;
/*     */   }
/*     */   
/*     */   public Boolean getPap() {
/* 216 */     return this.pap;
/*     */   }
/*     */   
/*     */   public void setPap(Boolean pap) {
/* 220 */     this.pap = pap;
/*     */   }
/*     */   
/*     */   public Double getCoefmulti() {
/* 224 */     return this.coefmulti;
/*     */   }
/*     */   
/*     */   public void setCoefmulti(Double coefmulti) {
/* 228 */     this.coefmulti = coefmulti;
/*     */   }
/*     */   
/*     */   public String getMoyens() {
/* 232 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(String moyens) {
/* 236 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public String getSourcedonnees() {
/* 240 */     return this.sourcedonnees;
/*     */   }
/*     */   
/*     */   public void setSourcedonnees(String sourcedonnees) {
/* 244 */     this.sourcedonnees = sourcedonnees;
/*     */   }
/*     */   
/*     */   public String getModecalcul() {
/* 248 */     return this.modecalcul;
/*     */   }
/*     */   
/*     */   public void setModecalcul(String modecalcul) {
/* 252 */     this.modecalcul = modecalcul;
/*     */   }
/*     */   
/*     */   public String getDenominateur() {
/* 256 */     return this.denominateur;
/*     */   }
/*     */   
/*     */   public void setDenominateur(String denominateur) {
/* 260 */     this.denominateur = denominateur;
/*     */   }
/*     */   
/*     */   public String getNumerateur() {
/* 264 */     return this.numerateur;
/*     */   }
/*     */   
/*     */   public void setNumerateur(String numerateur) {
/* 268 */     this.numerateur = numerateur;
/*     */   }
/*     */   
/*     */   public String getPeriodicitemesure() {
/* 272 */     return this.periodicitemesure;
/*     */   }
/*     */   
/*     */   public void setPeriodicitemesure(String periodicitemesure) {
/* 276 */     this.periodicitemesure = periodicitemesure;
/*     */   }
/*     */   
/*     */   public Double getCoutcollecte() {
/* 280 */     return this.coutcollecte;
/*     */   }
/*     */   
/*     */   public void setCoutcollecte(Double coutcollecte) {
/* 284 */     this.coutcollecte = coutcollecte;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 288 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 292 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public String getInterpretation() {
/* 296 */     return this.interpretation;
/*     */   }
/*     */   
/*     */   public void setInterpretation(String interpretation) {
/* 300 */     this.interpretation = interpretation;
/*     */   }
/*     */   
/*     */   public String getLimite() {
/* 304 */     return this.limite;
/*     */   }
/*     */   
/*     */   public void setLimite(String limite) {
/* 308 */     this.limite = limite;
/*     */   }
/*     */   
/*     */   public String getAnalyses() {
/* 312 */     return this.analyses;
/*     */   }
/*     */   
/*     */   public void setAnalyses(String analyses) {
/* 316 */     this.analyses = analyses;
/*     */   }
/*     */   
/*     */   public String getServiceanalyse() {
/* 320 */     return this.serviceanalyse;
/*     */   }
/*     */   
/*     */   public void setServiceanalyse(String serviceanalyse) {
/* 324 */     this.serviceanalyse = serviceanalyse;
/*     */   }
/*     */   
/*     */   public String getServicesynthese() {
/* 328 */     return this.servicesynthese;
/*     */   }
/*     */   
/*     */   public void setServicesynthese(String servicesynthese) {
/* 332 */     this.servicesynthese = servicesynthese;
/*     */   }
/*     */   
/*     */   public String getServicevalidation() {
/* 336 */     return this.servicevalidation;
/*     */   }
/*     */   
/*     */   public void setServicevalidation(String servicevalidation) {
/* 340 */     this.servicevalidation = servicevalidation;
/*     */   }
/*     */   
/*     */   public String getServicerespo() {
/* 344 */     return this.servicerespo;
/*     */   }
/*     */   
/*     */   public void setServicerespo(String servicerespo) {
/* 348 */     this.servicerespo = servicerespo;
/*     */   }
/*     */   
/*     */   public String getModecollecte() {
/* 352 */     return this.modecollecte;
/*     */   }
/*     */   
/*     */   public void setModecollecte(String modecollecte) {
/* 356 */     this.modecollecte = modecollecte;
/*     */   }
/*     */   
/*     */   public String getExplication() {
/* 360 */     return this.explication;
/*     */   }
/*     */   
/*     */   public void setExplication(String explication) {
/* 364 */     this.explication = explication;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 368 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 372 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 376 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 380 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 384 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 388 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Niveaupyramide getIdniveaupyramide() {
/* 392 */     return this.idniveaupyramide;
/*     */   }
/*     */   
/*     */   public void setIdniveaupyramide(Niveaupyramide idniveaupyramide) {
/* 396 */     this.idniveaupyramide = idniveaupyramide;
/*     */   }
/*     */   
/*     */   public Origineindicateur getIdorigineindicateur() {
/* 400 */     return this.idorigineindicateur;
/*     */   }
/*     */   
/*     */   public void setIdorigineindicateur(Origineindicateur idorigineindicateur) {
/* 404 */     this.idorigineindicateur = idorigineindicateur;
/*     */   }
/*     */   
/*     */   public Typedonnees getIdtypedonnees() {
/* 408 */     return this.idtypedonnees;
/*     */   }
/*     */   
/*     */   public void setIdtypedonnees(Typedonnees idtypedonnees) {
/* 412 */     this.idtypedonnees = idtypedonnees;
/*     */   }
/*     */   
/*     */   public Typestructure getIdtypestructure() {
/* 416 */     return this.idtypestructure;
/*     */   }
/*     */   
/*     */   public void setIdtypestructure(Typestructure idtypestructure) {
/* 420 */     this.idtypestructure = idtypestructure;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tacheindicateurperformance> getTacheindicateurperformanceList() {
/* 425 */     return this.tacheindicateurperformanceList;
/*     */   }
/*     */   
/*     */   public void setTacheindicateurperformanceList(List<Tacheindicateurperformance> tacheindicateurperformanceList) {
/* 429 */     this.tacheindicateurperformanceList = tacheindicateurperformanceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Extrant> getExtrantList() {
/* 434 */     return this.extrantList;
/*     */   }
/*     */   
/*     */   public void setExtrantList(List<Extrant> extrantList) {
/* 438 */     this.extrantList = extrantList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Performance> getPerformanceList() {
/* 443 */     return this.performanceList;
/*     */   }
/*     */   
/*     */   public void setPerformanceList(List<Performance> performanceList) {
/* 447 */     this.performanceList = performanceList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 452 */     int hash = 0;
/* 453 */     hash += (this.idindicateurperformance != null) ? this.idindicateurperformance.hashCode() : 0;
/* 454 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 460 */     if (!(object instanceof Indicateurperformance)) {
/* 461 */       return false;
/*     */     }
/* 463 */     Indicateurperformance other = (Indicateurperformance)object;
/* 464 */     if ((this.idindicateurperformance == null && other.idindicateurperformance != null) || (this.idindicateurperformance != null && !this.idindicateurperformance.equals(other.idindicateurperformance))) {
/* 465 */       return false;
/*     */     }
/* 467 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 472 */     return "entities.Indicateurperformance[ idindicateurperformance=" + this.idindicateurperformance + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurperformance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */