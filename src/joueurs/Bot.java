package joueurs;

import uno.Uno;

public class Bot extends Joueur {

    private final Strategie strategie;

    public Bot(Uno uno, Strategie strategie) {
        super(uno);
        this.strategie = strategie;
    }

    public Strategie getStrategie() {
        return strategie;
    }

    @Override
    public void jouer(String coup) {
        getStrategie().jouer(getMainDuJoueur());
    }

}
