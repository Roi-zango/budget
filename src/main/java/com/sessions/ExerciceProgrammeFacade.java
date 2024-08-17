/*    */ package sessions;
/*    */ 
/*    */ import entities.ExerciceProgramme;
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
/*    */ public class ExerciceProgrammeFacade
/*    */   extends AbstractFacade<ExerciceProgramme>
/*    */   implements ExerciceProgrammeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public ExerciceProgrammeFacade() {
/* 28 */     super(ExerciceProgramme.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceProgrammeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */