/*    */ package sessions;
/*    */ 
/*    */ import entities.Zone;
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
/*    */ public class ZoneFacade
/*    */   extends AbstractFacade<Zone>
/*    */   implements ZoneFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public ZoneFacade() {
/* 28 */     super(Zone.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ZoneFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */