/*    */ package sessions;
/*    */ 
/*    */ import entities.ExerciceNatureT;
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
/*    */ public class ExerciceNatureTFacade
/*    */   extends AbstractFacade<ExerciceNatureT>
/*    */   implements ExerciceNatureTFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public ExerciceNatureTFacade() {
/* 28 */     super(ExerciceNatureT.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceNatureTFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */