/*    */ package sessions;
/*    */ 
/*    */ import entities.Privilege;
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
/*    */ public class PrivilegeFacade
/*    */   extends AbstractFacade<Privilege>
/*    */   implements PrivilegeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public PrivilegeFacade() {
/* 28 */     super(Privilege.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PrivilegeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */