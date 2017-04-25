import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Ben Konrad Meyer 
 * @version 28.03.2017
 */
public class Menu extends World
{
    private Phase1World p1W = new Phase1World();
    private Phase2World p2W = new Phase2World();
    private Phase3World p3W = new Phase3World();
    private MapWorld mW = new MapWorld();
    private int[] textX = new int[100];
    private int[] textY = new int[100];
    private int index = 0;
    private boolean menu = false;
   
    //standard keylayout, customizable
    private String[] controlMap = {"Schiff oben","Schiff links","Schiff unten","Schiff rechts","Schiff Schuss","Geschütz links","Geschütz rechts",
            "Geschütz mitte","Person oben","Person links","Person unten","Person rechts"};
    private int angle;
    private String[] controls = {"w","a","s","d","space","left","right","down","w","a","s","d"};
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        text("ESCAPE_BACKUP",getWidth()/2,getHeight()/4);
        text("Start",getWidth()/2,getHeight()/2);
        text("Menu",getWidth()/2,getHeight()*3/4);
        p1W.setWorlds(this,p2W,p3W,mW);
        p2W.setWorlds(this,p1W,p3W,mW);
        p3W.setWorlds(this,p2W,p1W,mW);
        mW.setWorlds(this,p2W,p3W,p1W);        
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(!(mouse==null))
        {
            if(!menu)
            {
                // Are the buttons on the start screen pressed?
                if(mouse.getX()<400 && mouse.getX()>200 && mouse.getY()<350 && mouse.getY()>250 && mouse.getButton()==1)
                {   
                    showMenu();
                    Greenfoot.delay(100);
                } else if(mouse.getX()<400 && mouse.getX()>200 && mouse.getY()<250 && mouse.getY()>150 && mouse.getButton()==1){
                    startGame();
                }
            } else{
                int lIndex = (mouse.getY()+12)/25-1;
                if(lIndex<12 && mouse.getButton()==1)
                {
                    controls[lIndex] = Greenfoot.ask("Auf welche Taste möchtest du " + controlMap[lIndex] + " setzen.");
                    showMenu();
                } else if(mouse.getButton()==1)
                {
                    menu=false;
                    deleteAllText();
                    text("ESCAPE_BACKUP",getWidth()/2,getHeight()/4);
                    text("Start",getWidth()/2,getHeight()/2);
                    text("Menu",getWidth()/2,getHeight()*3/4);
                }
            }
        }
    }

    public void showMenu()
    {
        menu=true;
        deleteAllText(); 
        text("Schiff oben: ",75,25);
        text(controls[0],175,25); 
        text("Schiff links: ",75,50);
        text(controls[1],175,50);
        text("Schiff unten: ",75,75);
        text(controls[2],175,75);
        text("Schiff rechts: ",75,100);
        text(controls[3],175,100); 
        text("Schiff Schuss:",70,125);
        text(controls[4],175,125);
        text("Geschütz links: ",75,150);
        text(controls[5],175,150);
        text("Geschütz rechts:",75,175);
        text(controls[6],175,175);
        text("Geschütz mitte: ",75,200);
        text(controls[7],175,200);  
        text("Person oben: ",75,225);
        text(controls[8],175,225); 
        text("Person links: ",75,250);
        text(controls[9],175,250);  
        text("Person unten: ",75,275);
        text(controls[10],175,275);
        text("Person rechts: ",75,300);
        text(controls[11],175,300);
        text("Um eine Taste zu ändern,",450,188);
        text(" klicke auf ihrer Höhe.",450,213);
        text("Zurück",50,388);
    }

    public void startGame()
    {
        p2W.setGlobals(controls,angle);
        Greenfoot.setWorld(p2W);
    }

    public void text(String text, int x, int y)
    {
        showText(text,x,y);
        textX[++index] = x;
        textY[index] = y;
    }

    public void deleteAllText()
    {
        for(int i = 0; i <= index; i++)
        {
            showText(null,textX[i],textY[i]);
        }
        index=0;
    }
    
    public void setGlobals(String[] controls,int angle)
    {
        for(int i = 0; i<12;i++)
        this.controls[i] = controls[i];
        this.angle = angle;
    }
}
