import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dot extends Actor
{
    public static boolean isPowerUp;
    public Dot()
    {
        if(Greenfoot.getRandomNumber(20)==1)
        {
            isPowerUp = true;
        } else {
            isPowerUp = false;
        }
    }
    /**
     * Act - do whatever the Dot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
    public void addedToWorld()
    {
        
    }
}
