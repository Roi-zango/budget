/*    */ package converters;
/*    */ 
/*    */ import controllers.util.JsfUtil;
/*    */ import entities.Rubrique;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.ejb.EJB;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ import sessions.RubriqueFacadeLocal;
/*    */ 
/*    */ @FacesConverter("rubriqueConverter")
/*    */ public class RubriqueConverter
/*    */   implements Converter
/*    */ {
/*    */   @EJB
/*    */   private RubriqueFacadeLocal ejbFacade;
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
/* 35 */     StringBuffer sb = new StringBuffer();
/* 36 */     sb.append(value);
/* 37 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
/* 42 */     if (object == null || (object instanceof String && ((String)object)
/* 43 */       .length() == 0)) {
/* 44 */       return null;
/*    */     }
/* 46 */     if (object instanceof Rubrique) {
/* 47 */       Rubrique o = (Rubrique)object;
/* 48 */       return getStringKey(o.getIdrubrique());
/*    */     } 
/* 50 */     Logger.getLogger(getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[] { object, object.getClass().getName(), Rubrique.class.getName() });
/* 51 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\converters\RubriqueConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */