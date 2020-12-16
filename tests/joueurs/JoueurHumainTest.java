package joueurs;

import cartes.*;
import erreurs.CoupIncorrectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JoueurHumainTest {

    Uno uno;
    JoueurHumain humain;
    FabriqueCartes singleton = FabriqueCartes.getInstance();

    @BeforeEach
    void init() {
        uno = new Uno();
        humain = new JoueurHumain(uno);
    }

    @Test
    void jouer() throws CoupIncorrectException {
        uno.creerLesJoueurs(2);
        uno.setPioche(singleton.getPaquetDeUno(uno));
        uno.setTalon(singleton.getPaquetVide());
        uno.setJoueurQuiDistribue(2);
        uno.choisirQuiJoue();
        humain.getMainDuJoueur().ajouter(new CarteJoker(uno));
        humain.getMainDuJoueur().ajouter(new CarteChiffre(uno, Couleur.VERT, 5));
        humain.getMainDuJoueur().ajouter(new CartePlus4(uno));
        uno.getTalon().ajouter(uno.getPioche().piocher());

        // Nombre de carte actuel dans la main du joueur : 3
        // Nombre de carte actuel dans le talon : 1
        humain.jouer("p"); // Il pioche une carte qu'il peut jouer ensuite
        assertEquals(humain.getMainDuJoueur().getNombreDeCartes(), 3);
        assertEquals(uno.getTalon().getNombreDeCartes(), 2);

        uno.getTalon().ajouter(new CarteChiffre(uno, Couleur.JAUNE, 9));
        // Nombre de carte actuel dans la main du joueur : 3
        // Nombre de carte actuel dans le talon : 3
        humain.jouer("p"); // Il pioche une carte qu'il ne peut jouer ensuite
        assertEquals(humain.getMainDuJoueur().getNombreDeCartes(), 4);
        assertEquals(uno.getTalon().getNombreDeCartes(), 3);

        // Nombre de carte actuel dans la main du joueur : 3
        // Nombre de carte actuel dans le talon : 3
        assertThrows(CoupIncorrectException.class, () -> humain.jouer("1v"));
        humain.jouer("0v"); // Il joue sa carte numéro 1
        assertEquals(humain.getMainDuJoueur().getNombreDeCartes(), 3);
        assertEquals(uno.getTalon().getNombreDeCartes(), 4);

        // Nombre de carte actuel dans la main du joueur : 3
        // Nombre de carte actuel dans le talon : 4
        humain.jouer("passer"); // Il passe son tour
        assertEquals(humain.getMainDuJoueur().getNombreDeCartes(), 3);
        assertEquals(uno.getTalon().getNombreDeCartes(), 4);
    }
}