/*    */ package sessions;
/*    */ 
/*    */ import entities.Reglage;
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
/*    */ public class ReglageFacade
/*    */   extends AbstractFacade<Reglage>
/*    */   implements ReglageFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public ReglageFacade() {
/* 28 */     super(Reglage.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ReglageFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */