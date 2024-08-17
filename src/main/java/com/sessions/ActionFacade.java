/*    */ package sessions;
/*    */ 
/*    */ import entities.Action;
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
/*    */ public class ActionFacade
/*    */   extends AbstractFacade<Action>
/*    */   implements ActionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ActionFacade() {
/* 31 */     super(Action.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(a.idaction) FROM Action a");
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
/*    */   public List<Action> findByProgramme(Long idProgramme) throws Exception {
/* 48 */     Query query = this.em.createQuery("SELECT a FROM Action a WHERE a.idprogramme.idprogramme=:idProgramme");
/* 49 */     query.setParameter("idProgramme", idProgramme);
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Action> findByInstitution(Long idInstitution) throws Exception {
/* 55 */     Query query = this.em.createQuery("SELECT a FROM Action a WHERE a.idprogramme.idinstitution.idinstitution=:idInstitution ORDER BY a.code");
/* 56 */     query.setParameter("idInstitution", idInstitution);
/* 57 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public Action findByInstitution(Long idInstitution, String code) throws Exception {
/* 62 */     Query query = this.em.createQuery("SELECT a FROM Action a WHERE a.idprogramme.idinstitution.idinstitution=:idInstitution AND a.code=:code");
/* 63 */     query.setParameter("idInstitution", idInstitution).setParameter("code", code);
/* 64 */     List<Action> list = query.getResultList();
/* 65 */     if (!list.isEmpty()) {
/* 66 */       return list.get(0);
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ActionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */