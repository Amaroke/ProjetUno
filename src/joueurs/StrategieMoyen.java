package joueurs;

import cartes.Carte;
import cartes.PaquetDeCartes;
import uno.Uno;

public class StrategieMoyen implements Strategie {

    @Override
    public void jouer(PaquetDeCartes pdc, Uno uno) {
        boolean leJoueurAJoue = false;
        for (int i = 0; i < pdc.getNombreDeCartes(); i++ ) {
            Carte carteActuelle = pdc.getPaquet().get(i);
            if (!leJoueurAJoue && uno.getTalon().getSommet().peutEtreRecouverte(carteActuelle)) {
                leJoueurAJoue = true;
                uno.getTalon().ajouter(carteActuelle);
            }
        }
        if(!leJoueurAJoue) {
            pdc.getPaquet().add(uno.getPioche().piocher());
            if (uno.getTalon().getSommet().peutEtreRecouverte(pdc.getSommet())) {
                pdc.getPaquet().remove(pdc.getNombreDeCartes());
            }
            else {
                pdc.ajouter(uno.getPioche().piocher());
            }
        }
    }
}
