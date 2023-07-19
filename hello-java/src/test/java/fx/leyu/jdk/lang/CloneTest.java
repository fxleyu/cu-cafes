package fx.leyu.jdk.lang;

import org.junit.Test;

public class CloneTest {
    @Test
    public void test() {
        CloneObj obj = new CloneObj();
        obj.cloneObjItem = new CloneObjItem();
        obj.cloneObjItem.item = "HelloWorld";

        CloneObj objCopy = new CloneObj();
        //BeanUtils.copyProperties(obj, objCopy);
        System.out.println(obj.cloneObjItem);
        System.out.println(objCopy);
    }

    public static class CloneObj {
        private CloneObjItem cloneObjItem;


        public CloneObjItem getCloneObjItem() {
            return cloneObjItem;
        }

        public void setCloneObjItem(CloneObjItem cloneObjItem) {
            this.cloneObjItem = cloneObjItem;
        }
    }

    public static class CloneObjItem {
        private String item = "";


        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }
}
