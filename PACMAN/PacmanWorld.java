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
        super(1300, 800, 1);
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
        //testing
        Junction junction = new Junction();
        pacman = new Pacman();
        addObject(pacman,125,125);
        /*addObject(new Dot(),200,100);
        addObject(new Dot(),210,100);
        addObject(new Ghost(pacman),220,100);
        addObject(new Dot(),230,100);
        addObject(new Dot(),240,100);
         */addObject(junction,1215,125);
    }

    public void generateALevel()
    {
        int rand = Greenfoot.getRandomNumber(1);
        if(rand==0)
        {
            level1();
        }
    }

    public void levelCreator(Actor[] object)
    {
        for(int j=0;j<16;j++)
        {
            for(int i=0;i<26;i++)
            {
                if(object[i*26+j]!=null)
                    addObject(object[i*26+j],i*50+25,j*50+25);
            }
        }
    }

    public void level1()
    {
        Actor[] object=new Actor[26*16];
        for(int i=0; i<26;i++)
        {
            object[i]=new Wall();
            object[i+26*15]=new Wall();
        }
        for(int i =1; i<14;i++)
        {
            object[i*26]=new Wall();
            object[i*26+13]=new Wall();
        }
        for(int j=1;j<4;j++)
        {
            for(int i=1+j*26;i<5+j*26;i++)
            {
                object[i]=new Wall();
            }
            for(int i=6+j*26;i<9+j*26;i++)
            {
                object[i]=new Wall();
            }
            for(int i=10+j*26;i<14+j*26;i++)
            {
                object[i]=new Wall();
            }
            for(int i=15+j*26;i<18+j*26;i++)
            {
                object[i]=new Wall();
            }
            for(int i=19+j*26;i<23;i++)
            {
                object[i]=new Wall();
            }
        }
        levelCreator(object);
    }

    public void prepare()
    {
        scoreCounter=new Counter("score: ");
        addObject(scoreCounter,50,15);
        lifesCounter=new Counter("Leben: ");
        addObject(lifesCounter,1250,15);
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
