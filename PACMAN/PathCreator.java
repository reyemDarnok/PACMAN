import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PathCreator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PathCreator extends Actor
{
    private PacmanWorld world;
    private int cellSize = 50;
   
    public void act()
    {
        world=(PacmanWorld) getWorld();
        do {
            for(int i =Greenfoot.getRandomNumber(4)+3;i>0;i--)
            {
                world.addObject(new Path(),getX(),getY());
                move(cellSize);
                if(hitEdgeIn(1))
                    break;
            }
            if(Greenfoot.getRandomNumber(4)==0)
            {
                PathCreator p = new PathCreator();
                world.addObject(p,getX(),getY());
                p.setRotation(getRotation()+90);
                world.addObject(new Junction(),getX(),getY());
            }
            if(Greenfoot.getRandomNumber(4)==0)
            {
                PathCreator p = new PathCreator();
                world.addObject(p,getX(),getY());
                p.setRotation(getRotation()-90);
                world.addObject(new Junction(),getX(),getY());
            }
            if(Greenfoot.getRandomNumber(10)==0)
            {
                world.removeObject(this);
                break;
            }
        } while(getOneObjectAtOffset(0,0,Path.class)!=null&&!hitEdgeIn(1));
    }

    public boolean hitEdgeIn(int steps)
    {
        boolean returnValue=false;
        if(getRotation()==0)
        {
            if(getX()+steps*cellSize<world.getWidth()-1)
            {
                returnValue=true;
            }
        }
        if(getRotation()==180)
        {
            if(getX()-steps*cellSize>0)
            {
                returnValue=true;
            }
        }
        if(getRotation()==90)
        {
            if(getY()+steps*cellSize<world.getHeight()-1)
            {
                returnValue=true;
            }
        }
         if(getRotation()==270)
        {
            if(getY()-steps*cellSize>0)
            {
                returnValue=true;
            }
        }
        return returnValue;
    }

    /**
     * Act - do whatever the PathCreator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
}
