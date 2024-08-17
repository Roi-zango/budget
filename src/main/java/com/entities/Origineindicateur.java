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
/*     */ @Table(name = "origineindicateur")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Origineindicateur.findAll", query = "SELECT o FROM Origineindicateur o"), @NamedQuery(name = "Origineindicateur.findByIdorigineindicateur", query = "SELECT o FROM Origineindicateur o WHERE o.idorigineindicateur = :idorigineindicateur"), @NamedQuery(name = "Origineindicateur.findByNom", query = "SELECT o FROM Origineindicateur o WHERE o.nom = :nom"), @NamedQuery(name = "Origineindicateur.findByEtat", query = "SELECT o FROM Origineindicateur o WHERE o.etat = :etat"), @NamedQuery(name = "Origineindicateur.findByDateEnregistre", query = "SELECT o FROM Origineindicateur o WHERE o.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Origineindicateur.findByDerniereModif", query = "SELECT o FROM Origineindicateur o WHERE o.derniereModif = :derniereModif")})
/*     */ public class Origineindicateur
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idorigineindicateur")
/*     */   private Long idorigineindicateur;
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
/*     */   @OneToMany(mappedBy = "idorigineindicateur", fetch = FetchType.LAZY)
/*     */   private List<Indicateurperformance> indicateurperformanceList;
/*     */   
/*     */   public Origineindicateur() {}
/*     */   
/*     */   public Origineindicateur(Long idorigineindicateur) {
/*  67 */     this.idorigineindicateur = idorigineindicateur;
/*     */   }
/*     */   
/*     */   public Long getIdorigineindicateur() {
/*  71 */     return this.idorigineindicateur;
/*     */   }
/*     */   
/*     */   public void setIdorigineindicateur(Long idorigineindicateur) {
/*  75 */     this.idorigineindicateur = idorigineindicateur;
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
/*     */   public List<Indicateurperformance> getIndicateurperformanceList() {
/* 112 */     return this.indicateurperformanceList;
/*     */   }
/*     */   
/*     */   public void setIndicateurperformanceList(List<Indicateurperformance> indicateurperformanceList) {
/* 116 */     this.indicateurperformanceList = indicateurperformanceList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idorigineindicateur != null) ? this.idorigineindicateur.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Origineindicateur)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Origineindicateur other = (Origineindicateur)object;
/* 133 */     if ((this.idorigineindicateur == null && other.idorigineindicateur != null) || (this.idorigineindicateur != null && !this.idorigineindicateur.equals(other.idorigineindicateur))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Origineindicateur[ idorigineindicateur=" + this.idorigineindicateur + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Origineindicateur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */