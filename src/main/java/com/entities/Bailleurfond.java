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
/*     */ @Table(name = "bailleurfond")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Bailleurfond.findAll", query = "SELECT b FROM Bailleurfond b"), @NamedQuery(name = "Bailleurfond.findByIdbailleurfond", query = "SELECT b FROM Bailleurfond b WHERE b.idbailleurfond = :idbailleurfond"), @NamedQuery(name = "Bailleurfond.findByNom", query = "SELECT b FROM Bailleurfond b WHERE b.nom = :nom"), @NamedQuery(name = "Bailleurfond.findByEtat", query = "SELECT b FROM Bailleurfond b WHERE b.etat = :etat"), @NamedQuery(name = "Bailleurfond.findByDateEnregistre", query = "SELECT b FROM Bailleurfond b WHERE b.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Bailleurfond.findByDerniereModif", query = "SELECT b FROM Bailleurfond b WHERE b.derniereModif = :derniereModif")})
/*     */ public class Bailleurfond
/*     */   implements Serializable
/*     */ {
/*     */   @OneToMany(mappedBy = "idbailleurfond", fetch = FetchType.LAZY)
/*     */   private List<Recette> recetteList;
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idbailleurfond")
/*     */   private Long idbailleurfond;
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
/*     */   @OneToMany(mappedBy = "idbailleurfond", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   @JoinColumn(name = "idsourcefinancement", referencedColumnName = "idsourcefinancement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Sourcefinancement idsourcefinancement;
/*     */   
/*     */   public Bailleurfond() {}
/*     */   
/*     */   public Bailleurfond(Long idbailleurfond) {
/*  74 */     this.idbailleurfond = idbailleurfond;
/*     */   }
/*     */   
/*     */   public Long getIdbailleurfond() {
/*  78 */     return this.idbailleurfond;
/*     */   }
/*     */   
/*     */   public void setIdbailleurfond(Long idbailleurfond) {
/*  82 */     this.idbailleurfond = idbailleurfond;
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
/*     */   public List<Tache> getTacheList() {
/* 119 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/* 123 */     this.tacheList = tacheList;
/*     */   }
/*     */   
/*     */   public Sourcefinancement getIdsourcefinancement() {
/* 127 */     return this.idsourcefinancement;
/*     */   }
/*     */   
/*     */   public void setIdsourcefinancement(Sourcefinancement idsourcefinancement) {
/* 131 */     this.idsourcefinancement = idsourcefinancement;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     int hash = 0;
/* 137 */     hash += (this.idbailleurfond != null) ? this.idbailleurfond.hashCode() : 0;
/* 138 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 144 */     if (!(object instanceof Bailleurfond)) {
/* 145 */       return false;
/*     */     }
/* 147 */     Bailleurfond other = (Bailleurfond)object;
/* 148 */     if ((this.idbailleurfond == null && other.idbailleurfond != null) || (this.idbailleurfond != null && !this.idbailleurfond.equals(other.idbailleurfond))) {
/* 149 */       return false;
/*     */     }
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     return "entities.Bailleurfond[ idbailleurfond=" + this.idbailleurfond + " ]";
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Recette> getRecetteList() {
/* 161 */     return this.recetteList;
/*     */   }
/*     */   
/*     */   public void setRecetteList(List<Recette> recetteList) {
/* 165 */     this.recetteList = recetteList;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Bailleurfond.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */