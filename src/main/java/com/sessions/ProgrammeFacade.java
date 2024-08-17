/*    */ package sessions;
/*    */ 
/*    */ import entities.Programme;
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
/*    */ public class ProgrammeFacade
/*    */   extends AbstractFacade<Programme>
/*    */   implements ProgrammeFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ProgrammeFacade() {
/* 31 */     super(Programme.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(p.idprogramme) FROM Programme p");
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
/*    */   public List<Programme> findByIdinstitution(long idinstitution) {
/* 48 */     Query query = this.em.createQuery("SELECT p FROM Programme p WHERE p.idinstitution.idinstitution=:idinstitution ORDER BY p.code");
/* 49 */     query.setParameter("idinstitution", Long.valueOf(idinstitution));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Programme> findByIdinstitutionEtat(long idinstitution, String etat) {
/* 55 */     Query query = this.em.createQuery("SELECT p FROM Programme p WHERE p.idinstitution.idinstitution=:idinstitution AND p.etat=:etat ORDER BY p.code");
/* 56 */     query.setParameter("idinstitution", Long.valueOf(idinstitution)).setParameter("etat", etat);
/* 57 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public Programme findByIdinstitution(long idinstitution, String code) {
/* 62 */     Query query = this.em.createQuery("SELECT p FROM Programme p WHERE p.idinstitution.idinstitution=:idinstitution AND p.code=:code");
/* 63 */     query.setParameter("idinstitution", Long.valueOf(idinstitution)).setParameter("code", code);
/* 64 */     List<Programme> list = query.getResultList();
/* 65 */     if (!list.isEmpty()) {
/* 66 */       return list.get(0);
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ProgrammeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */