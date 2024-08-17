/*    */ package sessions;
/*    */ 
/*    */ import entities.Naturetache;
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
/*    */ public class NaturetacheFacade
/*    */   extends AbstractFacade<Naturetache>
/*    */   implements NaturetacheFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public NaturetacheFacade() {
/* 28 */     super(Naturetache.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\NaturetacheFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */