import java.util.Scanner;


public class UniqueCharacterCount {
	
	public static boolean checkUniqueCharacters(String str,char ch){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == ch){
				count++;
			}
		}
		if(count>1){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a String : ");
		int count =0;
		String str = s.next();
		for(int i=0; i<str.length(); i++){
			if(checkUniqueCharacters(str,str.charAt(i))){
				 count++;
			}
		}
		System.out.print("Count of unique characters = : " + count);
	}

}
