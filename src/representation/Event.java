package representation;

import java.util.List;

public interface Event {
    public void display();
    public Event chooseNext();
	public void setNextNodes(List<Event> asList);
	
}

