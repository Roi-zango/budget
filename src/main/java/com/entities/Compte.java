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
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
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
/*     */ @Entity
/*     */ @Table(name = "compte")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c"), @NamedQuery(name = "Compte.findByIdCompte", query = "SELECT c FROM Compte c WHERE c.idCompte = :idCompte"), @NamedQuery(name = "Compte.findByLogin", query = "SELECT c FROM Compte c WHERE c.login = :login"), @NamedQuery(name = "Compte.findByMdp", query = "SELECT c FROM Compte c WHERE c.mdp = :mdp"), @NamedQuery(name = "Compte.findByLangue", query = "SELECT c FROM Compte c WHERE c.langue = :langue"), @NamedQuery(name = "Compte.findByConnexion", query = "SELECT c FROM Compte c WHERE c.connexion = :connexion"), @NamedQuery(name = "Compte.findByEtat", query = "SELECT c FROM Compte c WHERE c.etat = :etat"), @NamedQuery(name = "Compte.findByHeurecondecon", query = "SELECT c FROM Compte c WHERE c.heurecondecon = :heurecondecon"), @NamedQuery(name = "Compte.findByDateEnregistre", query = "SELECT c FROM Compte c WHERE c.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Compte.findByDernieremodif", query = "SELECT c FROM Compte c WHERE c.dernieremodif = :dernieremodif")})
/*     */ public class Compte
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_compte")
/*     */   private Long idCompte;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "login")
/*     */   private String login;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "mdp")
/*     */   private String mdp;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "langue")
/*     */   private String langue;
/*     */   @Size(max = 50)
/*     */   @Column(name = "connexion")
/*     */   private String connexion;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "heurecondecon")
/*     */   @Temporal(TemporalType.TIME)
/*     */   private Date heurecondecon;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "dernieremodif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dernieremodif;
/*     */   @JoinTable(name = "cpte_grpusers", joinColumns = {@JoinColumn(name = "id_compte", referencedColumnName = "id_compte")}, inverseJoinColumns = {@JoinColumn(name = "id_groupe_utilisateur", referencedColumnName = "id_groupe_utilisateur")})
/*     */   @ManyToMany(fetch = FetchType.LAZY)
/*     */   private List<GroupeUtilisateur> groupeUtilisateurList;
/*     */   @OneToMany(mappedBy = "idCompte", fetch = FetchType.LAZY)
/*     */   private List<Privilege> privilegeList;
/*     */   @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idCompte", fetch = FetchType.LAZY)
/*     */   private List<Operations> operationsList;
/*     */   @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Utilisateur idUtilisateur;
/*     */   
/*     */   public Compte() {}
/*     */   
/*     */   public Compte(Long idCompte) {
/*  98 */     this.idCompte = idCompte;
/*     */   }
/*     */   
/*     */   public Long getIdCompte() {
/* 102 */     return this.idCompte;
/*     */   }
/*     */   
/*     */   public void setIdCompte(Long idCompte) {
/* 106 */     this.idCompte = idCompte;
/*     */   }
/*     */   
/*     */   public String getLogin() {
/* 110 */     return this.login;
/*     */   }
/*     */   
/*     */   public void setLogin(String login) {
/* 114 */     this.login = login;
/*     */   }
/*     */   
/*     */   public String getMdp() {
/* 118 */     return this.mdp;
/*     */   }
/*     */   
/*     */   public void setMdp(String mdp) {
/* 122 */     this.mdp = mdp;
/*     */   }
/*     */   
/*     */   public String getLangue() {
/* 126 */     return this.langue;
/*     */   }
/*     */   
/*     */   public void setLangue(String langue) {
/* 130 */     this.langue = langue;
/*     */   }
/*     */   
/*     */   public String getConnexion() {
/* 134 */     return this.connexion;
/*     */   }
/*     */   
/*     */   public void setConnexion(String connexion) {
/* 138 */     this.connexion = connexion;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 142 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 146 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getHeurecondecon() {
/* 150 */     return this.heurecondecon;
/*     */   }
/*     */   
/*     */   public void setHeurecondecon(Date heurecondecon) {
/* 154 */     this.heurecondecon = heurecondecon;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 158 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 162 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDernieremodif() {
/* 166 */     return this.dernieremodif;
/*     */   }
/*     */   
/*     */   public void setDernieremodif(Date dernieremodif) {
/* 170 */     this.dernieremodif = dernieremodif;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<GroupeUtilisateur> getGroupeUtilisateurList() {
/* 175 */     return this.groupeUtilisateurList;
/*     */   }
/*     */   
/*     */   public void setGroupeUtilisateurList(List<GroupeUtilisateur> groupeUtilisateurList) {
/* 179 */     this.groupeUtilisateurList = groupeUtilisateurList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Privilege> getPrivilegeList() {
/* 184 */     return this.privilegeList;
/*     */   }
/*     */   
/*     */   public void setPrivilegeList(List<Privilege> privilegeList) {
/* 188 */     this.privilegeList = privilegeList;
/*     */   }
/*     */   
/*     */   @XmlTransient
/*     */   public List<Operations> getOperationsList() {
/* 193 */     return this.operationsList;
/*     */   }
/*     */   
/*     */   public void setOperationsList(List<Operations> operationsList) {
/* 197 */     this.operationsList = operationsList;
/*     */   }
/*     */   
/*     */   public Utilisateur getIdUtilisateur() {
/* 201 */     return this.idUtilisateur;
/*     */   }
/*     */   
/*     */   public void setIdUtilisateur(Utilisateur idUtilisateur) {
/* 205 */     this.idUtilisateur = idUtilisateur;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 210 */     int hash = 0;
/* 211 */     hash += (this.idCompte != null) ? this.idCompte.hashCode() : 0;
/* 212 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 218 */     if (!(object instanceof Compte)) {
/* 219 */       return false;
/*     */     }
/* 221 */     Compte other = (Compte)object;
/* 222 */     if ((this.idCompte == null && other.idCompte != null) || (this.idCompte != null && !this.idCompte.equals(other.idCompte))) {
/* 223 */       return false;
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 230 */     return "entities.Compte[ idCompte=" + this.idCompte + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Compte.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */