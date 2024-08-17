/*    */ package sessions;
/*    */ 
/*    */ import entities.Structuremissionactivite;
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
/*    */ public class StructuremissionactiviteFacade
/*    */   extends AbstractFacade<Structuremissionactivite>
/*    */   implements StructuremissionactiviteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public StructuremissionactiviteFacade() {
/* 28 */     super(Structuremissionactivite.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StructuremissionactiviteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */