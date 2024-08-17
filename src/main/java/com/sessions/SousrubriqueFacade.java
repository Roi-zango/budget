/*    */ package sessions;
/*    */ 
/*    */ import entities.Sousrubrique;
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
/*    */ public class SousrubriqueFacade
/*    */   extends AbstractFacade<Sousrubrique>
/*    */   implements SousrubriqueFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 26 */     return this.em;
/*    */   }
/*    */   
/*    */   public SousrubriqueFacade() {
/* 30 */     super(Sousrubrique.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Sousrubrique> findByRubrique(int rubrique) {
/* 35 */     List<Sousrubrique> sousrubriques = null;
/*    */     
/*    */     try {
/* 38 */       Query query = this.em.createQuery("SELECT d FROM Sousrubrique d WHERE d.idrubrique.idrubrique=:rubrique");
/* 39 */       query.setParameter("rubrique", Integer.valueOf(rubrique));
/* 40 */       sousrubriques = query.getResultList();
/* 41 */     } catch (Exception e) {
/* 42 */       e.printStackTrace();
/*    */     } 
/* 44 */     return sousrubriques;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SousrubriqueFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */