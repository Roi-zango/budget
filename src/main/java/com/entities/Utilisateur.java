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
/*     */ import javax.persistence.ManyToMany;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "utilisateur")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"), @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"), @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"), @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"), @NamedQuery(name = "Utilisateur.findByDateNaissance", query = "SELECT u FROM Utilisateur u WHERE u.dateNaissance = :dateNaissance"), @NamedQuery(name = "Utilisateur.findByCni", query = "SELECT u FROM Utilisateur u WHERE u.cni = :cni"), @NamedQuery(name = "Utilisateur.findBySexe", query = "SELECT u FROM Utilisateur u WHERE u.sexe = :sexe"), @NamedQuery(name = "Utilisateur.findByPhoto", query = "SELECT u FROM Utilisateur u WHERE u.photo = :photo"), @NamedQuery(name = "Utilisateur.findByPhotoRelatif", query = "SELECT u FROM Utilisateur u WHERE u.photoRelatif = :photoRelatif"), @NamedQuery(name = "Utilisateur.findByEtat", query = "SELECT u FROM Utilisateur u WHERE u.etat = :etat"), @NamedQuery(name = "Utilisateur.findByDateEnregistre", query = "SELECT u FROM Utilisateur u WHERE u.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Utilisateur.findByDerniereModif", query = "SELECT u FROM Utilisateur u WHERE u.derniereModif = :derniereModif")})
/*     */ public class Utilisateur
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_utilisateur")
/*     */   private Long idUtilisateur;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "prenom")
/*     */   private String prenom;
/*     */   @Column(name = "date_naissance")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateNaissance;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "cni")
/*     */   private String cni;
/*     */   @Size(max = 50)
/*     */   @Column(name = "sexe")
/*     */   private String sexe;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "photo")
/*     */   private String photo;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "photo_relatif")
/*     */   private String photoRelatif;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @ManyToMany(mappedBy = "utilisateurList", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Adresse idAdresse;
/*     */   @JoinColumn(name = "idarrondissement", referencedColumnName = "idarrondissement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Arrondissement idarrondissement;
/*     */   @JoinColumn(name = "id_pays", referencedColumnName = "id_pays")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Pays idPays;
/*     */   @JoinColumn(name = "id_statut_matrimonial", referencedColumnName = "id_statut_matrimonial")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private StatutMatrimonial idStatutMatrimonial;
/*     */   @OneToMany(mappedBy = "idUtilisateur", fetch = FetchType.LAZY)
/*     */   private List<Compte> compteList;
/*     */   
/*     */   public Utilisateur() {}
/*     */   
/*     */   public Utilisateur(Long idUtilisateur) {
/* 108 */     this.idUtilisateur = idUtilisateur;
/*     */   }
/*     */   
/*     */   public Long getIdUtilisateur() {
/* 112 */     return this.idUtilisateur;
/*     */   }
/*     */   
/*     */   public void setIdUtilisateur(Long idUtilisateur) {
/* 116 */     this.idUtilisateur = idUtilisateur;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 120 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 124 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getPrenom() {
/* 128 */     return this.prenom;
/*     */   }
/*     */   
/*     */   public void setPrenom(String prenom) {
/* 132 */     this.prenom = prenom;
/*     */   }
/*     */   
/*     */   public Date getDateNaissance() {
/* 136 */     return this.dateNaissance;
/*     */   }
/*     */   
/*     */   public void setDateNaissance(Date dateNaissance) {
/* 140 */     this.dateNaissance = dateNaissance;
/*     */   }
/*     */   
/*     */   public String getCni() {
/* 144 */     return this.cni;
/*     */   }
/*     */   
/*     */   public void setCni(String cni) {
/* 148 */     this.cni = cni;
/*     */   }
/*     */   
/*     */   public String getSexe() {
/* 152 */     return this.sexe;
/*     */   }
/*     */   
/*     */   public void setSexe(String sexe) {
/* 156 */     this.sexe = sexe;
/*     */   }
/*     */   
/*     */   public String getPhoto() {
/* 160 */     return this.photo;
/*     */   }
/*     */   
/*     */   public void setPhoto(String photo) {
/* 164 */     this.photo = photo;
/*     */   }
/*     */   
/*     */   public String getPhotoRelatif() {
/* 168 */     return this.photoRelatif;
/*     */   }
/*     */   
/*     */   public void setPhotoRelatif(String photoRelatif) {
/* 172 */     this.photoRelatif = photoRelatif;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 176 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 180 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 184 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 188 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 192 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 196 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 201 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 205 */     this.structureList = structureList;
/*     */   }
/*     */   
/*     */   public Adresse getIdAdresse() {
/* 209 */     return this.idAdresse;
/*     */   }
/*     */   
/*     */   public void setIdAdresse(Adresse idAdresse) {
/* 213 */     this.idAdresse = idAdresse;
/*     */   }
/*     */   
/*     */   public Arrondissement getIdarrondissement() {
/* 217 */     return this.idarrondissement;
/*     */   }
/*     */   
/*     */   public void setIdarrondissement(Arrondissement idarrondissement) {
/* 221 */     this.idarrondissement = idarrondissement;
/*     */   }
/*     */   
/*     */   public Pays getIdPays() {
/* 225 */     return this.idPays;
/*     */   }
/*     */   
/*     */   public void setIdPays(Pays idPays) {
/* 229 */     this.idPays = idPays;
/*     */   }
/*     */   
/*     */   public StatutMatrimonial getIdStatutMatrimonial() {
/* 233 */     return this.idStatutMatrimonial;
/*     */   }
/*     */   
/*     */   public void setIdStatutMatrimonial(StatutMatrimonial idStatutMatrimonial) {
/* 237 */     this.idStatutMatrimonial = idStatutMatrimonial;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Compte> getCompteList() {
/* 242 */     return this.compteList;
/*     */   }
/*     */   
/*     */   public void setCompteList(List<Compte> compteList) {
/* 246 */     this.compteList = compteList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 251 */     int hash = 0;
/* 252 */     hash += (this.idUtilisateur != null) ? this.idUtilisateur.hashCode() : 0;
/* 253 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 259 */     if (!(object instanceof Utilisateur)) {
/* 260 */       return false;
/*     */     }
/* 262 */     Utilisateur other = (Utilisateur)object;
/* 263 */     if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
/* 264 */       return false;
/*     */     }
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 271 */     return "entities.Utilisateur[ idUtilisateur=" + this.idUtilisateur + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Utilisateur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */