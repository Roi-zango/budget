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
/*     */ import javax.validation.constraints.Size;
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
/*     */ @Table(name = "indicateurextrant")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Indicateurextrant.findAll", query = "SELECT i FROM Indicateurextrant i"), @NamedQuery(name = "Indicateurextrant.findByIdextrant", query = "SELECT i FROM Indicateurextrant i WHERE i.indicateurextrantPK.idextrant = :idextrant"), @NamedQuery(name = "Indicateurextrant.findByIdindicateuractivite", query = "SELECT i FROM Indicateurextrant i WHERE i.indicateurextrantPK.idindicateuractivite = :idindicateuractivite"), @NamedQuery(name = "Indicateurextrant.findByCible", query = "SELECT i FROM Indicateurextrant i WHERE i.cible = :cible"), @NamedQuery(name = "Indicateurextrant.findByObservation", query = "SELECT i FROM Indicateurextrant i WHERE i.observation = :observation")})
/*     */ public class Indicateurextrant
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected IndicateurextrantPK indicateurextrantPK;
/*     */   @Column(name = "cible")
/*     */   private Double cible;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "observation")
/*     */   private String observation;
/*     */   @JoinColumn(name = "idextrant", referencedColumnName = "idextrant", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Extrant extrant;
/*     */   
/*     */   public Indicateurextrant() {}
/*     */   
/*     */   public Indicateurextrant(IndicateurextrantPK indicateurextrantPK) {
/*  52 */     this.indicateurextrantPK = indicateurextrantPK;
/*     */   }
/*     */   
/*     */   public Indicateurextrant(long idextrant, long idindicateuractivite) {
/*  56 */     this.indicateurextrantPK = new IndicateurextrantPK(idextrant, idindicateuractivite);
/*     */   }
/*     */   
/*     */   public IndicateurextrantPK getIndicateurextrantPK() {
/*  60 */     return this.indicateurextrantPK;
/*     */   }
/*     */   
/*     */   public void setIndicateurextrantPK(IndicateurextrantPK indicateurextrantPK) {
/*  64 */     this.indicateurextrantPK = indicateurextrantPK;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/*  68 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/*  72 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/*  76 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/*  80 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public Extrant getExtrant() {
/*  84 */     return this.extrant;
/*     */   }
/*     */   
/*     */   public void setExtrant(Extrant extrant) {
/*  88 */     this.extrant = extrant;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  93 */     int hash = 0;
/*  94 */     hash += (this.indicateurextrantPK != null) ? this.indicateurextrantPK.hashCode() : 0;
/*  95 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 101 */     if (!(object instanceof Indicateurextrant)) {
/* 102 */       return false;
/*     */     }
/* 104 */     Indicateurextrant other = (Indicateurextrant)object;
/* 105 */     if ((this.indicateurextrantPK == null && other.indicateurextrantPK != null) || (this.indicateurextrantPK != null && !this.indicateurextrantPK.equals(other.indicateurextrantPK))) {
/* 106 */       return false;
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     return "entities.Indicateurextrant[ indicateurextrantPK=" + this.indicateurextrantPK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurextrant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */