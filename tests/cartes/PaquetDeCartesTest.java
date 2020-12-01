package cartes;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PaquetDeCartesTest {

    @Test
    void getNombreDeCartes() {
    }

    @Test
    void estVide() {
    }

    @Test
    void getValeur() {
    }

    // On ne test pas toString.

    @Test
    void ajouter() {
    }

    @Test
    void testAjouter() {
    }

    @Test
    void melanger() {
    }

    @Test
    void retourner() {
    }

    @Test
    void getSommet() {
    }

    @Test
    void piocher() {
    }

    @Test
    void ecrire() throws IOException {
            FabriqueCartes singleton = FabriqueCartes.getInstance();
            PaquetDeCartes pdc = singleton.getPaquetDeUno();
            pdc.ecrire("ecrireTest.txt");
    }

    @Test
    void lire() {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        PaquetDeCartes pdc = singleton.getPaquetDeUno();
        pdc.lire("lireTest.txt");
    }
}