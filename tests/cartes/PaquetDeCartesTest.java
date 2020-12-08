package cartes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PaquetDeCartesTest {

    Uno uno;
    FabriqueCartes singleton;
    PaquetDeCartes paquetUno;
    PaquetDeCartes paquetVide;
    File file = new File("ecrireTest.txt");

    @BeforeEach
    void init() {
        uno = new Uno();
        singleton = FabriqueCartes.getInstance();
        paquetUno = singleton.getPaquetDeUno();
        paquetVide = singleton.getPaquetVide();
    }

    @Test
    void getNombreDeCartes() {
        assertEquals(0, paquetVide.getNombreDeCartes());
        assertEquals(108, paquetUno.getNombreDeCartes());
    }

    @Test
    void estVide() {
        assertTrue(paquetVide.estVide());
        assertFalse(paquetUno.estVide());
    }

    @Test
    void getValeur() {
        assertEquals(0, paquetVide.getValeur());
        assertEquals(1240, paquetUno.getValeur());
    }

    @Test
    void ajouter() {
        paquetVide.ajouter(new CarteJoker(uno));
        paquetUno.ajouter(new CarteJoker(uno));
        assertEquals(paquetVide.getNombreDeCartes(), 1);
        assertEquals(paquetUno.getNombreDeCartes(), 109);
    }

    @Test
    void ajouterPaquet() {
        paquetVide.ajouter(paquetUno);
        assertEquals(paquetVide.getNombreDeCartes(), 108);
    }

    @Test
    void melanger() {
        paquetVide.melanger();
        paquetUno.melanger();
        assertEquals(paquetVide.getNombreDeCartes(), 0);
        assertEquals(paquetUno.getNombreDeCartes(), 108);
    }

    @Test
    void retourner() {
        paquetVide.retourner();
        paquetUno.retourner();
        assertEquals(paquetVide.getNombreDeCartes(), 0);
        assertEquals(paquetUno.getNombreDeCartes(), 108);
    }

    @Test
    void getSommet() {
        assertNull(paquetVide.getSommet());
        assertEquals(new CartePlus4(uno).effet(), paquetUno.getSommet().effet());
    }

    @Test
    void piocher() {
        assertEquals(paquetUno.piocher().effet(), new CarteChiffre(uno, Couleur.BLEU, 1).effet());
        assertEquals(paquetUno.getNombreDeCartes(), 107);
    }

    @Test
    void ecrire() throws IOException {
        //On supprime le fichier "ecrireTest.txt" s'il existe avant le test.
        if (file.delete()) {
            System.out.println(file.getName() + " est supprimé.");
        } else {
            System.out.println("Opération de suppression echouée.");
        }
        paquetUno.ecrire("ecrireTest.txt");
    }

    @Test
    void lire() throws FileNotFoundException {
        paquetUno.lire("lireTest.txt");
        System.out.println(paquetUno);
    }
}