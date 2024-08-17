/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.EmbeddedId;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.NamedQueries;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.Table;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
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
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "cdmt_annee")
/*    */ @XmlRootElement
/*    */ @NamedQueries({@NamedQuery(name = "CdmtAnnee.findAll", query = "SELECT c FROM CdmtAnnee c"), @NamedQuery(name = "CdmtAnnee.findByIdannee", query = "SELECT c FROM CdmtAnnee c WHERE c.cdmtAnneePK.idannee = :idannee"), @NamedQuery(name = "CdmtAnnee.findByIdcdmt", query = "SELECT c FROM CdmtAnnee c WHERE c.cdmtAnneePK.idcdmt = :idcdmt"), @NamedQuery(name = "CdmtAnnee.findByRang", query = "SELECT c FROM CdmtAnnee c WHERE c.rang = :rang")})
/*    */ public class CdmtAnnee
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @EmbeddedId
/*    */   protected CdmtAnneePK cdmtAnneePK;
/*    */   @Column(name = "rang")
/*    */   private Integer rang;
/*    */   
/*    */   public CdmtAnnee() {}
/*    */   
/*    */   public CdmtAnnee(CdmtAnneePK cdmtAnneePK) {
/* 40 */     this.cdmtAnneePK = cdmtAnneePK;
/*    */   }
/*    */   
/*    */   public CdmtAnnee(int idannee, int idcdmt) {
/* 44 */     this.cdmtAnneePK = new CdmtAnneePK(idannee, idcdmt);
/*    */   }
/*    */   
/*    */   public CdmtAnneePK getCdmtAnneePK() {
/* 48 */     return this.cdmtAnneePK;
/*    */   }
/*    */   
/*    */   public void setCdmtAnneePK(CdmtAnneePK cdmtAnneePK) {
/* 52 */     this.cdmtAnneePK = cdmtAnneePK;
/*    */   }
/*    */   
/*    */   public Integer getRang() {
/* 56 */     return this.rang;
/*    */   }
/*    */   
/*    */   public void setRang(Integer rang) {
/* 60 */     this.rang = rang;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     int hash = 0;
/* 66 */     hash += (this.cdmtAnneePK != null) ? this.cdmtAnneePK.hashCode() : 0;
/* 67 */     return hash;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 73 */     if (!(object instanceof CdmtAnnee)) {
/* 74 */       return false;
/*    */     }
/* 76 */     CdmtAnnee other = (CdmtAnnee)object;
/* 77 */     if ((this.cdmtAnneePK == null && other.cdmtAnneePK != null) || (this.cdmtAnneePK != null && !this.cdmtAnneePK.equals(other.cdmtAnneePK))) {
/* 78 */       return false;
/*    */     }
/* 80 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 85 */     return "entities.CdmtAnnee[ cdmtAnneePK=" + this.cdmtAnneePK + " ]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\CdmtAnnee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */