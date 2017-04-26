import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PACMAN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    public int lifes = 3;
    public boolean powerup;
    /**
     * Act - do whatever the PACMAN wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        turn();
        eatDot();
        eatGhost();
    }

    public void eatGhost()
    {
        Ghost ghost= (Ghost) getOneIntersectingObject(Ghost.class);
        if(ghost!=null)
        {
            PacmanWorld pW = (PacmanWorld) getWorld();
            if(powerup)
            {
                pW.score+=20;
                pW.respawn(ghost);
            } else {
                if(--lifes>0)
                {
                    pW.respawn(this);
                } else {
                    pW.gameOver();
                }
            }
        }
    }

    public void eatDot()
    {
        Dot dot = (Dot) getOneObjectAtOffset(0,0,Dot.class);
        if(dot!=null)
        {
            PacmanWorld pW = (PacmanWorld) getWorld();
            pW.score++;
            pW.removeObject(dot);
        }
    }

    public void turn()
    {
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class); 
        if(Greenfoot.isKeyDown("left") && (junction != null && junction.left || getRotation()==0))
        {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("right") && (junction != null && junction.right || getRotation()==180))
        {
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("up") && (junction != null && junction.up||getRotation()==90))
        {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("down") && (junction != null && junction.down||getRotation()==270))
        {
            setRotation(90);
        }
        // Add your action code here.    
    } 
}
