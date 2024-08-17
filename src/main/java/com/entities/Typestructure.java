/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.CascadeType;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "typestructure")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Typestructure.findAll", query = "SELECT t FROM Typestructure t"), @NamedQuery(name = "Typestructure.findByIdtypestructure", query = "SELECT t FROM Typestructure t WHERE t.idtypestructure = :idtypestructure"), @NamedQuery(name = "Typestructure.findByNom", query = "SELECT t FROM Typestructure t WHERE t.nom = :nom"), @NamedQuery(name = "Typestructure.findByDesignation", query = "SELECT t FROM Typestructure t WHERE t.designation = :designation"), @NamedQuery(name = "Typestructure.findByEtat", query = "SELECT t FROM Typestructure t WHERE t.etat = :etat"), @NamedQuery(name = "Typestructure.findByDateEnregistre", query = "SELECT t FROM Typestructure t WHERE t.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Typestructure.findByDerniereModif", query = "SELECT t FROM Typestructure t WHERE t.derniereModif = :derniereModif")})
/*     */ public class Typestructure
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idtypestructure")
/*     */   private Long idtypestructure;
/*     */   @Size(max = 254)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 254)
/*     */   @Column(name = "designation")
/*     */   private String designation;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idtypestructure", fetch = FetchType.LAZY)
/*     */   private List<Indicateurperformance> indicateurperformanceList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "typestructure", fetch = FetchType.LAZY)
/*     */   private List<Activitetypestructure> activitetypestructureList;
/*     */   @OneToMany(mappedBy = "idtypestructure", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   
/*     */   public Typestructure() {}
/*     */   
/*     */   public Typestructure(Long idtypestructure) {
/*  76 */     this.idtypestructure = idtypestructure;
/*     */   }
/*     */   
/*     */   public Long getIdtypestructure() {
/*  80 */     return this.idtypestructure;
/*     */   }
/*     */   
/*     */   public void setIdtypestructure(Long idtypestructure) {
/*  84 */     this.idtypestructure = idtypestructure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  88 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  92 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getDesignation() {
/*  96 */     return this.designation;
/*     */   }
/*     */   
/*     */   public void setDesignation(String designation) {
/* 100 */     this.designation = designation;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 104 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 108 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 112 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 116 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 120 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 124 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurperformance> getIndicateurperformanceList() {
/* 129 */     return this.indicateurperformanceList;
/*     */   }
/*     */   
/*     */   public void setIndicateurperformanceList(List<Indicateurperformance> indicateurperformanceList) {
/* 133 */     this.indicateurperformanceList = indicateurperformanceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Activitetypestructure> getActivitetypestructureList() {
/* 138 */     return this.activitetypestructureList;
/*     */   }
/*     */   
/*     */   public void setActivitetypestructureList(List<Activitetypestructure> activitetypestructureList) {
/* 142 */     this.activitetypestructureList = activitetypestructureList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 147 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 151 */     this.structureList = structureList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     int hash = 0;
/* 157 */     hash += (this.idtypestructure != null) ? this.idtypestructure.hashCode() : 0;
/* 158 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 164 */     if (!(object instanceof Typestructure)) {
/* 165 */       return false;
/*     */     }
/* 167 */     Typestructure other = (Typestructure)object;
/* 168 */     if ((this.idtypestructure == null && other.idtypestructure != null) || (this.idtypestructure != null && !this.idtypestructure.equals(other.idtypestructure))) {
/* 169 */       return false;
/*     */     }
/* 171 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     return "entities.Typestructure[ idtypestructure=" + this.idtypestructure + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typestructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */