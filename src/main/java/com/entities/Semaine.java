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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "semaine")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Semaine.findAll", query = "SELECT s FROM Semaine s"), @NamedQuery(name = "Semaine.findByIdsemaine", query = "SELECT s FROM Semaine s WHERE s.idsemaine = :idsemaine"), @NamedQuery(name = "Semaine.findByNom", query = "SELECT s FROM Semaine s WHERE s.nom = :nom"), @NamedQuery(name = "Semaine.findByS4", query = "SELECT s FROM Semaine s WHERE s.s4 = :s4"), @NamedQuery(name = "Semaine.findByS3", query = "SELECT s FROM Semaine s WHERE s.s3 = :s3"), @NamedQuery(name = "Semaine.findByS2", query = "SELECT s FROM Semaine s WHERE s.s2 = :s2"), @NamedQuery(name = "Semaine.findByS1", query = "SELECT s FROM Semaine s WHERE s.s1 = :s1"), @NamedQuery(name = "Semaine.findByEtat", query = "SELECT s FROM Semaine s WHERE s.etat = :etat"), @NamedQuery(name = "Semaine.findByDateEnregistre", query = "SELECT s FROM Semaine s WHERE s.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Semaine.findByDerniereModif", query = "SELECT s FROM Semaine s WHERE s.derniereModif = :derniereModif")})
/*     */ public class Semaine
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idsemaine")
/*     */   private Long idsemaine;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "s4")
/*     */   private Boolean s4;
/*     */   @Column(name = "s3")
/*     */   private Boolean s3;
/*     */   @Column(name = "s2")
/*     */   private Boolean s2;
/*     */   @Column(name = "s1")
/*     */   private Boolean s1;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumn(name = "idmois", referencedColumnName = "idmois")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Mois idmois;
/*     */   @JoinColumn(name = "idtache", referencedColumnName = "idtache")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Tache idtache;
/*     */   
/*     */   public Semaine() {}
/*     */   
/*     */   public Semaine(Long idsemaine) {
/*  82 */     this.idsemaine = idsemaine;
/*     */   }
/*     */   
/*     */   public Long getIdsemaine() {
/*  86 */     return this.idsemaine;
/*     */   }
/*     */   
/*     */   public void setIdsemaine(Long idsemaine) {
/*  90 */     this.idsemaine = idsemaine;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  94 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  98 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Boolean getS4() {
/* 102 */     return this.s4;
/*     */   }
/*     */   
/*     */   public void setS4(Boolean s4) {
/* 106 */     this.s4 = s4;
/*     */   }
/*     */   
/*     */   public Boolean getS3() {
/* 110 */     return this.s3;
/*     */   }
/*     */   
/*     */   public void setS3(Boolean s3) {
/* 114 */     this.s3 = s3;
/*     */   }
/*     */   
/*     */   public Boolean getS2() {
/* 118 */     return this.s2;
/*     */   }
/*     */   
/*     */   public void setS2(Boolean s2) {
/* 122 */     this.s2 = s2;
/*     */   }
/*     */   
/*     */   public Boolean getS1() {
/* 126 */     return this.s1;
/*     */   }
/*     */   
/*     */   public void setS1(Boolean s1) {
/* 130 */     this.s1 = s1;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 134 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 138 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 142 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 146 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 150 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 154 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Mois getIdmois() {
/* 158 */     return this.idmois;
/*     */   }
/*     */   
/*     */   public void setIdmois(Mois idmois) {
/* 162 */     this.idmois = idmois;
/*     */   }
/*     */   
/*     */   public Tache getIdtache() {
/* 166 */     return this.idtache;
/*     */   }
/*     */   
/*     */   public void setIdtache(Tache idtache) {
/* 170 */     this.idtache = idtache;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 175 */     int hash = 0;
/* 176 */     hash += (this.idsemaine != null) ? this.idsemaine.hashCode() : 0;
/* 177 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 183 */     if (!(object instanceof Semaine)) {
/* 184 */       return false;
/*     */     }
/* 186 */     Semaine other = (Semaine)object;
/* 187 */     if ((this.idsemaine == null && other.idsemaine != null) || (this.idsemaine != null && !this.idsemaine.equals(other.idsemaine))) {
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 195 */     return "entities.Semaine[ idsemaine=" + this.idsemaine + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Semaine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */