/*    */ package converters;
/*    */ 
/*    */ import controllers.util.JsfUtil;
/*    */ import entities.MenuB;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.EJB;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ import sessions.MenuBFacadeLocal;
/*    */ 
/*    */ @FacesConverter("menuConverter")
/*    */ public class menuConverter
/*    */   implements Converter
/*    */ {
/*    */   @EJB
/*    */   private MenuBFacadeLocal ejbFacade;
/*    */   
/*    */   public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
/* 22 */     if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
/* 23 */       return null;
/*    */     }
/* 25 */     return this.ejbFacade.find(getKey(value));
/*    */   }
/*    */ 
/*    */   
/*    */   Integer getKey(String value) {
/* 30 */     Integer key = Integer.valueOf(value);
/* 31 */     return key;
/*    */   }
/*    */   
/*    */   String getStringKey(Integer value) {
/* 35 */     return "" + value;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
/* 40 */     if (object == null || (object instanceof String && ((String)object)
/* 41 */       .length() == 0)) {
/* 42 */       return null;
/*    */     }
/* 44 */     if (object instanceof MenuB) {
/* 45 */       MenuB m = (MenuB)object;
/* 46 */       return getStringKey(m.getIdmenuB());
/*    */     } 
/* 48 */     Logger.getLogger(getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[] { object, object.getClass().getName(), MenuB.class.getName() });
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\converters\menuConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */