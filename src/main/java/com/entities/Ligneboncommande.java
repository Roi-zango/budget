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
/*     */ @Table(name = "ligneboncommande")
/*     */ public class Ligneboncommande
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @NotNull
/*     */   private Long idligneboncommande;
/*     */   private double prixunitaire;
/*     */   private double quantite;
/*     */   private double total;
/*     */   private double prixmercurial;
/*     */   private boolean verif;
/*     */   @Column(length = 20)
/*     */   private String reference;
/*     */   @JoinColumn(name = "idboncommande", referencedColumnName = "idboncommande")
/*     */   @ManyToOne
/*     */   private Boncommande boncommande;
/*     */   @JoinColumn(name = "idelementcout", referencedColumnName = "idelementcout")
/*     */   @ManyToOne
/*     */   private Elementcout elementcout;
/*     */   
/*     */   public Ligneboncommande() {}
/*     */   
/*     */   public Ligneboncommande(Long idligneboncommande) {
/*  47 */     this.idligneboncommande = idligneboncommande;
/*     */   }
/*     */   
/*     */   public Long getIdligneboncommande() {
/*  51 */     return this.idligneboncommande;
/*     */   }
/*     */   
/*     */   public void setIdligneboncommande(Long idligneboncommande) {
/*  55 */     this.idligneboncommande = idligneboncommande;
/*     */   }
/*     */   
/*     */   public double getPrixunitaire() {
/*  59 */     return this.prixunitaire;
/*     */   }
/*     */   
/*     */   public void setPrixunitaire(double prixunitaire) {
/*  63 */     this.prixunitaire = prixunitaire;
/*     */   }
/*     */   
/*     */   public double getQuantite() {
/*  67 */     return this.quantite;
/*     */   }
/*     */   
/*     */   public void setQuantite(double quantite) {
/*  71 */     this.quantite = quantite;
/*     */   }
/*     */   
/*     */   public double getTotal() {
/*  75 */     return this.total;
/*     */   }
/*     */   
/*     */   public void setTotal(double total) {
/*  79 */     this.total = total;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/*  83 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/*  87 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public Elementcout getElementcout() {
/*  91 */     return this.elementcout;
/*     */   }
/*     */   
/*     */   public void setElementcout(Elementcout elementcout) {
/*  95 */     this.elementcout = elementcout;
/*     */   }
/*     */   
/*     */   public double getPrixmercurial() {
/*  99 */     return this.prixmercurial;
/*     */   }
/*     */   
/*     */   public void setPrixmercurial(double prixmercurial) {
/* 103 */     this.prixmercurial = prixmercurial;
/*     */   }
/*     */   
/*     */   public boolean isVerif() {
/* 107 */     return this.verif;
/*     */   }
/*     */   
/*     */   public void setVerif(boolean verif) {
/* 111 */     this.verif = verif;
/*     */   }
/*     */   
/*     */   public String getReference() {
/* 115 */     return this.reference;
/*     */   }
/*     */   
/*     */   public void setReference(String reference) {
/* 119 */     this.reference = reference;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     return "Ligneboncommande{idligneboncommande=" + this.idligneboncommande + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 129 */     int hash = 7;
/* 130 */     hash = 37 * hash + Objects.hashCode(this.idligneboncommande);
/* 131 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 136 */     if (obj == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (getClass() != obj.getClass()) {
/* 140 */       return false;
/*     */     }
/* 142 */     Ligneboncommande other = (Ligneboncommande)obj;
/* 143 */     if (!Objects.equals(this.idligneboncommande, other.idligneboncommande)) {
/* 144 */       return false;
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Ligneboncommande.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */