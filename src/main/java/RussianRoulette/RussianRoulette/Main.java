package RussianRoulette.RussianRoulette;


import RussianRoulette.RussianRoulette.RouletteInterface;

public class Main {

  public static void main(String[] args) {
    //Instanciation de notre modèle
    AbstractModel calc = new Calculator();
    //Création du contrôleur
    AbstractControler controler = new CalculetteControler(calc);
    //Création de notre fenêtre avec le contrôleur en paramètre
    RouletteInterface roulette = new RouletteInterface(controler);
    //Ajout de la fenêtre comme observer de notre modèle
    calc.addObserver(roulette);
  }
}