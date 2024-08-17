/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ public class Verificationbc
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   private Long idverificationbc;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateverification;
/*     */   private String observation;
/*     */   private boolean valide;
/*     */   @JoinColumn(name = "idboncommande", referencedColumnName = "idboncommande")
/*     */   @ManyToOne
/*     */   private Boncommande boncommande;
/*     */   
/*     */   public Verificationbc() {}
/*     */   
/*     */   public Verificationbc(Long idverificationbc) {
/*  39 */     this.idverificationbc = idverificationbc;
/*     */   }
/*     */   
/*     */   public Long getIdverificationbc() {
/*  43 */     return this.idverificationbc;
/*     */   }
/*     */   
/*     */   public void setIdverificationbc(Long idverificationbc) {
/*  47 */     this.idverificationbc = idverificationbc;
/*     */   }
/*     */   
/*     */   public Date getDateverification() {
/*  51 */     return this.dateverification;
/*     */   }
/*     */   
/*     */   public void setDateverification(Date dateverification) {
/*  55 */     this.dateverification = dateverification;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/*  59 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/*  63 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/*  67 */     return this.valide;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/*  71 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/*  75 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/*  79 */     this.boncommande = boncommande;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  84 */     int hash = 5;
/*  85 */     hash = 59 * hash + Objects.hashCode(this.idverificationbc);
/*  86 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  91 */     if (obj == null) {
/*  92 */       return false;
/*     */     }
/*  94 */     if (getClass() != obj.getClass()) {
/*  95 */       return false;
/*     */     }
/*  97 */     Verificationbc other = (Verificationbc)obj;
/*  98 */     if (!Objects.equals(this.idverificationbc, other.idverificationbc)) {
/*  99 */       return false;
/*     */     }
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 106 */     return "Verificationbc{idverificationbc=" + this.idverificationbc + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Verificationbc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */