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
/*     */ @Table(name = "signataire")
/*     */ public class Signataire
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   private Integer idsignataire;
/*     */   @Column(length = 60)
/*     */   private String nom;
/*     */   @Column(length = 60)
/*     */   private String prenom;
/*     */   @Column(length = 50)
/*     */   private String adresse;
/*     */   @Column(length = 30)
/*     */   private String telephone;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "idstructure", referencedColumnName = "idstructure")
/*     */   private Structure structure;
/*     */   
/*     */   public Signataire() {}
/*     */   
/*     */   public Signataire(Integer idsignataire) {
/*  43 */     this.idsignataire = idsignataire;
/*     */   }
/*     */   
/*     */   public Integer getIdsignataire() {
/*  47 */     return this.idsignataire;
/*     */   }
/*     */   
/*     */   public void setIdsignataire(Integer idsignataire) {
/*  51 */     this.idsignataire = idsignataire;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  55 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  59 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getPrenom() {
/*  63 */     return this.prenom;
/*     */   }
/*     */   
/*     */   public void setPrenom(String prenom) {
/*  67 */     this.prenom = prenom;
/*     */   }
/*     */   
/*     */   public String getAdresse() {
/*  71 */     return this.adresse;
/*     */   }
/*     */   
/*     */   public void setAdresse(String adresse) {
/*  75 */     this.adresse = adresse;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/*  79 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/*  83 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/*  87 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/*  91 */     this.structure = structure;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  96 */     return "Signataire{idsignataire=" + this.idsignataire + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     int hash = 5;
/* 102 */     hash = 43 * hash + Objects.hashCode(this.idsignataire);
/* 103 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 108 */     if (obj == null) {
/* 109 */       return false;
/*     */     }
/* 111 */     if (getClass() != obj.getClass()) {
/* 112 */       return false;
/*     */     }
/* 114 */     Signataire other = (Signataire)obj;
/* 115 */     if (!Objects.equals(this.idsignataire, other.idsignataire)) {
/* 116 */       return false;
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Signataire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */