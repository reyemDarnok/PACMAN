import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    String status = "main";
    String[] pacmanControls = new String[4];
    String[] ghost1Controls = new String[4];
    String[] ghost2Controls = new String[4];
    String[] ghost3Controls = new String[4];
    String[] ghost4Controls = new String[4];
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Button(new GreenfootImage("Eat'em all!",100,null,null),this,1),300,100);
        addObject(new Button(new GreenfootImage("Start",50,null,null),this,1),300,300);
        addObject(new Button(new GreenfootImage("Menü",50,null,null),this,1),150,300);
        addObject(new Button(new GreenfootImage("Hilfe",50,null,null),this,3),450,300);
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
    }

    public void act()
    {
        if(status.equals("main"))
        {
            addObject(new Button(new GreenfootImage("Eat'em all!",100,null,null),this,1),300,100);
            addObject(new Button(new GreenfootImage("Start",50,null,null),this,1),300,300);
            addObject(new Button(new GreenfootImage("Menü",50,null,null),this,2),150,300);
            addObject(new Button(new GreenfootImage("Hilfe",50,null,null),this,3),450,300);
        } else if(status.equals("menu"))
        {
            addObject(new Button(new GreenfootImage("Pacman oben",20,null,null),this,1),50,5);
        }
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
        if(number==1)
        {
            startGame(); 
        } else if(number==2)
        {
            goToMenu();
        } else 
        {
            goToHelp();
        }
    }

    public void startGame()
    {
        Greenfoot.setWorld(new PacmanWorld());
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
}
