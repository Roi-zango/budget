/*     */ package utilitaire;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Convert
/*     */ {
/*     */   private static String result;
/*     */   private static String frac;
/*     */   private static String tranche;
/*     */   private static String dec;
/*     */   private static String cent;
/*     */   private static String un;
/*     */   private static String dix;
/*     */   private static int rang;
/*     */   private static int virgule;
/*     */   private static int lg;
/*     */   
/*     */   private static String traiter(String nombre) {
/*  24 */     nombre = nombre.replace(',', '.');
/*  25 */     nombre = nombre.replace(" ", "");
/*  26 */     if (nombre.charAt(0) == '-') {
/*  27 */       nombre = nombre.substring(1);
/*     */     }
/*  29 */     virgule = nombre.indexOf('.');
/*  30 */     frac = "";
/*  31 */     if (virgule > -1) {
/*  32 */       frac = nombre.substring(virgule + 1, (nombre.length() - virgule < 3) ? nombre.length() : (virgule + 3));
/*  33 */       nombre = nombre.substring(0, virgule);
/*     */     } 
/*  35 */     while (frac.length() < 2) {
/*  36 */       frac += "0";
/*     */     }
/*  38 */     if (nombre.length() > 18) {
/*  39 */       nombre = "#Trop grand";
/*     */     } else {
/*     */       try {
/*  42 */         new BigDecimal(nombre + "." + frac);
/*  43 */         rang = (nombre.length() + 2) / 3;
/*  44 */       } catch (Exception e) {
/*  45 */         nombre = "#Erreur";
/*     */       } 
/*     */     } 
/*  48 */     return nombre;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String FR(String nombre, String devise, String sou) {
/*  53 */     String[] n1 = { "", " Un", " Deux", " Trois", " Quatre", " Cinq", " Six", " Sept", " Huit", " Neuf", " Dix", " Onze", " Douze", " Treize", " Quatorze", " Quinze", " Seize", " Dix-sept", " Dix-huit", " Dix-neuf" };
/*  54 */     String[] n70 = { " Soixante et Onze", " Soixante-Douze", " Soixante-Treize", " Soixante-Quatorze", " Soixante-Quinze", " Soixante-Seize", " Soixante-Dix-sept", " Soixante-Dix-huit", " Soixante-Dix-neuf" };
/*  55 */     String[] n90 = { " Quatre-vingt-Onze", " Quatre-vingt-Douze", " Quatre-vingt-Treize", " Quatre-vingt-Quatorze", " Quatre-vingt-Quinze", " Quatre-vingt-Seize", " Quatre-vingt-Dix-sept", " Quatre-vingt-Dix-huit", " Quatre-vingt-Dix-neuf" };
/*  56 */     String[] n10 = { "", " Dix", " Vingt", " Trente", " Quarante", " Cinquante", " Soixante", " Soixante-Dix", " Quatre-vingt", " Quatre-vingt-Dix" };
/*  57 */     String[] n1000 = { "", " Mille", " Million", " Milliard", " Billion", " Billiard" };
/*  58 */     nombre = traiter(nombre);
/*  59 */     if (nombre.equals("#Erreur") || nombre.equals("#Trop grand")) {
/*  60 */       result = nombre;
/*     */     } else {
/*  62 */       result = "";
/*  63 */       while (rang > 0) {
/*  64 */         if (result == "") {
/*  65 */           tranche = nombre.substring(0, (nombre.length() + 2) % 3 + 1);
/*  66 */           while (tranche.length() < 3) {
/*  67 */             tranche = "0" + tranche;
/*     */           }
/*     */         } else {
/*  70 */           tranche = nombre.substring(nombre.length() - rang * 3, nombre.length() - (rang - 1) * 3);
/*     */         } 
/*  72 */         dec = tranche;
/*  73 */         dec = dec.substring(1, 3);
/*  74 */         if (dec.length() == 1) {
/*  75 */           un = dec;
/*  76 */           dix = "0";
/*     */         } else {
/*  78 */           un = dec.substring(1);
/*  79 */           dix = dec.substring(0, 1);
/*     */         } 
/*  81 */         cent = tranche;
/*  82 */         cent = cent.substring(0, 1);
/*  83 */         switch (Integer.parseInt(cent)) {
/*     */           case 0:
/*     */             break;
/*     */           case 1:
/*  87 */             result += " Cent";
/*     */             break;
/*     */           default:
/*  90 */             result += n1[Integer.parseInt(cent)] + " Cent"; break;
/*     */         } 
/*  92 */         switch (Integer.parseInt(dec)) {
/*     */           case 0:
/*  94 */             if (!cent.equals("0")) {
/*  95 */               result += n1000[rang - 1];
/*     */             }
/*     */             break;
/*     */           case 1:
/*     */           case 2:
/*     */           case 3:
/*     */           case 4:
/*     */           case 5:
/*     */           case 6:
/*     */           case 7:
/*     */           case 8:
/*     */           case 9:
/*     */           case 10:
/*     */           case 11:
/*     */           case 12:
/*     */           case 13:
/*     */           case 14:
/*     */           case 15:
/*     */           case 16:
/*     */           case 17:
/*     */           case 18:
/*     */           case 19:
/* 117 */             result += n1[Integer.parseInt(dec)] + n1000[rang - 1];
/*     */             break;
/*     */           case 71:
/*     */           case 72:
/*     */           case 73:
/*     */           case 74:
/*     */           case 75:
/*     */           case 76:
/*     */           case 77:
/*     */           case 78:
/*     */           case 79:
/* 128 */             result += n70[Integer.parseInt(un) - 1] + n1000[rang - 1];
/*     */             break;
/*     */           case 91:
/*     */           case 92:
/*     */           case 93:
/*     */           case 94:
/*     */           case 95:
/*     */           case 96:
/*     */           case 97:
/*     */           case 98:
/*     */           case 99:
/* 139 */             result += n90[Integer.parseInt(un) - 1] + n1000[rang - 1];
/*     */             break;
/*     */           default:
/* 142 */             if (!dix.equals("0") && un.equals("1")) {
/* 143 */               result += n10[Integer.parseInt(dix)] + " et Un" + n1000[rang - 1]; break;
/*     */             } 
/* 145 */             result += n10[Integer.parseInt(dix)] + n1[Integer.parseInt(un)] + n1000[rang - 1];
/*     */             break;
/*     */         } 
/* 148 */         rang--;
/*     */       } 
/* 150 */       if (result.equals("")) {
/*     */         
/* 152 */         result = " Zero " + devise;
/*     */       } else {
/*     */         
/* 155 */         result += " " + devise;
/*     */       } 
/* 157 */       un = Character.toString(frac.charAt(1));
/* 158 */       dix = Character.toString(frac.charAt(0));
/* 159 */       switch (Integer.parseInt(frac)) {
/*     */         case 0:
/*     */           break;
/*     */         
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*     */         case 5:
/*     */         case 6:
/*     */         case 7:
/*     */         case 8:
/*     */         case 9:
/*     */         case 10:
/*     */         case 11:
/*     */         case 12:
/*     */         case 13:
/*     */         case 14:
/*     */         case 15:
/*     */         case 16:
/*     */         case 17:
/*     */         case 18:
/*     */         case 19:
/* 182 */           result += n1[Integer.parseInt(frac)] + " " + sou;
/*     */           break;
/*     */         case 71:
/*     */         case 72:
/*     */         case 73:
/*     */         case 74:
/*     */         case 75:
/*     */         case 76:
/*     */         case 77:
/*     */         case 78:
/*     */         case 79:
/* 193 */           result += n70[Integer.parseInt(un) - 1] + " " + sou;
/*     */           break;
/*     */         case 91:
/*     */         case 92:
/*     */         case 93:
/*     */         case 94:
/*     */         case 95:
/*     */         case 96:
/*     */         case 97:
/*     */         case 98:
/*     */         case 99:
/* 204 */           result += n90[Integer.parseInt(un) - 1] + " " + sou;
/*     */           break;
/*     */         default:
/* 207 */           if (!dix.equals("0") && un.equals("1")) {
/* 208 */             result += n10[Integer.parseInt(dix)] + " et Un " + sou; break;
/*     */           } 
/* 210 */           result += n10[Integer.parseInt(dix)] + n1[Integer.parseInt(un)] + " " + sou;
/*     */           break;
/*     */       } 
/* 213 */       result = result.substring(1);
/*     */     } 
/* 215 */     return result;
/*     */   }
/*     */   
/*     */   public static String FR(String nombre) {
/* 219 */     return FR(nombre, "Franc cfa", "Centimes");
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\\\utilitaire\Convert.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */