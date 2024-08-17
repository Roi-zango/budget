/*    */ package sessions;
/*    */ 
/*    */ import entities.StatutMatrimonial;
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
/*    */ public class StatutMatrimonialFacade
/*    */   extends AbstractFacade<StatutMatrimonial>
/*    */   implements StatutMatrimonialFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public StatutMatrimonialFacade() {
/* 28 */     super(StatutMatrimonial.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StatutMatrimonialFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */