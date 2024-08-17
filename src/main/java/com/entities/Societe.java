/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "societe")
/*     */ public class Societe
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @NotNull
/*     */   private Integer idsociete;
/*     */   @Column(length = 100)
/*     */   private String nom;
/*     */   @Column(length = 100)
/*     */   private String ad1;
/*     */   @Column(length = 100)
/*     */   private String ad2;
/*     */   @Column(length = 100)
/*     */   private String ad3;
/*     */   @Column(length = 10)
/*     */   private String coge;
/*     */   @Column(length = 12)
/*     */   private String auxi;
/*     */   @Column(length = 30)
/*     */   private String numerocontribuable;
/*     */   @Column(length = 100)
/*     */   private String contact;
/*     */   @Column(length = 50)
/*     */   private String tel;
/*     */   @Column(length = 50)
/*     */   private String fax;
/*     */   @Column(length = 50)
/*     */   private String email;
/*     */   @Column(length = 3)
/*     */   private String pays;
/*     */   @Column(length = 50)
/*     */   private String rib1;
/*     */   @Column(length = 50)
/*     */   private String rib2;
/*     */   @Column(length = 50)
/*     */   private String dom1;
/*     */   @Column(length = 50)
/*     */   private String dom2;
/*     */   private int nbjours;
/*     */   private int jourref;
/*     */   @Column(length = 10)
/*     */   private String cogeconsolide;
/*     */   @Column(length = 10)
/*     */   private String auxiconsolide;
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date datecre;
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date datemaj;
/*     */   @Column(length = 10)
/*     */   private String usercre;
/*     */   @Column(length = 10)
/*     */   private String usermaj;
/*     */   @Column(length = 25)
/*     */   private String planconsolide;
/*     */   private Boolean statut;
/*     */   @Column(length = 100)
/*     */   private String rc;
/*     */   @Column(length = 100)
/*     */   private String nif;
/*     */   @Column(length = 100)
/*     */   private String stat;
/*     */   @Column(length = 50)
/*     */   private String bqnom;
/*     */   @Column(length = 50)
/*     */   private String bqville;
/*     */   @Column(length = 50)
/*     */   private String bqpays;
/*     */   @Column(length = 50)
/*     */   private String bqswift;
/*     */   
/*     */   public Integer getIdsociete() {
/* 131 */     return this.idsociete;
/*     */   }
/*     */   
/*     */   public void setIdsociete(Integer idsociete) {
/* 135 */     this.idsociete = idsociete;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 139 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 143 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public String getNumerocontribuable() {
/* 147 */     return this.numerocontribuable;
/*     */   }
/*     */   
/*     */   public void setNumerocontribuable(String numerocontribuable) {
/* 151 */     this.numerocontribuable = numerocontribuable;
/*     */   }
/*     */   
/*     */   public String getAd1() {
/* 155 */     return this.ad1;
/*     */   }
/*     */   
/*     */   public void setAd1(String ad1) {
/* 159 */     this.ad1 = ad1;
/*     */   }
/*     */   
/*     */   public String getAd2() {
/* 163 */     return this.ad2;
/*     */   }
/*     */   
/*     */   public void setAd2(String ad2) {
/* 167 */     this.ad2 = ad2;
/*     */   }
/*     */   
/*     */   public String getAd3() {
/* 171 */     return this.ad3;
/*     */   }
/*     */   
/*     */   public void setAd3(String ad3) {
/* 175 */     this.ad3 = ad3;
/*     */   }
/*     */   
/*     */   public String getContact() {
/* 179 */     return this.contact;
/*     */   }
/*     */   
/*     */   public void setContact(String contact) {
/* 183 */     this.contact = contact;
/*     */   }
/*     */   
/*     */   public String getTel() {
/* 187 */     return this.tel;
/*     */   }
/*     */   
/*     */   public void setTel(String tel) {
/* 191 */     this.tel = tel;
/*     */   }
/*     */   
/*     */   public String getFax() {
/* 195 */     return this.fax;
/*     */   }
/*     */   
/*     */   public void setFax(String fax) {
/* 199 */     this.fax = fax;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 203 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 207 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getPays() {
/* 211 */     return this.pays;
/*     */   }
/*     */   
/*     */   public void setPays(String pays) {
/* 215 */     this.pays = pays;
/*     */   }
/*     */   
/*     */   public String getRib1() {
/* 219 */     return this.rib1;
/*     */   }
/*     */   
/*     */   public void setRib1(String rib1) {
/* 223 */     this.rib1 = rib1;
/*     */   }
/*     */   
/*     */   public String getRib2() {
/* 227 */     return this.rib2;
/*     */   }
/*     */   
/*     */   public void setRib2(String rib2) {
/* 231 */     this.rib2 = rib2;
/*     */   }
/*     */   
/*     */   public String getDom1() {
/* 235 */     return this.dom1;
/*     */   }
/*     */   
/*     */   public void setDom1(String dom1) {
/* 239 */     this.dom1 = dom1;
/*     */   }
/*     */   
/*     */   public String getDom2() {
/* 243 */     return this.dom2;
/*     */   }
/*     */   
/*     */   public void setDom2(String dom2) {
/* 247 */     this.dom2 = dom2;
/*     */   }
/*     */   
/*     */   public int getNbjours() {
/* 251 */     return this.nbjours;
/*     */   }
/*     */   
/*     */   public void setNbjours(int nbjours) {
/* 255 */     this.nbjours = nbjours;
/*     */   }
/*     */   
/*     */   public int getJourref() {
/* 259 */     return this.jourref;
/*     */   }
/*     */   
/*     */   public void setJourref(int jourref) {
/* 263 */     this.jourref = jourref;
/*     */   }
/*     */   
/*     */   public String getCogeconsolide() {
/* 267 */     return this.cogeconsolide;
/*     */   }
/*     */   
/*     */   public void setCogeconsolide(String cogeconsolide) {
/* 271 */     this.cogeconsolide = cogeconsolide;
/*     */   }
/*     */   
/*     */   public String getAuxiconsolide() {
/* 275 */     return this.auxiconsolide;
/*     */   }
/*     */   
/*     */   public void setAuxiconsolide(String auxiconsolide) {
/* 279 */     this.auxiconsolide = auxiconsolide;
/*     */   }
/*     */   
/*     */   public Date getDatecre() {
/* 283 */     return this.datecre;
/*     */   }
/*     */   
/*     */   public void setDatecre(Date datecre) {
/* 287 */     this.datecre = datecre;
/*     */   }
/*     */   
/*     */   public Date getDatemaj() {
/* 291 */     return this.datemaj;
/*     */   }
/*     */   
/*     */   public void setDatemaj(Date datemaj) {
/* 295 */     this.datemaj = datemaj;
/*     */   }
/*     */   
/*     */   public String getUsercre() {
/* 299 */     return this.usercre;
/*     */   }
/*     */   
/*     */   public void setUsercre(String usercre) {
/* 303 */     this.usercre = usercre;
/*     */   }
/*     */   
/*     */   public String getPlanconsolide() {
/* 307 */     return this.planconsolide;
/*     */   }
/*     */   
/*     */   public void setPlanconsolide(String planconsolide) {
/* 311 */     this.planconsolide = planconsolide;
/*     */   }
/*     */   
/*     */   public boolean isStatut() {
/* 315 */     return this.statut.booleanValue();
/*     */   }
/*     */   
/*     */   public void setStatut(boolean statut) {
/* 319 */     this.statut = Boolean.valueOf(statut);
/*     */   }
/*     */   
/*     */   public String getRc() {
/* 323 */     return this.rc;
/*     */   }
/*     */   
/*     */   public void setRc(String rc) {
/* 327 */     this.rc = rc;
/*     */   }
/*     */   
/*     */   public String getNif() {
/* 331 */     return this.nif;
/*     */   }
/*     */   
/*     */   public void setNif(String nif) {
/* 335 */     this.nif = nif;
/*     */   }
/*     */   
/*     */   public String getStat() {
/* 339 */     return this.stat;
/*     */   }
/*     */   
/*     */   public void setStat(String stat) {
/* 343 */     this.stat = stat;
/*     */   }
/*     */   
/*     */   public String getBqnom() {
/* 347 */     return this.bqnom;
/*     */   }
/*     */   
/*     */   public void setBqnom(String bqnom) {
/* 351 */     this.bqnom = bqnom;
/*     */   }
/*     */   
/*     */   public String getBqville() {
/* 355 */     return this.bqville;
/*     */   }
/*     */   
/*     */   public void setBqville(String bqville) {
/* 359 */     this.bqville = bqville;
/*     */   }
/*     */   
/*     */   public String getBqpays() {
/* 363 */     return this.bqpays;
/*     */   }
/*     */   
/*     */   public void setBqpays(String bqpays) {
/* 367 */     this.bqpays = bqpays;
/*     */   }
/*     */   
/*     */   public String getBqswift() {
/* 371 */     return this.bqswift;
/*     */   }
/*     */   
/*     */   public void setBqswift(String bqswift) {
/* 375 */     this.bqswift = bqswift;
/*     */   }
/*     */   
/*     */   public String getCoge() {
/* 379 */     return this.coge;
/*     */   }
/*     */   
/*     */   public void setCoge(String coge) {
/* 383 */     this.coge = coge;
/*     */   }
/*     */   
/*     */   public String getUsermaj() {
/* 387 */     return this.usermaj;
/*     */   }
/*     */   
/*     */   public void setUsermaj(String usermaj) {
/* 391 */     this.usermaj = usermaj;
/*     */   }
/*     */   
/*     */   public String getAuxi() {
/* 395 */     return this.auxi;
/*     */   }
/*     */   
/*     */   public void setAuxi(String auxi) {
/* 399 */     this.auxi = auxi;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 404 */     int hash = 7;
/* 405 */     hash = 41 * hash + Objects.hashCode(this.idsociete);
/* 406 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 411 */     if (obj == null) {
/* 412 */       return false;
/*     */     }
/* 414 */     if (getClass() != obj.getClass()) {
/* 415 */       return false;
/*     */     }
/* 417 */     Societe other = (Societe)obj;
/* 418 */     if (!Objects.equals(this.idsociete, other.idsociete)) {
/* 419 */       return false;
/*     */     }
/* 421 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 426 */     return "Societe{idsociete=" + this.idsociete + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Societe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */