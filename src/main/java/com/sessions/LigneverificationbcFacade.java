/*    */ package sessions;
/*    */ 
/*    */ import entities.Ligneverificationbc;
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
/*    */ public class LigneverificationbcFacade
/*    */   extends AbstractFacade<Ligneverificationbc>
/*    */   implements LigneverificationbcFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public LigneverificationbcFacade() {
/* 31 */     super(Ligneverificationbc.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(l.idligneVerificationBc) FROM Ligneverificationbc l");
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
/*    */   public void deleteByIdVerificationBc(long idVerificationBc) {
/* 51 */     Query query = this.em.createQuery("DELETE FROM Ligneverificationbc l WHERE l.verificationbc.idverificationbc=:idVerficationBc");
/* 52 */     query.setParameter("idVerficationBc", Long.valueOf(idVerificationBc));
/* 53 */     query.executeUpdate();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Ligneverificationbc> findByIdVerificationBc(long idVerificationBc) {
/* 58 */     Query query = this.em.createQuery("SELECT l FROM Ligneverificationbc l WHERE l.verificationbc.idverificationbc=:idVerficationBc ORDER BY l.ligneboncommande.elementcout.code");
/* 59 */     query.setParameter("idVerficationBc", Long.valueOf(idVerificationBc));
/* 60 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\LigneverificationbcFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */