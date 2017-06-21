import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Menu here.
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-21)
 */
public class Menu extends World
{
    String status = "main"; 
    private int clickCooldown=20;
    String[] pacmanControls = new String[4];
    String[] ghost1Controls = new String[4];
    String[] ghost2Controls = new String[4];
    String[] ghost3Controls = new String[4];
    String[] ghost4Controls = new String[4];
    boolean pacmanAI=false;
    boolean ghost1AI=true;
    boolean ghost2AI=true;
    boolean ghost3AI=true;
    boolean ghost4AI=true;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Greenfoot.start();
        pacmanControls[0] = "w"; 
        pacmanControls[1] = "a";
        pacmanControls[2] = "s"; 
        pacmanControls[3] = "d"; 
        ghost1Controls[0] = "up";
        ghost1Controls[1] = "left";
        ghost1Controls[2] = "down";
        ghost1Controls[3] = "right";
        ghost2Controls[0] = "t";
        ghost2Controls[1] = "f";
        ghost2Controls[2] = "g";
        ghost2Controls[3] = "h";
        ghost3Controls[0] = "i";
        ghost3Controls[1] = "j";
        ghost3Controls[2] = "k";
        ghost3Controls[3] = "l";
        ghost4Controls[0] = "8";
        ghost4Controls[1] = "4";
        ghost4Controls[2] = "5";
        ghost4Controls[3] = "6";
        act();
    }

    /**
     * verwaltet das Menü
     *
     */
    public void act()
    {
        if(clickCooldown>0)
        {
            clickCooldown--;
        }
        if(status.equals("main"))
        {
            showMain();
        } else if(status.equals("menu"))
        {
            showMenu();
        } else if(status.equals("help"))
        {
            showHelp();
        }
    }

    /**
     * zeigt die Knöpfe des Hauptmenüs
     *
     */
    private void showMain()
    {
        removeAllObjects();
        addObject(new Button(new GreenfootImage("Eat'em all!",100,null,null),this,1,100,100),300,100);
        addObject(new Button(new GreenfootImage("Start",50,null,null),this,1,50,50),300,300);
        addObject(new Button(new GreenfootImage("Menü",50,null,null),this,2,50,50),150,300);
        addObject(new Button(new GreenfootImage("Hilfe",50,null,null),this,3,50,50),450,300);
    }

    /**
     * zeigt die "Knöpfe" (sie haben, außer der Zurückknopf, keine Funktion sondern sind einfach nur Text) der Hilfe
     *
     */
    private void showHelp()
    {
        removeAllObjects();
        addObject(new Button(new GreenfootImage("Der Pacman muss alle Punkte essen.",20,null,null),this,0,0,0),300,10);
        addObject(new Button(new GreenfootImage("Die Geister müssen das verhindern, indem sie den Pacman fangen.",20,null,null),this,0,0,0),300,30);
        addObject(new Button(new GreenfootImage("Powerups sind:",20,null,null),this,0,0,0),100,50);
        addObject(new Button(new GreenfootImage("Gelber Punkt: Pacman kann kurzzeitig die Geister fangen",20,null,null),this,0,0,0),300,70);
        addObject(new Button(new GreenfootImage("Die Steuerung kann im Menü mit einem Mausklick verändert werden.",20,null,null),this,0,0,0),300,90);
        addObject(new Button(new GreenfootImage("Zurück",getHeight()/20,null,null),this,29),550,390);
    }

    
    
    /**
     * zeigt die Knöpfe des Menüs
     *
     */
    private void showMenu()
    {
        //creating the identifiers (adding a new Button, with a new Image thats some short text, giving it an identifier and ordering it in a columm)
        removeAllObjects();
        addObject(new Button(new GreenfootImage("Pacman oben:",getHeight()/20,null,null),this,4),75,10);
        addObject(new Button(new GreenfootImage("Pacman links:",getHeight()/20,null,null),this,5),75,30);
        addObject(new Button(new GreenfootImage("Pacman unten:",getHeight()/20,null,null),this,6),75,50);
        addObject(new Button(new GreenfootImage("Pacman rechts:",getHeight()/20,null,null),this,7),75,70);
        addObject(new Button(new GreenfootImage("Geist 1 oben:",getHeight()/20,null,null),this,8),75,90);
        addObject(new Button(new GreenfootImage("Geist 1 links:",getHeight()/20,null,null),this,9),75,110);
        addObject(new Button(new GreenfootImage("Geist 1 unten:",getHeight()/20,null,null),this,10),75,130);
        addObject(new Button(new GreenfootImage("Geist 1 rechts:",getHeight()/20,null,null),this,11),75,150);
        addObject(new Button(new GreenfootImage("Geist 2 oben:",getHeight()/20,null,null),this,12),75,170);
        addObject(new Button(new GreenfootImage("Geist 2 links:",getHeight()/20,null,null),this,13),75,190);
        addObject(new Button(new GreenfootImage("Geist 2 unten:",getHeight()/20,null,null),this,14),75,210);
        addObject(new Button(new GreenfootImage("Geist 2 rechts:",getHeight()/20,null,null),this,15),75,230);
        addObject(new Button(new GreenfootImage("Geist 3 oben:",getHeight()/20,null,null),this,16),75,250);
        addObject(new Button(new GreenfootImage("Geist 3 links:",getHeight()/20,null,null),this,17),75,270);
        addObject(new Button(new GreenfootImage("Geist 3 unten:",getHeight()/20,null,null),this,18),75,290);
        addObject(new Button(new GreenfootImage("Geist 3 rechts:",getHeight()/20,null,null),this,19),75,310);
        addObject(new Button(new GreenfootImage("Geist 4 oben:",getHeight()/20,null,null),this,20),75,330);
        addObject(new Button(new GreenfootImage("Geist 4 links:",getHeight()/20,null,null),this,21),75,350);
        addObject(new Button(new GreenfootImage("Geist 4 unten:",getHeight()/20,null,null),this,22),75,370);
        addObject(new Button(new GreenfootImage("Geist 4 rechts:",getHeight()/20,null,null),this,23),75,390);
        //and now the same for the Buttons that show the current control
        addObject(new Button(new GreenfootImage(pacmanControls[0],getHeight()/20,null,null),this,4),150,10);
        addObject(new Button(new GreenfootImage(pacmanControls[1],getHeight()/20,null,null),this,5),150,30);
        addObject(new Button(new GreenfootImage(pacmanControls[2],getHeight()/20,null,null),this,6),150,50);
        addObject(new Button(new GreenfootImage(pacmanControls[3],getHeight()/20,null,null),this,7),150,70);
        addObject(new Button(new GreenfootImage(ghost1Controls[0],getHeight()/20,null,null),this,8),150,90);
        addObject(new Button(new GreenfootImage(ghost1Controls[1],getHeight()/20,null,null),this,9),150,110);
        addObject(new Button(new GreenfootImage(ghost1Controls[2],getHeight()/20,null,null),this,10),150,130);
        addObject(new Button(new GreenfootImage(ghost1Controls[3],getHeight()/20,null,null),this,11),150,150);
        addObject(new Button(new GreenfootImage(ghost2Controls[0],getHeight()/20,null,null),this,12),150,170);
        addObject(new Button(new GreenfootImage(ghost2Controls[1],getHeight()/20,null,null),this,13),150,190);
        addObject(new Button(new GreenfootImage(ghost2Controls[2],getHeight()/20,null,null),this,14),150,210);
        addObject(new Button(new GreenfootImage(ghost2Controls[3],getHeight()/20,null,null),this,15),150,230);
        addObject(new Button(new GreenfootImage(ghost3Controls[0],getHeight()/20,null,null),this,16),150,250);
        addObject(new Button(new GreenfootImage(ghost3Controls[1],getHeight()/20,null,null),this,17),150,270);
        addObject(new Button(new GreenfootImage(ghost3Controls[2],getHeight()/20,null,null),this,18),150,290);
        addObject(new Button(new GreenfootImage(ghost3Controls[3],getHeight()/20,null,null),this,19),150,310);
        addObject(new Button(new GreenfootImage(ghost4Controls[0],getHeight()/20,null,null),this,20),150,330);
        addObject(new Button(new GreenfootImage(ghost4Controls[1],getHeight()/20,null,null),this,21),150,350);
        addObject(new Button(new GreenfootImage(ghost4Controls[2],getHeight()/20,null,null),this,22),150,370);
        addObject(new Button(new GreenfootImage(ghost4Controls[3],getHeight()/20,null,null),this,23),150,390);
        //buttons for AI Ghost or player Ghosts, and the same with Pacman 
        addObject(new Button(new GreenfootImage("Pacman",getHeight()/20,null,null),this,24),300,40);
        addObject(new Button(new GreenfootImage("Geist 1",getHeight()/20,null,null),this,25),300,120);
        addObject(new Button(new GreenfootImage("Geist 2",getHeight()/20,null,null),this,26),300,200);
        addObject(new Button(new GreenfootImage("Geist 3",getHeight()/20,null,null),this,27),300,280);
        addObject(new Button(new GreenfootImage("Geist 4",getHeight()/20,null,null),this,28),300,360);
        if(pacmanAI)
        {
            addObject(new Button(new GreenfootImage("KI",getHeight()/20,null,null),this,24),375,40);
        } else {
            addObject(new Button(new GreenfootImage("Spieler",getHeight()/20,null,null),this,24),375,40);
        }
        if(ghost1AI)
        {
            addObject(new Button(new GreenfootImage("KI",getHeight()/20,null,null),this,25),375,120);
        } else {
            addObject(new Button(new GreenfootImage("Spieler",getHeight()/20,null,null),this,25),375,120);
        }
        if(ghost2AI)
        {
            addObject(new Button(new GreenfootImage("KI",getHeight()/20,null,null),this,26),375,200);
        } else {
            addObject(new Button(new GreenfootImage("Spieler",getHeight()/20,null,null),this,26),375,200);
        }
        if(ghost3AI)
        {
            addObject(new Button(new GreenfootImage("KI",getHeight()/20,null,null),this,27),375,280);
        } else {
            addObject(new Button(new GreenfootImage("Spieler",getHeight()/20,null,null),this,27),375,280);
        }
        if(ghost4AI)
        {
            addObject(new Button(new GreenfootImage("KI",getHeight()/20,null,null),this,28),375,360);
        } else {
            addObject(new Button(new GreenfootImage("Spieler",getHeight()/20,null,null),this,28),375,360);
        }
        //back button
        addObject(new Button(new GreenfootImage("Zurück",getHeight()/20,null,null),this,29),550,390);
    }

    public String ask(String question)
    {
        String answer="";
        answer=Greenfoot.ask(question);
        clickCooldown=10;
        return answer;
    }

    public void removeAllObjects()
    {
        for(Object o : getObjects(null))
        {
            Actor a = (Actor) o;
            removeObject(a);
        }
    }

    public void buttonClick(int number)
    {
        if(clickCooldown==0 && number==1)
        {
            startGame(); 

        } else if(clickCooldown==0 && number==2)
        {
            goToMenu();

        } else if(clickCooldown==0 && number==3)
        {
            goToHelp();

        } else if(clickCooldown==0 && number==4)
        {
            pacmanControls[0]=ask("Auf was soll Pacman oben gesetzt werden?");

        } else if(clickCooldown==0 && number==5)
        {
            pacmanControls[1]=ask("Auf was soll Pacman links gesetzt werden?");

        } else if(clickCooldown==0 && number==6)
        {
            pacmanControls[2]=ask("Auf was soll Pacman unten gesetzt werden?");

        } else if(clickCooldown==0 && number==7)
        {
            pacmanControls[3]=ask("Auf was soll Pacman rechts gesetzt werden?");

        } else if(clickCooldown==0 && number==8)
        {
            ghost1Controls[0]=ask("Auf was soll Geist 1 oben gesetzt werden?");

        } else if(clickCooldown==0 && number==9)
        {
            ghost1Controls[1]=ask("Auf was soll Geist 1 links gesetzt werden?");

        } else if(clickCooldown==0 && number==10)
        {
            ghost1Controls[2]=ask("Auf was soll Geist 1 unten gesetzt werden?");

        } else if(clickCooldown==0 && number==11)
        {
            ghost1Controls[3]=ask("Auf was soll Geist 1 rechts gesetzt werden?");

        } else if(clickCooldown==0 && number==12)
        {
            ghost2Controls[0]=ask("Auf was soll Geist 2 oben gesetzt werden?");

        } else if(clickCooldown==0 && number==13)
        {
            ghost2Controls[1]=ask("Auf was soll Geist 2 links gesetzt werden?");

        } else if(clickCooldown==0 && number==14)
        {
            ghost2Controls[2]=ask("Auf was soll Geist 2 unten gesetzt werden?");

        } else if(clickCooldown==0 && number==15)
        {
            ghost2Controls[3]=ask("Auf was soll Geist 2 rechts gesetzt werden?");

        } else if(clickCooldown==0 && number==16)
        {
            ghost3Controls[0]=ask("Auf was soll Geist 3 oben gesetzt werden?");

        } else if(clickCooldown==0 && number==17)
        {
            ghost3Controls[1]=ask("Auf was soll Geist 3 links gesetzt werden?");

        } else if(clickCooldown==0 && number==18)
        {
            ghost3Controls[2]=ask("Auf was soll Geist 3 unten gesetzt werden?");

        } else if(clickCooldown==0 && number==19)
        {
            ghost3Controls[3]=ask("Auf was soll Geist 3 rechts gesetzt werden?");

        } else if(clickCooldown==0 && number==20)
        {
            ghost4Controls[0]=ask("Auf was soll Geist 4 oben gesetzt werden?");

        } else if(clickCooldown==0 && number==21)
        {
            ghost4Controls[1]=ask("Auf was soll Geist 4 links gesetzt werden?");

        } else if(clickCooldown==0 && number==22)
        {
            ghost4Controls[2]=ask("Auf was soll Geist 4 unten gesetzt werden?");

        } else if(clickCooldown==0 && number==23)
        {
            ghost4Controls[3]=ask("Auf was soll Geist 4 rechts gesetzt werden?");
        } else if(clickCooldown==0 && number==24)
        {
            pacmanAI=!pacmanAI;
            clickCooldown=10;
        } else if(clickCooldown==0 && number==25)
        {
            ghost1AI=!ghost1AI;
            clickCooldown=10;
        } else if(clickCooldown==0 && number==26)
        {
            ghost2AI=!ghost2AI;
            clickCooldown=10;
        }  else if(clickCooldown==0 && number==27)
        {
            ghost3AI=!ghost3AI;
            clickCooldown=10;
        } else if(clickCooldown==0 && number==28)
        {
            ghost4AI=!ghost4AI;
            clickCooldown=10;
        } else if(clickCooldown==0 && number==29)
        {
            status="main";
        }
    }

    public void startGame()
    {
        Greenfoot.setWorld(new PacmanWorld(pacmanControls,ghost1Controls,ghost2Controls,ghost3Controls,ghost4Controls,pacmanAI,ghost1AI,ghost2AI,ghost3AI,ghost4AI));
    }

    public void goToMenu()
    {
        status="menu";
        removeAllObjects();
    }

    public void goToHelp()
    {
        status="help";
        removeAllObjects();
    }

    public void goToMain()
    {
        status="main";
        removeAllObjects();
    }
}
