/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ @Entity
/*     */ @Table(name = "nature_t")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "NatureT.findAll", query = "SELECT n FROM NatureT n"), @NamedQuery(name = "NatureT.findByIdnatureT", query = "SELECT n FROM NatureT n WHERE n.idnatureT = :idnatureT"), @NamedQuery(name = "NatureT.findByNom", query = "SELECT n FROM NatureT n WHERE n.nom = :nom")})
/*     */ public class NatureT
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idnature_t")
/*     */   private Integer idnatureT;
/*     */   @Size(max = 40)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @OneToMany(mappedBy = "idnatureT", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   @JoinColumn(name = "idnaturetache", referencedColumnName = "idnaturetache")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Naturetache idnaturetache;
/*     */   @OneToMany(mappedBy = "idnatureT", fetch = FetchType.LAZY)
/*     */   private List<ExerciceNatureT> exerciceNatureTList;
/*     */   
/*     */   public NatureT() {}
/*     */   
/*     */   public NatureT(Integer idnatureT) {
/*  60 */     this.idnatureT = idnatureT;
/*     */   }
/*     */   
/*     */   public Integer getIdnatureT() {
/*  64 */     return this.idnatureT;
/*     */   }
/*     */   
/*     */   public void setIdnatureT(Integer idnatureT) {
/*  68 */     this.idnatureT = idnatureT;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  72 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  76 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tache> getTacheList() {
/*  81 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/*  85 */     this.tacheList = tacheList;
/*     */   }
/*     */   
/*     */   public Naturetache getIdnaturetache() {
/*  89 */     return this.idnaturetache;
/*     */   }
/*     */   
/*     */   public void setIdnaturetache(Naturetache idnaturetache) {
/*  93 */     this.idnaturetache = idnaturetache;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<ExerciceNatureT> getExerciceNatureTList() {
/*  98 */     return this.exerciceNatureTList;
/*     */   }
/*     */   
/*     */   public void setExerciceNatureTList(List<ExerciceNatureT> exerciceNatureTList) {
/* 102 */     this.exerciceNatureTList = exerciceNatureTList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 107 */     int hash = 0;
/* 108 */     hash += (this.idnatureT != null) ? this.idnatureT.hashCode() : 0;
/* 109 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 115 */     if (!(object instanceof NatureT)) {
/* 116 */       return false;
/*     */     }
/* 118 */     NatureT other = (NatureT)object;
/* 119 */     if ((this.idnatureT == null && other.idnatureT != null) || (this.idnatureT != null && !this.idnatureT.equals(other.idnatureT))) {
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 127 */     return "entities.NatureT[ idnatureT=" + this.idnatureT + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\NatureT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */