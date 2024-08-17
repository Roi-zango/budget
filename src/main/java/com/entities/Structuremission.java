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
/*     */ @Entity
/*     */ @Table(name = "structuremission")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Structuremission.findAll", query = "SELECT s FROM Structuremission s"), @NamedQuery(name = "Structuremission.findByIdstructure", query = "SELECT s FROM Structuremission s WHERE s.structuremissionPK.idstructure = :idstructure"), @NamedQuery(name = "Structuremission.findByIdmission", query = "SELECT s FROM Structuremission s WHERE s.structuremissionPK.idmission = :idmission"), @NamedQuery(name = "Structuremission.findByProblemes", query = "SELECT s FROM Structuremission s WHERE s.problemes = :problemes"), @NamedQuery(name = "Structuremission.findByObjectif", query = "SELECT s FROM Structuremission s WHERE s.objectif = :objectif")})
/*     */ public class Structuremission
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected StructuremissionPK structuremissionPK;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "problemes")
/*     */   private String problemes;
/*     */   @Size(max = 254)
/*     */   @Column(name = "objectif")
/*     */   private String objectif;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "structuremission", fetch = FetchType.LAZY)
/*     */   private List<Structuremissionactivite> structuremissionactiviteList;
/*     */   @JoinColumn(name = "idmission", referencedColumnName = "idmission", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Mission mission;
/*     */   @JoinColumn(name = "idstructure", referencedColumnName = "idstructure", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Structure structure;
/*     */   
/*     */   public Structuremission() {}
/*     */   
/*     */   public Structuremission(StructuremissionPK structuremissionPK) {
/*  61 */     this.structuremissionPK = structuremissionPK;
/*     */   }
/*     */   
/*     */   public Structuremission(long idstructure, long idmission) {
/*  65 */     this.structuremissionPK = new StructuremissionPK(idstructure, idmission);
/*     */   }
/*     */   
/*     */   public StructuremissionPK getStructuremissionPK() {
/*  69 */     return this.structuremissionPK;
/*     */   }
/*     */   
/*     */   public void setStructuremissionPK(StructuremissionPK structuremissionPK) {
/*  73 */     this.structuremissionPK = structuremissionPK;
/*     */   }
/*     */   
/*     */   public String getProblemes() {
/*  77 */     return this.problemes;
/*     */   }
/*     */   
/*     */   public void setProblemes(String problemes) {
/*  81 */     this.problemes = problemes;
/*     */   }
/*     */   
/*     */   public String getObjectif() {
/*  85 */     return this.objectif;
/*     */   }
/*     */   
/*     */   public void setObjectif(String objectif) {
/*  89 */     this.objectif = objectif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structuremissionactivite> getStructuremissionactiviteList() {
/*  94 */     return this.structuremissionactiviteList;
/*     */   }
/*     */   
/*     */   public void setStructuremissionactiviteList(List<Structuremissionactivite> structuremissionactiviteList) {
/*  98 */     this.structuremissionactiviteList = structuremissionactiviteList;
/*     */   }
/*     */   
/*     */   public Mission getMission() {
/* 102 */     return this.mission;
/*     */   }
/*     */   
/*     */   public void setMission(Mission mission) {
/* 106 */     this.mission = mission;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 110 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 114 */     this.structure = structure;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 119 */     int hash = 0;
/* 120 */     hash += (this.structuremissionPK != null) ? this.structuremissionPK.hashCode() : 0;
/* 121 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 127 */     if (!(object instanceof Structuremission)) {
/* 128 */       return false;
/*     */     }
/* 130 */     Structuremission other = (Structuremission)object;
/* 131 */     if ((this.structuremissionPK == null && other.structuremissionPK != null) || (this.structuremissionPK != null && !this.structuremissionPK.equals(other.structuremissionPK))) {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     return "entities.Structuremission[ structuremissionPK=" + this.structuremissionPK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Structuremission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */