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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "methodeeval")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Methodeeval.findAll", query = "SELECT m FROM Methodeeval m"), @NamedQuery(name = "Methodeeval.findByIdmethodeeval", query = "SELECT m FROM Methodeeval m WHERE m.idmethodeeval = :idmethodeeval"), @NamedQuery(name = "Methodeeval.findByNom", query = "SELECT m FROM Methodeeval m WHERE m.nom = :nom"), @NamedQuery(name = "Methodeeval.findByDescription", query = "SELECT m FROM Methodeeval m WHERE m.description = :description"), @NamedQuery(name = "Methodeeval.findByEtat", query = "SELECT m FROM Methodeeval m WHERE m.etat = :etat"), @NamedQuery(name = "Methodeeval.findByDateEnregistre", query = "SELECT m FROM Methodeeval m WHERE m.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Methodeeval.findByDerniereModif", query = "SELECT m FROM Methodeeval m WHERE m.derniereModif = :derniereModif")})
/*     */ public class Methodeeval
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idmethodeeval")
/*     */   private Long idmethodeeval;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idmethodeeval", fetch = FetchType.LAZY)
/*     */   private List<Extrant> extrantList;
/*     */   
/*     */   public Methodeeval() {}
/*     */   
/*     */   public Methodeeval(Long idmethodeeval) {
/*  71 */     this.idmethodeeval = idmethodeeval;
/*     */   }
/*     */   
/*     */   public Long getIdmethodeeval() {
/*  75 */     return this.idmethodeeval;
/*     */   }
/*     */   
/*     */   public void setIdmethodeeval(Long idmethodeeval) {
/*  79 */     this.idmethodeeval = idmethodeeval;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  83 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  87 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  91 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  95 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  99 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 103 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 107 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 111 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 115 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 119 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Extrant> getExtrantList() {
/* 124 */     return this.extrantList;
/*     */   }
/*     */   
/*     */   public void setExtrantList(List<Extrant> extrantList) {
/* 128 */     this.extrantList = extrantList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 133 */     int hash = 0;
/* 134 */     hash += (this.idmethodeeval != null) ? this.idmethodeeval.hashCode() : 0;
/* 135 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 141 */     if (!(object instanceof Methodeeval)) {
/* 142 */       return false;
/*     */     }
/* 144 */     Methodeeval other = (Methodeeval)object;
/* 145 */     if ((this.idmethodeeval == null && other.idmethodeeval != null) || (this.idmethodeeval != null && !this.idmethodeeval.equals(other.idmethodeeval))) {
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return "entities.Methodeeval[ idmethodeeval=" + this.idmethodeeval + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Methodeeval.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */