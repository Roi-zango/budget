/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.NotNull;
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
/*     */ @Table(name = "boncommande")
/*     */ public class Boncommande
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @NotNull
/*     */   @Column(name = "idboncommande")
/*     */   private Long idboncommande;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateemission;
/*     */   @Column(length = 300)
/*     */   private String objet;
/*     */   @Column(length = 25)
/*     */   private String code;
/*     */   private int delailivraison;
/*     */   private double totalht;
/*     */   private double tva;
/*     */   private double totalair;
/*     */   private double netapayer;
/*     */   private double avance;
/*     */   private String montantenlettre;
/*     */   private Double ttc;
/*     */   private boolean cheque;
/*     */   private boolean espece;
/*     */   private boolean virement;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date datelivraison;
/*     */   private boolean engage;
/*     */   private double tauxtva;
/*     */   private double tauxair;
/*     */   @Column(length = 50)
/*     */   private String imputations;
/*     */   @Column(length = 35)
/*     */   private String reference;
/*     */   private double coefficientreducteur;
/*     */   private boolean verif;
/*     */   private boolean valide;
/*     */   private int nombreverif;
/*     */   private boolean bc;
/*     */   private boolean decision;
/*     */   private boolean lettrecommande;
/*     */   private boolean mission;
/*     */   @Column(name = "gre_a_gre")
/*     */   private boolean greAgre;
/*     */   private boolean attentepayement;
/*     */   private boolean paye;
/*     */   private boolean liquide;
/*     */   private boolean salaire;
/*     */   @Column(name = "montant_paye")
/*     */   private double montantPaye;
/*     */   @Column(name = "montant_ordonne")
/*     */   private double montantOrdonne;
/*     */   @Column(name = "taxe_ordonne")
/*     */   private double taxeOrdonne;
/*     */   @Column(name = "nap_ordonne")
/*     */   private double napOrdonne;
/*     */   @JoinColumn(name = "idstructure", referencedColumnName = "idstructure")
/*     */   @ManyToOne
/*     */   private Structure structure;
/*     */   @JoinColumn(name = "idsociete", referencedColumnName = "idsociete")
/*     */   @ManyToOne
/*     */   private Societe societe;
/*     */   @JoinColumn(name = "idsignataire", referencedColumnName = "idsignataire")
/*     */   @ManyToOne
/*     */   private Signataire signataire;
/*     */   @JoinColumn(name = "idimputation", referencedColumnName = "idimputation")
/*     */   @ManyToOne
/*     */   private Imputation imputation;
/*     */   @JoinColumn(name = "idbudget", referencedColumnName = "idbudget")
/*     */   @ManyToOne
/*     */   private Budget budget;
/*     */   @JoinColumn(name = "idmoyens", referencedColumnName = "idmoyens")
/*     */   @ManyToOne
/*     */   private Moyens moyens;
/*     */   @OneToMany(mappedBy = "boncommande", fetch = FetchType.LAZY)
/*     */   private List<Ligneboncommande> ligneboncommandes;
/*     */   
/*     */   public Boncommande() {}
/*     */   
/*     */   public Boncommande(Long idboncommande) {
/* 110 */     this.idboncommande = idboncommande;
/*     */   }
/*     */   
/*     */   public Long getIdboncommande() {
/* 114 */     return this.idboncommande;
/*     */   }
/*     */   
/*     */   public void setIdboncommande(Long idboncommande) {
/* 118 */     this.idboncommande = idboncommande;
/*     */   }
/*     */   
/*     */   public Date getDateemission() {
/* 122 */     return this.dateemission;
/*     */   }
/*     */   
/*     */   public void setDateemission(Date dateemission) {
/* 126 */     this.dateemission = dateemission;
/*     */   }
/*     */   
/*     */   public String getObjet() {
/* 130 */     return this.objet;
/*     */   }
/*     */   
/*     */   public void setObjet(String objet) {
/* 134 */     this.objet = objet;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 138 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 142 */     this.code = code;
/*     */   }
/*     */   
/*     */   public int getDelailivraison() {
/* 146 */     return this.delailivraison;
/*     */   }
/*     */   
/*     */   public void setDelailivraison(int delailivraison) {
/* 150 */     this.delailivraison = delailivraison;
/*     */   }
/*     */   
/*     */   public double getTotalht() {
/* 154 */     return this.totalht;
/*     */   }
/*     */   
/*     */   public void setTotalht(double totalht) {
/* 158 */     this.totalht = totalht;
/*     */   }
/*     */   
/*     */   public double getTva() {
/* 162 */     return this.tva;
/*     */   }
/*     */   
/*     */   public void setTva(double tva) {
/* 166 */     this.tva = tva;
/*     */   }
/*     */   
/*     */   public double getTotalair() {
/* 170 */     return this.totalair;
/*     */   }
/*     */   
/*     */   public void setTotalair(double totalair) {
/* 174 */     this.totalair = totalair;
/*     */   }
/*     */   
/*     */   public double getNetapayer() {
/* 178 */     return this.netapayer;
/*     */   }
/*     */   
/*     */   public void setNetapayer(double netapayer) {
/* 182 */     this.netapayer = netapayer;
/*     */   }
/*     */   
/*     */   public double getAvance() {
/* 186 */     return this.avance;
/*     */   }
/*     */   
/*     */   public void setAvance(double avance) {
/* 190 */     this.avance = avance;
/*     */   }
/*     */   
/*     */   public String getMontantenlettre() {
/* 194 */     return this.montantenlettre;
/*     */   }
/*     */   
/*     */   public void setMontantenlettre(String montantenlettre) {
/* 198 */     this.montantenlettre = montantenlettre;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 202 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 206 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public Societe getSociete() {
/* 210 */     return this.societe;
/*     */   }
/*     */   
/*     */   public void setSociete(Societe societe) {
/* 214 */     this.societe = societe;
/*     */   }
/*     */   
/*     */   public Signataire getSignataire() {
/* 218 */     return this.signataire;
/*     */   }
/*     */   
/*     */   public void setSignataire(Signataire signataire) {
/* 222 */     this.signataire = signataire;
/*     */   }
/*     */   
/*     */   public Imputation getImputation() {
/* 226 */     return this.imputation;
/*     */   }
/*     */   
/*     */   public void setImputation(Imputation imputation) {
/* 230 */     this.imputation = imputation;
/*     */   }
/*     */   
/*     */   public Double getTtc() {
/* 234 */     return this.ttc;
/*     */   }
/*     */   
/*     */   public void setTtc(Double ttc) {
/* 238 */     this.ttc = ttc;
/*     */   }
/*     */   
/*     */   public Budget getBudget() {
/* 242 */     return this.budget;
/*     */   }
/*     */   
/*     */   public void setBudget(Budget budget) {
/* 246 */     this.budget = budget;
/*     */   }
/*     */   
/*     */   public boolean isCheque() {
/* 250 */     return this.cheque;
/*     */   }
/*     */   
/*     */   public void setCheque(boolean cheque) {
/* 254 */     this.cheque = cheque;
/*     */   }
/*     */   
/*     */   public boolean isEspece() {
/* 258 */     return this.espece;
/*     */   }
/*     */   
/*     */   public void setEspece(boolean espece) {
/* 262 */     this.espece = espece;
/*     */   }
/*     */   
/*     */   public boolean isVirement() {
/* 266 */     return this.virement;
/*     */   }
/*     */   
/*     */   public void setVirement(boolean virement) {
/* 270 */     this.virement = virement;
/*     */   }
/*     */   
/*     */   public Date getDatelivraison() {
/* 274 */     return this.datelivraison;
/*     */   }
/*     */   
/*     */   public void setDatelivraison(Date datelivraison) {
/* 278 */     this.datelivraison = datelivraison;
/*     */   }
/*     */   
/*     */   public boolean isEngage() {
/* 282 */     return this.engage;
/*     */   }
/*     */   
/*     */   public void setEngage(boolean engage) {
/* 286 */     this.engage = engage;
/*     */   }
/*     */   
/*     */   public double getTauxtva() {
/* 290 */     return this.tauxtva;
/*     */   }
/*     */   
/*     */   public void setTauxtva(double tauxtva) {
/* 294 */     this.tauxtva = tauxtva;
/*     */   }
/*     */   
/*     */   public double getTauxair() {
/* 298 */     return this.tauxair;
/*     */   }
/*     */   
/*     */   public void setTauxair(double tauxair) {
/* 302 */     this.tauxair = tauxair;
/*     */   }
/*     */   
/*     */   public String getReference() {
/* 306 */     return this.reference;
/*     */   }
/*     */   
/*     */   public void setReference(String reference) {
/* 310 */     this.reference = reference;
/*     */   }
/*     */   
/*     */   public Moyens getMoyens() {
/* 314 */     return this.moyens;
/*     */   }
/*     */   
/*     */   public void setMoyens(Moyens moyens) {
/* 318 */     this.moyens = moyens;
/*     */   }
/*     */   
/*     */   public String getImputations() {
/* 322 */     return this.imputations;
/*     */   }
/*     */   
/*     */   public void setImputations(String imputations) {
/* 326 */     this.imputations = imputations;
/*     */   }
/*     */   
/*     */   public double getCoefficientreducteur() {
/* 330 */     return this.coefficientreducteur;
/*     */   }
/*     */   
/*     */   public void setCoefficientreducteur(double coefficientreducteur) {
/* 334 */     this.coefficientreducteur = coefficientreducteur;
/*     */   }
/*     */   
/*     */   public boolean isVerif() {
/* 338 */     return this.verif;
/*     */   }
/*     */   
/*     */   public void setVerif(boolean verif) {
/* 342 */     this.verif = verif;
/*     */   }
/*     */   
/*     */   public boolean isValide() {
/* 346 */     return this.valide;
/*     */   }
/*     */   
/*     */   public void setValide(boolean valide) {
/* 350 */     this.valide = valide;
/*     */   }
/*     */   
/*     */   public int getNombreverif() {
/* 354 */     return this.nombreverif;
/*     */   }
/*     */   
/*     */   public void setNombreverif(int nombreverif) {
/* 358 */     this.nombreverif = nombreverif;
/*     */   }
/*     */   
/*     */   public boolean isBc() {
/* 362 */     return this.bc;
/*     */   }
/*     */   
/*     */   public void setBc(boolean bc) {
/* 366 */     this.bc = bc;
/*     */   }
/*     */   
/*     */   public boolean isDecision() {
/* 370 */     return this.decision;
/*     */   }
/*     */   
/*     */   public void setDecision(boolean decision) {
/* 374 */     this.decision = decision;
/*     */   }
/*     */   
/*     */   public boolean isLettrecommande() {
/* 378 */     return this.lettrecommande;
/*     */   }
/*     */   
/*     */   public void setLettrecommande(boolean lettrecommande) {
/* 382 */     this.lettrecommande = lettrecommande;
/*     */   }
/*     */   
/*     */   public boolean isMission() {
/* 386 */     return this.mission;
/*     */   }
/*     */   
/*     */   public void setMission(boolean mission) {
/* 390 */     this.mission = mission;
/*     */   }
/*     */   
/*     */   public boolean isGreAgre() {
/* 394 */     return this.greAgre;
/*     */   }
/*     */   
/*     */   public void setGreAgre(boolean greAgre) {
/* 398 */     this.greAgre = greAgre;
/*     */   }
/*     */   
/*     */   public boolean isAttentepayement() {
/* 402 */     return this.attentepayement;
/*     */   }
/*     */   
/*     */   public void setAttentepayement(boolean attentepayement) {
/* 406 */     this.attentepayement = attentepayement;
/*     */   }
/*     */   
/*     */   public boolean isPaye() {
/* 410 */     return this.paye;
/*     */   }
/*     */   
/*     */   public void setPaye(boolean paye) {
/* 414 */     this.paye = paye;
/*     */   }
/*     */   
/*     */   public boolean isLiquide() {
/* 418 */     return this.liquide;
/*     */   }
/*     */   
/*     */   public void setLiquide(boolean liquide) {
/* 422 */     this.liquide = liquide;
/*     */   }
/*     */   
/*     */   public double getMontantPaye() {
/* 426 */     return this.montantPaye;
/*     */   }
/*     */   
/*     */   public void setMontantPaye(double montantPaye) {
/* 430 */     this.montantPaye = montantPaye;
/*     */   }
/*     */   
/*     */   public boolean isSalaire() {
/* 434 */     return this.salaire;
/*     */   }
/*     */   
/*     */   public void setSalaire(boolean salaire) {
/* 438 */     this.salaire = salaire;
/*     */   }
/*     */   
/*     */   public List<Ligneboncommande> getLigneboncommandes() {
/* 442 */     return this.ligneboncommandes;
/*     */   }
/*     */   
/*     */   public void setLigneboncommandes(List<Ligneboncommande> ligneboncommandes) {
/* 446 */     this.ligneboncommandes = ligneboncommandes;
/*     */   }
/*     */   
/*     */   public double getMontantOrdonne() {
/* 450 */     return this.montantOrdonne;
/*     */   }
/*     */   
/*     */   public void setMontantOrdonne(double montantOrdonne) {
/* 454 */     this.montantOrdonne = montantOrdonne;
/*     */   }
/*     */   
/*     */   public double getTaxeOrdonne() {
/* 458 */     return this.taxeOrdonne;
/*     */   }
/*     */   
/*     */   public void setTaxeOrdonne(double taxeOrdonne) {
/* 462 */     this.taxeOrdonne = taxeOrdonne;
/*     */   }
/*     */   
/*     */   public double getNapOrdonne() {
/* 466 */     return this.napOrdonne;
/*     */   }
/*     */   
/*     */   public void setNapOrdonne(double napOrdonne) {
/* 470 */     this.napOrdonne = napOrdonne;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 475 */     return "Bon de commande{idboncommande=" + this.idboncommande + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 480 */     int hash = 3;
/* 481 */     hash = 53 * hash + Objects.hashCode(this.idboncommande);
/* 482 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 487 */     if (obj == null) {
/* 488 */       return false;
/*     */     }
/* 490 */     if (getClass() != obj.getClass()) {
/* 491 */       return false;
/*     */     }
/* 493 */     Boncommande other = (Boncommande)obj;
/* 494 */     if (!Objects.equals(this.idboncommande, other.idboncommande)) {
/* 495 */       return false;
/*     */     }
/* 497 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Boncommande.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */