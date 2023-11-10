package representation;

public class TerminalNode extends Node {
    public TerminalNode(int id, String description) {
        super(id, description);
    }

    @Override
    public Node chooseNext() {
        // C'est un nœud terminal, donc le jeu se termine ici.
        return this;
    }
}

