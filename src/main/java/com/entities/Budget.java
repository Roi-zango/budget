/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
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
/*     */ @Entity
/*     */ @Table(name = "budget")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Budget.findAll", query = "SELECT b FROM Budget b"), @NamedQuery(name = "Budget.findByIdbudget", query = "SELECT b FROM Budget b WHERE b.idbudget = :idbudget"), @NamedQuery(name = "Budget.findByNom", query = "SELECT b FROM Budget b WHERE b.nom = :nom"), @NamedQuery(name = "Budget.findByAnnee", query = "SELECT b FROM Budget b WHERE b.annee = :annee")})
/*     */ public class Budget
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idbudget")
/*     */   private Integer idbudget;
/*     */   @Size(max = 60)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Size(max = 4)
/*     */   @Column(name = "annee")
/*     */   private String annee;
/*     */   
/*     */   public Budget() {}
/*     */   
/*     */   public Budget(Integer idbudget) {
/*  51 */     this.idbudget = idbudget;
/*     */   }
/*     */   
/*     */   public Integer getIdbudget() {
/*  55 */     return this.idbudget;
/*     */   }
/*     */   
/*     */   public void setIdbudget(Integer idbudget) {
/*  59 */     this.idbudget = idbudget;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  63 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  67 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getAnnee() {
/*  71 */     return this.annee;
/*     */   }
/*     */   
/*     */   public void setAnnee(String annee) {
/*  75 */     this.annee = annee;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  80 */     int hash = 0;
/*  81 */     hash += (this.idbudget != null) ? this.idbudget.hashCode() : 0;
/*  82 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*  88 */     if (!(object instanceof Budget)) {
/*  89 */       return false;
/*     */     }
/*  91 */     Budget other = (Budget)object;
/*  92 */     if ((this.idbudget == null && other.idbudget != null) || (this.idbudget != null && !this.idbudget.equals(other.idbudget))) {
/*  93 */       return false;
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     return "entities.Budget[ idbudget=" + this.idbudget + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Budget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */