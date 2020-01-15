package RussianRoulette.RussianRoulette;
import RussianRoulette.RussianRoulette.Observable;
public class Calculator extends AbstractModel{

  //Définit l'opérateur
  public void setOperateur(String ope){    
    //On lance le calcul
    calcul();

    //On stocke l'opérateur
    this.operateur = ope;

    //Si l'opérateur n'est pas =
    if(!ope.equals("=")){
      //On réinitialise l'opérande
      this.operande = "";
    }    
  }

  //Définit le nombre
  public void setNombre(String result, Boolean add){
    //On concatène le nombre 
   if(add == true) {
	   this.listeNombre.add(result);
   }else{
	   this.listeNombre.remove(result);
   }
  
  }

  //Force le calcul
  public void getResultat() {
    calcul();
  }


  //Calcul
  public void calcul(){
	    int rand =  (int)(Math.random() * 6) + 1;
	    String stringRand = Integer.toString(rand);
	    System.out.print(stringRand);
	    if(this.listeNombre.contains(stringRand)) {
	    	this.result = stringRand+ " Perdu";
	    } else {
	    	this.result =  stringRand+ " Gagné";
	    }
	    
	    notifyObserver(this.result);
  }


@Override
public void reset() {
	// TODO Auto-generated method stub
	
}
}