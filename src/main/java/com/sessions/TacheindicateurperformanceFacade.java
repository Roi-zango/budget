/*    */ package sessions;
/*    */ 
/*    */ import entities.Tacheindicateurperformance;
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
/*    */ public class TacheindicateurperformanceFacade
/*    */   extends AbstractFacade<Tacheindicateurperformance>
/*    */   implements TacheindicateurperformanceFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public TacheindicateurperformanceFacade() {
/* 28 */     super(Tacheindicateurperformance.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TacheindicateurperformanceFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */