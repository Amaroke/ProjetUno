package joueurs;

import cartes.*;
import erreurs.CoupIncorrectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JoueurTest {

    Uno uno;
    JoueurHumain humain;

    @BeforeEach
    void init() {
        uno = new Uno();
        humain = new JoueurHumain(uno);
    }

    @Test
    void carteChoisie() throws CoupIncorrectException {
        humain.getMainDuJoueur().ajouter(new CarteJoker(uno));
        humain.getMainDuJoueur().ajouter(new CarteChiffre(uno, Couleur.VERT, 5));
        humain.getMainDuJoueur().ajouter(new CartePlus4(uno));

        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie(""));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("v"));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("5"));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("0y"));

        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie(""));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("v"));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("1r"));

        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie(""));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("v"));
        assertThrows(CoupIncorrectException.class, () -> humain.carteChoisie("2y"));

        Carte carteTest = humain.carteChoisie("0v");
        Carte carteTest2 = humain.carteChoisie("1");
        Carte carteTest3 = humain.carteChoisie("2j");

        assertEquals(carteTest.effet(), new CarteJoker(uno).effet());

        assertEquals(carteTest2.effet(), new CarteChiffre(uno, Couleur.VERT, 5).effet());
        assertEquals(carteTest2.getCouleur(), new CarteChiffre(uno, Couleur.VERT, 5).getCouleur());

        assertEquals(carteTest3.effet(), new CartePlus4(uno).effet());
    }
}