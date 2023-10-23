package fx.leyu.algorithm.sort;

public class HeapSort {

	/**
	 * @param args
	 * ��������Ƚ��ѣ�Ȼ�������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] data = {1,2,3,4,5,6,7,8,9,10,1};
		
//		int data[] = {16,14,10,8,7,9,3,2,4,1};
		
		buildHeap(data);
		
		heapSort(data);
		
		out(data);

	}
	
	private static void buildHeap(int[] data) {
		// TODO Auto-generated method stub
		int heapSize = data.length;
		for(int i=data.length/2-1;i>=0;i--)
		{
			AjustHeap(data,i,heapSize);
		}
		
	}

	private static void AjustHeap(int[] data, int i,int heapSize) {//������
		// TODO Auto-generated method stub
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if(left<heapSize&&data[left]>data[largest]) //���������˳��ǧ���д����
		{
			largest = left;
		}
	   if(right<heapSize&&data[right]>data[largest])
		{
			largest = right;
		}
		if(i !=largest)
		{
			swap(data,i,largest);
			AjustHeap(data,largest,heapSize);
		}
		
		
	}

	private static void heapSort(int[] data) {
		// TODO Auto-generated method stub
		int heapSize = data.length;
		while(heapSize>0)
		{
			swap(data,0,heapSize-1);
			heapSize -= 1;
			AjustHeap(data,0,heapSize);
			
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
