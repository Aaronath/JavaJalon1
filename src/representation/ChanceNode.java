package representation;

import java.util.List;
import java.util.Random;

public class ChanceNode extends Node {
    protected List<Node> nextNodes;
    
    public ChanceNode(int id, String description) {
        super(id, description);
    }
    public ChanceNode(int id, String description, List<Node> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }
    
    

    public List<Node> getNextNodes() {
		return nextNodes;
	}
	public void setNextNodes(List<Node> nextNodes) {
		this.nextNodes = nextNodes;
	}
	@Override
    public Node chooseNext() {
        // Simulez un événement aléatoire en utilisant la classe Random.
        Random random = new Random();
        int randomChoice = random.nextInt(nextNodes.size());

        // Retournez le nœud correspondant au choix aléatoire.
        return nextNodes.get(randomChoice);
    }
}
