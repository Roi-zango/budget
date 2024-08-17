/*    */ package sessions;
/*    */ 
/*    */ import entities.Revueperformance;
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
/*    */ public class RevueperformanceFacade
/*    */   extends AbstractFacade<Revueperformance>
/*    */   implements RevueperformanceFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RevueperformanceFacade() {
/* 28 */     super(Revueperformance.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueperformanceFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */