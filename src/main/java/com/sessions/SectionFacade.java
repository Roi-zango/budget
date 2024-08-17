/*    */ package sessions;
/*    */ 
/*    */ import entities.Section;
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
/*    */ public class SectionFacade
/*    */   extends AbstractFacade<Section>
/*    */   implements SectionFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 28 */     return this.em;
/*    */   }
/*    */   
/*    */   public SectionFacade() {
/* 32 */     super(Section.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public int nextId() {
/*    */     try {
/* 38 */       Query query = this.em.createQuery("SELECT MAX(s.idsection) FROM Section s");
/* 39 */       List<Integer> listObj = query.getResultList();
/* 40 */       if (!listObj.isEmpty()) {
/* 41 */         return ((Integer)listObj.get(0)).intValue() + 1;
/*    */       }
/* 43 */       return 1;
/*    */     }
/* 45 */     catch (Exception e) {
/* 46 */       return 1;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Section findByCode(String code) throws Exception {
/* 52 */     Query query = this.em.createQuery("SELECT s FROM Section s WHERE UPPER(s.code)=:code");
/* 53 */     query.setParameter("code", code.toUpperCase());
/* 54 */     List<Section> sections = query.getResultList();
/* 55 */     if (!sections.isEmpty()) {
/* 56 */       return sections.get(0);
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Section> findAllRange() {
/* 63 */     Query query = this.em.createQuery("SELECT s FROM Section s ORDER BY s.code");
/* 64 */     return query.getResultList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SectionFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */