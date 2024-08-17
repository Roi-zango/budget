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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "institution")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"), @NamedQuery(name = "Institution.findByIdinstitution", query = "SELECT i FROM Institution i WHERE i.idinstitution = :idinstitution"), @NamedQuery(name = "Institution.findByNom", query = "SELECT i FROM Institution i WHERE i.nom = :nom"), @NamedQuery(name = "Institution.findByCode", query = "SELECT i FROM Institution i WHERE i.code = :code"), @NamedQuery(name = "Institution.findByChoixstrategique", query = "SELECT i FROM Institution i WHERE i.choixstrategique = :choixstrategique"), @NamedQuery(name = "Institution.findByEtat", query = "SELECT i FROM Institution i WHERE i.etat = :etat"), @NamedQuery(name = "Institution.findByDateEnregistre", query = "SELECT i FROM Institution i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Institution.findByDerniereModif", query = "SELECT i FROM Institution i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Institution
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idinstitution")
/*     */   private Long idinstitution;
/*     */   @Size(max = 200)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 50)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 2000)
/*     */   @Column(name = "choixstrategique")
/*     */   private String choixstrategique;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(length = 50)
/*     */   private String photo;
/*     */   @Column(length = 50, name = "photo_institution_mere")
/*     */   private String photoInstitutionMere;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Column(length = 250)
/*     */   private String sigle;
/*     */   @Column(length = 40)
/*     */   private String chapitre;
/*     */   @JoinColumn(name = "idsoussecteur", referencedColumnName = "idsoussecteur")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Soussecteur idsoussecteur;
/*     */   @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
/*     */   private List<Programme> programmeList;
/*     */   @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
/*     */   private List<Exercice> exerciceList;
/*     */   @Size(max = 200)
/*     */   @Column(name = "nom_en")
/*     */   private String nomEn;
/*     */   
/*     */   public Institution() {}
/*     */   
/*     */   public Institution(Long idinstitution) {
/*  96 */     this.idinstitution = idinstitution;
/*     */   }
/*     */   
/*     */   public Long getIdinstitution() {
/* 100 */     return this.idinstitution;
/*     */   }
/*     */   
/*     */   public void setIdinstitution(Long idinstitution) {
/* 104 */     this.idinstitution = idinstitution;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 108 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 112 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 116 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 120 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getChoixstrategique() {
/* 124 */     return this.choixstrategique;
/*     */   }
/*     */   
/*     */   public void setChoixstrategique(String choixstrategique) {
/* 128 */     this.choixstrategique = choixstrategique;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 132 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 136 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 140 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 144 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 148 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 152 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Soussecteur getIdsoussecteur() {
/* 156 */     return this.idsoussecteur;
/*     */   }
/*     */   
/*     */   public void setIdsoussecteur(Soussecteur idsoussecteur) {
/* 160 */     this.idsoussecteur = idsoussecteur;
/*     */   }
/*     */   
/*     */   public String getChapitre() {
/* 164 */     return this.chapitre;
/*     */   }
/*     */   
/*     */   public void setChapitre(String chapitre) {
/* 168 */     this.chapitre = chapitre;
/*     */   }
/*     */   
/*     */   public String getSigle() {
/* 172 */     return this.sigle;
/*     */   }
/*     */   
/*     */   public void setSigle(String sigle) {
/* 176 */     this.sigle = sigle;
/*     */   }
/*     */   
/*     */   public String getPhoto() {
/* 180 */     return this.photo;
/*     */   }
/*     */   
/*     */   public void setPhoto(String photo) {
/* 184 */     this.photo = photo;
/*     */   }
/*     */   
/*     */   public String getPhotoInstitutionMere() {
/* 188 */     return this.photoInstitutionMere;
/*     */   }
/*     */   
/*     */   public void setPhotoInstitutionMere(String photoInstitutionMere) {
/* 192 */     this.photoInstitutionMere = photoInstitutionMere;
/*     */   }
/*     */   
/*     */   public String getNomEn() {
/* 196 */     return this.nomEn;
/*     */   }
/*     */   
/*     */   public void setNomEn(String nomEn) {
/* 200 */     this.nomEn = nomEn;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Programme> getProgrammeList() {
/* 205 */     return this.programmeList;
/*     */   }
/*     */   
/*     */   public void setProgrammeList(List<Programme> programmeList) {
/* 209 */     this.programmeList = programmeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 214 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 218 */     this.structureList = structureList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Exercice> getExerciceList() {
/* 223 */     return this.exerciceList;
/*     */   }
/*     */   
/*     */   public void setExerciceList(List<Exercice> exerciceList) {
/* 227 */     this.exerciceList = exerciceList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 232 */     int hash = 0;
/* 233 */     hash += (this.idinstitution != null) ? this.idinstitution.hashCode() : 0;
/* 234 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 240 */     if (!(object instanceof Institution)) {
/* 241 */       return false;
/*     */     }
/* 243 */     Institution other = (Institution)object;
/* 244 */     if ((this.idinstitution == null && other.idinstitution != null) || (this.idinstitution != null && !this.idinstitution.equals(other.idinstitution))) {
/* 245 */       return false;
/*     */     }
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     return "entities.Institution[ idinstitution=" + this.idinstitution + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Institution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */