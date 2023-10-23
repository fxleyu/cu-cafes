package fx.leyu.algorithm.sort;

import java.util.Scanner;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int data[] = new int[10];		
		input(data);*/
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		
	//	int data[] = {10,9,8,7,6,5,4,3,2,1};
		
		mergeSort(data,0,data.length-1);
		
		out(data);
		

	}

	private static void out(int[] data) {
		// TODO Auto-generated method stub
		for(int i =0;i<data.length;i++)
		{
			System.out.print(data[i]+"   ");
		}
		System.out.println();
		
	}

	private static void mergeSort(int[] data,int low,int high) {
		// TODO Auto-generated method stub
		int mid;
		if(low<high)
		{
			mid = (low+high)/2;
			mergeSort(data,low,mid);
			mergeSort(data,mid+1,high);
			merge(data,low,mid,high);
		}
		
	}

	private static void merge(int[] data, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int i = low;
		int j = mid+1;
		int len = high-low+1;
		int k = 0;
		int[] temp = new int[len];
		while(i<=mid && j<=high)
		{
			if(data[i]<data[j])
			{
				temp[k++] = data[i++];
			}
			else
			{
				temp[k++] = data[j++];
			}
		}
		
		while(i<=mid)
		{
			temp[k++] = data[i++];
		}
		while(j<=high)
		{
			temp[k++] = data[j++];
		}
		k = low;
		for(i=0;i<len;i++)
		{
			data[k++] = temp[i];
		}
		
	}

	private static  void input(int[] data) {
		// TODO Auto-generated method stub
		/*Scanner sca = new Scanner(System.in);
		for (int i = 0; i < data.length; i++) {
			data[i] = sca.nextInt();
		}*/
		 
		
	}

}
