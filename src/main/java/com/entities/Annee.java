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
/*     */ @Entity
/*     */ @Table(name = "annee")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Annee.findAll", query = "SELECT a FROM Annee a"), @NamedQuery(name = "Annee.findByIdannee", query = "SELECT a FROM Annee a WHERE a.idannee = :idannee"), @NamedQuery(name = "Annee.findByNom", query = "SELECT a FROM Annee a WHERE a.nom = :nom"), @NamedQuery(name = "Annee.findByChoix", query = "SELECT a FROM Annee a WHERE a.choix = :choix"), @NamedQuery(name = "Annee.findByFc", query = "SELECT a FROM Annee a WHERE a.fc = :fc"), @NamedQuery(name = "Annee.findByEtat", query = "SELECT a FROM Annee a WHERE a.etat = :etat"), @NamedQuery(name = "Annee.findByDateEnregistre", query = "SELECT a FROM Annee a WHERE a.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Annee.findByDerniereModif", query = "SELECT a FROM Annee a WHERE a.derniereModif = :derniereModif")})
/*     */ public class Annee
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idannee")
/*     */   private Long idannee;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "choix")
/*     */   private String choix;
/*     */   @Column(name = "fc")
/*     */   private Boolean fc;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Column(name = "budget")
/*     */   private Boolean budget;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Revue> revueList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractiviteannee> indicateuractiviteanneeList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Indicateurprogrammeannee> indicateurprogrammeanneeList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Extrant> extrantList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Indicateuraction> indicateuractionList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Recette> recetteList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Exercice> exerciceList;
/*     */   @OneToMany(mappedBy = "idannee", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractionannee> indicateuractionanneeList;
/*     */   
/*     */   public Annee() {}
/*     */   
/*     */   public Annee(Long idannee) {
/*  93 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Long getIdannee() {
/*  97 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Long idannee) {
/* 101 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 105 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 109 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getChoix() {
/* 113 */     return this.choix;
/*     */   }
/*     */   
/*     */   public void setChoix(String choix) {
/* 117 */     this.choix = choix;
/*     */   }
/*     */   
/*     */   public Boolean getFc() {
/* 121 */     return this.fc;
/*     */   }
/*     */   
/*     */   public void setFc(Boolean fc) {
/* 125 */     this.fc = fc;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 129 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 133 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Boolean getBudget() {
/* 137 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Boolean budget) {
/* 141 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 145 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 149 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 153 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 157 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tache> getTacheList() {
/* 162 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/* 166 */     this.tacheList = tacheList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revue> getRevueList() {
/* 171 */     return this.revueList;
/*     */   }
/*     */   
/*     */   public void setRevueList(List<Revue> revueList) {
/* 175 */     this.revueList = revueList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractiviteannee> getIndicateuractiviteanneeList() {
/* 180 */     return this.indicateuractiviteanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractiviteanneeList(List<Indicateuractiviteannee> indicateuractiviteanneeList) {
/* 184 */     this.indicateuractiviteanneeList = indicateuractiviteanneeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurprogrammeannee> getIndicateurprogrammeanneeList() {
/* 189 */     return this.indicateurprogrammeanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateurprogrammeanneeList(List<Indicateurprogrammeannee> indicateurprogrammeanneeList) {
/* 193 */     this.indicateurprogrammeanneeList = indicateurprogrammeanneeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Extrant> getExtrantList() {
/* 198 */     return this.extrantList;
/*     */   }
/*     */   
/*     */   public void setExtrantList(List<Extrant> extrantList) {
/* 202 */     this.extrantList = extrantList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuraction> getIndicateuractionList() {
/* 207 */     return this.indicateuractionList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractionList(List<Indicateuraction> indicateuractionList) {
/* 211 */     this.indicateuractionList = indicateuractionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Recette> getRecetteList() {
/* 216 */     return this.recetteList;
/*     */   }
/*     */   
/*     */   public void setRecetteList(List<Recette> recetteList) {
/* 220 */     this.recetteList = recetteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Exercice> getExerciceList() {
/* 225 */     return this.exerciceList;
/*     */   }
/*     */   
/*     */   public void setExerciceList(List<Exercice> exerciceList) {
/* 229 */     this.exerciceList = exerciceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractionannee> getIndicateuractionanneeList() {
/* 234 */     return this.indicateuractionanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractionanneeList(List<Indicateuractionannee> indicateuractionanneeList) {
/* 238 */     this.indicateuractionanneeList = indicateuractionanneeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 243 */     int hash = 0;
/* 244 */     hash += (this.idannee != null) ? this.idannee.hashCode() : 0;
/* 245 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 251 */     if (!(object instanceof Annee)) {
/* 252 */       return false;
/*     */     }
/* 254 */     Annee other = (Annee)object;
/* 255 */     if ((this.idannee == null && other.idannee != null) || (this.idannee != null && !this.idannee.equals(other.idannee))) {
/* 256 */       return false;
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 263 */     return "entities.Annee[ idannee=" + this.idannee + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Annee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */