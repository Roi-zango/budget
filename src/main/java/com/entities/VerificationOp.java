/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
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
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "verification_op")
/*    */ public class VerificationOp
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name = "idverification_op")
/*    */   private Long idverificationOp;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_ordre_payement", referencedColumnName = "id_ordre_payement")
/*    */   private OrdrePayement odrePayement;
/*    */   @Temporal(TemporalType.DATE)
/*    */   @Column(name = "date_verification")
/*    */   private Date dateVerification;
/*    */   private boolean valide;
/*    */   @Column(length = 500)
/*    */   private String observation;
/*    */   
/*    */   public VerificationOp() {}
/*    */   
/*    */   public VerificationOp(Long idverificationOp) {
/* 48 */     this.idverificationOp = idverificationOp;
/*    */   }
/*    */   
/*    */   public OrdrePayement getOdrePayement() {
/* 52 */     return this.odrePayement;
/*    */   }
/*    */   
/*    */   public void setOdrePayement(OrdrePayement odrePayement) {
/* 56 */     this.odrePayement = odrePayement;
/*    */   }
/*    */   
/*    */   public Date getDateVerification() {
/* 60 */     return this.dateVerification;
/*    */   }
/*    */   
/*    */   public void setDateVerification(Date dateVerification) {
/* 64 */     this.dateVerification = dateVerification;
/*    */   }
/*    */   
/*    */   public String getObservation() {
/* 68 */     return this.observation;
/*    */   }
/*    */   
/*    */   public void setObservation(String observation) {
/* 72 */     this.observation = observation;
/*    */   }
/*    */   
/*    */   public boolean isValide() {
/* 76 */     return this.valide;
/*    */   }
/*    */   
/*    */   public void setValide(boolean valide) {
/* 80 */     this.valide = valide;
/*    */   }
/*    */   
/*    */   public Long getIdverificationOp() {
/* 84 */     return this.idverificationOp;
/*    */   }
/*    */   
/*    */   public void setIdverificationOp(Long idverificationOp) {
/* 88 */     this.idverificationOp = idverificationOp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\VerificationOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */