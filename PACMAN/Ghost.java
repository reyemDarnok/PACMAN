import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    private boolean blinking;
    private Pacman pacman;

    public Ghost()
    {}
    
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
        move(1);
        turn();
    }

    public void turn()
    {
        Junction junction = (Junction) getOneObjectAtOffset(0,0,Junction.class);
        if(junction!=null)
        // Add your action code here.
        {
            int offsetX = getX()-pacman.getX();
            int offsetY = getY()-pacman.getY();
            int[] order = new int[4];
            if(Math.abs(offsetX)>Math.abs(offsetY))
            {
                if(offsetX<0)
                {
                    order[0]=0;
                    order[3]=180;
                } else {
                    order[0]=180;
                    order[3]=0;
                }
                if(offsetY<0)
                {
                    order[1]=90;
                    order[2]=270;
                } else {
                    order[1]=270;
                    order[2]=90;
                }
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

