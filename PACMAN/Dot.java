import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dot extends Actor
{
    //describes whether this dot is a simple dot or one of various powerups
    public int state;
    
    public void addedToWorld(World world)
    {
        state=Greenfoot.getRandomNumber(25);
        if(state==21)
        {
            //setImage(non-Default);
        }
    }
    /**
     * Act - do whatever the Dot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
