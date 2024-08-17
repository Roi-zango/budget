/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r"), @NamedQuery(name = "Recette.findByIdrecette", query = "SELECT r FROM Recette r WHERE r.idrecette = :idrecette"), @NamedQuery(name = "Recette.findByRanneeavant", query = "SELECT r FROM Recette r WHERE r.ranneeavant = :ranneeavant"), @NamedQuery(name = "Recette.findByQte", query = "SELECT r FROM Recette r WHERE r.qte = :qte"), @NamedQuery(name = "Recette.findByCu", query = "SELECT r FROM Recette r WHERE r.cu = :cu"), @NamedQuery(name = "Recette.findByCt", query = "SELECT r FROM Recette r WHERE r.ct = :ct"), @NamedQuery(name = "Recette.findByReaanneeavant", query = "SELECT r FROM Recette r WHERE r.reaanneeavant = :reaanneeavant"), @NamedQuery(name = "Recette.findByPranneePlus1Cout", query = "SELECT r FROM Recette r WHERE r.pranneePlus1Cout = :pranneePlus1Cout"), @NamedQuery(name = "Recette.findByPranneePlus1Qte", query = "SELECT r FROM Recette r WHERE r.pranneePlus1Qte = :pranneePlus1Qte"), @NamedQuery(name = "Recette.findByPranneePlus1Total", query = "SELECT r FROM Recette r WHERE r.pranneePlus1Total = :pranneePlus1Total"), @NamedQuery(name = "Recette.findByPranneePlus2Cout", query = "SELECT r FROM Recette r WHERE r.pranneePlus2Cout = :pranneePlus2Cout"), @NamedQuery(name = "Recette.findByPranneePlus2Qte", query = "SELECT r FROM Recette r WHERE r.pranneePlus2Qte = :pranneePlus2Qte"), @NamedQuery(name = "Recette.findByPranneePlus2Total", query = "SELECT r FROM Recette r WHERE r.pranneePlus2Total = :pranneePlus2Total"), @NamedQuery(name = "Recette.findByRanneeavantQte", query = "SELECT r FROM Recette r WHERE r.ranneeavantQte = :ranneeavantQte"), @NamedQuery(name = "Recette.findByRanneeavantCu", query = "SELECT r FROM Recette r WHERE r.ranneeavantCu = :ranneeavantCu"), @NamedQuery(name = "Recette.findByReaanneeavantQte", query = "SELECT r FROM Recette r WHERE r.reaanneeavantQte = :reaanneeavantQte"), @NamedQuery(name = "Recette.findByReaanneeavantCu", query = "SELECT r FROM Recette r WHERE r.reaanneeavantCu = :reaanneeavantCu"), @NamedQuery(name = "Recette.findByMontantConsommeAvant", query = "SELECT r FROM Recette r WHERE r.montantConsommeAvant = :montantConsommeAvant")})
/*     */ public class Recette
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   private Long idrecette;
/*     */   private Float ranneeavant;
/*     */   private Float qte;
/*     */   private Float cu;
/*     */   private Float ct;
/*     */   private Float reaanneeavant;
/*     */   @Column(name = "prannee_plus_1_cout")
/*     */   private Double pranneePlus1Cout;
/*     */   @Column(name = "prannee_plus_1_qte")
/*     */   private Double pranneePlus1Qte;
/*     */   @Column(name = "prannee_plus_1_total")
/*     */   private Double pranneePlus1Total;
/*     */   @Column(name = "prannee_plus_2_cout")
/*     */   private Double pranneePlus2Cout;
/*     */   @Column(name = "prannee_plus_2_qte")
/*     */   private Double pranneePlus2Qte;
/*     */   @Column(name = "prannee_plus_2_total")
/*     */   private Double pranneePlus2Total;
/*     */   @Column(name = "ranneeavant_qte")
/*     */   private Double ranneeavantQte;
/*     */   @Column(name = "ranneeavant_cu")
/*     */   private Double ranneeavantCu;
/*     */   @Column(name = "reaanneeavant_qte")
/*     */   private Double reaanneeavantQte;
/*     */   @Column(name = "reaanneeavant_cu")
/*     */   private Double reaanneeavantCu;
/*     */   @Column(name = "montant_consomme_avant")
/*     */   private Double montantConsommeAvant;
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @JoinColumn(name = "idbailleurfond", referencedColumnName = "idbailleurfond")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Bailleurfond idbailleurfond;
/*     */   @JoinColumn(name = "idimputation", referencedColumnName = "idimputation")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Imputation idimputation;
/*     */   
/*     */   public Recette() {}
/*     */   
/*     */   public Recette(Long idrecette) {
/*  94 */     this.idrecette = idrecette;
/*     */   }
/*     */   
/*     */   public Long getIdrecette() {
/*  98 */     return this.idrecette;
/*     */   }
/*     */   
/*     */   public void setIdrecette(Long idrecette) {
/* 102 */     this.idrecette = idrecette;
/*     */   }
/*     */   
/*     */   public Float getRanneeavant() {
/* 106 */     return this.ranneeavant;
/*     */   }
/*     */   
/*     */   public void setRanneeavant(Float ranneeavant) {
/* 110 */     this.ranneeavant = ranneeavant;
/*     */   }
/*     */   
/*     */   public Float getQte() {
/* 114 */     return this.qte;
/*     */   }
/*     */   
/*     */   public void setQte(Float qte) {
/* 118 */     this.qte = qte;
/*     */   }
/*     */   
/*     */   public Float getCu() {
/* 122 */     return this.cu;
/*     */   }
/*     */   
/*     */   public void setCu(Float cu) {
/* 126 */     this.cu = cu;
/*     */   }
/*     */   
/*     */   public Float getCt() {
/* 130 */     return this.ct;
/*     */   }
/*     */   
/*     */   public void setCt(Float ct) {
/* 134 */     this.ct = ct;
/*     */   }
/*     */   
/*     */   public Float getReaanneeavant() {
/* 138 */     return this.reaanneeavant;
/*     */   }
/*     */   
/*     */   public void setReaanneeavant(Float reaanneeavant) {
/* 142 */     this.reaanneeavant = reaanneeavant;
/*     */   }
/*     */   
/*     */   public Double getPranneePlus1Cout() {
/* 146 */     return this.pranneePlus1Cout;
/*     */   }
/*     */   
/*     */   public void setPranneePlus1Cout(Double pranneePlus1Cout) {
/* 150 */     this.pranneePlus1Cout = pranneePlus1Cout;
/*     */   }
/*     */   
/*     */   public Double getPranneePlus1Qte() {
/* 154 */     return this.pranneePlus1Qte;
/*     */   }
/*     */   
/*     */   public void setPranneePlus1Qte(Double pranneePlus1Qte) {
/* 158 */     this.pranneePlus1Qte = pranneePlus1Qte;
/*     */   }
/*     */   
/*     */   public Double getPranneePlus1Total() {
/* 162 */     return this.pranneePlus1Total;
/*     */   }
/*     */   
/*     */   public void setPranneePlus1Total(Double pranneePlus1Total) {
/* 166 */     this.pranneePlus1Total = pranneePlus1Total;
/*     */   }
/*     */   
/*     */   public Double getPranneePlus2Cout() {
/* 170 */     return this.pranneePlus2Cout;
/*     */   }
/*     */   
/*     */   public void setPranneePlus2Cout(Double pranneePlus2Cout) {
/* 174 */     this.pranneePlus2Cout = pranneePlus2Cout;
/*     */   }
/*     */   
/*     */   public Double getPranneePlus2Qte() {
/* 178 */     return this.pranneePlus2Qte;
/*     */   }
/*     */   
/*     */   public void setPranneePlus2Qte(Double pranneePlus2Qte) {
/* 182 */     this.pranneePlus2Qte = pranneePlus2Qte;
/*     */   }
/*     */   
/*     */   public Double getPranneePlus2Total() {
/* 186 */     return this.pranneePlus2Total;
/*     */   }
/*     */   
/*     */   public void setPranneePlus2Total(Double pranneePlus2Total) {
/* 190 */     this.pranneePlus2Total = pranneePlus2Total;
/*     */   }
/*     */   
/*     */   public Double getRanneeavantQte() {
/* 194 */     return this.ranneeavantQte;
/*     */   }
/*     */   
/*     */   public void setRanneeavantQte(Double ranneeavantQte) {
/* 198 */     this.ranneeavantQte = ranneeavantQte;
/*     */   }
/*     */   
/*     */   public Double getRanneeavantCu() {
/* 202 */     return this.ranneeavantCu;
/*     */   }
/*     */   
/*     */   public void setRanneeavantCu(Double ranneeavantCu) {
/* 206 */     this.ranneeavantCu = ranneeavantCu;
/*     */   }
/*     */   
/*     */   public Double getReaanneeavantQte() {
/* 210 */     return this.reaanneeavantQte;
/*     */   }
/*     */   
/*     */   public void setReaanneeavantQte(Double reaanneeavantQte) {
/* 214 */     this.reaanneeavantQte = reaanneeavantQte;
/*     */   }
/*     */   
/*     */   public Double getReaanneeavantCu() {
/* 218 */     return this.reaanneeavantCu;
/*     */   }
/*     */   
/*     */   public void setReaanneeavantCu(Double reaanneeavantCu) {
/* 222 */     this.reaanneeavantCu = reaanneeavantCu;
/*     */   }
/*     */   
/*     */   public Double getMontantConsommeAvant() {
/* 226 */     return this.montantConsommeAvant;
/*     */   }
/*     */   
/*     */   public void setMontantConsommeAvant(Double montantConsommeAvant) {
/* 230 */     this.montantConsommeAvant = montantConsommeAvant;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 234 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 238 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Bailleurfond getIdbailleurfond() {
/* 242 */     return this.idbailleurfond;
/*     */   }
/*     */   
/*     */   public void setIdbailleurfond(Bailleurfond idbailleurfond) {
/* 246 */     this.idbailleurfond = idbailleurfond;
/*     */   }
/*     */   
/*     */   public Imputation getIdimputation() {
/* 250 */     return this.idimputation;
/*     */   }
/*     */   
/*     */   public void setIdimputation(Imputation idimputation) {
/* 254 */     this.idimputation = idimputation;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 259 */     int hash = 0;
/* 260 */     hash += (this.idrecette != null) ? this.idrecette.hashCode() : 0;
/* 261 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 267 */     if (!(object instanceof Recette)) {
/* 268 */       return false;
/*     */     }
/* 270 */     Recette other = (Recette)object;
/* 271 */     if ((this.idrecette == null && other.idrecette != null) || (this.idrecette != null && !this.idrecette.equals(other.idrecette))) {
/* 272 */       return false;
/*     */     }
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 279 */     return "entities.Recette[ idrecette=" + this.idrecette + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Recette.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */