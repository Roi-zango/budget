/*    */ package sessions;
/*    */ 
/*    */ import entities.Rubrique;
/*    */ import java.util.List;
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
/*    */ 
/*    */ @Stateless
/*    */ public class RubriqueFacade
/*    */   extends AbstractFacade<Rubrique>
/*    */   implements RubriqueFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public RubriqueFacade() {
/* 31 */     super(Rubrique.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Rubrique> findAllRangeCode() {
/* 36 */     Query query = this.em.createQuery("SELECT r FROM Rubrique r ORDER BY r.code");
/* 37 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RubriqueFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */