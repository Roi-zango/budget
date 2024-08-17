/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import javax.persistence.CascadeType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.EmbeddedId;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinColumns;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "structuremissionactivite")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Structuremissionactivite.findAll", query = "SELECT s FROM Structuremissionactivite s"), @NamedQuery(name = "Structuremissionactivite.findByIdstructure", query = "SELECT s FROM Structuremissionactivite s WHERE s.structuremissionactivitePK.idstructure = :idstructure"), @NamedQuery(name = "Structuremissionactivite.findByIdmission", query = "SELECT s FROM Structuremissionactivite s WHERE s.structuremissionactivitePK.idmission = :idmission"), @NamedQuery(name = "Structuremissionactivite.findByIdactivite", query = "SELECT s FROM Structuremissionactivite s WHERE s.structuremissionactivitePK.idactivite = :idactivite"), @NamedQuery(name = "Structuremissionactivite.findByObjectif", query = "SELECT s FROM Structuremissionactivite s WHERE s.objectif = :objectif")})
/*     */ public class Structuremissionactivite
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected StructuremissionactivitePK structuremissionactivitePK;
/*     */   @Size(max = 254)
/*     */   @Column(name = "objectif")
/*     */   private String objectif;
/*     */   @JoinColumn(name = "idactivite", referencedColumnName = "idactivite", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Activite activite;
/*     */   @JoinColumns({@JoinColumn(name = "idstructure", referencedColumnName = "idstructure", insertable = false, updatable = false), @JoinColumn(name = "idmission", referencedColumnName = "idmission", insertable = false, updatable = false)})
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Structuremission structuremission;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "structuremissionactivite", fetch = FetchType.LAZY)
/*     */   private List<Performance> performanceList;
/*     */   
/*     */   public Structuremissionactivite() {}
/*     */   
/*     */   public Structuremissionactivite(StructuremissionactivitePK structuremissionactivitePK) {
/*  61 */     this.structuremissionactivitePK = structuremissionactivitePK;
/*     */   }
/*     */   
/*     */   public Structuremissionactivite(long idstructure, long idmission, long idactivite) {
/*  65 */     this.structuremissionactivitePK = new StructuremissionactivitePK(idstructure, idmission, idactivite);
/*     */   }
/*     */   
/*     */   public StructuremissionactivitePK getStructuremissionactivitePK() {
/*  69 */     return this.structuremissionactivitePK;
/*     */   }
/*     */   
/*     */   public void setStructuremissionactivitePK(StructuremissionactivitePK structuremissionactivitePK) {
/*  73 */     this.structuremissionactivitePK = structuremissionactivitePK;
/*     */   }
/*     */   
/*     */   public String getObjectif() {
/*  77 */     return this.objectif;
/*     */   }
/*     */   
/*     */   public void setObjectif(String objectif) {
/*  81 */     this.objectif = objectif;
/*     */   }
/*     */   
/*     */   public Activite getActivite() {
/*  85 */     return this.activite;
/*     */   }
/*     */   
/*     */   public void setActivite(Activite activite) {
/*  89 */     this.activite = activite;
/*     */   }
/*     */   
/*     */   public Structuremission getStructuremission() {
/*  93 */     return this.structuremission;
/*     */   }
/*     */   
/*     */   public void setStructuremission(Structuremission structuremission) {
/*  97 */     this.structuremission = structuremission;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Performance> getPerformanceList() {
/* 102 */     return this.performanceList;
/*     */   }
/*     */   
/*     */   public void setPerformanceList(List<Performance> performanceList) {
/* 106 */     this.performanceList = performanceList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     int hash = 0;
/* 112 */     hash += (this.structuremissionactivitePK != null) ? this.structuremissionactivitePK.hashCode() : 0;
/* 113 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 119 */     if (!(object instanceof Structuremissionactivite)) {
/* 120 */       return false;
/*     */     }
/* 122 */     Structuremissionactivite other = (Structuremissionactivite)object;
/* 123 */     if ((this.structuremissionactivitePK == null && other.structuremissionactivitePK != null) || (this.structuremissionactivitePK != null && !this.structuremissionactivitePK.equals(other.structuremissionactivitePK))) {
/* 124 */       return false;
/*     */     }
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     return "entities.Structuremissionactivite[ structuremissionactivitePK=" + this.structuremissionactivitePK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Structuremissionactivite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */