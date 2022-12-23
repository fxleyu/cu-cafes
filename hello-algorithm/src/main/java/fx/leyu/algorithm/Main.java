package fx.leyu.algorithm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 数组 array 的 TOP K 最大值
        int[] array = new int[]{-2,2,3,4,4,5,-10,3,2,1,0,-1};

        int topK1 = topK(array, 8);
        System.out.println(topK1);
    }
    public static int topK(int[] arr,int n){
        //冒泡
        for(int i=0;i<arr.length;i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    int x=arr[j];
                    arr[j]=arr[i];
                    arr[i]=x;
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("------");
        }

        return arr[n];
    }
}