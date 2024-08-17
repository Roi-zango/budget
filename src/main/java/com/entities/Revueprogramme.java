/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.EmbeddedId;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Entity
/*     */ @Table(name = "revueprogramme")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Revueprogramme.findAll", query = "SELECT r FROM Revueprogramme r"), @NamedQuery(name = "Revueprogramme.findByIdrevue", query = "SELECT r FROM Revueprogramme r WHERE r.revueprogrammePK.idrevue = :idrevue"), @NamedQuery(name = "Revueprogramme.findByIdprogramme", query = "SELECT r FROM Revueprogramme r WHERE r.revueprogrammePK.idprogramme = :idprogramme"), @NamedQuery(name = "Revueprogramme.findByCout", query = "SELECT r FROM Revueprogramme r WHERE r.cout = :cout"), @NamedQuery(name = "Revueprogramme.findByProduits", query = "SELECT r FROM Revueprogramme r WHERE r.produits = :produits"), @NamedQuery(name = "Revueprogramme.findByContextmeo", query = "SELECT r FROM Revueprogramme r WHERE r.contextmeo = :contextmeo"), @NamedQuery(name = "Revueprogramme.findByDifficultes", query = "SELECT r FROM Revueprogramme r WHERE r.difficultes = :difficultes"), @NamedQuery(name = "Revueprogramme.findByPerspectives", query = "SELECT r FROM Revueprogramme r WHERE r.perspectives = :perspectives"), @NamedQuery(name = "Revueprogramme.findByPriseencompte", query = "SELECT r FROM Revueprogramme r WHERE r.priseencompte = :priseencompte"), @NamedQuery(name = "Revueprogramme.findByFaits", query = "SELECT r FROM Revueprogramme r WHERE r.faits = :faits"), @NamedQuery(name = "Revueprogramme.findByImplications", query = "SELECT r FROM Revueprogramme r WHERE r.implications = :implications"), @NamedQuery(name = "Revueprogramme.findByAjustementactions", query = "SELECT r FROM Revueprogramme r WHERE r.ajustementactions = :ajustementactions"), @NamedQuery(name = "Revueprogramme.findByObservations", query = "SELECT r FROM Revueprogramme r WHERE r.observations = :observations"), @NamedQuery(name = "Revueprogramme.findByEtat", query = "SELECT r FROM Revueprogramme r WHERE r.etat = :etat"), @NamedQuery(name = "Revueprogramme.findByDateEnregistre", query = "SELECT r FROM Revueprogramme r WHERE r.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Revueprogramme.findByDerniereModif", query = "SELECT r FROM Revueprogramme r WHERE r.derniereModif = :derniereModif")})
/*     */ public class Revueprogramme
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected RevueprogrammePK revueprogrammePK;
/*     */   @Column(name = "cout")
/*     */   private Double cout;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "produits")
/*     */   private String produits;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "contextmeo")
/*     */   private String contextmeo;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "difficultes")
/*     */   private String difficultes;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "perspectives")
/*     */   private String perspectives;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "priseencompte")
/*     */   private String priseencompte;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "faits")
/*     */   private String faits;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "implications")
/*     */   private String implications;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "ajustementactions")
/*     */   private String ajustementactions;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "observations")
/*     */   private String observations;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @JoinColumn(name = "idrevue", referencedColumnName = "idrevue", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Revue revue;
/*     */   @OneToMany(mappedBy = "revueprogramme", fetch = FetchType.LAZY)
/*     */   private List<Revueaction> revueactionList;
/*     */   @OneToMany(mappedBy = "revueprogramme", fetch = FetchType.LAZY)
/*     */   private List<Revueperformance> revueperformanceList;
/*     */   @OneToMany(mappedBy = "revueprogramme", fetch = FetchType.LAZY)
/*     */   private List<Revuefait> revuefaitList;
/*     */   @OneToMany(mappedBy = "revueprogramme", fetch = FetchType.LAZY)
/*     */   private List<Revueactivite> revueactiviteList;
/*     */   @OneToMany(mappedBy = "revueprogramme", fetch = FetchType.LAZY)
/*     */   private List<Revuedifficilte> revuedifficilteList;
/*     */   
/*     */   public Revueprogramme() {}
/*     */   
/*     */   public Revueprogramme(RevueprogrammePK revueprogrammePK) {
/* 112 */     this.revueprogrammePK = revueprogrammePK;
/*     */   }
/*     */   
/*     */   public Revueprogramme(long idrevue, long idprogramme) {
/* 116 */     this.revueprogrammePK = new RevueprogrammePK(idrevue, idprogramme);
/*     */   }
/*     */   
/*     */   public RevueprogrammePK getRevueprogrammePK() {
/* 120 */     return this.revueprogrammePK;
/*     */   }
/*     */   
/*     */   public void setRevueprogrammePK(RevueprogrammePK revueprogrammePK) {
/* 124 */     this.revueprogrammePK = revueprogrammePK;
/*     */   }
/*     */   
/*     */   public Double getCout() {
/* 128 */     return this.cout;
/*     */   }
/*     */   
/*     */   public void setCout(Double cout) {
/* 132 */     this.cout = cout;
/*     */   }
/*     */   
/*     */   public String getProduits() {
/* 136 */     return this.produits;
/*     */   }
/*     */   
/*     */   public void setProduits(String produits) {
/* 140 */     this.produits = produits;
/*     */   }
/*     */   
/*     */   public String getContextmeo() {
/* 144 */     return this.contextmeo;
/*     */   }
/*     */   
/*     */   public void setContextmeo(String contextmeo) {
/* 148 */     this.contextmeo = contextmeo;
/*     */   }
/*     */   
/*     */   public String getDifficultes() {
/* 152 */     return this.difficultes;
/*     */   }
/*     */   
/*     */   public void setDifficultes(String difficultes) {
/* 156 */     this.difficultes = difficultes;
/*     */   }
/*     */   
/*     */   public String getPerspectives() {
/* 160 */     return this.perspectives;
/*     */   }
/*     */   
/*     */   public void setPerspectives(String perspectives) {
/* 164 */     this.perspectives = perspectives;
/*     */   }
/*     */   
/*     */   public String getPriseencompte() {
/* 168 */     return this.priseencompte;
/*     */   }
/*     */   
/*     */   public void setPriseencompte(String priseencompte) {
/* 172 */     this.priseencompte = priseencompte;
/*     */   }
/*     */   
/*     */   public String getFaits() {
/* 176 */     return this.faits;
/*     */   }
/*     */   
/*     */   public void setFaits(String faits) {
/* 180 */     this.faits = faits;
/*     */   }
/*     */   
/*     */   public String getImplications() {
/* 184 */     return this.implications;
/*     */   }
/*     */   
/*     */   public void setImplications(String implications) {
/* 188 */     this.implications = implications;
/*     */   }
/*     */   
/*     */   public String getAjustementactions() {
/* 192 */     return this.ajustementactions;
/*     */   }
/*     */   
/*     */   public void setAjustementactions(String ajustementactions) {
/* 196 */     this.ajustementactions = ajustementactions;
/*     */   }
/*     */   
/*     */   public String getObservations() {
/* 200 */     return this.observations;
/*     */   }
/*     */   
/*     */   public void setObservations(String observations) {
/* 204 */     this.observations = observations;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 208 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 212 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 216 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 220 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 224 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 228 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Revue getRevue() {
/* 232 */     return this.revue;
/*     */   }
/*     */   
/*     */   public void setRevue(Revue revue) {
/* 236 */     this.revue = revue;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revueaction> getRevueactionList() {
/* 241 */     return this.revueactionList;
/*     */   }
/*     */   
/*     */   public void setRevueactionList(List<Revueaction> revueactionList) {
/* 245 */     this.revueactionList = revueactionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revueperformance> getRevueperformanceList() {
/* 250 */     return this.revueperformanceList;
/*     */   }
/*     */   
/*     */   public void setRevueperformanceList(List<Revueperformance> revueperformanceList) {
/* 254 */     this.revueperformanceList = revueperformanceList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revuefait> getRevuefaitList() {
/* 259 */     return this.revuefaitList;
/*     */   }
/*     */   
/*     */   public void setRevuefaitList(List<Revuefait> revuefaitList) {
/* 263 */     this.revuefaitList = revuefaitList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revueactivite> getRevueactiviteList() {
/* 268 */     return this.revueactiviteList;
/*     */   }
/*     */   
/*     */   public void setRevueactiviteList(List<Revueactivite> revueactiviteList) {
/* 272 */     this.revueactiviteList = revueactiviteList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Revuedifficilte> getRevuedifficilteList() {
/* 277 */     return this.revuedifficilteList;
/*     */   }
/*     */   
/*     */   public void setRevuedifficilteList(List<Revuedifficilte> revuedifficilteList) {
/* 281 */     this.revuedifficilteList = revuedifficilteList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 286 */     int hash = 0;
/* 287 */     hash += (this.revueprogrammePK != null) ? this.revueprogrammePK.hashCode() : 0;
/* 288 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 294 */     if (!(object instanceof Revueprogramme)) {
/* 295 */       return false;
/*     */     }
/* 297 */     Revueprogramme other = (Revueprogramme)object;
/* 298 */     if ((this.revueprogrammePK == null && other.revueprogrammePK != null) || (this.revueprogrammePK != null && !this.revueprogrammePK.equals(other.revueprogrammePK))) {
/* 299 */       return false;
/*     */     }
/* 301 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 306 */     return "entities.Revueprogramme[ revueprogrammePK=" + this.revueprogrammePK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueprogramme.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */