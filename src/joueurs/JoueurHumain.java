package joueurs;

import cartes.Carte;
import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import erreurs.CoupIncorrectException;
import uno.Uno;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class JoueurHumain {

    private final PaquetDeCartes mainDuJoueur;
    private final Uno uno;

    public JoueurHumain(Uno uno) {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        mainDuJoueur = singleton.getPaquetVide();
        this.uno = uno;
    }

    public PaquetDeCartes getMainDuJoueur() {
        return mainDuJoueur;
    }

    public Carte getCarteNumero(int n) {
        return getMainDuJoueur().getPaquet().get(n);
    }

    public Uno getUno() {
        return uno;
    }

    public abstract void jouer(String coup);

    public Carte carteChoisie(String coup) throws CoupIncorrectException {
        Matcher matcher = Pattern.compile("\\d+").matcher(coup);
        List<String> couleurs = List.of("r", "v", "b", "j");
        // On cherche un nombre.
        if (!matcher.find()) {
            throw new CoupIncorrectException("Erreur, pas d'entier dans le coup.");
        }
        String nombre = matcher.group(0);
        int numeroCarteChoisie = Integer.parseInt(nombre);
        if (numeroCarteChoisie > getMainDuJoueur().getNombreDeCartes()) {
            throw new CoupIncorrectException("Erreur, la carte n'existe pas.");
        }
        coup = coup.replace(nombre, "");
        // On vérifie la couleur fournie.
        if (!couleurs.contains(coup) && !coup.equals("")) {
            throw new CoupIncorrectException("Erreur, la couleur n'est pas bonne.");
        }
        int typeDeCarteChoisie = getCarteNumero(numeroCarteChoisie).effet();
        boolean estUneCartePlus4OuJoker = (typeDeCarteChoisie == 3 || typeDeCarteChoisie == 6);
        if (estUneCartePlus4OuJoker && coup.equals("")) {
            throw new CoupIncorrectException("Erreur, la carte doit prendre une couleur.");
        }
        if (!estUneCartePlus4OuJoker && couleurs.contains(coup)) {
            throw new CoupIncorrectException("Erreur, la carte ne prends pas de couleur.");
        }
        return getMainDuJoueur().getPaquet().get(numeroCarteChoisie);
    }
}
