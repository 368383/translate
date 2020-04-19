
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class launchClass {
	private static ArrayList<String> all = new ArrayList<String>();
	private static ArrayList<String> english;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
		System.out.println("[SYSTEM MSG] THIS IS WHAT YOU PLAN TO TRANSLATE: ");
		printArray(all);
		english = formatArray();
		printOut();
	}

	private static void printOut() {
		System.out.println("[SYSTEM MSG] FINALIZED TEXT _____________________");
		for (int index = 0; index < all.size(); index++) {
			System.out.println(all.get(index));
			System.out.println(english.get(index));
		}

	}

	private static ArrayList<String> formatArray() {
		System.out.println("[SYSTEM MSG] BEGINNING TO TRANSLATE");
		ArrayList<String> english = new ArrayList<String>();
		for (int index = 0; index < all.size(); index++) {
			String trans = all.get(index);
			System.out.println("[SYSTEM PROCESSING]: Input for translate: " + trans);
			String combined = "";
			for (int i = 0; i < trans.length(); i++) {
				String input = trans.substring(i, i + 1);
				try {
					combined = combined + "[" + GoogleTranslator.translate("zh", "en", input) + "]";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			english.add(combined);
		}
		return english;
	}

	private static void read() {
		System.out.println("[SYSTEM MSG]\t INPUT DESIRED TEXT FOR CHINESE TO ENGLISH INDIVIDUAL CHARACTER TRANSLATION");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String input = in.nextLine();
			if (input == null || input.isEmpty()) {
				break;
			}
			all.add(input);
		}
		System.out.println("[SYSTEM MSG] TEXT FINISHED READING");
		in.close();
		ifFormat();
	}
	private static void ifFormat() {
		boolean format = false;
		for(String currentIndex: all) {
			if(currentIndex.length()>10) {
				format = true;
				System.out.println("[SYSTEM MSG] YOUR TEXT WILL BE FORMATTED FOR READABILTY");
				break;
			}
		}
	}
	

	private static String trimWhiteSpace(String input) {
		input = input.replaceAll("\\s+", "");
		return input;
	}

	private static void printArray(ArrayList<String> input) {
		for (String currentIndex : input) {
			System.out.println(currentIndex);
		}
	}

}
