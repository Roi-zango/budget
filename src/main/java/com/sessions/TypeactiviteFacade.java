/*    */ package sessions;
/*    */ 
/*    */ import entities.Typeactivite;
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
/*    */ public class TypeactiviteFacade
/*    */   extends AbstractFacade<Typeactivite>
/*    */   implements TypeactiviteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public TypeactiviteFacade() {
/* 28 */     super(Typeactivite.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypeactiviteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */