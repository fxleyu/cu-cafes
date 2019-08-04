package fx.leyu.algorithm.sort;

public class SelectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	int data[] = {1,2,3,4,5,6,7,8,9,10};
		
		int data[] = {10,9,8,7,6,5,4,3,2,1,5};
		
		selectSort(data);
		
		out(data);

	}
	
	private static void selectSort(int[] data) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<data.length-1;i++)
		{
			int minIndex = i;
			
			for(int j=i+1;j<data.length;j++)
			{
				if(data[minIndex]>data[j])
				{
					minIndex = j;
					
				}
			}
			if(minIndex != i)
			{
				int temp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = temp;
			}
		}
		
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
