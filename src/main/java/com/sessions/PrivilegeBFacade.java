/*    */ package sessions;
/*    */ 
/*    */ import entities.PrivilegeB;
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
/*    */ public class PrivilegeBFacade
/*    */   extends AbstractFacade<PrivilegeB>
/*    */   implements PrivilegeBFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public PrivilegeBFacade() {
/* 31 */     super(PrivilegeB.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Long nextVal() {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(p.idprivilegeB) FROM PrivilegeB p");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null) {
/* 39 */       result = Long.valueOf(1L);
/*    */     } else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     } 
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<PrivilegeB> findByUser(long idcompte) {
/* 48 */     Query query = this.em.createQuery("SELECT p FROM PrivilegeB p WHERE p.compte.idCompte=:idcompte");
/* 49 */     query.setParameter("idcompte", Long.valueOf(idcompte));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public PrivilegeB findByUser(long idcompte, int idmenu) {
/* 55 */     Query query = this.em.createQuery("SELECT p FROM PrivilegeB p WHERE p.compte.idCompte=:idcompte AND p.menu.idmenuB=:idmenu");
/* 56 */     query.setParameter("idcompte", Long.valueOf(idcompte)).setParameter("idmenu", Integer.valueOf(idmenu));
/* 57 */     if (!query.getResultList().isEmpty()) {
/* 58 */       return query.getResultList().get(0);
/*    */     }
/* 60 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(int idmenu, long idcompte) {
/*    */     try {
/* 66 */       Query query = this.em.createQuery("DELETE FROM PrivilegeB p WHERE p.menu.idmenuB=:idmenu AND p.compte.idCompte=:idcompte");
/* 67 */       query.setParameter("idmenu", Integer.valueOf(idmenu)).setParameter("idcompte", Long.valueOf(idcompte));
/* 68 */       query.executeUpdate();
/* 69 */     } catch (Exception e) {
/* 70 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PrivilegeBFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */