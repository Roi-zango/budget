/*    */ package sessions;
/*    */ 
/*    */ import entities.Revueactivite;
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
/*    */ public class RevueactiviteFacade
/*    */   extends AbstractFacade<Revueactivite>
/*    */   implements RevueactiviteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RevueactiviteFacade() {
/* 28 */     super(Revueactivite.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueactiviteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */