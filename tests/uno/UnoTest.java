package uno;

import cartes.FabriqueCartes;
import joueurs.StrategieFacile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {

    Uno uno;
    FabriqueCartes singleton = FabriqueCartes.getInstance();

    @BeforeEach
    void init() {
        uno = new Uno();
    }

    @Test
    void creerLesJoueurs() {
        uno.creerLesJoueurs(5, new StrategieFacile());
        assertEquals(5, uno.getNbJoueurs());
    }

    @Test
    void choisirQuiJoue() {
        uno.creerLesJoueurs(5, new StrategieFacile());
        uno.setJoueurQuiDistribue(2);
        uno.choisirQuiJoue();
        assertEquals(uno.getJoueurQuiJoue(), 3);
    }

    @Test
    void distribuerCartes() {
        uno.creerLesJoueurs(2, new StrategieFacile());
        uno.setPioche(singleton.getPaquetDeUno(uno));
        uno.setTalon(singleton.getPaquetVide());
        uno.distribuerCartes();
        assertEquals(uno.getJoueur(1).getMainDuJoueur().getNombreDeCartes(), 7);
        assertEquals(uno.getJoueur(2).getMainDuJoueur().getNombreDeCartes(), 7);
        assertEquals(uno.getPioche().getNombreDeCartes(), 93);
    }

    @Test
    void changerDeSens() {
        assertTrue(uno.getSensHoraire());
        uno.changerDeSens();
        assertFalse(uno.getSensHoraire());
    }

    @Test
    void changerDeJoueur() {
        uno.creerLesJoueurs(3, new StrategieFacile());
        uno.setJoueurQuiDistribue(2);
        uno.choisirQuiJoue();
        assertEquals(3, uno.getJoueurQuiJoue());
    }

    @Test
    void distribuerCartesJoueurSuivant() {
        uno.creerLesJoueurs(2, new StrategieFacile());
        uno.setPioche(singleton.getPaquetDeUno(uno));
        uno.setTalon(singleton.getPaquetVide());
        uno.setJoueurQuiDistribue(2);
        uno.choisirQuiJoue();
        uno.distribuerCartesJoueurSuivant(4);
        assertEquals(uno.getJoueur(1).getMainDuJoueur().getNombreDeCartes(), 4);
        assertEquals(uno.getPioche().getNombreDeCartes(), 104);
    }
}