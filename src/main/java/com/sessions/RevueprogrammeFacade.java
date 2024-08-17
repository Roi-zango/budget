/*    */ package sessions;
/*    */ 
/*    */ import entities.Revueprogramme;
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
/*    */ public class RevueprogrammeFacade
/*    */   extends AbstractFacade<Revueprogramme>
/*    */   implements RevueprogrammeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public RevueprogrammeFacade() {
/* 28 */     super(Revueprogramme.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueprogrammeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */