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
    public int[] PacmanSpawn = new int[2];
    public int[] GhostSpawn = new int[2];
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Junction junction = new Junction();
        addObject(new Pacman(),100,100);
        addObject(new Ghost(),200,100);
        addObject(new Ghost(),210,100);
        addObject(new Ghost(),220,100);
        addObject(new Ghost(),230,100);
        addObject(new Ghost(),240,100);
        addObject(junction,200,100);
        junction.down=true;
        junction.up=true;
        junction.left=true;
        junction.right=true;
    }
    public void respawn(Ghost ghost)
    {
        
    }
    public void respawn(Pacman pacman)
    {
        
    }
    public void gameOver()
    {
        showText("GAME OVER!",300,200);
        Greenfoot.stop();
    }
}
