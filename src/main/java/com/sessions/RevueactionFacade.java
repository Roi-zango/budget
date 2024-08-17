/*    */ package sessions;
/*    */ 
/*    */ import entities.Revueaction;
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
/*    */ public class RevueactionFacade
/*    */   extends AbstractFacade<Revueaction>
/*    */   implements RevueactionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RevueactionFacade() {
/* 28 */     super(Revueaction.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueactionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */