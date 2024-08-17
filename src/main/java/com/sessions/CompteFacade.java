/*    */ package sessions;
/*    */ 
/*    */ import entities.Compte;
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
/*    */ public class CompteFacade
/*    */   extends AbstractFacade<Compte>
/*    */   implements CompteFacadeLocal
/*    */ {
/*    */   @PersistenceContext(unitName = "BudgetPU")
/*    */   private EntityManager em;
/*    */   
/*    */   protected EntityManager getEntityManager() {
/* 27 */     return this.em;
/*    */   }
/*    */   
/*    */   public CompteFacade() {
/* 31 */     super(Compte.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextId() {
/*    */     try {
/* 37 */       Query query = this.em.createQuery("SELECT MAX(c.idCompte) FROM Compte c");
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
/*    */   public Compte connexion(Compte compte) {
/*    */     try {
/* 52 */       Query query = this.em.createQuery("SELECT c FROM Compte c WHERE c.login=:login AND c.mdp=:mdp");
/* 53 */       query.setParameter("login", compte.getLogin()).setParameter("mdp", compte.getMdp());
/* 54 */       List<Compte> listObj = query.getResultList();
/* 55 */       if (!listObj.isEmpty()) {
/* 56 */         Compte cpte = listObj.get(0);
/* 57 */         this.em.refresh(cpte);
/* 58 */         return cpte;
/*    */       } 
/* 60 */       return null;
/*    */     }
/* 62 */     catch (Exception e) {
/* 63 */       e.printStackTrace();
/* 64 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Compte> findByEtat(String etat) {
/* 70 */     Query query = this.em.createQuery("SELECT c FROM Compte c WHERE c.etat=:etat");
/* 71 */     query.setParameter("etat", etat);
/* 72 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   
/*    */   public Compte findByIdutilisateur(long idutilisateur) {
/* 77 */     Query query = this.em.createQuery("SELECT c FROM Compte c WHERE c.idUtilisateur.idUtilisateur=:idutilisateur");
/* 78 */     query.setParameter("idutilisateur", Long.valueOf(idutilisateur));
/* 79 */     List<Compte> list = query.getResultList();
/* 80 */     if (!list.isEmpty()) {
/* 81 */       return list.get(0);
/*    */     }
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CompteFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */