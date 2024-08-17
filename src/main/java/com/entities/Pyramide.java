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
/*     */ @Entity
/*     */ @Table(name = "pyramide")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Pyramide.findAll", query = "SELECT p FROM Pyramide p"), @NamedQuery(name = "Pyramide.findByIdpyramide", query = "SELECT p FROM Pyramide p WHERE p.idpyramide = :idpyramide"), @NamedQuery(name = "Pyramide.findByIdpyramideratachement", query = "SELECT p FROM Pyramide p WHERE p.idpyramideratachement = :idpyramideratachement"), @NamedQuery(name = "Pyramide.findByNom", query = "SELECT p FROM Pyramide p WHERE p.nom = :nom"), @NamedQuery(name = "Pyramide.findBySuperficie", query = "SELECT p FROM Pyramide p WHERE p.superficie = :superficie"), @NamedQuery(name = "Pyramide.findByPopulation", query = "SELECT p FROM Pyramide p WHERE p.population = :population"), @NamedQuery(name = "Pyramide.findByEtat", query = "SELECT p FROM Pyramide p WHERE p.etat = :etat"), @NamedQuery(name = "Pyramide.findByDateEnregistre", query = "SELECT p FROM Pyramide p WHERE p.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Pyramide.findByDerniereModif", query = "SELECT p FROM Pyramide p WHERE p.derniereModif = :derniereModif")})
/*     */ public class Pyramide
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idpyramide")
/*     */   private Long idpyramide;
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idpyramideratachement")
/*     */   private long idpyramideratachement;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "superficie")
/*     */   private Double superficie;
/*     */   @Column(name = "population")
/*     */   private Double population;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idpyramide", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   @JoinColumn(name = "idniveaupyramide", referencedColumnName = "idniveaupyramide")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Niveaupyramide idniveaupyramide;
/*     */   
/*     */   public Pyramide() {}
/*     */   
/*     */   public Pyramide(Long idpyramide) {
/*  84 */     this.idpyramide = idpyramide;
/*     */   }
/*     */   
/*     */   public Pyramide(Long idpyramide, long idpyramideratachement) {
/*  88 */     this.idpyramide = idpyramide;
/*  89 */     this.idpyramideratachement = idpyramideratachement;
/*     */   }
/*     */   
/*     */   public Long getIdpyramide() {
/*  93 */     return this.idpyramide;
/*     */   }
/*     */   
/*     */   public void setIdpyramide(Long idpyramide) {
/*  97 */     this.idpyramide = idpyramide;
/*     */   }
/*     */   
/*     */   public long getIdpyramideratachement() {
/* 101 */     return this.idpyramideratachement;
/*     */   }
/*     */   
/*     */   public void setIdpyramideratachement(long idpyramideratachement) {
/* 105 */     this.idpyramideratachement = idpyramideratachement;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 109 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 113 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Double getSuperficie() {
/* 117 */     return this.superficie;
/*     */   }
/*     */   
/*     */   public void setSuperficie(Double superficie) {
/* 121 */     this.superficie = superficie;
/*     */   }
/*     */   
/*     */   public Double getPopulation() {
/* 125 */     return this.population;
/*     */   }
/*     */   
/*     */   public void setPopulation(Double population) {
/* 129 */     this.population = population;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 133 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 137 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 141 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 145 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 149 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 153 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 158 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 162 */     this.structureList = structureList;
/*     */   }
/*     */   
/*     */   public Niveaupyramide getIdniveaupyramide() {
/* 166 */     return this.idniveaupyramide;
/*     */   }
/*     */   
/*     */   public void setIdniveaupyramide(Niveaupyramide idniveaupyramide) {
/* 170 */     this.idniveaupyramide = idniveaupyramide;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 175 */     int hash = 0;
/* 176 */     hash += (this.idpyramide != null) ? this.idpyramide.hashCode() : 0;
/* 177 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 183 */     if (!(object instanceof Pyramide)) {
/* 184 */       return false;
/*     */     }
/* 186 */     Pyramide other = (Pyramide)object;
/* 187 */     if ((this.idpyramide == null && other.idpyramide != null) || (this.idpyramide != null && !this.idpyramide.equals(other.idpyramide))) {
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 195 */     return "entities.Pyramide[ idpyramide=" + this.idpyramide + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Pyramide.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */