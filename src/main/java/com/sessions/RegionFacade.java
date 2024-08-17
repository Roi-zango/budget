/*    */ package sessions;
/*    */ 
/*    */ import entities.Region;
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
/*    */ 
/*    */ @Stateless
/*    */ public class RegionFacade
/*    */   extends AbstractFacade<Region>
/*    */   implements RegionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 26 */     return this.em;
/*    */   }
/*    */   
/*    */   public RegionFacade() {
/* 30 */     super(Region.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Region> findAllRange() {
/* 35 */     return this.em.createQuery("SELECT r from Region r ORDER BY r.nom").getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RegionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */