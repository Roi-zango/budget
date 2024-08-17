/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ public class Section
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   private Integer idsection;
/*    */   @Column(length = 5)
/*    */   private String code;
/*    */   @Column(length = 140)
/*    */   private String nom;
/*    */   @JoinColumn(name = "idarticle", referencedColumnName = "idarticle")
/*    */   @ManyToOne
/*    */   private Article article;
/*    */   
/*    */   public Section() {}
/*    */   
/*    */   public Section(Integer idsection) {
/* 37 */     this.idsection = idsection;
/*    */   }
/*    */   
/*    */   public Integer getIdsection() {
/* 41 */     return this.idsection;
/*    */   }
/*    */   
/*    */   public void setIdsection(Integer idsection) {
/* 45 */     this.idsection = idsection;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 49 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 53 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 57 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 61 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public Article getArticle() {
/* 65 */     return this.article;
/*    */   }
/*    */   
/*    */   public void setArticle(Article article) {
/* 69 */     this.article = article;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 74 */     int hash = 7;
/* 75 */     hash = 17 * hash + Objects.hashCode(this.idsection);
/* 76 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 81 */     if (obj == null) {
/* 82 */       return false;
/*    */     }
/* 84 */     if (getClass() != obj.getClass()) {
/* 85 */       return false;
/*    */     }
/* 87 */     Section other = (Section)obj;
/* 88 */     if (!Objects.equals(this.idsection, other.idsection)) {
/* 89 */       return false;
/*    */     }
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Section.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */