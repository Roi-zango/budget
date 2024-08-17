/*    */ package sessions;
/*    */ 
/*    */ import entities.Imputation;
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
/*    */ public class ImputationFacade
/*    */   extends AbstractFacade<Imputation>
/*    */   implements ImputationFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ImputationFacade() {
/* 31 */     super(Imputation.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(r.idimputation) FROM Imputation r");
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
/*    */ 
/*    */   
/*    */   public List<Imputation> find(int rubrique, int sousrubrique) {
/* 53 */     List<Imputation> imputations = null;
/*    */     try {
/* 55 */       Query query = this.em.createQuery("SELECT r FROM Imputation r WHERE r.idsousrubrique.idrubrique.idrubrique=:rubrique AND r.idsousrubrique.idsousrubrique=:sousrubrique ORDER BY r.code");
/* 56 */       query.setParameter("rubrique", Integer.valueOf(rubrique)).setParameter("sousrubrique", Integer.valueOf(sousrubrique));
/* 57 */       imputations = query.getResultList();
/* 58 */     } catch (Exception e) {
/* 59 */       e.printStackTrace();
/*    */     } 
/* 61 */     return imputations;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Imputation> findAllOrder() {
/* 66 */     List<Imputation> imputations = null;
/* 67 */     Query query = this.em.createQuery("SELECT r FROM Imputation r ORDER BY r.code");
/* 68 */     imputations = query.getResultList();
/* 69 */     return imputations;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Imputation> findAllOrder(String etat) {
/* 74 */     Query query = this.em.createQuery("SELECT r FROM Imputation r WHERE r.etat=:etat ORDER BY r.code");
/* 75 */     query.setParameter("etat", etat);
/* 76 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ImputationFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */