/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
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
/*     */ @Table(name = "menu")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"), @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"), @NamedQuery(name = "Menu.findByIdParent", query = "SELECT m FROM Menu m WHERE m.idParent = :idParent"), @NamedQuery(name = "Menu.findByName", query = "SELECT m FROM Menu m WHERE m.name = :name"), @NamedQuery(name = "Menu.findByLibelle", query = "SELECT m FROM Menu m WHERE m.libelle = :libelle"), @NamedQuery(name = "Menu.findByShortcut", query = "SELECT m FROM Menu m WHERE m.shortcut = :shortcut"), @NamedQuery(name = "Menu.findByCategorie", query = "SELECT m FROM Menu m WHERE m.categorie = :categorie"), @NamedQuery(name = "Menu.findByEtat", query = "SELECT m FROM Menu m WHERE m.etat = :etat"), @NamedQuery(name = "Menu.findByDateEnregistre", query = "SELECT m FROM Menu m WHERE m.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Menu.findByDerniereModif", query = "SELECT m FROM Menu m WHERE m.derniereModif = :derniereModif")})
/*     */ public class Menu
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "id_menu")
/*     */   private Long idMenu;
/*     */   @Column(name = "id_parent")
/*     */   private BigInteger idParent;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "name")
/*     */   private String name;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "libelle")
/*     */   private String libelle;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "shortcut")
/*     */   private String shortcut;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "categorie")
/*     */   private String categorie;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   
/*     */   public Menu() {}
/*     */   
/*     */   public Menu(Long idMenu) {
/*  77 */     this.idMenu = idMenu;
/*     */   }
/*     */   
/*     */   public Long getIdMenu() {
/*  81 */     return this.idMenu;
/*     */   }
/*     */   
/*     */   public void setIdMenu(Long idMenu) {
/*  85 */     this.idMenu = idMenu;
/*     */   }
/*     */   
/*     */   public BigInteger getIdParent() {
/*  89 */     return this.idParent;
/*     */   }
/*     */   
/*     */   public void setIdParent(BigInteger idParent) {
/*  93 */     this.idParent = idParent;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  97 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 101 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getLibelle() {
/* 105 */     return this.libelle;
/*     */   }
/*     */   
/*     */   public void setLibelle(String libelle) {
/* 109 */     this.libelle = libelle;
/*     */   }
/*     */   
/*     */   public String getShortcut() {
/* 113 */     return this.shortcut;
/*     */   }
/*     */   
/*     */   public void setShortcut(String shortcut) {
/* 117 */     this.shortcut = shortcut;
/*     */   }
/*     */   
/*     */   public String getCategorie() {
/* 121 */     return this.categorie;
/*     */   }
/*     */   
/*     */   public void setCategorie(String categorie) {
/* 125 */     this.categorie = categorie;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 129 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 133 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 137 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 141 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 145 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 149 */     this.derniereModif = derniereModif;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 154 */     int hash = 0;
/* 155 */     hash += (this.idMenu != null) ? this.idMenu.hashCode() : 0;
/* 156 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 162 */     if (!(object instanceof Menu)) {
/* 163 */       return false;
/*     */     }
/* 165 */     Menu other = (Menu)object;
/* 166 */     if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
/* 167 */       return false;
/*     */     }
/* 169 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     return "entities.Menu[ idMenu=" + this.idMenu + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */