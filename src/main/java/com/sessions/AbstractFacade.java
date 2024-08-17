/*    */ package sessions;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.TypedQuery;
/*    */ import javax.persistence.criteria.CriteriaQuery;
/*    */ import javax.persistence.criteria.Expression;
/*    */ import javax.persistence.criteria.Root;
/*    */ import javax.persistence.criteria.Selection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractFacade<T>
/*    */ {
/*    */   private Class<T> entityClass;
/*    */   
/*    */   public AbstractFacade(Class<T> entityClass) {
/* 20 */     this.entityClass = entityClass;
/*    */   }
/*    */   
/*    */   protected abstract EntityManager getEntityManager();
/*    */   
/*    */   public void create(T entity) {
/* 26 */     getEntityManager().persist(entity);
/*    */   }
/*    */   
/*    */   public void edit(T entity) {
/* 30 */     getEntityManager().merge(entity);
/*    */   }
/*    */   
/*    */   public void remove(T entity) {
/* 34 */     getEntityManager().remove(getEntityManager().merge(entity));
/*    */   }
/*    */   
/*    */   public T find(Object id) {
/* 38 */     return (T)getEntityManager().find(this.entityClass, id);
/*    */   }
/*    */   
/*    */   public List<T> findAll() {
/* 42 */     CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
/* 43 */     cq.select((Selection)cq.from(this.entityClass));
/* 44 */     return getEntityManager().createQuery(cq).getResultList();
/*    */   }
/*    */   
/*    */   public List<T> findRange(int[] range) {
/* 48 */     CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
/* 49 */     cq.select((Selection)cq.from(this.entityClass));
/* 50 */     TypedQuery typedQuery = getEntityManager().createQuery(cq);
/* 51 */     typedQuery.setMaxResults(range[1] - range[0] + 1);
/* 52 */     typedQuery.setFirstResult(range[0]);
/* 53 */     return typedQuery.getResultList();
/*    */   }
/*    */   
/*    */   public int count() {
/* 57 */     CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
/* 58 */     Root<T> rt = cq.from(this.entityClass);
/* 59 */     cq.select((Selection)getEntityManager().getCriteriaBuilder().count((Expression)rt));
/* 60 */     TypedQuery typedQuery = getEntityManager().createQuery(cq);
/* 61 */     return ((Long)typedQuery.getSingleResult()).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AbstractFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */