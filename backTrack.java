package backTracking;

public class backTrack {

    public static void findSubsets (String str, String ans, int i) {
        // base case 

        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("A null Set");
                
            } else {
                System.out.println(ans);
                
            }

            return;
            
        }

        // recursion step
        // if yes is chosen
        // it means that the character at i'th position willing to be part of the subset, so i append it to the new string ans
        findSubsets(str, ans+str.charAt(i), i+1);
        // if no is chosen
        // it means that the character at i'th position is not willing to be part of the
        // subset, so i don't append it to the new string ans
        findSubsets(str, ans, i+1);
    }


    public static void findPermutation(String str, String ans, int i) {
        // base case
        if(ans.length() == 3){
            System.out.println(ans);
        }
        if(str.length() == i){
            return;
        } 


        // iterate throught he string and place each char one by one to print all the n factorial permutation
        // place the char at ith position in the ans string
        findPermutation(str, ans+str.charAt(i),i+1);
        findPermutation(str, ans, i+1);
        
    }
    public static void main(String[] args) {

        String str = "abc";
        // findSubsets(str, "", 0);
        findPermutation(str, "", 0);


    }
    
}
