/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
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
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "privilege_b")
/*    */ public class PrivilegeB
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name = "idprivilege_b")
/*    */   private Long idprivilegeB;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "idmenu", referencedColumnName = "idmenu_b")
/*    */   private MenuB menu;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "idcompte", referencedColumnName = "id_compte")
/*    */   private Compte compte;
/*    */   
/*    */   public PrivilegeB() {}
/*    */   
/*    */   public PrivilegeB(Long idprivilegeB) {
/* 40 */     this.idprivilegeB = idprivilegeB;
/*    */   }
/*    */   
/*    */   public Long getIdprivilegeB() {
/* 44 */     return this.idprivilegeB;
/*    */   }
/*    */   
/*    */   public void setIdprivilegeB(Long idprivilegeB) {
/* 48 */     this.idprivilegeB = idprivilegeB;
/*    */   }
/*    */   
/*    */   public MenuB getMenu() {
/* 52 */     return this.menu;
/*    */   }
/*    */   
/*    */   public void setMenu(MenuB menu) {
/* 56 */     this.menu = menu;
/*    */   }
/*    */   
/*    */   public Compte getCompte() {
/* 60 */     return this.compte;
/*    */   }
/*    */   
/*    */   public void setCompte(Compte compte) {
/* 64 */     this.compte = compte;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 69 */     int hash = 3;
/* 70 */     hash = 47 * hash + Objects.hashCode(this.idprivilegeB);
/* 71 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 76 */     if (obj == null) {
/* 77 */       return false;
/*    */     }
/* 79 */     if (getClass() != obj.getClass()) {
/* 80 */       return false;
/*    */     }
/* 82 */     PrivilegeB other = (PrivilegeB)obj;
/* 83 */     if (!Objects.equals(this.idprivilegeB, other.idprivilegeB)) {
/* 84 */       return false;
/*    */     }
/* 86 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 91 */     return "PrivilegeB{idprivilegeB=" + this.idprivilegeB + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\PrivilegeB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */