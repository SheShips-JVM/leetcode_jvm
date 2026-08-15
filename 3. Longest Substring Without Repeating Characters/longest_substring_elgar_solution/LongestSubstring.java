import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubString {

    public int lengthOfTheLongestSubString(String l){

        Set<Character> subString=new HashSet<>();
        int leftPointer=0;
        int maxLength=0;

        for( int rightPointer=0;rightPointer<l.length();rightPointer++){

            while(subString.contains(l.charAt(rightPointer))){
                subString.remove(l.charAt(leftPointer));
                leftPointer++;

            }

            subString.add(l.charAt(rightPointer));
            int length=rightPointer-leftPointer+1;
            maxLength=Math.max(maxLength,length);
        }

        return maxLength;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your string :");
        String input= scanner.nextLine();

        LongestSubString longestSubString=new LongestSubString();
        int len=longestSubString.lengthOfTheLongestSubString(input);

        System.out.println("The length of the longest substring : " + len);
        scanner.close();


    }
}
