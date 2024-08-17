/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateuractivite;
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
/*    */ public class IndicateuractiviteFacade
/*    */   extends AbstractFacade<Indicateuractivite>
/*    */   implements IndicateuractiviteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateuractiviteFacade() {
/* 28 */     super(Indicateuractivite.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractiviteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */