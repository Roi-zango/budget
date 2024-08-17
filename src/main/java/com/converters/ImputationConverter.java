/*    */ package converters;
/*    */ 
/*    */ import controllers.util.JsfUtil;
/*    */ import entities.Imputation;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.EJB;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ import sessions.ImputationFacadeLocal;
/*    */ 
/*    */ @FacesConverter("imputationConverter")
/*    */ public class ImputationConverter
/*    */   implements Converter
/*    */ {
/*    */   @EJB
/*    */   private ImputationFacadeLocal ejbFacade;
/*    */   
/*    */   public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
/* 22 */     if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
/* 23 */       return null;
/*    */     }
/* 25 */     return this.ejbFacade.find(getKey(value));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   Long getKey(String value) {
/* 31 */     Long key = Long.valueOf(value);
/* 32 */     return key;
/*    */   }
/*    */   
/*    */   String getStringKey(Long value) {
/* 36 */     StringBuffer sb = new StringBuffer();
/* 37 */     sb.append(value);
/* 38 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
/* 43 */     if (object == null || (object instanceof String && ((String)object)
/* 44 */       .length() == 0)) {
/* 45 */       return null;
/*    */     }
/* 47 */     if (object instanceof Imputation) {
/* 48 */       Imputation o = (Imputation)object;
/* 49 */       return getStringKey(o.getIdimputation());
/*    */     } 
/* 51 */     Logger.getLogger(getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[] { object, object.getClass().getName(), Imputation.class.getName() });
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\converters\ImputationConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */