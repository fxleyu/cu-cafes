package fx.leyu.designpattern.chainofresponsibility.handler;

import fx.leyu.designpattern.chainofresponsibility.MarkingHandler;

public class ChoicenessMarkingHandler extends MarkingHandler {
    @Override
    protected boolean marking() {
        System.out.println("精选");
        return false;
    }
}
