/*    */ package controllers.util;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.component.UIInput;
/*    */ import javax.faces.component.UISelectItem;
/*    */ import javax.faces.context.FacesContext;
/*    */ 
/*    */ public class JsfUtil
/*    */ {
/*    */   public static void addErrorMessage(Exception ex, String defaultMsg) {
/* 14 */     String msg = ex.getLocalizedMessage();
/* 15 */     if (msg != null && msg.length() > 0) {
/* 16 */       addErrorMessage(msg);
/*    */     } else {
/* 18 */       addErrorMessage(defaultMsg);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void addErrorMessages(List<String> messages) {
/* 23 */     for (String message : messages) {
/* 24 */       addErrorMessage(message);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void addErrorMessage(String msg) {
/* 29 */     FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
/* 30 */     FacesContext.getCurrentInstance().addMessage(null, facesMsg);
/* 31 */     FacesContext.getCurrentInstance().validationFailed();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addSuccessMessage(String msg) {
/* 36 */     FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
/* 37 */     FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
/*    */   }
/*    */   
/*    */   public static void addWarningMessage(String msg) {
/* 41 */     FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
/* 42 */     FacesContext.getCurrentInstance().addMessage(null, facesMsg);
/*    */   }
/*    */   
/*    */   public static void addFatalErrorMessage(String msg) {
/* 46 */     FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
/* 47 */     FacesContext.getCurrentInstance().addMessage(null, facesMsg);
/*    */   }
/*    */   
/*    */   public static Throwable getRootCause(Throwable cause) {
/* 51 */     if (cause != null) {
/* 52 */       Throwable source = cause.getCause();
/* 53 */       if (source != null) {
/* 54 */         return getRootCause(source);
/*    */       }
/* 56 */       return cause;
/*    */     } 
/*    */     
/* 59 */     return null;
/*    */   }
/*    */   
/*    */   public static boolean isValidationFailed() {
/* 63 */     return FacesContext.getCurrentInstance().isValidationFailed();
/*    */   }
/*    */   
/*    */   public static boolean isDummySelectItem(UIComponent component, String value) {
/* 67 */     for (UIComponent children : component.getChildren()) {
/* 68 */       if (children instanceof UISelectItem) {
/* 69 */         UISelectItem item = (UISelectItem)children;
/* 70 */         if (item.getItemValue() == null && item.getItemLabel().equals(value)) {
/* 71 */           return true;
/*    */         }
/*    */         break;
/*    */       } 
/*    */     } 
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public static String getComponentMessages(String clientComponent, String defaultMessage) {
/* 80 */     FacesContext fc = FacesContext.getCurrentInstance();
/* 81 */     UIComponent component = UIComponent.getCurrentComponent(fc).findComponent(clientComponent);
/* 82 */     if (component instanceof UIInput) {
/* 83 */       UIInput inputComponent = (UIInput)component;
/* 84 */       if (inputComponent.isValid()) {
/* 85 */         return defaultMessage;
/*    */       }
/* 87 */       Iterator<FacesMessage> iter = fc.getMessages(inputComponent.getClientId());
/* 88 */       if (iter.hasNext()) {
/* 89 */         return ((FacesMessage)iter.next()).getDetail();
/*    */       }
/*    */     } 
/*    */     
/* 93 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controller\\util\JsfUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */