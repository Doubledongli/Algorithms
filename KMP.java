public class KMP {
 
    char[] s;
    char[] p;
    int[] next;
 
    public KMP(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        this.next = new int[this.p.length];
        getNext();
        for(int i=0;i<next.length;i++)
            System.out.print(next[i]+" ");
    }
 
    /**
     * 填充next数组 若pattern[k] == pattern[j]，则next[j + 1 ] = next [j] + 1 = k + 1；
     * 若pattern[k ] ≠ pattern[j]，如果此时pattern[ next[k] ] == pattern[j ]，则next[ j
     * + 1 ] = next[k] + 1，否则重复此过程。 现在前缀“p0 pk-1 pk” 去跟后缀 “pj-k pj-1
     * pj”匹配，发现在pk处匹配失败，那么前缀需要向右移动多少位呢？根据已经求得的前缀各个字符的next 值，可得前缀应该向右移动k -
     * next[k]位，相当于k = next[k]。 若移动之后，pk' = pj，则代表字符E前存在长度为next[ k' ] +
     * 1的相同前缀后缀； 否则继续递归k = next [k]，直到pk’’ 跟pj匹配成功，或者不存在任何k（0 < k < j）满足pk = pj
     * ，且 k = next[k] = -1停止递归。
     */
    public void getNext() {
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
 
    public int match(){
        int i=0;
        int j=0;
        while(i<s.length&&j<p.length){
            if(j==-1||s[i]==p[j]){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==p.length){
            return i-j;
        }
        else
            return -1;
    }
 
    public static void main(String[] args) {
        String s="BBC ABCDAB ABCDABCDABDE";
        String p="ABCDABD";
        KMP k=new KMP(s, p);
        System.out.println();
        System.out.println(k.match());
 
    }
}
