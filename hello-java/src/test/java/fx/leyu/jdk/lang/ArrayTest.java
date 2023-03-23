package fx.leyu.jdk.lang;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ArrayTest {
    @Test(expected = ArrayStoreException.class)
    public void test() {
        String[] strings = new String[2];
        Object[] objects = strings;
        objects[0] = "string";
        objects[1] = 1;
    }

    @Test
    public void testValue() {
        List<Integer> x = Lists.newArrayList(0,1,2,3,4,5,6,7,8,9);
        x = x.subList(10,10);
        System.out.println(Arrays.toString(x.toArray()));

        String xx = "xx";
        System.out.println(Arrays.toString(StringUtils.split(xx, "##")));

        double value =8368.98 * 0.4;
        System.out.println(value);

        Calendar day = Calendar.getInstance();
        day.add(Calendar.YEAR, -3);
        long minStartTime = day.getTimeInMillis();
        System.out.println(minStartTime);

    }

        // 求数组中第 K 大的值
        // 实现 topK 函数
    @Test
        public void tesxt() {
            int[] arr = new int[]{2,3,4,2,1,3,4,5,6,6,90};
            int k = 6;

            int len = arr.length - 1;
        System.out.println(len);
            int beginIndex = (len -1) >>1;
        System.out.println(beginIndex);
            for(int i = beginIndex ;i>=0;i--){
                heap(arr,i,len);
            }

            for(int i = len;i>=len-k;i--){
                swap(arr,0,i);
                heap(arr,0,i);
            }
        System.out.println( arr[len-k]);
        }

        public void swap(int[] arr,int i ,int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = arr[i];
        }
        public void heap(int[] arr,int index ,int len){
            int l = (index >>1) +1;
            int r = l +1;
            int max = l;
            if (l > len){
                return;
            }
            if(r <= len && arr[r] > arr[l]){
                max = r;
            }
            if(arr[index] > arr[max]){
                swap(arr,max,index);
                heap(arr,max,len);
            }
        }
}
