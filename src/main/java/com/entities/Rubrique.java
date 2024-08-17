/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlTransient;
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
/*     */ @Table(name = "rubrique")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Rubrique.findAll", query = "SELECT r FROM Rubrique r"), @NamedQuery(name = "Rubrique.findByIdrubrique", query = "SELECT r FROM Rubrique r WHERE r.idrubrique = :idrubrique"), @NamedQuery(name = "Rubrique.findByNom", query = "SELECT r FROM Rubrique r WHERE r.nom = :nom"), @NamedQuery(name = "Rubrique.findByCode", query = "SELECT r FROM Rubrique r WHERE r.code = :code")})
/*     */ public class Rubrique
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idrubrique")
/*     */   private Integer idrubrique;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @OneToMany(mappedBy = "idrubrique", fetch = FetchType.LAZY)
/*     */   private List<Sousrubrique> sousrubriqueList;
/*     */   
/*     */   public Rubrique() {}
/*     */   
/*     */   public Rubrique(Integer idrubrique) {
/*  56 */     this.idrubrique = idrubrique;
/*     */   }
/*     */   
/*     */   public Integer getIdrubrique() {
/*  60 */     return this.idrubrique;
/*     */   }
/*     */   
/*     */   public void setIdrubrique(Integer idrubrique) {
/*  64 */     this.idrubrique = idrubrique;
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
/*     */   public String getCode() {
/*  76 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  80 */     this.code = code;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Sousrubrique> getSousrubriqueList() {
/*  85 */     return this.sousrubriqueList;
/*     */   }
/*     */   
/*     */   public void setSousrubriqueList(List<Sousrubrique> sousrubriqueList) {
/*  89 */     this.sousrubriqueList = sousrubriqueList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  94 */     int hash = 0;
/*  95 */     hash += (this.idrubrique != null) ? this.idrubrique.hashCode() : 0;
/*  96 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 102 */     if (!(object instanceof Rubrique)) {
/* 103 */       return false;
/*     */     }
/* 105 */     Rubrique other = (Rubrique)object;
/* 106 */     if ((this.idrubrique == null && other.idrubrique != null) || (this.idrubrique != null && !this.idrubrique.equals(other.idrubrique))) {
/* 107 */       return false;
/*     */     }
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     return "entities.Rubrique[ idrubrique=" + this.idrubrique + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rubrique.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */