package shell.context;

import java.util.ArrayList;
import java.util.List;

import shell.task.AbstractTask;
import shell.utils.PropertiesUtils;

public class Container {

	List<List<AbstractTask>> tasks = new ArrayList<List<AbstractTask>>();
	
	public void load() {
		
		//
		PropertiesUtils.load("task-weight.properties");
		
	}
	
	public List<AbstractTask> getTasks(int weight) {
		if(1 > weight || tasks.size() < weight) {
			throw new IllegalArgumentException("Invalid weight["+ weight +"], weight should be between [1, "+ tasks.size() +"]. ");
		}
		List<AbstractTask> ts = tasks.get(weight);
		if(null == ts) {
			throw new RuntimeException("No tasks set for weight["+ weight +"]. ");
		}
		
		return ts;
	}
}
