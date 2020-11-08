package cartes;

public abstract class Carte {

    protected Uno uno;
    protected Couleur couleur;

    Carte(Uno uno) {
        this.uno = uno;
    }

    Carte(Uno uno, Couleur couleur) {
        this.uno = uno;
        this.couleur = couleur;
    }

    abstract boolean peutEtreRecouverte(Carte c);

    abstract int getValeur();

    abstract int effet();

    Couleur getCouleur() {
        return couleur;
    }

    boolean estSansCouleur() {
        return this.getCouleur().equals(null);
    }

    void appliquerEffet() {

    }

    boolean estDeCouleurCompatible(Couleur c) {
        return this.getCouleur().equals(c);
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
