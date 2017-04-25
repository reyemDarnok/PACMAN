import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Phase2Actor
{
    private Phase2World world;
    public void addedToWorld(World p2W)   
    {
        world=getWorldOfType(Phase2World.class);
    }

    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()     
    {
        if(Greenfoot.isKeyDown(world.getControls()[5]))
        {
            rotate("left");
        } else if(Greenfoot.isKeyDown(world.getControls()[6]))
        {
            rotate("right");
        } else if(Greenfoot.isKeyDown(world.getControls()[7]))
        {
            rotate("middle"); 
        } 
    }
    //y=1/720*(x-300)^2+275  
    //y=1/720*(x^2-600x+90000)+275
    //y=x^2/720-5*x/6+400
    public void rotate(String direction)
    {
        if(direction=="right" || direction=="middle" && getX()<300)
        {
            setLocation(getX()+1,(int)((double)(Math.pow(getX(),2)/720-5*getX()/6+400)));
            setRotation((int)(Math.atan((getX()/360-5/6))*180/Math.PI));
            System.out.println(Integer.toString((int)(Math.atan((getX()/360-5/6))*180/Math.PI)+90));
        } else if(direction=="left" || direction=="middle" && getX()>=300)
        {
            setLocation(getX()-1,(int)((double)(Math.pow(getX(),2)/720-5*getX()/6+400)));
            setRotation((int)((Math.atan((getX()/360-5/6))*180/Math.PI)));
        } else  
        {
            System.out.println("Illegal argument for Method rotate(String direction) in Turret.class.");
            System.out.println("Legal arguments: 'left','right','middle'");
            System.out.println("Given Argument: " + direction);
        }
    }
}
