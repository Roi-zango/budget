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
/*     */ @Table(name = "zone")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Zone.findAll", query = "SELECT z FROM Zone z"), @NamedQuery(name = "Zone.findByIdzone", query = "SELECT z FROM Zone z WHERE z.idzone = :idzone"), @NamedQuery(name = "Zone.findByNom", query = "SELECT z FROM Zone z WHERE z.nom = :nom"), @NamedQuery(name = "Zone.findByEtat", query = "SELECT z FROM Zone z WHERE z.etat = :etat"), @NamedQuery(name = "Zone.findByDateEnregistre", query = "SELECT z FROM Zone z WHERE z.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Zone.findByDerniereModif", query = "SELECT z FROM Zone z WHERE z.derniereModif = :derniereModif")})
/*     */ public class Zone
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idzone")
/*     */   private Long idzone;
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
/*     */   @OneToMany(mappedBy = "idzone", fetch = FetchType.LAZY)
/*     */   private List<Action> actionList;
/*     */   
/*     */   public Zone() {}
/*     */   
/*     */   public Zone(Long idzone) {
/*  67 */     this.idzone = idzone;
/*     */   }
/*     */   
/*     */   public Long getIdzone() {
/*  71 */     return this.idzone;
/*     */   }
/*     */   
/*     */   public void setIdzone(Long idzone) {
/*  75 */     this.idzone = idzone;
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
/*     */   public List<Action> getActionList() {
/* 112 */     return this.actionList;
/*     */   }
/*     */   
/*     */   public void setActionList(List<Action> actionList) {
/* 116 */     this.actionList = actionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idzone != null) ? this.idzone.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof Zone)) {
/* 130 */       return false;
/*     */     }
/* 132 */     Zone other = (Zone)object;
/* 133 */     if ((this.idzone == null && other.idzone != null) || (this.idzone != null && !this.idzone.equals(other.idzone))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.Zone[ idzone=" + this.idzone + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Zone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */