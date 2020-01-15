package RussianRoulette.RussianRoulette;

import java.util.ArrayList;
import RussianRoulette.RussianRoulette.AbstractModel;

public abstract class AbstractControler {

  protected AbstractModel calc;
  protected String operateur = "", nbre = "";
  protected Boolean add = false;
  protected ArrayList<String> listOperateur = new ArrayList<String>();

  public AbstractControler(AbstractModel cal){
    this.calc = cal;
    //On définit la liste des opérateurs
    //Afin de s'assurer qu'ils sont corrects

    this.listOperateur.add("Lancer la roulette");
   }
   
  //Définit l'opérateur
  public void setOperateur(String ope){
    this.operateur = ope;
    control();
  }
   
  //Définit le nombre
  public void setNombre(String nombre, boolean b){
    this.nbre = nombre;
    this.add = b;
    control();
  }
   
  //Efface
  public void reset(){
    this.calc.reset();
  }
   
  //Méthode de contrôle
  abstract void control();
}