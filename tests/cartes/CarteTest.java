package cartes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    Uno uno;
    CarteChiffre CarteBleu1;
    CarteChiffre CarteBleu2;
    CarteChiffre CarteRouge1;
    CarteChiffre CarteRouge2;
    CarteChiffre CarteJaune1;
    CarteChiffre CarteJaune2;
    CarteChiffre CarteVert1;
    CarteChiffre CarteVert2;
    CartePlus2 CarteBleuPlus2;
    CartePlus2 CarteRougePlus2;
    CarteChangementDeSens CarteBleuChangementDeSens;
    CarteChangementDeSens CarteRougeChangementDeSens;
    CartePasseTonTour CarteBleuPasseTonTour;
    CartePasseTonTour CarteRougePasseTonTour;
    CarteJoker CarteJoker;
    CartePlus4 CartePlus4;

    @BeforeEach
    void init() {
        uno = new Uno();
        CarteBleu1 = new CarteChiffre(uno, Couleur.BLEU, 1);
        CarteBleu2 = new CarteChiffre(uno, Couleur.BLEU, 2);
        CarteRouge1 = new CarteChiffre(uno, Couleur.ROUGE, 1);
        CarteRouge2 = new CarteChiffre(uno, Couleur.ROUGE, 2);
        CarteJaune1 = new CarteChiffre(uno, Couleur.JAUNE, 1);
        CarteJaune2 = new CarteChiffre(uno, Couleur.JAUNE, 2);
        CarteVert1 = new CarteChiffre(uno, Couleur.VERT, 1);
        CarteVert2 = new CarteChiffre(uno, Couleur.VERT, 2);
        CarteBleuPlus2 = new CartePlus2(uno, Couleur.BLEU);
        CarteRougePlus2 = new CartePlus2(uno, Couleur.ROUGE);
        CarteBleuChangementDeSens = new CarteChangementDeSens(uno, Couleur.BLEU);
        CarteRougeChangementDeSens = new CarteChangementDeSens(uno, Couleur.ROUGE);
        CarteBleuPasseTonTour = new CartePasseTonTour(uno, Couleur.BLEU);
        CarteRougePasseTonTour = new CartePasseTonTour(uno, Couleur.ROUGE);
        CarteJoker = new CarteJoker(uno, null);
        CartePlus4 = new CartePlus4(uno, null);
    }

    @Test
    void peutEtreRecouverte() {
    }

    @Test
    void getValeur() {
    }

    @Test
    void effet() {
    }

    @Test
    void getCouleur() {
    }

    @Test
    void estSansCouleur() {
    }

    @Test
    void appliquerEffet() {
    }

    @Test
    void estDeCouleurCompatible() {
    }

    @Test
    void peutEtrePoseeSur() {
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(CarteBleu1.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteBleu2.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteRouge1.peutEtrePoseeSur(CarteBleu1));
        assertFalse(CarteRouge2.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteJaune1.peutEtrePoseeSur(CarteBleu1));
        assertFalse(CarteJaune2.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteVert1.peutEtrePoseeSur(CarteBleu1));
        assertFalse(CarteVert2.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteBleuPlus2.peutEtrePoseeSur(CarteBleu1));
        assertFalse(CarteRougePlus2.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteBleuChangementDeSens.peutEtrePoseeSur(CarteBleu1));
        assertFalse(CarteRougeChangementDeSens.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteBleuPasseTonTour.peutEtrePoseeSur(CarteBleu1));
        assertFalse(CarteRougePasseTonTour.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CarteJoker.peutEtrePoseeSur(CarteBleu1));
        assertTrue(CartePlus4.peutEtrePoseeSur(CarteBleu1));
    }

    @Test
    void testPeutEtrePoseeSur1() {
    }

    @Test
    void testPeutEtrePoseeSur2() {
    }

    @Test
    void testPeutEtrePoseeSur3() {
    }

    @Test
    void testPeutEtrePoseeSur4() {
    }

    @Test
    void testToString() {
    }
}