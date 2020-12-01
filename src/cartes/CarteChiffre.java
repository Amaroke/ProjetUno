package cartes;

public class CarteChiffre extends Carte{
    private final int chiffre;
    CarteChiffre (Uno uno, Couleur couleur, int chiffre) {
        super(uno, couleur);
        this.chiffre = chiffre;
    }

    @Override
    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public int getValeur() {
        return this.chiffre;
    }

    @Override
    public int effet() {
        return 1;
    }

    @Override
    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return this.estDeCouleurCompatible(c.getCouleur()) || this.getValeur() == c.getValeur();
    }

    @Override
    public String toString() {
        return "CarteChiffre{" + "couleur=" + this.getCouleur() + "chiffre=" + chiffre +
                '}';
    }
}
