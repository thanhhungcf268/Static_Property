package Demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Content {
    private String content;
    String str ;
    List<String> list = new ArrayList<>();
    String[] arrayString;
    String url;
    public Content(String content,String str,String url){
        this.str = str;
        this.content = content;
        this.url = url;
        this.getContent();
    }
    private void getContent(){
        content = content.replaceAll("\\n+", "");
        content = content.replaceAll("<br />","///");
        String TiLDE = "tilde;";
        content = content.replaceAll("&a"+TiLDE,"ã");
        String GRAVE = "grave;";
        content = content.replaceAll("&o"+ GRAVE,"ò");
        content = content.replaceAll("&i"+ GRAVE,"ì");
        content = content.replaceAll("&a"+ GRAVE,"à");
        content = content.replaceAll("&u"+ GRAVE,"ù");
        content = content.replaceAll("&e"+ GRAVE,"è");
        String ACUTE = "acute;";
        content = content.replaceAll("&a"+ ACUTE,"á");
        content = content.replaceAll("&u"+ ACUTE,"ú");
        content = content.replaceAll("&y"+ ACUTE,"ý");
        content = content.replaceAll("&i"+ ACUTE,"í");
        content = content.replaceAll("&o"+ ACUTE,"ó");
        content = content.replaceAll("&e"+ ACUTE,"é");
        String CiRC = "circ;";
        content = content.replaceAll("&e"+CiRC,"ê");
        content = content.replaceAll("&o"+CiRC,"ô");
        content = content.replaceAll("&a"+CiRC,"â");
        content = content.replaceAll("\\s{28}","");
        addArray();
    }
    public void addArray(){
        Pattern p = Pattern.compile(str);
        Matcher matcher = p.matcher(content);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        this.arrayString = list.get(0).split("///");
    }
    public void show(){
        for (String token: arrayString){
            System.out.println(token);
        }
    }
    public void addFile(){
        try {
            FileWriter f=new FileWriter(url+".txt");
            for (String s : arrayString){
                f.write(s+"\n");
            }
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void  readFile(){
        try {
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url+".txt")));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
