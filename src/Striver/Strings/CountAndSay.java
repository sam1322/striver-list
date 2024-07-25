package Striver.Strings;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String ans = "";
        int cnt = 0, val = -1;
        String s = countAndSay(n - 1);
        for (int i = 0; i < s.length(); ++i) {
            if (cnt == 0) {
                val = s.charAt(i) - '0';
                cnt++;
            } else if (val != s.charAt(i) - '0') {
                ans += cnt;
                ans += val;
                val = s.charAt(i) - '0';
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if(cnt!=0){
            ans += cnt;
            ans += val;
        }
//        System.out.println("n = " + n + " ans = " + ans);
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
