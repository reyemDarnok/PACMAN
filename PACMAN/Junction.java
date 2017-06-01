import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Junction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Junction extends Actor
{
    //are there ways up, down,left or right?
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    /**
     * Act - do whatever the Junction wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Wall wall = (Wall) getOneObjectAtOffset(0,-100,Wall.class);
        if(wall == null)
        {
            right=true;
        }
        wall = (Wall) getOneObjectAtOffset(-100,0,Wall.class);
        if(wall == null)
        {
            up=true;
        }
        wall = (Wall) getOneObjectAtOffset(100,0,Wall.class);
        if(wall == null)
        {
            down=true;
        }
        wall = (Wall) getOneObjectAtOffset(0,100,Wall.class);
        if(wall == null)
        {
            left=true;
        }
        // Add your action code here.
    }    
    public boolean getUp()
    {
        return up;
    }
    public boolean getDown()
    {
        return down;
    }
    public boolean getRight()
    {
        return right;
    }
    public boolean getLeft()
    {
        return left;
    }
}
