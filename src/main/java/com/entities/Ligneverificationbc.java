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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "ligne_verification_bc")
/*     */ public class Ligneverificationbc
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name = "idligne_verification_bc")
/*     */   private Long idligneVerificationBc;
/*     */   @JoinColumn(name = "idligneboncommande", referencedColumnName = "idligneboncommande")
/*     */   @ManyToOne
/*     */   private Ligneboncommande ligneboncommande;
/*     */   @JoinColumn(name = "idverificationbc", referencedColumnName = "idverificationbc")
/*     */   @ManyToOne
/*     */   private Verificationbc verificationbc;
/*     */   @JoinColumn(name = "idligne_decision", referencedColumnName = "idligne_decision")
/*     */   @ManyToOne
/*     */   private Lignedecision lignedecision;
/*     */   
/*     */   public Ligneverificationbc() {}
/*     */   
/*     */   public Ligneverificationbc(Long idligneVerificationBc) {
/*  45 */     this.idligneVerificationBc = idligneVerificationBc;
/*     */   }
/*     */   
/*     */   public Long getIdligneVerificationBc() {
/*  49 */     return this.idligneVerificationBc;
/*     */   }
/*     */   
/*     */   public void setIdligneVerificationBc(Long idligneVerificationBc) {
/*  53 */     this.idligneVerificationBc = idligneVerificationBc;
/*     */   }
/*     */   
/*     */   public Ligneboncommande getLigneboncommande() {
/*  57 */     return this.ligneboncommande;
/*     */   }
/*     */   
/*     */   public void setLigneboncommande(Ligneboncommande ligneboncommande) {
/*  61 */     this.ligneboncommande = ligneboncommande;
/*     */   }
/*     */   
/*     */   public Verificationbc getVerificationbc() {
/*  65 */     return this.verificationbc;
/*     */   }
/*     */   
/*     */   public void setVerificationbc(Verificationbc verificationbc) {
/*  69 */     this.verificationbc = verificationbc;
/*     */   }
/*     */   
/*     */   public Lignedecision getLignedecision() {
/*  73 */     return this.lignedecision;
/*     */   }
/*     */   
/*     */   public void setLignedecision(Lignedecision lignedecision) {
/*  77 */     this.lignedecision = lignedecision;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  82 */     return "Ligneverificationbc{idligneVerificationBc=" + this.idligneVerificationBc + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  87 */     int hash = 3;
/*  88 */     hash = 83 * hash + Objects.hashCode(this.idligneVerificationBc);
/*  89 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  94 */     if (obj == null) {
/*  95 */       return false;
/*     */     }
/*  97 */     if (getClass() != obj.getClass()) {
/*  98 */       return false;
/*     */     }
/* 100 */     Ligneverificationbc other = (Ligneverificationbc)obj;
/* 101 */     if (!Objects.equals(this.idligneVerificationBc, other.idligneVerificationBc)) {
/* 102 */       return false;
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Ligneverificationbc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */