/*    */ package sessions;
/*    */ 
/*    */ import entities.Utilisateur;
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
/*    */ public class UtilisateurFacade
/*    */   extends AbstractFacade<Utilisateur>
/*    */   implements UtilisateurFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public UtilisateurFacade() {
/* 31 */     super(Utilisateur.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(u.idUtilisateur) FROM Utilisateur u");
/* 38 */       List<Long> listObj = query.getResultList();
/* 39 */       if (!listObj.isEmpty()) {
/* 40 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*    */       }
/* 42 */       return 2L;
/*    */     }
/* 44 */     catch (Exception e) {
/* 45 */       return 2L;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Utilisateur> findByEtat(String etat) {
/* 51 */     Query query = this.em.createQuery("SELECT u FROM Utilisateur u WHERE u.etat=:etat");
/* 52 */     query.setParameter("etat", etat);
/* 53 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\UtilisateurFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */