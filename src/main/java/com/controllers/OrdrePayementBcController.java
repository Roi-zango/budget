/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Boncommande;
/*     */ import entities.Imputation;
/*     */ import entities.OrdrePayement;
/*     */ import entities.Signataire;
/*     */ import entities.Structure;
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
/*     */ public class OrdrePayementBcController
/*     */   implements Serializable
/*     */ {
/*     */   @Resource
/*     */   private UserTransaction ut;
/*     */   @EJB
/*     */   private OrdrePayementFacadeLocal ordrePayementFacadeLocal;
/*  50 */   private OrdrePayement ordrePayement = new OrdrePayement();
/*  51 */   private List<OrdrePayement> ordrePayements = new ArrayList<>();
/*     */   
/*     */   private long idBonCommande;
/*     */   
/*     */   private int modeOp;
/*     */   @EJB
/*     */   private BoncommandeFacadeLocal boncommandeFacadeLocal;
/*  58 */   private Boncommande boncommande = new Boncommande();
/*  59 */   private List<Boncommande> boncommandes = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private MoyensFacadeLocal moyensFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private TacheFacadeLocal tacheFacadeLocal;
/*     */   
/*  67 */   private String mode = "";
/*     */   private boolean detail = true;
/*  69 */   private String typeFiltre = "BC";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   private void initBon() {
/*  77 */     this.boncommande = new Boncommande();
/*  78 */     this.boncommande.setStructure(new Structure());
/*  79 */     this.boncommande.setImputation(new Imputation());
/*  80 */     this.boncommande.setSignataire(new Signataire());
/*  81 */     this.boncommande.setTtc(Double.valueOf(0.0D));
/*  82 */     this.boncommande.setTva(0.0D);
/*  83 */     this.boncommande.setNetapayer(0.0D);
/*  84 */     this.boncommande.setTotalair(0.0D);
/*     */   }
/*     */   
/*     */   public void prepareCreate() {
/*  88 */     if (!Utilitaires.isAccess(Long.valueOf(35L))) {
/*  89 */       JsfUtil.addErrorMessage("Vous n'avez pas le droit d'etablir un ordre de payement");
/*     */       
/*     */       return;
/*     */     } 
/*  93 */     this.modeOp = 1;
/*  94 */     this.mode = "Create";
/*  95 */     this.typeFiltre = "Tout";
/*  96 */     this.ordrePayement = new OrdrePayement();
/*  97 */     this.ordrePayement.setBeneficiaire("-");
/*  98 */     this.ordrePayement.setDateOrdonnation(new Date());
/*     */     
/* 100 */     List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 101 */     this.boncommandes = filterBon(list);
/* 102 */     initBon();
/* 103 */     RequestContext.getCurrentInstance().execute("PF('OrdrePayementCreateDialog').show()");
/*     */   }
/*     */   
/*     */   private List<Boncommande> filterBon(List<Boncommande> list) {
/* 107 */     List<Boncommande> results = new ArrayList<>();
/* 108 */     for (Boncommande bc : list) {
/* 109 */       if (bc.getMontantOrdonne() < bc.getNetapayer() + bc.getTva() + bc.getTotalair()) {
/* 110 */         double diff = bc.getNetapayer() + bc.getTva() + bc.getTotalair() - bc.getMontantOrdonne();
/* 111 */         if (diff > 400.0D) {
/* 112 */           results.add(bc);
/*     */         }
/*     */       } 
/*     */     } 
/* 116 */     return results;
/*     */   }
/*     */   
/*     */   public void updateMontantEnLettre() {
/*     */     try {
/* 121 */       if (this.ordrePayement.getMontant() != null && this.ordrePayement.getMontant().doubleValue() > 0.0D) {
/* 122 */         String montantEnLettre = Convert.FR("" + this.ordrePayement.getMontant().intValue());
/* 123 */         this.ordrePayement.setMontantEnLettre(montantEnLettre);
/*     */       } else {
/* 125 */         this.ordrePayement.setMontant(Double.valueOf(0.0D));
/* 126 */         this.ordrePayement.setMontantEnLettre("-");
/*     */       } 
/* 128 */     } catch (Exception e) {
/* 129 */       this.ordrePayement.setMontant(Double.valueOf(0.0D));
/* 130 */       this.ordrePayement.setMontantEnLettre("-");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateDataType() {
/* 136 */     if (this.typeFiltre.equals("Tout")) {
/* 137 */       List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeValidated(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 138 */       this.boncommandes = filterBon(list);
/*     */     } 
/*     */     
/* 141 */     if (this.typeFiltre.equals("BC")) {
/* 142 */       List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeBc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 143 */       this.boncommandes = filterBon(list);
/*     */     } 
/*     */     
/* 146 */     if (this.typeFiltre.equals("LC")) {
/* 147 */       List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeLc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 148 */       this.boncommandes = filterBon(list);
/*     */     } 
/*     */     
/* 151 */     if (this.typeFiltre.equals("DEC")) {
/* 152 */       List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeDec(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 153 */       this.boncommandes = filterBon(list);
/*     */     } 
/*     */     
/* 156 */     if (this.typeFiltre.equals("SAL")) {
/* 157 */       List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeSal(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 158 */       this.boncommandes = filterBon(list);
/*     */     } 
/*     */     
/* 161 */     if (this.typeFiltre.equals("MIS")) {
/* 162 */       List<Boncommande> list = this.boncommandeFacadeLocal.findByIdAnneeMis(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget().intValue(), true);
/* 163 */       this.boncommandes = filterBon(list);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void save() {
/*     */     try {
/* 170 */       if ("Create".equals(this.mode))
/*     */       {
/* 172 */         if (this.ordrePayement.getMontant().doubleValue() <= 0.0D) {
/* 173 */           JsfUtil.addWarningMessage("Veuillez saisir une quantité positive");
/*     */           
/*     */           return;
/*     */         } 
/* 177 */         if (this.modeOp == 1) {
/* 178 */           double somme = this.boncommande.getNapOrdonne() + this.ordrePayement.getMontant().doubleValue();
/* 179 */           somme -= this.boncommande.getNetapayer();
/* 180 */           if (somme > 500.0D) {
/* 181 */             JsfUtil.addErrorMessage("Montant NAP Excessivement supérieur au montant réquis");
/*     */             return;
/*     */           } 
/*     */         } else {
/* 185 */           double somme = this.boncommande.getTaxeOrdonne() + this.ordrePayement.getMontant().doubleValue();
/* 186 */           somme -= this.boncommande.getTva() + this.boncommande.getTotalair();
/* 187 */           if (somme > 500.0D) {
/* 188 */             JsfUtil.addErrorMessage("Montant Des Taxes Excessivement supérieur au montant réquis");
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/* 193 */         if (this.modeOp == 1) {
/* 194 */           this.ordrePayement.setNap(true);
/* 195 */           this.ordrePayement.setTaxe(false);
/*     */         } else {
/* 197 */           this.ordrePayement.setNap(false);
/* 198 */           this.ordrePayement.setTaxe(true);
/*     */         } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 226 */         this.ordrePayement.setIdOrdrePayement(Long.valueOf(this.ordrePayementFacadeLocal.nextId()));
/* 227 */         this.ordrePayement.setBoncommande(this.boncommande);
/* 228 */         this.ordrePayement.setCode(Utilitaires.generateOPNumero(this.ordrePayementFacadeLocal, SessionMBean.getBudget().getIdbudget().intValue(), "" + SessionMBean.getAnnee().getNom()));
/* 229 */         this.ordrePayementFacadeLocal.create(this.ordrePayement);
/*     */ 
/*     */         
/* 232 */         this.boncommande = new Boncommande();
/* 233 */         this.detail = true;
/* 234 */         RequestContext.getCurrentInstance().execute("PF('OrdrePayementCreateDialog').hide()");
/* 235 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       }
/*     */     
/* 238 */     } catch (Exception e) {
/* 239 */       e.printStackTrace();
/* 240 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public void delete() {
/*     */     try {
/* 247 */       if (this.ordrePayement != null) {
/*     */         
/* 249 */         if (!Utilitaires.isAccess(Long.valueOf(36L))) {
/* 250 */           JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler un ordre de paiement");
/*     */           
/*     */           return;
/*     */         } 
/* 254 */         if (this.ordrePayement.getBoncommande().isPaye()) {
/* 255 */           JsfUtil.addErrorMessage("Ce bon de commandé est dejà payé");
/*     */           
/*     */           return;
/*     */         } 
/* 259 */         if (this.ordrePayement.isEtat()) {
/* 260 */           JsfUtil.addErrorMessage("Cette ordre de paiement est deja validé");
/*     */           
/*     */           return;
/*     */         } 
/* 264 */         this.ordrePayementFacadeLocal.remove(this.ordrePayement);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 283 */         this.detail = true;
/* 284 */         JsfUtil.addSuccessMessage("Opération réussie");
/*     */       } else {
/* 286 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 288 */     } catch (Exception e) {
/* 289 */       e.printStackTrace();
/* 290 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateData() {
/*     */     try {
/* 296 */       initBon();
/* 297 */       if (this.idBonCommande != 0L) {
/* 298 */         this.boncommande = this.boncommandeFacadeLocal.find(Long.valueOf(this.idBonCommande));
/* 299 */         if (this.boncommande.isCheque()) {
/* 300 */           this.ordrePayement.setModePaiement("Chèque");
/*     */         }
/* 302 */         if (this.boncommande.isVirement()) {
/* 303 */           this.ordrePayement.setModePaiement("Virement");
/*     */         }
/*     */         
/* 306 */         if (this.boncommande.isEspece()) {
/* 307 */           this.ordrePayement.setModePaiement("Espèce");
/*     */         }
/* 309 */         this.ordrePayement.setPieces("BON DE COMMANDE N° : " + this.boncommande.getCode() + "\nRef : " + this.boncommande.getReference() + "\nDOSSIER FISCAL");
/* 310 */         updateModeOp();
/*     */       } 
/* 312 */     } catch (Exception e) {
/* 313 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateModeOp() {
/* 318 */     if (this.boncommande.getIdboncommande() != null) {
/* 319 */       if (this.modeOp == 1) {
/* 320 */         if (this.boncommande.getNapOrdonne() > 0.0D) {
/* 321 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getNetapayer() - this.boncommande.getMontantOrdonne()));
/*     */         } else {
/* 323 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getNetapayer()));
/*     */         } 
/* 325 */         this.ordrePayement.setBeneficiaire(this.boncommande.getSociete().getNom());
/*     */       } else {
/*     */         
/* 328 */         if (this.boncommande.getTaxeOrdonne() > 0.0D) {
/* 329 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getTva() + this.boncommande.getTotalair() - this.boncommande.getTaxeOrdonne()));
/*     */         } else {
/* 331 */           this.ordrePayement.setMontant(Double.valueOf(this.boncommande.getTotalair() + this.boncommande.getTva()));
/*     */         } 
/* 333 */         this.ordrePayement.setBeneficiaire("TRESOR PUBLIC");
/*     */       } 
/* 335 */       if (this.ordrePayement.getMontant().doubleValue() < 0.0D) {
/* 336 */         this.ordrePayement.setMontant(Double.valueOf(0.0D));
/*     */       }
/* 338 */       this.ordrePayement.setMontantEnLettre(Convert.FR("" + this.ordrePayement.getMontant().intValue()));
/* 339 */       updateObjetPaiement();
/*     */     } else {
/* 341 */       this.ordrePayement.setMontant(Double.valueOf(0.0D));
/* 342 */       this.ordrePayement.setMontantEnLettre("-");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateObjetPaiement() {
/* 347 */     if (this.modeOp == 1) {
/* 348 */       this.ordrePayement.setObjet("Facture n° " + this.boncommande.getReference() + " de " + this.boncommande.getSociete().getNom() + " rélative à : " + this.boncommande.getObjet());
/*     */     } else {
/* 350 */       this.ordrePayement.setObjet("PAIEMENT DES IMPOTS (AIR ET TVA) Rélative à la n° " + this.boncommande.getReference() + " de " + this.boncommande.getSociete().getNom() + " rélative à : " + this.boncommande.getObjet());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printOp() {
/*     */     try {
/* 356 */       if (!Utilitaires.isAccess(Long.valueOf(38L))) {
/* 357 */         JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un ordre de paiement");
/*     */         
/*     */         return;
/*     */       } 
/* 361 */       Map<Object, Object> parameter = new HashMap<>();
/* 362 */       parameter.put("idOp", this.ordrePayement.getIdOrdrePayement());
/* 363 */       parameter.put("logo", SessionMBean.getLogo());
/* 364 */       Printer p = new Printer();
/*     */       
/* 366 */       if (this.ordrePayement.isNap()) {
/* 367 */         p.print("/rapport/report_camer_soft/op_nap.jasper", parameter);
/*     */       } else {
/* 369 */         p.print("/rapport/report_camer_soft/op_taxes.jasper", parameter);
/*     */       } 
/* 371 */     } catch (Exception e) {
/* 372 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 377 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 381 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 385 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 389 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Boncommande getBoncommande() {
/* 393 */     return this.boncommande;
/*     */   }
/*     */   
/*     */   public void setBoncommande(Boncommande boncommande) {
/* 397 */     this.boncommande = boncommande;
/*     */   }
/*     */   
/*     */   public List<Boncommande> getBoncommandes() {
/* 401 */     return this.boncommandes;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 405 */     return this.mode;
/*     */   }
/*     */   
/*     */   public List<OrdrePayement> getOrdrePayements() {
/* 409 */     this.ordrePayements = this.ordrePayementFacadeLocal.findAll(SessionMBean.getInstitution().getIdinstitution().longValue(), SessionMBean.getBudget().getIdbudget().intValue());
/* 410 */     return this.ordrePayements;
/*     */   }
/*     */   
/*     */   public long getIdBonCommande() {
/* 414 */     return this.idBonCommande;
/*     */   }
/*     */   
/*     */   public void setIdBonCommande(long idBonCommande) {
/* 418 */     this.idBonCommande = idBonCommande;
/*     */   }
/*     */   
/*     */   public int getModeOp() {
/* 422 */     return this.modeOp;
/*     */   }
/*     */   
/*     */   public void setModeOp(int modeOp) {
/* 426 */     this.modeOp = modeOp;
/*     */   }
/*     */   
/*     */   public OrdrePayement getOrdrePayement() {
/* 430 */     return this.ordrePayement;
/*     */   }
/*     */   
/*     */   public void setOrdrePayement(OrdrePayement ordrePayement) {
/* 434 */     this.ordrePayement = ordrePayement;
/*     */   }
/*     */   
/*     */   public String getTypeFiltre() {
/* 438 */     return this.typeFiltre;
/*     */   }
/*     */   
/*     */   public void setTypeFiltre(String typeFiltre) {
/* 442 */     this.typeFiltre = typeFiltre;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\OrdrePayementBcController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */