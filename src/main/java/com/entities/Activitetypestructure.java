/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.EmbeddedId;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Table(name = "activitetypestructure")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Activitetypestructure.findAll", query = "SELECT a FROM Activitetypestructure a"), @NamedQuery(name = "Activitetypestructure.findByIdactivite", query = "SELECT a FROM Activitetypestructure a WHERE a.activitetypestructurePK.idactivite = :idactivite"), @NamedQuery(name = "Activitetypestructure.findByIdtypestructure", query = "SELECT a FROM Activitetypestructure a WHERE a.activitetypestructurePK.idtypestructure = :idtypestructure"), @NamedQuery(name = "Activitetypestructure.findByStrategies", query = "SELECT a FROM Activitetypestructure a WHERE a.strategies = :strategies"), @NamedQuery(name = "Activitetypestructure.findByObjectif", query = "SELECT a FROM Activitetypestructure a WHERE a.objectif = :objectif")})
/*     */ public class Activitetypestructure
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @EmbeddedId
/*     */   protected ActivitetypestructurePK activitetypestructurePK;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "strategies")
/*     */   private String strategies;
/*     */   @Size(max = 1024)
/*     */   @Column(name = "objectif")
/*     */   private String objectif;
/*     */   @JoinColumn(name = "idactivite", referencedColumnName = "idactivite", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Activite activite;
/*     */   @JoinColumn(name = "idtypestructure", referencedColumnName = "idtypestructure", insertable = false, updatable = false)
/*     */   @ManyToOne(optional = false, fetch = FetchType.LAZY)
/*     */   private Typestructure typestructure;
/*     */   
/*     */   public Activitetypestructure() {}
/*     */   
/*     */   public Activitetypestructure(ActivitetypestructurePK activitetypestructurePK) {
/*  55 */     this.activitetypestructurePK = activitetypestructurePK;
/*     */   }
/*     */   
/*     */   public Activitetypestructure(long idactivite, long idtypestructure) {
/*  59 */     this.activitetypestructurePK = new ActivitetypestructurePK(idactivite, idtypestructure);
/*     */   }
/*     */   
/*     */   public ActivitetypestructurePK getActivitetypestructurePK() {
/*  63 */     return this.activitetypestructurePK;
/*     */   }
/*     */   
/*     */   public void setActivitetypestructurePK(ActivitetypestructurePK activitetypestructurePK) {
/*  67 */     this.activitetypestructurePK = activitetypestructurePK;
/*     */   }
/*     */   
/*     */   public String getStrategies() {
/*  71 */     return this.strategies;
/*     */   }
/*     */   
/*     */   public void setStrategies(String strategies) {
/*  75 */     this.strategies = strategies;
/*     */   }
/*     */   
/*     */   public String getObjectif() {
/*  79 */     return this.objectif;
/*     */   }
/*     */   
/*     */   public void setObjectif(String objectif) {
/*  83 */     this.objectif = objectif;
/*     */   }
/*     */   
/*     */   public Activite getActivite() {
/*  87 */     return this.activite;
/*     */   }
/*     */   
/*     */   public void setActivite(Activite activite) {
/*  91 */     this.activite = activite;
/*     */   }
/*     */   
/*     */   public Typestructure getTypestructure() {
/*  95 */     return this.typestructure;
/*     */   }
/*     */   
/*     */   public void setTypestructure(Typestructure typestructure) {
/*  99 */     this.typestructure = typestructure;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 104 */     int hash = 0;
/* 105 */     hash += (this.activitetypestructurePK != null) ? this.activitetypestructurePK.hashCode() : 0;
/* 106 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 112 */     if (!(object instanceof Activitetypestructure)) {
/* 113 */       return false;
/*     */     }
/* 115 */     Activitetypestructure other = (Activitetypestructure)object;
/* 116 */     if ((this.activitetypestructurePK == null && other.activitetypestructurePK != null) || (this.activitetypestructurePK != null && !this.activitetypestructurePK.equals(other.activitetypestructurePK))) {
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     return "entities.Activitetypestructure[ activitetypestructurePK=" + this.activitetypestructurePK + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Activitetypestructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */