package joueurs;

import cartes.Carte;
import cartes.Couleur;
import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import erreurs.CoupIncorrectException;
import uno.Uno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Joueur {

    private final PaquetDeCartes mainDuJoueur;
    private final Uno uno;

    public Joueur(Uno uno) {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        mainDuJoueur = singleton.getPaquetVide();
        this.uno = uno;
    }

    public PaquetDeCartes getMainDuJoueur() {
        return mainDuJoueur;
    }

    public Uno getUno() {
        return uno;
    }

    public abstract void jouer(String coup);

    public Carte carteChoisie(String coup) throws CoupIncorrectException {
        Matcher matcher = Pattern.compile("\\d+").matcher(coup);
        String nombre;
        int numeroCarteChoisie;
        // On cherche un nombre
        if (matcher.find()) {
            nombre = matcher.group(0);
            numeroCarteChoisie = Integer.parseInt(nombre);
            // On vérifie le nombre
            if (numeroCarteChoisie > getMainDuJoueur().getNombreDeCartes()) {
                throw new CoupIncorrectException("Erreur, la carte n'existe pas.");
            }
        } else {
            throw new CoupIncorrectException("Erreur, pas d'entier dans le coup.");
        }
        coup = coup.replace(nombre, "");
        // On vérifie la couleur fournie
        if (coup.equals("v") || coup.equals("r") || coup.equals("b") || coup.equals("j")) {
            int typeDeCarteChoisie = getMainDuJoueur().getPaquet().get(numeroCarteChoisie).effet();
            // On vérifie qu'on donne une couleur à un Joker ou un Plus4
            if (!(typeDeCarteChoisie == 3 || typeDeCarteChoisie == 6)) {
                throw new CoupIncorrectException("Erreur, la carte ne prends pas de couleur.");
            } else {
                Carte carteARetourner = getMainDuJoueur().getPaquet().get(numeroCarteChoisie);
                switch (coup.charAt(0)) {
                    case 'v':
                        carteARetourner.setCouleur(Couleur.VERT);
                        break;
                    case 'b':
                        carteARetourner.setCouleur(Couleur.BLEU);
                        break;
                    case 'r':
                        carteARetourner.setCouleur(Couleur.ROUGE);
                        break;
                    case 'j':
                        carteARetourner.setCouleur(Couleur.JAUNE);
                        break;
                }
                return carteARetourner;
            }
        } else {
            throw new CoupIncorrectException("Erreur, la couleur n'est pas bonne.");
        }
    }
}
