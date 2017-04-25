import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapWorld extends World
{
    private Menu menu;
    private Phase2World p2W;
    private Phase3World p3W;
    private Phase1World p1W;
    private int angle;
    private String[] controls = {"w","a","s","d","space","left","right","down","w","a","s","d"};
    /**
     * Constructor for objects of class Map.
     * 
     */
    public MapWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }

    /**
      Sets the parameters of this World. Should be run in the beginning to avoid nullPointerErrors.
      @param menu The Menu World of the scenario
      @param p2W The Phase2World of the scenario
      @param p3W The Phase3World of the scenario
      @param p1W The Phase1World of the scenario
    **/
    public void setWorlds(Menu menu,Phase2World p2W, Phase3World p3W, Phase1World p1W)
    {
        this.menu = menu;
        this.p2W = p2W;
        this.p3W = p3W;
        this.p1W = p1W;
    }
    /**
        Sets the globals in this World. Should be run whenever the globals are changed.
        @param controls How the controls are currently set
        @param which angle the turret has
    **/
    public void setGlobals(String[] controls,int angle)
    {
        for(int i = 0; i<12;i++)
        this.controls[i] = controls[i];
        this.angle = angle;
    }
}
