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
/*    */ public class Article
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   private Integer idarticle;
/*    */   @Column(length = 10)
/*    */   private String code;
/*    */   @Column(length = 140)
/*    */   private String nom;
/*    */   
/*    */   public Article() {}
/*    */   
/*    */   public Article(Integer idarticle) {
/* 32 */     this.idarticle = idarticle;
/*    */   }
/*    */   
/*    */   public Integer getIdarticle() {
/* 36 */     return this.idarticle;
/*    */   }
/*    */   
/*    */   public void setIdarticle(Integer idarticle) {
/* 40 */     this.idarticle = idarticle;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 44 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 48 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 52 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 56 */     this.nom = nom;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 61 */     int hash = 5;
/* 62 */     hash = 47 * hash + Objects.hashCode(this.idarticle);
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
/* 74 */     Article other = (Article)obj;
/* 75 */     if (!Objects.equals(this.idarticle, other.idarticle)) {
/* 76 */       return false;
/*    */     }
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Article.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */