/*     */ package utilitaire;
/*     */ 
/*     */ import controllers.SocieteController;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Compte;
/*     */ import entities.Operations;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.joda.time.DateTime;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.OperationsFacadeLocal;
/*     */ import sessions.OrdrePayementFacadeLocal;
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
/*     */ public class Utilitaires
/*     */ {
/*  31 */   private static final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
/*  32 */   public static final String path = servletContext.getRealPath("");
/*     */   
/*     */   public static final String repertoireDefautAnalyseNorme = "Rapports/AnalyseNorme";
/*     */   
/*     */   public static final String nomFichierParDefautAnalyseNorme = "AnalyseNorme.pdf";
/*     */   
/*     */   public static final String repertoire_document = "/photos/";
/*     */   public static final String userAvatar = "avatar1.png";
/*     */   
/*     */   public static String formaterStringMoney(Long valeur) {
/*  42 */     String chaine = Long.toString(valeur.longValue());
/*  43 */     if (chaine == null) {
/*  44 */       return "0";
/*     */     }
/*  46 */     int taille = chaine.length(), j = taille;
/*  47 */     String result = "";
/*  48 */     int i = 0;
/*  49 */     while (i < taille) {
/*  50 */       result = result + chaine.charAt(i);
/*  51 */       i++;
/*  52 */       j--;
/*  53 */       if (j > 0 && j % 3 == 0) {
/*  54 */         result = result + ' ';
/*     */       }
/*     */     } 
/*     */     
/*  58 */     return result;
/*     */   }
/*     */   
/*     */   public static String formaterStringMoney(Integer valeur) {
/*  62 */     String chaine = Integer.toString(valeur.intValue());
/*  63 */     if (chaine == null) {
/*  64 */       return "0";
/*     */     }
/*  66 */     int taille = chaine.length(), j = taille;
/*  67 */     String result = "";
/*  68 */     int i = 0;
/*  69 */     while (i < taille) {
/*  70 */       result = result + chaine.charAt(i);
/*  71 */       i++;
/*  72 */       j--;
/*  73 */       if (j > 0 && j % 3 == 0) {
/*  74 */         result = result + ' ';
/*     */       }
/*     */     } 
/*     */     
/*  78 */     return result;
/*     */   }
/*     */   
/*     */   public static String formaterStringMoney(String valeur) {
/*  82 */     String chaine = valeur;
/*  83 */     if (chaine == null) {
/*  84 */       return null;
/*     */     }
/*  86 */     int taille = chaine.length(), j = taille;
/*  87 */     String result = "";
/*  88 */     int i = 0;
/*  89 */     while (i < taille) {
/*  90 */       result = result + chaine.charAt(i);
/*  91 */       i++;
/*  92 */       j--;
/*  93 */       if (j > 0 && j % 3 == 0) {
/*  94 */         result = result + ' ';
/*     */       }
/*     */     } 
/*     */     
/*  98 */     return result;
/*     */   }
/*     */   
/*     */   public static String formaterStringMoney(Double val) {
/* 102 */     String result = "";
/*     */     try {
/* 104 */       String pEntiere = partieEntiere(val);
/* 105 */       String pDec = partieDecimale(val);
/* 106 */       String chaine = pEntiere;
/* 107 */       int taille = chaine.length(), j = taille;
/*     */       
/* 109 */       int i = 0;
/* 110 */       while (i < taille) {
/* 111 */         result = result + chaine.charAt(i);
/* 112 */         i++;
/* 113 */         j--;
/* 114 */         if (j > 0 && j % 3 == 0) {
/* 115 */           result = result + ' ';
/*     */         }
/*     */       } 
/* 118 */       if (pDec != null) {
/* 119 */         result = result + "." + pDec;
/*     */       }
/*     */     }
/* 122 */     catch (Exception e) {
/* 123 */       result = "0";
/* 124 */       e.printStackTrace();
/*     */     } 
/* 126 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String partieDecimale(Double nombre) {
/* 131 */     return partieDecimale(nombre.toString());
/*     */   }
/*     */   
/*     */   private static String partieDecimale(String nombre) {
/* 135 */     String result = "";
/* 136 */     int taille = nombre.length();
/* 137 */     boolean copie = false;
/* 138 */     for (int i = 0; i < taille; i++) {
/* 139 */       if (copie) {
/* 140 */         result = result + nombre.charAt(i);
/* 141 */       } else if (nombre.charAt(i) == '.') {
/* 142 */         copie = true;
/*     */       } 
/*     */     } 
/* 145 */     if (result.equals("0")) {
/* 146 */       return null;
/*     */     }
/* 148 */     return result;
/*     */   }
/*     */   
/*     */   private static String partieEntiere(Double nombre) {
/* 152 */     Integer tmp = Integer.valueOf(nombre.intValue());
/* 153 */     return tmp.toString();
/*     */   }
/*     */   
/*     */   public static String formatPrenomMaj(String prenom) {
/* 157 */     if (prenom.isEmpty()) {
/* 158 */       return " ";
/*     */     }
/* 160 */     char prenLettre = '0';
/*     */ 
/*     */ 
/*     */     
/* 164 */     prenLettre = prenom.charAt(0);
/*     */     
/* 166 */     String leReste = prenom.substring(1, prenom.length());
/*     */     
/* 168 */     String lettre1 = String.valueOf(prenLettre);
/*     */     
/* 170 */     leReste = leReste.toLowerCase();
/*     */     
/* 172 */     return lettre1.toUpperCase() + leReste;
/*     */   }
/*     */   
/*     */   public static double arrondiNDecimales(double x, int n) {
/* 176 */     double pow = Math.pow(10.0D, n);
/* 177 */     return Math.floor(x * pow) / pow;
/*     */   }
/*     */   
/*     */   public static Date addDayToDate(Date date, int nbre) {
/* 181 */     DateTime date_time = new DateTime("" + (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate());
/* 182 */     date_time.plusDays(nbre);
/* 183 */     return date_time.toDate();
/*     */   }
/*     */   
/*     */   public static Operations saveOperation(String action, Compte compte, OperationsFacadeLocal operationFacadeLocal) {
/* 187 */     Operations operation = new Operations();
/*     */     
/* 189 */     try { operation.setIdOperations(operationFacadeLocal.nextId());
/* 190 */       operation.setLibelle(action);
/* 191 */       operation.setDateOpration(new Date());
/* 192 */       operation.setHeureOpration(new Date());
/* 193 */       operation.setIdCompte(compte);
/* 194 */       operationFacadeLocal.create(operation);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 199 */       return operation; } catch (Exception e) { return operation; } finally { Exception exception = null; }
/*     */   
/*     */   }
/*     */   
/*     */   public static String getExtension(String nomFichier) {
/* 204 */     int taille = nomFichier.length();
/* 205 */     String extension = "";
/* 206 */     for (int i = 0; i < taille; i++) {
/* 207 */       if (nomFichier.charAt(i) == '.') {
/* 208 */         extension = "";
/*     */       } else {
/* 210 */         extension = extension + nomFichier.charAt(i);
/*     */       } 
/*     */     } 
/* 213 */     return extension;
/*     */   }
/*     */   
/*     */   public static boolean estFichierImage(String nom) {
/* 217 */     String extension = getExtension(nom);
/* 218 */     if (extension == null || extension.equals("")) {
/* 219 */       return false;
/*     */     }
/* 221 */     String ext = extension.toUpperCase();
/* 222 */     if (ext.equals("PDF")) {
/* 223 */       return true;
/*     */     }
/* 225 */     if (ext.equals("JPG")) {
/* 226 */       return true;
/*     */     }
/* 228 */     if (ext.equals("JPEG")) {
/* 229 */       return true;
/*     */     }
/* 231 */     if (ext.equals("GIF")) {
/* 232 */       return true;
/*     */     }
/* 234 */     if (ext.equals("PNG")) {
/* 235 */       return true;
/*     */     }
/* 237 */     if (ext.equals("BMP")) {
/* 238 */       return true;
/*     */     }
/* 240 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isAccess(Long idmenu) {
/* 244 */     if (SessionMBean.getUserAccessId().isEmpty()) {
/* 245 */       return false;
/*     */     }
/* 247 */     if (SessionMBean.getUserAccessId().contains(Long.valueOf(1L))) {
/* 248 */       return true;
/*     */     }
/* 250 */     if (SessionMBean.getUserAccessId().contains(idmenu)) {
/* 251 */       return true;
/*     */     }
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Connection connexionDB(String driverClassName, String chaineConnexion, String user, String password) throws SQLException {
/* 260 */     Connection connection = null;
/*     */     try {
/* 262 */       Class.forName(driverClassName);
/* 263 */       connection = DriverManager.getConnection(chaineConnexion, user, password);
/* 264 */       System.out.println("Connecion réussie");
/* 265 */       return connection;
/* 266 */     } catch (ClassNotFoundException ex) {
/* 267 */       Logger.getLogger(SocieteController.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 268 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String generateBCNumero(BoncommandeFacadeLocal bfl, int idBudget, String annee) {
/* 281 */     String resultat = "BC" + annee + "";
/* 282 */     long nextBonBC = bfl.nextIdBC(idBudget, SessionMBean.getInstitution().getIdinstitution().longValue());
/* 283 */     nextBonBC++;
/* 284 */     if (nextBonBC >= 1L && nextBonBC < 10L) {
/* 285 */       resultat = resultat + "0000" + nextBonBC;
/* 286 */     } else if (nextBonBC >= 10L && nextBonBC < 100L) {
/* 287 */       resultat = resultat + "000" + nextBonBC;
/* 288 */     } else if (nextBonBC >= 100L && nextBonBC < 1000L) {
/* 289 */       resultat = resultat + "00" + nextBonBC;
/* 290 */     } else if (nextBonBC >= 1000L && nextBonBC < 10000L) {
/* 291 */       resultat = resultat + "0" + nextBonBC;
/* 292 */     } else if (nextBonBC >= 100000L && nextBonBC < 1000000L) {
/* 293 */       resultat = resultat + "" + nextBonBC;
/*     */     } 
/* 295 */     return resultat;
/*     */   }
/*     */   
/*     */   public static String generateLCNumero(BoncommandeFacadeLocal bfl, int idBudget, String annee) {
/* 299 */     String resultat = "LC" + annee + "";
/* 300 */     long nextBonBC = bfl.nextIdLC(idBudget);
/* 301 */     nextBonBC++;
/* 302 */     if (nextBonBC >= 1L && nextBonBC < 10L) {
/* 303 */       resultat = resultat + "0000" + nextBonBC;
/* 304 */     } else if (nextBonBC >= 10L && nextBonBC < 100L) {
/* 305 */       resultat = resultat + "000" + nextBonBC;
/* 306 */     } else if (nextBonBC >= 100L && nextBonBC < 1000L) {
/* 307 */       resultat = resultat + "00" + nextBonBC;
/* 308 */     } else if (nextBonBC >= 1000L && nextBonBC < 10000L) {
/* 309 */       resultat = resultat + "0" + nextBonBC;
/* 310 */     } else if (nextBonBC >= 100000L && nextBonBC < 1000000L) {
/* 311 */       resultat = resultat + "" + nextBonBC;
/*     */     } 
/* 313 */     return resultat;
/*     */   }
/*     */   
/*     */   public static String generateDENumero(BoncommandeFacadeLocal bfl, int idBudget, String annee) {
/* 317 */     String resultat = "DE" + annee + "";
/* 318 */     long nextBonBC = bfl.nextIdDE(idBudget);
/* 319 */     nextBonBC++;
/* 320 */     if (nextBonBC >= 1L && nextBonBC < 10L) {
/* 321 */       resultat = resultat + "0000" + nextBonBC;
/* 322 */     } else if (nextBonBC >= 10L && nextBonBC < 100L) {
/* 323 */       resultat = resultat + "000" + nextBonBC;
/* 324 */     } else if (nextBonBC >= 100L && nextBonBC < 1000L) {
/* 325 */       resultat = resultat + "00" + nextBonBC;
/* 326 */     } else if (nextBonBC >= 1000L && nextBonBC < 10000L) {
/* 327 */       resultat = resultat + "0" + nextBonBC;
/* 328 */     } else if (nextBonBC >= 100000L && nextBonBC < 1000000L) {
/* 329 */       resultat = resultat + "" + nextBonBC;
/*     */     } 
/* 331 */     return resultat;
/*     */   }
/*     */   
/*     */   public static String generateSANumero(BoncommandeFacadeLocal bfl, int idBudget, String annee) {
/* 335 */     String resultat = "SA" + annee + "";
/* 336 */     long nextBonBC = bfl.nextIdSA(idBudget);
/* 337 */     nextBonBC++;
/* 338 */     if (nextBonBC >= 1L && nextBonBC < 10L) {
/* 339 */       resultat = resultat + "0000" + nextBonBC;
/* 340 */     } else if (nextBonBC >= 10L && nextBonBC < 100L) {
/* 341 */       resultat = resultat + "000" + nextBonBC;
/* 342 */     } else if (nextBonBC >= 100L && nextBonBC < 1000L) {
/* 343 */       resultat = resultat + "00" + nextBonBC;
/* 344 */     } else if (nextBonBC >= 1000L && nextBonBC < 10000L) {
/* 345 */       resultat = resultat + "0" + nextBonBC;
/* 346 */     } else if (nextBonBC >= 100000L && nextBonBC < 1000000L) {
/* 347 */       resultat = resultat + "" + nextBonBC;
/*     */     } 
/* 349 */     return resultat;
/*     */   }
/*     */   
/*     */   public static String generateOPNumero(OrdrePayementFacadeLocal opfl, int idBudget, String annee) {
/* 353 */     String resultat = "OP" + annee + "";
/* 354 */     long nextOp = opfl.nextIdOp(idBudget);
/* 355 */     nextOp++;
/* 356 */     if (nextOp >= 1L && nextOp < 10L) {
/* 357 */       resultat = resultat + "0000" + nextOp;
/* 358 */     } else if (nextOp >= 10L && nextOp < 100L) {
/* 359 */       resultat = resultat + "000" + nextOp;
/* 360 */     } else if (nextOp >= 100L && nextOp < 1000L) {
/* 361 */       resultat = resultat + "00" + nextOp;
/* 362 */     } else if (nextOp >= 1000L && nextOp < 10000L) {
/* 363 */       resultat = resultat + "0" + nextOp;
/* 364 */     } else if (nextOp >= 100000L && nextOp < 1000000L) {
/* 365 */       resultat = resultat + "" + nextOp;
/*     */     } 
/* 367 */     return resultat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\\\utilitaire\Utilitaires.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */