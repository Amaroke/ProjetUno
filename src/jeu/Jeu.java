package jeu;

import dialogue.DialogueLigneDeCommande;
import uno.Uno;

public class Jeu {

    public static void main(String[] args) {
        Uno uno = new Uno();
        DialogueLigneDeCommande dial = new DialogueLigneDeCommande(uno);
        uno.setDialogue(dial);
    }

}
