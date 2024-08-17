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
/*     */ @Table(name = "axestrategique")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Axestrategique.findAll", query = "SELECT a FROM Axestrategique a"), @NamedQuery(name = "Axestrategique.findByIdaxestrategique", query = "SELECT a FROM Axestrategique a WHERE a.idaxestrategique = :idaxestrategique"), @NamedQuery(name = "Axestrategique.findByNom", query = "SELECT a FROM Axestrategique a WHERE a.nom = :nom"), @NamedQuery(name = "Axestrategique.findByEtat", query = "SELECT a FROM Axestrategique a WHERE a.etat = :etat"), @NamedQuery(name = "Axestrategique.findByDateEnregistre", query = "SELECT a FROM Axestrategique a WHERE a.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Axestrategique.findByDerniereModif", query = "SELECT a FROM Axestrategique a WHERE a.derniereModif = :derniereModif")})
/*     */ public class Axestrategique
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idaxestrategique")
/*     */   private Long idaxestrategique;
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
/*     */   @OneToMany(mappedBy = "idaxestrategique", fetch = FetchType.LAZY)
/*     */   private List<Programme> programmeList;
/*     */   
/*     */   public Axestrategique() {}
/*     */   
/*     */   public Axestrategique(Long idaxestrategique) {
/*  67 */     this.idaxestrategique = idaxestrategique;
/*     */   }
/*     */   
/*     */   public Long getIdaxestrategique() {
/*  71 */     return this.idaxestrategique;
/*     */   }
/*     */   
/*     */   public void setIdaxestrategique(Long idaxestrategique) {
/*  75 */     this.idaxestrategique = idaxestrategique;
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
/*     */   public List<Programme> getProgrammeList() {
/* 112 */     return this.programmeList;
/*     */   }
/*     */   
/*     */   public void setProgrammeList(List<Programme> programmeList) {
/* 116 */     this.programmeList = programmeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idaxestrategique != null) ? this.idaxestrategique.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Axestrategique)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Axestrategique other = (Axestrategique)object;
/* 133 */     if ((this.idaxestrategique == null && other.idaxestrategique != null) || (this.idaxestrategique != null && !this.idaxestrategique.equals(other.idaxestrategique))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Axestrategique[ idaxestrategique=" + this.idaxestrategique + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Axestrategique.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */