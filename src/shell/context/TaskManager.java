package shell.context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import shell.task.AbstractTask;
import shell.task.TaskFuture;
import shell.task.TaskFuture.State;

public class TaskManager {

	private ExecutorService worker = Executors.newCachedThreadPool();
	private ScheduledExecutorService supervisor = Executors.newScheduledThreadPool(1);
	
	private volatile int WEIGHT;
	
	private static TaskManager mgn;
	private TaskManager(){}
	public static TaskManager getManager() {
		if(null == mgn) {
			synchronized(TaskManager.class) {
				if(null == mgn) {
					mgn = new TaskManager();
				}
			}
		}
		return mgn;
	}
	
	{
		supervisor.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		}, 0, 3600, TimeUnit.SECONDS);
	}
	
	void submit(AbstractTask task) {
		Future<?> future = worker.submit(task);
		
		TaskFuture taskFuture = new TaskFuture(future, State.Submitted);
		task.setFuture(taskFuture);
		
	}
	
	void callback(AbstractTask task) {
		
	}
}
