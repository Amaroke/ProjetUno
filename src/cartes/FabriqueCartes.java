package cartes;

public class FabriqueCartes {

    private static FabriqueCartes instance = new FabriqueCartes();

    public static FabriqueCartes getInstance() {
        return instance;
    }

    public PaquetDeCartes getPaquetVide() {
        return new PaquetDeCartes();
    }

    public PaquetDeCartes getPaquet1Vert() {
        PaquetDeCartes paquet = new PaquetDeCartes();
        paquet.ajouter(new Carte(1, Couleur.VERT));
        return paquet;
    }

    public PaquetDeCartes getPaquet5Vert() {
        Carte[] cartes = new Carte[5];
        PaquetDeCartes paquet = new PaquetDeCartes();
        for (int i = 0; i < 5; ++i) {
            cartes[i] = new Carte(i + 1, Couleur.VERT);
        }
        paquet.ajouter(cartes);
        return paquet;
    }

    public PaquetDeCartes getPaquet32() {
        Carte[] cartes = new Carte[32];
        PaquetDeCartes paquet = new PaquetDeCartes();
        for (int i = 0; i < 8; ++i) {
            cartes[i] = new Carte(i + 1, Couleur.BLEU);
        }
        for (int i = 8; i < 16; ++i) {
            cartes[i] = new Carte(i - 7, Couleur.ROUGE);
        }
        for (int i = 16; i < 24; ++i) {
            cartes[i] = new Carte(i - 15, Couleur.VERT);
        }
        for (int i = 24; i < 32; ++i) {
            cartes[i] = new Carte(i - 23, Couleur.JAUNE);
        }
        paquet.ajouter(cartes);
        return paquet;
    }

}