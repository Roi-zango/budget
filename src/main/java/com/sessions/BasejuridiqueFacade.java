/*    */ package sessions;
/*    */ 
/*    */ import entities.Basejuridique;
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
/*    */ public class BasejuridiqueFacade
/*    */   extends AbstractFacade<Basejuridique>
/*    */   implements BasejuridiqueFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public BasejuridiqueFacade() {
/* 28 */     super(Basejuridique.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BasejuridiqueFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */