public class QuickSort {
	public int[] QuickSort(int[] arrc,int left,int right){
		int arr[] = arrc;
		int i = left;
		int j = right;
		int pivot = i;
		if(left>right) return arr;
		while(i<j){
			while(i<j&&arr[j]>=arr[pivot]){
				j--;				
			}
			while(i<j&&arr[i]<=arr[pivot]){
				i++;
			}
			if(i<j)
			{
			int tmp;
			tmp = arr[j];
			arr[j] = arr[i];
			arr[i] = tmp;
			}
		}
	
			int tmp;
			tmp = arr[pivot];
			System.out.println(j);
			arr[pivot] = arr[j];
			arr[j] = tmp;
			pivot = j;
			QuickSort(arr,left,i-1);
			QuickSort(arr,i+1,right);

		return arr;

	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int arr[] = {77,1, 5, 6, 9, 3, 4, 55,2,33,12,32,54,43};
		System.out.println("The output line is: ");
		System.out.println("Start time:  "+System.currentTimeMillis());
		int ar[] = qs.QuickSort(arr, 0,arr.length-1);
		
		for(int s=0;s<ar.length;s++){			
			System.out.print(arr[s]+"  ");		
		}
		
		System.out.println("End time:  "+System.currentTimeMillis());
	}

}
