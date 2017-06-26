import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The Ghost chasing the Pacman
 * 
 * @author (Ben Konrad Meyer) 
 * @version (2017-06-26)
 */
public class Ghost extends Actor
{
    //is the ghost vulnerable?
    private boolean blinking;
    //and how long has he been blinking
    private int intervall;
    //reference to the pacman for navigation purposes
    private Pacman pacman;
    //Ghost number one, two, three or four
    protected int number;
    //respawn waiting
    protected int wait;
    /**
    Only for collision testing. Breaks navigation. DEPRECATED
     **/
    public Ghost()
    {}

    /**
    Main constructor.
    @param pacman A reference to the pacman that's to be hunted
    @param number Is this Ghost 1, 2, 3 or 4
     **/
    public Ghost(Pacman pacman,int number)
    {
        this.pacman = pacman;
        this.number=number;
    }
    /**
        gives the ghosts number
    */
    public int getNumber()
    {
        return number
    }

    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
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
        governs blinking
    */
    public void blink()
    {
        if(pacman.getPowerup()&&!blinking)
        {
            blinking==true;
            intervall=0;
        } else if(blinking){
            if(intervall++ % 20 <10)
            {
                setImage(images/junction.png); // the junction is a single pixel, effectively the ghost vanishes
            } else {
                setImage(images/Ghost.jpg);
            }
        } else if(!blinking){
            setImage(images/Ghost.jpg);
            intervall=0;
        }
        
    }

    /**
        stuns the Ghost for 200 ticks
    */
    public void stun()
    {
        wait=200;
    }
    /**
        checks if the ghost can move and does so if possible
    */ 
     public void move()
    {
        if(getRotation()==0)
        {
            if(getOneObjectAtOffset(25,0,Wall.class)==null)
                move(1);
        }
         if(getRotation()==90)
        {
            if(getOneObjectAtOffset(0,-25,Wall.class)==null)
                move(1);
        }
         if(getRotation()==180)
        {
            if(getOneObjectAtOffset(-25,0,Wall.class)==null)
                move(1);
        }
         if(getRotation()==270)
        {
            if(getOneObjectAtOffset(0,25,Wall.class)==null)
                move(1);
        }
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
                //if pacman is right
                if(offsetX<0)
                {
                    //I want to go right the most
                    order[0]=0;
                    //and left the least
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
            //if you can go left and want to go left
            if(order[0]==0&&junction.right==true)
            {
                setRotation(0);
            }else if(order[0]==90&&junction.down==true)
            {
                setRotation(90);
            } else if(order[0]==180&&junction.left==true)
            {
                setRotation(180);
            } else if(order[0]==270&&junction.up==true)
            {
                setRotation(270);
            } else if(order[1]==0&&junction.right==true)
            {
                setRotation(0);
            } else if(order[1]==90&&junction.down==true)
            {
                setRotation(90);
                //if the most desirable scenario is impossible, try the next(and so on)
            } else if(order[1]==180&&junction.left==true)
            {
                setRotation(180);
            } else if(order[1]==270&&junction.up==true)
            {
                setRotation(270);
            } else if(order[2]==0&&junction.right==true)
            {
                setRotation(0);
            } else if(order[2]==90&&junction.down==true)
            {
                setRotation(90);
            } else if(order[2]==180&&junction.left==true)
            {
                setRotation(90);
            } else if(order[2]==270&&junction.up==true)
            {
                setRotation(270);
            } else if(order[3]==0&&junction.right==true)
            {
                setRotation(0);
            } else if(order[3]==90&&junction.down==true)
            {
                setRotation(90);
            } else if(order[3]==180&&junction.left==true)
            {
                setRotation(180);
            } else if(order[3]==270&&junction.up==true)
            {
                setRotation(270);
            } 
        } 
    }
}    

