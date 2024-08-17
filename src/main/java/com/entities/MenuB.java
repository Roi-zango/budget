/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
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
/*    */ @Entity
/*    */ @Table(name = "menu_b")
/*    */ public class MenuB
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name = "idmenu_b")
/*    */   private Integer idmenuB;
/*    */   private String nom;
/*    */   private String ressource;
/*    */   
/*    */   public MenuB() {}
/*    */   
/*    */   public MenuB(Integer idmenuB) {
/* 33 */     this.idmenuB = idmenuB;
/*    */   }
/*    */   
/*    */   public Integer getIdmenuB() {
/* 37 */     return this.idmenuB;
/*    */   }
/*    */   
/*    */   public void setIdmenuB(Integer idmenuB) {
/* 41 */     this.idmenuB = idmenuB;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 45 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 49 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public String getRessource() {
/* 53 */     return this.ressource;
/*    */   }
/*    */   
/*    */   public void setRessource(String ressource) {
/* 57 */     this.ressource = ressource;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 62 */     int hash = 3;
/* 63 */     hash = 37 * hash + Objects.hashCode(this.idmenuB);
/* 64 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 69 */     if (obj == null) {
/* 70 */       return false;
/*    */     }
/* 72 */     if (getClass() != obj.getClass()) {
/* 73 */       return false;
/*    */     }
/* 75 */     MenuB other = (MenuB)obj;
/* 76 */     if (!Objects.equals(this.idmenuB, other.idmenuB)) {
/* 77 */       return false;
/*    */     }
/* 79 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 84 */     return "MenuB{idmenuB=" + this.idmenuB + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\MenuB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */