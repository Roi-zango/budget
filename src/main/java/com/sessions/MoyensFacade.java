/*    */ package sessions;
/*    */ 
/*    */ import entities.Annee;
/*    */ import entities.Moyens;
/*    */ import entities.Structure;
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
/*    */ 
/*    */ @Stateless
/*    */ public class MoyensFacade
/*    */   extends AbstractFacade<Moyens>
/*    */   implements MoyensFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 30 */     return this.em;
/*    */   }
/*    */   
/*    */   public MoyensFacade() {
/* 34 */     super(Moyens.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer nextId() {
/* 39 */     Query query = this.em.createQuery("SELECT MAX(m.idmoyens) FROM Moyens m");
/* 40 */     Integer resultat = (Integer)query.getSingleResult();
/* 41 */     if (resultat != null) {
/* 42 */       return Integer.valueOf(resultat.intValue() + 1);
/*    */     }
/* 44 */     return Integer.valueOf(1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Moyens> findByStructureAnnee(Structure structure, Annee annee) {
/* 50 */     Query query = this.em.createQuery("SELECT m FROM Moyens m WHERE m.idtache.idstructure.idstructure=:structure AND m.idtache.idannee.idannee=:annee");
/* 51 */     query.setParameter("structure", structure.getIdstructure()).setParameter("annee", annee.getIdannee());
/* 52 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Moyens> findByTache(long idTache) throws Exception {
/* 57 */     Query query = this.em.createQuery("SELECT m FROM Moyens m WHERE m.idtache.idtache=:tache ORDER BY m.idimputation.code");
/* 58 */     query.setParameter("tache", Long.valueOf(idTache));
/* 59 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Moyens> findByStructureAnneeIdimputation(Long idstructure, Long idannee, Long idimputation) {
/* 64 */     Query query = this.em.createQuery("SELECT m FROM Moyens m WHERE m.idtache.idstructure.idstructure=:idstructure AND m.idtache.idannee.idannee=:idannee AND m.idimputation.idimputation=:idimputation");
/* 65 */     query.setParameter("idstructure", idstructure).setParameter("idannee", idannee).setParameter("idimputation", idimputation);
/* 66 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MoyensFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */