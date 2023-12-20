package representation;

public abstract class Node implements Event {
    protected int id;
    protected String description;

    public Node(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public void display() {
        char[] descriptionChars = description.toCharArray();

        for (char c : descriptionChars) {
            System.out.print(c);
            try {
                Thread.sleep(15); // Délai de 100 millisecondes entre chaque caractère
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Nouvelle ligne à la fin
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
	
	public abstract Event chooseNext();
}