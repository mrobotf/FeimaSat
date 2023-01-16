import java.io.*;
public class FileConvert {
    public void readFile(String fileName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        InputStreamReader reader;
    }

    // 从文件逐行读取字符串，charsetName 用于指定文件字符编码
    public void readFile(String fileName, String charsetName)throws IOException{
        InputStream in = new FileInputStream(fileName);
        InputStreamReader reader;
        if (charsetName == null)
            reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in, charsetName);
        BufferedReader br = new BufferedReader (reader) ;
        String data;
        while((data = br. readLine()) != null)   //逐行读取数据
            System.out.println(data);
        br.close();
    }

    // 文件中的字符内容复制到另一个文件，并进行字符编码转换
    public void copyFile (String from, String charsetFrom, String to, String charsetTo ) throws IOException{
        InputStream in = new FileInputStream(from);
        InputStreamReader reader;
        if (charsetFrom == null)
         reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in, charsetFrom);
        BufferedReader br = new BufferedReader(reader);
        OutputStream out = new FileOutputStream(to);
        OutputStreamWriter writer = new OutputStreamWriter (out, charsetTo);
        BufferedWriter bw = new BufferedWriter(writer);
        String data;
        while((data = br. readLine()) != null)
            bw. write(data+ "\n");
        br.close();
        bw.close();
    }

    public static void main(String args[])throws IOException{
        FileConvert myapp = new FileConvert();
        myapp.readFile("test.txt");
        myapp.copyFile("test.txt", null, "unicode.txt","Unicode");
        myapp.copyFile("test.txt",null,"utf8.txt", "UTF-8");
        myapp.readFile("unicode.txt", "Unicode");
        myapp. readFile("utf8.txt", "UTF-8");
    }
}