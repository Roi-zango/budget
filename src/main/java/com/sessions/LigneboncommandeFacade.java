/*    */ package sessions;
/*    */ 
/*    */ import entities.Ligneboncommande;
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
/*    */ public class LigneboncommandeFacade
/*    */   extends AbstractFacade<Ligneboncommande>
/*    */   implements LigneboncommandeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public LigneboncommandeFacade() {
/* 31 */     super(Ligneboncommande.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(l.idligneboncommande) FROM Ligneboncommande l");
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
/*    */   public void deleteByIdBoncommande(long idboncommande) {
/* 51 */     Query query = this.em.createQuery("DELETE FROM Ligneboncommande l WHERE l.boncommande.idboncommande=:idboncommande");
/* 52 */     query.setParameter("idboncommande", Long.valueOf(idboncommande));
/* 53 */     query.executeUpdate();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Ligneboncommande> findByIdBoncommande(long idboncommande) {
/* 58 */     Query query = this.em.createQuery("SELECT l FROM Ligneboncommande l WHERE l.boncommande.idboncommande=:idboncommande ORDER BY l.elementcout.code");
/* 59 */     query.setParameter("idboncommande", Long.valueOf(idboncommande));
/* 60 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\LigneboncommandeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */