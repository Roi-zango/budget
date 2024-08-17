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
/*    */ public class StructuremissionactivitePK
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
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idactivite")
/*    */   private long idactivite;
/*    */   
/*    */   public StructuremissionactivitePK() {}
/*    */   
/*    */   public StructuremissionactivitePK(long idstructure, long idmission, long idactivite) {
/* 37 */     this.idstructure = idstructure;
/* 38 */     this.idmission = idmission;
/* 39 */     this.idactivite = idactivite;
/*    */   }
/*    */   
/*    */   public long getIdstructure() {
/* 43 */     return this.idstructure;
/*    */   }
/*    */   
/*    */   public void setIdstructure(long idstructure) {
/* 47 */     this.idstructure = idstructure;
/*    */   }
/*    */   
/*    */   public long getIdmission() {
/* 51 */     return this.idmission;
/*    */   }
/*    */   
/*    */   public void setIdmission(long idmission) {
/* 55 */     this.idmission = idmission;
/*    */   }
/*    */   
/*    */   public long getIdactivite() {
/* 59 */     return this.idactivite;
/*    */   }
/*    */   
/*    */   public void setIdactivite(long idactivite) {
/* 63 */     this.idactivite = idactivite;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 68 */     int hash = 0;
/* 69 */     hash += (int)this.idstructure;
/* 70 */     hash += (int)this.idmission;
/* 71 */     hash += (int)this.idactivite;
/* 72 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 78 */     if (!(object instanceof StructuremissionactivitePK)) {
/* 79 */       return false;
/*    */     }
/* 81 */     StructuremissionactivitePK other = (StructuremissionactivitePK)object;
/* 82 */     if (this.idstructure != other.idstructure) {
/* 83 */       return false;
/*    */     }
/* 85 */     if (this.idmission != other.idmission) {
/* 86 */       return false;
/*    */     }
/* 88 */     if (this.idactivite != other.idactivite) {
/* 89 */       return false;
/*    */     }
/* 91 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 96 */     return "entities.StructuremissionactivitePK[ idstructure=" + this.idstructure + ", idmission=" + this.idmission + ", idactivite=" + this.idactivite + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\StructuremissionactivitePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */