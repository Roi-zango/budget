/*    */ package sessions;
/*    */ 
/*    */ import entities.Certificatengagement;
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
/*    */ public class CertificatengagementFacade
/*    */   extends AbstractFacade<Certificatengagement>
/*    */   implements CertificatengagementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public CertificatengagementFacade() {
/* 31 */     super(Certificatengagement.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(c.idcertificatengagement) FROM Certificatengagement c");
/* 38 */       List<Long> listObj = query.getResultList();
/* 39 */       if (!listObj.isEmpty()) {
/* 40 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*    */       }
/* 42 */       return 1L;
/*    */     }
/* 44 */     catch (Exception e) {
/* 45 */       return 1L;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Certificatengagement> findByIdAnnee(Long idinstitution, int idbudget) {
/* 51 */     Query query = this.em.createQuery("SELECT c FROM Certificatengagement c WHERE c.boncommande.structure.idinstitution.idinstitution=:idinstitution AND c.boncommande.budget.idbudget=:idbudget");
/* 52 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 53 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CertificatengagementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */