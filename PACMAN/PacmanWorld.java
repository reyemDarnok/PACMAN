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
    private Pacman pacman;
    private Counter scoreCounter;
    private Counter lifesCounter;
    public int[] pacmanSpawn = new int[2];
    public int[] ghostSpawn = new int[2];
    String[] pacmanControls = new String[4];
    String[] ghost1Controls = new String[4];
    String[] ghost2Controls = new String[4];
    String[] ghost3Controls = new String[4];
    String[] ghost4Controls = new String[4];
    boolean pacmanAI=false;
    boolean ghost1AI=true;
    boolean ghost2AI=true;
    boolean ghost3AI=true;
    boolean ghost4AI=true;
    public PacmanWorld(String[] pacmanControls,String[] ghost1Controls,String[] ghost2Controls,String[] ghost3Controls,String[] ghost4Controls,boolean pacmanAI,boolean ghost1AI,boolean ghost2AI, boolean ghost3AI,boolean ghost4AI)
    {
        super(600, 400, 1);
        this.pacmanControls = pacmanControls;
        this.ghost1Controls = ghost1Controls;
        this.ghost2Controls = ghost2Controls;
        this.ghost3Controls = ghost3Controls;
        this.ghost4Controls = ghost4Controls;
        this.pacmanAI = pacmanAI;
        this.ghost1AI = ghost1AI;
        this.ghost2AI = ghost2AI;
        this.ghost3AI = ghost3AI;
        this.ghost4AI = ghost4AI;
        prepare();
        generateALevel();
        Junction junction = new Junction();
        pacman = new Pacman();
        addObject(pacman,100,100);
        addObject(new Dot(),200,100);
        addObject(new Dot(),210,100);
        addObject(new Ghost(pacman),220,100);
        addObject(new Dot(),230,100);
        addObject(new Dot(),240,100);
        addObject(junction,300,100);
    }
    public void generateALevel()
    {
        int rand = Greenfoot.getRandomNumber(1);
        if(rand==0)
        {
            level1();
        }
    }
    
    public void level1()
    {
        
    }
    
    public void prepare()
    {
        scoreCounter=new Counter("score: ");
        addObject(scoreCounter,50,15);
        lifesCounter=new Counter("Leben: ");
        addObject(lifesCounter,550,15);
    }
    public void act()
    {
        scoreCounter.update(Integer.toString(score));
    }
    public Counter getLifesCounter()
    {
        return lifesCounter;
    }
    public void respawn(Ghost ghost)
    {
        ghost.setLocation(ghostSpawn[0],ghostSpawn[1]);
        ghost.stun();
    }
    public void respawn(Pacman pacman)
    {
        pacman.setLocation(pacmanSpawn[0],pacmanSpawn[1]);
    }
    public void gameOver()
    {
        showText("GAME OVER!",300,200);
        Greenfoot.stop();
    }
}
