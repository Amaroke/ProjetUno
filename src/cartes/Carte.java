package cartes;

import uno.Uno;

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

    public Uno getUno() {
        return uno;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public abstract boolean peutEtreRecouverte(Carte c);

    public abstract int getValeur();

    public abstract int effet();

    public abstract void appliquerEffet();

    public boolean estSansCouleur() {
        return getCouleur() == null;
    }

    public boolean estDeCouleurCompatible(Couleur c) {
        return estSansCouleur() || c == null || getCouleur().equals(c);
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteJoker c) {
        return estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return estDeCouleurCompatible(c.getCouleur());
    }

    @Override
    public String toString() {
        return "Carte{" +
                "uno=" + uno +
                ", couleur=" + couleur +
                '}';
    }
}
