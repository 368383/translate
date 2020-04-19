
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class launchClass {
	private static ArrayList<String> all = new ArrayList<String>();
	private static ArrayList<String> english ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = read();
		System.out.println();
		System.out.println("Desired Text Entry:" + "\n" + input);
		english = formatArray();
		combined();
	}
	private static void combined() {
		System.out.println("FINALIZED TEXT _____________________");
		for(int index =0; index<all.size();index++) {
			System.out.println(all.get(index));
			System.out.println(english.get(index));
		}

	}

	private static ArrayList<String> formatArray() {
		System.out.println("BEGINNING TO TRANSLATE");
		ArrayList<String> english = new ArrayList<String>();
		for(int index = 0; index<all.size();index++) {
			String trans = all.get(index);
			System.out.println("Input for translate" +trans);
			String combined = "";
			for(int i =0;i<trans.length();i++) {
				String input = trans.substring(i,i+1);
				try {
					combined = combined + "["+GoogleTranslator.translate("zh","en",input)+"]";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			english.add(combined);
		}
		return english;
	}

	private static String read() {
		System.out.println("READING FILE");
		int counter = 0;
		Scanner in = new Scanner(System.in);
		while (in.hasNext() && counter < 15) {
			String input = in.next();
			all.add(input);
			System.out.println("Value "+counter+ " input " +input);
			counter++;
		}
		in.close();
		printArray(all);

		return combine(all);
	}

	private static void printArray(ArrayList<String> input) {
		System.out.println("Array Ouput");
		for (String currentIndex : input) {
			System.out.println(currentIndex);
		}
	}

	private static String combine(ArrayList<String> input) {
		String combined = "";
		for (String currentIndex : input) {
			combined = combined + currentIndex;
		}
		return combined;
	}

}
