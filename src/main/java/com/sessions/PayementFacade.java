/*    */ package sessions;
/*    */ 
/*    */ import entities.Payement;
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
/*    */ 
/*    */ @Stateless
/*    */ public class PayementFacade
/*    */   extends AbstractFacade<Payement>
/*    */   implements PayementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 28 */     return this.em;
/*    */   }
/*    */   
/*    */   public PayementFacade() {
/* 32 */     super(Payement.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 38 */       Query query = this.em.createQuery("SELECT MAX(p.idpayement) FROM Payement p");
/* 39 */       List<Long> listObj = query.getResultList();
/* 40 */       if (!listObj.isEmpty()) {
/* 41 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*    */       }
/* 43 */       return 1L;
/*    */     }
/* 45 */     catch (Exception e) {
/* 46 */       return 1L;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Payement> findByIdAnnee(Long idinstitution, int idbudget) {
/* 52 */     Query query = this.em.createQuery("SELECT p FROM Payement p WHERE p.boncommande.structure.idinstitution.idinstitution=:idinstitution AND p.boncommande.budget.idbudget=:idbudget");
/* 53 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 54 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public Payement findByIdVirement(int idvirement) {
/* 59 */     Query query = this.em.createQuery("SELECT p FROM Payement p WHERE p.virementId =:virementId");
/* 60 */     query.setParameter("virementId", Integer.valueOf(idvirement));
/* 61 */     List<Payement> list = query.getResultList();
/* 62 */     if (!list.isEmpty()) {
/* 63 */       return list.get(0);
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PayementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */