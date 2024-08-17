/*    */ package sessions;
/*    */ 
/*    */ import entities.Revuefait;
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
/*    */ public class RevuefaitFacade
/*    */   extends AbstractFacade<Revuefait>
/*    */   implements RevuefaitFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RevuefaitFacade() {
/* 28 */     super(Revuefait.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevuefaitFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */