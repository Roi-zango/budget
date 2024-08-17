/*    */ package sessions;
/*    */ 
/*    */ import entities.Verificationbc;
/*    */ import java.util.Date;
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
/*    */ public class VerificationbcFacade
/*    */   extends AbstractFacade<Verificationbc>
/*    */   implements VerificationbcFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 28 */     return this.em;
/*    */   }
/*    */   
/*    */   public VerificationbcFacade() {
/* 32 */     super(Verificationbc.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 38 */       Query query = this.em.createQuery("SELECT MAX(v.idverificationbc) FROM Verificationbc v");
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
/*    */   public List<Verificationbc> findByIdAnneeBc(Long idinstitution, int idbudget) {
/* 52 */     Query query = this.em.createQuery("SELECT v FROM Verificationbc v WHERE v.boncommande.structure.idinstitution.idinstitution=:idinstitution AND v.boncommande.budget.idbudget=:idbudget AND v.boncommande.bc=true ORDER BY v.dateverification DESC , v.idverificationbc");
/* 53 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 54 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Verificationbc> findByIdAnneeSal(Long idinstitution, int idbudget) {
/* 59 */     Query query = this.em.createQuery("SELECT v FROM Verificationbc v WHERE v.boncommande.structure.idinstitution.idinstitution=:idinstitution AND v.boncommande.budget.idbudget=:idbudget AND v.boncommande.salaire=true ORDER BY v.dateverification DESC , v.idverificationbc");
/* 60 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 61 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Verificationbc> findByIdAnneeLc(Long idinstitution, int idbudget) {
/* 66 */     Query query = this.em.createQuery("SELECT v FROM Verificationbc v WHERE v.boncommande.structure.idinstitution.idinstitution=:idinstitution AND v.boncommande.budget.idbudget=:idbudget AND v.boncommande.lettrecommande=true ORDER BY v.dateverification DESC , v.idverificationbc");
/* 67 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 68 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Verificationbc> findByIdAnneeDec(Long idinstitution, int idbudget) {
/* 73 */     Query query = this.em.createQuery("SELECT v FROM Verificationbc v WHERE v.boncommande.structure.idinstitution.idinstitution=:idinstitution AND v.boncommande.budget.idbudget=:idbudget AND v.boncommande.decision=true ORDER BY v.dateverification DESC , v.idverificationbc");
/* 74 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 75 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Verificationbc> findByIdAnnee(Long idinstitution, int idbudget, Date date_debut, Date date_fin) {
/* 80 */     Query query = this.em.createQuery("SELECT v FROM Verificationbc v WHERE v.boncommande.structure.idinstitution.idinstitution=:idinstitution AND v.boncommande.budget.idbudget=:idbudget AND v.valide=false AND v.dateverification BETWEEN :date_debut AND :date_fin ORDER BY v.dateverification , v.idverificationbc");
/* 81 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 82 */     query.setParameter("date_debut", date_debut).setParameter("date_fin", date_fin);
/* 83 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\VerificationbcFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */