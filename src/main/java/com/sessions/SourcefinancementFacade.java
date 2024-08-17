/*    */ package sessions;
/*    */ 
/*    */ import entities.Sourcefinancement;
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
/*    */ public class SourcefinancementFacade
/*    */   extends AbstractFacade<Sourcefinancement>
/*    */   implements SourcefinancementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public SourcefinancementFacade() {
/* 28 */     super(Sourcefinancement.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SourcefinancementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */