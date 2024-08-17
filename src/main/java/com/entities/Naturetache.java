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
/*     */ @Table(name = "naturetache")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Naturetache.findAll", query = "SELECT n FROM Naturetache n"), @NamedQuery(name = "Naturetache.findByIdnaturetache", query = "SELECT n FROM Naturetache n WHERE n.idnaturetache = :idnaturetache"), @NamedQuery(name = "Naturetache.findByNom", query = "SELECT n FROM Naturetache n WHERE n.nom = :nom")})
/*     */ public class Naturetache
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idnaturetache")
/*     */   private Integer idnaturetache;
/*     */   @Size(max = 15)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @OneToMany(mappedBy = "idnaturetache", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   @OneToMany(mappedBy = "idnature", fetch = FetchType.LAZY)
/*     */   private List<ExerciceNature> exerciceNatureList;
/*     */   @OneToMany(mappedBy = "idnaturetache", fetch = FetchType.LAZY)
/*     */   private List<NatureT> natureTList;
/*     */   
/*     */   public Naturetache() {}
/*     */   
/*     */   public Naturetache(Integer idnaturetache) {
/*  57 */     this.idnaturetache = idnaturetache;
/*     */   }
/*     */   
/*     */   public Integer getIdnaturetache() {
/*  61 */     return this.idnaturetache;
/*     */   }
/*     */   
/*     */   public void setIdnaturetache(Integer idnaturetache) {
/*  65 */     this.idnaturetache = idnaturetache;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  69 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  73 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tache> getTacheList() {
/*  78 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/*  82 */     this.tacheList = tacheList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<ExerciceNature> getExerciceNatureList() {
/*  87 */     return this.exerciceNatureList;
/*     */   }
/*     */   
/*     */   public void setExerciceNatureList(List<ExerciceNature> exerciceNatureList) {
/*  91 */     this.exerciceNatureList = exerciceNatureList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<NatureT> getNatureTList() {
/*  96 */     return this.natureTList;
/*     */   }
/*     */   
/*     */   public void setNatureTList(List<NatureT> natureTList) {
/* 100 */     this.natureTList = natureTList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     int hash = 0;
/* 106 */     hash += (this.idnaturetache != null) ? this.idnaturetache.hashCode() : 0;
/* 107 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 113 */     if (!(object instanceof Naturetache)) {
/* 114 */       return false;
/*     */     }
/* 116 */     Naturetache other = (Naturetache)object;
/* 117 */     if ((this.idnaturetache == null && other.idnaturetache != null) || (this.idnaturetache != null && !this.idnaturetache.equals(other.idnaturetache))) {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     return "entities.Naturetache[ idnaturetache=" + this.idnaturetache + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Naturetache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */