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
/*    */ 
/*    */ @Entity
/*    */ public class Rubriquemercurial
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   private Integer idrubriquemercurial;
/*    */   @Column(length = 7)
/*    */   private String code;
/*    */   @Column(length = 150)
/*    */   private String nom;
/*    */   
/*    */   public Rubriquemercurial() {}
/*    */   
/*    */   public Rubriquemercurial(Integer idrubriquemercurial) {
/* 33 */     this.idrubriquemercurial = idrubriquemercurial;
/*    */   }
/*    */   
/*    */   public Integer getIdrubriquemercurial() {
/* 37 */     return this.idrubriquemercurial;
/*    */   }
/*    */   
/*    */   public void setIdrubriquemercurial(Integer idrubriquemercurial) {
/* 41 */     this.idrubriquemercurial = idrubriquemercurial;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 45 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 49 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 53 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 57 */     this.nom = nom;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 62 */     int hash = 7;
/* 63 */     hash = 67 * hash + Objects.hashCode(this.idrubriquemercurial);
/* 64 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 69 */     if (obj == null) {
/* 70 */       return false;
/*    */     }
/* 72 */     if (getClass() != obj.getClass()) {
/* 73 */       return false;
/*    */     }
/* 75 */     Rubriquemercurial other = (Rubriquemercurial)obj;
/* 76 */     if (!Objects.equals(this.idrubriquemercurial, other.idrubriquemercurial)) {
/* 77 */       return false;
/*    */     }
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rubriquemercurial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */