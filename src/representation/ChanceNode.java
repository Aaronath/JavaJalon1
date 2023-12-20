package representation;

import java.util.List;
import java.util.Random;

public class ChanceNode extends Node {
    protected List<Event> nextNodes;
    
    public ChanceNode(int id, String description) {
        super(id, description);
    }
    public ChanceNode(int id, String description, List<Event> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }
    
    

    public List<Event> getNextNodes() {
		return nextNodes;
	}
	
	@Override
    public Event chooseNext() {
        // Simulez un événement aléatoire
        Random random = new Random();
        int randomChoice = random.nextInt(nextNodes.size());

        // Retournez le nœud correspondant au choix aléatoire.
        return nextNodes.get(randomChoice);
    }
	
	@Override
	public void setNextNodes(List<Event> nextNodes) {
	    this.nextNodes = nextNodes;
	}

}
