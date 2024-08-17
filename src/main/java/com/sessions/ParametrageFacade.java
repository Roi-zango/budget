/*    */ package sessions;
/*    */ 
/*    */ import entities.Parametrage;
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
/*    */ 
/*    */ @Stateless
/*    */ public class ParametrageFacade
/*    */   extends AbstractFacade<Parametrage>
/*    */   implements ParametrageFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 25 */     return this.em;
/*    */   }
/*    */   
/*    */   public ParametrageFacade() {
/* 29 */     super(Parametrage.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ParametrageFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */