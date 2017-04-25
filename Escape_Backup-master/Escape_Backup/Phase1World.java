import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phase1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phase1World extends World
{
    private Menu menu;
    private Phase2World p2W;
    private Phase3World p3W;
    private MapWorld mW;
    private int angle;
    private String[] controls = {"w","a","s","d","space","left","right","down","w","a","s","d"};
    /**
     * Constructor for objects of class Phase1.
     * 
     */
    public Phase1World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }

    public void setWorlds(Menu menu,Phase2World p2W, Phase3World p3W, MapWorld mW)
    {
        this.menu = menu;
        this.p2W = p2W;
        this.p3W = p3W;
        this.mW = mW;
    }
    public void setGlobals(String[] controls,int angle)
    {
        for(int i = 0; i<12;i++)
        this.controls[i] = controls[i];
        this.angle = angle;
    }
}
