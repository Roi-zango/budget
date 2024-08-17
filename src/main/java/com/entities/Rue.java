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
/*     */ @Table(name = "rue")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Rue.findAll", query = "SELECT r FROM Rue r"), @NamedQuery(name = "Rue.findByIdRue", query = "SELECT r FROM Rue r WHERE r.idRue = :idRue"), @NamedQuery(name = "Rue.findByLibelle", query = "SELECT r FROM Rue r WHERE r.libelle = :libelle"), @NamedQuery(name = "Rue.findByEtat", query = "SELECT r FROM Rue r WHERE r.etat = :etat"), @NamedQuery(name = "Rue.findByDateEnregistre", query = "SELECT r FROM Rue r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Rue.findByDerniereModif", query = "SELECT r FROM Rue r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Rue
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_rue")
/*     */   private Long idRue;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumn(name = "id_quartier", referencedColumnName = "id_quartier")
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Quartier idQuartier;
/*     */   @OneToMany(mappedBy = "idRue", fetch = FetchType.LAZY)
/*     */   private List<Adresse> adresseList;
/*     */   
/*     */   public Rue() {}
/*     */   
/*     */   public Rue(Long idRue) {
/*  72 */     this.idRue = idRue;
/*     */   }
/*     */   
/*     */   public Long getIdRue() {
/*  76 */     return this.idRue;
/*     */   }
/*     */   
/*     */   public void setIdRue(Long idRue) {
/*  80 */     this.idRue = idRue;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  84 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  88 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  92 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  96 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 100 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 104 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 108 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 112 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Quartier getIdQuartier() {
/* 116 */     return this.idQuartier;
/*     */   }
/*     */   
/*     */   public void setIdQuartier(Quartier idQuartier) {
/* 120 */     this.idQuartier = idQuartier;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Adresse> getAdresseList() {
/* 125 */     return this.adresseList;
/*     */   }
/*     */   
/*     */   public void setAdresseList(List<Adresse> adresseList) {
/* 129 */     this.adresseList = adresseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 134 */     int hash = 0;
/* 135 */     hash += (this.idRue != null) ? this.idRue.hashCode() : 0;
/* 136 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 142 */     if (!(object instanceof Rue)) {
/* 143 */       return false;
/*     */     }
/* 145 */     Rue other = (Rue)object;
/* 146 */     if ((this.idRue == null && other.idRue != null) || (this.idRue != null && !this.idRue.equals(other.idRue))) {
/* 147 */       return false;
/*     */     }
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     return "entities.Rue[ idRue=" + this.idRue + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */