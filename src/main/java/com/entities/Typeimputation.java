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
/*    */ public class Typeimputation
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   private Integer idtypeimputation;
/*    */   @Column(length = 150)
/*    */   private String nom;
/*    */   @Column(length = 20)
/*    */   private String code;
/*    */   
/*    */   public Typeimputation() {}
/*    */   
/*    */   public Typeimputation(Integer idtypeimputation) {
/* 32 */     this.idtypeimputation = idtypeimputation;
/*    */   }
/*    */   
/*    */   public Integer getIdtypeimputation() {
/* 36 */     return this.idtypeimputation;
/*    */   }
/*    */   
/*    */   public void setIdtypeimputation(Integer idtypeimputation) {
/* 40 */     this.idtypeimputation = idtypeimputation;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 44 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 48 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 52 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 56 */     this.code = code;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 61 */     int hash = 7;
/* 62 */     hash = 11 * hash + Objects.hashCode(this.idtypeimputation);
/* 63 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 68 */     if (obj == null) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (getClass() != obj.getClass()) {
/* 72 */       return false;
/*    */     }
/* 74 */     Typeimputation other = (Typeimputation)obj;
/* 75 */     if (!Objects.equals(this.idtypeimputation, other.idtypeimputation)) {
/* 76 */       return false;
/*    */     }
/* 78 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 83 */     return "Typeimputation{idtypeimputation=" + this.idtypeimputation + ", nom=" + this.nom + ", code=" + this.code + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typeimputation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */