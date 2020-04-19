
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleTranslator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "中文";
		System.out.println("中文");
        try {
			System.out.println("Translated text: " + translate("zh", "en", text));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String translate(String langFrom, String langTo, String text) throws IOException {
		// INSERT YOU URL HERE
		String urlStr = "https://script.google.com/macros/s/AKfycbyjJV_JHCzxR21vVMxpXqobPfD0tqUw_aVsxl05-ehbSwHe1Os/exec"
				+ "?q=" + URLEncoder.encode(text, "UTF-8") + "&target=" + langTo + "&source=" + langFrom;
		URL url = new URL(urlStr);
		StringBuilder response = new StringBuilder();
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

}
