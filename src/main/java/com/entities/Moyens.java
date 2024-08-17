/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "moyens")
/*     */ @XmlRootElement
/*     */ @NamedQueries({@NamedQuery(name = "Moyens.findAll", query = "SELECT m FROM Moyens m"), @NamedQuery(name = "Moyens.findByIdmoyens", query = "SELECT m FROM Moyens m WHERE m.idmoyens = :idmoyens"), @NamedQuery(name = "Moyens.findByCp", query = "SELECT m FROM Moyens m WHERE m.cp = :cp"), @NamedQuery(name = "Moyens.findByCt", query = "SELECT m FROM Moyens m WHERE m.ct = :ct"), @NamedQuery(name = "Moyens.findByCu", query = "SELECT m FROM Moyens m WHERE m.cu = :cu"), @NamedQuery(name = "Moyens.findByQte", query = "SELECT m FROM Moyens m WHERE m.qte = :qte"), @NamedQuery(name = "Moyens.findByObservation", query = "SELECT m FROM Moyens m WHERE m.observation = :observation"), @NamedQuery(name = "Moyens.findByIdbudget", query = "SELECT m FROM Moyens m WHERE m.idbudget = :idbudget"), @NamedQuery(name = "Moyens.findByMontantexecute", query = "SELECT m FROM Moyens m WHERE m.montantexecute = :montantexecute"), @NamedQuery(name = "Moyens.findByEtat", query = "SELECT m FROM Moyens m WHERE m.etat = :etat"), @NamedQuery(name = "Moyens.findByDateEnregistre", query = "SELECT m FROM Moyens m WHERE m.dateEnregistre = :dateEnregistre"), @NamedQuery(name = "Moyens.findByDerniereModif", query = "SELECT m FROM Moyens m WHERE m.derniereModif = :derniereModif"), @NamedQuery(name = "Moyens.findByQuantie", query = "SELECT m FROM Moyens m WHERE m.quantie = :quantie"), @NamedQuery(name = "Moyens.findByCpanneeplus1", query = "SELECT m FROM Moyens m WHERE m.cpanneeplus1 = :cpanneeplus1"), @NamedQuery(name = "Moyens.findByCpanneeplus2", query = "SELECT m FROM Moyens m WHERE m.cpanneeplus2 = :cpanneeplus2")})
/*     */ public class Moyens
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @Basic(optional = false)
/*     */   @NotNull
/*     */   @Column(name = "idmoyens")
/*     */   private Integer idmoyens;
/*     */   @Column(name = "cp")
/*     */   private Double cp;
/*     */   @Column(name = "ct")
/*     */   private Double ct;
/*     */   @Column(name = "cu")
/*     */   private Double cu;
/*     */   @Column(name = "qte")
/*     */   private Double qte;
/*     */   @Size(max = 255)
/*     */   @Column(name = "observation")
/*     */   private String observation;
/*     */   @Column(name = "idbudget")
/*     */   private Double idbudget;
/*     */   @Column(name = "montantexecute")
/*     */   private Double montantexecute;
/*     */   @Size(max = 50)
/*     */   @Column(name = "etat")
/*     */   private String etat;
/*     */   @Column(name = "date_enregistre")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateEnregistre;
/*     */   @Column(name = "derniere_modif")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date derniereModif;
/*     */   @Column(name = "quantie")
/*     */   private Integer quantie;
/*     */   @Column(name = "cpanneeplus1")
/*     */   private Double cpanneeplus1;
/*     */   @Column(name = "cpanneeplus2")
/*     */   private Double cpanneeplus2;
/*     */   @JoinColumn(name = "idimputation", referencedColumnName = "idimputation")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Imputation idimputation;
/*     */   @JoinColumn(name = "idtache", referencedColumnName = "idtache")
/*     */   @ManyToOne(fetch = FetchType.LAZY)
/*     */   private Tache idtache;
/*     */   @Column(name = "montant_liquide")
/*     */   private double montantLiquide;
/*     */   @Column(name = "montant_paye")
/*     */   private double montantPaye;
/*     */   @Column(name = "montant_ordonne")
/*     */   private double montantOrdonne;
/*     */   @Column(name = "taxe_ordonne")
/*     */   private double taxeOrdonne;
/*     */   @Column(name = "nap_ordonne")
/*     */   private double napOrdonne;
/*     */   
/*     */   public Moyens() {}
/*     */   
/*     */   public Moyens(Integer idmoyens) {
/* 110 */     this.idmoyens = idmoyens;
/*     */   }
/*     */   
/*     */   public Integer getIdmoyens() {
/* 114 */     return this.idmoyens;
/*     */   }
/*     */   
/*     */   public void setIdmoyens(Integer idmoyens) {
/* 118 */     this.idmoyens = idmoyens;
/*     */   }
/*     */   
/*     */   public Double getCp() {
/* 122 */     return this.cp;
/*     */   }
/*     */   
/*     */   public void setCp(Double cp) {
/* 126 */     this.cp = cp;
/*     */   }
/*     */   
/*     */   public Double getCt() {
/* 130 */     return this.ct;
/*     */   }
/*     */   
/*     */   public void setCt(Double ct) {
/* 134 */     this.ct = ct;
/*     */   }
/*     */   
/*     */   public Double getCu() {
/* 138 */     return this.cu;
/*     */   }
/*     */   
/*     */   public void setCu(Double cu) {
/* 142 */     this.cu = cu;
/*     */   }
/*     */   
/*     */   public Double getQte() {
/* 146 */     return this.qte;
/*     */   }
/*     */   
/*     */   public void setQte(Double qte) {
/* 150 */     this.qte = qte;
/*     */   }
/*     */   
/*     */   public String getObservation() {
/* 154 */     return this.observation;
/*     */   }
/*     */   
/*     */   public void setObservation(String observation) {
/* 158 */     this.observation = observation;
/*     */   }
/*     */   
/*     */   public Double getIdbudget() {
/* 162 */     return this.idbudget;
/*     */   }
/*     */   
/*     */   public void setIdbudget(Double idbudget) {
/* 166 */     this.idbudget = idbudget;
/*     */   }
/*     */   
/*     */   public Double getMontantexecute() {
/* 170 */     return this.montantexecute;
/*     */   }
/*     */   
/*     */   public void setMontantexecute(Double montantexecute) {
/* 174 */     this.montantexecute = montantexecute;
/*     */   }
/*     */   
/*     */   public String getEtat() {
/* 178 */     return this.etat;
/*     */   }
/*     */   
/*     */   public void setEtat(String etat) {
/* 182 */     this.etat = etat;
/*     */   }
/*     */   
/*     */   public Date getDateEnregistre() {
/* 186 */     return this.dateEnregistre;
/*     */   }
/*     */   
/*     */   public void setDateEnregistre(Date dateEnregistre) {
/* 190 */     this.dateEnregistre = dateEnregistre;
/*     */   }
/*     */   
/*     */   public Date getDerniereModif() {
/* 194 */     return this.derniereModif;
/*     */   }
/*     */   
/*     */   public void setDerniereModif(Date derniereModif) {
/* 198 */     this.derniereModif = derniereModif;
/*     */   }
/*     */   
/*     */   public Integer getQuantie() {
/* 202 */     return this.quantie;
/*     */   }
/*     */   
/*     */   public void setQuantie(Integer quantie) {
/* 206 */     this.quantie = quantie;
/*     */   }
/*     */   
/*     */   public Double getCpanneeplus1() {
/* 210 */     return this.cpanneeplus1;
/*     */   }
/*     */   
/*     */   public void setCpanneeplus1(Double cpanneeplus1) {
/* 214 */     this.cpanneeplus1 = cpanneeplus1;
/*     */   }
/*     */   
/*     */   public Double getCpanneeplus2() {
/* 218 */     return this.cpanneeplus2;
/*     */   }
/*     */   
/*     */   public void setCpanneeplus2(Double cpanneeplus2) {
/* 222 */     this.cpanneeplus2 = cpanneeplus2;
/*     */   }
/*     */   
/*     */   public Imputation getIdimputation() {
/* 226 */     return this.idimputation;
/*     */   }
/*     */   
/*     */   public void setIdimputation(Imputation idimputation) {
/* 230 */     this.idimputation = idimputation;
/*     */   }
/*     */   
/*     */   public Tache getIdtache() {
/* 234 */     return this.idtache;
/*     */   }
/*     */   
/*     */   public void setIdtache(Tache idtache) {
/* 238 */     this.idtache = idtache;
/*     */   }
/*     */   
/*     */   public double getMontantLiquide() {
/* 242 */     return this.montantLiquide;
/*     */   }
/*     */   
/*     */   public void setMontantLiquide(double montantLiquide) {
/* 246 */     this.montantLiquide = montantLiquide;
/*     */   }
/*     */   
/*     */   public double getMontantPaye() {
/* 250 */     return this.montantPaye;
/*     */   }
/*     */   
/*     */   public void setMontantPaye(double montantPaye) {
/* 254 */     this.montantPaye = montantPaye;
/*     */   }
/*     */   
/*     */   public double getMontantOrdonne() {
/* 258 */     return this.montantOrdonne;
/*     */   }
/*     */   
/*     */   public void setMontantOrdonne(double montantOrdonne) {
/* 262 */     this.montantOrdonne = montantOrdonne;
/*     */   }
/*     */   
/*     */   public double getTaxeOrdonne() {
/* 266 */     return this.taxeOrdonne;
/*     */   }
/*     */   
/*     */   public void setTaxeOrdonne(double taxeOrdonne) {
/* 270 */     this.taxeOrdonne = taxeOrdonne;
/*     */   }
/*     */   
/*     */   public double getNapOrdonne() {
/* 274 */     return this.napOrdonne;
/*     */   }
/*     */   
/*     */   public void setNapOrdonne(double napOrdonne) {
/* 278 */     this.napOrdonne = napOrdonne;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 283 */     int hash = 0;
/* 284 */     hash += (this.idmoyens != null) ? this.idmoyens.hashCode() : 0;
/* 285 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 291 */     if (!(object instanceof Moyens)) {
/* 292 */       return false;
/*     */     }
/* 294 */     Moyens other = (Moyens)object;
/* 295 */     if ((this.idmoyens == null && other.idmoyens != null) || (this.idmoyens != null && !this.idmoyens.equals(other.idmoyens))) {
/* 296 */       return false;
/*     */     }
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 303 */     return "entities.Moyens[ idmoyens=" + this.idmoyens + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Moyens.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */