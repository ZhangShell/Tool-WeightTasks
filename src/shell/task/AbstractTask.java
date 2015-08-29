package shell.task;

import shell.context.RuntimeEnv;
import shell.task.TaskFuture.State;

/***
 * 业务类模版
 * 
 * @author Shell
 *
 */
public abstract class AbstractTask implements Runnable{

	
	private TaskFuture future;
	
	/**
	 * 
	 */
	public abstract void execute();
	
	/**
	 * 刷新任务状态，并进行任务回调
	 */
	public void callback() {
		future.setState(State.Fini);
		
		RuntimeEnv.getEnv().callback(this);
	}
	
	public void run() {
		future.setState(State.Running);
		
		try {
			execute();
			
		} catch (Exception e) { e.printStackTrace();
		} finally {
			
			callback();
			
		}
	}

	/**
	 * @return the future
	 */
	public TaskFuture getFuture() {
		return future;
	}

	/**
	 * @param future could not be nil.
	 */
	public void setFuture(TaskFuture future) {
		if(null == future) {
			
			throw new IllegalArgumentException("future could not be nil. ");
		}
		this.future = future;
	}
	
}
