/*    */ package sessions;
/*    */ 
/*    */ import entities.VerificationOp;
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
/*    */ public class VerificationOpFacade
/*    */   extends AbstractFacade<VerificationOp>
/*    */   implements VerificationOpFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public VerificationOpFacade() {
/* 31 */     super(VerificationOp.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(v.idverificationOp) FROM VerificationOp v");
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
/*    */   public List<VerificationOp> findByIdBudget(long idInstitution, int idBudget) {
/* 51 */     Query query = this.em.createQuery("SELECT v FROM VerificationOp v WHERE v.odrePayement.boncommande.budget.idbudget=:idBudget AND v.odrePayement.boncommande.structure.idinstitution.idinstitution=:idInstitution ORDER BY v.dateVerification DESC , v.idverificationOp DESC");
/* 52 */     query.setParameter("idBudget", Integer.valueOf(idBudget)).setParameter("idInstitution", Long.valueOf(idInstitution));
/* 53 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\VerificationOpFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */