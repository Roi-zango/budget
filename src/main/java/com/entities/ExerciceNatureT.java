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
/*     */ @Entity
/*     */ @Table(name = "exercice_nature_t")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "ExerciceNatureT.findAll", query = "SELECT e FROM ExerciceNatureT e"), @NamedQuery(name = "ExerciceNatureT.findByIdexercicenatureT", query = "SELECT e FROM ExerciceNatureT e WHERE e.idexercicenatureT = :idexercicenatureT"), @NamedQuery(name = "ExerciceNatureT.findByPourcentage", query = "SELECT e FROM ExerciceNatureT e WHERE e.pourcentage = :pourcentage"), @NamedQuery(name = "ExerciceNatureT.findByMontant", query = "SELECT e FROM ExerciceNatureT e WHERE e.montant = :montant")})
/*     */ public class ExerciceNatureT
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idexercicenature_t")
/*     */   private Integer idexercicenatureT;
/*     */   @Column(name = "pourcentage")
/*     */   private Double pourcentage;
/*     */   @Column(name = "montant")
/*     */   private Double montant;
/*     */   @JoinColumn(name = "idexercice", referencedColumnName = "idexercice")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Exercice idexercice;
/*     */   @JoinColumn(name = "idnature_t", referencedColumnName = "idnature_t")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private NatureT idnatureT;
/*     */   
/*     */   public ExerciceNatureT() {}
/*     */   
/*     */   public ExerciceNatureT(Integer idexercicenatureT) {
/*  58 */     this.idexercicenatureT = idexercicenatureT;
/*     */   }
/*     */   
/*     */   public Integer getIdexercicenatureT() {
/*  62 */     return this.idexercicenatureT;
/*     */   }
/*     */   
/*     */   public void setIdexercicenatureT(Integer idexercicenatureT) {
/*  66 */     this.idexercicenatureT = idexercicenatureT;
/*     */   }
/*     */   
/*     */   public Double getPourcentage() {
/*  70 */     return this.pourcentage;
/*     */   }
/*     */   
/*     */   public void setPourcentage(Double pourcentage) {
/*  74 */     this.pourcentage = pourcentage;
/*     */   }
/*     */   
/*     */   public Double getMontant() {
/*  78 */     return this.montant;
/*     */   }
/*     */   
/*     */   public void setMontant(Double montant) {
/*  82 */     this.montant = montant;
/*     */   }
/*     */   
/*     */   public Exercice getIdexercice() {
/*  86 */     return this.idexercice;
/*     */   }
/*     */   
/*     */   public void setIdexercice(Exercice idexercice) {
/*  90 */     this.idexercice = idexercice;
/*     */   }
/*     */   
/*     */   public NatureT getIdnatureT() {
/*  94 */     return this.idnatureT;
/*     */   }
/*     */   
/*     */   public void setIdnatureT(NatureT idnatureT) {
/*  98 */     this.idnatureT = idnatureT;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 103 */     int hash = 0;
/* 104 */     hash += (this.idexercicenatureT != null) ? this.idexercicenatureT.hashCode() : 0;
/* 105 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 111 */     if (!(object instanceof ExerciceNatureT)) {
/* 112 */       return false;
/*     */     }
/* 114 */     ExerciceNatureT other = (ExerciceNatureT)object;
/* 115 */     if ((this.idexercicenatureT == null && other.idexercicenatureT != null) || (this.idexercicenatureT != null && !this.idexercicenatureT.equals(other.idexercicenatureT))) {
/* 116 */       return false;
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     return "entities.ExerciceNatureT[ idexercicenatureT=" + this.idexercicenatureT + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ExerciceNatureT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */