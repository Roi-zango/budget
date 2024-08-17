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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "mois")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Mois.findAll", query = "SELECT m FROM Mois m"), @NamedQuery(name = "Mois.findByIdmois", query = "SELECT m FROM Mois m WHERE m.idmois = :idmois"), @NamedQuery(name = "Mois.findByNom", query = "SELECT m FROM Mois m WHERE m.nom = :nom"), @NamedQuery(name = "Mois.findByRang", query = "SELECT m FROM Mois m WHERE m.rang = :rang"), @NamedQuery(name = "Mois.findByChoix", query = "SELECT m FROM Mois m WHERE m.choix = :choix"), @NamedQuery(name = "Mois.findByEtat", query = "SELECT m FROM Mois m WHERE m.etat = :etat"), @NamedQuery(name = "Mois.findByDateEnregistre", query = "SELECT m FROM Mois m WHERE m.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Mois.findByDerniereModif", query = "SELECT m FROM Mois m WHERE m.derniereModif = :derniereModif")})
/*     */ public class Mois
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idmois")
/*     */   private Long idmois;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "rang")
/*     */   private Integer rang;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "choix")
/*     */   private String choix;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idmois", fetch = FetchType.LAZY)
/*     */   private List<Semaine> semaineList;
/*     */   
/*     */   public Mois() {}
/*     */   
/*     */   public Mois(Long idmois) {
/*  74 */     this.idmois = idmois;
/*     */   }
/*     */   
/*     */   public Long getIdmois() {
/*  78 */     return this.idmois;
/*     */   }
/*     */   
/*     */   public void setIdmois(Long idmois) {
/*  82 */     this.idmois = idmois;
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
/*     */   public Integer getRang() {
/*  94 */     return this.rang;
/*     */   }
/*     */   
/*     */   public void setRang(Integer rang) {
/*  98 */     this.rang = rang;
/*     */   }
/*     */   
/*     */   public String getChoix() {
/* 102 */     return this.choix;
/*     */   }
/*     */   
/*     */   public void setChoix(String choix) {
/* 106 */     this.choix = choix;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 110 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 114 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 118 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 122 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 126 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 130 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Semaine> getSemaineList() {
/* 135 */     return this.semaineList;
/*     */   }
/*     */   
/*     */   public void setSemaineList(List<Semaine> semaineList) {
/* 139 */     this.semaineList = semaineList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 144 */     int hash = 0;
/* 145 */     hash += (this.idmois != null) ? this.idmois.hashCode() : 0;
/* 146 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 152 */     if (!(object instanceof Mois)) {
/* 153 */       return false;
/*     */     }
/* 155 */     Mois other = (Mois)object;
/* 156 */     if ((this.idmois == null && other.idmois != null) || (this.idmois != null && !this.idmois.equals(other.idmois))) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 164 */     return "entities.Mois[ idmois=" + this.idmois + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Mois.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */