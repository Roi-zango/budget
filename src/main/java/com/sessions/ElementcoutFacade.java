/*    */ package sessions;
/*    */ 
/*    */ import entities.Elementcout;
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
/*    */ public class ElementcoutFacade
/*    */   extends AbstractFacade<Elementcout>
/*    */   implements ElementcoutFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ElementcoutFacade() {
/* 31 */     super(Elementcout.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(e.idelementcout) FROM Elementcout e");
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
/*    */   public Elementcout findByCode(String code) throws Exception {
/* 51 */     Query query = this.em.createQuery("SELECT e FROM Elementcout e WHERE  UPPER(e.code)=:code");
/* 52 */     query.setParameter("code", code.toUpperCase());
/* 53 */     List<Elementcout> elementcouts = query.getResultList();
/* 54 */     if (!elementcouts.isEmpty()) {
/* 55 */       return elementcouts.get(0);
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Elementcout> findAllRange() {
/* 62 */     return this.em.createQuery("SELECT e FROM Elementcout e ORDER BY e.code").getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Elementcout> findByIdimputation(long idimputation) {
/* 67 */     Query query = this.em.createQuery("SELECT e FROM Elementcout e WHERE e.imputation.idimputation=:idimputation ORDER BY e.code");
/* 68 */     query.setParameter("idimputation", Long.valueOf(idimputation));
/* 69 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Elementcout> findByIdimputationIdrubrique(long idimputation, int idrubrique) {
/* 74 */     Query query = this.em.createQuery("SELECT e FROM Elementcout e WHERE e.imputation.idimputation=:idimputation AND e.sousrubriquemercurial.rubriquemercurial.idrubriquemercurial=:idrubrique ORDER BY e.code");
/* 75 */     query.setParameter("idimputation", Long.valueOf(idimputation)).setParameter("idrubrique", Integer.valueOf(idrubrique));
/* 76 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Elementcout> findByIdimputationIdsousrubrique(long idimputation, int idsousrubrique) {
/* 82 */     Query query = this.em.createQuery("SELECT e FROM Elementcout e WHERE e.imputation.idimputation=:idimputation AND e.sousrubriquemercurial.idsousrubriquemercurial=:idsousrubrique ORDER BY e.code");
/* 83 */     query.setParameter("idimputation", Long.valueOf(idimputation)).setParameter("idsousrubrique", Integer.valueOf(idsousrubrique));
/* 84 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Elementcout> findByIdrubrique(int idrubrique) {
/* 89 */     Query query = this.em.createQuery("SELECT e FROM Elementcout e WHERE e.sousrubriquemercurial.rubriquemercurial.idrubriquemercurial=:idrubrique ORDER BY e.code");
/* 90 */     query.setParameter("idrubrique", Integer.valueOf(idrubrique));
/* 91 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Elementcout> findByIdsousrubrique(int idsousrubrique) {
/* 96 */     Query query = this.em.createQuery("SELECT e FROM Elementcout e WHERE e.sousrubriquemercurial.idsousrubriquemercurial=:idsousrubrique ORDER BY e.code");
/* 97 */     query.setParameter("idsousrubrique", Integer.valueOf(idsousrubrique));
/* 98 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ElementcoutFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */