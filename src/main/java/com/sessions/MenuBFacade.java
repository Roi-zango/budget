/*    */ package sessions;
/*    */ 
/*    */ import entities.MenuB;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Stateless
/*    */ public class MenuBFacade
/*    */   extends AbstractFacade<MenuB>
/*    */   implements MenuBFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public MenuBFacade() {
/* 28 */     super(MenuB.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MenuBFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */