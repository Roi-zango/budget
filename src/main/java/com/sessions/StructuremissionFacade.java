/*    */ package sessions;
/*    */ 
/*    */ import entities.Structuremission;
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
/*    */ public class StructuremissionFacade
/*    */   extends AbstractFacade<Structuremission>
/*    */   implements StructuremissionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public StructuremissionFacade() {
/* 28 */     super(Structuremission.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StructuremissionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */