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
/*     */ @Table(name = "basejuridique")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Basejuridique.findAll", query = "SELECT b FROM Basejuridique b"), @NamedQuery(name = "Basejuridique.findByIdbasejuridique", query = "SELECT b FROM Basejuridique b WHERE b.idbasejuridique = :idbasejuridique"), @NamedQuery(name = "Basejuridique.findByNom", query = "SELECT b FROM Basejuridique b WHERE b.nom = :nom"), @NamedQuery(name = "Basejuridique.findByEtat", query = "SELECT b FROM Basejuridique b WHERE b.etat = :etat"), @NamedQuery(name = "Basejuridique.findByDateEnregistre", query = "SELECT b FROM Basejuridique b WHERE b.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Basejuridique.findByDerniereModif", query = "SELECT b FROM Basejuridique b WHERE b.derniereModif = :derniereModif")})
/*     */ public class Basejuridique
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idbasejuridique")
/*     */   private Long idbasejuridique;
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
/*     */   @OneToMany(mappedBy = "idbasejuridique", fetch = FetchType.LAZY)
/*     */   private List<Mission> missionList;
/*     */   
/*     */   public Basejuridique() {}
/*     */   
/*     */   public Basejuridique(Long idbasejuridique) {
/*  67 */     this.idbasejuridique = idbasejuridique;
/*     */   }
/*     */   
/*     */   public Long getIdbasejuridique() {
/*  71 */     return this.idbasejuridique;
/*     */   }
/*     */   
/*     */   public void setIdbasejuridique(Long idbasejuridique) {
/*  75 */     this.idbasejuridique = idbasejuridique;
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
/*     */   public List<Mission> getMissionList() {
/* 112 */     return this.missionList;
/*     */   }
/*     */   
/*     */   public void setMissionList(List<Mission> missionList) {
/* 116 */     this.missionList = missionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idbasejuridique != null) ? this.idbasejuridique.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Basejuridique)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Basejuridique other = (Basejuridique)object;
/* 133 */     if ((this.idbasejuridique == null && other.idbasejuridique != null) || (this.idbasejuridique != null && !this.idbasejuridique.equals(other.idbasejuridique))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Basejuridique[ idbasejuridique=" + this.idbasejuridique + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Basejuridique.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */