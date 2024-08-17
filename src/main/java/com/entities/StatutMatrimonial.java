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
/*     */ @Table(name = "statut_matrimonial")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "StatutMatrimonial.findAll", query = "SELECT s FROM StatutMatrimonial s"), @NamedQuery(name = "StatutMatrimonial.findByIdStatutMatrimonial", query = "SELECT s FROM StatutMatrimonial s WHERE s.idStatutMatrimonial = :idStatutMatrimonial"), @NamedQuery(name = "StatutMatrimonial.findByLibelle", query = "SELECT s FROM StatutMatrimonial s WHERE s.libelle = :libelle"), @NamedQuery(name = "StatutMatrimonial.findByEtat", query = "SELECT s FROM StatutMatrimonial s WHERE s.etat = :etat"), @NamedQuery(name = "StatutMatrimonial.findByDateEnregistre", query = "SELECT s FROM StatutMatrimonial s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "StatutMatrimonial.findByDerniereModif", query = "SELECT s FROM StatutMatrimonial s WHERE s.derniereModif = :derniereModif")})
/*     */ public class StatutMatrimonial
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_statut_matrimonial")
/*     */   private Long idStatutMatrimonial;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idStatutMatrimonial", fetch = FetchType.LAZY)
/*     */   private List<Utilisateur> utilisateurList;
/*     */   
/*     */   public StatutMatrimonial() {}
/*     */   
/*     */   public StatutMatrimonial(Long idStatutMatrimonial) {
/*  67 */     this.idStatutMatrimonial = idStatutMatrimonial;
/*     */   }
/*     */   
/*     */   public Long getIdStatutMatrimonial() {
/*  71 */     return this.idStatutMatrimonial;
/*     */   }
/*     */   
/*     */   public void setIdStatutMatrimonial(Long idStatutMatrimonial) {
/*  75 */     this.idStatutMatrimonial = idStatutMatrimonial;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  79 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  83 */     this.libelle = libelle;
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
/*     */   public List<Utilisateur> getUtilisateurList() {
/* 112 */     return this.utilisateurList;
/*     */   }
/*     */   
/*     */   public void setUtilisateurList(List<Utilisateur> utilisateurList) {
/* 116 */     this.utilisateurList = utilisateurList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     int hash = 0;
/* 122 */     hash += (this.idStatutMatrimonial != null) ? this.idStatutMatrimonial.hashCode() : 0;
/* 123 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 129 */     if (!(object instanceof StatutMatrimonial)) {
/* 130 */       return false;
/*     */     }
/* 132 */     StatutMatrimonial other = (StatutMatrimonial)object;
/* 133 */     if ((this.idStatutMatrimonial == null && other.idStatutMatrimonial != null) || (this.idStatutMatrimonial != null && !this.idStatutMatrimonial.equals(other.idStatutMatrimonial))) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "entities.StatutMatrimonial[ idStatutMatrimonial=" + this.idStatutMatrimonial + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\StatutMatrimonial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */