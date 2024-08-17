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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "cdmt")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Cdmt.findAll", query = "SELECT c FROM Cdmt c"), @NamedQuery(name = "Cdmt.findByIdcdmt", query = "SELECT c FROM Cdmt c WHERE c.idcdmt = :idcdmt"), @NamedQuery(name = "Cdmt.findByNom", query = "SELECT c FROM Cdmt c WHERE c.nom = :nom"), @NamedQuery(name = "Cdmt.findByAnneedebut", query = "SELECT c FROM Cdmt c WHERE c.anneedebut = :anneedebut"), @NamedQuery(name = "Cdmt.findByAnneefin", query = "SELECT c FROM Cdmt c WHERE c.anneefin = :anneefin")})
/*     */ public class Cdmt
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "idcdmt")
/*     */   private Integer idcdmt;
/*     */   @Size(max = 100)
/*     */   @Column(name = "nom")
/*     */   private String nom;
/*     */   @Column(name = "anneedebut")
/*     */   private Integer anneedebut;
/*     */   @Column(name = "anneefin")
/*     */   private Integer anneefin;
/*     */   
/*     */   public Cdmt() {}
/*     */   
/*     */   public Cdmt(Integer idcdmt) {
/*  53 */     this.idcdmt = idcdmt;
/*     */   }
/*     */   
/*     */   public Integer getIdcdmt() {
/*  57 */     return this.idcdmt;
/*     */   }
/*     */   
/*     */   public void setIdcdmt(Integer idcdmt) {
/*  61 */     this.idcdmt = idcdmt;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  65 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  69 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Integer getAnneedebut() {
/*  73 */     return this.anneedebut;
/*     */   }
/*     */   
/*     */   public void setAnneedebut(Integer anneedebut) {
/*  77 */     this.anneedebut = anneedebut;
/*     */   }
/*     */   
/*     */   public Integer getAnneefin() {
/*  81 */     return this.anneefin;
/*     */   }
/*     */   
/*     */   public void setAnneefin(Integer anneefin) {
/*  85 */     this.anneefin = anneefin;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  90 */     int hash = 0;
/*  91 */     hash += (this.idcdmt != null) ? this.idcdmt.hashCode() : 0;
/*  92 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/*  98 */     if (!(object instanceof Cdmt)) {
/*  99 */       return false;
/*     */     }
/* 101 */     Cdmt other = (Cdmt)object;
/* 102 */     if ((this.idcdmt == null && other.idcdmt != null) || (this.idcdmt != null && !this.idcdmt.equals(other.idcdmt))) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 110 */     return "entities.Cdmt[ idcdmt=" + this.idcdmt + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Cdmt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */