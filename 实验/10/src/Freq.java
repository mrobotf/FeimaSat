import java.io.*;
import java.util.*;

public class Freq{
    public static void main(String args[])throws Exception{
        File file = new File("D:\\java\\10\\file.txt");
        display(file);
    }
    public static void display(File file)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        while((line=br.readLine())!=null){
            line.toLowerCase();
            String reg1 = "\\s+";
            String reg2 ="^[a-zA-Z]\\w*";
            String str[] = line.split(reg1);
            for(String s: str){
                if(s.matches(reg2)){
                    if(!tm.containsKey(s)){
                        tm.put(s,1);
                    }
                    else{
                        tm.put(s,tm.get(s)+1);
                    }
                }
            }
        }
        System.out.println(tm);
    }
}