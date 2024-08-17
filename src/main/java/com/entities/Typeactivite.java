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
/*     */ @Table(name = "typeactivite")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Typeactivite.findAll", query = "SELECT t FROM Typeactivite t"), @NamedQuery(name = "Typeactivite.findByIdtypeactivite", query = "SELECT t FROM Typeactivite t WHERE t.idtypeactivite = :idtypeactivite"), @NamedQuery(name = "Typeactivite.findByNom", query = "SELECT t FROM Typeactivite t WHERE t.nom = :nom"), @NamedQuery(name = "Typeactivite.findByNumero", query = "SELECT t FROM Typeactivite t WHERE t.numero = :numero"), @NamedQuery(name = "Typeactivite.findByEtat", query = "SELECT t FROM Typeactivite t WHERE t.etat = :etat"), @NamedQuery(name = "Typeactivite.findByDateEnregistre", query = "SELECT t FROM Typeactivite t WHERE t.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Typeactivite.findByDerniereModif", query = "SELECT t FROM Typeactivite t WHERE t.derniereModif = :derniereModif")})
/*     */ public class Typeactivite
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idtypeactivite")
/*     */   private Long idtypeactivite;
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
/*     */   @OneToMany(mappedBy = "idtypeactivite", fetch = FetchType.LAZY)
/*     */   private List<Activite> activiteList;
/*     */   
/*     */   public Typeactivite() {}
/*     */   
/*     */   public Typeactivite(Long idtypeactivite) {
/*  70 */     this.idtypeactivite = idtypeactivite;
/*     */   }
/*     */   
/*     */   public Long getIdtypeactivite() {
/*  74 */     return this.idtypeactivite;
/*     */   }
/*     */   
/*     */   public void setIdtypeactivite(Long idtypeactivite) {
/*  78 */     this.idtypeactivite = idtypeactivite;
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
/* 133 */     hash += (this.idtypeactivite != null) ? this.idtypeactivite.hashCode() : 0;
/* 134 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 140 */     if (!(object instanceof Typeactivite)) {
/* 141 */       return false;
/*     */     }
/* 143 */     Typeactivite other = (Typeactivite)object;
/* 144 */     if ((this.idtypeactivite == null && other.idtypeactivite != null) || (this.idtypeactivite != null && !this.idtypeactivite.equals(other.idtypeactivite))) {
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     return "entities.Typeactivite[ idtypeactivite=" + this.idtypeactivite + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typeactivite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */