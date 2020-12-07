package cartes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class PaquetDeCartesTest {

    FabriqueCartes singleton;
    PaquetDeCartes paquetUno;
    PaquetDeCartes paquetVide;

    @BeforeEach
    void init() {
        singleton = FabriqueCartes.getInstance();
        paquetUno = singleton.getPaquetDeUno();
        paquetVide = singleton.getPaquetVide();
    }

    @Test
    void getNombreDeCartes() {
    }

    @Test
    void estVide() {
    }

    @Test
    void getValeur() {
    }

    @Test
    void ajouter() {
    }

    @Test
    void ajouterPaquet() {
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
        paquetUno.ecrire("ecrireTest.txt");
    }

    @Test
    void lire() throws FileNotFoundException {
        paquetUno.lire("lireTest.txt");
        System.out.println(paquetUno);
    }
}