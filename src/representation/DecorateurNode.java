package representation;

public abstract class DecorateurNode implements Event {
    Node node;
    
    public DecorateurNode(Node node) {
        this.node = node;
    }


    @Override
    public Node chooseNext() {
        return node.chooseNext();
    }


    @Override
    public void display() {
        node.display();
    }



}
