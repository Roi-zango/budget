/*    */ package sessions;
/*    */ 
/*    */ import entities.Rattachement;
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
/*    */ public class RattachementFacade
/*    */   extends AbstractFacade<Rattachement>
/*    */   implements RattachementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RattachementFacade() {
/* 28 */     super(Rattachement.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RattachementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */