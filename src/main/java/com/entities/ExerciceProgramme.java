/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "exercice_programme")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "ExerciceProgramme.findAll", query = "SELECT e FROM ExerciceProgramme e"), @NamedQuery(name = "ExerciceProgramme.findByIdprogramme", query = "SELECT e FROM ExerciceProgramme e WHERE e.idprogramme = :idprogramme"), @NamedQuery(name = "ExerciceProgramme.findByIdexercice", query = "SELECT e FROM ExerciceProgramme e WHERE e.idexercice = :idexercice"), @NamedQuery(name = "ExerciceProgramme.findByNom", query = "SELECT e FROM ExerciceProgramme e WHERE e.nom = :nom"), @NamedQuery(name = "ExerciceProgramme.findByCoutprog", query = "SELECT e FROM ExerciceProgramme e WHERE e.coutprog = :coutprog"), @NamedQuery(name = "ExerciceProgramme.findByPoidprog", query = "SELECT e FROM ExerciceProgramme e WHERE e.poidprog = :poidprog"), @NamedQuery(name = "ExerciceProgramme.findByEtat", query = "SELECT e FROM ExerciceProgramme e WHERE e.etat = :etat"), @NamedQuery(name = "ExerciceProgramme.findByDateEnregistre", query = "SELECT e FROM ExerciceProgramme e WHERE e.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "ExerciceProgramme.findByDerniereModif", query = "SELECT e FROM ExerciceProgramme e WHERE e.derniereModif = :derniereModif"), @NamedQuery(name = "ExerciceProgramme.findByIdexerciceprogramme", query = "SELECT e FROM ExerciceProgramme e WHERE e.idexerciceprogramme = :idexerciceprogramme")})
/*     */ public class ExerciceProgramme
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idprogramme")
/*     */   private long idprogramme;
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idexercice")
/*     */   private long idexercice;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "coutprog")
/*     */   private Double coutprog;
/*     */   @Column(name = "poidprog")
/*     */   private Double poidprog;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idexerciceprogramme")
/*     */   private Integer idexerciceprogramme;
/*     */   
/*     */   public ExerciceProgramme() {}
/*     */   
/*     */   public ExerciceProgramme(Integer idexerciceprogramme) {
/*  80 */     this.idexerciceprogramme = idexerciceprogramme;
/*     */   }
/*     */   
/*     */   public ExerciceProgramme(Integer idexerciceprogramme, long idprogramme, long idexercice) {
/*  84 */     this.idexerciceprogramme = idexerciceprogramme;
/*  85 */     this.idprogramme = idprogramme;
/*  86 */     this.idexercice = idexercice;
/*     */   }
/*     */   
/*     */   public long getIdprogramme() {
/*  90 */     return this.idprogramme;
/*     */   }
/*     */   
/*     */   public void setIdprogramme(long idprogramme) {
/*  94 */     this.idprogramme = idprogramme;
/*     */   }
/*     */   
/*     */   public long getIdexercice() {
/*  98 */     return this.idexercice;
/*     */   }
/*     */   
/*     */   public void setIdexercice(long idexercice) {
/* 102 */     this.idexercice = idexercice;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 106 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 110 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Double getCoutprog() {
/* 114 */     return this.coutprog;
/*     */   }
/*     */   
/*     */   public void setCoutprog(Double coutprog) {
/* 118 */     this.coutprog = coutprog;
/*     */   }
/*     */   
/*     */   public Double getPoidprog() {
/* 122 */     return this.poidprog;
/*     */   }
/*     */   
/*     */   public void setPoidprog(Double poidprog) {
/* 126 */     this.poidprog = poidprog;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 130 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 134 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 138 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 142 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 146 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 150 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Integer getIdexerciceprogramme() {
/* 154 */     return this.idexerciceprogramme;
/*     */   }
/*     */   
/*     */   public void setIdexerciceprogramme(Integer idexerciceprogramme) {
/* 158 */     this.idexerciceprogramme = idexerciceprogramme;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 163 */     int hash = 0;
/* 164 */     hash += (this.idexerciceprogramme != null) ? this.idexerciceprogramme.hashCode() : 0;
/* 165 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 171 */     if (!(object instanceof ExerciceProgramme)) {
/* 172 */       return false;
/*     */     }
/* 174 */     ExerciceProgramme other = (ExerciceProgramme)object;
/* 175 */     if ((this.idexerciceprogramme == null && other.idexerciceprogramme != null) || (this.idexerciceprogramme != null && !this.idexerciceprogramme.equals(other.idexerciceprogramme))) {
/* 176 */       return false;
/*     */     }
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 183 */     return "entities.ExerciceProgramme[ idexerciceprogramme=" + this.idexerciceprogramme + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ExerciceProgramme.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */