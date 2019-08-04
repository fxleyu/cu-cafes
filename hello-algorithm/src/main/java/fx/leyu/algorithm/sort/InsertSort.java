package fx.leyu.algorithm.sort;

public class InsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//	int data[] = {1,2,3,4,5,6,7,8,9,10,1};
		
		int data[] = {10,9,8,7,6,5,4,3,2,1,5};
		
		insertSort2(data);
		
		out(data);

	}
	
	private static void insertSort(int[] data) {
		// TODO Auto-generated method stub
		
		int i,j,k;
		for( i=1;i<data.length;i++)
		{
			int temp = data[i];
			j = i-1;
			while(j>=0&&temp<data[j])
			{
				j--;
			}
			
			for( k=i-1;k>j;k--)
			{
				data[k+1] = data[k];
			}
			data[k+1] = temp;
				
		}
	}
	
	public static void insertSort2(int [] data) {//�������
		for(int i=1;i<data.length;i++)
		{
			for(int j=i;j>0&&data[j]<data[j-1];j--)
			{
				swap(data,j-1,j);
			}
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
