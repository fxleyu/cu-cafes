package fx.leyu.designpattern.chainofresponsibility.handler;

import fx.leyu.designpattern.chainofresponsibility.MarkingHandler;

public class ChoicenessMarkingHandler extends MarkingHandler {
    protected String word = "精选开始";
    @Override
    protected boolean marking() {
        System.out.println("精选");
        return false;
    }
}
