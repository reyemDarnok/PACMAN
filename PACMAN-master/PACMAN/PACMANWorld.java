import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PACMANWorld extends World
{
    private int score;
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
    public void removeDot(Dot eaten)
    {
        removeObject(eaten);
        dots--;
    }
}
