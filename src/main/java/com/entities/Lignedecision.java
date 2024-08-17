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
/*     */ @Entity
/*     */ @Table(name = "ligne_decision")
/*     */ public class Lignedecision
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name = "idligne_decision")
/*     */   private Long idligneDecision;
/*     */   @Column(length = 300)
/*     */   private String libelle;
/*     */   @Column(length = 20)
/*     */   private String code;
/*     */   private double coutunitaire;
/*     */   private int quantite;
/*     */   private double total;
/*     */   private boolean verif;
/*     */   @JoinColumn(name = "idboncommande", referencedColumnName = "idboncommande")
/*     */   @ManyToOne
/*     */   private Boncommande boncommande;
/*     */   
/*     */   public Lignedecision() {}
/*     */   
/*     */   public Lignedecision(Long idligneDecision) {
/*  45 */     this.idligneDecision = idligneDecision;
/*     */   }
/*     */   
/*     */   public Long getIdligneDecision() {
/*  49 */     return this.idligneDecision;
/*     */   }
/*     */   
/*     */   public void setIdligneDecision(Long idligneDecision) {
/*  53 */     this.idligneDecision = idligneDecision;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  57 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  61 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public int getQuantite() {
/*  65 */     return this.quantite;
/*     */   }
/*     */   
/*     */   public void setQuantite(int quantite) {
/*  69 */     this.quantite = quantite;
/*     */   }
/*     */   
/*     */   public double getTotal() {
/*  73 */     return this.total;
/*     */   }
/*     */   
/*     */   public void setTotal(double total) {
/*  77 */     this.total = total;
/*     */   }
/*     */   
/*     */   public double getCoutunitaire() {
/*  81 */     return this.coutunitaire;
/*     */   }
/*     */   
/*     */   public void setCoutunitaire(double coutunitaire) {
/*  85 */     this.coutunitaire = coutunitaire;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/*  89 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/*  93 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  97 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 101 */     this.code = code;
/*     */   }
/*     */   
/*     */   public boolean isVerif() {
/* 105 */     return this.verif;
/*     */   }
/*     */   
/*     */   public void setVerif(boolean verif) {
/* 109 */     this.verif = verif;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     return "Lignedecision{idligneDecision=" + this.idligneDecision + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 119 */     int hash = 7;
/* 120 */     hash = 89 * hash + Objects.hashCode(this.idligneDecision);
/* 121 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 126 */     if (obj == null) {
/* 127 */       return false;
/*     */     }
/* 129 */     if (getClass() != obj.getClass()) {
/* 130 */       return false;
/*     */     }
/* 132 */     Lignedecision other = (Lignedecision)obj;
/* 133 */     if (!Objects.equals(this.idligneDecision, other.idligneDecision)) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Lignedecision.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */