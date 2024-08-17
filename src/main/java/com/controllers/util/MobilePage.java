/*    */ package controllers.util;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public class MobilePage
/*    */   implements Serializable {
/*    */   private String pageId;
/*    */   private String viewId;
/*    */   
/*    */   public String getPageId() {
/* 12 */     return this.pageId;
/*    */   }
/*    */   
/*    */   public void setPageId(String pageId) {
/* 16 */     this.pageId = pageId;
/*    */   }
/*    */   
/*    */   public String getViewId() {
/* 20 */     return this.viewId;
/*    */   }
/*    */   
/*    */   public void setViewId(String viewId) {
/* 24 */     this.viewId = viewId;
/*    */   }
/*    */   
/*    */   public MobilePage(String pageId, String viewId) {
/* 28 */     this.pageId = pageId;
/* 29 */     this.viewId = viewId;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 34 */     int hash = 3;
/* 35 */     hash = 13 * hash + Objects.hashCode(this.pageId);
/* 36 */     hash = 13 * hash + Objects.hashCode(this.viewId);
/* 37 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 42 */     if (obj == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     if (getClass() != obj.getClass()) {
/* 46 */       return false;
/*    */     }
/* 48 */     MobilePage other = (MobilePage)obj;
/* 49 */     if (!Objects.equals(this.pageId, other.pageId)) {
/* 50 */       return false;
/*    */     }
/* 52 */     if (!Objects.equals(this.viewId, other.viewId)) {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controller\\util\MobilePage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */