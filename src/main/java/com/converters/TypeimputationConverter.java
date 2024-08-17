/*    */ package converters;
/*    */ 
/*    */ import controllers.util.JsfUtil;
/*    */ import entities.MenuB;
/*    */ import entities.Typeimputation;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.EJB;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ import sessions.TypeimputationFacadeLocal;
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
/*    */ @FacesConverter("typeimputationConverter")
/*    */ public class TypeimputationConverter
/*    */   implements Converter
/*    */ {
/*    */   @EJB
/*    */   private TypeimputationFacadeLocal ejbFacade;
/*    */   
/*    */   public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
/* 32 */     if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
/* 33 */       return null;
/*    */     }
/* 35 */     return this.ejbFacade.find(getKey(value));
/*    */   }
/*    */ 
/*    */   
/*    */   Integer getKey(String value) {
/* 40 */     Integer key = Integer.valueOf(value);
/* 41 */     return key;
/*    */   }
/*    */   
/*    */   String getStringKey(Integer value) {
/* 45 */     return "" + value;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
/* 50 */     if (object == null || (object instanceof String && ((String)object)
/* 51 */       .length() == 0)) {
/* 52 */       return null;
/*    */     }
/* 54 */     if (object instanceof Typeimputation) {
/* 55 */       Typeimputation ti = (Typeimputation)object;
/* 56 */       return getStringKey(ti.getIdtypeimputation());
/*    */     } 
/* 58 */     Logger.getLogger(getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[] { object, object.getClass().getName(), MenuB.class.getName() });
/* 59 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\converters\TypeimputationConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */