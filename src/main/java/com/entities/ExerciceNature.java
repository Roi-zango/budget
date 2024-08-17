/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ import javax.persistence.Table;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ @Table(name = "exercice_nature")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "ExerciceNature.findAll", query = "SELECT e FROM ExerciceNature e"), @NamedQuery(name = "ExerciceNature.findByIdexercicenature", query = "SELECT e FROM ExerciceNature e WHERE e.idexercicenature = :idexercicenature"), @NamedQuery(name = "ExerciceNature.findByIdexercice", query = "SELECT e FROM ExerciceNature e WHERE e.idexercice = :idexercice"), @NamedQuery(name = "ExerciceNature.findByPourcentage", query = "SELECT e FROM ExerciceNature e WHERE e.pourcentage = :pourcentage"), @NamedQuery(name = "ExerciceNature.findByMontant", query = "SELECT e FROM ExerciceNature e WHERE e.montant = :montant")})
/*     */ public class ExerciceNature
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idexercicenature")
/*     */   private Integer idexercicenature;
/*     */   @Column(name = "idexercice")
/*     */   private Integer idexercice;
/*     */   @Column(name = "pourcentage")
/*     */   private Double pourcentage;
/*     */   @Column(name = "montant")
/*     */   private Double montant;
/*     */   @JoinColumn(name = "idnature", referencedColumnName = "idnaturetache")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Naturetache idnature;
/*     */   
/*     */   public ExerciceNature() {}
/*     */   
/*     */   public ExerciceNature(Integer idexercicenature) {
/*  58 */     this.idexercicenature = idexercicenature;
/*     */   }
/*     */   
/*     */   public Integer getIdexercicenature() {
/*  62 */     return this.idexercicenature;
/*     */   }
/*     */   
/*     */   public void setIdexercicenature(Integer idexercicenature) {
/*  66 */     this.idexercicenature = idexercicenature;
/*     */   }
/*     */   
/*     */   public Integer getIdexercice() {
/*  70 */     return this.idexercice;
/*     */   }
/*     */   
/*     */   public void setIdexercice(Integer idexercice) {
/*  74 */     this.idexercice = idexercice;
/*     */   }
/*     */   
/*     */   public Double getPourcentage() {
/*  78 */     return this.pourcentage;
/*     */   }
/*     */   
/*     */   public void setPourcentage(Double pourcentage) {
/*  82 */     this.pourcentage = pourcentage;
/*     */   }
/*     */   
/*     */   public Double getMontant() {
/*  86 */     return this.montant;
/*     */   }
/*     */   
/*     */   public void setMontant(Double montant) {
/*  90 */     this.montant = montant;
/*     */   }
/*     */   
/*     */   public Naturetache getIdnature() {
/*  94 */     return this.idnature;
/*     */   }
/*     */   
/*     */   public void setIdnature(Naturetache idnature) {
/*  98 */     this.idnature = idnature;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 103 */     int hash = 0;
/* 104 */     hash += (this.idexercicenature != null) ? this.idexercicenature.hashCode() : 0;
/* 105 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 111 */     if (!(object instanceof ExerciceNature)) {
/* 112 */       return false;
/*     */     }
/* 114 */     ExerciceNature other = (ExerciceNature)object;
/* 115 */     if ((this.idexercicenature == null && other.idexercicenature != null) || (this.idexercicenature != null && !this.idexercicenature.equals(other.idexercicenature))) {
/* 116 */       return false;
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     return "entities.ExerciceNature[ idexercicenature=" + this.idexercicenature + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ExerciceNature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */