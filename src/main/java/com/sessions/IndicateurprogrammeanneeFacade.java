/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateurprogrammeannee;
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
/*    */ public class IndicateurprogrammeanneeFacade
/*    */   extends AbstractFacade<Indicateurprogrammeannee>
/*    */   implements IndicateurprogrammeanneeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateurprogrammeanneeFacade() {
/* 28 */     super(Indicateurprogrammeannee.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurprogrammeanneeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */