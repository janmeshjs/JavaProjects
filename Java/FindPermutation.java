public class FindPermutation {
    public static void findper(String str, String ans) {
        // Base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion

        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);

            String Newstr = str.substring(0, i)+str.substring(i+1);
            findper(Newstr, ans+curr);
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        findper(str, "");

    }
}
