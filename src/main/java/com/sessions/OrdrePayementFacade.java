/*    */ package sessions;
/*    */ 
/*    */ import entities.OrdrePayement;
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
/*    */ public class OrdrePayementFacade
/*    */   extends AbstractFacade<OrdrePayement>
/*    */   implements OrdrePayementFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public OrdrePayementFacade() {
/* 31 */     super(OrdrePayement.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(o.idOrdrePayement) FROM OrdrePayement O");
/* 38 */       List<Long> listObj = query.getResultList();
/* 39 */       if (!listObj.isEmpty()) {
/* 40 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*    */       }
/* 42 */       return 1L;
/*    */     }
/* 44 */     catch (Exception e) {
/* 45 */       return 1L;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextIdOp(int idBudget) {
/* 51 */     Query query = this.em.createQuery("SELECT COUNT(o.idOrdrePayement) FROM OrdrePayement o WHERE o.boncommande.budget.idbudget=:idBudget");
/* 52 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/* 53 */     List<Long> listObj = query.getResultList();
/* 54 */     if (!listObj.isEmpty()) {
/* 55 */       return ((Long)listObj.get(0)).longValue();
/*    */     }
/* 57 */     return 0L;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<OrdrePayement> findAll(long idInstitution, int idBudget) {
/* 62 */     Query query = this.em.createQuery("SELECT o FROM OrdrePayement o WHERE o.boncommande.budget.idbudget=:idBudget AND o.boncommande.structure.idinstitution.idinstitution=:idInstitution ORDER BY o.idOrdrePayement DESC");
/* 63 */     query.setParameter("idBudget", Integer.valueOf(idBudget)).setParameter("idInstitution", Long.valueOf(idInstitution));
/* 64 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<OrdrePayement> findAllEtat(long idInstitution, int idBudget, boolean etat) {
/* 69 */     Query query = this.em.createQuery("SELECT o FROM OrdrePayement o WHERE o.boncommande.budget.idbudget=:idBudget AND o.etat=:etat AND o.boncommande.structure.idinstitution.idinstitution=:idInstitution ORDER BY o.idOrdrePayement DESC");
/* 70 */     query.setParameter("idBudget", Integer.valueOf(idBudget)).setParameter("etat", Boolean.valueOf(etat)).setParameter("idInstitution", Long.valueOf(idInstitution));
/* 71 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<OrdrePayement> findAllBc(int idBudget) {
/* 76 */     Query query = this.em.createQuery("SELECT o FROM OrdrePayement o WHERE o.boncommande.budget.idbudget=:idBudget AND o.boncommande.bc=true");
/* 77 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/* 78 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<OrdrePayement> findAllLc(int idBudget) {
/* 83 */     Query query = this.em.createQuery("SELECT o FROM OrdrePayement o WHERE o.boncommande.budget.idbudget=:idBudget AND o.boncommande.lettrecommande=true");
/* 84 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/* 85 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<OrdrePayement> findAllEtatPaid(long idInstitution, int idBudget, boolean etat, boolean paid) {
/* 90 */     Query query = this.em.createQuery("SELECT o FROM OrdrePayement o WHERE o.boncommande.budget.idbudget=:idBudget AND o.etat=:etat AND o.paye=:paye AND o.boncommande.structure.idinstitution.idinstitution=:idInstitution ORDER BY o.idOrdrePayement DESC");
/* 91 */     query.setParameter("idBudget", Integer.valueOf(idBudget)).setParameter("etat", Boolean.valueOf(etat)).setParameter("paye", Boolean.valueOf(paid)).setParameter("idInstitution", Long.valueOf(idInstitution));
/* 92 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\OrdrePayementFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */