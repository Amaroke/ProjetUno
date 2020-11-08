package cartes;

public abstract class Carte {

    protected Uno uno;
    protected Couleur couleur;

    public Carte(Uno uno) {
        this.uno = uno;
    }

    public Carte(Uno uno, Couleur couleur) {
        this.uno = uno;
        this.couleur = couleur;
    }

    public abstract boolean peutEtreRecouverte(Carte c);

    public abstract int getValeur();

    public abstract int effet();

    public Couleur getCouleur() {
        return couleur;
    }

    public boolean estSansCouleur() {
        return this.getCouleur().equals(null);
    }

    public void appliquerEffet() {

    }

    public boolean estDeCouleurCompatible(Couleur c) {
        return this.getCouleur().equals(c);
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {

    }

    public boolean peutEtrePoseeSur(CarteJoker c) {

    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {

    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {

    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {

    }


}
