/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.util.JsfUtil;
import controllers.util.SessionMBean;
import entities.Boncommande;
import entities.Elementcout;
import entities.Imputation;
import entities.Ligneboncommande;
import entities.Moyens;
import entities.Rubriquemercurial;
import entities.Signataire;
import entities.Societe;
import entities.Sousrubriquemercurial;
import entities.Structure;
import entities.Tache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import org.primefaces.context.RequestContext;
import sessions.BoncommandeFacadeLocal;
import sessions.ElementcoutFacadeLocal;
import sessions.ImputationFacadeLocal;
import sessions.LigneboncommandeFacadeLocal;
import sessions.MoyensFacadeLocal;
import sessions.RubriquemercurialFacadeLocal;
import sessions.SignataireFacadeLocal;
import sessions.SocieteFacadeLocal;
import sessions.SousrubriquemercurialFacadeLocal;
import sessions.StructureFacadeLocal;
import sessions.TacheFacadeLocal;
import utilitaire.Convert;
import utilitaire.Printer;
import utilitaire.Utilitaires;

/**
 *
 * @author kenne
 */
@ManagedBean
@ViewScoped
public class BoncommandeController implements Serializable {

    @Resource
    private UserTransaction ut;

    @EJB
    private BoncommandeFacadeLocal boncommandeFacadeLocal;
    private Boncommande boncommande = new Boncommande();
    private List<Boncommande> boncommandes = new ArrayList<>();

    @EJB
    private LigneboncommandeFacadeLocal ligneboncommandeFacadeLocal;
    private List<Ligneboncommande> ligneboncommandes = new ArrayList<>();

    @EJB
    private ElementcoutFacadeLocal elementcoutFacadeLocal;
    private List<Elementcout> elementcouts = new ArrayList<>();
    private List<Elementcout> selectedElementcouts = new ArrayList<>();

    @EJB
    private SignataireFacadeLocal signataireFacadeLocal;
    private Signataire signataire = new Signataire();
    private List<Signataire> signataires = new ArrayList<>();

    @EJB
    private StructureFacadeLocal structureFacadeLocal;
    private Structure structure = new Structure();
    private List<Structure> structures = new ArrayList<>();

    @EJB
    private ImputationFacadeLocal imputationFacadeLocal;
    private Imputation imputation = new Imputation();
    private List<Imputation> imputations = new ArrayList<>();

    @EJB
    private SocieteFacadeLocal societeFacadeLocal;
    private Societe societe = new Societe();
    private List<Societe> societes = new ArrayList<>();

    @EJB
    protected TacheFacadeLocal tacheFacadeLocal;
    protected Tache tache = new Tache();
    protected List<Tache> taches = new ArrayList<>();

    @EJB
    protected MoyensFacadeLocal moyensFacadeLocal;
    protected Moyens moyens = new Moyens();
    protected List<Moyens> moyenses = new ArrayList<>();

    @EJB
    private SousrubriquemercurialFacadeLocal sousrubriquemercurialFacadeLocal;
    private Sousrubriquemercurial sousrubriquemercurial = new Sousrubriquemercurial();
    private List<Sousrubriquemercurial> sousrubriquemercurials = new ArrayList<>();

    @EJB
    private RubriquemercurialFacadeLocal rubriquemercurialFacadeLocal;
    private Rubriquemercurial rubriquemercurial = new Rubriquemercurial();
    private List<Rubriquemercurial> rubriquemercurials = new ArrayList<>();

    private String mode = "";
    private List<String> notif = new ArrayList<>();
    private boolean renderedNotif = false;
    private long idboncommande;
    private String codeBonCommande;

    private boolean detail = true;

    public BoncommandeController() {

    }

    @PostConstruct
    private void load() {
        boncommandes.clear();
        boncommandes.addAll(boncommandeFacadeLocal.findByIdAnneeBc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget()));
        elementcouts = elementcoutFacadeLocal.findAllRange();
    }

    private void initBoncommande() {
        imputation = new Imputation();
        boncommande = new Boncommande();
        boncommande.setAvance(0);
        boncommande.setTotalht(0);
        boncommande.setTotalair(0);
        boncommande.setMontantenlettre("-");
        boncommande.setReference("-");

        boncommande.setCoefficientreducteur(SessionMBean.getParametrage().getPourcentagemercurial());
        boncommande.setDelailivraison(15);
        boncommande.setVerif(false);
        boncommande.setNombreverif(0);
        boncommande.setValide(false);
        boncommande.setEngage(true);

        boncommande.setBc(true);
        boncommande.setMission(false);
        boncommande.setLettrecommande(false);
        boncommande.setDecision(false);
        boncommande.setGreAgre(false);
        boncommande.setSalaire(false);
    }

    public void prepareCreate() {
        if (SessionMBean.getBudget() != null) {

            if (!Utilitaires.isAccess(16l)) {
                JsfUtil.addErrorMessage("Vous n'avez pas le droit d'établir un bon de commande");
                return;
            }

            mode = "Create";
            ligneboncommandes.clear();
            notif.clear();
            taches.clear();
            moyenses.clear();
            moyens = new Moyens();
            tache = new Tache();
            societe = new Societe();
            signataire = new Signataire();
            structure = new Structure();

            this.initBoncommande();

            boncommande.setImputations("-");

            boncommande.setEspece(false);
            boncommande.setVirement(true);
            boncommande.setCheque(false);

            boncommande.setPaye(false);
            boncommande.setAttentepayement(false);
            codeBonCommande = Utilitaires.generateBCNumero(boncommandeFacadeLocal, SessionMBean.getBudget().getIdbudget(), SessionMBean.getAnnee().getNom());
            boncommande.setCode(codeBonCommande);

            if (SessionMBean.getParametrage() != null) {
                boncommande.setTauxtva(SessionMBean.getParametrage().getTauxtva());
                boncommande.setTauxair(SessionMBean.getParametrage().getTauxair());
            } else {
                boncommande.setTauxair(5.5);
                boncommande.setTauxtva(19.25);
            }

            RequestContext.getCurrentInstance().execute("PF('BoncommandeCreateDialog').show()");
        } else {
            JsfUtil.addWarningMessage("Aucune année budgetaire en session");
        }
    }

    public void prepareEdit() {
        if (boncommande != null) {

            if (!Utilitaires.isAccess(16l)) {
                JsfUtil.addErrorMessage("Vous n'avez pas le droit de modifier un bon de commande");
                return;
            }

            if (boncommande.isValide()) {
                JsfUtil.addWarningMessage("Operation impossible; Ce BC est deja validé");
                return;
            }

            taches.clear();
            moyenses.clear();

            structure = boncommande.getStructure();
            imputation = boncommande.getImputation();
            signataire = boncommande.getSignataire();
            societe = boncommande.getSociete();

            elementcouts = elementcoutFacadeLocal.findByIdimputation(imputation.getIdimputation());
            ligneboncommandes = ligneboncommandeFacadeLocal.findByIdBoncommande(boncommande.getIdboncommande());

            selectedElementcouts.clear();
            for (Ligneboncommande lbc : ligneboncommandes) {
                selectedElementcouts.add(lbc.getElementcout());
            }

            tache = boncommande.getMoyens().getIdtache();
            moyens = boncommande.getMoyens();

            taches.add(boncommande.getMoyens().getIdtache());
            moyenses.add(boncommande.getMoyens());
            mode = "Edit";
            RequestContext.getCurrentInstance().execute("PF('BoncommandeCreateDialog').show()");
        } else {
            JsfUtil.addFatalErrorMessage("Aucune ligne sélectionnée");
        }
    }

    public void updateDuplicationData() {
        if (idboncommande != 0) {
            Boncommande bc = boncommandeFacadeLocal.find(idboncommande);
            boncommande = new Boncommande();
            boncommande.setBc(true);
            boncommande.setIdboncommande(null);
            boncommande.setAttentepayement(false);
            boncommande.setAvance(0d);
            boncommande.setMontantPaye(0);
            boncommande.setReference("-");
            boncommande.setNombreverif(0);
            boncommande.setDateemission(null);
            boncommande.setMission(false);
            boncommande.setLiquide(false);
            boncommande.setVerif(false);
            boncommande.setValide(false);
            boncommande.setImputations(bc.getImputation().getCode() + " SITE 3");
            boncommande.setObjet(bc.getObjet());
            boncommande.setMontantenlettre(bc.getMontantenlettre());
            boncommande.setTauxair(bc.getTauxair());
            boncommande.setTauxtva(bc.getTauxtva());
            boncommande.setTotalair(bc.getTotalair());
            boncommande.setTotalht(bc.getTotalht());
            boncommande.setTtc(bc.getTtc());
            boncommande.setTva(bc.getTva());
            boncommande.setNetapayer(bc.getNetapayer());
            boncommande.setDelailivraison(bc.getDelailivraison());
            imputation = bc.getImputation();
            structure = bc.getStructure();
            societe = bc.getSociete();
            signataire = bc.getSignataire();
            taches.clear();
            moyenses.clear();
            tache = bc.getMoyens().getIdtache();
            moyens = bc.getMoyens();

            ligneboncommandes.clear();
            ligneboncommandes.addAll(ligneboncommandeFacadeLocal.findByIdBoncommande(idboncommande));

            boncommande.setCode(codeBonCommande);
            for (int i = 0; i < ligneboncommandes.size(); i++) {
                ligneboncommandes.get(i).setIdligneboncommande(0l);
            }
            taches.add(bc.getMoyens().getIdtache());
            moyenses.add(bc.getMoyens());
        }
    }

    public void prepareAddElements() {
        //elementcouts.clear();

        /*if (imputation.getIdimputation() != null) {
         elementcouts = elementcoutFacadeLocal.findByIdimputation(imputation.getIdimputation());
         }*/
        RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').show()");
    }

    public void removeElement(Ligneboncommande l) {
        int i = 0;
        for (Ligneboncommande lbc : ligneboncommandes) {
            if (lbc.getElementcout().equals(l.getElementcout())) {
                if (l.getIdligneboncommande() != 0) {
                    ligneboncommandeFacadeLocal.remove(lbc);
                }
                ligneboncommandes.remove(i);
                break;
            }
            i++;
        }
        this.updateTotal();
    }

    public void addElement() {
        for (Elementcout e : selectedElementcouts) {
            if (!checkIfExistElementInLigne(e)) {
                Ligneboncommande l = new Ligneboncommande();
                l.setIdligneboncommande(0l);
                l.setElementcout(e);
                l.setPrixunitaire(0);
                l.setQuantite(0);
                l.setTotal(0);
                l.setPrixunitaire(e.getPrixunitaire());
                l.setPrixmercurial(e.getPrixunitaire());
                ligneboncommandes.add(l);
            }
        }

        RequestContext.getCurrentInstance().execute("PF('ElementcoutCreateDialog').hide()");
        JsfUtil.addSuccessMessage("Ajout avec succès");
    }

    private boolean checkIfExistElementInLigne(Elementcout elementcout) {
        boolean result = false;
        for (Ligneboncommande l : ligneboncommandes) {
            if (l.getElementcout().equals(elementcout)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void updateTotal() {
        double value_ht = 0;
        int i = 0;
        for (Ligneboncommande l : ligneboncommandes) {
            value_ht += l.getPrixunitaire() * l.getQuantite();
            ligneboncommandes.get(i).setTotal(l.getPrixunitaire() * l.getQuantite());
            i++;
        }

        boncommande.setTotalht(value_ht);
        boncommande.setTva((value_ht * boncommande.getTauxtva()) / 100);
        boncommande.setTotalair((value_ht * boncommande.getTauxair()) / 100);
        boncommande.setTtc(value_ht + boncommande.getTva());
        boncommande.setNetapayer(value_ht - boncommande.getTotalair());

        String montantEnLettre = Convert.FR("" + boncommande.getTtc().intValue());
        boncommande.setMontantenlettre(montantEnLettre);
    }

    public void updateSousRubiqueM() {
        try {
            sousrubriquemercurials.clear();
            elementcouts.clear();
            if (rubriquemercurial.getIdrubriquemercurial() != null) {
                sousrubriquemercurials = sousrubriquemercurialFacadeLocal.findByIdrubrique(rubriquemercurial.getIdrubriquemercurial());
                //elementcouts = elementcoutFacadeLocal.findByIdimputationIdrubrique(imputation.getIdimputation(), rubriquemercurial.getIdrubriquemercurial());
                elementcouts = elementcoutFacadeLocal.findByIdrubrique(rubriquemercurial.getIdrubriquemercurial());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateReference() {
        try {
            elementcouts.clear();
            if (sousrubriquemercurial.getIdsousrubriquemercurial() != null) {
                //elementcouts = elementcoutFacadeLocal.findByIdimputationIdsousrubrique(imputation.getIdimputation(), sousrubriquemercurial.getIdsousrubriquemercurial());               
                elementcouts = elementcoutFacadeLocal.findByIdsousrubrique(sousrubriquemercurial.getIdsousrubriquemercurial());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMP1() {
        if (boncommande.isCheque()) {
            boncommande.setVirement(false);
            boncommande.setEspece(false);
        }
        this.initModePayement();
    }

    public void updateMP2() {
        if (boncommande.isEspece()) {
            boncommande.setCheque(false);
            boncommande.setVirement(false);
        }
        this.initModePayement();
    }

    public void updateMP3() {
        if (boncommande.isVirement()) {
            boncommande.setCheque(false);
            boncommande.setEspece(false);
        }
        this.initModePayement();
    }

    private void initModePayement() {
        if (!boncommande.isCheque() && !boncommande.isVirement() && !boncommande.isEspece()) {
            boncommande.setVirement(true);
        }
    }

    private List<String> notifyChecking() {
        List<String> notifs = new ArrayList<>();
        int i = 0;
        for (Ligneboncommande lbc : ligneboncommandes) {
            double montant = lbc.getPrixunitaire();
            double pourcentage = (lbc.getElementcout().getPrixunitaire() * SessionMBean.getParametrage().getPourcentagemercurial()) / 100;
            if (lbc.getQuantite() == 0) {
                notifs.add("Ligne " + (i + 1) + " : Défaut de quantité ; ");
            } else {
                if (montant > lbc.getElementcout().getPrixunitaire()) {
                    double reste = montant - lbc.getElementcout().getPrixunitaire();
                    if (reste > pourcentage) {
                        notifs.add("Ligne " + (i + 1) + " : Le prix Maximal est : " + (lbc.getElementcout().getPrixunitaire() + pourcentage) + " ; ");
                    }
                } else if (montant < lbc.getElementcout().getPrixunitaire()) {
                    double reste = lbc.getElementcout().getPrixunitaire() - montant;
                    if (reste > pourcentage) {
                        notifs.add("Ligne " + (i + 1) + " : Le prix Minimal est : " + (lbc.getElementcout().getPrixunitaire() - pourcentage) + " ; ");
                    }
                }
            }
            i++;
        }
        return notifs;
    }

    @Transactional
    public void save() {
        try {
            if ("Create".equals(mode)) {

                renderedNotif = false;
                notif.clear();
                this.updateTotal();
                this.notif = this.notifyChecking();
                if (!notif.isEmpty()) {
                    renderedNotif = true;
                    JsfUtil.addWarningMessage("Les prix sont incorrects par rapport aux references mercuriales");
                    return;
                }

                if ((moyens.getMontantexecute() + boncommande.getTtc()) > moyens.getCt()) {
                    JsfUtil.addWarningMessage("Montant insuffisant pour engager ce bon de commande");
                    return;
                }

                if (boncommandeFacadeLocal.findByCode(structure.getIdstructure(), boncommande.getCode()) == null) {

                    boncommande.setIdboncommande(boncommandeFacadeLocal.nextId());
                    boncommande.setStructure(structure);
                    boncommande.setSignataire(signataire);
                    boncommande.setImputation(imputation);
                    boncommande.setBudget(SessionMBean.getBudget());
                    boncommande.setSociete(societe);
                    boncommande.setMoyens(moyens);
                    boncommande.setTaxeOrdonne(0);
                    boncommande.setNapOrdonne(0);
                    if (boncommande.getDelailivraison() > 0) {
                        boncommande.setDatelivraison(Utilitaires.addDayToDate(boncommande.getDateemission(), boncommande.getDelailivraison()));
                    }

                    boncommande.setEngage(true);
                    boncommandeFacadeLocal.create(boncommande);

                    for (Ligneboncommande lbc : ligneboncommandes) {
                        lbc.setIdligneboncommande(ligneboncommandeFacadeLocal.nextId());
                        lbc.setBoncommande(boncommande);
                        lbc.setReference(lbc.getElementcout().getCode());
                        lbc.setVerif(true);
                        ligneboncommandeFacadeLocal.create(lbc);
                    }

                    moyens.setMontantexecute(moyens.getMontantexecute() + boncommande.getTtc());
                    moyensFacadeLocal.edit(moyens);

                    moyens.getIdtache().setCpconsommee(moyens.getIdtache().getCpconsommee() + boncommande.getTtc());
                    moyens.getIdtache().setMontantengage(moyens.getIdtache().getMontantengage() + boncommande.getTtc());
                    tacheFacadeLocal.edit(moyens.getIdtache());

                    boncommande = new Boncommande();
                    signataire = new Signataire();
                    structure = new Structure();
                    detail = true;
                    RequestContext.getCurrentInstance().execute("PF('BoncommandeCreateDialog').hide()");
                    JsfUtil.addSuccessMessage("Opération réussie");
                    boncommandes.clear();
                    //this.load();
                    boncommandes.addAll(boncommandeFacadeLocal.findByIdAnneeBc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget()));
                } else {
                    JsfUtil.addErrorMessage("Un bon de commande ayant cette reference existe dejà");
                }
            } else if ("Edit".equals(mode)) {
                if (boncommande != null) {

                    this.updateTotal();

                    if (boncommande.getDelailivraison() > 0) {
                        boncommande.setDatelivraison(Utilitaires.addDayToDate(boncommande.getDateemission(), boncommande.getDelailivraison()));
                    }
                    boncommande.setSociete(societeFacadeLocal.find(societe.getIdsociete()));
                    boncommande.setSignataire(signataireFacadeLocal.find(signataire.getIdsignataire()));
                    boncommandeFacadeLocal.edit(boncommande);
                    for (Ligneboncommande lbc : ligneboncommandes) {
                        if (lbc.getIdligneboncommande() == 0l) {
                            lbc.setIdligneboncommande(ligneboncommandeFacadeLocal.nextId());
                            lbc.setBoncommande(boncommande);
                            lbc.setReference(lbc.getElementcout().getCode());
                            ligneboncommandeFacadeLocal.create(lbc);
                        } else {
                            ligneboncommandeFacadeLocal.edit(lbc);
                        }
                    }

                    Boncommande b = boncommandeFacadeLocal.find(boncommande.getIdboncommande());
                    if (b.getTtc() != boncommande.getTtc()) {
                        Moyens m = boncommande.getMoyens();
                        m.setMontantexecute((m.getMontantexecute() - b.getTtc()) + boncommande.getTtc());
                        moyensFacadeLocal.edit(m);

                        Tache t = boncommande.getMoyens().getIdtache();
                        t.setCpconsommee((t.getCpconsommee() - b.getTtc()) + boncommande.getTtc());
                        t.setMontantengage((t.getMontantengage() - b.getTtc()) + boncommande.getTtc());
                        tacheFacadeLocal.edit(t);
                    }

                    boncommande = new Boncommande();
                    signataire = new Signataire();
                    structure = new Structure();
                    detail = true;
                    boncommandes.addAll(boncommandeFacadeLocal.findByIdAnneeBc(SessionMBean.getInstitution().getIdinstitution(), SessionMBean.getBudget().getIdbudget()));
                    RequestContext.getCurrentInstance().execute("PF('BoncommandeCreateDialog').hide()");
                    //this.load();
                    JsfUtil.addSuccessMessage("Opération réussie");
                } else {
                    JsfUtil.addErrorMessage("Aucune ligne seletionnée");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.addFatalErrorMessage("Exception");
        }
    }

    @Transactional
    public void delete() {
        try {
            if (boncommande != null) {

                if (!Utilitaires.isAccess(17l)) {
                    JsfUtil.addErrorMessage("Vous n'avez pas le droit d'annuler un bon de commande");
                    return;
                }

                if (boncommande.isPaye()) {
                    JsfUtil.addErrorMessage("Bon de commande dejà payé");
                    return;
                }

                ligneboncommandeFacadeLocal.deleteByIdBoncommande(boncommande.getIdboncommande());
                boncommandeFacadeLocal.remove(boncommande);

                Moyens m = boncommande.getMoyens();
                m.setMontantexecute(m.getMontantexecute() - boncommande.getTtc());
                if (boncommande.isLiquide()) {
                    m.setMontantLiquide(m.getMontantLiquide() - boncommande.getTtc());
                }
                moyensFacadeLocal.edit(m);

                Tache t = boncommande.getMoyens().getIdtache();
                t.setCpconsommee(t.getCpconsommee() - boncommande.getTtc());
                t.setMontantengage(t.getMontantengage() - boncommande.getTtc());

                if (boncommande.isPaye()) {
                    t.setMontantpayettc(t.getMontantpayettc() - boncommande.getTtc());
                    t.setMontantpayeht(t.getMontantpayeht() - boncommande.getNetapayer());
                }
                tacheFacadeLocal.edit(t);

                boncommande = new Boncommande();
                detail = true;
                this.load();
                JsfUtil.addSuccessMessage("Opération réussie");
            } else {
                JsfUtil.addErrorMessage("Aucune ligne seletionnée");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.addFatalErrorMessage("Exception");
        }
    }

    public void updateTache() {
        try {
            if (structure.getIdstructure() != null) {
                taches.clear();
                imputation = new Imputation();
                moyenses.clear();
                moyens = new Moyens();
                taches = tacheFacadeLocal.findByStructureAnne(structure.getIdstructure(), SessionMBean.getAnnee().getIdannee());
                return;
            }
            JsfUtil.addWarningMessage("Veuillez selectionner une structure");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMoyens() {
        try {
            moyenses.clear();
            if (tache != null) {
                moyenses = moyensFacadeLocal.findByTache(tache.getIdtache());
                if (!moyenses.isEmpty()) {
                    if (moyenses.size() == 1) {
                        imputation = moyenses.get(0).getIdimputation();
                        boncommande.setImputations(imputation.getCode() + " SITE 3");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateImputationData() {
        if (moyens != null) {
            imputation = moyens.getIdimputation();
            boncommande.setImputations(imputation.getCode() + " SITE 3");
        }
    }

    public void print() {
        try {
            if (!Utilitaires.isAccess(18l)) {
                JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un bon d'engagement");
                return;
            }
            Map parameter = new HashMap();
            parameter.put("idboncommande", boncommande.getIdboncommande());
            parameter.put("logo", SessionMBean.getLogo());
            Printer p = new Printer();
            p.print("/rapport/report_camer_soft/bon_commande.jasper", parameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCe() {
        try {

            if (!Utilitaires.isAccess(18l)) {
                JsfUtil.addErrorMessage("Vous n'avez pas le droit d'imprimer un certificat d'engament");
                return;
            }

            Map parameter = new HashMap();
            parameter.put("idboncommande", boncommande.getIdboncommande());
            parameter.put("logo", SessionMBean.getLogo());
            Printer p = new Printer();
            p.print("/rapport/report_camer_soft/certificat_engagement.jasper", parameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void activeButton() {
        detail = false;
    }

    public void deactiveButton() {
        detail = true;
    }

    public boolean isDetail() {
        return detail;
    }

    public void setDetail(boolean detail) {
        this.detail = detail;
    }

    public Signataire getSignataire() {
        return signataire;
    }

    public void setSignataire(Signataire signataire) {
        this.signataire = signataire;
    }

    public List<Signataire> getSignataires() {
        signataires = signataireFacadeLocal.findByIdInstitution(SessionMBean.getInstitution().getIdinstitution());
        return signataires;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public List<Structure> getStructures() {
        structures = structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution(), "Actif");
        return structures;
    }

    public Boncommande getBoncommande() {
        return boncommande;
    }

    public void setBoncommande(Boncommande boncommande) {
        this.boncommande = boncommande;
    }

    public List<Boncommande> getBoncommandes() {
        return boncommandes;
    }

    public List<Ligneboncommande> getLigneboncommandes() {
        return ligneboncommandes;
    }

    public List<Elementcout> getElementcouts() {
        return elementcouts;
    }

    public List<Elementcout> getSelectedElementcouts() {
        return selectedElementcouts;
    }

    public void setSelectedElementcouts(List<Elementcout> selectedElementcouts) {
        this.selectedElementcouts = selectedElementcouts;
    }

    public Imputation getImputation() {
        return imputation;
    }

    public void setImputation(Imputation imputation) {
        this.imputation = imputation;
    }

    public List<Imputation> getImputations() {
        imputations = imputationFacadeLocal.findAllOrder();
        return imputations;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public List<Societe> getSocietes() {
        societes = societeFacadeLocal.findAllRange();
        return societes;
    }

    public String getMode() {
        return mode;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public Moyens getMoyens() {
        return moyens;
    }

    public void setMoyens(Moyens moyens) {
        this.moyens = moyens;
    }

    public List<Moyens> getMoyenses() {
        return moyenses;
    }

    public Sousrubriquemercurial getSousrubriquemercurial() {
        return sousrubriquemercurial;
    }

    public void setSousrubriquemercurial(Sousrubriquemercurial sousrubriquemercurial) {
        this.sousrubriquemercurial = sousrubriquemercurial;
    }

    public List<Sousrubriquemercurial> getSousrubriquemercurials() {
        return sousrubriquemercurials;
    }

    public Rubriquemercurial getRubriquemercurial() {
        return rubriquemercurial;
    }

    public void setRubriquemercurial(Rubriquemercurial rubriquemercurial) {
        this.rubriquemercurial = rubriquemercurial;
    }

    public List<Rubriquemercurial> getRubriquemercurials() {
        rubriquemercurials = rubriquemercurialFacadeLocal.findAllRange();
        return rubriquemercurials;
    }

    public List<String> getNotif() {
        return notif;
    }

    public boolean isRenderedNotif() {
        return renderedNotif;
    }

    public long getIdboncommande() {
        return idboncommande;
    }

    public void setIdboncommande(long idboncommande) {
        this.idboncommande = idboncommande;
    }

}
