/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Entity
/*     */ @Table(name = "privilege")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"), @NamedQuery(name = "Privilege.findByIdPrivilege", query = "SELECT p FROM Privilege p WHERE p.idPrivilege = :idPrivilege"), @NamedQuery(name = "Privilege.findByConfiguration", query = "SELECT p FROM Privilege p WHERE p.configuration = :configuration"), @NamedQuery(name = "Privilege.findByEtat", query = "SELECT p FROM Privilege p WHERE p.etat = :etat"), @NamedQuery(name = "Privilege.findByDateEnregistre", query = "SELECT p FROM Privilege p WHERE p.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Privilege.findByDerniereModif", query = "SELECT p FROM Privilege p WHERE p.derniereModif = :derniereModif")})
/*     */ public class Privilege
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_privilege")
/*     */   private Long idPrivilege;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "configuration")
/*     */   private String configuration;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Compte idCompte;
/*     */   @JoinColumn(name = "id_groupe_utilisateur", referencedColumnName = "id_groupe_utilisateur")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private GroupeUtilisateur idGroupeUtilisateur;
/*     */   
/*     */   public Privilege() {}
/*     */   
/*     */   public Privilege(Long idPrivilege) {
/*  70 */     this.idPrivilege = idPrivilege;
/*     */   }
/*     */   
/*     */   public Long getIdPrivilege() {
/*  74 */     return this.idPrivilege;
/*     */   }
/*     */   
/*     */   public void setIdPrivilege(Long idPrivilege) {
/*  78 */     this.idPrivilege = idPrivilege;
/*     */   }
/*     */   
/*     */   public String getConfiguration() {
/*  82 */     return this.configuration;
/*     */   }
/*     */   
/*     */   public void setConfiguration(String configuration) {
/*  86 */     this.configuration = configuration;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/*  90 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  94 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/*  98 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 102 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 106 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 110 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Compte getIdCompte() {
/* 114 */     return this.idCompte;
/*     */   }
/*     */   
/*     */   public void setIdCompte(Compte idCompte) {
/* 118 */     this.idCompte = idCompte;
/*     */   }
/*     */   
/*     */   public GroupeUtilisateur getIdGroupeUtilisateur() {
/* 122 */     return this.idGroupeUtilisateur;
/*     */   }
/*     */   
/*     */   public void setIdGroupeUtilisateur(GroupeUtilisateur idGroupeUtilisateur) {
/* 126 */     this.idGroupeUtilisateur = idGroupeUtilisateur;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     int hash = 0;
/* 132 */     hash += (this.idPrivilege != null) ? this.idPrivilege.hashCode() : 0;
/* 133 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 139 */     if (!(object instanceof Privilege)) {
/* 140 */       return false;
/*     */     }
/* 142 */     Privilege other = (Privilege)object;
/* 143 */     if ((this.idPrivilege == null && other.idPrivilege != null) || (this.idPrivilege != null && !this.idPrivilege.equals(other.idPrivilege))) {
/* 144 */       return false;
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     return "entities.Privilege[ idPrivilege=" + this.idPrivilege + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Privilege.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */