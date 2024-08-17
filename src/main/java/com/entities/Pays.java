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
/*     */ @Table(name = "pays")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"), @NamedQuery(name = "Pays.findByIdPays", query = "SELECT p FROM Pays p WHERE p.idPays = :idPays"), @NamedQuery(name = "Pays.findByLibelle", query = "SELECT p FROM Pays p WHERE p.libelle = :libelle"), @NamedQuery(name = "Pays.findByCode", query = "SELECT p FROM Pays p WHERE p.code = :code"), @NamedQuery(name = "Pays.findByDrapeau", query = "SELECT p FROM Pays p WHERE p.drapeau = :drapeau"), @NamedQuery(name = "Pays.findByDrapeauRelatif", query = "SELECT p FROM Pays p WHERE p.drapeauRelatif = :drapeauRelatif"), @NamedQuery(name = "Pays.findByEtat", query = "SELECT p FROM Pays p WHERE p.etat = :etat"), @NamedQuery(name = "Pays.findByDateEnregistre", query = "SELECT p FROM Pays p WHERE p.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Pays.findByDerniereModif", query = "SELECT p FROM Pays p WHERE p.derniereModif = :derniereModif")})
/*     */ public class Pays
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_pays")
/*     */   private Long idPays;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Column(name = "code")
/*     */   private Integer code;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "drapeau")
/*     */   private String drapeau;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "drapeau_relatif")
/*     */   private String drapeauRelatif;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @OneToMany(mappedBy = "idPays", fetch = FetchType.LAZY)
/*     */   private List<Utilisateur> utilisateurList;
/*     */   @OneToMany(mappedBy = "idPays", fetch = FetchType.LAZY)
/*     */   private List<Region> regionList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idPays", fetch = FetchType.LAZY)
/*     */   private List<Ville> villeList;
/*     */   @JoinColumn(name = "id_continent", referencedColumnName = "id_continent")
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Continent idContinent;
/*     */   
/*     */   public Pays() {}
/*     */   
/*     */   public Pays(Long idPays) {
/*  88 */     this.idPays = idPays;
/*     */   }
/*     */   
/*     */   public Long getIdPays() {
/*  92 */     return this.idPays;
/*     */   }
/*     */   
/*     */   public void setIdPays(Long idPays) {
/*  96 */     this.idPays = idPays;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/* 100 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/* 104 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public Integer getCode() {
/* 108 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(Integer code) {
/* 112 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getDrapeau() {
/* 116 */     return this.drapeau;
/*     */   }
/*     */   
/*     */   public void setDrapeau(String drapeau) {
/* 120 */     this.drapeau = drapeau;
/*     */   }
/*     */   
/*     */   public String getDrapeauRelatif() {
/* 124 */     return this.drapeauRelatif;
/*     */   }
/*     */   
/*     */   public void setDrapeauRelatif(String drapeauRelatif) {
/* 128 */     this.drapeauRelatif = drapeauRelatif;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 132 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 136 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 140 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 144 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 148 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 152 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Utilisateur> getUtilisateurList() {
/* 157 */     return this.utilisateurList;
/*     */   }
/*     */   
/*     */   public void setUtilisateurList(List<Utilisateur> utilisateurList) {
/* 161 */     this.utilisateurList = utilisateurList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Region> getRegionList() {
/* 166 */     return this.regionList;
/*     */   }
/*     */   
/*     */   public void setRegionList(List<Region> regionList) {
/* 170 */     this.regionList = regionList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Ville> getVilleList() {
/* 175 */     return this.villeList;
/*     */   }
/*     */   
/*     */   public void setVilleList(List<Ville> villeList) {
/* 179 */     this.villeList = villeList;
/*     */   }
/*     */   
/*     */   public Continent getIdContinent() {
/* 183 */     return this.idContinent;
/*     */   }
/*     */   
/*     */   public void setIdContinent(Continent idContinent) {
/* 187 */     this.idContinent = idContinent;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 192 */     int hash = 0;
/* 193 */     hash += (this.idPays != null) ? this.idPays.hashCode() : 0;
/* 194 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 200 */     if (!(object instanceof Pays)) {
/* 201 */       return false;
/*     */     }
/* 203 */     Pays other = (Pays)object;
/* 204 */     if ((this.idPays == null && other.idPays != null) || (this.idPays != null && !this.idPays.equals(other.idPays))) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 212 */     return "entities.Pays[ idPays=" + this.idPays + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Pays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */