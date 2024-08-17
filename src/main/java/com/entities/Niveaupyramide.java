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
/*     */ @Entity
/*     */ @Table(name = "niveaupyramide")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Niveaupyramide.findAll", query = "SELECT n FROM Niveaupyramide n"), @NamedQuery(name = "Niveaupyramide.findByIdniveaupyramide", query = "SELECT n FROM Niveaupyramide n WHERE n.idniveaupyramide = :idniveaupyramide"), @NamedQuery(name = "Niveaupyramide.findByCode", query = "SELECT n FROM Niveaupyramide n WHERE n.code = :code"), @NamedQuery(name = "Niveaupyramide.findByNom", query = "SELECT n FROM Niveaupyramide n WHERE n.nom = :nom"), @NamedQuery(name = "Niveaupyramide.findByEtat", query = "SELECT n FROM Niveaupyramide n WHERE n.etat = :etat"), @NamedQuery(name = "Niveaupyramide.findByDateEnregistre", query = "SELECT n FROM Niveaupyramide n WHERE n.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Niveaupyramide.findByDerniereModif", query = "SELECT n FROM Niveaupyramide n WHERE n.derniereModif = :derniereModif")})
/*     */ public class Niveaupyramide
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idniveaupyramide")
/*     */   private Long idniveaupyramide;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 1024)
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
/*     */   @OneToMany(mappedBy = "idniveaupyramide", fetch = FetchType.LAZY)
/*     */   private List<Indicateurperformance> indicateurperformanceList;
/*     */   @OneToMany(mappedBy = "idniveaupyramide", fetch = FetchType.LAZY)
/*     */   private List<Mission> missionList;
/*     */   @OneToMany(mappedBy = "idniveaupyramide", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   @OneToMany(mappedBy = "idniveaupyramide", fetch = FetchType.LAZY)
/*     */   private List<Pyramide> pyramideList;
/*     */   
/*     */   public Niveaupyramide() {}
/*     */   
/*     */   public Niveaupyramide(Long idniveaupyramide) {
/*  77 */     this.idniveaupyramide = idniveaupyramide;
/*     */   }
/*     */   
/*     */   public Long getIdniveaupyramide() {
/*  81 */     return this.idniveaupyramide;
/*     */   }
/*     */   
/*     */   public void setIdniveaupyramide(Long idniveaupyramide) {
/*  85 */     this.idniveaupyramide = idniveaupyramide;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  89 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  93 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  97 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 101 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 105 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 109 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 113 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 117 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 121 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 125 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurperformance> getIndicateurperformanceList() {
/* 130 */     return this.indicateurperformanceList;
/*     */   }
/*     */   
/*     */   public void setIndicateurperformanceList(List<Indicateurperformance> indicateurperformanceList) {
/* 134 */     this.indicateurperformanceList = indicateurperformanceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Mission> getMissionList() {
/* 139 */     return this.missionList;
/*     */   }
/*     */   
/*     */   public void setMissionList(List<Mission> missionList) {
/* 143 */     this.missionList = missionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 148 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 152 */     this.structureList = structureList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Pyramide> getPyramideList() {
/* 157 */     return this.pyramideList;
/*     */   }
/*     */   
/*     */   public void setPyramideList(List<Pyramide> pyramideList) {
/* 161 */     this.pyramideList = pyramideList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 166 */     int hash = 0;
/* 167 */     hash += (this.idniveaupyramide != null) ? this.idniveaupyramide.hashCode() : 0;
/* 168 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 174 */     if (!(object instanceof Niveaupyramide)) {
/* 175 */       return false;
/*     */     }
/* 177 */     Niveaupyramide other = (Niveaupyramide)object;
/* 178 */     if ((this.idniveaupyramide == null && other.idniveaupyramide != null) || (this.idniveaupyramide != null && !this.idniveaupyramide.equals(other.idniveaupyramide))) {
/* 179 */       return false;
/*     */     }
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     return "entities.Niveaupyramide[ idniveaupyramide=" + this.idniveaupyramide + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Niveaupyramide.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */