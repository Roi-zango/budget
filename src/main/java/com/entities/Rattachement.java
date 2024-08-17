/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
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
/*     */ @Entity
/*     */ @Table(name = "rattachement")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Rattachement.findAll", query = "SELECT r FROM Rattachement r"), @NamedQuery(name = "Rattachement.findByIdrattachement", query = "SELECT r FROM Rattachement r WHERE r.idrattachement = :idrattachement"), @NamedQuery(name = "Rattachement.findByNom", query = "SELECT r FROM Rattachement r WHERE r.nom = :nom")})
/*     */ public class Rattachement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idrattachement")
/*     */   private Integer idrattachement;
/*     */   @Size(max = 40)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @OneToMany(mappedBy = "idrattachement", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   
/*     */   public Rattachement() {}
/*     */   
/*     */   public Rattachement(Integer idrattachement) {
/*  53 */     this.idrattachement = idrattachement;
/*     */   }
/*     */   
/*     */   public Integer getIdrattachement() {
/*  57 */     return this.idrattachement;
/*     */   }
/*     */   
/*     */   public void setIdrattachement(Integer idrattachement) {
/*  61 */     this.idrattachement = idrattachement;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  65 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  69 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/*  74 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/*  78 */     this.structureList = structureList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  83 */     int hash = 0;
/*  84 */     hash += (this.idrattachement != null) ? this.idrattachement.hashCode() : 0;
/*  85 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*  91 */     if (!(object instanceof Rattachement)) {
/*  92 */       return false;
/*     */     }
/*  94 */     Rattachement other = (Rattachement)object;
/*  95 */     if ((this.idrattachement == null && other.idrattachement != null) || (this.idrattachement != null && !this.idrattachement.equals(other.idrattachement))) {
/*  96 */       return false;
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     return "entities.Rattachement[ idrattachement=" + this.idrattachement + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rattachement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */