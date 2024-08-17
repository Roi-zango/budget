/*    */ package sessions;
/*    */ 
/*    */ import entities.Unite;
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
/*    */ public class UniteFacade
/*    */   extends AbstractFacade<Unite>
/*    */   implements UniteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public UniteFacade() {
/* 31 */     super(Unite.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(u.idunite) FROM Unite u");
/* 38 */       List<Integer> listObj = query.getResultList();
/* 39 */       if (!listObj.isEmpty()) {
/* 40 */         return ((Integer)listObj.get(0)).intValue() + 1;
/*    */       }
/* 42 */       return 1;
/*    */     }
/* 44 */     catch (Exception e) {
/* 45 */       return 1;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Unite> findAllRange() {
/* 51 */     Query query = this.em.createQuery("SELECT u FROM Unite u ORDER BY u.nom");
/* 52 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\UniteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */