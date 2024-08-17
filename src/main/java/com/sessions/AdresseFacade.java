/*    */ package sessions;
/*    */ 
/*    */ import entities.Adresse;
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
/*    */ public class AdresseFacade
/*    */   extends AbstractFacade<Adresse>
/*    */   implements AdresseFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 26 */     return this.em;
/*    */   }
/*    */   
/*    */   public AdresseFacade() {
/* 30 */     super(Adresse.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 36 */       Query query = this.em.createQuery("SELECT MAX(a.idAdresse) FROM Adresse a");
/* 37 */       List<Long> listObj = query.getResultList();
/* 38 */       if (!listObj.isEmpty()) {
/* 39 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*    */       }
/* 41 */       return 2L;
/*    */     }
/* 43 */     catch (Exception e) {
/* 44 */       return 2L;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AdresseFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */