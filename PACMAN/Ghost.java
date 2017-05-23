import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    //is the ghost vulnerable?
    private boolean blinking;
    //reference to the pacman for navigation purposes
    private Pacman pacman;
    //respawn waiting
    private int wait;
    /**
    Only for collision testing. Breaks navigation. DEPRECATED
     **/
    public Ghost()
    {}

    /**
    Main constructor.
    @param pacman A reference to the pacman that's to be hunted
     **/
    public Ghost(Pacman pacman)
    {
        this.pacman = pacman;
    }

    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(wait<=0)
        {
            move(1);
            turn();
        } else {
            wait--;
        }
    }

    public void stun()
    {
        wait=200;
    }
    
    /**
    Turns in the general direction of the pacman if allowed to
     **/
    public void turn()
    {
        //is there even a junction for turning there
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class);
        if(junction!=null)
        {
            //how far am I in the different dimensions from the pacman
            int offsetX = getX()-pacman.getX();
            int offsetY = getY()-pacman.getY();
            //an array for storing the priority of the directions
            int[] order = new int[4];
            //is the distance in x or y bigger? the bigger one is prioritised
            if(Math.abs(offsetX)>Math.abs(offsetY))
            {
                //if pacman is getRight()
                if(offsetX<0)
                {
                    //I want to go getRight() the most
                    order[0]=0;
                    //and getLeft() the least
                    order[3]=180;
                } else {
                    //and vice versa
                    order[0]=180;
                    order[3]=0;
                }
                if(offsetY<0)
                {
                    //same thing as above but with the y-axis
                    order[1]=90;
                    order[2]=270;
                } else {
                    order[1]=270;
                    order[2]=90;
                }
                //and the same with reversed x- and y-axis priorities
            } else {
                if(offsetX<0)
                {
                    order[1]=0;
                    order[2]=180;
                } else {
                    order[1]=180;
                    order[2]=0;
                }
                if(offsetY<0)
                {
                    order[0]=90;
                    order[3]=270;
                } else {
                    order[0]=270;
                    order[3]=90;
                }   
            } 
            //if you can go getLeft() and want to go getLeft()
            if(order[0]==0&&junction.getRight()==true)
            {
                setRotation(0);
            }else if(order[0]==90&&junction.getDown()==true)
            {
                setRotation(90);
            } else if(order[0]==180&&junction.getLeft()==true)
            {
                setRotation(180);
            } else if(order[0]==270&&junction.getUp()==true)
            {
                setRotation(270);
            } else if(order[1]==0&&junction.getRight()==true)
            {
                setRotation(0);
            } else if(order[1]==90&&junction.getDown()==true)
            {
                setRotation(90);
                //if the most desirable scenario is impossible, try the next(and so on)
            } else if(order[1]==180&&junction.getLeft()==true)
            {
                setRotation(180);
            } else if(order[1]==270&&junction.getUp()==true)
            {
                setRotation(270);
            } else if(order[2]==0&&junction.getRight()==true)
            {
                setRotation(0);
            } else if(order[2]==90&&junction.getDown()==true)
            {
                setRotation(90);
            } else if(order[2]==180&&junction.getLeft()==true)
            {
                setRotation(90);
            } else if(order[2]==270&&junction.getUp()==true)
            {
                setRotation(270);
            } else if(order[3]==0&&junction.getRight()==true)
            {
                setRotation(0);
            } else if(order[3]==90&&junction.getDown()==true)
            {
                setRotation(90);
            } else if(order[3]==180&&junction.getLeft()==true)
            {
                setRotation(180);
            } else if(order[3]==270&&junction.getUp()==true)
            {
                setRotation(270);
            } 
        } 
    }
}    

