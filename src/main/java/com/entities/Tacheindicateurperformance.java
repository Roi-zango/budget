/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.EmbeddedId;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
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
/*     */ @Table(name = "tacheindicateurperformance")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Tacheindicateurperformance.findAll", query = "SELECT t FROM Tacheindicateurperformance t"), @NamedQuery(name = "Tacheindicateurperformance.findByIdindicateurperformance", query = "SELECT t FROM Tacheindicateurperformance t WHERE t.tacheindicateurperformancePK.idindicateurperformance = :idindicateurperformance"), @NamedQuery(name = "Tacheindicateurperformance.findByIdtache", query = "SELECT t FROM Tacheindicateurperformance t WHERE t.tacheindicateurperformancePK.idtache = :idtache"), @NamedQuery(name = "Tacheindicateurperformance.findByCout", query = "SELECT t FROM Tacheindicateurperformance t WHERE t.cout = :cout")})
/*     */ public class Tacheindicateurperformance
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected TacheindicateurperformancePK tacheindicateurperformancePK;
/*     */   @Column(name = "cout")
/*     */   private Double cout;
/*     */   @JoinColumn(name = "idindicateurperformance", referencedColumnName = "idindicateurperformance", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Indicateurperformance indicateurperformance;
/*     */   @JoinColumn(name = "idtache", referencedColumnName = "idtache", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Tache tache;
/*     */   
/*     */   public Tacheindicateurperformance() {}
/*     */   
/*     */   public Tacheindicateurperformance(TacheindicateurperformancePK tacheindicateurperformancePK) {
/*  50 */     this.tacheindicateurperformancePK = tacheindicateurperformancePK;
/*     */   }
/*     */   
/*     */   public Tacheindicateurperformance(long idindicateurperformance, long idtache) {
/*  54 */     this.tacheindicateurperformancePK = new TacheindicateurperformancePK(idindicateurperformance, idtache);
/*     */   }
/*     */   
/*     */   public TacheindicateurperformancePK getTacheindicateurperformancePK() {
/*  58 */     return this.tacheindicateurperformancePK;
/*     */   }
/*     */   
/*     */   public void setTacheindicateurperformancePK(TacheindicateurperformancePK tacheindicateurperformancePK) {
/*  62 */     this.tacheindicateurperformancePK = tacheindicateurperformancePK;
/*     */   }
/*     */   
/*     */   public Double getCout() {
/*  66 */     return this.cout;
/*     */   }
/*     */   
/*     */   public void setCout(Double cout) {
/*  70 */     this.cout = cout;
/*     */   }
/*     */   
/*     */   public Indicateurperformance getIndicateurperformance() {
/*  74 */     return this.indicateurperformance;
/*     */   }
/*     */   
/*     */   public void setIndicateurperformance(Indicateurperformance indicateurperformance) {
/*  78 */     this.indicateurperformance = indicateurperformance;
/*     */   }
/*     */   
/*     */   public Tache getTache() {
/*  82 */     return this.tache;
/*     */   }
/*     */   
/*     */   public void setTache(Tache tache) {
/*  86 */     this.tache = tache;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     int hash = 0;
/*  92 */     hash += (this.tacheindicateurperformancePK != null) ? this.tacheindicateurperformancePK.hashCode() : 0;
/*  93 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*  99 */     if (!(object instanceof Tacheindicateurperformance)) {
/* 100 */       return false;
/*     */     }
/* 102 */     Tacheindicateurperformance other = (Tacheindicateurperformance)object;
/* 103 */     if ((this.tacheindicateurperformancePK == null && other.tacheindicateurperformancePK != null) || (this.tacheindicateurperformancePK != null && !this.tacheindicateurperformancePK.equals(other.tacheindicateurperformancePK))) {
/* 104 */       return false;
/*     */     }
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     return "entities.Tacheindicateurperformance[ tacheindicateurperformancePK=" + this.tacheindicateurperformancePK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Tacheindicateurperformance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */