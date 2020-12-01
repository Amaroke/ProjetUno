package cartes;

public class CarteJoker extends Carte {
    CarteJoker(Uno uno, Couleur couleur) {
        super(uno, couleur);
    }

    @Override
    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public int getValeur() {
        return 50;
    }

    @Override
    public int effet() {
        return 3;
    }

    @Override
    public boolean peutEtrePoseeSur(CarteJoker c) {
        return true;
    }

    @Override
    public String toString() {
        return "Carte Joker";
    }
}