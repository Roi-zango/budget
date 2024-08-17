/*    */ package sessions;
/*    */ 
/*    */ import entities.Niveaupyramide;
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
/*    */ public class NiveaupyramideFacade
/*    */   extends AbstractFacade<Niveaupyramide>
/*    */   implements NiveaupyramideFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 25 */     return this.em;
/*    */   }
/*    */   
/*    */   public NiveaupyramideFacade() {
/* 29 */     super(Niveaupyramide.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Niveaupyramide> findAllRange() {
/* 34 */     return this.em.createQuery("SELECT n from Niveaupyramide n ORDER BY n.nom").getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\NiveaupyramideFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */