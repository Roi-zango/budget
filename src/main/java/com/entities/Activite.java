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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "activite")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a"), @NamedQuery(name = "Activite.findByIdactivite", query = "SELECT a FROM Activite a WHERE a.idactivite = :idactivite"), @NamedQuery(name = "Activite.findByCode", query = "SELECT a FROM Activite a WHERE a.code = :code"), @NamedQuery(name = "Activite.findByNom", query = "SELECT a FROM Activite a WHERE a.nom = :nom"), @NamedQuery(name = "Activite.findByObjectif", query = "SELECT a FROM Activite a WHERE a.objectif = :objectif"), @NamedQuery(name = "Activite.findByPrio", query = "SELECT a FROM Activite a WHERE a.prio = :prio"), @NamedQuery(name = "Activite.findByPartisprenantes", query = "SELECT a FROM Activite a WHERE a.partisprenantes = :partisprenantes"), @NamedQuery(name = "Activite.findByAutreconcerne", query = "SELECT a FROM Activite a WHERE a.autreconcerne = :autreconcerne"), @NamedQuery(name = "Activite.findByCumulextrants", query = "SELECT a FROM Activite a WHERE a.cumulextrants = :cumulextrants"), @NamedQuery(name = "Activite.findByResponsables", query = "SELECT a FROM Activite a WHERE a.responsables = :responsables"), @NamedQuery(name = "Activite.findByJustification", query = "SELECT a FROM Activite a WHERE a.justification = :justification"), @NamedQuery(name = "Activite.findByEtat", query = "SELECT a FROM Activite a WHERE a.etat = :etat"), @NamedQuery(name = "Activite.findByDateEnregistre", query = "SELECT a FROM Activite a WHERE a.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Activite.findByDerniereModif", query = "SELECT a FROM Activite a WHERE a.derniereModif = :derniereModif"), @NamedQuery(name = "Activite.findByCumulindicateurs", query = "SELECT a FROM Activite a WHERE a.cumulindicateurs = :cumulindicateurs")})
/*     */ public class Activite
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idactivite")
/*     */   private Long idactivite;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "objectif")
/*     */   private String objectif;
/*     */   @Column(name = "prio")
/*     */   private Boolean prio;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "partisprenantes")
/*     */   private String partisprenantes;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "autreconcerne")
/*     */   private String autreconcerne;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "cumulextrants")
/*     */   private String cumulextrants;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "responsables")
/*     */   private String responsables;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "justification")
/*     */   private String justification;
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
/*     */   @Column(name = "cumulindicateurs")
/*     */   private String cumulindicateurs;
/*     */   @OneToMany(mappedBy = "idactivite", fetch = FetchType.LAZY)
/*     */   private List<Tache> tacheList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "activite", fetch = FetchType.LAZY)
/*     */   private List<Structuremissionactivite> structuremissionactiviteList;
/*     */   @JoinColumn(name = "idaction", referencedColumnName = "idaction")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Action idaction;
/*     */   @JoinColumn(name = "idindicateuraction", referencedColumnName = "idindicateuraction")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Indicateuraction idindicateuraction;
/*     */   @JoinColumn(name = "idrang", referencedColumnName = "idrang")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Rang idrang;
/*     */   @JoinColumn(name = "idstructure", referencedColumnName = "idstructure")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Structure idstructure;
/*     */   @JoinColumn(name = "idtypeactivite", referencedColumnName = "idtypeactivite")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Typeactivite idtypeactivite;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "activite", fetch = FetchType.LAZY)
/*     */   private List<Activitetypestructure> activitetypestructureList;
/*     */   @OneToMany(mappedBy = "idactivite", fetch = FetchType.LAZY)
/*     */   private List<Indicateuractivite> indicateuractiviteList;
/*     */   @OneToMany(mappedBy = "idactivite", fetch = FetchType.LAZY)
/*     */   private List<Extrant> extrantList;
/*     */   
/*     */   public Activite() {}
/*     */   
/*     */   public Activite(Long idactivite) {
/* 128 */     this.idactivite = idactivite;
/*     */   }
/*     */   
/*     */   public Long getIdactivite() {
/* 132 */     return this.idactivite;
/*     */   }
/*     */   
/*     */   public void setIdactivite(Long idactivite) {
/* 136 */     this.idactivite = idactivite;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 140 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 144 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 148 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 152 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getObjectif() {
/* 156 */     return this.objectif;
/*     */   }
/*     */   
/*     */   public void setObjectif(String objectif) {
/* 160 */     this.objectif = objectif;
/*     */   }
/*     */   
/*     */   public Boolean getPrio() {
/* 164 */     return this.prio;
/*     */   }
/*     */   
/*     */   public void setPrio(Boolean prio) {
/* 168 */     this.prio = prio;
/*     */   }
/*     */   
/*     */   public String getPartisprenantes() {
/* 172 */     return this.partisprenantes;
/*     */   }
/*     */   
/*     */   public void setPartisprenantes(String partisprenantes) {
/* 176 */     this.partisprenantes = partisprenantes;
/*     */   }
/*     */   
/*     */   public String getAutreconcerne() {
/* 180 */     return this.autreconcerne;
/*     */   }
/*     */   
/*     */   public void setAutreconcerne(String autreconcerne) {
/* 184 */     this.autreconcerne = autreconcerne;
/*     */   }
/*     */   
/*     */   public String getCumulextrants() {
/* 188 */     return this.cumulextrants;
/*     */   }
/*     */   
/*     */   public void setCumulextrants(String cumulextrants) {
/* 192 */     this.cumulextrants = cumulextrants;
/*     */   }
/*     */   
/*     */   public String getResponsables() {
/* 196 */     return this.responsables;
/*     */   }
/*     */   
/*     */   public void setResponsables(String responsables) {
/* 200 */     this.responsables = responsables;
/*     */   }
/*     */   
/*     */   public String getJustification() {
/* 204 */     return this.justification;
/*     */   }
/*     */   
/*     */   public void setJustification(String justification) {
/* 208 */     this.justification = justification;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 212 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 216 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 220 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 224 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 228 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 232 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public String getCumulindicateurs() {
/* 236 */     return this.cumulindicateurs;
/*     */   }
/*     */   
/*     */   public void setCumulindicateurs(String cumulindicateurs) {
/* 240 */     this.cumulindicateurs = cumulindicateurs;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Tache> getTacheList() {
/* 245 */     return this.tacheList;
/*     */   }
/*     */   
/*     */   public void setTacheList(List<Tache> tacheList) {
/* 249 */     this.tacheList = tacheList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structuremissionactivite> getStructuremissionactiviteList() {
/* 254 */     return this.structuremissionactiviteList;
/*     */   }
/*     */   
/*     */   public void setStructuremissionactiviteList(List<Structuremissionactivite> structuremissionactiviteList) {
/* 258 */     this.structuremissionactiviteList = structuremissionactiviteList;
/*     */   }
/*     */   
/*     */   public Action getIdaction() {
/* 262 */     return this.idaction;
/*     */   }
/*     */   
/*     */   public void setIdaction(Action idaction) {
/* 266 */     this.idaction = idaction;
/*     */   }
/*     */   
/*     */   public Indicateuraction getIdindicateuraction() {
/* 270 */     return this.idindicateuraction;
/*     */   }
/*     */   
/*     */   public void setIdindicateuraction(Indicateuraction idindicateuraction) {
/* 274 */     this.idindicateuraction = idindicateuraction;
/*     */   }
/*     */   
/*     */   public Rang getIdrang() {
/* 278 */     return this.idrang;
/*     */   }
/*     */   
/*     */   public void setIdrang(Rang idrang) {
/* 282 */     this.idrang = idrang;
/*     */   }
/*     */   
/*     */   public Structure getIdstructure() {
/* 286 */     return this.idstructure;
/*     */   }
/*     */   
/*     */   public void setIdstructure(Structure idstructure) {
/* 290 */     this.idstructure = idstructure;
/*     */   }
/*     */   
/*     */   public Typeactivite getIdtypeactivite() {
/* 294 */     return this.idtypeactivite;
/*     */   }
/*     */   
/*     */   public void setIdtypeactivite(Typeactivite idtypeactivite) {
/* 298 */     this.idtypeactivite = idtypeactivite;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Activitetypestructure> getActivitetypestructureList() {
/* 303 */     return this.activitetypestructureList;
/*     */   }
/*     */   
/*     */   public void setActivitetypestructureList(List<Activitetypestructure> activitetypestructureList) {
/* 307 */     this.activitetypestructureList = activitetypestructureList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Indicateuractivite> getIndicateuractiviteList() {
/* 312 */     return this.indicateuractiviteList;
/*     */   }
/*     */   
/*     */   public void setIndicateuractiviteList(List<Indicateuractivite> indicateuractiviteList) {
/* 316 */     this.indicateuractiviteList = indicateuractiviteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Extrant> getExtrantList() {
/* 321 */     return this.extrantList;
/*     */   }
/*     */   
/*     */   public void setExtrantList(List<Extrant> extrantList) {
/* 325 */     this.extrantList = extrantList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 330 */     int hash = 0;
/* 331 */     hash += (this.idactivite != null) ? this.idactivite.hashCode() : 0;
/* 332 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 338 */     if (!(object instanceof Activite)) {
/* 339 */       return false;
/*     */     }
/* 341 */     Activite other = (Activite)object;
/* 342 */     if ((this.idactivite == null && other.idactivite != null) || (this.idactivite != null && !this.idactivite.equals(other.idactivite))) {
/* 343 */       return false;
/*     */     }
/* 345 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 350 */     return "entities.Activite[ idactivite=" + this.idactivite + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Activite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */