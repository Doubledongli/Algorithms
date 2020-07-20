public class Permute {
	
	public static List<List<Integer>> result  =  new ArrayList<>();
	public static  List<List<Integer>> permute(int[] nums){
		LinkedList<Integer> track = new LinkedList<>();
		backtrace(nums, track);
		return result;
	}
	
	public static  void backtrace(int[] nums,LinkedList<Integer> track) {
		if(track.size()==nums.length) {
			result.add(new LinkedList(track));
			return ;
		}
		for(int i=0;i<nums.length;i++) {
			if(track.contains(nums[i])) continue;
			track.add(nums[i]);
			backtrace(nums, track);
			track.removeLast();
		}
		
	}
	public static void main(String[] args) {
		int[] nums ={1,2,3,4};
		permute(nums);
		System.out.println(result);
	}

}
