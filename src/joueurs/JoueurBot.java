package joueurs;

import erreurs.CoupIncorrectException;
import uno.Uno;

public class JoueurBot extends Joueur {

    private final Strategie strategie;

    public JoueurBot(Uno uno, Strategie strategie) {
        super(uno);
        this.strategie = strategie;
    }

    public Strategie getStrategie() {
        return strategie;
    }

    @Override
    public boolean estUnJoueurHumain() {
        return false;
    }

    @Override
    public void jouer(String coup) throws CoupIncorrectException {
        getStrategie().jouer(getMainDuJoueur(), getUno());
    }

}
