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
        return this.getCouleur() == null;
    }

    public void appliquerEffet() {

    }

    public boolean estDeCouleurCompatible(Couleur c) {
        return this.getCouleur().equals(c) || this.estSansCouleur();
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteJoker c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carte{");
        sb.append("uno=").append(uno);
        sb.append(", couleur=").append(couleur);
        sb.append('}');
        return sb.toString();
    }
}
