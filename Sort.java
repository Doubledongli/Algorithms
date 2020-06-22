package com.ldd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort {

	public static void printArray(int[] k) {
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i] + "->");
		}
	}

	// 1、冒泡排序
	public static void bubbleSort(int[] v) {
		for (int i = 0; i < v.length - 1; i++) {
			for (int j = 0; j < v.length - 1 - i; j++) {
				if (v[j] > v[j + 1]) {
					int temp = v[j + 1];
					v[j + 1] = v[j];
					v[j] = temp;

				}
			}

		}
		printArray(v);

	}

	// 2、快速排序
	public static void quickSort(int[] v, int low, int high) {
		int i = low;
		int j = high;
		int pivot = v[i];
		if (i < j) {
			while (i < j) {
				while (i < j && v[j] >= pivot)
					j--;
				if (i < j) {
					v[i] = v[j];
					i++;
				}
				while (i < j && v[i] <= pivot)
					i++;
				if (i < j) {
					v[j] = v[i];
					j--;
				}
			}
			v[i] = pivot;
			quickSort(v, low, i - 1);
			quickSort(v, i + 1, high);
		}

	}

	// 3、简单插入排序
	public static void insertSort(int[] v) {
		int n = v.length;
		int i, j;
		int temp;
		for (i = 1; i < n; i++) {
			temp = v[i];
			j = i - 1;
			while (j >= 0 && temp < v[j]) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = temp;

		}

	}

	// 4、希尔排序
	public static void shellSort(int[] v) {
		int d = v.length;
		while (d != 0) {
			d = d / 2;
			for (int g = 0; g < d; g++) {
				for (int i = g + d; i < v.length; i = i + d) {
					int j = i - d;
					int temp = v[i];
					while (j >= 0 && temp < v[j]) {
						v[j + d] = v[j];
						j = j - d;
					}
					v[j + d] = temp;
				}
			}

		}

	}

	// 5、简单选择排序
	public static void selectionSort(int[] v) {
		int temp;
		for (int i = 0; i < v.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[minIndex]) {
					minIndex = j;
				}
			}
			temp = v[i];
			v[i] = v[minIndex];
			v[minIndex] = temp;

		}
	}

	// 6、堆排序
	static int heap_lenth;

	public static void heapify(int[] v, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < heap_lenth && v[left] > v[largest]) {
			largest = left;
		}
		if (right < heap_lenth && v[right] > v[largest]) {
			largest = right;
		}
		if (largest != i) {
			swap(v, i, largest);
			heapify(v, largest);
		}

	}

	public static void buildMaxHeap(int[] v) {
		heap_lenth = v.length;
		for (int i = (int) Math.floor(heap_lenth / 2); i >= 0; i--) {
			heapify(v, i);
		}

	}

	// 7、归并排序
	  public static void mergeSort(int arr[], int l, int r) 
	  { 
	      if (l < r) 
	      { 
	          int m = l+(r-l)/2; 
	    
	          mergeSort(arr, l, m); 
	          mergeSort(arr, m+1, r);     
	          merge(arr, l, m, r); 
	      } 
	  }
	public static void merge(int arr[], int l, int m, int r) 
	  { 
	      int i, j, k; 
	      int n1 = m - l + 1; 
	      int n2 =  r - m; 

	      int L[] = new int[n1];
	      int R[] = new int[n2]; 

	      for (i = 0; i < n1; i++) 
	          L[i] = arr[l + i]; 
	      for (j = 0; j < n2; j++) 
	          R[j] = arr[m + 1+ j]; 

	      i = 0; 
	      j = 0; 
	      k = l; 
	      while (i < n1 && j < n2) 
	      { 
	          if (L[i] <= R[j]) 
	          { 
	              arr[k] = L[i]; 
	              i++; 
	          } 
	          else
	          { 
	              arr[k] = R[j]; 
	              j++; 
	          } 
	          k++; 
	      } 
	    
	      while (i < n1) 
	      { 
	          arr[k] = L[i]; 
	          i++; 
	          k++; 
	      } 
	    
	      while (j < n2) 
	      { 
	          arr[k] = R[j]; 
	          j++; 
	          k++; 
	      } 
	  } 
	// 8、计数排序
	public static void countSort(int[] v, int maxValue) {
		int[] bucket = new int[maxValue + 1];
		int sortedIndex = 0;
		int n = v.length;
		int bucketLen = maxValue + 1;
		for (int i = 0; i < n; i++) {
			if (bucket[v[i]] == 0) {
				bucket[v[i]] = 0;
			}
			bucket[v[i]] = bucket[v[i]] + 1;
		}
		for (int j = 0; j < bucketLen; j++) {
			while (bucket[j] > 0) {
				v[sortedIndex++] = j;
				bucket[j]--;
			}
		}

	}

	// 9、桶排序
	public static void bucketSort(int[] arr) {

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// 桶数
		int bucketNum = (max - min) / arr.length + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// 将每个元素放入桶
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}

		System.out.println(bucketArr.toString());

	}

	// 10、基数排序
	public static void radixSort(int[] array) {
		// 首先确定排序的趟数;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}
		// 建立10个队列;
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		// 进行time次分配和收集;
		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < array.length; j++) {
				// 得到数字的第time+1位数;
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}

	public static void swap(int[] v, int i, int j) {
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}

	public static void main(String[] args) {
		int[] k = { 3, 5, 6, 1, 4, 8, 9, 0, 2, 7 };
		radixSort(k);
		printArray(k);

	}

}
