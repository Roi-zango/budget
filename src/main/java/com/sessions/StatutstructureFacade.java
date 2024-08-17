/*    */ package sessions;
/*    */ 
/*    */ import entities.Statutstructure;
/*    */ import java.util.List;
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
/*    */ public class StatutstructureFacade
/*    */   extends AbstractFacade<Statutstructure>
/*    */   implements StatutstructureFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 25 */     return this.em;
/*    */   }
/*    */   
/*    */   public StatutstructureFacade() {
/* 29 */     super(Statutstructure.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Statutstructure> findAllRange() {
/* 35 */     return this.em.createQuery("SELECT s from Statutstructure s ORDER BY s.nom").getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StatutstructureFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */