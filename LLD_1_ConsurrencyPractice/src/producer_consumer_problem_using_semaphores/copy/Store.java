package producer_consumer_problem_using_semaphores.copy;

import java.util.ArrayList;
import java.util.List;

public class Store
{
	
	int maxSize;
	List<String> items = new ArrayList<String>();
	
	public Store(int maxSize)
	{
		super();
		this.maxSize = maxSize;
	}
	
	
	
	public int getMaxSize()
	{
		return maxSize;
	}
	
	public void setMaxSize(int maxSize)
	{
		this.maxSize = maxSize;
	}

	public List<String> getItems()
	{
		return items;
	}
	
	public void setItems(List<String> items)
	{
		this.items = items;
	}
	
	
	/**
	 * Added synchronized to this method to make sure only 1 thread 
	 * accesses this method at a time. 
	 */
	public synchronized void addItem(String itemToadd)
	{
		items.add(itemToadd);
	}
	
	
	/**
	 * Added synchronized to this method to make sure only 1 thread 
	 * accesses this method at a time. 
	 */
	public synchronized  void removeItem()
	{
		items.remove(items.size() - 1);
	}
	

}
