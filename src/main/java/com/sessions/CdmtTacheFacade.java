/*    */ package sessions;
/*    */ 
/*    */ import entities.CdmtTache;
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
/*    */ public class CdmtTacheFacade
/*    */   extends AbstractFacade<CdmtTache>
/*    */   implements CdmtTacheFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public CdmtTacheFacade() {
/* 28 */     super(CdmtTache.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CdmtTacheFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */