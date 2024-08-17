/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Entity
/*     */ @Table(name = "exercice")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Exercice.findAll", query = "SELECT e FROM Exercice e"), @NamedQuery(name = "Exercice.findByCoutglobal", query = "SELECT e FROM Exercice e WHERE e.coutglobal = :coutglobal"), @NamedQuery(name = "Exercice.findByNomExercice", query = "SELECT e FROM Exercice e WHERE e.nomExercice = :nomExercice"), @NamedQuery(name = "Exercice.findByDateEnregistre", query = "SELECT e FROM Exercice e WHERE e.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Exercice.findByEtat", query = "SELECT e FROM Exercice e WHERE e.etat = :etat"), @NamedQuery(name = "Exercice.findByDerniereModif", query = "SELECT e FROM Exercice e WHERE e.derniereModif = :derniereModif"), @NamedQuery(name = "Exercice.findByIdexercice", query = "SELECT e FROM Exercice e WHERE e.idexercice = :idexercice"), @NamedQuery(name = "Exercice.findByMontantaccorde", query = "SELECT e FROM Exercice e WHERE e.montantaccorde = :montantaccorde"), @NamedQuery(name = "Exercice.findByIspublic", query = "SELECT e FROM Exercice e WHERE e.ispublic = :ispublic"), @NamedQuery(name = "Exercice.findByPropbudgetsante", query = "SELECT e FROM Exercice e WHERE e.propbudgetsante = :propbudgetsante")})
/*     */ public class Exercice
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Column(name = "coutglobal")
/*     */   private Double coutglobal;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom_exercice")
/*     */   private String nomExercice;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idexercice")
/*     */   private Integer idexercice;
/*     */   @Column(name = "montantaccorde")
/*     */   private Double montantaccorde;
/*     */   @Column(name = "ispublic")
/*     */   private Boolean ispublic;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "propbudgetsante")
/*     */   private String propbudgetsante;
/*     */   @OneToMany(mappedBy = "idexercice", fetch = FetchType.LAZY)
/*     */   private List<ExerciceNatureT> exerciceNatureTList;
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Institution idinstitution;
/*     */   
/*     */   public Exercice() {}
/*     */   
/*     */   public Exercice(Integer idexercice) {
/*  90 */     this.idexercice = idexercice;
/*     */   }
/*     */   
/*     */   public Double getCoutglobal() {
/*  94 */     return this.coutglobal;
/*     */   }
/*     */   
/*     */   public void setCoutglobal(Double coutglobal) {
/*  98 */     this.coutglobal = coutglobal;
/*     */   }
/*     */   
/*     */   public String getNomExercice() {
/* 102 */     return this.nomExercice;
/*     */   }
/*     */   
/*     */   public void setNomExercice(String nomExercice) {
/* 106 */     this.nomExercice = nomExercice;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 110 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 114 */     this.dateEnregistre = dateEnregistre;
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
/*     */   public Date getDerniereModif() {
/* 126 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 130 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Integer getIdexercice() {
/* 134 */     return this.idexercice;
/*     */   }
/*     */   
/*     */   public void setIdexercice(Integer idexercice) {
/* 138 */     this.idexercice = idexercice;
/*     */   }
/*     */   
/*     */   public Double getMontantaccorde() {
/* 142 */     return this.montantaccorde;
/*     */   }
/*     */   
/*     */   public void setMontantaccorde(Double montantaccorde) {
/* 146 */     this.montantaccorde = montantaccorde;
/*     */   }
/*     */   
/*     */   public Boolean getIspublic() {
/* 150 */     return this.ispublic;
/*     */   }
/*     */   
/*     */   public void setIspublic(Boolean ispublic) {
/* 154 */     this.ispublic = ispublic;
/*     */   }
/*     */   
/*     */   public String getPropbudgetsante() {
/* 158 */     return this.propbudgetsante;
/*     */   }
/*     */   
/*     */   public void setPropbudgetsante(String propbudgetsante) {
/* 162 */     this.propbudgetsante = propbudgetsante;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<ExerciceNatureT> getExerciceNatureTList() {
/* 167 */     return this.exerciceNatureTList;
/*     */   }
/*     */   
/*     */   public void setExerciceNatureTList(List<ExerciceNatureT> exerciceNatureTList) {
/* 171 */     this.exerciceNatureTList = exerciceNatureTList;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 175 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 179 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Institution getIdinstitution() {
/* 183 */     return this.idinstitution;
/*     */   }
/*     */   
/*     */   public void setIdinstitution(Institution idinstitution) {
/* 187 */     this.idinstitution = idinstitution;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 192 */     int hash = 0;
/* 193 */     hash += (this.idexercice != null) ? this.idexercice.hashCode() : 0;
/* 194 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 200 */     if (!(object instanceof Exercice)) {
/* 201 */       return false;
/*     */     }
/* 203 */     Exercice other = (Exercice)object;
/* 204 */     if ((this.idexercice == null && other.idexercice != null) || (this.idexercice != null && !this.idexercice.equals(other.idexercice))) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 212 */     return "entities.Exercice[ idexercice=" + this.idexercice + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Exercice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */