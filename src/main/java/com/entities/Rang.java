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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "rang")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Rang.findAll", query = "SELECT r FROM Rang r"), @NamedQuery(name = "Rang.findByIdrang", query = "SELECT r FROM Rang r WHERE r.idrang = :idrang"), @NamedQuery(name = "Rang.findByNom", query = "SELECT r FROM Rang r WHERE r.nom = :nom"), @NamedQuery(name = "Rang.findByNumero", query = "SELECT r FROM Rang r WHERE r.numero = :numero"), @NamedQuery(name = "Rang.findByEtat", query = "SELECT r FROM Rang r WHERE r.etat = :etat"), @NamedQuery(name = "Rang.findByDateEnregistre", query = "SELECT r FROM Rang r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Rang.findByDerniereModif", query = "SELECT r FROM Rang r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Rang
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idrang")
/*     */   private Long idrang;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "numero")
/*     */   private Integer numero;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idrang", fetch = FetchType.LAZY)
/*     */   private List<Activite> activiteList;
/*     */   
/*     */   public Rang() {}
/*     */   
/*     */   public Rang(Long idrang) {
/*  70 */     this.idrang = idrang;
/*     */   }
/*     */   
/*     */   public Long getIdrang() {
/*  74 */     return this.idrang;
/*     */   }
/*     */   
/*     */   public void setIdrang(Long idrang) {
/*  78 */     this.idrang = idrang;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  82 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  86 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Integer getNumero() {
/*  90 */     return this.numero;
/*     */   }
/*     */   
/*     */   public void setNumero(Integer numero) {
/*  94 */     this.numero = numero;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  98 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 102 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 106 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 110 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 114 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 118 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Activite> getActiviteList() {
/* 123 */     return this.activiteList;
/*     */   }
/*     */   
/*     */   public void setActiviteList(List<Activite> activiteList) {
/* 127 */     this.activiteList = activiteList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 132 */     int hash = 0;
/* 133 */     hash += (this.idrang != null) ? this.idrang.hashCode() : 0;
/* 134 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 140 */     if (!(object instanceof Rang)) {
/* 141 */       return false;
/*     */     }
/* 143 */     Rang other = (Rang)object;
/* 144 */     if ((this.idrang == null && other.idrang != null) || (this.idrang != null && !this.idrang.equals(other.idrang))) {
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     return "entities.Rang[ idrang=" + this.idrang + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rang.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */