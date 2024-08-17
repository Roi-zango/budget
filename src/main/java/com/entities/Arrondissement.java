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
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Table(name = "arrondissement")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Arrondissement.findAll", query = "SELECT a FROM Arrondissement a"), @NamedQuery(name = "Arrondissement.findByIdarrondissement", query = "SELECT a FROM Arrondissement a WHERE a.idarrondissement = :idarrondissement"), @NamedQuery(name = "Arrondissement.findByNom", query = "SELECT a FROM Arrondissement a WHERE a.nom = :nom"), @NamedQuery(name = "Arrondissement.findByEtat", query = "SELECT a FROM Arrondissement a WHERE a.etat = :etat"), @NamedQuery(name = "Arrondissement.findByDateEnregistre", query = "SELECT a FROM Arrondissement a WHERE a.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Arrondissement.findByDerniereModif", query = "SELECT a FROM Arrondissement a WHERE a.derniereModif = :derniereModif")})
/*     */ public class Arrondissement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idarrondissement")
/*     */   private Long idarrondissement;
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
/*     */   @JoinColumn(name = "iddepartement", referencedColumnName = "iddepartement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Departement iddepartement;
/*     */   @OneToMany(mappedBy = "idarrondissement", fetch = FetchType.LAZY)
/*     */   private List<Utilisateur> utilisateurList;
/*     */   @OneToMany(mappedBy = "idarrondissement", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   
/*     */   public Arrondissement() {}
/*     */   
/*     */   public Arrondissement(Long idarrondissement) {
/*  74 */     this.idarrondissement = idarrondissement;
/*     */   }
/*     */   
/*     */   public Long getIdarrondissement() {
/*  78 */     return this.idarrondissement;
/*     */   }
/*     */   
/*     */   public void setIdarrondissement(Long idarrondissement) {
/*  82 */     this.idarrondissement = idarrondissement;
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
/*     */   public String getEtat() {
/*  94 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/*  98 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 102 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 106 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 110 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 114 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Departement getIddepartement() {
/* 118 */     return this.iddepartement;
/*     */   }
/*     */   
/*     */   public void setIddepartement(Departement iddepartement) {
/* 122 */     this.iddepartement = iddepartement;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Utilisateur> getUtilisateurList() {
/* 127 */     return this.utilisateurList;
/*     */   }
/*     */   
/*     */   public void setUtilisateurList(List<Utilisateur> utilisateurList) {
/* 131 */     this.utilisateurList = utilisateurList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 136 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 140 */     this.structureList = structureList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     int hash = 0;
/* 146 */     hash += (this.idarrondissement != null) ? this.idarrondissement.hashCode() : 0;
/* 147 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 153 */     if (!(object instanceof Arrondissement)) {
/* 154 */       return false;
/*     */     }
/* 156 */     Arrondissement other = (Arrondissement)object;
/* 157 */     if ((this.idarrondissement == null && other.idarrondissement != null) || (this.idarrondissement != null && !this.idarrondissement.equals(other.idarrondissement))) {
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     return "entities.Arrondissement[ idarrondissement=" + this.idarrondissement + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Arrondissement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */