import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class Button extends Actor
{
    private ButtonHosts world;
    private int number;
    private int height=5;
    private int width=5;
    /**
        constructor for a button. Hitbox size defaults to a 5 units square
        @param image the image of the Button
        @param world needed to tell the world that the button has been clicked
        @param number an identifier of what the button does (1 is starting the game for example). 0 is reserved for doing nothing
    */
    public Button(GreenfootImage image,ButtonHosts world,int number)
    {
        setImage(image);
        this.world=world;
        this.number=number;
    }
    /**
        constructor for a button
        @param image the image of the Button
        @param world needed to tell the world that the button has been clicked
        @param number an identifier of what the button does (1 is starting the game for example). 0 is reserved for doing nothing
        @param height the height of the Buttons hitbox (the sprite is not used because it glitched around for some reason)
        @param width the width of the Buttons hitbox (the sprite is not used because it glitched around for some reason)
    */
    public Button(GreenfootImage image,ButtonHosts world,int number,int height, int width)
    {
        setImage(image);
        this.world=world;
        this.number=number;
        this.height=height;
        this.width=width;
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        if(thisIsClicked())
        {
            world.buttonClick(number);
        }
    }   

    /**
        checks wether this button is clicked inside its hitbox or not
    */
    public boolean thisIsClicked()
    {
        boolean result=false;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null)
        {
            int mX = mouse.getX();
            int mY = mouse.getY();
            int x = getX();
            int y = getY();
            if((mX<x+width && mX>x-width) && (mY<y+height&&mY>y-height) && mouse.getButton()==1)
            {
                result = true;
            }
        }
        return result;
    }
}
