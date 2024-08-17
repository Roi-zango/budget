/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ @Table(name = "reglage")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Reglage.findAll", query = "SELECT r FROM Reglage r"), @NamedQuery(name = "Reglage.findByIdReglage", query = "SELECT r FROM Reglage r WHERE r.idReglage = :idReglage"), @NamedQuery(name = "Reglage.findByLibelle", query = "SELECT r FROM Reglage r WHERE r.libelle = :libelle"), @NamedQuery(name = "Reglage.findByValeur", query = "SELECT r FROM Reglage r WHERE r.valeur = :valeur"), @NamedQuery(name = "Reglage.findByEtat", query = "SELECT r FROM Reglage r WHERE r.etat = :etat"), @NamedQuery(name = "Reglage.findByDateEnregistre", query = "SELECT r FROM Reglage r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Reglage.findByDerniereModif", query = "SELECT r FROM Reglage r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Reglage
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_reglage")
/*     */   private Long idReglage;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "valeur")
/*     */   private String valeur;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   
/*     */   public Reglage() {}
/*     */   
/*     */   public Reglage(Long idReglage) {
/*  65 */     this.idReglage = idReglage;
/*     */   }
/*     */   
/*     */   public Long getIdReglage() {
/*  69 */     return this.idReglage;
/*     */   }
/*     */   
/*     */   public void setIdReglage(Long idReglage) {
/*  73 */     this.idReglage = idReglage;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  77 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  81 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public String getValeur() {
/*  85 */     return this.valeur;
/*     */   }
/*     */   
/*     */   public void setValeur(String valeur) {
/*  89 */     this.valeur = valeur;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  93 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  97 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 101 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 105 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 109 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 113 */     this.derniereModif = derniereModif;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 118 */     int hash = 0;
/* 119 */     hash += (this.idReglage != null) ? this.idReglage.hashCode() : 0;
/* 120 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 126 */     if (!(object instanceof Reglage)) {
/* 127 */       return false;
/*     */     }
/* 129 */     Reglage other = (Reglage)object;
/* 130 */     if ((this.idReglage == null && other.idReglage != null) || (this.idReglage != null && !this.idReglage.equals(other.idReglage))) {
/* 131 */       return false;
/*     */     }
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 138 */     return "entities.Reglage[ idReglage=" + this.idReglage + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Reglage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */