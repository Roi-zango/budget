/*    */ package sessions;
/*    */ 
/*    */ import entities.Soussecteur;
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
/*    */ 
/*    */ @Stateless
/*    */ public class SoussecteurFacade
/*    */   extends AbstractFacade<Soussecteur>
/*    */   implements SoussecteurFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 28 */     return this.em;
/*    */   }
/*    */   
/*    */   public SoussecteurFacade() {
/* 32 */     super(Soussecteur.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Soussecteur> findAllRange() {
/* 37 */     Query query = this.em.createQuery("SELECT s FROM Soussecteur s ORDER BY s.nom");
/* 38 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SoussecteurFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */