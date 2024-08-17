/*     */ package sessions;
/*     */ 
/*     */ import entities.Boncommande;
/*     */ import java.util.List;
/*     */ import javax.ejb.Stateless;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.PersistenceContext;
/*     */ import javax.persistence.Query;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Stateless
public class BoncommandeFacade extends AbstractFacade<Boncommande> implements BoncommandeFacadeLocal {
    @PersistenceContext(unitName = "BudgetPU")
    private EntityManager em;

    public BoncommandeFacade() {
        super(Boncommande.class);
        System.out.println("BoncommandeFacade initialized.");
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }
}

/*     */ 
/*     */   
/*     */   public long nextId() {
/*     */     try {
/*  37 */       Query query = this.em.createQuery("SELECT MAX(b.idboncommande) FROM Boncommande b");
/*  38 */       List<Long> listObj = query.getResultList();
/*  39 */       if (!listObj.isEmpty()) {
/*  40 */         return ((Long)listObj.get(0)).longValue() + 1L;
/*     */       }
/*  42 */       return 1L;
/*     */     }
/*  44 */     catch (Exception e) {
/*  45 */       return 1L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long nextIdBC(int idBudget) {
/*  51 */     Query query = this.em.createQuery("SELECT COUNT(b.idboncommande) FROM Boncommande b WHERE b.budget.idbudget=:idBudget AND b.bc = true");
/*  52 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/*  53 */     List<Long> listObj = query.getResultList();
/*  54 */     if (!listObj.isEmpty()) {
/*  55 */       return ((Long)listObj.get(0)).longValue();
/*     */     }
/*  57 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long nextIdBC(int idBudget, long idInstitution) {
/*  62 */     Query query = this.em.createQuery("SELECT COUNT(b.idboncommande) FROM Boncommande b WHERE b.budget.idbudget=:idBudget AND b.structure.idinstitution.idinstitution=:idInstitution AND b.bc = true");
/*  63 */     query.setParameter("idBudget", Integer.valueOf(idBudget)).setParameter("idInstitution", Long.valueOf(idInstitution));
/*  64 */     List<Long> listObj = query.getResultList();
/*  65 */     if (!listObj.isEmpty()) {
/*  66 */       return ((Long)listObj.get(0)).longValue();
/*     */     }
/*  68 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long nextIdLC(int idBudget) {
/*  73 */     Query query = this.em.createQuery("SELECT COUNT(b.idboncommande) FROM Boncommande b WHERE b.budget.idbudget=:idBudget AND b.lettrecommande = true");
/*  74 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/*  75 */     List<Long> listObj = query.getResultList();
/*  76 */     if (!listObj.isEmpty()) {
/*  77 */       return ((Long)listObj.get(0)).longValue();
/*     */     }
/*  79 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long nextIdDE(int idBudget) {
/*  84 */     Query query = this.em.createQuery("SELECT COUNT(b.idboncommande) FROM Boncommande b WHERE b.budget.idbudget=:idBudget AND b.decision = true");
/*  85 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/*  86 */     List<Long> listObj = query.getResultList();
/*  87 */     if (!listObj.isEmpty()) {
/*  88 */       return ((Long)listObj.get(0)).longValue();
/*     */     }
/*  90 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long nextIdSA(int idBudget) {
/*  95 */     Query query = this.em.createQuery("SELECT COUNT(b.idboncommande) FROM Boncommande b WHERE b.budget.idbudget=:idBudget AND b.salaire = true");
/*  96 */     query.setParameter("idBudget", Integer.valueOf(idBudget));
/*  97 */     List<Long> listObj = query.getResultList();
/*  98 */     if (!listObj.isEmpty()) {
/*  99 */       return ((Long)listObj.get(0)).longValue();
/*     */     }
/* 101 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boncommande findByCode(Long idinstitution, String code) {
/* 106 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idstructure=:idstructure AND UPPER(b.code)=:code");
/* 107 */     query.setParameter("idstructure", idinstitution).setParameter("code", code.toUpperCase());
/* 108 */     List<Boncommande> boncommandes = query.getResultList();
/* 109 */     if (!boncommandes.isEmpty()) {
/* 110 */       return boncommandes.get(0);
/*     */     }
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnnee(Long idinstitution, int idbudget) {
/* 117 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget");
/* 118 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 119 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeBc(Long idinstitution, int idbudget) {
/* 124 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.bc = true ORDER BY b.idboncommande DESC");
/* 125 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 126 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeMis(Long idinstitution, int idbudget) {
/* 131 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.mission = true");
/* 132 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 133 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeSal(Long idinstitution, int idbudget) {
/* 138 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.salaire = true ORDER BY b.idboncommande DESC");
/* 139 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 140 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeEngageIsFalse(Long idinstitution, int idbudget) {
/* 145 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.engage=:engage");
/* 146 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("engage", Boolean.valueOf(false));
/* 147 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeEngageNotvalidated(Long idinstitution, int idbudget) {
/* 152 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.valide=:valide");
/* 153 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(false));
/* 154 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeBcNotValidated(Long idinstitution, int idbudget) {
/* 159 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.bc = true AND b.valide=false");
/* 160 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 161 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeBc(Long idinstitution, int idbudget, boolean valide) {
/* 166 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.bc = true AND b.valide=:valide");
/* 167 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(valide));
/* 168 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeLc(Long idinstitution, int idbudget, boolean valide) {
/* 173 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.lettrecommande = true AND b.valide=:valide");
/* 174 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(valide));
/* 175 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeDec(Long idinstitution, int idbudget, boolean valide) {
/* 180 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.decision = true AND b.valide=:valide");
/* 181 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(valide));
/* 182 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeSal(Long idinstitution, int idbudget, boolean valide) {
/* 187 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.salaire = true AND b.valide=:valide");
/* 188 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(valide));
/* 189 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeMis(Long idinstitution, int idbudget, boolean valide) {
/* 194 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.mission = true AND b.valide=:valide");
/* 195 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(valide));
/* 196 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeValidated(Long idinstitution, int idbudget, boolean valide) {
/* 201 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.valide=:valide");
/* 202 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget)).setParameter("valide", Boolean.valueOf(valide));
/* 203 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeMisNotValidated(Long idinstitution, int idbudget) {
/* 208 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.salaire = true AND b.valide=false");
/* 209 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 210 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeLc(Long idinstitution, int idbudget) {
/* 215 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.lettrecommande = true ORDER BY b.idboncommande DESC");
/* 216 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 217 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeDec(Long idinstitution, int idbudget) {
/* 222 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.decision = true ORDER BY b.idboncommande DESC");
/* 223 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 224 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeLcNotValidated(Long idinstitution, int idbudget) {
/* 229 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.lettrecommande = true AND b.valide=false");
/* 230 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 231 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeDecNotValidated(Long idinstitution, int idbudget) {
/* 236 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.decision = true AND b.valide=false");
/* 237 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 238 */     return query.getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boncommande> findByIdAnneeValidatedNotPayed(Long idinstitution, int idbudget) {
/* 243 */     Query query = this.em.createQuery("SELECT b FROM Boncommande b WHERE b.structure.idinstitution.idinstitution=:idinstitution AND b.budget.idbudget=:idbudget AND b.liquide=true AND b.paye=false");
/* 244 */     query.setParameter("idinstitution", idinstitution).setParameter("idbudget", Integer.valueOf(idbudget));
/* 245 */     return query.getResultList();
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BoncommandeFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */