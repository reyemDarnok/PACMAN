import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
/**
 * Write a description of class Leveleditor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leveleditor extends World implements ButtonHosts
{
    int[][] layout = new int[19][14];
    /**
     * Constructor for objects of class Leveleditor.
     * 
     */
    public Leveleditor()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        prepare();
        setup();
    }

    public void act()
    {
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<14;j++)
            {
                if(layout[i][j]==0)
                    addObject(new Button(new GreenfootImage("Wall.jpg"),this,j*19+i,50,50),i*50+50,j*50+100);
                if(layout[i][j]==1)
                    addObject(new Button(new GreenfootImage("punkt.png"),this,j*19+i,50,50),i*50+50,j*50+100);
                if(layout[i][j]==2)
                    addObject(new Button(new GreenfootImage("junction.png"),this,j*19+i,50,50),i*50+50,j*50+100);
                if(layout[i][j]==3)
                    addObject(new Button(new GreenfootImage("Ghost.jpg"),this,j*19+i,50,50),i*50+50,j*50+100);
                if(layout[i][j]==4)
                    addObject(new Button(new GreenfootImage("pacman.png"),this,j*19+i,50,50),i*50+50,j*50+100);
            }
        }
        if(Greenfoot.isKeyDown("p"))
        {
           
            for(int i=0;i<19;i++)
            {
                for(int j=0;j<14;j++)
                {
                    if(layout[i][j]==0)
                        System.out.print("layout["+i+"]["+j+"]=\"wall\";");
                    else if(layout[i][j]==1)
                        System.out.print("layout["+i+"]["+j+"]=\"null\";");
                    else if(layout[i][j]==2)
                        System.out.print("layout["+i+"]["+j+"]=\"junction\";");
                    else if(layout[i][j]==3)
                        System.out.print("layout["+i+"]["+j+"]=\"ghost\";");
                    else if(layout[i][j]==4)
                        System.out.print("layout["+i+"]["+j+"]=\"pacman\";");
                    else  System.out.print("WTF HOW");
                }
                System.out.println("");
            }
        }
    }

    public void buttonClick(int number)
    {
        int x= number % 19;
        int y= number / 19;
        if(layout[x][y]++==5)
            layout[x][y]=0;
    }

    public void setup()
    {
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<14;j++)
            {
                layout[i][j]=0;
            }
        }
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<14;j++)
            {
                addObject(new Button(new GreenfootImage("Wall.jpg"),this,j*19+i,50,50),i*50+50,j*50+100);
            }
        }
    }

    public void prepare()
    {
        addObject(new Counter("score: "),100,30);
        addObject(new Counter("Leben: "),900,30);
    }
}