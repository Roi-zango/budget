/*    */ package sessions;
/*    */ 
/*    */ import entities.Typefinancement;
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
/*    */ public class TypefinancementFacade
/*    */   extends AbstractFacade<Typefinancement>
/*    */   implements TypefinancementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public TypefinancementFacade() {
/* 28 */     super(Typefinancement.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypefinancementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */