package joueurs;

import cartes.Carte;
import cartes.Couleur;
import cartes.PaquetDeCartes;
import uno.Uno;

public class StrategieFacile implements Strategie {

    @Override
    public void jouer(PaquetDeCartes pdc, Uno uno) {
        boolean leJoueurAJoue = false;
        int nbrouge = 0;
        int nbvert = 0;
        int nbjaune = 0;
        int nbbleue = 0;
        for (int i = 0; i < pdc.getNombreDeCartes(); i++) {
            if (pdc.getPaquet().get(i).getCouleur() == Couleur.BLEU) {
                nbbleue++;
            }
            if (pdc.getPaquet().get(i).getCouleur() == Couleur.ROUGE) {
                nbrouge++;
            }
            if (pdc.getPaquet().get(i).getCouleur() == Couleur.VERT) {
                nbvert++;
            }
            if (pdc.getPaquet().get(i).getCouleur() == Couleur.JAUNE) {
                nbjaune++;
            }
        }
        for (int i = 0; i < pdc.getNombreDeCartes(); i++) {
            Carte carteActuelle = pdc.getPaquet().get(i);
            if (!leJoueurAJoue && uno.getTalon().getSommet().peutEtreRecouverte(carteActuelle)) {
                leJoueurAJoue = true;
                pdc.getPaquet().remove(i);
                uno.getTalon().ajouter(carteActuelle);
                if (carteActuelle.estSansCouleur()) {
                    if (nbrouge <= nbbleue && nbrouge <= nbvert && nbrouge <= nbjaune) {
                        uno.getTalon().getSommet().setCouleur(Couleur.ROUGE);
                    } else if (nbvert <= nbbleue && nbvert <= nbrouge && nbvert <= nbjaune) {
                        uno.getTalon().getSommet().setCouleur(Couleur.VERT);
                    } else if (nbbleue <= nbrouge && nbbleue <= nbvert && nbbleue <= nbjaune) {
                        uno.getTalon().getSommet().setCouleur(Couleur.BLEU);
                    } else {
                        uno.getTalon().getSommet().setCouleur(Couleur.JAUNE);
                    }
                }
                uno.getTalon().getSommet().appliquerEffet();
            }
        }
        if (!leJoueurAJoue) {
            pdc.getPaquet().add(uno.getPioche().piocher());
            if (uno.getTalon().getSommet().peutEtreRecouverte(pdc.getSommet())) {
                pdc.getPaquet().remove(pdc.getNombreDeCartes() - 1);
            }
        }
    }
}

