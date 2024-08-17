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
/*     */ @Table(name = "secteur")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Secteur.findAll", query = "SELECT s FROM Secteur s"), @NamedQuery(name = "Secteur.findByIdsecteur", query = "SELECT s FROM Secteur s WHERE s.idsecteur = :idsecteur"), @NamedQuery(name = "Secteur.findByNom", query = "SELECT s FROM Secteur s WHERE s.nom = :nom"), @NamedQuery(name = "Secteur.findByEtat", query = "SELECT s FROM Secteur s WHERE s.etat = :etat"), @NamedQuery(name = "Secteur.findByDateEnregistre", query = "SELECT s FROM Secteur s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Secteur.findByDerniereModif", query = "SELECT s FROM Secteur s WHERE s.derniereModif = :derniereModif")})
/*     */ public class Secteur
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idsecteur")
/*     */   private Long idsecteur;
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
/*     */   @OneToMany(mappedBy = "idsecteur", fetch = FetchType.LAZY)
/*     */   private List<Soussecteur> soussecteurList;
/*     */   
/*     */   public Secteur() {}
/*     */   
/*     */   public Secteur(Long idsecteur) {
/*  67 */     this.idsecteur = idsecteur;
/*     */   }
/*     */   
/*     */   public Long getIdsecteur() {
/*  71 */     return this.idsecteur;
/*     */   }
/*     */   
/*     */   public void setIdsecteur(Long idsecteur) {
/*  75 */     this.idsecteur = idsecteur;
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
/*     */   public List<Soussecteur> getSoussecteurList() {
/* 112 */     return this.soussecteurList;
/*     */   }
/*     */   
/*     */   public void setSoussecteurList(List<Soussecteur> soussecteurList) {
/* 116 */     this.soussecteurList = soussecteurList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idsecteur != null) ? this.idsecteur.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Secteur)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Secteur other = (Secteur)object;
/* 133 */     if ((this.idsecteur == null && other.idsecteur != null) || (this.idsecteur != null && !this.idsecteur.equals(other.idsecteur))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Secteur[ idsecteur=" + this.idsecteur + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Secteur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */