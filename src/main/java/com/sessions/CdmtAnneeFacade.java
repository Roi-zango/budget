/*    */ package sessions;
/*    */ 
/*    */ import entities.CdmtAnnee;
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
/*    */ public class CdmtAnneeFacade
/*    */   extends AbstractFacade<CdmtAnnee>
/*    */   implements CdmtAnneeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public CdmtAnneeFacade() {
/* 28 */     super(CdmtAnnee.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CdmtAnneeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */