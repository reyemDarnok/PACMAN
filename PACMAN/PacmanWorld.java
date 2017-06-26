import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    public ArrayList<Actor> removableObjects = new ArrayList<>();
    
    public int score;
    public int dots;
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
        super(1000, 800, 1);
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
        makeLevel();
    }
    
    public void removeRemovables()
    {
        
        for(Actor intruder : removableObjects)
        {
            this.removeObject(intruder);
        }
        removableObjects.clear();
    }

    public void makeLevel()
    {
        removeRemovables();
        int level=Greenfoot.getRandomNumber(1);
        if(level==0)
            level1();
    }

    public void level1()
    {
        String[][] layout= new String[19][14];
        for(int i=0;i<19;i++)
        {
            for(int y=0;y<14;y++)
            {
                layout[i][y]="wall";
            }
        }
        layout[4][3]="pacman";
        layout[5][3]="junction";
        layout[9][9]=null;
        construct(layout);
    }
    

    public void construct(String[][] layout)
    {
        int numberOfGhost=1;
        Pacman pacman;
        if(pacmanAI)
        {
            pacman=new AIpacman();
        } else {
            pacman=new Pacman(pacmanControls);
        }
        for(int x=0;x<19;x++)
        {
            for(int y=0;y<14;y++)
            {
                Actor toAdd = new Dot();
                if(layout[x][y]=="wall")
                {
                    toAdd=new Wall();
                } else if(layout[x][y]=="junction")
                {
                    toAdd=new Junction();
                } else if(layout[x][y]=="pacman")
                {
                    toAdd=pacman;
                    pacmanSpawn[0]=x;
                    pacmanSpawn[1]=x;
                } else if(layout[x][y]=="ghost")
                {
                    toAdd=new Ghost(pacman,numberOfGhost++);
                    if(numberOfGhost==1&&!ghost1AI||numberOfGhost==2&&!ghost2AI||numberOfGhost==3&&!ghost3AI||numberOfGhost==4&&!ghost4AI)
                    {
                        if(numberOfGhost==1)
                        {
                            toAdd=new PlayerGhost(numberOfGhost,ghost1Controls);
                        }
                        if(numberOfGhost==2)
                        {
                            toAdd=new PlayerGhost(numberOfGhost,ghost2Controls);
                        }
                        if(numberOfGhost==3)
                        {
                            toAdd=new PlayerGhost(numberOfGhost,ghost3Controls);
                        }
                        if(numberOfGhost==4)
                        {
                            toAdd=new PlayerGhost(numberOfGhost,ghost4Controls);
                        }
                    }
                } else {
                    dots++;
                }
                addObject(toAdd,50+x*50,100+y*50);
                removableObjects.add(toAdd);
            }
        }
    }

    public void prepare()
    {
        scoreCounter=new Counter("score: ");
        addObject(scoreCounter,100,30);
        lifesCounter=new Counter("Leben: ");
        addObject(lifesCounter,900,30);
    }

    public void act()
    {
        scoreCounter.update(Integer.toString(score));
        if(dots<=0)
        {
            makeLevel();
        }
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
        pacman.setLocation(pacmanSpawn[0]*50+50,pacmanSpawn[1]*50+50);
    }

    public void gameOver()
    {
        showText("GAME OVER!",300,200);
        Greenfoot.stop();
    }
}
