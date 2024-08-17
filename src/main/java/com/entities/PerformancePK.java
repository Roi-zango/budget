/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Embeddable;
/*     */ import javax.validation.constraints.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Embeddable
/*     */ public class PerformancePK
/*     */   implements Serializable
/*     */ {
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idindicateurperformance")
/*     */   private long idindicateurperformance;
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idstructure")
/*     */   private long idstructure;
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idmission")
/*     */   private long idmission;
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idactivite")
/*     */   private long idactivite;
/*     */   
/*     */   public PerformancePK() {}
/*     */   
/*     */   public PerformancePK(long idindicateurperformance, long idstructure, long idmission, long idactivite) {
/*  41 */     this.idindicateurperformance = idindicateurperformance;
/*  42 */     this.idstructure = idstructure;
/*  43 */     this.idmission = idmission;
/*  44 */     this.idactivite = idactivite;
/*     */   }
/*     */   
/*     */   public long getIdindicateurperformance() {
/*  48 */     return this.idindicateurperformance;
/*     */   }
/*     */   
/*     */   public void setIdindicateurperformance(long idindicateurperformance) {
/*  52 */     this.idindicateurperformance = idindicateurperformance;
/*     */   }
/*     */   
/*     */   public long getIdstructure() {
/*  56 */     return this.idstructure;
/*     */   }
/*     */   
/*     */   public void setIdstructure(long idstructure) {
/*  60 */     this.idstructure = idstructure;
/*     */   }
/*     */   
/*     */   public long getIdmission() {
/*  64 */     return this.idmission;
/*     */   }
/*     */   
/*     */   public void setIdmission(long idmission) {
/*  68 */     this.idmission = idmission;
/*     */   }
/*     */   
/*     */   public long getIdactivite() {
/*  72 */     return this.idactivite;
/*     */   }
/*     */   
/*     */   public void setIdactivite(long idactivite) {
/*  76 */     this.idactivite = idactivite;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  81 */     int hash = 0;
/*  82 */     hash += (int)this.idindicateurperformance;
/*  83 */     hash += (int)this.idstructure;
/*  84 */     hash += (int)this.idmission;
/*  85 */     hash += (int)this.idactivite;
/*  86 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*  92 */     if (!(object instanceof PerformancePK)) {
/*  93 */       return false;
/*     */     }
/*  95 */     PerformancePK other = (PerformancePK)object;
/*  96 */     if (this.idindicateurperformance != other.idindicateurperformance) {
/*  97 */       return false;
/*     */     }
/*  99 */     if (this.idstructure != other.idstructure) {
/* 100 */       return false;
/*     */     }
/* 102 */     if (this.idmission != other.idmission) {
/* 103 */       return false;
/*     */     }
/* 105 */     if (this.idactivite != other.idactivite) {
/* 106 */       return false;
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     return "entities.PerformancePK[ idindicateurperformance=" + this.idindicateurperformance + ", idstructure=" + this.idstructure + ", idmission=" + this.idmission + ", idactivite=" + this.idactivite + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\PerformancePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */