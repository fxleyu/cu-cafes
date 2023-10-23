package fx.leyu.algorithm.sort;

public class ShellSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int[] data = {1,2,3,4,5,6,7,8,9,10,1};
		
//		int data[] = {49,38,65,97,76,13,27,49,55,04};
		
		shellSort(data);
		
		out(data);

	}
	
	private static void shellSort(int[] data) {
		// TODO Auto-generated method stub
		
		int step = data.length/2;
		while(step>0)
		{
			for(int k=0;k<step;k++)
			{
				for(int i=k+step;i<data.length;i+=step)
				{
					for(int j=i;j-step>=0&&data[j]<data[j-step];j-=step)
					{
						swap(data,j,j-step);
					}
					
				}
			}
			
			step = step/2;
		}
		
		
	}

	private static void swap(int[] data, int i, int j) {
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
		System.out.println();
		
	}

}
