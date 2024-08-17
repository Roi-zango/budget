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
/*    */ public class CdmtAnneePK
/*    */   implements Serializable
/*    */ {
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idannee")
/*    */   private int idannee;
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idcdmt")
/*    */   private int idcdmt;
/*    */   
/*    */   public CdmtAnneePK() {}
/*    */   
/*    */   public CdmtAnneePK(int idannee, int idcdmt) {
/* 33 */     this.idannee = idannee;
/* 34 */     this.idcdmt = idcdmt;
/*    */   }
/*    */   
/*    */   public int getIdannee() {
/* 38 */     return this.idannee;
/*    */   }
/*    */   
/*    */   public void setIdannee(int idannee) {
/* 42 */     this.idannee = idannee;
/*    */   }
/*    */   
/*    */   public int getIdcdmt() {
/* 46 */     return this.idcdmt;
/*    */   }
/*    */   
/*    */   public void setIdcdmt(int idcdmt) {
/* 50 */     this.idcdmt = idcdmt;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int hash = 0;
/* 56 */     hash += this.idannee;
/* 57 */     hash += this.idcdmt;
/* 58 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 64 */     if (!(object instanceof CdmtAnneePK)) {
/* 65 */       return false;
/*    */     }
/* 67 */     CdmtAnneePK other = (CdmtAnneePK)object;
/* 68 */     if (this.idannee != other.idannee) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (this.idcdmt != other.idcdmt) {
/* 72 */       return false;
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "entities.CdmtAnneePK[ idannee=" + this.idannee + ", idcdmt=" + this.idcdmt + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\CdmtAnneePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */