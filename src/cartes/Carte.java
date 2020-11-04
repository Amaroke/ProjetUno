package cartes;

public class Carte {

    Carte(Uno uno) {

    }

    Carte(Uno uno, Couleur couleur) {

    }

    abstract boolean peutEtreRecouverte(Carte c) {

    }

    abstract int getValeur() {

    }

    abstract int effet() {

    }

    Couleur getCouleur() {

    }

    boolean estSansCouleur() {

    }

    void appliquerEffet() {

    }

    boolean estDeCouleurCompatible(Couleur c) {

    }

    boolean peutEtrePoseeSur(CarteChiffre c) {

    }

    boolean peutEtrePoseeSur(CarteChangementDeSens c) {

    }

    boolean peutEtrePoseeSur(CarteJoker c) {

    }

    boolean peutEtrePoseeSur(CartePasseTonTour c) {

    }

    boolean peutEtrePoseeSur(CartePlus2 c) {

    }

    boolean peutEtrePoseeSur(CartePlus4 c) {

    }


}
