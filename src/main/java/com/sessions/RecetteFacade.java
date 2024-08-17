/*    */ package sessions;
/*    */ 
/*    */ import entities.Annee;
/*    */ import entities.Imputation;
/*    */ import entities.Recette;
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
/*    */ public class RecetteFacade
/*    */   extends AbstractFacade<Recette>
/*    */   implements RecetteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 28 */     return this.em;
/*    */   }
/*    */   
/*    */   public RecetteFacade() {
/* 32 */     super(Recette.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 38 */     Query query = this.em.createQuery("SELECT MAX(r.idrecette) FROM Recette r");
/* 39 */     Long resultat = (Long)query.getSingleResult();
/*    */     
/* 41 */     if (resultat != null) {
/* 42 */       return Long.valueOf(resultat.longValue() + 1L);
/*    */     }
/* 44 */     return Long.valueOf(1L);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Recette findByImputationAnne(Imputation imputation, Annee annee) throws Exception {
/* 51 */     Recette recette = null;
/*    */     try {
/* 53 */       Query query = this.em.createQuery("SELECT r FROM Recette r WHERE r.idimputation.idimputation=:imputation AND r.idannee.idannee=:annee");
/* 54 */       query.setParameter("imputation", imputation.getIdimputation()).setParameter("annee", annee.getIdannee());
/* 55 */       if (!query.getResultList().isEmpty()) {
/* 56 */         recette = query.getResultList().get(0);
/*    */       }
/* 58 */     } catch (Exception e) {
/* 59 */       e.printStackTrace();
/*    */     } 
/* 61 */     return recette;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RecetteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */