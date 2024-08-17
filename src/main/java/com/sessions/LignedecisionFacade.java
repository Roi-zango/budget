/*    */ package sessions;
/*    */ 
/*    */ import entities.Lignedecision;
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
/*    */ @Stateless
/*    */ public class LignedecisionFacade
/*    */   extends AbstractFacade<Lignedecision>
/*    */   implements LignedecisionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 26 */     return this.em;
/*    */   }
/*    */   
/*    */   public LignedecisionFacade() {
/* 30 */     super(Lignedecision.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 36 */       Query query = this.em.createQuery("SELECT MAX(l.idligneDecision) FROM Lignedecision l");
/* 37 */       List<Long> listObj = query.getResultList();
/* 38 */       if (!listObj.isEmpty()) {
/* 39 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*    */       }
/* 41 */       return 1L;
/*    */     }
/* 43 */     catch (Exception e) {
/* 44 */       return 1L;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void deleteByIdBoncommande(long idboncommande) {
/* 50 */     Query query = this.em.createQuery("DELETE FROM Lignedecision l WHERE l.boncommande.idboncommande=:idboncommande");
/* 51 */     query.setParameter("idboncommande", Long.valueOf(idboncommande));
/* 52 */     query.executeUpdate();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Lignedecision> findByIdBoncommande(long idboncommande) {
/* 57 */     Query query = this.em.createQuery("SELECT l FROM Lignedecision l WHERE l.boncommande.idboncommande=:idboncommande ORDER BY l.code");
/* 58 */     query.setParameter("idboncommande", Long.valueOf(idboncommande));
/* 59 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\LignedecisionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */