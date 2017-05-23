import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerGhost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerGhost extends Ghost
{
    /**
     * Act - do whatever the PlayerGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        turn();

    }   

    public void turn()
    {
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class); 
        //if Pacman can turn left and the player wants to do so, do so. And the same for the other directions
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
