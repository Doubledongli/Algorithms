import java.util.Arrays;
//This is a RadixSort programming
public class RadixSort {
	public int[] radixSort(int[] data, int radix, int bitNum) {
		// generate a temporary array

		// the bucket number,1-10

		// sort the array from low bit to high bit
		for (int i = 0, rate = 1; i < bitNum; i++) {
			// set bucket each box as 0
			int[] tmp = new int[data.length];
			int[] bucket = new int[radix];
			System.arraycopy(data, 0, tmp, 0, data.length);
			for (int j = 0; j < data.length; j++) {
				int subkey = (data[j] / rate) % radix;
				bucket[subkey]++;
			}

			// set the bucket subNum to fit the output
			for (int j = 1; j < radix; j++) {
				bucket[j] = bucket[j] + bucket[j - 1];

			}
			// sort the array arrcoding to the bitNum
			for (int s = data.length - 1; s >= 0; s--) {
				int subkey = (tmp[s] / rate) % radix;
				data[--bucket[subkey]] = tmp[s];

			}

			// continue to sort the higher bit
			rate = rate * 10;

		}
		return data;
	}

	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] data = {  23, 43, 42, 3543, 546, 7345, 145,7625,156,1,0,545454545 };
		int radix = 10;
		int bitNum = 9;//equal the biggest number`s bit
		System.out.println("    " + bitNum);
		int[] result = rs.radixSort(data, radix, bitNum);
		for (int i = 0; i < result.length; i++) {
			System.out.print("    " + result[i]);
		}
	}

}
