/*    */ package sessions;
/*    */ 
/*    */ import entities.Typestructure;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
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
/*    */ public class TypestructureFacade
/*    */   extends AbstractFacade<Typestructure>
/*    */   implements TypestructureFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 26 */     return this.em;
/*    */   }
/*    */   
/*    */   public TypestructureFacade() {
/* 30 */     super(Typestructure.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Typestructure> findAllRange() {
/* 35 */     return this.em.createQuery("SELECT t from Typestructure t ORDER BY t.nom").getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypestructureFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */