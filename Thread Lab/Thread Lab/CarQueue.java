import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CarQueue {

	
	BlockingQueue<Integer> myqueue;
	Random navigate;
	
	public CarQueue()
	{
		myqueue = new LinkedBlockingQueue<Integer>();
		navigate = new Random();
		
		myqueue.add(navigate.nextInt(4));
		myqueue.add(navigate.nextInt(4));
		myqueue.add(navigate.nextInt(4));
		myqueue.add(navigate.nextInt(4));
	}
	
	public void addToQueue() {
		// TODO Auto-generated method stub
		class QueueRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					while(true)
					{
						myqueue.put(navigate.nextInt(4));
						Thread.sleep(100);
					}
				}
				catch(InterruptedException exception)
				{}
				finally
				{}
			}
		}
		Runnable runnabledata = new QueueRunnable();
		Thread thread = new Thread(runnabledata);
		thread.start();
	}

	public Integer deleteQueue() {
		try {
			return myqueue.take();
		} catch (InterruptedException e) {
			return 0;
		}
		
	}

}
