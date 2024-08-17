/*    */ package sessions;
/*    */ 
/*    */ import entities.Activite;
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
/*    */ public class ActiviteFacade
/*    */   extends AbstractFacade<Activite>
/*    */   implements ActiviteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ActiviteFacade() {
/* 31 */     super(Activite.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(a.idactivite) FROM Activite a");
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
/*    */   public List<Activite> findByAction(Long idAction) throws Exception {
/* 48 */     Query query = this.em.createQuery("SELECT a FROM Activite a WHERE a.idaction.idaction=:action ORDER BY a.code , a.nom");
/* 49 */     query.setParameter("action", idAction);
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Activite> findByIdStructure(Long idStructure) {
/* 55 */     Query query = this.em.createQuery("SELECT a FROM Activite a WHERE a.idstructure.idstructure=:idStructure ORDER BY a.code , a.nom");
/* 56 */     query.setParameter("idStructure", idStructure);
/* 57 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Activite> findByIdInstitution(Long idInstitution) {
/* 62 */     Query query = this.em.createQuery("SELECT a FROM Activite a WHERE a.idstructure.idinstitution.idinstitution=:idInstitution ORDER BY a.code , a.nom");
/* 63 */     query.setParameter("idInstitution", idInstitution);
/* 64 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ActiviteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */