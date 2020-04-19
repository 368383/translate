package translate.dev;

import java.util.ArrayList;
import java.util.Scanner;

public class trim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> alpha = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) { // no need for "== true"
			String read = s.nextLine();
			if (read == null || read.isEmpty()) { // if the line is empty
				break; // exit the loop
			}
			alpha.add(read);
		}
		System.out.println(alpha);
	}

}
