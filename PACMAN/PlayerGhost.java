import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A ghost steered by a player
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class PlayerGhost extends Ghost
{
    //the ghosts controls
    private String[] controls=new String[4];
    /**
     * Act - do whatever the PlayerGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(wait<=0)
        {
            move();
            turn();
        } else {
            wait--;
        }
        blink();
    }

    /**
        constructor for the class
        @param number the identifier of the ghost
        @param controls the controls of the ghost
    */
    public PlayerGhost(int number,String[] controls)
    {
        this.number=number;
        this.controls=controls;
    }

    /**
        checks if turning is possible
    */
   public void turn()
    {
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class); 
        //if Pacman can turn left and the player wants to do so, do so. And the same for the other directions
        //he can do so if there is a) a junction that has the right direction available or 
        //b) it would be an u-turn
        if(Greenfoot.isKeyDown(controls[1]) && (junction != null && junction.getLeft() || getRotation()==0))
        {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown(controls[3]) && (junction != null && junction.getRight() || getRotation()==180))
        {
            setRotation(0);
        }
        if(Greenfoot.isKeyDown(controls[0]) && (junction != null && junction.getUp()||getRotation()==90))
        {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown(controls[2]) && (junction != null && junction.getDown()||getRotation()==270))
        {
            setRotation(90);
        }
        
    } 
}
