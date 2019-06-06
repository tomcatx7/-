package thread;

import java.util.Random;

public class Sort {
	public static void main(String[] args) {
		 int[] arr = arrGenerate(20, 100);
		 printArr(arr);
		 sort(arr);
		 printArr(arr);

	}

	public static void sort(int[] arr) {
		divideMergeSort(arr, 0, arr.length-1);
	}

	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		int len = arr.length - 1;
		for (int i = 0; i < len; i++) {
			// 先通过一次全遍历找到最大值，每完成一次，遍历次数就相应减一次
			for (int j = 0; j < len - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tem = 0;
					tem = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tem;
				}
			}

		}
		return;
	}

	// 选择排序
	public static void chooseSort(int[] arr) {
		int index = 0;
		// 默认从小到大排序
		for (int i = 0; i < arr.length; i++) {
			// 每次初始化索引为数组下标
			index = i;
			// 默认从初始下标遍历后续数组，找出最小值对应的索引
			for (int j = i; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			// 交换初始值与最小值
			int tem = arr[i];
			arr[i] = arr[index];
			arr[index] = tem;
		}
		return;
	}

	// 插入排序
	public static void insertSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int tem = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] < tem) {
				arr[j] = arr[j - 1];
				j--;
			}
			if (i != j) {
				arr[j] = tem;
			}
		}
		return;
	}

	//归并排序
	public static void divideMergeSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			//分组，划分成两组
			divideMergeSort(arr, begin, mid);
			divideMergeSort(arr, mid + 1, end);
			//合并
			merge(arr, begin, mid, mid + 1, end);
		}

	}

	private static void merge(int[] arr, int ls, int le, int rs, int re) {
		//保存合并数据的临时数组
		int[] tem = new int[arr.length];
		//临时数组的初始下标等于左数组初始下标
		int index = ls;
		//保存合并数组的开始和结束下标，目的是确定数组的合并范围，合并左右数组在原数组中是连续的
		int leftstart = ls, leftend = le, rightstart = rs, rightend = re;
		//左右数组都是有序的，当左右被分割到只有一个元素的情况下，才开始合并，因此可以保证后续合并数组都是有序的
		//依次取左右数组的首个元素做比较，将较小的放入tem数组
		while (ls <= le && rs <= re) {
			if (arr[ls] < arr[rs]) {
				tem[index++] = arr[ls];
				ls++;
			} else {
				tem[index++] = arr[rs];
				rs++;
			}
		}
		//将arr中剩余的未加入temp的数加入到temp中
		while (ls <= le) {
			//放入左数组
			tem[index++] = arr[ls];
			ls++;
		}
		while (rs <= re) {
			//放入右数组
			tem[index++] = arr[rs];
			rs++;
		}
		//将排序好的tem数组还原到arr数组中，还原的范围就是左右数组的leftstart，rightend
		while (leftstart <= rightend) {
			arr[leftstart] = tem[leftstart];
			leftstart++;
		}

	}

	@Deprecated
	public static void swap(int x, int y) {
		int tem = x;
		x = y;
		y = tem;
		return;
	}

	public static int[] arrGenerate(int size, int seed) {
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(seed);

		}
		return arr;
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();

	}

}
