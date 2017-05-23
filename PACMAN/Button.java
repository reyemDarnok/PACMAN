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
    private int height=5;
    private int width=5;
    public Button(GreenfootImage image,Menu world,int number)
    {
        setImage(image);
        this.world=world;
        this.number=number;
    }
    
    public Button(GreenfootImage image,Menu world,int number,int height, int width)
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

    public void test()
    {
        world.buttonClick(number);}
}
