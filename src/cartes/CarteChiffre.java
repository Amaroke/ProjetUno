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
        return 0;
    }

    @Override
    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return this.getValeur() == c.getValeur();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarteChiffre{");
        sb.append("chiffre=").append(chiffre);
        sb.append('}');
        return sb.toString();
    }
}
