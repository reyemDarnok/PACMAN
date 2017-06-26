import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An Object that needs to be placed at every turn so that the Actors can turn there
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class Junction extends Actor
{
    //are there ways up, down,left or right?
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    /**
     * checks where there are paths and adjusts the four attributes accordingly
     */
    public void act() 
    {
        Wall wall = (Wall) getOneObjectAtOffset(50,0,Wall.class);
        if(wall == null)
        {
            right=true;
        }
         wall = (Wall) getOneObjectAtOffset(0,50,Wall.class);
        if(wall == null)
        {
            down=true;
        }
         wall = (Wall) getOneObjectAtOffset(0,-50,Wall.class);
        if(wall == null)
        {
            up=true;
        }
         wall = (Wall) getOneObjectAtOffset(-50,50,Wall.class);
        if(wall == null)
        {
            left=true;
        }
        // Add your action code here.
    }    
    /**
        returns the value of up
    */
    public boolean getUp()
    {
        return up;
    }
    /**
        returns the value of down
    */
    public boolean getDown()
    {
        return down;
    }
    /**
        returns the value of right
    */
    public boolean getRight()
    {
        return right;
    }
    /**
        returns the value of left
    */
    public boolean getLeft()
    {
        return left;
    }
}
