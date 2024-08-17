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
/*     */ @Table(name = "typefinancement")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Typefinancement.findAll", query = "SELECT t FROM Typefinancement t"), @NamedQuery(name = "Typefinancement.findByIdtypefinancement", query = "SELECT t FROM Typefinancement t WHERE t.idtypefinancement = :idtypefinancement"), @NamedQuery(name = "Typefinancement.findByNom", query = "SELECT t FROM Typefinancement t WHERE t.nom = :nom"), @NamedQuery(name = "Typefinancement.findByEtat", query = "SELECT t FROM Typefinancement t WHERE t.etat = :etat"), @NamedQuery(name = "Typefinancement.findByDateEnregistre", query = "SELECT t FROM Typefinancement t WHERE t.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Typefinancement.findByDerniereModif", query = "SELECT t FROM Typefinancement t WHERE t.derniereModif = :derniereModif")})
/*     */ public class Typefinancement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idtypefinancement")
/*     */   private Long idtypefinancement;
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
/*     */   @OneToMany(mappedBy = "idtypefinancement", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   
/*     */   public Typefinancement() {}
/*     */   
/*     */   public Typefinancement(Long idtypefinancement) {
/*  67 */     this.idtypefinancement = idtypefinancement;
/*     */   }
/*     */   
/*     */   public Long getIdtypefinancement() {
/*  71 */     return this.idtypefinancement;
/*     */   }
/*     */   
/*     */   public void setIdtypefinancement(Long idtypefinancement) {
/*  75 */     this.idtypefinancement = idtypefinancement;
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
/*     */   public List<Tache> getTacheList() {
/* 112 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/* 116 */     this.tacheList = tacheList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idtypefinancement != null) ? this.idtypefinancement.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Typefinancement)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Typefinancement other = (Typefinancement)object;
/* 133 */     if ((this.idtypefinancement == null && other.idtypefinancement != null) || (this.idtypefinancement != null && !this.idtypefinancement.equals(other.idtypefinancement))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Typefinancement[ idtypefinancement=" + this.idtypefinancement + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typefinancement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */