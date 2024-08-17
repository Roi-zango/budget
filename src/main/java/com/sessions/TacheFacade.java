/*    */ package sessions;
/*    */ 
/*    */ import entities.Tache;
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
/*    */ public class TacheFacade
/*    */   extends AbstractFacade<Tache>
/*    */   implements TacheFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public TacheFacade() {
/* 31 */     super(Tache.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(t.idtache) FROM Tache t");
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
/*    */   public List<Tache> findByStructureAnnee(long idStructure, long idAnnee) {
/* 48 */     Query query = this.em.createQuery("SELECT t FROM Tache t WHERE t.idstructure.idstructure=:structure AND t.idannee.idannee=:annee");
/* 49 */     query.setParameter("structure", Long.valueOf(idStructure)).setParameter("annee", Long.valueOf(idAnnee));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Tache> findByIdInstitutionIdAnnee(long idInstitution, long idAnnee) {
/* 55 */     Query query = this.em.createQuery("SELECT t FROM Tache t WHERE t.idstructure.idinstitution.idinstitution=:idInstitution AND t.idannee.idannee=:annee");
/* 56 */     query.setParameter("idInstitution", Long.valueOf(idInstitution)).setParameter("annee", Long.valueOf(idAnnee));
/* 57 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TacheFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */