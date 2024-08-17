/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateuractionannee;
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
/*    */ public class IndicateuractionanneeFacade
/*    */   extends AbstractFacade<Indicateuractionannee>
/*    */   implements IndicateuractionanneeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateuractionanneeFacade() {
/* 28 */     super(Indicateuractionannee.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractionanneeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */