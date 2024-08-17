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
/*     */ @Entity
/*     */ @Table(name = "mission")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Mission.findAll", query = "SELECT m FROM Mission m"), @NamedQuery(name = "Mission.findByIdmission", query = "SELECT m FROM Mission m WHERE m.idmission = :idmission"), @NamedQuery(name = "Mission.findByCode", query = "SELECT m FROM Mission m WHERE m.code = :code"), @NamedQuery(name = "Mission.findByProblemes", query = "SELECT m FROM Mission m WHERE m.problemes = :problemes"), @NamedQuery(name = "Mission.findByObjectgeneral", query = "SELECT m FROM Mission m WHERE m.objectgeneral = :objectgeneral"), @NamedQuery(name = "Mission.findByObservation", query = "SELECT m FROM Mission m WHERE m.observation = :observation"), @NamedQuery(name = "Mission.findByObjectspecifique", query = "SELECT m FROM Mission m WHERE m.objectspecifique = :objectspecifique"), @NamedQuery(name = "Mission.findByNom", query = "SELECT m FROM Mission m WHERE m.nom = :nom"), @NamedQuery(name = "Mission.findByEtat", query = "SELECT m FROM Mission m WHERE m.etat = :etat"), @NamedQuery(name = "Mission.findByDateEnregistre", query = "SELECT m FROM Mission m WHERE m.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Mission.findByDerniereModif", query = "SELECT m FROM Mission m WHERE m.derniereModif = :derniereModif")})
/*     */ public class Mission
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idmission")
/*     */   private Long idmission;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "code")
/*     */   private String code;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "problemes")
/*     */   private String problemes;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "objectgeneral")
/*     */   private String objectgeneral;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "observation")
/*     */   private String observation;
/*     */   @Size(max = 2147483647)
/*     */   @Column(name = "objectspecifique")
/*     */   private String objectspecifique;
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
/*     */   @JoinColumn(name = "idbasejuridique", referencedColumnName = "idbasejuridique")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Basejuridique idbasejuridique;
/*     */   @JoinColumn(name = "idniveaupyramide", referencedColumnName = "idniveaupyramide")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Niveaupyramide idniveaupyramide;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "mission", fetch = FetchType.LAZY)
/*     */   private List<Structuremission> structuremissionList;
/*     */   
/*     */   public Mission() {}
/*     */   
/*     */   public Mission(Long idmission) {
/*  96 */     this.idmission = idmission;
/*     */   }
/*     */   
/*     */   public Long getIdmission() {
/* 100 */     return this.idmission;
/*     */   }
/*     */   
/*     */   public void setIdmission(Long idmission) {
/* 104 */     this.idmission = idmission;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 108 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 112 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getProblemes() {
/* 116 */     return this.problemes;
/*     */   }
/*     */   
/*     */   public void setProblemes(String problemes) {
/* 120 */     this.problemes = problemes;
/*     */   }
/*     */   
/*     */   public String getObjectgeneral() {
/* 124 */     return this.objectgeneral;
/*     */   }
/*     */   
/*     */   public void setObjectgeneral(String objectgeneral) {
/* 128 */     this.objectgeneral = objectgeneral;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 132 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 136 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public String getObjectspecifique() {
/* 140 */     return this.objectspecifique;
/*     */   }
/*     */   
/*     */   public void setObjectspecifique(String objectspecifique) {
/* 144 */     this.objectspecifique = objectspecifique;
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
/*     */   public String getEtat() {
/* 156 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 160 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 164 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 168 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 172 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 176 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Basejuridique getIdbasejuridique() {
/* 180 */     return this.idbasejuridique;
/*     */   }
/*     */   
/*     */   public void setIdbasejuridique(Basejuridique idbasejuridique) {
/* 184 */     this.idbasejuridique = idbasejuridique;
/*     */   }
/*     */   
/*     */   public Niveaupyramide getIdniveaupyramide() {
/* 188 */     return this.idniveaupyramide;
/*     */   }
/*     */   
/*     */   public void setIdniveaupyramide(Niveaupyramide idniveaupyramide) {
/* 192 */     this.idniveaupyramide = idniveaupyramide;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structuremission> getStructuremissionList() {
/* 197 */     return this.structuremissionList;
/*     */   }
/*     */   
/*     */   public void setStructuremissionList(List<Structuremission> structuremissionList) {
/* 201 */     this.structuremissionList = structuremissionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 206 */     int hash = 0;
/* 207 */     hash += (this.idmission != null) ? this.idmission.hashCode() : 0;
/* 208 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 214 */     if (!(object instanceof Mission)) {
/* 215 */       return false;
/*     */     }
/* 217 */     Mission other = (Mission)object;
/* 218 */     if ((this.idmission == null && other.idmission != null) || (this.idmission != null && !this.idmission.equals(other.idmission))) {
/* 219 */       return false;
/*     */     }
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 226 */     return "entities.Mission[ idmission=" + this.idmission + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Mission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */