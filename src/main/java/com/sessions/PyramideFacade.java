/*    */ package sessions;
/*    */ 
/*    */ import entities.Pyramide;
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
/*    */ public class PyramideFacade
/*    */   extends AbstractFacade<Pyramide>
/*    */   implements PyramideFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public PyramideFacade() {
/* 28 */     super(Pyramide.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PyramideFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */