package joueurs;

import cartes.Carte;
import erreurs.CoupIncorrectException;
import uno.Uno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoueurHumain extends Joueur {

    public JoueurHumain(Uno uno) {
        super(uno);
    }

    @Override
    public void jouer(String coup) throws CoupIncorrectException {
        Matcher matcher = Pattern.compile("\\d+").matcher(coup);
        String nombre = "nonTrouve";
        int numeroCarteChoisie = -1;
        if (matcher.find()) {
            nombre = matcher.group(0);
            numeroCarteChoisie = Integer.parseInt(nombre);
        }
        if (coup.equals("p")) {
            Carte cartePiocher = getUno().getPioche().piocher();
            if (getUno().getTalon().getSommet().peutEtreRecouverte(cartePiocher)) {
                getUno().getTalon().ajouter(cartePiocher);
            } else {
                getMainDuJoueur().ajouter(cartePiocher);
            }
        } else {
            if (!nombre.equals("nonTrouve")) {
                Carte carteAJouer = carteChoisie(coup);
                getMainDuJoueur().getPaquet().remove(numeroCarteChoisie);
                carteAJouer.appliquerEffet();
                getUno().getTalon().ajouter(carteAJouer);
            } else {
                getUno().changerDeJoueur();
            }
        }
    }
}
