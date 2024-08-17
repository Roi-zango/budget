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
/*    */ public class Sousrubriquemercurial
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   private Integer idsousrubriquemercurial;
/*    */   @Column(length = 5)
/*    */   private String code;
/*    */   @Column(length = 200)
/*    */   private String nom;
/*    */   @JoinColumn(name = "idrubriquemercurial", referencedColumnName = "idrubriquemercurial")
/*    */   @ManyToOne
/*    */   private Rubriquemercurial rubriquemercurial;
/*    */   
/*    */   public Sousrubriquemercurial() {}
/*    */   
/*    */   public Sousrubriquemercurial(Integer idsousrubriquemercurial) {
/* 37 */     this.idsousrubriquemercurial = idsousrubriquemercurial;
/*    */   }
/*    */   
/*    */   public Integer getIdsousrubriquemercurial() {
/* 41 */     return this.idsousrubriquemercurial;
/*    */   }
/*    */   
/*    */   public void setIdsousrubriquemercurial(Integer idsousrubriquemercurial) {
/* 45 */     this.idsousrubriquemercurial = idsousrubriquemercurial;
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
/*    */   public Rubriquemercurial getRubriquemercurial() {
/* 65 */     return this.rubriquemercurial;
/*    */   }
/*    */   
/*    */   public void setRubriquemercurial(Rubriquemercurial rubriquemercurial) {
/* 69 */     this.rubriquemercurial = rubriquemercurial;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 74 */     int hash = 3;
/* 75 */     hash = 19 * hash + Objects.hashCode(this.idsousrubriquemercurial);
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
/* 87 */     Sousrubriquemercurial other = (Sousrubriquemercurial)obj;
/* 88 */     if (!Objects.equals(this.idsousrubriquemercurial, other.idsousrubriquemercurial)) {
/* 89 */       return false;
/*    */     }
/* 91 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 96 */     return "Sousrubriquemercurial{idsousrubriquemercurial=" + this.idsousrubriquemercurial + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Sousrubriquemercurial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */