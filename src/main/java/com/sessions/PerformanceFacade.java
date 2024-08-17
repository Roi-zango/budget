/*    */ package sessions;
/*    */ 
/*    */ import entities.Performance;
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
/*    */ public class PerformanceFacade
/*    */   extends AbstractFacade<Performance>
/*    */   implements PerformanceFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public PerformanceFacade() {
/* 28 */     super(Performance.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PerformanceFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */