package representation;

import java.util.Arrays;
import java.util.List;

public class InnerNode extends Node {
    protected List<Event> nextNodes;

    public InnerNode(int id, String description, List<Event> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }
    
    public InnerNode(int id, String description) {
        super(id, description);
    }

    

	public List<Event> getNextNodes() {
		return nextNodes;
	}



	public void setNextNodes(List<Event> nextNodes) {
		this.nextNodes = nextNodes;
	}



	@Override
    public Event chooseNext() {
        if (nextNodes.isEmpty()) {
            // Gérez le cas où il n'y a pas de nœud suivant.
            return this; // Par défaut, revenez au nœud actuel.
        }
        return nextNodes.get(0);
    }
}
