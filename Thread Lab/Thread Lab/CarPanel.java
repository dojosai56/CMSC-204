import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               while(true)
	               {
	            	   direction = carQueue.deleteQueue();
	            	   //0=Up,1=dow, 2=right, 3=left
	            	   
	            	   if(direction == 0) {
	            		   y -= 10;
	            	   }else if(direction == 1) {
	            		   y += 10;
	            	   }else if(direction == 2) {
	            		   x += 10;
	            	   }else if(direction == 3) {
	            		   x -=10;
	            	   }
	            	   
	            	   // if at the boundary go in oppisite direction to stay in bounds
	            	   if(x+60 >= FRAME_WIDTH) {
	            		   x -= 10;
	            	   }else if(x <= 0) {
	            		   x += 10;
	            	   }
	            	   
	            	   if(y+30 >= FRAME_HEIGHT) {
	            		   y -= 10;
	            	   }else if(y <= 0) {
	            		   y += 10;
	            	   }
	            	   repaint();
	            	   Thread.sleep(delay*100);
	               }//animation loop
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      car1.draw(g2,x,y);    
   }
}
