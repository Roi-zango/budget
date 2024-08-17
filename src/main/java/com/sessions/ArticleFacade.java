/*    */ package sessions;
/*    */ 
/*    */ import entities.Article;
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
/*    */ public class ArticleFacade
/*    */   extends AbstractFacade<Article>
/*    */   implements ArticleFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public ArticleFacade() {
/* 31 */     super(Article.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(a.idarticle) FROM Article a");
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
/*    */   public Article findByCode(String code) throws Exception {
/* 51 */     Query query = this.em.createQuery("SELECT a FROM Article a WHERE UPPER(a.code)=:code");
/* 52 */     query.setParameter("code", code.toUpperCase());
/* 53 */     List<Article> articles = query.getResultList();
/* 54 */     if (!articles.isEmpty()) {
/* 55 */       return articles.get(0);
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Article> findAllRange() {
/* 62 */     Query query = this.em.createQuery("SELECT a FROM Article a ORDER BY a.code");
/* 63 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ArticleFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */