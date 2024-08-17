/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
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
/*     */ @Entity
/*     */ @Table(name = "pap")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Pap.findAll", query = "SELECT p FROM Pap p"), @NamedQuery(name = "Pap.findByIdpap", query = "SELECT p FROM Pap p WHERE p.idpap = :idpap"), @NamedQuery(name = "Pap.findByLibelle", query = "SELECT p FROM Pap p WHERE p.libelle = :libelle"), @NamedQuery(name = "Pap.findByAnnedebut", query = "SELECT p FROM Pap p WHERE p.annedebut = :annedebut"), @NamedQuery(name = "Pap.findByAnneefin", query = "SELECT p FROM Pap p WHERE p.anneefin = :anneefin"), @NamedQuery(name = "Pap.findByDuree", query = "SELECT p FROM Pap p WHERE p.duree = :duree"), @NamedQuery(name = "Pap.findByActif", query = "SELECT p FROM Pap p WHERE p.actif = :actif")})
/*     */ public class Pap
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Size(min = 1, max = 1024)
/*     */   @Column(name = "idpap")
/*     */   private String idpap;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Column(name = "annedebut")
/*     */   private Integer annedebut;
/*     */   @Column(name = "anneefin")
/*     */   private Integer anneefin;
/*     */   @Column(name = "duree")
/*     */   private Integer duree;
/*     */   @Column(name = "actif")
/*     */   private Boolean actif;
/*     */   
/*     */   public Pap() {}
/*     */   
/*     */   public Pap(String idpap) {
/*  59 */     this.idpap = idpap;
/*     */   }
/*     */   
/*     */   public String getIdpap() {
/*  63 */     return this.idpap;
/*     */   }
/*     */   
/*     */   public void setIdpap(String idpap) {
/*  67 */     this.idpap = idpap;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  71 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  75 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public Integer getAnnedebut() {
/*  79 */     return this.annedebut;
/*     */   }
/*     */   
/*     */   public void setAnnedebut(Integer annedebut) {
/*  83 */     this.annedebut = annedebut;
/*     */   }
/*     */   
/*     */   public Integer getAnneefin() {
/*  87 */     return this.anneefin;
/*     */   }
/*     */   
/*     */   public void setAnneefin(Integer anneefin) {
/*  91 */     this.anneefin = anneefin;
/*     */   }
/*     */   
/*     */   public Integer getDuree() {
/*  95 */     return this.duree;
/*     */   }
/*     */   
/*     */   public void setDuree(Integer duree) {
/*  99 */     this.duree = duree;
/*     */   }
/*     */   
/*     */   public Boolean getActif() {
/* 103 */     return this.actif;
/*     */   }
/*     */   
/*     */   public void setActif(Boolean actif) {
/* 107 */     this.actif = actif;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 112 */     int hash = 0;
/* 113 */     hash += (this.idpap != null) ? this.idpap.hashCode() : 0;
/* 114 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 120 */     if (!(object instanceof Pap)) {
/* 121 */       return false;
/*     */     }
/* 123 */     Pap other = (Pap)object;
/* 124 */     if ((this.idpap == null && other.idpap != null) || (this.idpap != null && !this.idpap.equals(other.idpap))) {
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     return "entities.Pap[ idpap=" + this.idpap + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Pap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */