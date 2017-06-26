import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * exists to be eaten by the Pacman.
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class Dot extends Actor
{
    //describes whether this dot is a simple dot or one of various powerups
    public int state;
    /**
        When the Dot is added to the wordl he gets a random state assigned. Everything not being 21 is normal
        @param world mandatory for method identification by Greenfoot
    */
    public void addedToWorld(World world)
    {
        state=Greenfoot.getRandomNumber(25);
        if(state==21)
        {
            //setImage(non-Default);
        }
    }
    
}
