import java.util.*;
import java.util.regex.*;
import java.io.*;
/**
 * 功能：
 * 显示当前卫星列表、显示休眠卫星列表、名称模糊查找
 * 
 * 包含方法：
 * COSPARID 命名是否合规,
 * 卫星轨道是否合规,
 * String 类型数据是否有匹配,
 * 操作是否成功
 * 数据写入文件 
 * 从文件读取数据 
 */

public class CheckOut {

    Scanner inforIn = new Scanner(System.in);

    /*
    public void LoadSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 初始化卫星数据
        id.add("CS0001");
        id.add("CS0002");
        id.add("CS0003");
        id.add("CS0004");
        id.add("CS0005");

        name.add("红旗一号");
        name.add("红旗二号");
        name.add("红旗三号");
        name.add("风云一号");
        name.add("风云二号");

        orbit.add(1.50);
        orbit.add(2.00);
        orbit.add(2.50);
        orbit.add(3.50);
        orbit.add(3.00);

        avl.add(true);
        avl.add(true);
        avl.add(false);
        avl.add(true);
        avl.add(true);        
    }
    */

    public void CurrentSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 显示当前卫星列表
        for(int i = 0; i < id.size();i++) {
            System.out.println(id.get(i)+"              " + name.get(i)+"   " + orbit.get(i)+"        " + avl.get(i));
        }
    }

    public void DormSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 显示休眠卫星列表
        for(int i = 0; i < id.size();i++) {
            if(avl.get(i) == false)
            System.out.println(id.get(i)+"              " + name.get(i)+"   " + orbit.get(i));
        }
    }

    public void search(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl){
        // 按名称模糊查找
        String nameSearch;
        boolean flag = true;
        nameSearch = inforIn.nextLine();
        Pattern pattern = Pattern.compile(nameSearch);
        
        for(int i=0; i < name.size(); i++){
            Matcher matcher = pattern.matcher(name.get(i));
            if(matcher.find()){
                System.out.println("[COSPARID:"+id.get(i)+"    卫星名称:"+name.get(i)+"    卫星轨道:"+orbit.get(i)+"    状态: "+avl.get(i)+"]");
                flag = false;
            }
        }
        if(flag) {
            System.out.println("不存在该卫星\n");
        }
        else System.out.println("\n查找成功");
    }


    public boolean IDCheckRule(ArrayList<String> id, String idChange) {
        // COSPARID 是否符合命名规定
        // 不符合规定 返回 true
        if(idChange.length() != 6)
            return true;

        int flag = 0;   // flag == 6 说明符合条件

        // 判断国家编号(前两位)
        String codeNation = idChange.substring(0, 2);
        char c[] = codeNation.toCharArray();
        byte b[] = new byte[c.length];
        for (int i = 0; i < c.length; i++) {
            b[i] = (byte) c[i];
            if ((b[i] >= 97 && b[i] <= 122) || (b[i] >= 65 && b[i] <= 90)) {
                flag++;
            }
        }

        // 判断是否为数字(后四位)
        String codeNum = idChange.substring(2, 6);
        c = codeNum.toCharArray();
        b = new byte[c.length];
        for (int i = 0; i < c.length; i++) {
            b[i] = (byte) c[i];
            if (b[i] > 47 && b[i] < 58) {
                flag++;
            }
        }
        
        if(flag == 6) {
            return false;
        }
        else return true;
    }

    public boolean OrbitCheckRule(ArrayList<Double> orbit, double orbitChange) {
        // 要修改的卫星轨道是否符合规定
        // 不符合规定返回 true
        int i;
        for(i = 0; i < orbit.size(); i++)
            if(Math.abs(orbit.get(i) - orbitChange) < 0.2 || orbitChange < 1.2 || orbit.get(i).equals(orbitChange))
                return true;
        return false;
    }
    

    public String StrElementRCheck(ArrayList<String> arr, String target, boolean flag) {
        // 对 String 类型数据 判断是否有匹配
        // flag == true  target 不能存在于 arr 中
        // flag == false target 需要在 arr 中存在
        if(flag == false) {
            while(!arr.contains(target.toUpperCase())) {
                System.out.println("不存在该卫星，重新输入");
                target = inforIn.next().toUpperCase();
            }
        }
        else {
            while(arr.contains(target)) {
                System.out.println("已存在该卫星，重新输入");
                target = inforIn.next().toUpperCase();
            }
        }
        return target;
    }


    public void ElementOpCheck(boolean check) {
        // 操作是否成功
        if(check)
            System.out.println("操作成功");
        else System.out.println("操作失败");
    }


    public static void WriterData(String file, ArrayList<String> satId, ArrayList<String> satName, ArrayList<Double> satOrbit, ArrayList<Boolean> satAvl) throws IOException{
        // 数据写入文件
        FileOutputStream f = new FileOutputStream(file);
        BufferedWriter bw =new BufferedWriter(new FileWriter(file));
        for(int i = 0; i < satId.size(); i++){
            StringBuilder sb=new StringBuilder();
            sb.append(satId.get(i))
              .append(" ")
              .append(satName.get(i))
              .append(" ")
              .append(satOrbit.get(i).toString())
              .append(" ")
              .append(satAvl.get(i).toString());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }


    public static void ReadData(String file, ArrayList<String> satID, ArrayList<String> satName, ArrayList<Double> satOrbit, ArrayList<Boolean> satAvl) throws IOException {
        // 从文件读取数据
        FileInputStream fil = new FileInputStream(file);
        InputStreamReader fi = new InputStreamReader(fil, "GBK");
        BufferedReader satInfo = new BufferedReader(fi);

        String line;
        while ((line = satInfo.readLine()) != null) {
            String[] s =line.split(" ");
            satID.add(s[0]);
            satName.add(s[1]);
            satOrbit.add(Double.parseDouble(s[2]));
            satAvl.add(Boolean.valueOf(s[3]));
        }
        satInfo.close();
    }
}