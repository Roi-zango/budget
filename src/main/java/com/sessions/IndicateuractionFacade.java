/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateuraction;
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
/*    */ public class IndicateuractionFacade
/*    */   extends AbstractFacade<Indicateuraction>
/*    */   implements IndicateuractionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateuractionFacade() {
/* 28 */     super(Indicateuraction.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */