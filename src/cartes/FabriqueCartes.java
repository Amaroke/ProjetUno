package cartes;

import uno.Uno;

public class FabriqueCartes {

    private static final FabriqueCartes instance = new FabriqueCartes();

    public static FabriqueCartes getInstance() {
        return instance;
    }

    public PaquetDeCartes getPaquetVide() {
        return new PaquetDeCartes();
    }

    public PaquetDeCartes getPaquetDeUno() {
        Uno uno = new Uno();
        PaquetDeCartes pdc = new PaquetDeCartes();
        Carte[] cartesBleues = new Carte[25];
        Carte[] cartesRouges = new Carte[25];
        Carte[] cartesJaunes = new Carte[25];
        Carte[] cartesVertes = new Carte[25];
        CarteJoker[] cartesJokers = new CarteJoker[4];
        CartePlus4[] cartesPlus4 = new CartePlus4[4];
        for (int i = 0; i < 19; ++i) {
            cartesBleues[i] = new CarteChiffre(uno, Couleur.BLEU, (i + 1) / 2);
            cartesRouges[i] = new CarteChiffre(uno, Couleur.ROUGE, (i + 1) / 2);
            cartesJaunes[i] = new CarteChiffre(uno, Couleur.JAUNE, (i + 1) / 2);
            cartesVertes[i] = new CarteChiffre(uno, Couleur.VERT, (i + 1) / 2);
        }
        for (int i = 19; i < 21; ++i) {
            cartesBleues[i] = new CartePlus2(uno, Couleur.BLEU);
            cartesRouges[i] = new CartePlus2(uno, Couleur.ROUGE);
            cartesJaunes[i] = new CartePlus2(uno, Couleur.JAUNE);
            cartesVertes[i] = new CartePlus2(uno, Couleur.VERT);
        }
        for (int i = 21; i < 23; ++i) {
            cartesBleues[i] = new CarteChangementDeSens(uno, Couleur.BLEU);
            cartesRouges[i] = new CarteChangementDeSens(uno, Couleur.ROUGE);
            cartesJaunes[i] = new CarteChangementDeSens(uno, Couleur.JAUNE);
            cartesVertes[i] = new CarteChangementDeSens(uno, Couleur.VERT);
        }
        for (int i = 23; i < 25; ++i) {
            cartesBleues[i] = new CartePasseTonTour(uno, Couleur.BLEU);
            cartesRouges[i] = new CartePasseTonTour(uno, Couleur.ROUGE);
            cartesJaunes[i] = new CartePasseTonTour(uno, Couleur.JAUNE);
            cartesVertes[i] = new CartePasseTonTour(uno, Couleur.VERT);
        }
        for (int i = 0; i < 4; ++i) {
            cartesJokers[i] = new CarteJoker(uno, null);
            cartesPlus4[i] = new CartePlus4(uno, null);
        }
        pdc.ajouter(cartesBleues);
        pdc.ajouter(cartesRouges);
        pdc.ajouter(cartesJaunes);
        pdc.ajouter(cartesVertes);
        pdc.ajouter(cartesJokers);
        pdc.ajouter(cartesPlus4);
        return pdc;
    }
}