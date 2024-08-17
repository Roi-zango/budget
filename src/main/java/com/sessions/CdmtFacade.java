/*    */ package sessions;
/*    */ 
/*    */ import entities.Cdmt;
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
/*    */ public class CdmtFacade
/*    */   extends AbstractFacade<Cdmt>
/*    */   implements CdmtFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public CdmtFacade() {
/* 28 */     super(Cdmt.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CdmtFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */