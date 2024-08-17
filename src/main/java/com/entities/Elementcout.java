/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "elementcout")
/*     */ public class Elementcout
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @NotNull
/*     */   private Integer idelementcout;
/*     */   @Column(length = 20)
/*     */   private String code;
/*     */   @Column(length = 100)
/*     */   private String nom;
/*     */   private double prixunitaire;
/*     */   @JoinColumn(name = "idimputation", referencedColumnName = "idimputation")
/*     */   @ManyToOne
/*     */   private Imputation imputation;
/*     */   @JoinColumn(name = "idunite", referencedColumnName = "idunite")
/*     */   @ManyToOne
/*     */   private Unite unite;
/*     */   @JoinColumn(name = "idsousrubriquemercurial", referencedColumnName = "idsousrubriquemercurial")
/*     */   @ManyToOne
/*     */   private Sousrubriquemercurial sousrubriquemercurial;
/*     */   
/*     */   public Elementcout() {}
/*     */   
/*     */   public Elementcout(Integer idelementcout) {
/*  48 */     this.idelementcout = idelementcout;
/*     */   }
/*     */   
/*     */   public Integer getIdelementcout() {
/*  52 */     return this.idelementcout;
/*     */   }
/*     */   
/*     */   public void setIdelementcout(Integer idelementcout) {
/*  56 */     this.idelementcout = idelementcout;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  60 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  64 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  68 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  72 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public double getPrixunitaire() {
/*  76 */     return this.prixunitaire;
/*     */   }
/*     */   
/*     */   public void setPrixunitaire(double prixunitaire) {
/*  80 */     this.prixunitaire = prixunitaire;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/*  84 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/*  88 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public Unite getUnite() {
/*  92 */     return this.unite;
/*     */   }
/*     */   
/*     */   public void setUnite(Unite unite) {
/*  96 */     this.unite = unite;
/*     */   }
/*     */   
/*     */   public Sousrubriquemercurial getSousrubriquemercurial() {
/* 100 */     return this.sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
/* 104 */     this.sousrubriquemercurial = sousrubriquemercurial;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     return "Elementcout{idelementcout=" + this.idelementcout + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     int hash = 7;
/* 115 */     hash = 59 * hash + Objects.hashCode(this.idelementcout);
/* 116 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 121 */     if (obj == null) {
/* 122 */       return false;
/*     */     }
/* 124 */     if (getClass() != obj.getClass()) {
/* 125 */       return false;
/*     */     }
/* 127 */     Elementcout other = (Elementcout)obj;
/* 128 */     if (!Objects.equals(this.idelementcout, other.idelementcout)) {
/* 129 */       return false;
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Elementcout.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */