import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    public int score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void respawn(Ghost ghost)
    {
        
    }
    public void respawn(Pacman pacman)
    {
        
    }
    public void gameOver()
    {
        
    }
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Junction junction = new Junction();
        addObject(new Pacman(),100,100);
        addObject(new Dot(),200,100);
        junction.down=true;
        junction.up=true;
        junction.left=true;
        junction.right=true;
    }
}
