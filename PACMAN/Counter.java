import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private String prefix = "";
    public Counter(String prefix)
    {
        this.prefix=prefix;
                setImage(new GreenfootImage(prefix+"3",30,Color.WHITE,null));
    }
    public void update(String text)
    {
        setImage(new GreenfootImage(prefix+text,30,Color.WHITE,null));
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
