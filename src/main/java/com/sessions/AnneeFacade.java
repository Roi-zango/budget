/*    */ package sessions;
/*    */ 
/*    */ import entities.Annee;
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
/*    */ public class AnneeFacade
/*    */   extends AbstractFacade<Annee>
/*    */   implements AnneeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public AnneeFacade() {
/* 31 */     super(Annee.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Annee> findAllRange() {
/* 36 */     Query query = this.em.createQuery("SELECT a FROM Annee a ORDER BY a.idannee");
/* 37 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Annee> findByEtat(boolean budget) {
/* 42 */     Query query = this.em.createQuery("SELECT a FROM Annee a WHERE a.budget=:budget ORDER BY a.idannee");
/* 43 */     query.setParameter("budget", Boolean.valueOf(budget));
/* 44 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Annee> findAll(String actif) {
/* 49 */     Query query = this.em.createQuery("SELECT a FROM Annee a WHERE a.etat=:etat ORDER BY a.idannee");
/* 50 */     query.setParameter("etat", actif);
/* 51 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AnneeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */