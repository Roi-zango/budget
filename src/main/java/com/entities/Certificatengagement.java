/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Table(name = "certificatengagement")
/*     */ public class Certificatengagement
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   private Long idcertificatengagement;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateengagement;
/*     */   @JoinColumn(name = "idboncommande", referencedColumnName = "idboncommande")
/*     */   @ManyToOne
/*     */   private Boncommande boncommande;
/*     */   @JoinColumn(name = "idmoyens", referencedColumnName = "idmoyens")
/*     */   @ManyToOne
/*     */   private Moyens moyens;
/*     */   
/*     */   public Certificatengagement() {}
/*     */   
/*     */   public Certificatengagement(Long idcertificatengagement) {
/*  42 */     this.idcertificatengagement = idcertificatengagement;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/*  46 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/*  50 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public Date getDateengagement() {
/*  54 */     return this.dateengagement;
/*     */   }
/*     */   
/*     */   public void setDateengagement(Date dateengagement) {
/*  58 */     this.dateengagement = dateengagement;
/*     */   }
/*     */   
/*     */   public Long getIdcertificatengagement() {
/*  62 */     return this.idcertificatengagement;
/*     */   }
/*     */   
/*     */   public void setIdcertificatengagement(Long idcertificatengagement) {
/*  66 */     this.idcertificatengagement = idcertificatengagement;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/*  70 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/*  74 */     this.moyens = moyens;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  79 */     int hash = 3;
/*  80 */     hash = 29 * hash + Objects.hashCode(this.idcertificatengagement);
/*  81 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  86 */     if (obj == null) {
/*  87 */       return false;
/*     */     }
/*  89 */     if (getClass() != obj.getClass()) {
/*  90 */       return false;
/*     */     }
/*  92 */     Certificatengagement other = (Certificatengagement)obj;
/*  93 */     if (!Objects.equals(this.idcertificatengagement, other.idcertificatengagement)) {
/*  94 */       return false;
/*     */     }
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 101 */     return "Certificatengagement{idcertificatengagement=" + this.idcertificatengagement + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Certificatengagement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */