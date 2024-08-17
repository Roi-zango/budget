/*    */ package sessions;
/*    */ 
/*    */ import entities.Extrant;
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
/*    */ public class ExtrantFacade
/*    */   extends AbstractFacade<Extrant>
/*    */   implements ExtrantFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public ExtrantFacade() {
/* 28 */     super(Extrant.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExtrantFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */