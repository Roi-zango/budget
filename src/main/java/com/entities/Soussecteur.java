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
/*     */ @Table(name = "soussecteur")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Soussecteur.findAll", query = "SELECT s FROM Soussecteur s"), @NamedQuery(name = "Soussecteur.findByIdsoussecteur", query = "SELECT s FROM Soussecteur s WHERE s.idsoussecteur = :idsoussecteur"), @NamedQuery(name = "Soussecteur.findByNom", query = "SELECT s FROM Soussecteur s WHERE s.nom = :nom"), @NamedQuery(name = "Soussecteur.findByEtat", query = "SELECT s FROM Soussecteur s WHERE s.etat = :etat"), @NamedQuery(name = "Soussecteur.findByDateEnregistre", query = "SELECT s FROM Soussecteur s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Soussecteur.findByDerniereModif", query = "SELECT s FROM Soussecteur s WHERE s.derniereModif = :derniereModif")})
/*     */ public class Soussecteur
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idsoussecteur")
/*     */   private Long idsoussecteur;
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
/*     */   @OneToMany(mappedBy = "idsoussecteur", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
/*     */   private List<Institution> institutionList;
/*     */   @JoinColumn(name = "idsecteur", referencedColumnName = "idsecteur")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Secteur idsecteur;
/*     */   @OneToMany(mappedBy = "idsoussecteur", fetch = FetchType.LAZY)
/*     */   private List<Programme> programmeList;
/*     */   
/*     */   public Soussecteur() {}
/*     */   
/*     */   public Soussecteur(Long idsoussecteur) {
/*  74 */     this.idsoussecteur = idsoussecteur;
/*     */   }
/*     */   
/*     */   public Long getIdsoussecteur() {
/*  78 */     return this.idsoussecteur;
/*     */   }
/*     */   
/*     */   public void setIdsoussecteur(Long idsoussecteur) {
/*  82 */     this.idsoussecteur = idsoussecteur;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  86 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  90 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  94 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  98 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 102 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 106 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 110 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 114 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Institution> getInstitutionList() {
/* 119 */     return this.institutionList;
/*     */   }
/*     */   
/*     */   public void setInstitutionList(List<Institution> institutionList) {
/* 123 */     this.institutionList = institutionList;
/*     */   }
/*     */   
/*     */   public Secteur getIdsecteur() {
/* 127 */     return this.idsecteur;
/*     */   }
/*     */   
/*     */   public void setIdsecteur(Secteur idsecteur) {
/* 131 */     this.idsecteur = idsecteur;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Programme> getProgrammeList() {
/* 136 */     return this.programmeList;
/*     */   }
/*     */   
/*     */   public void setProgrammeList(List<Programme> programmeList) {
/* 140 */     this.programmeList = programmeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     int hash = 0;
/* 146 */     hash += (this.idsoussecteur != null) ? this.idsoussecteur.hashCode() : 0;
/* 147 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 153 */     if (!(object instanceof Soussecteur)) {
/* 154 */       return false;
/*     */     }
/* 156 */     Soussecteur other = (Soussecteur)object;
/* 157 */     if ((this.idsoussecteur == null && other.idsoussecteur != null) || (this.idsoussecteur != null && !this.idsoussecteur.equals(other.idsoussecteur))) {
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     return "entities.Soussecteur[ idsoussecteur=" + this.idsoussecteur + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Soussecteur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */