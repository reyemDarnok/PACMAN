import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PACMAN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    //the lifes of pacman
    public int lifes = 3;
    //whether or not the pacman can eat ghosts
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
        ((PacmanWorld)getWorld()).getLifesCounter().update(Integer.toString(lifes));
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
            pW.removeObject(dot);
        }
    }

    /**
        handles turning
    **/
    public void turn()
    {
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class); 
        //if Pacman can turn left and the player wants to do so, do so. And the same for the other directions
        //he can do so if there is a) a junction that has the right direction available or 
        //b) it would be an u-turn
        if(Greenfoot.isKeyDown("left") && (junction != null && junction.getLeft() || getRotation()==0))
        {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("right") && (junction != null && junction.getRight() || getRotation()==180))
        {
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("up") && (junction != null && junction.getUp()||getRotation()==90))
        {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("down") && (junction != null && junction.getDown()||getRotation()==270))
        {
            setRotation(90);
        }
        // Add your action code here.    
    } 
}
