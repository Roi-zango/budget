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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "action")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a"), @NamedQuery(name = "Action.findByIdaction", query = "SELECT a FROM Action a WHERE a.idaction = :idaction"), @NamedQuery(name = "Action.findByNom", query = "SELECT a FROM Action a WHERE a.nom = :nom"), @NamedQuery(name = "Action.findByCode", query = "SELECT a FROM Action a WHERE a.code = :code"), @NamedQuery(name = "Action.findByEffet", query = "SELECT a FROM Action a WHERE a.effet = :effet"), @NamedQuery(name = "Action.findByCadremeo", query = "SELECT a FROM Action a WHERE a.cadremeo = :cadremeo"), @NamedQuery(name = "Action.findByRespomeo", query = "SELECT a FROM Action a WHERE a.respomeo = :respomeo"), @NamedQuery(name = "Action.findByObjectifs", query = "SELECT a FROM Action a WHERE a.objectifs = :objectifs"), @NamedQuery(name = "Action.findByEtat", query = "SELECT a FROM Action a WHERE a.etat = :etat"), @NamedQuery(name = "Action.findByDateEnregistre", query = "SELECT a FROM Action a WHERE a.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Action.findByDerniereModif", query = "SELECT a FROM Action a WHERE a.derniereModif = :derniereModif"), @NamedQuery(name = "Action.findByIndicateur", query = "SELECT a FROM Action a WHERE a.indicateur = :indicateur"), @NamedQuery(name = "Action.findByCible", query = "SELECT a FROM Action a WHERE a.cible = :cible"), @NamedQuery(name = "Action.findByBaseline", query = "SELECT a FROM Action a WHERE a.baseline = :baseline")})
/*     */ public class Action
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idaction")
/*     */   private Long idaction;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "effet")
/*     */   private String effet;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "cadremeo")
/*     */   private String cadremeo;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "respomeo")
/*     */   private String respomeo;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "objectifs")
/*     */   private String objectifs;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "indicateur")
/*     */   private String indicateur;
/*     */   @Column(name = "cible")
/*     */   private Double cible;
/*     */   @Column(name = "baseline")
/*     */   private Double baseline;
/*     */   @JoinColumn(name = "idindicateurprogramme", referencedColumnName = "idindicateurprogramme")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Indicateurprogramme idindicateurprogramme;
/*     */   @JoinColumn(name = "idzone", referencedColumnName = "idzone")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Zone idzone;
/*     */   @OneToMany(mappedBy = "idaction", fetch = FetchType.LAZY)
/*     */   private List<Revueaction> revueactionList;
/*     */   @OneToMany(mappedBy = "idaction", fetch = FetchType.LAZY)
/*     */   private List<Activite> activiteList;
/*     */   @OneToMany(mappedBy = "idaction", fetch = FetchType.LAZY)
/*     */   private List<Indicateuraction> indicateuractionList;
/*     */   @JoinColumn(name = "idprogramme", referencedColumnName = "idprogramme")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Programme idprogramme;
/*     */   
/*     */   public Action() {}
/*     */   
/*     */   public Action(Long idaction) {
/* 116 */     this.idaction = idaction;
/*     */   }
/*     */   
/*     */   public Long getIdaction() {
/* 120 */     return this.idaction;
/*     */   }
/*     */   
/*     */   public void setIdaction(Long idaction) {
/* 124 */     this.idaction = idaction;
/*     */   }
/*     */   
/*     */   public Programme getIdprogramme() {
/* 128 */     return this.idprogramme;
/*     */   }
/*     */   
/*     */   public void setIdprogramme(Programme idprogramme) {
/* 132 */     this.idprogramme = idprogramme;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 136 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 140 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 144 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 148 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getEffet() {
/* 152 */     return this.effet;
/*     */   }
/*     */   
/*     */   public void setEffet(String effet) {
/* 156 */     this.effet = effet;
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
/*     */   public String getRespomeo() {
/* 168 */     return this.respomeo;
/*     */   }
/*     */   
/*     */   public void setRespomeo(String respomeo) {
/* 172 */     this.respomeo = respomeo;
/*     */   }
/*     */   
/*     */   public String getObjectifs() {
/* 176 */     return this.objectifs;
/*     */   }
/*     */   
/*     */   public void setObjectifs(String objectifs) {
/* 180 */     this.objectifs = objectifs;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 184 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 188 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 192 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 196 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 200 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 204 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public String getIndicateur() {
/* 208 */     return this.indicateur;
/*     */   }
/*     */   
/*     */   public void setIndicateur(String indicateur) {
/* 212 */     this.indicateur = indicateur;
/*     */   }
/*     */   
/*     */   public Double getCible() {
/* 216 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(Double cible) {
/* 220 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public Double getBaseline() {
/* 224 */     return this.baseline;
/*     */   }
/*     */   
/*     */   public void setBaseline(Double baseline) {
/* 228 */     this.baseline = baseline;
/*     */   }
/*     */   
/*     */   public Indicateurprogramme getIdindicateurprogramme() {
/* 232 */     return this.idindicateurprogramme;
/*     */   }
/*     */   
/*     */   public void setIdindicateurprogramme(Indicateurprogramme idindicateurprogramme) {
/* 236 */     this.idindicateurprogramme = idindicateurprogramme;
/*     */   }
/*     */   
/*     */   public Zone getIdzone() {
/* 240 */     return this.idzone;
/*     */   }
/*     */   
/*     */   public void setIdzone(Zone idzone) {
/* 244 */     this.idzone = idzone;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revueaction> getRevueactionList() {
/* 249 */     return this.revueactionList;
/*     */   }
/*     */   
/*     */   public void setRevueactionList(List<Revueaction> revueactionList) {
/* 253 */     this.revueactionList = revueactionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Activite> getActiviteList() {
/* 258 */     return this.activiteList;
/*     */   }
/*     */   
/*     */   public void setActiviteList(List<Activite> activiteList) {
/* 262 */     this.activiteList = activiteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuraction> getIndicateuractionList() {
/* 267 */     return this.indicateuractionList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractionList(List<Indicateuraction> indicateuractionList) {
/* 271 */     this.indicateuractionList = indicateuractionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 276 */     int hash = 0;
/* 277 */     hash += (this.idaction != null) ? this.idaction.hashCode() : 0;
/* 278 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 284 */     if (!(object instanceof Action)) {
/* 285 */       return false;
/*     */     }
/* 287 */     Action other = (Action)object;
/* 288 */     if ((this.idaction == null && other.idaction != null) || (this.idaction != null && !this.idaction.equals(other.idaction))) {
/* 289 */       return false;
/*     */     }
/* 291 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 296 */     return "entities.Action[ idaction=" + this.idaction + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */