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
/*     */ @Table(name = "extrant")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Extrant.findAll", query = "SELECT e FROM Extrant e"), @NamedQuery(name = "Extrant.findByIdextrant", query = "SELECT e FROM Extrant e WHERE e.idextrant = :idextrant"), @NamedQuery(name = "Extrant.findByNom", query = "SELECT e FROM Extrant e WHERE e.nom = :nom"), @NamedQuery(name = "Extrant.findByCout", query = "SELECT e FROM Extrant e WHERE e.cout = :cout"), @NamedQuery(name = "Extrant.findByIndicateurs", query = "SELECT e FROM Extrant e WHERE e.indicateurs = :indicateurs"), @NamedQuery(name = "Extrant.findByEtat", query = "SELECT e FROM Extrant e WHERE e.etat = :etat"), @NamedQuery(name = "Extrant.findByDateEnregistre", query = "SELECT e FROM Extrant e WHERE e.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Extrant.findByDerniereModif", query = "SELECT e FROM Extrant e WHERE e.derniereModif = :derniereModif")})
/*     */ public class Extrant
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idextrant")
/*     */   private Long idextrant;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "cout")
/*     */   private Double cout;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "indicateurs")
/*     */   private String indicateurs;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "extrant", fetch = FetchType.LAZY)
/*     */   private List<Indicateurextrant> indicateurextrantList;
/*     */   @JoinColumn(name = "idactivite", referencedColumnName = "idactivite")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Activite idactivite;
/*     */   @JoinColumn(name = "idannee", referencedColumnName = "idannee")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Annee idannee;
/*     */   @JoinColumn(name = "idindicateurperformance", referencedColumnName = "idindicateurperformance")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Indicateurperformance idindicateurperformance;
/*     */   @JoinColumn(name = "idmethodeeval", referencedColumnName = "idmethodeeval")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Methodeeval idmethodeeval;
/*     */   
/*     */   public Extrant() {}
/*     */   
/*     */   public Extrant(Long idextrant) {
/*  90 */     this.idextrant = idextrant;
/*     */   }
/*     */   
/*     */   public Long getIdextrant() {
/*  94 */     return this.idextrant;
/*     */   }
/*     */   
/*     */   public void setIdextrant(Long idextrant) {
/*  98 */     this.idextrant = idextrant;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 102 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 106 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Double getCout() {
/* 110 */     return this.cout;
/*     */   }
/*     */   
/*     */   public void setCout(Double cout) {
/* 114 */     this.cout = cout;
/*     */   }
/*     */   
/*     */   public String getIndicateurs() {
/* 118 */     return this.indicateurs;
/*     */   }
/*     */   
/*     */   public void setIndicateurs(String indicateurs) {
/* 122 */     this.indicateurs = indicateurs;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 126 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 130 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 134 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 138 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 142 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 146 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateurextrant> getIndicateurextrantList() {
/* 151 */     return this.indicateurextrantList;
/*     */   }
/*     */   
/*     */   public void setIndicateurextrantList(List<Indicateurextrant> indicateurextrantList) {
/* 155 */     this.indicateurextrantList = indicateurextrantList;
/*     */   }
/*     */   
/*     */   public Activite getIdactivite() {
/* 159 */     return this.idactivite;
/*     */   }
/*     */   
/*     */   public void setIdactivite(Activite idactivite) {
/* 163 */     this.idactivite = idactivite;
/*     */   }
/*     */   
/*     */   public Annee getIdannee() {
/* 167 */     return this.idannee;
/*     */   }
/*     */   
/*     */   public void setIdannee(Annee idannee) {
/* 171 */     this.idannee = idannee;
/*     */   }
/*     */   
/*     */   public Indicateurperformance getIdindicateurperformance() {
/* 175 */     return this.idindicateurperformance;
/*     */   }
/*     */   
/*     */   public void setIdindicateurperformance(Indicateurperformance idindicateurperformance) {
/* 179 */     this.idindicateurperformance = idindicateurperformance;
/*     */   }
/*     */   
/*     */   public Methodeeval getIdmethodeeval() {
/* 183 */     return this.idmethodeeval;
/*     */   }
/*     */   
/*     */   public void setIdmethodeeval(Methodeeval idmethodeeval) {
/* 187 */     this.idmethodeeval = idmethodeeval;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 192 */     int hash = 0;
/* 193 */     hash += (this.idextrant != null) ? this.idextrant.hashCode() : 0;
/* 194 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 200 */     if (!(object instanceof Extrant)) {
/* 201 */       return false;
/*     */     }
/* 203 */     Extrant other = (Extrant)object;
/* 204 */     if ((this.idextrant == null && other.idextrant != null) || (this.idextrant != null && !this.idextrant.equals(other.idextrant))) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 212 */     return "entities.Extrant[ idextrant=" + this.idextrant + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Extrant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */