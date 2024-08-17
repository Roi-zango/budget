/*    */ package sessions;
/*    */ 
/*    */ import entities.Departement;
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
/*    */ public class DepartementFacade
/*    */   extends AbstractFacade<Departement>
/*    */   implements DepartementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public DepartementFacade() {
/* 31 */     super(Departement.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Departement> findByIdregion(Long idregion) {
/* 36 */     Query query = this.em.createQuery("SELECT d FROM Departement d WHERE d.idregion.idregion=:idregion ORDER BY d.nom");
/* 37 */     query.setParameter("idregion", idregion);
/* 38 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\DepartementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */