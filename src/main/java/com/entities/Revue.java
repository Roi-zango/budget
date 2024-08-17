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
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Table(name = "revue")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revue.findAll", query = "SELECT r FROM Revue r"), @NamedQuery(name = "Revue.findByIdrevue", query = "SELECT r FROM Revue r WHERE r.idrevue = :idrevue"), @NamedQuery(name = "Revue.findByNom", query = "SELECT r FROM Revue r WHERE r.nom = :nom"), @NamedQuery(name = "Revue.findByEtat", query = "SELECT r FROM Revue r WHERE r.etat = :etat"), @NamedQuery(name = "Revue.findByDateEnregistre", query = "SELECT r FROM Revue r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revue.findByDerniereModif", query = "SELECT r FROM Revue r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Revue
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idrevue")
/*     */   private Long idrevue;
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
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "revue", fetch = FetchType.LAZY)
/*     */   private List<Revueprogramme> revueprogrammeList;
/*     */   
/*     */   public Revue() {}
/*     */   
/*     */   public Revue(Long idrevue) {
/*  73 */     this.idrevue = idrevue;
/*     */   }
/*     */   
/*     */   public Long getIdrevue() {
/*  77 */     return this.idrevue;
/*     */   }
/*     */   
/*     */   public void setIdrevue(Long idrevue) {
/*  81 */     this.idrevue = idrevue;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  85 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  89 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  93 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  97 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 101 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 105 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 109 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 113 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 117 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 121 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revueprogramme> getRevueprogrammeList() {
/* 126 */     return this.revueprogrammeList;
/*     */   }
/*     */   
/*     */   public void setRevueprogrammeList(List<Revueprogramme> revueprogrammeList) {
/* 130 */     this.revueprogrammeList = revueprogrammeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 135 */     int hash = 0;
/* 136 */     hash += (this.idrevue != null) ? this.idrevue.hashCode() : 0;
/* 137 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 143 */     if (!(object instanceof Revue)) {
/* 144 */       return false;
/*     */     }
/* 146 */     Revue other = (Revue)object;
/* 147 */     if ((this.idrevue == null && other.idrevue != null) || (this.idrevue != null && !this.idrevue.equals(other.idrevue))) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     return "entities.Revue[ idrevue=" + this.idrevue + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */