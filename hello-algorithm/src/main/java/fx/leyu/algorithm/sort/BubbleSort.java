package fx.leyu.algorithm.sort;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	int data[] = {1,2,3,4,5,6,7,8,9,10};
		
		int[] data = {10,9,8,7,6,5,4,3,2,1};
		
		bubbleSort(data);
		
		out(data);

	}
	
	private static void bubbleSort(int[] data) {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		for(int i=0;i<data.length && flag;i++)
		{
			flag = false;
		
			for(int j=0;j<data.length-i-1;j++)
			{
				if(data[j]>data[j+1])
				{
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
					flag = true;
					
				}
			}
		}
	
	}

	private static void out(int[] data) {
		// TODO Auto-generated method stub
		for(int i =0;i<data.length;i++)
		{
			System.out.print(data[i]+"   ");
		}
		System.out.println();
		
	}

}
