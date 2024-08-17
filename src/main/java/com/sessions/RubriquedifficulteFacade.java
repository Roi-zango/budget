/*    */ package sessions;
/*    */ 
/*    */ import entities.Rubriquedifficulte;
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
/*    */ public class RubriquedifficulteFacade
/*    */   extends AbstractFacade<Rubriquedifficulte>
/*    */   implements RubriquedifficulteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RubriquedifficulteFacade() {
/* 28 */     super(Rubriquedifficulte.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RubriquedifficulteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */