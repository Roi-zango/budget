/*    */ package sessions;
/*    */ 
/*    */ import entities.Typedonnees;
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
/*    */ public class TypedonneesFacade
/*    */   extends AbstractFacade<Typedonnees>
/*    */   implements TypedonneesFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public TypedonneesFacade() {
/* 28 */     super(Typedonnees.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypedonneesFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */