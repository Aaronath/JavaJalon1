package representation;

import java.util.Arrays;
import java.util.List;

public class InnerNode extends Node {
    protected List<Node> nextNodes;

    public InnerNode(int id, String description, List<Node> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }
    
    public InnerNode(int id, String description) {
        super(id, description);
    }

    

	public List<Node> getNextNodes() {
		return nextNodes;
	}



	public void setNextNodes(List<Node> nextNodes) {
		this.nextNodes = nextNodes;
	}



	@Override
    public Node chooseNext() {
        if (nextNodes.isEmpty()) {
            // Gérez le cas où il n'y a pas de nœud suivant.
            return this; // Par défaut, revenez au nœud actuel.
        }
        return nextNodes.get(0);
    }
}
