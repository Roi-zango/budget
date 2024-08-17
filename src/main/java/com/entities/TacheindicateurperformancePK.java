/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Embeddable;
/*    */ import javax.validation.constraints.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Embeddable
/*    */ public class TacheindicateurperformancePK
/*    */   implements Serializable
/*    */ {
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idindicateurperformance")
/*    */   private long idindicateurperformance;
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idtache")
/*    */   private long idtache;
/*    */   
/*    */   public TacheindicateurperformancePK() {}
/*    */   
/*    */   public TacheindicateurperformancePK(long idindicateurperformance, long idtache) {
/* 33 */     this.idindicateurperformance = idindicateurperformance;
/* 34 */     this.idtache = idtache;
/*    */   }
/*    */   
/*    */   public long getIdindicateurperformance() {
/* 38 */     return this.idindicateurperformance;
/*    */   }
/*    */   
/*    */   public void setIdindicateurperformance(long idindicateurperformance) {
/* 42 */     this.idindicateurperformance = idindicateurperformance;
/*    */   }
/*    */   
/*    */   public long getIdtache() {
/* 46 */     return this.idtache;
/*    */   }
/*    */   
/*    */   public void setIdtache(long idtache) {
/* 50 */     this.idtache = idtache;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int hash = 0;
/* 56 */     hash += (int)this.idindicateurperformance;
/* 57 */     hash += (int)this.idtache;
/* 58 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 64 */     if (!(object instanceof TacheindicateurperformancePK)) {
/* 65 */       return false;
/*    */     }
/* 67 */     TacheindicateurperformancePK other = (TacheindicateurperformancePK)object;
/* 68 */     if (this.idindicateurperformance != other.idindicateurperformance) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (this.idtache != other.idtache) {
/* 72 */       return false;
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "entities.TacheindicateurperformancePK[ idindicateurperformance=" + this.idindicateurperformance + ", idtache=" + this.idtache + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\TacheindicateurperformancePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */