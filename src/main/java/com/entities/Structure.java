/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.CascadeType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
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
/*     */ @Table(name = "structure")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Structure.findAll", query = "SELECT s FROM Structure s"), @NamedQuery(name = "Structure.findByIdstructure", query = "SELECT s FROM Structure s WHERE s.idstructure = :idstructure"), @NamedQuery(name = "Structure.findByNom", query = "SELECT s FROM Structure s WHERE s.nom = :nom"), @NamedQuery(name = "Structure.findByArticle", query = "SELECT s FROM Structure s WHERE s.article = :article"), @NamedQuery(name = "Structure.findByNomrespo", query = "SELECT s FROM Structure s WHERE s.nomrespo = :nomrespo"), @NamedQuery(name = "Structure.findByArretecreation", query = "SELECT s FROM Structure s WHERE s.arretecreation = :arretecreation"), @NamedQuery(name = "Structure.findByDesignation", query = "SELECT s FROM Structure s WHERE s.designation = :designation"), @NamedQuery(name = "Structure.findByCordonex", query = "SELECT s FROM Structure s WHERE s.cordonex = :cordonex"), @NamedQuery(name = "Structure.findByCordoney", query = "SELECT s FROM Structure s WHERE s.cordoney = :cordoney"), @NamedQuery(name = "Structure.findByPresentation", query = "SELECT s FROM Structure s WHERE s.presentation = :presentation"), @NamedQuery(name = "Structure.findByPap", query = "SELECT s FROM Structure s WHERE s.pap = :pap"), @NamedQuery(name = "Structure.findByActif", query = "SELECT s FROM Structure s WHERE s.actif = :actif"), @NamedQuery(name = "Structure.findByEtat", query = "SELECT s FROM Structure s WHERE s.etat = :etat"), @NamedQuery(name = "Structure.findByDateouverture", query = "SELECT s FROM Structure s WHERE s.dateouverture = :dateouverture"), @NamedQuery(name = "Structure.findByDateEnregistre", query = "SELECT s FROM Structure s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Structure.findByDerniereModif", query = "SELECT s FROM Structure s WHERE s.derniereModif = :derniereModif"), @NamedQuery(name = "Structure.findByVision", query = "SELECT s FROM Structure s WHERE s.vision = :vision"), @NamedQuery(name = "Structure.findByAxeintervention", query = "SELECT s FROM Structure s WHERE s.axeintervention = :axeintervention"), @NamedQuery(name = "Structure.findByObjectifgeneral", query = "SELECT s FROM Structure s WHERE s.objectifgeneral = :objectifgeneral"), @NamedQuery(name = "Structure.findByObjectifspecifique", query = "SELECT s FROM Structure s WHERE s.objectifspecifique = :objectifspecifique")})
/*     */ public class Structure
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idstructure")
/*     */   private Long idstructure;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 254)
/*     */   @Column(name = "article")
/*     */   private String article;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nomrespo")
/*     */   private String nomrespo;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "arretecreation")
/*     */   private String arretecreation;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "designation")
/*     */   private String designation;
/*     */   @Column(name = "cordonex")
/*     */   private Double cordonex;
/*     */   @Column(name = "cordoney")
/*     */   private Double cordoney;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "presentation")
/*     */   private String presentation;
/*     */   @Column(name = "pap")
/*     */   private Boolean pap;
/*     */   @Column(name = "actif")
/*     */   private Boolean actif;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "dateouverture")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateouverture;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "vision")
/*     */   private String vision;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "axeintervention")
/*     */   private String axeintervention;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "objectifgeneral")
/*     */   private String objectifgeneral;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "objectifspecifique")
/*     */   private String objectifspecifique;
/*     */   @JoinTable(name = "utilisateurstructure", joinColumns = {@JoinColumn(name = "idstructure", referencedColumnName = "idstructure")}, inverseJoinColumns = {@JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")})
/*     */   @ManyToMany(fetch = FetchType.LAZY)
/*     */   private List<Utilisateur> utilisateurList;
/*     */   @OneToMany(mappedBy = "idstructure", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   @OneToMany(mappedBy = "idstructure", fetch = FetchType.LAZY)
/*     */   private List<Activite> activiteList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "structure", fetch = FetchType.LAZY)
/*     */   private List<Structuremission> structuremissionList;
/*     */   @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Adresse idAdresse;
/*     */   @JoinColumn(name = "idarrondissement", referencedColumnName = "idarrondissement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Arrondissement idarrondissement;
/*     */   @JoinColumn(name = "iddepartement", referencedColumnName = "iddepartement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Departement iddepartement;
/*     */   @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Institution idinstitution;
/*     */   @JoinColumn(name = "idniveaupyramide", referencedColumnName = "idniveaupyramide")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Niveaupyramide idniveaupyramide;
/*     */   @JoinColumn(name = "idpyramide", referencedColumnName = "idpyramide")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Pyramide idpyramide;
/*     */   @JoinColumn(name = "idrattachement", referencedColumnName = "idrattachement")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Rattachement idrattachement;
/*     */   @JoinColumn(name = "idregion", referencedColumnName = "idregion")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Region idregion;
/*     */   @JoinColumn(name = "idstatutstructure", referencedColumnName = "idstatutstructure")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Statutstructure idstatutstructure;
/*     */   @JoinColumn(name = "idtypestructure", referencedColumnName = "idtypestructure")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typestructure idtypestructure;
/*     */   
/*     */   public Structure() {}
/*     */   
/*     */   public Structure(Long idstructure) {
/* 164 */     this.idstructure = idstructure;
/*     */   }
/*     */   
/*     */   public Long getIdstructure() {
/* 168 */     return this.idstructure;
/*     */   }
/*     */   
/*     */   public void setIdstructure(Long idstructure) {
/* 172 */     this.idstructure = idstructure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 176 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 180 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getArticle() {
/* 184 */     return this.article;
/*     */   }
/*     */   
/*     */   public void setArticle(String article) {
/* 188 */     this.article = article;
/*     */   }
/*     */   
/*     */   public String getNomrespo() {
/* 192 */     return this.nomrespo;
/*     */   }
/*     */   
/*     */   public void setNomrespo(String nomrespo) {
/* 196 */     this.nomrespo = nomrespo;
/*     */   }
/*     */   
/*     */   public String getArretecreation() {
/* 200 */     return this.arretecreation;
/*     */   }
/*     */   
/*     */   public void setArretecreation(String arretecreation) {
/* 204 */     this.arretecreation = arretecreation;
/*     */   }
/*     */   
/*     */   public String getDesignation() {
/* 208 */     return this.designation;
/*     */   }
/*     */   
/*     */   public void setDesignation(String designation) {
/* 212 */     this.designation = designation;
/*     */   }
/*     */   
/*     */   public Double getCordonex() {
/* 216 */     return this.cordonex;
/*     */   }
/*     */   
/*     */   public void setCordonex(Double cordonex) {
/* 220 */     this.cordonex = cordonex;
/*     */   }
/*     */   
/*     */   public Double getCordoney() {
/* 224 */     return this.cordoney;
/*     */   }
/*     */   
/*     */   public void setCordoney(Double cordoney) {
/* 228 */     this.cordoney = cordoney;
/*     */   }
/*     */   
/*     */   public String getPresentation() {
/* 232 */     return this.presentation;
/*     */   }
/*     */   
/*     */   public void setPresentation(String presentation) {
/* 236 */     this.presentation = presentation;
/*     */   }
/*     */   
/*     */   public Boolean getPap() {
/* 240 */     return this.pap;
/*     */   }
/*     */   
/*     */   public void setPap(Boolean pap) {
/* 244 */     this.pap = pap;
/*     */   }
/*     */   
/*     */   public Boolean getActif() {
/* 248 */     return this.actif;
/*     */   }
/*     */   
/*     */   public void setActif(Boolean actif) {
/* 252 */     this.actif = actif;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 256 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 260 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateouverture() {
/* 264 */     return this.dateouverture;
/*     */   }
/*     */   
/*     */   public void setDateouverture(Date dateouverture) {
/* 268 */     this.dateouverture = dateouverture;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 272 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 276 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 280 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 284 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public String getVision() {
/* 288 */     return this.vision;
/*     */   }
/*     */   
/*     */   public void setVision(String vision) {
/* 292 */     this.vision = vision;
/*     */   }
/*     */   
/*     */   public String getAxeintervention() {
/* 296 */     return this.axeintervention;
/*     */   }
/*     */   
/*     */   public void setAxeintervention(String axeintervention) {
/* 300 */     this.axeintervention = axeintervention;
/*     */   }
/*     */   
/*     */   public String getObjectifgeneral() {
/* 304 */     return this.objectifgeneral;
/*     */   }
/*     */   
/*     */   public void setObjectifgeneral(String objectifgeneral) {
/* 308 */     this.objectifgeneral = objectifgeneral;
/*     */   }
/*     */   
/*     */   public String getObjectifspecifique() {
/* 312 */     return this.objectifspecifique;
/*     */   }
/*     */   
/*     */   public void setObjectifspecifique(String objectifspecifique) {
/* 316 */     this.objectifspecifique = objectifspecifique;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Utilisateur> getUtilisateurList() {
/* 321 */     return this.utilisateurList;
/*     */   }
/*     */   
/*     */   public void setUtilisateurList(List<Utilisateur> utilisateurList) {
/* 325 */     this.utilisateurList = utilisateurList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tache> getTacheList() {
/* 330 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/* 334 */     this.tacheList = tacheList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Activite> getActiviteList() {
/* 339 */     return this.activiteList;
/*     */   }
/*     */   
/*     */   public void setActiviteList(List<Activite> activiteList) {
/* 343 */     this.activiteList = activiteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structuremission> getStructuremissionList() {
/* 348 */     return this.structuremissionList;
/*     */   }
/*     */   
/*     */   public void setStructuremissionList(List<Structuremission> structuremissionList) {
/* 352 */     this.structuremissionList = structuremissionList;
/*     */   }
/*     */   
/*     */   public Adresse getIdAdresse() {
/* 356 */     return this.idAdresse;
/*     */   }
/*     */   
/*     */   public void setIdAdresse(Adresse idAdresse) {
/* 360 */     this.idAdresse = idAdresse;
/*     */   }
/*     */   
/*     */   public Arrondissement getIdarrondissement() {
/* 364 */     return this.idarrondissement;
/*     */   }
/*     */   
/*     */   public void setIdarrondissement(Arrondissement idarrondissement) {
/* 368 */     this.idarrondissement = idarrondissement;
/*     */   }
/*     */   
/*     */   public Departement getIddepartement() {
/* 372 */     return this.iddepartement;
/*     */   }
/*     */   
/*     */   public void setIddepartement(Departement iddepartement) {
/* 376 */     this.iddepartement = iddepartement;
/*     */   }
/*     */   
/*     */   public Institution getIdinstitution() {
/* 380 */     return this.idinstitution;
/*     */   }
/*     */   
/*     */   public void setIdinstitution(Institution idinstitution) {
/* 384 */     this.idinstitution = idinstitution;
/*     */   }
/*     */   
/*     */   public Niveaupyramide getIdniveaupyramide() {
/* 388 */     return this.idniveaupyramide;
/*     */   }
/*     */   
/*     */   public void setIdniveaupyramide(Niveaupyramide idniveaupyramide) {
/* 392 */     this.idniveaupyramide = idniveaupyramide;
/*     */   }
/*     */   
/*     */   public Pyramide getIdpyramide() {
/* 396 */     return this.idpyramide;
/*     */   }
/*     */   
/*     */   public void setIdpyramide(Pyramide idpyramide) {
/* 400 */     this.idpyramide = idpyramide;
/*     */   }
/*     */   
/*     */   public Rattachement getIdrattachement() {
/* 404 */     return this.idrattachement;
/*     */   }
/*     */   
/*     */   public void setIdrattachement(Rattachement idrattachement) {
/* 408 */     this.idrattachement = idrattachement;
/*     */   }
/*     */   
/*     */   public Region getIdregion() {
/* 412 */     return this.idregion;
/*     */   }
/*     */   
/*     */   public void setIdregion(Region idregion) {
/* 416 */     this.idregion = idregion;
/*     */   }
/*     */   
/*     */   public Statutstructure getIdstatutstructure() {
/* 420 */     return this.idstatutstructure;
/*     */   }
/*     */   
/*     */   public void setIdstatutstructure(Statutstructure idstatutstructure) {
/* 424 */     this.idstatutstructure = idstatutstructure;
/*     */   }
/*     */   
/*     */   public Typestructure getIdtypestructure() {
/* 428 */     return this.idtypestructure;
/*     */   }
/*     */   
/*     */   public void setIdtypestructure(Typestructure idtypestructure) {
/* 432 */     this.idtypestructure = idtypestructure;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 437 */     int hash = 0;
/* 438 */     hash += (this.idstructure != null) ? this.idstructure.hashCode() : 0;
/* 439 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 445 */     if (!(object instanceof Structure)) {
/* 446 */       return false;
/*     */     }
/* 448 */     Structure other = (Structure)object;
/* 449 */     if ((this.idstructure == null && other.idstructure != null) || (this.idstructure != null && !this.idstructure.equals(other.idstructure))) {
/* 450 */       return false;
/*     */     }
/* 452 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 457 */     return "entities.Structure[ idstructure=" + this.idstructure + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Structure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */