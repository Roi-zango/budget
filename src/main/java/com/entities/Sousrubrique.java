/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Table(name = "sousrubrique")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Sousrubrique.findAll", query = "SELECT s FROM Sousrubrique s"), @NamedQuery(name = "Sousrubrique.findByIdsousrubrique", query = "SELECT s FROM Sousrubrique s WHERE s.idsousrubrique = :idsousrubrique"), @NamedQuery(name = "Sousrubrique.findByNom", query = "SELECT s FROM Sousrubrique s WHERE s.nom = :nom"), @NamedQuery(name = "Sousrubrique.findByCode", query = "SELECT s FROM Sousrubrique s WHERE s.code = :code")})
/*     */ public class Sousrubrique
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idsousrubrique")
/*     */   private Integer idsousrubrique;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @OneToMany(mappedBy = "idsousrubrique", fetch = FetchType.LAZY)
/*     */   private List<Imputation> imputationList;
/*     */   @JoinColumn(name = "idrubrique", referencedColumnName = "idrubrique")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Rubrique idrubrique;
/*     */   
/*     */   public Sousrubrique() {}
/*     */   
/*     */   public Sousrubrique(Integer idsousrubrique) {
/*  61 */     this.idsousrubrique = idsousrubrique;
/*     */   }
/*     */   
/*     */   public Integer getIdsousrubrique() {
/*  65 */     return this.idsousrubrique;
/*     */   }
/*     */   
/*     */   public void setIdsousrubrique(Integer idsousrubrique) {
/*  69 */     this.idsousrubrique = idsousrubrique;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  73 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  77 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  81 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  85 */     this.code = code;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Imputation> getImputationList() {
/*  90 */     return this.imputationList;
/*     */   }
/*     */   
/*     */   public void setImputationList(List<Imputation> imputationList) {
/*  94 */     this.imputationList = imputationList;
/*     */   }
/*     */   
/*     */   public Rubrique getIdrubrique() {
/*  98 */     return this.idrubrique;
/*     */   }
/*     */   
/*     */   public void setIdrubrique(Rubrique idrubrique) {
/* 102 */     this.idrubrique = idrubrique;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 107 */     int hash = 0;
/* 108 */     hash += (this.idsousrubrique != null) ? this.idsousrubrique.hashCode() : 0;
/* 109 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 115 */     if (!(object instanceof Sousrubrique)) {
/* 116 */       return false;
/*     */     }
/* 118 */     Sousrubrique other = (Sousrubrique)object;
/* 119 */     if ((this.idsousrubrique == null && other.idsousrubrique != null) || (this.idsousrubrique != null && !this.idsousrubrique.equals(other.idsousrubrique))) {
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 127 */     return "entities.Sousrubrique[ idsousrubrique=" + this.idsousrubrique + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Sousrubrique.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */