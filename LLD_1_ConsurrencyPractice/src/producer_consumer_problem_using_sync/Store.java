package producer_consumer_problem_using_sync;

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
	
	public void addItem(String itemToadd)
	{
		items.add(itemToadd);
	}
	
	
	public void removeItem()
	{
		items.remove(items.size() - 1);
	}
	

}
