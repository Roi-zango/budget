/*    */ package sessions;
/*    */ 
/*    */ import entities.Rubriquemercurial;
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
/*    */ public class RubriquemercurialFacade
/*    */   extends AbstractFacade<Rubriquemercurial>
/*    */   implements RubriquemercurialFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public RubriquemercurialFacade() {
/* 31 */     super(Rubriquemercurial.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(r.idrubriquemercurial) FROM Rubriquemercurial r");
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
/*    */   public Rubriquemercurial findByCode(String code) throws Exception {
/* 51 */     Query query = this.em.createQuery("SELECT r FROM Rubriquemercurial r WHERE UPPER(r.code)=:code");
/* 52 */     query.setParameter("code", code.toUpperCase());
/* 53 */     List<Rubriquemercurial> rubriquemercurials = query.getResultList();
/* 54 */     if (!rubriquemercurials.isEmpty()) {
/* 55 */       return rubriquemercurials.get(0);
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Rubriquemercurial> findAllRange() {
/* 62 */     Query query = this.em.createQuery("SELECT r FROM Rubriquemercurial r ORDER BY r.code");
/* 63 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RubriquemercurialFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */