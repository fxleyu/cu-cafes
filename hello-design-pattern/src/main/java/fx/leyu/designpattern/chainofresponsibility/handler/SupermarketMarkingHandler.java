package fx.leyu.designpattern.chainofresponsibility.handler;

import fx.leyu.designpattern.chainofresponsibility.MarkingHandler;

public class SupermarketMarkingHandler extends MarkingHandler {
    protected String word = "超市开始";

    @Override
    protected boolean marking() {
        System.out.println("超市");
        return true;
    }
}
