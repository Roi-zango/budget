/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ @Table(name = "adresse")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"), @NamedQuery(name = "Adresse.findByIdAdresse", query = "SELECT a FROM Adresse a WHERE a.idAdresse = :idAdresse"), @NamedQuery(name = "Adresse.findByContact", query = "SELECT a FROM Adresse a WHERE a.contact = :contact"), @NamedQuery(name = "Adresse.findByFax", query = "SELECT a FROM Adresse a WHERE a.fax = :fax"), @NamedQuery(name = "Adresse.findByBp", query = "SELECT a FROM Adresse a WHERE a.bp = :bp"), @NamedQuery(name = "Adresse.findByEmail", query = "SELECT a FROM Adresse a WHERE a.email = :email"), @NamedQuery(name = "Adresse.findBySiteWeb", query = "SELECT a FROM Adresse a WHERE a.siteWeb = :siteWeb")})
/*     */ public class Adresse
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_adresse")
/*     */   private Long idAdresse;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "contact")
/*     */   private String contact;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "fax")
/*     */   private String fax;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "bp")
/*     */   private String bp;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "email")
/*     */   private String email;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "site_web")
/*     */   private String siteWeb;
/*     */   @OneToMany(mappedBy = "idAdresse", fetch = FetchType.LAZY)
/*     */   private List<Utilisateur> utilisateurList;
/*     */   @OneToMany(mappedBy = "idAdresse", fetch = FetchType.LAZY)
/*     */   private List<Structure> structureList;
/*     */   @JoinColumn(name = "id_quartier", referencedColumnName = "id_quartier")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Quartier idQuartier;
/*     */   @JoinColumn(name = "id_rue", referencedColumnName = "id_rue")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Rue idRue;
/*     */   @JoinColumn(name = "id_ville", referencedColumnName = "id_ville")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Ville idVille;
/*     */   
/*     */   public Adresse() {}
/*     */   
/*     */   public Adresse(Long idAdresse) {
/*  83 */     this.idAdresse = idAdresse;
/*     */   }
/*     */   
/*     */   public Long getIdAdresse() {
/*  87 */     return this.idAdresse;
/*     */   }
/*     */   
/*     */   public void setIdAdresse(Long idAdresse) {
/*  91 */     this.idAdresse = idAdresse;
/*     */   }
/*     */   
/*     */   public String getContact() {
/*  95 */     return this.contact;
/*     */   }
/*     */   
/*     */   public void setContact(String contact) {
/*  99 */     this.contact = contact;
/*     */   }
/*     */   
/*     */   public String getFax() {
/* 103 */     return this.fax;
/*     */   }
/*     */   
/*     */   public void setFax(String fax) {
/* 107 */     this.fax = fax;
/*     */   }
/*     */   
/*     */   public String getBp() {
/* 111 */     return this.bp;
/*     */   }
/*     */   
/*     */   public void setBp(String bp) {
/* 115 */     this.bp = bp;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 119 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 123 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getSiteWeb() {
/* 127 */     return this.siteWeb;
/*     */   }
/*     */   
/*     */   public void setSiteWeb(String siteWeb) {
/* 131 */     this.siteWeb = siteWeb;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Utilisateur> getUtilisateurList() {
/* 136 */     return this.utilisateurList;
/*     */   }
/*     */   
/*     */   public void setUtilisateurList(List<Utilisateur> utilisateurList) {
/* 140 */     this.utilisateurList = utilisateurList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Structure> getStructureList() {
/* 145 */     return this.structureList;
/*     */   }
/*     */   
/*     */   public void setStructureList(List<Structure> structureList) {
/* 149 */     this.structureList = structureList;
/*     */   }
/*     */   
/*     */   public Quartier getIdQuartier() {
/* 153 */     return this.idQuartier;
/*     */   }
/*     */   
/*     */   public void setIdQuartier(Quartier idQuartier) {
/* 157 */     this.idQuartier = idQuartier;
/*     */   }
/*     */   
/*     */   public Rue getIdRue() {
/* 161 */     return this.idRue;
/*     */   }
/*     */   
/*     */   public void setIdRue(Rue idRue) {
/* 165 */     this.idRue = idRue;
/*     */   }
/*     */   
/*     */   public Ville getIdVille() {
/* 169 */     return this.idVille;
/*     */   }
/*     */   
/*     */   public void setIdVille(Ville idVille) {
/* 173 */     this.idVille = idVille;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 178 */     int hash = 0;
/* 179 */     hash += (this.idAdresse != null) ? this.idAdresse.hashCode() : 0;
/* 180 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 186 */     if (!(object instanceof Adresse)) {
/* 187 */       return false;
/*     */     }
/* 189 */     Adresse other = (Adresse)object;
/* 190 */     if ((this.idAdresse == null && other.idAdresse != null) || (this.idAdresse != null && !this.idAdresse.equals(other.idAdresse))) {
/* 191 */       return false;
/*     */     }
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     return "entities.Adresse[ idAdresse=" + this.idAdresse + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Adresse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */