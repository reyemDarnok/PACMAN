import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // needed for the white color
/**
 * Is a counter. Used for counting lives and the score in this scenario
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class Counter extends Actor
{
    // a counter of what?
    private String prefix = "";
    /**
        constructor for a Counter
        @param prefix What is standing before the number
    */
    public Counter(String prefix)
    {
        this.prefix=prefix;
                setImage(new GreenfootImage(prefix+"3",30,Color.WHITE,null));
    }
    /**
        update the counters look
        @param text the new text to come after the prefix
    */
    public void update(String text)
    {
        setImage(new GreenfootImage(prefix+text,30,Color.WHITE,null));
    }
    
}
