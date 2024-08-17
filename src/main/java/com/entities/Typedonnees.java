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
/*     */ @Table(name = "typedonnees")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Typedonnees.findAll", query = "SELECT t FROM Typedonnees t"), @NamedQuery(name = "Typedonnees.findByIdtypedonnees", query = "SELECT t FROM Typedonnees t WHERE t.idtypedonnees = :idtypedonnees"), @NamedQuery(name = "Typedonnees.findByNom", query = "SELECT t FROM Typedonnees t WHERE t.nom = :nom"), @NamedQuery(name = "Typedonnees.findByEtat", query = "SELECT t FROM Typedonnees t WHERE t.etat = :etat"), @NamedQuery(name = "Typedonnees.findByDateEnregistre", query = "SELECT t FROM Typedonnees t WHERE t.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Typedonnees.findByDerniereModif", query = "SELECT t FROM Typedonnees t WHERE t.derniereModif = :derniereModif")})
/*     */ public class Typedonnees
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idtypedonnees")
/*     */   private Long idtypedonnees;
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
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateurperformance> indicateurperformanceList;
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractiviteannee> indicateuractiviteanneeList;
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateurprogrammeannee> indicateurprogrammeanneeList;
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateurprogramme> indicateurprogrammeList;
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractivite> indicateuractiviteList;
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateuraction> indicateuractionList;
/*     */   @OneToMany(mappedBy = "idtypedonnees", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractionannee> indicateuractionanneeList;
/*     */   
/*     */   public Typedonnees() {}
/*     */   
/*     */   public Typedonnees(Long idtypedonnees) {
/*  79 */     this.idtypedonnees = idtypedonnees;
/*     */   }
/*     */   
/*     */   public Long getIdtypedonnees() {
/*  83 */     return this.idtypedonnees;
/*     */   }
/*     */   
/*     */   public void setIdtypedonnees(Long idtypedonnees) {
/*  87 */     this.idtypedonnees = idtypedonnees;
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
/*     */   public List<Indicateurperformance> getIndicateurperformanceList() {
/* 124 */     return this.indicateurperformanceList;
/*     */   }
/*     */   
/*     */   public void setIndicateurperformanceList(List<Indicateurperformance> indicateurperformanceList) {
/* 128 */     this.indicateurperformanceList = indicateurperformanceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractiviteannee> getIndicateuractiviteanneeList() {
/* 133 */     return this.indicateuractiviteanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractiviteanneeList(List<Indicateuractiviteannee> indicateuractiviteanneeList) {
/* 137 */     this.indicateuractiviteanneeList = indicateuractiviteanneeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurprogrammeannee> getIndicateurprogrammeanneeList() {
/* 142 */     return this.indicateurprogrammeanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateurprogrammeanneeList(List<Indicateurprogrammeannee> indicateurprogrammeanneeList) {
/* 146 */     this.indicateurprogrammeanneeList = indicateurprogrammeanneeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurprogramme> getIndicateurprogrammeList() {
/* 151 */     return this.indicateurprogrammeList;
/*     */   }
/*     */   
/*     */   public void setIndicateurprogrammeList(List<Indicateurprogramme> indicateurprogrammeList) {
/* 155 */     this.indicateurprogrammeList = indicateurprogrammeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractivite> getIndicateuractiviteList() {
/* 160 */     return this.indicateuractiviteList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractiviteList(List<Indicateuractivite> indicateuractiviteList) {
/* 164 */     this.indicateuractiviteList = indicateuractiviteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuraction> getIndicateuractionList() {
/* 169 */     return this.indicateuractionList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractionList(List<Indicateuraction> indicateuractionList) {
/* 173 */     this.indicateuractionList = indicateuractionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractionannee> getIndicateuractionanneeList() {
/* 178 */     return this.indicateuractionanneeList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractionanneeList(List<Indicateuractionannee> indicateuractionanneeList) {
/* 182 */     this.indicateuractionanneeList = indicateuractionanneeList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 187 */     int hash = 0;
/* 188 */     hash += (this.idtypedonnees != null) ? this.idtypedonnees.hashCode() : 0;
/* 189 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 195 */     if (!(object instanceof Typedonnees)) {
/* 196 */       return false;
/*     */     }
/* 198 */     Typedonnees other = (Typedonnees)object;
/* 199 */     if ((this.idtypedonnees == null && other.idtypedonnees != null) || (this.idtypedonnees != null && !this.idtypedonnees.equals(other.idtypedonnees))) {
/* 200 */       return false;
/*     */     }
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     return "entities.Typedonnees[ idtypedonnees=" + this.idtypedonnees + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typedonnees.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */