/*    */ package sessions;
/*    */ 
/*    */ import entities.ExerciceNature;
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
/*    */ public class ExerciceNatureFacade
/*    */   extends AbstractFacade<ExerciceNature>
/*    */   implements ExerciceNatureFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public ExerciceNatureFacade() {
/* 28 */     super(ExerciceNature.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceNatureFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */