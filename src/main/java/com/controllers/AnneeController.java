/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import entities.Annee;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import sessions.AnneeFacadeLocal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class AnneeController
/*     */   implements Serializable
/*     */ {
            private String nom;
    
             public String getNom() {
                  return nom;
            }
    
              public void setNom(String nom) {
                  this.nom = nom;
            }
/*     */   @EJB
/*     */   private AnneeFacadeLocal anneeFacadeLocal;
/*  29 */   private Annee annee;
/*  30 */   private List<Annee> annees;
/*     */   
/*  32 */   private String mode = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   public void init() {
/*  45 */     construct();
              annee = new Annee();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void construct() {
/*     */     annee = new Annee();
/*     */     System.out.println("Annee object initialised: " +  annee);
/*     */ }
/*     */ 
/*     */ 
/*     */   
/*     */  public void create() {
    try {
        if (annee != null) {
            anneeFacadeLocal.create(annee);
            JsfUtil.addSuccessMessage("Annee created successfully.");
            annee = new Annee(); // Reset the annee object
            this.annees = anneeFacadeLocal.findAllRange(); // Refresh the list
        }
    } catch (Exception e) {
        JsfUtil.addErrorMessage("Error occurred while creating annee.");
        e.printStackTrace();
    }
}


/*     */     
/*     */   
/*     */   public void prepareEdit() {
/*  61 */     if (this.annee != null) {
/*  62 */       this.mode = "Edit";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void filterSousrubriqueByRubrique() {}
/*     */ 
/*     */   
/*     */   public void afficher() {}
/*     */ 
/*     */   
/*     */   public void save() {
/*     */     try {
/*  76 */       if (this.annee != null) {
/*  77 */         if ("Create".equals(this.mode)) {
/*  78 */           this.mode = "";
/*  79 */           JsfUtil.addSuccessMessage("Opération réussie");
/*  80 */         } else if ("Edit".equals(this.mode)) {
/*     */           
/*  82 */           this.anneeFacadeLocal.edit(this.annee);
/*     */           
/*  84 */           JsfUtil.addSuccessMessage("Opération réussie");
/*  85 */           this.mode = "";
/*     */         } else {
/*  87 */           JsfUtil.addErrorMessage("Veuillez verifier les données");
/*     */         }
/*     */       
/*     */       }
/*  91 */     } catch (Exception e) {
/*  92 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete() {}
/*     */       try {
    if (this.annee != null) {
        anneeFacadeLocal.remove(annee);
        JsfUtil.addSuccessMessage("Annee supprimée avec succès");
        annee = new Annee();  // Reset the current annee
        this.annees = anneeFacadeLocal.findAllRange();  // Refresh the list
    } else {
        JsfUtil.addErrorMessage("Aucune année sélectionnée à supprimer");
    }
} catch (Exception e) {
    e.printStackTrace();
    JsfUtil.addErrorMessage(e, "Une erreur s'est produite lors de la suppression de l'année");
}
}
/*     */ 
/*     */ 
/*     */   
/*     */   public void activeButton() {
/* 105 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 109 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 113 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 117 */     this.detail = detail;
/*     */   }
/*     */   
/*     */    public Annee getAnnee() {
    if (annee == null) {
        annee = new Annee(); // Ensure annee is never null
    }
    return annee;
}


/*     */   
/*     */   public void setAnnee(Annee annee) {
/* 125 */     this.annee = annee;
/*     */   }
/*     */   
/*     */   public List<Annee> getAnnees() {
	           if(annees == null) { 
	        	   annees = new Arraylist<>();
	           }
/* 129 */     this.annees = this.anneeFacadeLocal.findAllRange();
/* 130 */     return this.annees;
/*     */   }
/*     */   
/*     */   public void setAnnees(List<Annee> annees) {
/* 134 */     this.annees = annees;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\AnneeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */