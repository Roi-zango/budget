/*    */ package sessions;
/*    */ 
/*    */ import entities.Indicateuractiviteannee;
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
/*    */ public class IndicateuractiviteanneeFacade
/*    */   extends AbstractFacade<Indicateuractiviteannee>
/*    */   implements IndicateuractiviteanneeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public IndicateuractiviteanneeFacade() {
/* 28 */     super(Indicateuractiviteannee.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractiviteanneeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */