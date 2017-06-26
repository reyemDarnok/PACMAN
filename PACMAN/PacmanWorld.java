import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The game world
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class PacmanWorld extends World
{
    //keeping track for removeRemovables()
    public ArrayList<Actor> removableObjects = new ArrayList<>();
    //the score
    public int score;
    //how many dots there are left on the current map
    public int dots;
    //the two counters
    private Counter scoreCounter;
    private Counter lifesCounter;
    //The spawnpoints
    public int[] pacmanSpawn = new int[2];
    public int[] ghost1Spawn = new int[2];
    public int[] ghost2Spawn = new int[2];
    public int[] ghost3Spawn = new int[2];
    public int[] ghost4Spawn = new int[2];
    //the controls (saved here to pass them on to the actors later)
    String[] pacmanControls = new String[4];
    String[] ghost1Controls = new String[4];
    String[] ghost2Controls = new String[4];
    String[] ghost3Controls = new String[4];
    String[] ghost4Controls = new String[4];
    //Are the Actors AIs or not 
    boolean pacmanAI=false;
    boolean ghost1AI=true;
    boolean ghost2AI=true;
    boolean ghost3AI=true;
    boolean ghost4AI=true;
    /**
        Constructor for a gameworld
        @param pacmanControls the Pacmans controls
        @param ghost1controls the first ghosts controls
        @param ghost2controls the second ghosts controls
        @param ghost3controls the third ghosts controls
        @param ghost4controls the fourth ghosts controls
        @param pacmanAI is the Pacman controlled by AI?
        @param ghost1AI is the first ghost controlled by AI?
        @param ghost2AI is the second ghost controlled by AI?
        @param ghost3AI is the third ghost controlled by AI?
        @param ghost4AI is the fourth ghost controlled by AI?
    */
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
    
    /**
        removes all tiles of the game (leaves the counters alone)
    */
    public void removeRemovables()
    {
        
        for(Actor intruder : removableObjects)
        {
            this.removeObject(intruder);
        }
        removableObjects.clear();
    }

    /**
        picks a prewritten level and generates it
    */
    public void makeLevel()
    {
        removeRemovables();
        int level=Greenfoot.getRandomNumber(1);
        if(level==0)
            level1();
    }
    
    /**
        creates the first level
    */
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
    
    /**
        constructs a level
        @layout what is at which place? The first index is the x coordinate, the second the y coordinate
    */
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
                    if(numberOfGhost==1)
                    {
                        ghost1Spawn[0]==x;
                        ghost1Spawn[1]==y;
                    }
                    if(numberOfGhost==2)
                    {
                        ghost2Spawn[0]==x;
                        ghost2Spawn[1]==y;
                    }
                    if(numberOfGhost==3)
                    {
                        ghost3Spawn[0]==x;
                        ghost3Spawn[1]==y;
                    }
                    if(numberOfGhost==4)
                    {
                        ghost4Spawn[0]==x;
                        ghost4Spawn[1]==y;
                    }
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
    /**
        places the counters in the world
    */
    public void prepare()
    {
        scoreCounter=new Counter("score: ");
        addObject(scoreCounter,100,30);
        lifesCounter=new Counter("Leben: ");
        addObject(lifesCounter,900,30);
    }

    /**
        updates the scorecounter and checks whether there has to be a new level
    */
    public void act()
    {
        scoreCounter.update(Integer.toString(score));
        if(dots<=0)
        {
            makeLevel();
        }
    }

    /**
        gives a reference to the lifesCounter
    */
    public Counter getLifesCounter()
    {
        return lifesCounter;
    }

    /**
        respawns the given ghost to the place where he first was and stuns him
        @param ghost the ghost that should respawn
    */
    public void respawn(Ghost ghost)
    {
        if(ghost.number()==1)
        ghost.setLocation(ghost1Spawn[0]*50+50,ghost1Spawn[1]*50+50);
        if(ghost.number()==2)
        ghost.setLocation(ghost2Spawn[0]*50+50,ghost2Spawn[1]*50+50);
        if(ghost.number()==3)
        ghost.setLocation(ghost3Spawn[0]*50+50,ghost3Spawn[1]*50+50);
        if(ghost.number()==4)
        ghost.setLocation(ghost4Spawn[0]*50+50,ghost4Spawn[1]*50+50);
        ghost.stun();
    }
    
    /**
        respawns the pacman to his first position 
        @param pacman the Pacman
    */
    public void respawn(Pacman pacman)
    {
        pacman.setLocation(pacmanSpawn[0]*50+50,pacmanSpawn[1]*50+50);
    }

    /**
        ends the game
    */
    public void gameOver()
    {
        showText("GAME OVER!",300,200);
        Greenfoot.stop();
    }
}
