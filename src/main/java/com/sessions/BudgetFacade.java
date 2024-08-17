/*    */ package sessions;
/*    */ 
/*    */ import entities.Budget;
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
/*    */ public class BudgetFacade
/*    */   extends AbstractFacade<Budget>
/*    */   implements BudgetFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public BudgetFacade() {
/* 31 */     super(Budget.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(b.idbudget) FROM Budget b");
/* 37 */     Integer resultat = (Integer)query.getSingleResult();
/*    */     
/* 39 */     if (resultat != null) {
/* 40 */       return Integer.valueOf(resultat.intValue() + 1);
/*    */     }
/* 42 */     return Integer.valueOf(1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Budget findByNom(String nom) {
/* 48 */     Query query = this.em.createQuery("SELECT b FROM Budget b WHERE b.annee=:annee");
/* 49 */     query.setParameter("annee", nom);
/* 50 */     List<Budget> budgets = query.getResultList();
/* 51 */     if (!budgets.isEmpty()) {
/* 52 */       return budgets.get(0);
/*    */     }
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Budget> findAllRange() {
/* 59 */     Query query = this.em.createQuery("SELECT b FROM Budget b ORDER BY b.annee");
/* 60 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public Budget findByAnnee(String annee) {
/* 65 */     Query query = this.em.createQuery("SELECT b FROM Budget b WHERE b.annee=:annee");
/* 66 */     query.setParameter("annee", annee);
/* 67 */     List<Budget> list = query.getResultList();
/* 68 */     if (!list.isEmpty()) {
/* 69 */       return list.get(0);
/*    */     }
/* 71 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BudgetFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */