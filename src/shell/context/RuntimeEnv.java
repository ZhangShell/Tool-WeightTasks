package shell.context;

import shell.task.AbstractTask;

/***
 * 运行时
 * 
 * @author Shell
 *
 */
public class RuntimeEnv {

	private static RuntimeEnv env = new RuntimeEnv();
	private TaskManager taskManager = TaskManager.getManager();
	
	public static RuntimeEnv getEnv() {
		return env;
	}
	
	public void submit(AbstractTask task) {
		
		taskManager.submit(task);
	}
	
	public void callback(AbstractTask task) {
		
		taskManager.callback(task);
	}
}
