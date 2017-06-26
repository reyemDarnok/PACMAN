import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PACMANWorld extends World
{
    //the score of the player
    private int score;
    //the number of dots left(if zero, start next world)
    private int dots;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PACMANWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    /**
        removes a dot. Does not increase score.
        @param eaten the dot to be eaten
    **/
    public void removeDot(Dot eaten)
    {
        removeObject(eaten);
        dots--;
    }
}
