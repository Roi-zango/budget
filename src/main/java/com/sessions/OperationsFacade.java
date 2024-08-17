/*    */ package sessions;
/*    */ 
/*    */ import entities.Operations;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Stateless
/*    */ public class OperationsFacade
/*    */   extends AbstractFacade<Operations>
/*    */   implements OperationsFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 25 */     return this.em;
/*    */   }
/*    */   
/*    */   public OperationsFacade() {
/* 29 */     super(Operations.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 35 */     Query query = this.em.createQuery("SELECT MAX(o.idOperations) FROM Operations o");
/* 36 */     Long resultat = (Long)query.getSingleResult();
/*    */     
/* 38 */     if (resultat != null) {
/* 39 */       return Long.valueOf(resultat.longValue() + 1L);
/*    */     }
/* 41 */     return Long.valueOf(1L);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\OperationsFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */