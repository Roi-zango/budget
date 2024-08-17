/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "statutstructure")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Statutstructure.findAll", query = "SELECT s FROM Statutstructure s"), @NamedQuery(name = "Statutstructure.findByIdstatutstructure", query = "SELECT s FROM Statutstructure s WHERE s.idstatutstructure = :idstatutstructure"), @NamedQuery(name = "Statutstructure.findByNom", query = "SELECT s FROM Statutstructure s WHERE s.nom = :nom"), @NamedQuery(name = "Statutstructure.findByEtat", query = "SELECT s FROM Statutstructure s WHERE s.etat = :etat"), @NamedQuery(name = "Statutstructure.findByDateEnregistre", query = "SELECT s FROM Statutstructure s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Statutstructure.findByDerniereModif", query = "SELECT s FROM Statutstructure s WHERE s.derniereModif = :derniereModif")})
/*     */ public class Statutstructure
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idstatutstructure")
/*     */   private Long idstatutstructure;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idstatutstructure", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   
/*     */   public Statutstructure() {}
/*     */   
/*     */   public Statutstructure(Long idstatutstructure) {
/*  67 */     this.idstatutstructure = idstatutstructure;
/*     */   }
/*     */   
/*     */   public Long getIdstatutstructure() {
/*  71 */     return this.idstatutstructure;
/*     */   }
/*     */   
/*     */   public void setIdstatutstructure(Long idstatutstructure) {
/*  75 */     this.idstatutstructure = idstatutstructure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  79 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  83 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  87 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  91 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/*  95 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/*  99 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 103 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 107 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 112 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 116 */     this.structureList = structureList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idstatutstructure != null) ? this.idstatutstructure.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Statutstructure)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Statutstructure other = (Statutstructure)object;
/* 133 */     if ((this.idstatutstructure == null && other.idstatutstructure != null) || (this.idstatutstructure != null && !this.idstatutstructure.equals(other.idstatutstructure))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Statutstructure[ idstatutstructure=" + this.idstatutstructure + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Statutstructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */