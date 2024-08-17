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
/*    */ public class ActivitetypestructurePK
/*    */   implements Serializable
/*    */ {
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idactivite")
/*    */   private long idactivite;
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idtypestructure")
/*    */   private long idtypestructure;
/*    */   
/*    */   public ActivitetypestructurePK() {}
/*    */   
/*    */   public ActivitetypestructurePK(long idactivite, long idtypestructure) {
/* 33 */     this.idactivite = idactivite;
/* 34 */     this.idtypestructure = idtypestructure;
/*    */   }
/*    */   
/*    */   public long getIdactivite() {
/* 38 */     return this.idactivite;
/*    */   }
/*    */   
/*    */   public void setIdactivite(long idactivite) {
/* 42 */     this.idactivite = idactivite;
/*    */   }
/*    */   
/*    */   public long getIdtypestructure() {
/* 46 */     return this.idtypestructure;
/*    */   }
/*    */   
/*    */   public void setIdtypestructure(long idtypestructure) {
/* 50 */     this.idtypestructure = idtypestructure;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int hash = 0;
/* 56 */     hash += (int)this.idactivite;
/* 57 */     hash += (int)this.idtypestructure;
/* 58 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 64 */     if (!(object instanceof ActivitetypestructurePK)) {
/* 65 */       return false;
/*    */     }
/* 67 */     ActivitetypestructurePK other = (ActivitetypestructurePK)object;
/* 68 */     if (this.idactivite != other.idactivite) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (this.idtypestructure != other.idtypestructure) {
/* 72 */       return false;
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "entities.ActivitetypestructurePK[ idactivite=" + this.idactivite + ", idtypestructure=" + this.idtypestructure + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ActivitetypestructurePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */