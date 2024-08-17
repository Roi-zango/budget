/*    */ package sessions;
/*    */ 
/*    */ import entities.Societe;
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
/*    */ public class SocieteFacade
/*    */   extends AbstractFacade<Societe>
/*    */   implements SocieteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public SocieteFacade() {
/* 31 */     super(Societe.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(s.idsociete) FROM Societe s");
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
/*    */   public Societe findByNuid(String nuid) {
/* 51 */     Query query = this.em.createQuery("SELECT s FROM Societe s WHERE  UPPER(s.numerocontribuable)=:nuid");
/* 52 */     query.setParameter("nuid", nuid.toUpperCase());
/* 53 */     List<Societe> societes = query.getResultList();
/* 54 */     if (!societes.isEmpty()) {
/* 55 */       return societes.get(0);
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Societe> findAllRange() {
/* 62 */     return this.em.createQuery("SELECT s FROM Societe s ORDER BY s.nom").getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SocieteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */