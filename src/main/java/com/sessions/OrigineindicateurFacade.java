/*    */ package sessions;
/*    */ 
/*    */ import entities.Origineindicateur;
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
/*    */ public class OrigineindicateurFacade
/*    */   extends AbstractFacade<Origineindicateur>
/*    */   implements OrigineindicateurFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 24 */     return this.em;
/*    */   }
/*    */   
/*    */   public OrigineindicateurFacade() {
/* 28 */     super(Origineindicateur.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\OrigineindicateurFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */