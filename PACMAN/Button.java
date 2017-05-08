import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private Menu world;
    private int number;
    public Button(GreenfootImage image,Menu world,int number)
    {
        setImage(image);
        this.world=world;
        this.number=number;
    }
    
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            world.buttonClick(number);
        }
    }    
}
