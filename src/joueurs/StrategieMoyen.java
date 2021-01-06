package joueurs;

import cartes.Carte;
import cartes.Couleur;
import cartes.PaquetDeCartes;
import uno.Uno;

import java.util.Random;

public class StrategieMoyen implements Strategie {

    @Override
    public void jouer(PaquetDeCartes pdc, Uno uno) {
        boolean leJoueurAJoue = false;
        for (int i = 0; i < pdc.getNombreDeCartes(); i++) {
            Carte carteActuelle = pdc.getPaquet().get(i);
            if (!leJoueurAJoue && uno.getTalon().getSommet().peutEtreRecouverte(carteActuelle)) {
                leJoueurAJoue = true;
                pdc.getPaquet().remove(i);
                uno.getTalon().ajouter(carteActuelle);
                if (carteActuelle.estSansCouleur()) {
                    Couleur[] tab = new Couleur[]{Couleur.JAUNE, Couleur.ROUGE, Couleur.VERT, Couleur.BLEU};
                    Random rand = new Random();
                    Couleur c = tab[rand.nextInt(4)];
                    uno.getTalon().getSommet().setCouleur(c);
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
