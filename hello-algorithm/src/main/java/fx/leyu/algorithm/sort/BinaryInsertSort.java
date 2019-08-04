package fx.leyu.algorithm.sort;

public class BinaryInsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  int data[] = {1,2,3,4,5,6,7,8,9,10,1};
		
//		int data[] = {10,9,8,7,6,5,4,3,2,1,5,4};
		
		binaryInsertSort(data);
		
		out(data);

	}
	
	private static void binaryInsertSort(int[] data) {
		// TODO Auto-generated method stub
		
		int low ,mid,high;
		int i,j;
		for( i=1;i<data.length;i++)
		{
			low = 0;
			high = i;
			int temp = data[i];
			while(low<=high)
			{
				mid =(low+high)/2;
				if(temp>data[mid])
				{
					low = mid+1;
				}
				else
				{
					high = mid-1;
				}
			}
			for( j=i-1;j>high;j--)
			{
				data[j+1] = data[j];
			}
			data[j+1] = temp;
		}
		
	}

	private static void swap(int data[],int i, int j) {
		// TODO Auto-generated method stub
		int temp =  data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static void out(int[] data) {
		// TODO Auto-generated method stub
		for(int i =0;i<data.length;i++)
		{
			System.out.print(data[i]+"   ");
		}
		System.out.println("");
		
	}


}
