package cartes;

public class CartePlus4 extends Carte {
    CartePlus4(Uno uno, Couleur couleur) {
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
        return 6;
    }

    @Override
    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return true;
    }
    @Override
    public String toString() {
        return "CartePlus4{}";
    }
}
