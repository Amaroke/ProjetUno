package joueurs;

import cartes.Carte;
import uno.Uno;

import java.util.Iterator;

public class Bot extends Joueur {
    public Bot(Uno uno) {
        super(uno);
    }

    @Override
    public void jouer(String coup) {
        boolean leJoueurAJoue = false;
        for (Iterator<Carte> iterator = getMainDuJoueur().getPaquet().iterator(); iterator.hasNext(); ) {
            Carte carteActuelle = iterator.next();
            if (!leJoueurAJoue && getUno().getTalon().getSommet().peutEtreRecouverte(carteActuelle)) {
                leJoueurAJoue = true;
                getUno().getTalon().ajouter(carteActuelle);
                iterator.remove();
            }
        }
        if(!leJoueurAJoue) {
            getMainDuJoueur().getPaquet().add(getUno().getPioche().piocher());
            if (getUno().getTalon().getSommet().peutEtreRecouverte(getMainDuJoueur().getSommet())) {
                getUno().getTalon().ajouter(getMainDuJoueur().getPaquet().get(getMainDuJoueur().getNombreDeCartes()));
                getMainDuJoueur().getPaquet().remove(getMainDuJoueur().getNombreDeCartes());
            }
            else {
                getMainDuJoueur().ajouter(getUno().getPioche().piocher());
            }
        }
    }
}
