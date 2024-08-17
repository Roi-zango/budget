/*    */ package sessions;
/*    */ 
/*    */ import entities.Methodeeval;
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
/*    */ public class MethodeevalFacade
/*    */   extends AbstractFacade<Methodeeval>
/*    */   implements MethodeevalFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public MethodeevalFacade() {
/* 28 */     super(Methodeeval.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MethodeevalFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */