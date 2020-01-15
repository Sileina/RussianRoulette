package RussianRoulette.RussianRoulette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

//CTRL + SHIFT + O pour générer les imports
public class RouletteInterface extends JFrame implements Observer{

  private JPanel container = new JPanel();
   
  String[] tab_string = {"1", "2", "3", "4", "5", "6", "Lancer la roulette"};
  JToggleButton[] tab_button = new JToggleButton[tab_string.length];
   
  private JLabel ecran = new JLabel();
  private Dimension dim = new Dimension(50, 40);
  private Dimension dim2 = new Dimension(50, 31);
  private double chiffre1;
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
   
  //L'instance de notre objet contrôleur
  private AbstractControler controler;

  public RouletteInterface(AbstractControler controler){                
    this.setSize(240, 260);
    this.setTitle("Calculette");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    initComposant();                
    this.controler = controler;                
    this.setContentPane(container);
    this.setVisible(true);
  }

  private void initComposant(){
    Font police = new Font("Arial", Font.BOLD, 20);
    ecran = new JLabel("0");
    ecran.setFont(police);
    ecran.setHorizontalAlignment(JLabel.RIGHT);
    ecran.setPreferredSize(new Dimension(220, 20));

    JPanel operateur = new JPanel();        
    operateur.setPreferredSize(new Dimension(55, 225));
    JPanel chiffre = new JPanel();
    chiffre.setPreferredSize(new Dimension(165, 225));
    JPanel panEcran = new JPanel();
    panEcran.setPreferredSize(new Dimension(220, 30));

    //Nous utiliserons le même listener pour tous les opérateurs
    OperateurListener opeListener = new OperateurListener();

    for(int i = 0; i < tab_string.length; i++)
    {
      tab_button[i] = new JToggleButton(tab_string[i]);
      tab_button[i].setPreferredSize(dim);

      switch(i){
        case 6 :
          tab_button[i].addActionListener(opeListener);
          tab_button[i].setForeground(Color.red);
          tab_button[i].setPreferredSize(new Dimension(150, 35));
          
          chiffre.add(tab_button[i]);
          break;
        default :
          chiffre.add(tab_button[i]);
          tab_button[i].addActionListener((ActionListener) new ChiffreListener());
          break;                       
      }                    
    }                
    panEcran.add(ecran);
    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
    container.add(panEcran, BorderLayout.NORTH);
    container.add(chiffre, BorderLayout.CENTER);
    container.add(operateur, BorderLayout.EAST);                
  }   

  //Les listeners pour nos boutons
  class ChiffreListener implements ActionListener{ 
    public void actionPerformed(ActionEvent actionEvent) {
      //On affiche le chiffre en plus dans le label
      String str = ((JToggleButton)actionEvent.getSource()).getText();
      AbstractButton abstractButton =  
              (AbstractButton)actionEvent.getSource();
      boolean isSelected = abstractButton.getModel().isSelected();

    
      if( isSelected == true) {
    	   controler.setNombre(((JToggleButton)actionEvent.getSource()).getText(), true);
      } else {
    	  controler.setNombre(((JToggleButton)actionEvent.getSource()).getText(), false);
      }
   
    }

                
  }

  class OperateurListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      controler.setOperateur(((JToggleButton)e.getSource()).getText());
    }           
  }
   
  class ResetListener implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
      controler.reset();
    }               
  }
   
  //Implémentation du pattern observer
  public void update(String str) {
    ecran.setText(str);
  }  
}