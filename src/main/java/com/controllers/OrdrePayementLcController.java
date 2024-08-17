/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Imputation;
/*     */ import entities.Moyens;
/*     */ import entities.OrdrePayement;
/*     */ import entities.Signataire;
/*     */ import entities.Structure;
/*     */ import entities.Tache;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.annotation.Resource;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.transaction.Transactional;
/*     */ import javax.transaction.UserTransaction;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.BoncommandeFacadeLocal;
/*     */ import sessions.MoyensFacadeLocal;
/*     */ import sessions.OrdrePayementFacadeLocal;
/*     */ import sessions.TacheFacadeLocal;
/*     */ import utilitaire.Convert;
/*     */ import utilitaire.Printer;
/*     */ import utilitaire.Utilitaires;
/*     */ 
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
/*     */ @ViewScoped
/*     */ public class OrdrePayementLcController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private OrdrePayementFacadeLocal ordrePayementFacadeLocal;
/*  52 */   private OrdrePayement ordrePayement = new OrdrePayement();
/*  53 */   private List<OrdrePayement> ordrePayements = new ArrayList<>();
/*     */   
/*     */   private long idBonCommande;
/*     */   
/*     */   private int modeOp;
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  60 */   private Boncommande boncommande = new Boncommande();
/*  61 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private MoyensFacadeLocal moyensFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private TacheFacadeLocal tacheFacadeLocal;
/*     */   
/*  69 */   private String mode = "";
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void initBon() {
/*  78 */     this.boncommande = new Boncommande();
/*  79 */     this.boncommande.setStructure(new Structure());
/*  80 */     this.boncommande.setImputation(new Imputation());
/*  81 */     this.boncommande.setSignataire(new Signataire());
/*  82 */     this.boncommande.setTtc(Double.valueOf(0.0D));
/*  83 */     this.boncommande.setTva(0.0D);
/*  84 */     this.boncommande.setNetapayer(0.0D);
/*  85 */     this.boncommande.setTotalair(0.0D);
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*  89 */     if (!Utilitaires.isAccess(Long.valueOf(32L))) {
/*  90 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit d'etablir un ordre de payement");
/*     */       
/*     */       return;
/*     */     } 
/*  94 */     this.modeOp = 1;
/*  95 */     this.mode = "Create";
/*  96 */     this.ordrePayement = new OrdrePayement();
/*  97 */     this.ordrePayement.setBeneficiaire("-");
/*  98 */     this.ordrePayement.setDateOrdonnation(new Date());
/*     */     
/* 100 */     List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeLc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 101 */     if (!list.isEmpty()) {
/* 102 */       for (Boncommande bc : list) {
/* 103 */         if (bc.getMontantOrdonne() < bc.getNetapayer() + bc.getTva() + bc.getTotalair()) {
/* 104 */           double diff = bc.getNetapayer() + bc.getTva() + bc.getTotalair() - bc.getMontantOrdonne();
/* 105 */           if (diff > 400.0D) {
/* 106 */             this.boncommandes.add(bc);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 111 */     initBon();
/* 112 */     RequestContext.getCurrentInstance().execute("PF('OrdrePayementCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void updateMontantEnLettre() {
/*     */     try {
/* 117 */       if (this.ordrePayement.getMontant() != null && this.ordrePayement.getMontant().doubleValue() > 0.0D) {
/* 118 */         String montantEnLettre = Convert.FR("" + this.ordrePayement.getMontant().intValue());
/* 119 */         this.ordrePayement.setMontantEnLettre(montantEnLettre);
/*     */       } else {
/* 121 */         this.ordrePayement.setMontant(Double.valueOf(0.0D));
/* 122 */         this.ordrePayement.setMontantEnLettre("-");
/*     */       } 
/* 124 */     } catch (Exception e) {
/* 125 */       this.ordrePayement.setMontant(Double.valueOf(0.0D));
/* 126 */       this.ordrePayement.setMontantEnLettre("-");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void save() {
/*     */     try {
/* 133 */       if ("Create".equals(this.mode))
/*     */       {
/* 135 */         if (this.ordrePayement.getMontant().doubleValue() <= 0.0D) {
/* 136 */           JsfUtil.addWarningMessage("Veuillez saisir une quantité positive");
/*     */           
/*     */           return;
/*     */         } 
/* 140 */         if (this.modeOp == 1) {
/* 141 */           double somme = this.boncommande.getNapOrdonne() + this.ordrePayement.getMontant().doubleValue();
/* 142 */           somme -= this.boncommande.getNetapayer();
/* 143 */           if (somme > 500.0D) {
/* 144 */             JsfUtil.addErrorMessage("Montant NAP Excessivement supérieur au montant réquis");
/*     */             return;
/*     */           } 
/*     */         } else {
/* 148 */           double somme = this.boncommande.getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue();
/* 149 */           somme -= this.boncommande.getTva() + this.boncommande.getTotalair();
/* 150 */           if (somme > 500.0D) {
/* 151 */             JsfUtil.addErrorMessage("Montant Des Taxes Excessivement supérieur au montant réquis");
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/* 156 */         Moyens moyens = this.boncommande.getMoyens();
/*     */         
/* 158 */         moyens.setMontantOrdonne(moyens.getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 159 */         moyens.getIdtache().setMontantOrdonne(moyens.getIdtache().getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */         
/* 161 */         if (this.modeOp == 1) {
/* 162 */           this.ordrePayement.setNap(true);
/* 163 */           this.ordrePayement.setTaxe(false);
/* 164 */           this.boncommande.setMontantOrdonne(this.boncommande.getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 165 */           this.boncommande.setNapOrdonne(this.boncommande.getNapOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */           
/* 167 */           moyens.setNapOrdonne(moyens.getNapOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 168 */           moyens.getIdtache().setNapOrdonne(moyens.getIdtache().getNapOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */         } else {
/* 170 */           this.ordrePayement.setNap(false);
/* 171 */           this.ordrePayement.setTaxe(true);
/* 172 */           this.boncommande.setMontantOrdonne(this.boncommande.getMontantOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 173 */           this.boncommande.setTaxeOrdonne(this.boncommande.getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */           
/* 175 */           moyens.setTaxeOrdonne(moyens.getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue());
/* 176 */           moyens.getIdtache().setTaxeOrdonne(moyens.getIdtache().getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue());
/*     */         } 
/*     */         
/* 179 */         this.moyensFacadeLocal.edit(moyens);
/* 180 */         this.tacheFacadeLocal.edit(moyens.getIdtache());
/*     */         
/* 182 */         this.ordrePayement.setIdOrdrePayement(Long.valueOf(this.ordrePayementFacadeLocal.nextId()));
/* 183 */         this.ordrePayement.setBoncommande(this.boncommande);
/* 184 */         this.ordrePayement.setCode(Utilitaires.generateOPNumero(this.ordrePayementFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), "" + SessionMBean.getAnnee().getNom()));
/* 185 */         this.ordrePayementFacadeLocal.create(this.ordrePayement);
/*     */         
/* 187 */         this.boncommandeFacadeLocal.edit(this.boncommande);
/*     */         
/* 189 */         this.boncommande = new Boncommande();
/* 190 */         this.detail = true;
/* 191 */         RequestContext.getCurrentInstance().execute("PF('OrdrePayementCreateDialog').hide()");
/* 192 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       }
/*     */     
/* 195 */     } catch (Exception e) {
/* 196 */       e.printStackTrace();
/* 197 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 204 */       if (this.ordrePayement != null) {
/*     */         
/* 206 */         if (!Utilitaires.isAccess(Long.valueOf(33L))) {
/* 207 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler un engagement de salaire");
/*     */           
/*     */           return;
/*     */         } 
/* 211 */         if (this.ordrePayement.getBoncommande().isPaye()) {
/* 212 */           JsfUtil.addErrorMessage("Ce bon de commandé est dejà payé");
/*     */           
/*     */           return;
/*     */         } 
/* 216 */         this.ordrePayementFacadeLocal.remove(this.ordrePayement);
/*     */         
/* 218 */         Boncommande bc = this.ordrePayement.getBoncommande();
/* 219 */         Moyens m = bc.getMoyens();
/* 220 */         Tache t = bc.getMoyens().getIdtache();
/*     */         
/* 222 */         if (this.ordrePayement.isNap()) {
/* 223 */           bc.setNapOrdonne(bc.getNapOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 224 */           m.setNapOrdonne(m.getNapOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 225 */           t.setNapOrdonne(t.getNapOrdonne() - this.ordrePayement.getMontant().doubleValue());
/*     */         } else {
/* 227 */           bc.setTaxeOrdonne(bc.getTaxeOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 228 */           m.setTaxeOrdonne(m.getTaxeOrdonne() - this.ordrePayement.getMontant().doubleValue());
/* 229 */           t.setTaxeOrdonne(t.getTaxeOrdonne() - this.ordrePayement.getMontant().doubleValue());
/*     */         } 
/*     */         
/* 232 */         this.boncommandeFacadeLocal.edit(bc);
/* 233 */         this.moyensFacadeLocal.edit(m);
/* 234 */         this.tacheFacadeLocal.edit(t);
/*     */         
/* 236 */         this.detail = true;
/* 237 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 239 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 241 */     } catch (Exception e) {
/* 242 */       e.printStackTrace();
/* 243 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 249 */       initBon();
/* 250 */       if (this.idBonCommande != 0L) {
/* 251 */         this.boncommande = this.boncommandeFacadeLocal.find(Long.valueOf(this.idBonCommande));
/* 252 */         if (this.boncommande.isCheque()) {
/* 253 */           this.ordrePayement.setModePaiement("Chèque");
/*     */         }
/* 255 */         if (this.boncommande.isVirement()) {
/* 256 */           this.ordrePayement.setModePaiement("Virement");
/*     */         }
/*     */         
/* 259 */         if (this.boncommande.isEspece()) {
/* 260 */           this.ordrePayement.setModePaiement("Espèce");
/*     */         }
/* 262 */         this.ordrePayement.setPieces(" - LETTRE COMMANDE N° : " + this.boncommande.getCode() + "\n - Ref : " + this.boncommande.getReference() + "\n - DOSSIER FISCAL");
/* 263 */         updateModeOp();
/*     */       } 
/* 265 */     } catch (Exception e) {
/* 266 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateModeOp() {
/* 271 */     if (this.boncommande.getIdboncommande() != null) {
/* 272 */       if (this.modeOp == 1) {
/* 273 */         if (this.boncommande.getNapOrdonne() > 0.0D) {
/* 274 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getNetapayer() - this.boncommande.getMontantOrdonne()));
/*     */         } else {
/* 276 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getNetapayer()));
/*     */         } 
/* 278 */         this.ordrePayement.setBeneficiaire(this.boncommande.getSociete().getNom());
/*     */       } else {
/*     */         
/* 281 */         if (this.boncommande.getTaxeOrdonne() > 0.0D) {
/* 282 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getTva() + this.boncommande.getTotalair() - this.boncommande.getTaxeOrdonne()));
/*     */         } else {
/* 284 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getTotalair() + this.boncommande.getTva()));
/*     */         } 
/* 286 */         this.ordrePayement.setBeneficiaire("TRESOR PUBLIC");
/*     */       } 
/* 288 */       if (this.ordrePayement.getMontant().doubleValue() < 0.0D) {
/* 289 */         this.ordrePayement.setMontant(Double.valueOf(0.0D));
/*     */       }
/* 291 */       this.ordrePayement.setMontantEnLettre(Convert.FR("" + this.ordrePayement.getMontant()));
/* 292 */       updateObjetPaiement();
/*     */     } else {
/* 294 */       this.ordrePayement.setMontant(Double.valueOf(0.0D));
/* 295 */       this.ordrePayement.setMontantEnLettre("-");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateObjetPaiement() {
/* 300 */     if (this.modeOp == 1) {
/* 301 */       this.ordrePayement.setObjet("Facture n° " + this.boncommande.getReference() + " de " + this.boncommande.getSociete().getNom() + " rélative à : " + this.boncommande.getObjet());
/*     */     } else {
/* 303 */       this.ordrePayement.setObjet("PAIEMENT DES IMPOTS (AIR ET TVA) Rélative à la n° " + this.boncommande.getReference() + " de " + this.boncommande.getSociete().getNom() + " rélative à : " + this.boncommande.getObjet());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printCe() {
/*     */     try {
/* 309 */       if (!Utilitaires.isAccess(Long.valueOf(18L))) {
/* 310 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engament");
/*     */         
/*     */         return;
/*     */       } 
/* 314 */       Map<Object, Object> parameter = new HashMap<>();
/* 315 */       parameter.put("idOp", this.ordrePayement.getIdOrdrePayement());
/* 316 */       Printer p = new Printer();
/*     */       
/* 318 */       if (this.ordrePayement.isNap()) {
/* 319 */         p.print("/rapport/report_camer_soft/op_nap.jasper", parameter);
/*     */       } else {
/* 321 */         p.print("/rapport/report_camer_soft/op_taxes.jasper", parameter);
/*     */       } 
/* 323 */     } catch (Exception e) {
/* 324 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 329 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 333 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 337 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 341 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 345 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 349 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 353 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 357 */     return this.mode;
/*     */   }
/*     */   
/*     */   public List<OrdrePayement> getOrdrePayements() {
/* 361 */     this.ordrePayements = this.ordrePayementFacadeLocal.findAllLc(SessionMBean.getBudget().getIdbudget().intValue());
/* 362 */     return this.ordrePayements;
/*     */   }
/*     */   
/*     */   public long getIdBonCommande() {
/* 366 */     return this.idBonCommande;
/*     */   }
/*     */   
/*     */   public void setIdBonCommande(long idBonCommande) {
/* 370 */     this.idBonCommande = idBonCommande;
/*     */   }
/*     */   
/*     */   public int getModeOp() {
/* 374 */     return this.modeOp;
/*     */   }
/*     */   
/*     */   public void setModeOp(int modeOp) {
/* 378 */     this.modeOp = modeOp;
/*     */   }
/*     */   
/*     */   public OrdrePayement getOrdrePayement() {
/* 382 */     return this.ordrePayement;
/*     */   }
/*     */   
/*     */   public void setOrdrePayement(OrdrePayement ordrePayement) {
/* 386 */     this.ordrePayement = ordrePayement;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\OrdrePayementLcController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */