package joueurs;

import cartes.PaquetDeCartes;
import uno.Uno;

public interface Strategie {

    void jouer(PaquetDeCartes pdc, Uno uno);

}
