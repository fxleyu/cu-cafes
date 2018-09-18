package fx.leyu.designpattern.chainofresponsibility;

public abstract class MarkingHandler {
    private MarkingHandler successor;
    protected String word;
    
    public void setSuccessor(MarkingHandler successor) {
        this.successor = successor;
    }
    
    public final void handleMarking() {
        System.out.println(word);
        if (marking()) {
            return;    
        }
        if (successor != null) {
            successor.handleMarking();
        }
        
    }

    protected abstract boolean marking();
}
