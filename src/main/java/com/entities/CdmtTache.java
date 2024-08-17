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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "cdmt_tache")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "CdmtTache.findAll", query = "SELECT c FROM CdmtTache c"), @NamedQuery(name = "CdmtTache.findById", query = "SELECT c FROM CdmtTache c WHERE c.id = :id"), @NamedQuery(name = "CdmtTache.findByAeannee1", query = "SELECT c FROM CdmtTache c WHERE c.aeannee1 = :aeannee1"), @NamedQuery(name = "CdmtTache.findByRi1", query = "SELECT c FROM CdmtTache c WHERE c.ri1 = :ri1"), @NamedQuery(name = "CdmtTache.findByRi2", query = "SELECT c FROM CdmtTache c WHERE c.ri2 = :ri2"), @NamedQuery(name = "CdmtTache.findByRi3", query = "SELECT c FROM CdmtTache c WHERE c.ri3 = :ri3"), @NamedQuery(name = "CdmtTache.findByRe1", query = "SELECT c FROM CdmtTache c WHERE c.re1 = :re1"), @NamedQuery(name = "CdmtTache.findByRe2", query = "SELECT c FROM CdmtTache c WHERE c.re2 = :re2"), @NamedQuery(name = "CdmtTache.findByRe3", query = "SELECT c FROM CdmtTache c WHERE c.re3 = :re3"), @NamedQuery(name = "CdmtTache.findByIdcdmt", query = "SELECT c FROM CdmtTache c WHERE c.idcdmt = :idcdmt"), @NamedQuery(name = "CdmtTache.findByIdtache", query = "SELECT c FROM CdmtTache c WHERE c.idtache = :idtache"), @NamedQuery(name = "CdmtTache.findByIdcdmtTache", query = "SELECT c FROM CdmtTache c WHERE c.idcdmtTache = :idcdmtTache")})
/*     */ public class CdmtTache
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "ID")
/*     */   private Integer id;
/*     */   @Column(name = "aeannee1")
/*     */   private Double aeannee1;
/*     */   @Column(name = "ri1")
/*     */   private Double ri1;
/*     */   @Column(name = "ri2")
/*     */   private Double ri2;
/*     */   @Column(name = "ri3")
/*     */   private Double ri3;
/*     */   @Column(name = "re1")
/*     */   private Double re1;
/*     */   @Column(name = "re2")
/*     */   private Double re2;
/*     */   @Column(name = "re3")
/*     */   private Double re3;
/*     */   @Column(name = "idcdmt")
/*     */   private Double idcdmt;
/*     */   @Column(name = "idtache")
/*     */   private Double idtache;
/*     */   @Column(name = "idcdmt_tache")
/*     */   private Double idcdmtTache;
/*     */   
/*     */   public CdmtTache() {}
/*     */   
/*     */   public CdmtTache(Integer id) {
/*  73 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getId() {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  81 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Double getAeannee1() {
/*  85 */     return this.aeannee1;
/*     */   }
/*     */   
/*     */   public void setAeannee1(Double aeannee1) {
/*  89 */     this.aeannee1 = aeannee1;
/*     */   }
/*     */   
/*     */   public Double getRi1() {
/*  93 */     return this.ri1;
/*     */   }
/*     */   
/*     */   public void setRi1(Double ri1) {
/*  97 */     this.ri1 = ri1;
/*     */   }
/*     */   
/*     */   public Double getRi2() {
/* 101 */     return this.ri2;
/*     */   }
/*     */   
/*     */   public void setRi2(Double ri2) {
/* 105 */     this.ri2 = ri2;
/*     */   }
/*     */   
/*     */   public Double getRi3() {
/* 109 */     return this.ri3;
/*     */   }
/*     */   
/*     */   public void setRi3(Double ri3) {
/* 113 */     this.ri3 = ri3;
/*     */   }
/*     */   
/*     */   public Double getRe1() {
/* 117 */     return this.re1;
/*     */   }
/*     */   
/*     */   public void setRe1(Double re1) {
/* 121 */     this.re1 = re1;
/*     */   }
/*     */   
/*     */   public Double getRe2() {
/* 125 */     return this.re2;
/*     */   }
/*     */   
/*     */   public void setRe2(Double re2) {
/* 129 */     this.re2 = re2;
/*     */   }
/*     */   
/*     */   public Double getRe3() {
/* 133 */     return this.re3;
/*     */   }
/*     */   
/*     */   public void setRe3(Double re3) {
/* 137 */     this.re3 = re3;
/*     */   }
/*     */   
/*     */   public Double getIdcdmt() {
/* 141 */     return this.idcdmt;
/*     */   }
/*     */   
/*     */   public void setIdcdmt(Double idcdmt) {
/* 145 */     this.idcdmt = idcdmt;
/*     */   }
/*     */   
/*     */   public Double getIdtache() {
/* 149 */     return this.idtache;
/*     */   }
/*     */   
/*     */   public void setIdtache(Double idtache) {
/* 153 */     this.idtache = idtache;
/*     */   }
/*     */   
/*     */   public Double getIdcdmtTache() {
/* 157 */     return this.idcdmtTache;
/*     */   }
/*     */   
/*     */   public void setIdcdmtTache(Double idcdmtTache) {
/* 161 */     this.idcdmtTache = idcdmtTache;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 166 */     int hash = 0;
/* 167 */     hash += (this.id != null) ? this.id.hashCode() : 0;
/* 168 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 174 */     if (!(object instanceof CdmtTache)) {
/* 175 */       return false;
/*     */     }
/* 177 */     CdmtTache other = (CdmtTache)object;
/* 178 */     if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
/* 179 */       return false;
/*     */     }
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     return "entities.CdmtTache[ id=" + this.id + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\CdmtTache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */