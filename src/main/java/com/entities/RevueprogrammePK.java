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
/*    */ public class RevueprogrammePK
/*    */   implements Serializable
/*    */ {
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idrevue")
/*    */   private long idrevue;
/*    */   @Basic(optional = false)
/*    */   @NotNull
/*    */   @Column(name = "idprogramme")
/*    */   private long idprogramme;
/*    */   
/*    */   public RevueprogrammePK() {}
/*    */   
/*    */   public RevueprogrammePK(long idrevue, long idprogramme) {
/* 33 */     this.idrevue = idrevue;
/* 34 */     this.idprogramme = idprogramme;
/*    */   }
/*    */   
/*    */   public long getIdrevue() {
/* 38 */     return this.idrevue;
/*    */   }
/*    */   
/*    */   public void setIdrevue(long idrevue) {
/* 42 */     this.idrevue = idrevue;
/*    */   }
/*    */   
/*    */   public long getIdprogramme() {
/* 46 */     return this.idprogramme;
/*    */   }
/*    */   
/*    */   public void setIdprogramme(long idprogramme) {
/* 50 */     this.idprogramme = idprogramme;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int hash = 0;
/* 56 */     hash += (int)this.idrevue;
/* 57 */     hash += (int)this.idprogramme;
/* 58 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 64 */     if (!(object instanceof RevueprogrammePK)) {
/* 65 */       return false;
/*    */     }
/* 67 */     RevueprogrammePK other = (RevueprogrammePK)object;
/* 68 */     if (this.idrevue != other.idrevue) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (this.idprogramme != other.idprogramme) {
/* 72 */       return false;
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "entities.RevueprogrammePK[ idrevue=" + this.idrevue + ", idprogramme=" + this.idprogramme + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\RevueprogrammePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */