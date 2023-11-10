package representation;

public abstract class Node {
    protected int id;
    protected String description;

    public Node(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public void display() {
        System.out.println(description);
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
    public String toString() {
        return "Node{id=" + id + ", description='" + description + "'}";
    }

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node node = (Node) obj;

        return id == node.id &&
               (description != null ? description.equals(node.description) : node.description == null);
    }
	
	 @Override
	    public int hashCode() {
	        int result = id;
	        result = 31 * result + (description != null ? description.hashCode() : 0);
	        return result;
	    }
	
	public abstract Node chooseNext();
}