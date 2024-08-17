/*    */ package controllers.util;
/*    */ 
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Session
/*    */ {
/*    */   public static HttpSession getSession() {
/* 19 */     return (HttpSession)FacesContext.getCurrentInstance()
/* 20 */       .getExternalContext().getSession(false);
/*    */   }
/*    */   
/*    */   public static HttpServletRequest getRequest() {
/* 24 */     return (HttpServletRequest)FacesContext.getCurrentInstance()
/* 25 */       .getExternalContext().getRequest();
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getUserName() {
/* 30 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
/* 31 */     return session.getAttribute("login").toString();
/*    */   }
/*    */   
/*    */   public static String getUserId() {
/* 35 */     HttpSession session = getSession();
/* 36 */     if (session != null) {
/* 37 */       return (String)session.getAttribute("compteid");
/*    */     }
/* 39 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controller\\util\Session.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */