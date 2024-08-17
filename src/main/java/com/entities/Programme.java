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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "programme")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p"), @NamedQuery(name = "Programme.findByIdprogramme", query = "SELECT p FROM Programme p WHERE p.idprogramme = :idprogramme"), @NamedQuery(name = "Programme.findByNom", query = "SELECT p FROM Programme p WHERE p.nom = :nom"), @NamedQuery(name = "Programme.findByCode", query = "SELECT p FROM Programme p WHERE p.code = :code"), @NamedQuery(name = "Programme.findByStratrgieprogramme", query = "SELECT p FROM Programme p WHERE p.stratrgieprogramme = :stratrgieprogramme"), @NamedQuery(name = "Programme.findByRespomeo", query = "SELECT p FROM Programme p WHERE p.respomeo = :respomeo"), @NamedQuery(name = "Programme.findByCadremeo", query = "SELECT p FROM Programme p WHERE p.cadremeo = :cadremeo"), @NamedQuery(name = "Programme.findByImpact", query = "SELECT p FROM Programme p WHERE p.impact = :impact"), @NamedQuery(name = "Programme.findByEtat", query = "SELECT p FROM Programme p WHERE p.etat = :etat"), @NamedQuery(name = "Programme.findByDateEnregistre", query = "SELECT p FROM Programme p WHERE p.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Programme.findByDerniereModif", query = "SELECT p FROM Programme p WHERE p.derniereModif = :derniereModif"), @NamedQuery(name = "Programme.findByObjectifs", query = "SELECT p FROM Programme p WHERE p.objectifs = :objectifs"), @NamedQuery(name = "Programme.findByObjectifstrategique", query = "SELECT p FROM Programme p WHERE p.objectifstrategique = :objectifstrategique"), @NamedQuery(name = "Programme.findByFonction", query = "SELECT p FROM Programme p WHERE p.fonction = :fonction"), @NamedQuery(name = "Programme.findByIndicateur", query = "SELECT p FROM Programme p WHERE p.indicateur = :indicateur"), @NamedQuery(name = "Programme.findByBaseline", query = "SELECT p FROM Programme p WHERE p.baseline = :baseline"), @NamedQuery(name = "Programme.findByCible", query = "SELECT p FROM Programme p WHERE p.cible = :cible")})
/*     */ public class Programme
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idprogramme")
/*     */   private Long idprogramme;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "stratrgieprogramme")
/*     */   private String stratrgieprogramme;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "respomeo")
/*     */   private String respomeo;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "cadremeo")
/*     */   private String cadremeo;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "impact")
/*     */   private String impact;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "objectifs")
/*     */   private String objectifs;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "objectifstrategique")
/*     */   private String objectifstrategique;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "fonction")
/*     */   private String fonction;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "indicateur")
/*     */   private String indicateur;
/*     */   @Column(name = "baseline")
/*     */   private Double baseline;
/*     */   @Column(name = "cible")
/*     */   private Double cible;
/*     */   @JoinColumn(name = "idaxestrategique", referencedColumnName = "idaxestrategique")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Axestrategique idaxestrategique;
/*     */   @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Institution idinstitution;
/*     */   @JoinColumn(name = "idsoussecteur", referencedColumnName = "idsoussecteur")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Soussecteur idsoussecteur;
/*     */   
/*     */   public Programme() {}
/*     */   
/*     */   public Programme(Long idprogramme) {
/* 116 */     this.idprogramme = idprogramme;
/*     */   }
/*     */   
/*     */   public Long getIdprogramme() {
/* 120 */     return this.idprogramme;
/*     */   }
/*     */   
/*     */   public void setIdprogramme(Long idprogramme) {
/* 124 */     this.idprogramme = idprogramme;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 128 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 132 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 136 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 140 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getStratrgieprogramme() {
/* 144 */     return this.stratrgieprogramme;
/*     */   }
/*     */   
/*     */   public void setStratrgieprogramme(String stratrgieprogramme) {
/* 148 */     this.stratrgieprogramme = stratrgieprogramme;
/*     */   }
/*     */   
/*     */   public String getRespomeo() {
/* 152 */     return this.respomeo;
/*     */   }
/*     */   
/*     */   public void setRespomeo(String respomeo) {
/* 156 */     this.respomeo = respomeo;
/*     */   }
/*     */   
/*     */   public String getCadremeo() {
/* 160 */     return this.cadremeo;
/*     */   }
/*     */   
/*     */   public void setCadremeo(String cadremeo) {
/* 164 */     this.cadremeo = cadremeo;
/*     */   }
/*     */   
/*     */   public String getImpact() {
/* 168 */     return this.impact;
/*     */   }
/*     */   
/*     */   public void setImpact(String impact) {
/* 172 */     this.impact = impact;
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
/*     */   public String getObjectifs() {
/* 200 */     return this.objectifs;
/*     */   }
/*     */   
/*     */   public void setObjectifs(String objectifs) {
/* 204 */     this.objectifs = objectifs;
/*     */   }
/*     */   
/*     */   public String getObjectifstrategique() {
/* 208 */     return this.objectifstrategique;
/*     */   }
/*     */   
/*     */   public void setObjectifstrategique(String objectifstrategique) {
/* 212 */     this.objectifstrategique = objectifstrategique;
/*     */   }
/*     */   
/*     */   public String getFonction() {
/* 216 */     return this.fonction;
/*     */   }
/*     */   
/*     */   public void setFonction(String fonction) {
/* 220 */     this.fonction = fonction;
/*     */   }
/*     */   
/*     */   public String getIndicateur() {
/* 224 */     return this.indicateur;
/*     */   }
/*     */   
/*     */   public void setIndicateur(String indicateur) {
/* 228 */     this.indicateur = indicateur;
/*     */   }
/*     */   
/*     */   public Double getBaseline() {
/* 232 */     return this.baseline;
/*     */   }
/*     */   
/*     */   public void setBaseline(Double baseline) {
/* 236 */     this.baseline = baseline;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/* 240 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/* 244 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public Axestrategique getIdaxestrategique() {
/* 248 */     return this.idaxestrategique;
/*     */   }
/*     */   
/*     */   public void setIdaxestrategique(Axestrategique idaxestrategique) {
/* 252 */     this.idaxestrategique = idaxestrategique;
/*     */   }
/*     */   
/*     */   public Institution getIdinstitution() {
/* 256 */     return this.idinstitution;
/*     */   }
/*     */   
/*     */   public void setIdinstitution(Institution idinstitution) {
/* 260 */     this.idinstitution = idinstitution;
/*     */   }
/*     */   
/*     */   public Soussecteur getIdsoussecteur() {
/* 264 */     return this.idsoussecteur;
/*     */   }
/*     */   
/*     */   public void setIdsoussecteur(Soussecteur idsoussecteur) {
/* 268 */     this.idsoussecteur = idsoussecteur;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 273 */     int hash = 0;
/* 274 */     hash += (this.idprogramme != null) ? this.idprogramme.hashCode() : 0;
/* 275 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 281 */     if (!(object instanceof Programme)) {
/* 282 */       return false;
/*     */     }
/* 284 */     Programme other = (Programme)object;
/* 285 */     if ((this.idprogramme == null && other.idprogramme != null) || (this.idprogramme != null && !this.idprogramme.equals(other.idprogramme))) {
/* 286 */       return false;
/*     */     }
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 293 */     return "entities.Programme[ idprogramme=" + this.idprogramme + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Programme.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */