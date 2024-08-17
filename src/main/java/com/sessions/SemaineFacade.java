/*    */ package sessions;
/*    */ 
/*    */ import entities.Semaine;
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
/*    */ public class SemaineFacade
/*    */   extends AbstractFacade<Semaine>
/*    */   implements SemaineFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public SemaineFacade() {
/* 28 */     super(Semaine.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SemaineFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */