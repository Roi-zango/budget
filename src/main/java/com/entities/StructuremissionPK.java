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
/*    */ public class StructuremissionPK
/*    */   implements Serializable
/*    */ {
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idstructure")
/*    */   private long idstructure;
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idmission")
/*    */   private long idmission;
/*    */   
/*    */   public StructuremissionPK() {}
/*    */   
/*    */   public StructuremissionPK(long idstructure, long idmission) {
/* 33 */     this.idstructure = idstructure;
/* 34 */     this.idmission = idmission;
/*    */   }
/*    */   
/*    */   public long getIdstructure() {
/* 38 */     return this.idstructure;
/*    */   }
/*    */   
/*    */   public void setIdstructure(long idstructure) {
/* 42 */     this.idstructure = idstructure;
/*    */   }
/*    */   
/*    */   public long getIdmission() {
/* 46 */     return this.idmission;
/*    */   }
/*    */   
/*    */   public void setIdmission(long idmission) {
/* 50 */     this.idmission = idmission;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int hash = 0;
/* 56 */     hash += (int)this.idstructure;
/* 57 */     hash += (int)this.idmission;
/* 58 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 64 */     if (!(object instanceof StructuremissionPK)) {
/* 65 */       return false;
/*    */     }
/* 67 */     StructuremissionPK other = (StructuremissionPK)object;
/* 68 */     if (this.idstructure != other.idstructure) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (this.idmission != other.idmission) {
/* 72 */       return false;
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "entities.StructuremissionPK[ idstructure=" + this.idstructure + ", idmission=" + this.idmission + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\StructuremissionPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */