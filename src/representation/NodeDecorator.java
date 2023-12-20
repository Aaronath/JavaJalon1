package representation;

public abstract class NodeDecorator implements Event {
    protected Event decoratedEvent;

    public NodeDecorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    @Override
    public void display() {
        decoratedEvent.display();
    }

    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }

	public Event getDecoratedEvent() {
		return decoratedEvent;
	}
}

