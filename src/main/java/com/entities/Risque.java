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
/*     */ @Table(name = "risque")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Risque.findAll", query = "SELECT r FROM Risque r"), @NamedQuery(name = "Risque.findByIdrisque", query = "SELECT r FROM Risque r WHERE r.idrisque = :idrisque"), @NamedQuery(name = "Risque.findByNom", query = "SELECT r FROM Risque r WHERE r.nom = :nom"), @NamedQuery(name = "Risque.findByEtat", query = "SELECT r FROM Risque r WHERE r.etat = :etat"), @NamedQuery(name = "Risque.findByDateEnregistre", query = "SELECT r FROM Risque r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Risque.findByDerniereModif", query = "SELECT r FROM Risque r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Risque
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idrisque")
/*     */   private Long idrisque;
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
/*     */   @OneToMany(mappedBy = "idrisque", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   
/*     */   public Risque() {}
/*     */   
/*     */   public Risque(Long idrisque) {
/*  67 */     this.idrisque = idrisque;
/*     */   }
/*     */   
/*     */   public Long getIdrisque() {
/*  71 */     return this.idrisque;
/*     */   }
/*     */   
/*     */   public void setIdrisque(Long idrisque) {
/*  75 */     this.idrisque = idrisque;
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
/* 122 */     hash += (this.idrisque != null) ? this.idrisque.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Risque)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Risque other = (Risque)object;
/* 133 */     if ((this.idrisque == null && other.idrisque != null) || (this.idrisque != null && !this.idrisque.equals(other.idrisque))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Risque[ idrisque=" + this.idrisque + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Risque.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */