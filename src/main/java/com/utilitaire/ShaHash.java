/*    */ package utilitaire;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.util.Base64;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShaHash
/*    */ {
/*    */   private String plaintext;
/*    */   private String hash;
/*    */   
/*    */   public synchronized String hash(String plaintext) {
/* 22 */     this.plaintext = plaintext;
/* 23 */     MessageDigest md = null;
/*    */     try {
/* 25 */       md = MessageDigest.getInstance("SHA");
/* 26 */     } catch (NoSuchAlgorithmException e) {
/* 27 */       e.printStackTrace();
/*    */     } 
/*    */     try {
/* 30 */       md.update(this.plaintext.getBytes("UTF-8"));
/* 31 */     } catch (UnsupportedEncodingException e) {
/* 32 */       e.printStackTrace();
/*    */     } 
/* 34 */     byte[] raw = md.digest();
/*    */ 
/*    */     
/* 37 */     this.hash = Base64.getMimeEncoder().encodeToString(raw);
/* 38 */     return this.hash;
/*    */   }
/*    */   
/*    */   public String getPlaintext() {
/* 42 */     return this.plaintext;
/*    */   }
/*    */   
/*    */   public void setPlaintext(String plaintext) {
/* 46 */     this.plaintext = plaintext;
/*    */   }
/*    */   
/*    */   public String getHash() {
/* 50 */     return this.hash;
/*    */   }
/*    */   
/*    */   public void setHash(String hash) {
/* 54 */     this.hash = hash;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\\\utilitaire\ShaHash.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */