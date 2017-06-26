import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class AIpacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIpacman extends Pacman
{
    public AIpacman()
    {super(new String[4]);}
    
    /**
     * Act - do whatever the AIpacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         move();
        turn();
        eatDot();
        eatGhost();
        ((PacmanWorld)getWorld()).getLifesCounter().update(Integer.toString(lifes));
    }  
     public void move()
    {
        if(getRotation()==0)
        {
            if(getOneObjectAtOffset(25,0,Wall.class)==null)
                move(1);
        }
         if(getRotation()==90)
        {
            if(getOneObjectAtOffset(0,-25,Wall.class)==null)
                move(1);
        }
         if(getRotation()==180)
        {
            if(getOneObjectAtOffset(-25,0,Wall.class)==null)
                move(1);
        }
         if(getRotation()==270)
        {
            if(getOneObjectAtOffset(0,25,Wall.class)==null)
                move(1);
        }
    }
    /**
        Tries to eat a ghost. Damages Pacman if no powerup was eaten 
    **/
    public void eatGhost()
    {
        Ghost ghost= (Ghost) getOneIntersectingObject(Ghost.class);
        //if there is actually a ghost
        if(ghost!=null)
        {
            PacmanWorld pW = (PacmanWorld) getWorld();
            //if pacman has a powerup
            if(powerup)
            {
                //eat the ghost and get some points
                pW.score+=20;
                pW.respawn(ghost);
            } else {
                //if not and pacman survives this
                if(--lifes>0)
                {
                    //lose a live (--lives) and respawns
                    pW.respawn(this);
                } else {
                    //if that was the last live, go game over
                    pW.gameOver();
                }
            }
        }
    }

    /**
        tries to eat a dot
    **/
    public void eatDot()
    {
        Dot dot = (Dot) getOneObjectAtOffset(0,0,Dot.class);
        //if there is a dot
        if(dot!=null)
        {
            //get a point and kill the dot
            PacmanWorld pW = (PacmanWorld) getWorld();
            pW.score++;
            pW.dots--;
            pW.removeObject(dot);
        }
    }

    /**
        handles turning
    **/
    public void turn()
    {
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class); 
        if(junction!=null)
        {
            ArrayList<Integer> directions = new ArrayList<>();
            if(junction.getLeft())
            directions.add(180);
            if(junction.getUp())
            directions.add(90);
            if(junction.getRight())
            directions.add(0);
            if(junction.getDown())
            directions.add(270);
            setRotation(directions.get(Greenfoot.getRandomNumber(directions.size())));
        }
        

    } 
}
