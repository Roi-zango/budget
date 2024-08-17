/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigInteger;
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
/*     */ @Table(name = "rubriquedifficulte")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Rubriquedifficulte.findAll", query = "SELECT r FROM Rubriquedifficulte r"), @NamedQuery(name = "Rubriquedifficulte.findByIdrubriquedifficulte", query = "SELECT r FROM Rubriquedifficulte r WHERE r.idrubriquedifficulte = :idrubriquedifficulte"), @NamedQuery(name = "Rubriquedifficulte.findByIdprogramme", query = "SELECT r FROM Rubriquedifficulte r WHERE r.idprogramme = :idprogramme"), @NamedQuery(name = "Rubriquedifficulte.findByNom", query = "SELECT r FROM Rubriquedifficulte r WHERE r.nom = :nom"), @NamedQuery(name = "Rubriquedifficulte.findByEtat", query = "SELECT r FROM Rubriquedifficulte r WHERE r.etat = :etat"), @NamedQuery(name = "Rubriquedifficulte.findByDateEnregistre", query = "SELECT r FROM Rubriquedifficulte r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Rubriquedifficulte.findByDerniereModif", query = "SELECT r FROM Rubriquedifficulte r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Rubriquedifficulte
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idrubriquedifficulte")
/*     */   private Long idrubriquedifficulte;
/*     */   @Column(name = "idprogramme")
/*     */   private BigInteger idprogramme;
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
/*     */   @OneToMany(mappedBy = "idrubriquedifficulte", fetch = FetchType.LAZY)
/*     */   private List<Revuedifficilte> revuedifficilteList;
/*     */   
/*     */   public Rubriquedifficulte() {}
/*     */   
/*     */   public Rubriquedifficulte(Long idrubriquedifficulte) {
/*  71 */     this.idrubriquedifficulte = idrubriquedifficulte;
/*     */   }
/*     */   
/*     */   public Long getIdrubriquedifficulte() {
/*  75 */     return this.idrubriquedifficulte;
/*     */   }
/*     */   
/*     */   public void setIdrubriquedifficulte(Long idrubriquedifficulte) {
/*  79 */     this.idrubriquedifficulte = idrubriquedifficulte;
/*     */   }
/*     */   
/*     */   public BigInteger getIdprogramme() {
/*  83 */     return this.idprogramme;
/*     */   }
/*     */   
/*     */   public void setIdprogramme(BigInteger idprogramme) {
/*  87 */     this.idprogramme = idprogramme;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  91 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  95 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  99 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 103 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 107 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 111 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 115 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 119 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revuedifficilte> getRevuedifficilteList() {
/* 124 */     return this.revuedifficilteList;
/*     */   }
/*     */   
/*     */   public void setRevuedifficilteList(List<Revuedifficilte> revuedifficilteList) {
/* 128 */     this.revuedifficilteList = revuedifficilteList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 133 */     int hash = 0;
/* 134 */     hash += (this.idrubriquedifficulte != null) ? this.idrubriquedifficulte.hashCode() : 0;
/* 135 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 141 */     if (!(object instanceof Rubriquedifficulte)) {
/* 142 */       return false;
/*     */     }
/* 144 */     Rubriquedifficulte other = (Rubriquedifficulte)object;
/* 145 */     if ((this.idrubriquedifficulte == null && other.idrubriquedifficulte != null) || (this.idrubriquedifficulte != null && !this.idrubriquedifficulte.equals(other.idrubriquedifficulte))) {
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return "entities.Rubriquedifficulte[ idrubriquedifficulte=" + this.idrubriquedifficulte + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rubriquedifficulte.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */