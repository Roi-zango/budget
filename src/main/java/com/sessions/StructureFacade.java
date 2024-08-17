/*    */ package sessions;
/*    */ 
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
/*    */ @Stateless
/*    */ public class StructureFacade
/*    */   extends AbstractFacade<Structure>
/*    */   implements StructureFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public StructureFacade() {
/* 31 */     super(Structure.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextId() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(s.idstructure) FROM Structure s");
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
/*    */   public List<Structure> findAllRange() {
/* 48 */     Query query = this.em.createQuery("SELECT s FROM Structure s ORDER BY s.nom");
/* 49 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Structure> findAllRangeEtatInstitutionIsActif() {
/* 54 */     Query query = this.em.createQuery("SELECT s FROM Structure s WHERE s.idinstitution.etat=:etat ORDER BY s.nom");
/* 55 */     query.setParameter("etat", "Actif");
/* 56 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Structure> findByIdinstitution(long idinstitution) {
/* 61 */     Query query = this.em.createQuery("SELECT s FROM Structure s WHERE s.idinstitution.idinstitution=:idinstitution");
/* 62 */     query.setParameter("idinstitution", Long.valueOf(idinstitution));
/* 63 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Structure> findByIdinstitution(long idinstitution, String etat) {
/* 68 */     Query query = this.em.createQuery("SELECT s FROM Structure s WHERE s.idinstitution.idinstitution=:idinstitution AND s.etat=:etat");
/* 69 */     query.setParameter("idinstitution", Long.valueOf(idinstitution)).setParameter("etat", etat);
/* 70 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StructureFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */