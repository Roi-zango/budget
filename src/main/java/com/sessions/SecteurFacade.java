/*    */ package sessions;
/*    */ 
/*    */ import entities.Secteur;
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
/*    */ public class SecteurFacade
/*    */   extends AbstractFacade<Secteur>
/*    */   implements SecteurFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public SecteurFacade() {
/* 28 */     super(Secteur.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SecteurFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */