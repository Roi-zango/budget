/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateurperformance;
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
/*    */ public class IndicateurperformanceFacade
/*    */   extends AbstractFacade<Indicateurperformance>
/*    */   implements IndicateurperformanceFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateurperformanceFacade() {
/* 28 */     super(Indicateurperformance.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurperformanceFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */