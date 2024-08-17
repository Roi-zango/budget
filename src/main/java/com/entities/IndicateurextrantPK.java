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
/*    */ public class IndicateurextrantPK
/*    */   implements Serializable
/*    */ {
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idextrant")
/*    */   private long idextrant;
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idindicateuractivite")
/*    */   private long idindicateuractivite;
/*    */   
/*    */   public IndicateurextrantPK() {}
/*    */   
/*    */   public IndicateurextrantPK(long idextrant, long idindicateuractivite) {
/* 33 */     this.idextrant = idextrant;
/* 34 */     this.idindicateuractivite = idindicateuractivite;
/*    */   }
/*    */   
/*    */   public long getIdextrant() {
/* 38 */     return this.idextrant;
/*    */   }
/*    */   
/*    */   public void setIdextrant(long idextrant) {
/* 42 */     this.idextrant = idextrant;
/*    */   }
/*    */   
/*    */   public long getIdindicateuractivite() {
/* 46 */     return this.idindicateuractivite;
/*    */   }
/*    */   
/*    */   public void setIdindicateuractivite(long idindicateuractivite) {
/* 50 */     this.idindicateuractivite = idindicateuractivite;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int hash = 0;
/* 56 */     hash += (int)this.idextrant;
/* 57 */     hash += (int)this.idindicateuractivite;
/* 58 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 64 */     if (!(object instanceof IndicateurextrantPK)) {
/* 65 */       return false;
/*    */     }
/* 67 */     IndicateurextrantPK other = (IndicateurextrantPK)object;
/* 68 */     if (this.idextrant != other.idextrant) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (this.idindicateuractivite != other.idindicateuractivite) {
/* 72 */       return false;
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "entities.IndicateurextrantPK[ idextrant=" + this.idextrant + ", idindicateuractivite=" + this.idindicateuractivite + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\IndicateurextrantPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */