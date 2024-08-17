/*    */ package sessions;
/*    */ 
/*    */ import entities.Revuedifficilte;
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
/*    */ public class RevuedifficilteFacade
/*    */   extends AbstractFacade<Revuedifficilte>
/*    */   implements RevuedifficilteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RevuedifficilteFacade() {
/* 28 */     super(Revuedifficilte.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevuedifficilteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */