/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateurextrant;
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
/*    */ public class IndicateurextrantFacade
/*    */   extends AbstractFacade<Indicateurextrant>
/*    */   implements IndicateurextrantFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateurextrantFacade() {
/* 28 */     super(Indicateurextrant.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurextrantFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */