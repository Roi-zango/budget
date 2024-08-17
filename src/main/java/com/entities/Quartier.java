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
/*     */ @Table(name = "quartier")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Quartier.findAll", query = "SELECT q FROM Quartier q"), @NamedQuery(name = "Quartier.findByIdQuartier", query = "SELECT q FROM Quartier q WHERE q.idQuartier = :idQuartier"), @NamedQuery(name = "Quartier.findByLibelle", query = "SELECT q FROM Quartier q WHERE q.libelle = :libelle"), @NamedQuery(name = "Quartier.findByEtat", query = "SELECT q FROM Quartier q WHERE q.etat = :etat"), @NamedQuery(name = "Quartier.findByDateEnregistre", query = "SELECT q FROM Quartier q WHERE q.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Quartier.findByDerniereModif", query = "SELECT q FROM Quartier q WHERE q.derniereModif = :derniereModif")})
/*     */ public class Quartier
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_quartier")
/*     */   private Long idQuartier;
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
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idQuartier", fetch = FetchType.LAZY)
/*     */   private List<Rue> rueList;
/*     */   @JoinColumn(name = "id_ville", referencedColumnName = "id_ville")
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Ville idVille;
/*     */   @OneToMany(mappedBy = "idQuartier", fetch = FetchType.LAZY)
/*     */   private List<Adresse> adresseList;
/*     */   
/*     */   public Quartier() {}
/*     */   
/*     */   public Quartier(Long idQuartier) {
/*  75 */     this.idQuartier = idQuartier;
/*     */   }
/*     */   
/*     */   public Long getIdQuartier() {
/*  79 */     return this.idQuartier;
/*     */   }
/*     */   
/*     */   public void setIdQuartier(Long idQuartier) {
/*  83 */     this.idQuartier = idQuartier;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  87 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  91 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  95 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  99 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 103 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 107 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 111 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 115 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Rue> getRueList() {
/* 120 */     return this.rueList;
/*     */   }
/*     */   
/*     */   public void setRueList(List<Rue> rueList) {
/* 124 */     this.rueList = rueList;
/*     */   }
/*     */   
/*     */   public Ville getIdVille() {
/* 128 */     return this.idVille;
/*     */   }
/*     */   
/*     */   public void setIdVille(Ville idVille) {
/* 132 */     this.idVille = idVille;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Adresse> getAdresseList() {
/* 137 */     return this.adresseList;
/*     */   }
/*     */   
/*     */   public void setAdresseList(List<Adresse> adresseList) {
/* 141 */     this.adresseList = adresseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     int hash = 0;
/* 147 */     hash += (this.idQuartier != null) ? this.idQuartier.hashCode() : 0;
/* 148 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 154 */     if (!(object instanceof Quartier)) {
/* 155 */       return false;
/*     */     }
/* 157 */     Quartier other = (Quartier)object;
/* 158 */     if ((this.idQuartier == null && other.idQuartier != null) || (this.idQuartier != null && !this.idQuartier.equals(other.idQuartier))) {
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return "entities.Quartier[ idQuartier=" + this.idQuartier + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Quartier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */