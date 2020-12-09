package cartes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    Uno uno;
    CarteChiffre carteBleu1;
    CarteChiffre carteBleu2;
    CarteChiffre carteRouge1;
    CarteChiffre carteRouge2;
    CarteChiffre carteJaune1;
    CarteChiffre carteJaune2;
    CarteChiffre carteVert1;
    CarteChiffre carteVert2;
    CartePlus2 carteBleuPlus2;
    CartePlus2 carteRougePlus2;
    CarteChangementDeSens carteBleuChangementDeSens;
    CarteChangementDeSens carteRougeChangementDeSens;
    CartePasseTonTour carteBleuPasseTonTour;
    CartePasseTonTour carteRougePasseTonTour;
    CarteJoker carteJoker;
    CartePlus4 cartePlus4;

    @BeforeEach
    void init() {
        uno = new Uno();
        carteBleu1 = new CarteChiffre(uno, Couleur.BLEU, 1);
        carteBleu2 = new CarteChiffre(uno, Couleur.BLEU, 2);
        carteRouge1 = new CarteChiffre(uno, Couleur.ROUGE, 1);
        carteRouge2 = new CarteChiffre(uno, Couleur.ROUGE, 2);
        carteJaune1 = new CarteChiffre(uno, Couleur.JAUNE, 1);
        carteJaune2 = new CarteChiffre(uno, Couleur.JAUNE, 2);
        carteVert1 = new CarteChiffre(uno, Couleur.VERT, 1);
        carteVert2 = new CarteChiffre(uno, Couleur.VERT, 2);
        carteBleuPlus2 = new CartePlus2(uno, Couleur.BLEU);
        carteRougePlus2 = new CartePlus2(uno, Couleur.ROUGE);
        carteBleuChangementDeSens = new CarteChangementDeSens(uno, Couleur.BLEU);
        carteRougeChangementDeSens = new CarteChangementDeSens(uno, Couleur.ROUGE);
        carteBleuPasseTonTour = new CartePasseTonTour(uno, Couleur.BLEU);
        carteRougePasseTonTour = new CartePasseTonTour(uno, Couleur.ROUGE);
        carteJoker = new CarteJoker(uno);
        cartePlus4 = new CartePlus4(uno);
    }

    @Test
    void getValeur() {
        assertEquals(1, carteBleu1.getValeur());
        assertEquals(2, carteBleu2.getValeur());
        assertEquals(1, carteRouge1.getValeur());
        assertEquals(2, carteRouge2.getValeur());
        assertEquals(1, carteJaune1.getValeur());
        assertEquals(2, carteJaune2.getValeur());
        assertEquals(1, carteVert1.getValeur());
        assertEquals(2, carteVert2.getValeur());
        assertEquals(20, carteBleuPlus2.getValeur());
        assertEquals(20, carteRougePlus2.getValeur());
        assertEquals(20, carteBleuChangementDeSens.getValeur());
        assertEquals(20, carteRougeChangementDeSens.getValeur());
        assertEquals(20, carteBleuPasseTonTour.getValeur());
        assertEquals(20, carteRougePasseTonTour.getValeur());
        assertEquals(50, carteJoker.getValeur());
        assertEquals(50, cartePlus4.getValeur());
    }

    @Test
    void effet() {
        assertEquals(1, carteBleu1.effet());
        assertEquals(1, carteBleu2.effet());
        assertEquals(1, carteRouge1.effet());
        assertEquals(1, carteRouge2.effet());
        assertEquals(1, carteJaune1.effet());
        assertEquals(1, carteJaune2.effet());
        assertEquals(1, carteVert1.effet());
        assertEquals(1, carteVert2.effet());
        assertEquals(5, carteBleuPlus2.effet());
        assertEquals(5, carteRougePlus2.effet());
        assertEquals(2, carteBleuChangementDeSens.effet());
        assertEquals(2, carteRougeChangementDeSens.effet());
        assertEquals(4, carteBleuPasseTonTour.effet());
        assertEquals(4, carteRougePasseTonTour.effet());
        assertEquals(3, carteJoker.effet());
        assertEquals(6, cartePlus4.effet());
    }

    @Test
    void getCouleur() {
        assertEquals(Couleur.BLEU, carteBleu1.getCouleur());
        assertEquals(Couleur.BLEU, carteBleu2.getCouleur());
        assertEquals(Couleur.ROUGE, carteRouge1.getCouleur());
        assertEquals(Couleur.ROUGE, carteRouge2.getCouleur());
        assertEquals(Couleur.JAUNE, carteJaune1.getCouleur());
        assertEquals(Couleur.JAUNE, carteJaune2.getCouleur());
        assertEquals(Couleur.VERT, carteVert1.getCouleur());
        assertEquals(Couleur.VERT, carteVert2.getCouleur());
        assertEquals(Couleur.BLEU, carteBleuPlus2.getCouleur());
        assertEquals(Couleur.ROUGE, carteRougePlus2.getCouleur());
        assertEquals(Couleur.BLEU, carteBleuChangementDeSens.getCouleur());
        assertEquals(Couleur.ROUGE, carteRougeChangementDeSens.getCouleur());
        assertEquals(Couleur.BLEU, carteBleuPasseTonTour.getCouleur());
        assertEquals(Couleur.ROUGE, carteRougePasseTonTour.getCouleur());
        assertNull(carteJoker.getCouleur());
        assertNull(cartePlus4.getCouleur());
    }

    @Test
    void setCouleur() {
        carteBleu1.setCouleur(Couleur.JAUNE);
        carteRouge1.setCouleur(Couleur.JAUNE);
        carteJaune1.setCouleur(Couleur.JAUNE);
        carteVert1.setCouleur(Couleur.JAUNE);
        carteBleuPlus2.setCouleur(Couleur.JAUNE);
        carteBleuChangementDeSens.setCouleur(Couleur.JAUNE);
        carteBleuPasseTonTour.setCouleur(Couleur.JAUNE);
        assertEquals(Couleur.JAUNE, carteBleu1.getCouleur());
        assertEquals(Couleur.JAUNE, carteRouge1.getCouleur());
        assertEquals(Couleur.JAUNE, carteJaune1.getCouleur());
        assertEquals(Couleur.JAUNE, carteVert1.getCouleur());
        assertEquals(Couleur.JAUNE, carteBleuPlus2.getCouleur());
        assertEquals(Couleur.JAUNE, carteBleuChangementDeSens.getCouleur());
        assertEquals(Couleur.JAUNE, carteBleuPasseTonTour.getCouleur());
    }

    @Test
    void estSansCouleur() {
        assertFalse(carteBleu1.estSansCouleur());
        assertFalse(carteBleu2.estSansCouleur());
        assertFalse(carteRouge1.estSansCouleur());
        assertFalse(carteRouge2.estSansCouleur());
        assertFalse(carteJaune1.estSansCouleur());
        assertFalse(carteJaune2.estSansCouleur());
        assertFalse(carteVert1.estSansCouleur());
        assertFalse(carteVert2.estSansCouleur());
        assertFalse(carteBleuPlus2.estSansCouleur());
        assertFalse(carteRougePlus2.estSansCouleur());
        assertFalse(carteBleuChangementDeSens.estSansCouleur());
        assertFalse(carteRougeChangementDeSens.estSansCouleur());
        assertFalse(carteBleuPasseTonTour.estSansCouleur());
        assertFalse(carteRougePasseTonTour.estSansCouleur());
        assertTrue(carteJoker.estSansCouleur());
        assertTrue(cartePlus4.estSansCouleur());
    }

    @Test
    void estDeCouleurCompatible() {
        assertTrue(carteBleu1.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carteBleu1.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carteBleu1.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carteBleu1.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carteRouge1.estDeCouleurCompatible(Couleur.BLEU));
        assertTrue(carteRouge1.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carteRouge1.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carteRouge1.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carteJaune1.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carteJaune1.estDeCouleurCompatible(Couleur.ROUGE));
        assertTrue(carteJaune1.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carteJaune1.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carteVert1.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carteVert1.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carteVert1.estDeCouleurCompatible(Couleur.JAUNE));
        assertTrue(carteVert1.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carteBleuPlus2.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carteBleuPlus2.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carteBleuPlus2.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carteBleuPlus2.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carteBleuChangementDeSens.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carteBleuChangementDeSens.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carteBleuChangementDeSens.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carteBleuChangementDeSens.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carteBleuPasseTonTour.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carteBleuPasseTonTour.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carteBleuPasseTonTour.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carteBleuPasseTonTour.estDeCouleurCompatible(Couleur.VERT));
    }

    @Test
    void testPeutEtrePoseeSurChiffre() {
        assertTrue(carteBleu1.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteBleu2.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteRouge1.peutEtrePoseeSur(carteBleu1));
        assertFalse(carteRouge2.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteJaune1.peutEtrePoseeSur(carteBleu1));
        assertFalse(carteJaune2.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteVert1.peutEtrePoseeSur(carteBleu1));
        assertFalse(carteVert2.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteBleuPlus2.peutEtrePoseeSur(carteBleu1));
        assertFalse(carteRougePlus2.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteBleuChangementDeSens.peutEtrePoseeSur(carteBleu1));
        assertFalse(carteRougeChangementDeSens.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteBleuPasseTonTour.peutEtrePoseeSur(carteBleu1));
        assertFalse(carteRougePasseTonTour.peutEtrePoseeSur(carteBleu1));
        assertTrue(carteJoker.peutEtrePoseeSur(carteBleu1));
        assertTrue(cartePlus4.peutEtrePoseeSur(carteBleu1));
    }

    @Test
    void testPeutEtrePoseeSurChangementDeSens() {
        assertTrue(carteBleu1.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(carteBleu2.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteRouge1.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteRouge2.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteJaune1.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteJaune2.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteVert1.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteVert2.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(carteBleuPlus2.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteRougePlus2.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(carteBleuChangementDeSens.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(carteRougeChangementDeSens.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(carteBleuPasseTonTour.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertFalse(carteRougePasseTonTour.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(carteJoker.peutEtrePoseeSur(carteBleuChangementDeSens));
        assertTrue(cartePlus4.peutEtrePoseeSur(carteBleuChangementDeSens));
    }

    @Test
    void testPeutEtrePoseeSurJoker() {
        assertTrue(carteBleu1.peutEtrePoseeSur(carteJoker));
        assertTrue(carteBleu2.peutEtrePoseeSur(carteJoker));
        assertTrue(carteRouge1.peutEtrePoseeSur(carteJoker));
        assertTrue(carteRouge2.peutEtrePoseeSur(carteJoker));
        assertTrue(carteJaune1.peutEtrePoseeSur(carteJoker));
        assertTrue(carteJaune2.peutEtrePoseeSur(carteJoker));
        assertTrue(carteVert1.peutEtrePoseeSur(carteJoker));
        assertTrue(carteVert2.peutEtrePoseeSur(carteJoker));
        assertTrue(carteBleuPlus2.peutEtrePoseeSur(carteJoker));
        assertTrue(carteRougePlus2.peutEtrePoseeSur(carteJoker));
        assertTrue(carteBleuChangementDeSens.peutEtrePoseeSur(carteJoker));
        assertTrue(carteRougeChangementDeSens.peutEtrePoseeSur(carteJoker));
        assertTrue(carteBleuPasseTonTour.peutEtrePoseeSur(carteJoker));
        assertTrue(carteRougePasseTonTour.peutEtrePoseeSur(carteJoker));
        assertTrue(carteJoker.peutEtrePoseeSur(carteJoker));
        assertTrue(cartePlus4.peutEtrePoseeSur(carteJoker));
    }

    @Test
    void testPeutEtrePoseeSurPasseTonTour() {
        assertTrue(carteBleu1.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(carteBleu2.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteRouge1.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteRouge2.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteJaune1.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteJaune2.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteVert1.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteVert2.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(carteBleuPlus2.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteRougePlus2.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(carteBleuChangementDeSens.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertFalse(carteRougeChangementDeSens.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(carteBleuPasseTonTour.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(carteRougePasseTonTour.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(carteJoker.peutEtrePoseeSur(carteBleuPasseTonTour));
        assertTrue(cartePlus4.peutEtrePoseeSur(carteBleuPasseTonTour));
    }

    @Test
    void testPeutEtrePoseeSurPlus2() {
        assertTrue(carteBleu1.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(carteBleu2.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteRouge1.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteRouge2.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteJaune1.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteJaune2.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteVert1.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteVert2.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(carteBleuPlus2.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(carteRougePlus2.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(carteBleuChangementDeSens.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteRougeChangementDeSens.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(carteBleuPasseTonTour.peutEtrePoseeSur(carteBleuPlus2));
        assertFalse(carteRougePasseTonTour.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(carteJoker.peutEtrePoseeSur(carteBleuPlus2));
        assertTrue(cartePlus4.peutEtrePoseeSur(carteBleuPlus2));
    }

    @Test
    void testPeutEtrePoseeSurPlus4() {
        assertTrue(carteBleu1.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteBleu2.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteRouge1.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteRouge2.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteJaune1.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteJaune2.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteVert1.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteVert2.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteBleuPlus2.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteRougePlus2.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteBleuChangementDeSens.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteRougeChangementDeSens.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteBleuPasseTonTour.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteRougePasseTonTour.peutEtrePoseeSur(cartePlus4));
        assertTrue(carteJoker.peutEtrePoseeSur(cartePlus4));
        assertTrue(cartePlus4.peutEtrePoseeSur(cartePlus4));
    }
}