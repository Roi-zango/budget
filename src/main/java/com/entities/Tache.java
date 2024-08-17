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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "tache")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"), @NamedQuery(name = "Tache.findByIdtache", query = "SELECT t FROM Tache t WHERE t.idtache = :idtache"), @NamedQuery(name = "Tache.findByNumordre", query = "SELECT t FROM Tache t WHERE t.numordre = :numordre"), @NamedQuery(name = "Tache.findByTotalmontantaloue", query = "SELECT t FROM Tache t WHERE t.totalmontantaloue = :totalmontantaloue"), @NamedQuery(name = "Tache.findByMoyensnecessaires", query = "SELECT t FROM Tache t WHERE t.moyensnecessaires = :moyensnecessaires"), @NamedQuery(name = "Tache.findByIndicateurs2014", query = "SELECT t FROM Tache t WHERE t.indicateurs2014 = :indicateurs2014"), @NamedQuery(name = "Tache.findByNom", query = "SELECT t FROM Tache t WHERE t.nom = :nom"), @NamedQuery(name = "Tache.findByEtat", query = "SELECT t FROM Tache t WHERE t.etat = :etat"), @NamedQuery(name = "Tache.findByDateEnregistre", query = "SELECT t FROM Tache t WHERE t.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Tache.findByDerniereModif", query = "SELECT t FROM Tache t WHERE t.derniereModif = :derniereModif"), @NamedQuery(name = "Tache.findByAeencours", query = "SELECT t FROM Tache t WHERE t.aeencours = :aeencours"), @NamedQuery(name = "Tache.findByCpconsommee", query = "SELECT t FROM Tache t WHERE t.cpconsommee = :cpconsommee"), @NamedQuery(name = "Tache.findByIndicateurspoursuivis", query = "SELECT t FROM Tache t WHERE t.indicateurspoursuivis = :indicateurspoursuivis"), @NamedQuery(name = "Tache.findByM1", query = "SELECT t FROM Tache t WHERE t.m1 = :m1"), @NamedQuery(name = "Tache.findByM2", query = "SELECT t FROM Tache t WHERE t.m2 = :m2"), @NamedQuery(name = "Tache.findByM3", query = "SELECT t FROM Tache t WHERE t.m3 = :m3"), @NamedQuery(name = "Tache.findByM4", query = "SELECT t FROM Tache t WHERE t.m4 = :m4"), @NamedQuery(name = "Tache.findByM5", query = "SELECT t FROM Tache t WHERE t.m5 = :m5"), @NamedQuery(name = "Tache.findByM6", query = "SELECT t FROM Tache t WHERE t.m6 = :m6"), @NamedQuery(name = "Tache.findByM7", query = "SELECT t FROM Tache t WHERE t.m7 = :m7"), @NamedQuery(name = "Tache.findByM8", query = "SELECT t FROM Tache t WHERE t.m8 = :m8"), @NamedQuery(name = "Tache.findByM9", query = "SELECT t FROM Tache t WHERE t.m9 = :m9"), @NamedQuery(name = "Tache.findByM10", query = "SELECT t FROM Tache t WHERE t.m10 = :m10"), @NamedQuery(name = "Tache.findByM11", query = "SELECT t FROM Tache t WHERE t.m11 = :m11"), @NamedQuery(name = "Tache.findByM12", query = "SELECT t FROM Tache t WHERE t.m12 = :m12")})
/*     */ public class Tache
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idtache")
/*     */   private Long idtache;
/*     */   @Column(name = "numordre")
/*     */   private Integer numordre;
/*     */   @Column(name = "totalmontantaloue")
/*     */   private Double totalmontantaloue;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "moyensnecessaires")
/*     */   private String moyensnecessaires;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "indicateurs2014")
/*     */   private String indicateurs2014;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Column(name = "aeencours")
/*     */   private Double aeencours;
/*     */   @Column(name = "cpconsommee")
/*     */   private Double cpconsommee;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "indicateurspoursuivis")
/*     */   private String indicateurspoursuivis;
/*     */   @Column(name = "m1")
/*     */   private Boolean m1;
/*     */   @Column(name = "m2")
/*     */   private Boolean m2;
/*     */   @Column(name = "m3")
/*     */   private Boolean m3;
/*     */   @Column(name = "m4")
/*     */   private Boolean m4;
/*     */   @Column(name = "m5")
/*     */   private Boolean m5;
/*     */   @Column(name = "m6")
/*     */   private Boolean m6;
/*     */   @Column(name = "m7")
/*     */   private Boolean m7;
/*     */   @Column(name = "m8")
/*     */   private Boolean m8;
/*     */   @Column(name = "m9")
/*     */   private Boolean m9;
/*     */   @Column(name = "m10")
/*     */   private Boolean m10;
/*     */   @Column(name = "m11")
/*     */   private Boolean m11;
/*     */   @Column(name = "m12")
/*     */   private Boolean m12;
/*     */   @JoinColumn(name = "idactivite", referencedColumnName = "idactivite")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Activite idactivite;
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @JoinColumn(name = "idbailleurfond", referencedColumnName = "idbailleurfond")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Bailleurfond idbailleurfond;
/*     */   @JoinColumn(name = "idnature_t", referencedColumnName = "idnature_t")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private NatureT idnatureT;
/*     */   @JoinColumn(name = "idnaturetache", referencedColumnName = "idnaturetache")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Naturetache idnaturetache;
/*     */   @JoinColumn(name = "idrisque", referencedColumnName = "idrisque")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Risque idrisque;
/*     */   @JoinColumn(name = "idstructure", referencedColumnName = "idstructure")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Structure idstructure;
/*     */   @JoinColumn(name = "idtypefinancement", referencedColumnName = "idtypefinancement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typefinancement idtypefinancement;
/*     */   @OneToMany(mappedBy = "idtache", fetch = FetchType.LAZY)
/*     */   private List<Moyens> moyensList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "tache", fetch = FetchType.LAZY)
/*     */   private List<Tacheindicateurperformance> tacheindicateurperformanceList;
/*     */   @OneToMany(mappedBy = "idtache", fetch = FetchType.LAZY)
/*     */   private List<Semaine> semaineList;
/*     */   private double montantengage;
/*     */   private double montantliquide;
/*     */   private double montantpayeht;
/*     */   private double montantpayettc;
/*     */   private double cpanneeplus1;
/*     */   private double cpanneeplus2;
/*     */   @Column(name = "montant_ordonne")
/*     */   private double montantOrdonne;
/*     */   @Column(name = "taxe_ordonne")
/*     */   private double taxeOrdonne;
/*     */   @Column(name = "nap_ordonne")
/*     */   private double napOrdonne;
/*     */   @Size(max = 1000)
/*     */   @Column(name = "resultprocess")
/*     */   private String resultprocess;
/*     */   @Size(max = 1000)
/*     */   @Column(name = "indicateurresult")
/*     */   private String indicateurresult;
/*     */   /**
 * 
 */
@ManyToOne(fetch = FetchType.LAZY)
//
///*     */   @JoinColumn(name = "idcode_analytique", referencedColumnName = "idcode_analytique")
///*     */   private CodeAnalytique codeAnalytique;
/*     */   
/*     */   public Tache() {}
/*     */   
/*     */   public Tache(Long idtache) {
/* 186 */     this.idtache = idtache;
/*     */   }
/*     */   
/*     */   public Long getIdtache() {
/* 190 */     return this.idtache;
/*     */   }
/*     */   
/*     */   public void setIdtache(Long idtache) {
/* 194 */     this.idtache = idtache;
/*     */   }
/*     */   
/*     */   public Integer getNumordre() {
/* 198 */     return this.numordre;
/*     */   }
/*     */   
/*     */   public void setNumordre(Integer numordre) {
/* 202 */     this.numordre = numordre;
/*     */   }
/*     */   
/*     */   public Double getTotalmontantaloue() {
/* 206 */     return this.totalmontantaloue;
/*     */   }
/*     */   
/*     */   public void setTotalmontantaloue(Double totalmontantaloue) {
/* 210 */     this.totalmontantaloue = totalmontantaloue;
/*     */   }
/*     */   
/*     */   public String getMoyensnecessaires() {
/* 214 */     return this.moyensnecessaires;
/*     */   }
/*     */   
/*     */   public void setMoyensnecessaires(String moyensnecessaires) {
/* 218 */     this.moyensnecessaires = moyensnecessaires;
/*     */   }
/*     */   
/*     */   public String getIndicateurs2014() {
/* 222 */     return this.indicateurs2014;
/*     */   }
/*     */   
/*     */   public void setIndicateurs2014(String indicateurs2014) {
/* 226 */     this.indicateurs2014 = indicateurs2014;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 230 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 234 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 238 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 242 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 246 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 250 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 254 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 258 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Double getAeencours() {
/* 262 */     return this.aeencours;
/*     */   }
/*     */   
/*     */   public void setAeencours(Double aeencours) {
/* 266 */     this.aeencours = aeencours;
/*     */   }
/*     */   
/*     */   public Double getCpconsommee() {
/* 270 */     return this.cpconsommee;
/*     */   }
/*     */   
/*     */   public void setCpconsommee(Double cpconsommee) {
/* 274 */     this.cpconsommee = cpconsommee;
/*     */   }
/*     */   
/*     */   public String getIndicateurspoursuivis() {
/* 278 */     return this.indicateurspoursuivis;
/*     */   }
/*     */   
/*     */   public void setIndicateurspoursuivis(String indicateurspoursuivis) {
/* 282 */     this.indicateurspoursuivis = indicateurspoursuivis;
/*     */   }
/*     */   
/*     */   public Boolean getM1() {
/* 286 */     return this.m1;
/*     */   }
/*     */   
/*     */   public void setM1(Boolean m1) {
/* 290 */     this.m1 = m1;
/*     */   }
/*     */   
/*     */   public Boolean getM2() {
/* 294 */     return this.m2;
/*     */   }
/*     */   
/*     */   public void setM2(Boolean m2) {
/* 298 */     this.m2 = m2;
/*     */   }
/*     */   
/*     */   public Boolean getM3() {
/* 302 */     return this.m3;
/*     */   }
/*     */   
/*     */   public void setM3(Boolean m3) {
/* 306 */     this.m3 = m3;
/*     */   }
/*     */   
/*     */   public Boolean getM4() {
/* 310 */     return this.m4;
/*     */   }
/*     */   
/*     */   public void setM4(Boolean m4) {
/* 314 */     this.m4 = m4;
/*     */   }
/*     */   
/*     */   public Boolean getM5() {
/* 318 */     return this.m5;
/*     */   }
/*     */   
/*     */   public void setM5(Boolean m5) {
/* 322 */     this.m5 = m5;
/*     */   }
/*     */   
/*     */   public Boolean getM6() {
/* 326 */     return this.m6;
/*     */   }
/*     */   
/*     */   public void setM6(Boolean m6) {
/* 330 */     this.m6 = m6;
/*     */   }
/*     */   
/*     */   public Boolean getM7() {
/* 334 */     return this.m7;
/*     */   }
/*     */   
/*     */   public void setM7(Boolean m7) {
/* 338 */     this.m7 = m7;
/*     */   }
/*     */   
/*     */   public Boolean getM8() {
/* 342 */     return this.m8;
/*     */   }
/*     */   
/*     */   public void setM8(Boolean m8) {
/* 346 */     this.m8 = m8;
/*     */   }
/*     */   
/*     */   public Boolean getM9() {
/* 350 */     return this.m9;
/*     */   }
/*     */   
/*     */   public void setM9(Boolean m9) {
/* 354 */     this.m9 = m9;
/*     */   }
/*     */   
/*     */   public Boolean getM10() {
/* 358 */     return this.m10;
/*     */   }
/*     */   
/*     */   public void setM10(Boolean m10) {
/* 362 */     this.m10 = m10;
/*     */   }
/*     */   
/*     */   public Boolean getM11() {
/* 366 */     return this.m11;
/*     */   }
/*     */   
/*     */   public void setM11(Boolean m11) {
/* 370 */     this.m11 = m11;
/*     */   }
/*     */   
/*     */   public Boolean getM12() {
/* 374 */     return this.m12;
/*     */   }
/*     */   
/*     */   public void setM12(Boolean m12) {
/* 378 */     this.m12 = m12;
/*     */   }
/*     */   
/*     */   public double getCpanneeplus1() {
/* 382 */     return this.cpanneeplus1;
/*     */   }
/*     */   
/*     */   public void setCpanneeplus1(double cpanneeplus1) {
/* 386 */     this.cpanneeplus1 = cpanneeplus1;
/*     */   }
/*     */   
/*     */   public double getCpanneeplus2() {
/* 390 */     return this.cpanneeplus2;
/*     */   }
/*     */   
/*     */   public void setCpanneeplus2(double cpanneeplus2) {
/* 394 */     this.cpanneeplus2 = cpanneeplus2;
/*     */   }
/*     */   
/*     */   public double getMontantengage() {
/* 398 */     return this.montantengage;
/*     */   }
/*     */   
/*     */   public void setMontantengage(double montantengage) {
/* 402 */     this.montantengage = montantengage;
/*     */   }
/*     */   
/*     */   public double getMontantliquide() {
/* 406 */     return this.montantliquide;
/*     */   }
/*     */   
/*     */   public void setMontantliquide(double montantliquide) {
/* 410 */     this.montantliquide = montantliquide;
/*     */   }
/*     */   
/*     */   public double getMontantpayeht() {
/* 414 */     return this.montantpayeht;
/*     */   }
/*     */   
/*     */   public void setMontantpayeht(double montantpayeht) {
/* 418 */     this.montantpayeht = montantpayeht;
/*     */   }
/*     */   
/*     */   public double getMontantpayettc() {
/* 422 */     return this.montantpayettc;
/*     */   }
/*     */   
/*     */   public void setMontantpayettc(double montantpayettc) {
/* 426 */     this.montantpayettc = montantpayettc;
/*     */   }
/*     */   
/*     */   public double getMontantOrdonne() {
/* 430 */     return this.montantOrdonne;
/*     */   }
/*     */   
/*     */   public void setMontantOrdonne(double montantOrdonne) {
/* 434 */     this.montantOrdonne = montantOrdonne;
/*     */   }
/*     */   
/*     */   public double getTaxeOrdonne() {
/* 438 */     return this.taxeOrdonne;
/*     */   }
/*     */   
/*     */   public void setTaxeOrdonne(double taxeOrdonne) {
/* 442 */     this.taxeOrdonne = taxeOrdonne;
/*     */   }
/*     */   
/*     */   public double getNapOrdonne() {
/* 446 */     return this.napOrdonne;
/*     */   }
/*     */   
/*     */   public void setNapOrdonne(double napOrdonne) {
/* 450 */     this.napOrdonne = napOrdonne;
/*     */   }
/*     */   
/*     */   public Activite getIdactivite() {
/* 454 */     return this.idactivite;
/*     */   }
/*     */   
/*     */   public void setIdactivite(Activite idactivite) {
/* 458 */     this.idactivite = idactivite;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 462 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 466 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Bailleurfond getIdbailleurfond() {
/* 470 */     return this.idbailleurfond;
/*     */   }
/*     */   
/*     */   public void setIdbailleurfond(Bailleurfond idbailleurfond) {
/* 474 */     this.idbailleurfond = idbailleurfond;
/*     */   }
/*     */   
/*     */   public NatureT getIdnatureT() {
/* 478 */     return this.idnatureT;
/*     */   }
/*     */   
/*     */   public void setIdnatureT(NatureT idnatureT) {
/* 482 */     this.idnatureT = idnatureT;
/*     */   }
/*     */   
/*     */   public Naturetache getIdnaturetache() {
/* 486 */     return this.idnaturetache;
/*     */   }
/*     */   
/*     */   public void setIdnaturetache(Naturetache idnaturetache) {
/* 490 */     this.idnaturetache = idnaturetache;
/*     */   }
/*     */   
/*     */   public Risque getIdrisque() {
/* 494 */     return this.idrisque;
/*     */   }
/*     */   
/*     */   public void setIdrisque(Risque idrisque) {
/* 498 */     this.idrisque = idrisque;
/*     */   }
/*     */   
/*     */   public Structure getIdstructure() {
/* 502 */     return this.idstructure;
/*     */   }
/*     */   
/*     */   public void setIdstructure(Structure idstructure) {
/* 506 */     this.idstructure = idstructure;
/*     */   }
/*     */   
/*     */   public Typefinancement getIdtypefinancement() {
/* 510 */     return this.idtypefinancement;
/*     */   }
/*     */   
/*     */   public void setIdtypefinancement(Typefinancement idtypefinancement) {
/* 514 */     this.idtypefinancement = idtypefinancement;
/*     */   }
/*     */   
/*     */   public String getResultprocess() {
/* 518 */     return this.resultprocess;
/*     */   }
/*     */   
/*     */   public void setResultprocess(String resultprocess) {
/* 522 */     this.resultprocess = resultprocess;
/*     */   }
/*     */   
/*     */   public String getIndicateurresult() {
/* 526 */     return this.indicateurresult;
/*     */   }
/*     */   
/*     */   public void setIndicateurresult(String indicateurresult) {
/* 530 */     this.indicateurresult = indicateurresult;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Moyens> getMoyensList() {
/* 535 */     return this.moyensList;
/*     */   }
/*     */   
/*     */   public void setMoyensList(List<Moyens> moyensList) {
/* 539 */     this.moyensList = moyensList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tacheindicateurperformance> getTacheindicateurperformanceList() {
/* 544 */     return this.tacheindicateurperformanceList;
/*     */   }
/*     */   
/*     */   public void setTacheindicateurperformanceList(List<Tacheindicateurperformance> tacheindicateurperformanceList) {
/* 548 */     this.tacheindicateurperformanceList = tacheindicateurperformanceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Semaine> getSemaineList() {
/* 553 */     return this.semaineList;
/*     */   }
/*     */   
/*     */   public void setSemaineList(List<Semaine> semaineList) {
/* 557 */     this.semaineList = semaineList;
/*     */   }
/*     */   
///*     */   public CodeAnalytique getCodeAnalytique() {
///* 561 */     return this.codeAnalytique;
/*     */   }
/*     */   
///*     */   public void setCodeAnalytique(CodeAnalytique codeAnalytique) {
///* 565 */     this.codeAnalytique = codeAnalytique;
///*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 570 */     int hash = 0;
/* 571 */     hash += (this.idtache != null) ? this.idtache.hashCode() : 0;
/* 572 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 578 */     if (!(object instanceof Tache)) {
/* 579 */       return false;
/*     */     }
/* 581 */     Tache other = (Tache)object;
/* 582 */     if ((this.idtache == null && other.idtache != null) || (this.idtache != null && !this.idtache.equals(other.idtache))) {
/* 583 */       return false;
/*     */     }
/* 585 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 590 */     return "entities.Tache[ idtache=" + this.idtache + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Tache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */