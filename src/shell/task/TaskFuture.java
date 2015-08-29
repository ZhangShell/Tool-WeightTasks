package shell.task;

import java.util.concurrent.Future;

public class TaskFuture {

	public static enum State {
		Submitted,
		Running,
		Fini
	}
	
	private Future<?> future;
	private State state;

	public TaskFuture(){}
	public TaskFuture(Future<?> future, State state) {
		this.future = future;
		this.state = state;
	}
	
	/**
	 * @return the future
	 */
	public Future<?> getFuture() {
		return future;
	}

	/**
	 * @param future the future to set
	 */
	public void setFuture(Future<?> future) {
		this.future = future;
	}
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	
}
