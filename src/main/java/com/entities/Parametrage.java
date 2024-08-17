/*     */ package entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
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
/*     */ @Table(name = "parametrage")
/*     */ public class Parametrage
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   private Integer idparametrage;
/*     */   private double tauxtva;
/*     */   private double tauxair;
/*     */   @Column(length = 50, name = "repertoire_photo")
/*     */   private String repertoirePhoto;
/*     */   private double pourcentagemercurial;
/*     */   @Column(length = 50, name = "user_tompro")
/*     */   private String userTompro;
/*     */   @Column(length = 100, name = "password_tompro")
/*     */   private String passwordTompro;
/*     */   @Column(length = 100, name = "chaine_connexion_tompro")
/*     */   private String chaineConnexionTompro;
/*     */   @Column(length = 50, name = "user_gendata")
/*     */   private String userGendata;
/*     */   @Column(length = 100, name = "password_gendata")
/*     */   private String passwordGendata;
/*     */   @Column(length = 100, name = "chaine_connexion_gendata")
/*     */   private String chaineConnexionGendata;
/*     */   @Column(name = "driver_class_name_tompro")
/*     */   private String driverClassNameTompro;
/*     */   @Column(name = "driver_class_name_gendata")
/*     */   private String driverClassNameGendata;
/*     */   @Column(name = "data_base_name_tompro")
/*     */   private String dataBaseNameTompro;
/*     */   @Column(name = "data_base_name_gendata")
/*     */   private String dataBaseNameGendata;
/*     */   
/*     */   public Parametrage() {}
/*     */   
/*     */   public Parametrage(Integer idparametrage) {
/*  65 */     this.idparametrage = idparametrage;
/*     */   }
/*     */   
/*     */   public Integer getIdparametrage() {
/*  69 */     return this.idparametrage;
/*     */   }
/*     */   
/*     */   public void setIdparametrage(Integer idparametrage) {
/*  73 */     this.idparametrage = idparametrage;
/*     */   }
/*     */   
/*     */   public double getTauxtva() {
/*  77 */     return this.tauxtva;
/*     */   }
/*     */   
/*     */   public void setTauxtva(double tauxtva) {
/*  81 */     this.tauxtva = tauxtva;
/*     */   }
/*     */   
/*     */   public double getTauxair() {
/*  85 */     return this.tauxair;
/*     */   }
/*     */   
/*     */   public void setTauxair(double tauxair) {
/*  89 */     this.tauxair = tauxair;
/*     */   }
/*     */   
/*     */   public String getRepertoirePhoto() {
/*  93 */     return this.repertoirePhoto;
/*     */   }
/*     */   
/*     */   public void setRepertoirePhoto(String repertoirePhoto) {
/*  97 */     this.repertoirePhoto = repertoirePhoto;
/*     */   }
/*     */   
/*     */   public double getPourcentagemercurial() {
/* 101 */     return this.pourcentagemercurial;
/*     */   }
/*     */   
/*     */   public void setPourcentagemercurial(double pourcentagemercurial) {
/* 105 */     this.pourcentagemercurial = pourcentagemercurial;
/*     */   }
/*     */   
/*     */   public String getUserTompro() {
/* 109 */     return this.userTompro;
/*     */   }
/*     */   
/*     */   public void setUserTompro(String userTompro) {
/* 113 */     this.userTompro = userTompro;
/*     */   }
/*     */   
/*     */   public String getPasswordTompro() {
/* 117 */     return this.passwordTompro;
/*     */   }
/*     */   
/*     */   public void setPasswordTompro(String passwordTompro) {
/* 121 */     this.passwordTompro = passwordTompro;
/*     */   }
/*     */   
/*     */   public String getChaineConnexionTompro() {
/* 125 */     return this.chaineConnexionTompro;
/*     */   }
/*     */   
/*     */   public void setChaineConnexionTompro(String chaineConnexionTompro) {
/* 129 */     this.chaineConnexionTompro = chaineConnexionTompro;
/*     */   }
/*     */   
/*     */   public String getUserGendata() {
/* 133 */     return this.userGendata;
/*     */   }
/*     */   
/*     */   public void setUserGendata(String userGendata) {
/* 137 */     this.userGendata = userGendata;
/*     */   }
/*     */   
/*     */   public String getPasswordGendata() {
/* 141 */     return this.passwordGendata;
/*     */   }
/*     */   
/*     */   public void setPasswordGendata(String passwordGendata) {
/* 145 */     this.passwordGendata = passwordGendata;
/*     */   }
/*     */   
/*     */   public String getChaineConnexionGendata() {
/* 149 */     return this.chaineConnexionGendata;
/*     */   }
/*     */   
/*     */   public void setChaineConnexionGendata(String chaineConnexionGendata) {
/* 153 */     this.chaineConnexionGendata = chaineConnexionGendata;
/*     */   }
/*     */   
/*     */   public String getDriverClassNameTompro() {
/* 157 */     return this.driverClassNameTompro;
/*     */   }
/*     */   
/*     */   public void setDriverClassNameTompro(String driverClassNameTompro) {
/* 161 */     this.driverClassNameTompro = driverClassNameTompro;
/*     */   }
/*     */   
/*     */   public String getDriverClassNameGendata() {
/* 165 */     return this.driverClassNameGendata;
/*     */   }
/*     */   
/*     */   public void setDriverClassNameGendata(String driverClassNameGendata) {
/* 169 */     this.driverClassNameGendata = driverClassNameGendata;
/*     */   }
/*     */   
/*     */   public String getDataBaseNameTompro() {
/* 173 */     return this.dataBaseNameTompro;
/*     */   }
/*     */   
/*     */   public void setDataBaseNameTompro(String dataBaseNameTompro) {
/* 177 */     this.dataBaseNameTompro = dataBaseNameTompro;
/*     */   }
/*     */   
/*     */   public String getDataBaseNameGendata() {
/* 181 */     return this.dataBaseNameGendata;
/*     */   }
/*     */   
/*     */   public void setDataBaseNameGendata(String dataBaseNameGendata) {
/* 185 */     this.dataBaseNameGendata = dataBaseNameGendata;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 190 */     int hash = 5;
/* 191 */     hash = 37 * hash + Objects.hashCode(this.idparametrage);
/* 192 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 197 */     if (obj == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (getClass() != obj.getClass()) {
/* 201 */       return false;
/*     */     }
/* 203 */     Parametrage other = (Parametrage)obj;
/* 204 */     if (!Objects.equals(this.idparametrage, other.idparametrage)) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 212 */     return "Parametrage{idparametrage=" + this.idparametrage + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Parametrage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */