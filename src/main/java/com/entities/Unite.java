/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ public class Unite
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   private Integer idunite;
/*    */   @Column(length = 40)
/*    */   private String nom;
/*    */   
/*    */   public Unite() {}
/*    */   
/*    */   public Unite(Integer idunite) {
/* 30 */     this.idunite = idunite;
/*    */   }
/*    */   
/*    */   public Integer getIdunite() {
/* 34 */     return this.idunite;
/*    */   }
/*    */   
/*    */   public void setIdunite(Integer idunite) {
/* 38 */     this.idunite = idunite;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 42 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 46 */     this.nom = nom;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 51 */     int hash = 7;
/* 52 */     hash = 67 * hash + Objects.hashCode(this.idunite);
/* 53 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 58 */     if (obj == null) {
/* 59 */       return false;
/*    */     }
/* 61 */     if (getClass() != obj.getClass()) {
/* 62 */       return false;
/*    */     }
/* 64 */     Unite other = (Unite)obj;
/* 65 */     if (!Objects.equals(this.idunite, other.idunite)) {
/* 66 */       return false;
/*    */     }
/* 68 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 73 */     return "Unite{idunite=" + this.idunite + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Unite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */