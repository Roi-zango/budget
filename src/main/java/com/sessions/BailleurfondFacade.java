/*    */ package sessions;
/*    */ 
/*    */ import entities.Bailleurfond;
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
/*    */ public class BailleurfondFacade
/*    */   extends AbstractFacade<Bailleurfond>
/*    */   implements BailleurfondFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public BailleurfondFacade() {
/* 28 */     super(Bailleurfond.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BailleurfondFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */