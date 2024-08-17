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
/*     */ import javax.persistence.ManyToMany;
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
/*     */ @Table(name = "groupe_utilisateur")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "GroupeUtilisateur.findAll", query = "SELECT g FROM GroupeUtilisateur g"), @NamedQuery(name = "GroupeUtilisateur.findByIdGroupeUtilisateur", query = "SELECT g FROM GroupeUtilisateur g WHERE g.idGroupeUtilisateur = :idGroupeUtilisateur"), @NamedQuery(name = "GroupeUtilisateur.findByLibelle", query = "SELECT g FROM GroupeUtilisateur g WHERE g.libelle = :libelle"), @NamedQuery(name = "GroupeUtilisateur.findByEtat", query = "SELECT g FROM GroupeUtilisateur g WHERE g.etat = :etat"), @NamedQuery(name = "GroupeUtilisateur.findByDateEnregistre", query = "SELECT g FROM GroupeUtilisateur g WHERE g.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "GroupeUtilisateur.findByDerniereModif", query = "SELECT g FROM GroupeUtilisateur g WHERE g.derniereModif = :derniereModif")})
/*     */ public class GroupeUtilisateur
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_groupe_utilisateur")
/*     */   private Long idGroupeUtilisateur;
/*     */   @Size(max = 50)
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
/*     */   @ManyToMany(mappedBy = "groupeUtilisateurList", fetch = FetchType.LAZY)
/*     */   private List<Compte> compteList;
/*     */   @OneToMany(mappedBy = "idGroupeUtilisateur", fetch = FetchType.LAZY)
/*     */   private List<Privilege> privilegeList;
/*     */   
/*     */   public GroupeUtilisateur() {}
/*     */   
/*     */   public GroupeUtilisateur(Long idGroupeUtilisateur) {
/*  70 */     this.idGroupeUtilisateur = idGroupeUtilisateur;
/*     */   }
/*     */   
/*     */   public Long getIdGroupeUtilisateur() {
/*  74 */     return this.idGroupeUtilisateur;
/*     */   }
/*     */   
/*     */   public void setIdGroupeUtilisateur(Long idGroupeUtilisateur) {
/*  78 */     this.idGroupeUtilisateur = idGroupeUtilisateur;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/*  82 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/*  86 */     this.libelle = libelle;
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
/*     */   @XmlTransient
/*     */   public List<Compte> getCompteList() {
/* 115 */     return this.compteList;
/*     */   }
/*     */   
/*     */   public void setCompteList(List<Compte> compteList) {
/* 119 */     this.compteList = compteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Privilege> getPrivilegeList() {
/* 124 */     return this.privilegeList;
/*     */   }
/*     */   
/*     */   public void setPrivilegeList(List<Privilege> privilegeList) {
/* 128 */     this.privilegeList = privilegeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 133 */     int hash = 0;
/* 134 */     hash += (this.idGroupeUtilisateur != null) ? this.idGroupeUtilisateur.hashCode() : 0;
/* 135 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 141 */     if (!(object instanceof GroupeUtilisateur)) {
/* 142 */       return false;
/*     */     }
/* 144 */     GroupeUtilisateur other = (GroupeUtilisateur)object;
/* 145 */     if ((this.idGroupeUtilisateur == null && other.idGroupeUtilisateur != null) || (this.idGroupeUtilisateur != null && !this.idGroupeUtilisateur.equals(other.idGroupeUtilisateur))) {
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return "entities.GroupeUtilisateur[ idGroupeUtilisateur=" + this.idGroupeUtilisateur + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\GroupeUtilisateur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */