/*    */ package sessions;
/*    */ 
/*    */ import entities.Quartier;
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
/*    */ public class QuartierFacade
/*    */   extends AbstractFacade<Quartier>
/*    */   implements QuartierFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public QuartierFacade() {
/* 28 */     super(Quartier.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\QuartierFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */