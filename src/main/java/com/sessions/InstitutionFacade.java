/*    */ package sessions;
/*    */ 
/*    */ import entities.Institution;
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
/*    */ public class InstitutionFacade
/*    */   extends AbstractFacade<Institution>
/*    */   implements InstitutionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public InstitutionFacade() {
/* 31 */     super(Institution.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(i.idinstitution) FROM Institution i");
/* 37 */     Long resultat = (Long)query.getSingleResult();
/*    */     
/* 39 */     if (resultat != null) {
/* 40 */       return Long.valueOf(resultat.longValue() + 1L);
/*    */     }
/* 42 */     return Long.valueOf(1L);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Institution> findAllEtatIsActif() {
/* 48 */     Query query = this.em.createQuery("SELECT i FROM Institution i WHERE i.etat=:etat");
/* 49 */     query.setParameter("etat", "Actif");
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Institution> findAllRange() {
/* 55 */     Query query = this.em.createQuery("SELECT i FROM Institution i ORDER BY i.nom");
/* 56 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\InstitutionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */