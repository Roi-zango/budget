/*    */ package sessions;
/*    */ 
/*    */ import entities.Arrondissement;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
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
/*    */ public class ArrondissementFacade
/*    */   extends AbstractFacade<Arrondissement>
/*    */   implements ArrondissementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ArrondissementFacade() {
/* 31 */     super(Arrondissement.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Arrondissement> findByIddepartement(Long iddepartement) {
/* 36 */     Query query = this.em.createQuery("SELECT a FROM Arrondissement a WHERE a.iddepartement.iddepartement=:iddepartement ORDER BY a.nom");
/* 37 */     query.setParameter("iddepartement", iddepartement);
/* 38 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ArrondissementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */