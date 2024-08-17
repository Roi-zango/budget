/*    */ package sessions;
/*    */ 
/*    */ import entities.Sousrubriquemercurial;
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
/*    */ public class SousrubriquemercurialFacade
/*    */   extends AbstractFacade<Sousrubriquemercurial>
/*    */   implements SousrubriquemercurialFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public SousrubriquemercurialFacade() {
/* 31 */     super(Sousrubriquemercurial.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(s.idsousrubriquemercurial) FROM Sousrubriquemercurial s");
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
/*    */   public Sousrubriquemercurial findByCode(int idrubrique, String code) throws Exception {
/* 51 */     Query query = this.em.createQuery("SELECT s FROM Sousrubriquemercurial s WHERE s.rubriquemercurial.idrubriquemercurial=:idrubrique AND UPPER(s.code)=:code");
/* 52 */     query.setParameter("code", code.toUpperCase()).setParameter("idrubrique", Integer.valueOf(idrubrique));
/* 53 */     List<Sousrubriquemercurial> sousrubriquemercurials = query.getResultList();
/* 54 */     if (!sousrubriquemercurials.isEmpty()) {
/* 55 */       return sousrubriquemercurials.get(0);
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Sousrubriquemercurial> findAllRange() {
/* 62 */     Query query = this.em.createQuery("SELECT s FROM Sousrubriquemercurial s ORDER BY s.rubriquemercurial.code , s.code");
/* 63 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Sousrubriquemercurial> findByIdrubrique(int idrubrique) {
/* 68 */     Query query = this.em.createQuery("SELECT s FROM Sousrubriquemercurial s WHERE s.rubriquemercurial.idrubriquemercurial=:idrubrique ORDER BY s.code");
/* 69 */     query.setParameter("idrubrique", Integer.valueOf(idrubrique));
/* 70 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SousrubriquemercurialFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */