package Demo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    private static URL url;

    static {
        try {
            url = new URL("https://www.nhaccuatui.com/bai-hat/the-thai-huong-ly.73T5LuURl5Bo.html");
//            url = new URL("https://www.nhaccuatui.com/bai-hat/anh-khong-tha-thu-dinh-dung-ft-acv.CE7Fwqox7j2h.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String k = getUrl();
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        String str = "style=\"height:auto;max-height:255px;overflow:hidden;\">(.*?)</p>";
        Content content1 = new Content(content, str,k);
        content1.show();
//        content1.addFile();
//        content1.readFile();
    }

    private static String getUrl() {
        String s = "";
        s += url;
        char[] arrayUrl = new char[s.length()];
        for (int i=0;i<s.length();i++){
            arrayUrl[i] = s.charAt(i);
        }
        return String.copyValueOf(arrayUrl,35,20);
    }
}
