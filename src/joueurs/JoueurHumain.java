package joueurs;

import cartes.Carte;
import cartes.Couleur;
import erreurs.CoupIncorrectException;
import uno.Uno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoueurHumain extends Joueur {

    public JoueurHumain(Uno uno) {
        super(uno);
    }

    @Override
    public boolean estUnJoueurHumain() {
        return true;
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
        // Si le joueur indique p, on le fait piocher.
        if (coup.equals("p")) {
            Carte cartePiocher = getUno().getPioche().piocher();
            // Si la carte piocher peut-être joué on la joue.
            if (getUno().getTalon().getSommet().peutEtreRecouverte(cartePiocher)) {
                if (cartePiocher.effet() == 3 || cartePiocher.effet() == 6) {
                    switch (getUno().getDial().choisirCouleurCartePioche().charAt(0)) {
                        case 'r':
                            cartePiocher.setCouleur(Couleur.ROUGE);
                            break;
                        case 'v':
                            cartePiocher.setCouleur(Couleur.VERT);
                            break;
                        case 'b':
                            cartePiocher.setCouleur(Couleur.BLEU);
                            break;
                        case 'j':
                            cartePiocher.setCouleur(Couleur.JAUNE);
                            break;
                    }
                }
                getUno().getTalon().ajouter(cartePiocher);
                // Sinon on se contente de l'ajouter à notre main.
            } else {
                getMainDuJoueur().ajouter(cartePiocher);
            }
        } else {
            // Si on a indiqué une carte à jouer.
            if (!nombre.equals("nonTrouve")) {
                Carte carteAJouer = carteChoisie(coup);
                // Si elle peut-être joué.
                if (getUno().getTalon().getSommet().peutEtreRecouverte(carteAJouer)) {
                    getMainDuJoueur().getPaquet().remove(numeroCarteChoisie);
                    if (carteAJouer.effet() == 3 || carteAJouer.effet() == 6) {
                        switch (coup.charAt(1)) {
                            case 'r':
                                carteAJouer.setCouleur(Couleur.ROUGE);
                                break;
                            case 'v':
                                carteAJouer.setCouleur(Couleur.VERT);
                                break;
                            case 'b':
                                carteAJouer.setCouleur(Couleur.BLEU);
                                break;
                            case 'j':
                                carteAJouer.setCouleur(Couleur.JAUNE);
                                break;
                        }
                    }
                    getUno().getTalon().ajouter(carteAJouer);
                    getUno().getTalon().getSommet().appliquerEffet();
                }
                // Sinon déclencher l'exception coupIncorrect.
                else {
                    throw new CoupIncorrectException("La carte ne peut être joué sur le talon !");
                }
            }
            // Sinon on passe son tour.
        }
    }
}
