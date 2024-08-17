/*    */ package sessions;
/*    */ 
/*    */ import entities.Rang;
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
/*    */ public class RangFacade
/*    */   extends AbstractFacade<Rang>
/*    */   implements RangFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RangFacade() {
/* 28 */     super(Rang.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RangFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */