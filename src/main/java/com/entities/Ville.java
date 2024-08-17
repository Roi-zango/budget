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
/*     */ @Table(name = "ville")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v"), @NamedQuery(name = "Ville.findByIdVille", query = "SELECT v FROM Ville v WHERE v.idVille = :idVille"), @NamedQuery(name = "Ville.findByLibelle", query = "SELECT v FROM Ville v WHERE v.libelle = :libelle"), @NamedQuery(name = "Ville.findByEtat", query = "SELECT v FROM Ville v WHERE v.etat = :etat"), @NamedQuery(name = "Ville.findByDateEnregistre", query = "SELECT v FROM Ville v WHERE v.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Ville.findByDerniereModif", query = "SELECT v FROM Ville v WHERE v.derniereModif = :derniereModif")})
/*     */ public class Ville
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_ville")
/*     */   private Long idVille;
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
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idVille", fetch = FetchType.LAZY)
/*     */   private List<Quartier> quartierList;
/*     */   @JoinColumn(name = "id_pays", referencedColumnName = "id_pays")
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Pays idPays;
/*     */   @OneToMany(mappedBy = "idVille", fetch = FetchType.LAZY)
/*     */   private List<Adresse> adresseList;
/*     */   
/*     */   public Ville() {}
/*     */   
/*     */   public Ville(Long idVille) {
/*  75 */     this.idVille = idVille;
/*     */   }
/*     */   
/*     */   public Long getIdVille() {
/*  79 */     return this.idVille;
/*     */   }
/*     */   
/*     */   public void setIdVille(Long idVille) {
/*  83 */     this.idVille = idVille;
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
/*     */   public List<Quartier> getQuartierList() {
/* 120 */     return this.quartierList;
/*     */   }
/*     */   
/*     */   public void setQuartierList(List<Quartier> quartierList) {
/* 124 */     this.quartierList = quartierList;
/*     */   }
/*     */   
/*     */   public Pays getIdPays() {
/* 128 */     return this.idPays;
/*     */   }
/*     */   
/*     */   public void setIdPays(Pays idPays) {
/* 132 */     this.idPays = idPays;
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
/* 147 */     hash += (this.idVille != null) ? this.idVille.hashCode() : 0;
/* 148 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 154 */     if (!(object instanceof Ville)) {
/* 155 */       return false;
/*     */     }
/* 157 */     Ville other = (Ville)object;
/* 158 */     if ((this.idVille == null && other.idVille != null) || (this.idVille != null && !this.idVille.equals(other.idVille))) {
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return "entities.Ville[ idVille=" + this.idVille + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Ville.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */