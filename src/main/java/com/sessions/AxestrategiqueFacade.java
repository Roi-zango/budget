/*    */ package sessions;
/*    */ 
/*    */ import entities.Axestrategique;
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
/*    */ public class AxestrategiqueFacade
/*    */   extends AbstractFacade<Axestrategique>
/*    */   implements AxestrategiqueFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public AxestrategiqueFacade() {
/* 28 */     super(Axestrategique.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AxestrategiqueFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */