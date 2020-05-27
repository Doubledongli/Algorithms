	
	//面试题1:给定字符串str，搜索第m个只出现n次的字符，如给定字符串"tervestskt"，搜索第2个只出现1次的字符，输出v
	public static char 	searchChar(String input ,int m,int n){
		char [] inputChars = input.toCharArray();
		char result = inputChars[0];
		Map<Character,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<inputChars.length;i++){
			char curr = inputChars[i];
			if(map.containsKey(curr)){
				int ev = map.get(curr);
				map.put(curr, ev+1);
			}else{
				map.put(curr, 1);
			}
		}
		int input_m = 0;
		//遍历输出第m个出现n次第字符
		for(Character c:map.keySet()){
		
			if(map.get(c)==n){
				input_m++;
				if(input_m==m){
					return c;
				}
			}
			
		}
		
		
		
		return result;
	}
