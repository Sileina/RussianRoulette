package RussianRoulette.RussianRoulette;

import java.util.ArrayList;
import java.util.List;

import RussianRoulette.RussianRoulette.Observable;
import RussianRoulette.RussianRoulette.Observer;

public abstract class AbstractModel implements Observable{

  protected String result ;   
  protected String operateur = "", operande = "";
  protected List<String> listeNombre = new ArrayList<String>();
  private ArrayList<Observer> listObserver = new ArrayList<Observer>();   
  //Efface 
  public abstract void reset();

  //Effectue le calcul
  public abstract void calcul();

  //Affichage forcé du résultat
  public abstract void getResultat();

  //Définit l'opérateur de l'opération
  public abstract void setOperateur(String operateur);

  //Définit le nombre à utiliser pour l'opération
  public abstract void setNombre(String nbre, Boolean add) ;

  //Implémentation du pattern observer
  public void addObserver(Observer obs) {
    this.listObserver.add(obs);
  }

  public void notifyObserver(String str) {
 
    for(Observer obs : listObserver)
      obs.update(str);
  }

  public void removeObserver() {
    listObserver = new ArrayList<Observer>();
  }  
}