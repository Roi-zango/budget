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
/*     */ @Table(name = "departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIddepartement", query = "SELECT d FROM Departement d WHERE d.iddepartement = :iddepartement"),
    @NamedQuery(name = "Departement.findByNom", query = "SELECT d FROM Departement d WHERE d.nom = :nom"),
    @NamedQuery(name = "Departement.findByEtat", query = "SELECT d FROM Departement d WHERE d.etat = :etat"),
    @NamedQuery(name = "Departement.findByDateEnregistre", query = "SELECT d FROM Departement d WHERE d.dateEnregistre = :dateEnregistre"),
    @NamedQuery(name = "Departement.findByDerniereModif", query = "SELECT d FROM Departement d WHERE d.derniereModif = :derniereModif")
})
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddepartement")
    private Long iddepartement;

    @Size(max = 1024)
    @Column(name = "nom")
    private String nom;

    @Size(max = 50)
    @Column(name = "etat")
    private String etat;

    @Column(name = "date_enregistre")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistre;

    @Column(name = "derniere_modif")
    @Temporal(TemporalType.DATE)
    private Date derniereModif;

    @JoinColumn(name = "idregion", referencedColumnName = "idregion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Region idregion;

    @OneToMany(mappedBy = "iddepartement", fetch = FetchType.LAZY)
    private List<Arrondissement> arrondissementList;

    @OneToMany(mappedBy = "iddepartement", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Structure> structureList;

    // Other class members, constructors, getters, and setters
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
/*     */   public Departement() {}
/*     */   
/*     */   public Departement(Long iddepartement) {
/*  74 */     this.iddepartement = iddepartement;
/*     */   }
/*     */   
/*     */   public Long getIddepartement() {
/*  78 */     return this.iddepartement;
/*     */   }
/*     */   
/*     */   public void setIddepartement(Long iddepartement) {
/*  82 */     this.iddepartement = iddepartement;
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
/*     */   public Region getIdregion() {
/* 118 */     return this.idregion;
/*     */   }
/*     */   
/*     */   public void setIdregion(Region idregion) {
/* 122 */     this.idregion = idregion;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Arrondissement> getArrondissementList() {
/* 127 */     return this.arrondissementList;
/*     */   }
/*     */   
/*     */   public void setArrondissementList(List<Arrondissement> arrondissementList) {
/* 131 */     this.arrondissementList = arrondissementList;
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
/* 146 */     hash += (this.iddepartement != null) ? this.iddepartement.hashCode() : 0;
/* 147 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 153 */     if (!(object instanceof Departement)) {
/* 154 */       return false;
/*     */     }
/* 156 */     Departement other = (Departement)object;
/* 157 */     if ((this.iddepartement == null && other.iddepartement != null) || (this.iddepartement != null && !this.iddepartement.equals(other.iddepartement))) {
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     return "entities.Departement[ iddepartement=" + this.iddepartement + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Departement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */