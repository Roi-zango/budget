/*    */ package sessions;
/*    */ 
/*    */ import entities.Signataire;
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
/*    */ public class SignataireFacade
/*    */   extends AbstractFacade<Signataire>
/*    */   implements SignataireFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public SignataireFacade() {
/* 31 */     super(Signataire.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(s.idsignataire) FROM Signataire s");
/* 38 */       List<Integer> listObj = query.getResultList();
/* 39 */       if (!listObj.isEmpty()) {
/* 40 */         return ((Integer)listObj.get(0)).intValue() + 1;
/*    */       }
/* 42 */       return 1;
/*    */     }
/* 44 */     catch (Exception e) {
/* 45 */       return 1;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Signataire> findAllRangeEtatInstitutionIsActif() {
/* 51 */     Query query = this.em.createQuery("SELECT s FROM Signataire s WHERE s.structure.etat=:etat ORDER BY s.nom , s.prenom");
/* 52 */     query.setParameter("etat", "Actif");
/* 53 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Signataire> findByIdInstitution(long idInstitution) {
/* 58 */     Query query = this.em.createQuery("SELECT s FROM Signataire s WHERE s.structure.idinstitution.idinstitution=:idInstitution ORDER BY s.nom , s.prenom");
/* 59 */     query.setParameter("idInstitution", Long.valueOf(idInstitution));
/* 60 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SignataireFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */