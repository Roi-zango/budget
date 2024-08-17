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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "imputation")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Imputation.findAll", query = "SELECT i FROM Imputation i"), @NamedQuery(name = "Imputation.findByIdimputation", query = "SELECT i FROM Imputation i WHERE i.idimputation = :idimputation"), @NamedQuery(name = "Imputation.findByCode", query = "SELECT i FROM Imputation i WHERE i.code = :code"), @NamedQuery(name = "Imputation.findByNom", query = "SELECT i FROM Imputation i WHERE i.nom = :nom"), @NamedQuery(name = "Imputation.findByDescription", query = "SELECT i FROM Imputation i WHERE i.description = :description"), @NamedQuery(name = "Imputation.findByEtat", query = "SELECT i FROM Imputation i WHERE i.etat = :etat"), @NamedQuery(name = "Imputation.findByDateEnregistre", query = "SELECT i FROM Imputation i WHERE i.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Imputation.findByDerniereModif", query = "SELECT i FROM Imputation i WHERE i.derniereModif = :derniereModif")})
/*     */ public class Imputation
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idimputation")
/*     */   private Long idimputation;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumn(name = "idsousrubrique", referencedColumnName = "idsousrubrique")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Sousrubrique idsousrubrique;
/*     */   @OneToMany(mappedBy = "idimputation", fetch = FetchType.LAZY)
/*     */   private List<Moyens> moyensList;
/*     */   @OneToMany(mappedBy = "idimputation", fetch = FetchType.LAZY)
/*     */   private List<Recette> recetteList;
/*     */   @JoinColumn(name = "idsection", referencedColumnName = "idsection")
/*     */   @ManyToOne
/*     */   private Section section;
/*     */   @JoinColumn(name = "idsousrubriquemercurial", referencedColumnName = "idsousrubriquemercurial")
/*     */   @ManyToOne
/*     */   private Sousrubriquemercurial sousrubriquemercurial;
/*     */   @JoinColumn(name = "idtypeimputation", referencedColumnName = "idtypeimputation")
/*     */   @ManyToOne
/*     */   private Typeimputation idtypeimputation;
/*     */   
/*     */   public Imputation() {}
/*     */   
/*     */   public Imputation(Long idimputation) {
/*  93 */     this.idimputation = idimputation;
/*     */   }
/*     */   
/*     */   public Long getIdimputation() {
/*  97 */     return this.idimputation;
/*     */   }
/*     */   
/*     */   public void setIdimputation(Long idimputation) {
/* 101 */     this.idimputation = idimputation;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 105 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 109 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 113 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 117 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 121 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 125 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 129 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 133 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 137 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 141 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 145 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 149 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Sousrubrique getIdsousrubrique() {
/* 153 */     return this.idsousrubrique;
/*     */   }
/*     */   
/*     */   public void setIdsousrubrique(Sousrubrique idsousrubrique) {
/* 157 */     this.idsousrubrique = idsousrubrique;
/*     */   }
/*     */   
/*     */   public Section getSection() {
/* 161 */     return this.section;
/*     */   }
/*     */   
/*     */   public void setSection(Section section) {
/* 165 */     this.section = section;
/*     */   }
/*     */   
/*     */   public Sousrubriquemercurial getSousrubriquemercurial() {
/* 169 */     return this.sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
/* 173 */     this.sousrubriquemercurial = sousrubriquemercurial;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Moyens> getMoyensList() {
/* 178 */     return this.moyensList;
/*     */   }
/*     */   
/*     */   public void setMoyensList(List<Moyens> moyensList) {
/* 182 */     this.moyensList = moyensList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Recette> getRecetteList() {
/* 187 */     return this.recetteList;
/*     */   }
/*     */   
/*     */   public void setRecetteList(List<Recette> recetteList) {
/* 191 */     this.recetteList = recetteList;
/*     */   }
/*     */   
/*     */   public Typeimputation getIdtypeimputation() {
/* 195 */     return this.idtypeimputation;
/*     */   }
/*     */   
/*     */   public void setIdtypeimputation(Typeimputation idtypeimputation) {
/* 199 */     this.idtypeimputation = idtypeimputation;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 204 */     int hash = 0;
/* 205 */     hash += (this.idimputation != null) ? this.idimputation.hashCode() : 0;
/* 206 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 212 */     if (!(object instanceof Imputation)) {
/* 213 */       return false;
/*     */     }
/* 215 */     Imputation other = (Imputation)object;
/* 216 */     if ((this.idimputation == null && other.idimputation != null) || (this.idimputation != null && !this.idimputation.equals(other.idimputation))) {
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 224 */     return "entities.Imputation[ idimputation=" + this.idimputation + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Imputation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */