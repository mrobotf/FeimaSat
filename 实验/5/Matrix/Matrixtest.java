package Matrix;
import java.util.Arrays;
import java.io.*;
public class Matrixtest {
    public static void main(String[] args) {
        try{
            String file = "D:/java/5/Matrix/file.txt";
            String file_result = "result.txt";
            BufferedReader x = new BufferedReader(new FileReader(file));

            // 读取并分割文件数据
            String l = x.readLine();
            int z[] = Arrays.asList(l.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            int a = z[0];   // 矩阵行
            int b = z[1];   // 矩阵列

            Matrix A = new Matrix(a,b);
            for(int i = 0; i < a; i++) {
                l = x.readLine();
                z = Arrays.asList(l.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
                for(int j = 0; j < b; j++)
                    A.n[i][j] = z[j];
            }

            l = x.readLine();
            z = Arrays.asList(l.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            int c = z[0];
            int d = z[1];
            Matrix B = new Matrix(c,d);
            for(int i = 0; i < c; i++) {
                l = x.readLine();
                z = Arrays.asList(l.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
                for(int j = 0; j < d; j++)
                    B.n[i][j] = z[j];
            }
            x.close();

            System.out.println("运算结果如下:");
            BufferedWriter y = new BufferedWriter(new FileWriter(file_result));

            //矩阵相加
            Matrix C = A.plus(B);
            System.out.println("A+B=\n"+C);
            y.write("A+B:"+"\n");
            y.write(C.toString());

            //矩阵相减
            Matrix D = A.sub(B);
            System.out.println("A-B=\n"+D);
            y.write("A-B:"+"\n");
            y.write(D.toString());
            y.close();

            //判断矩阵相等
            Boolean flag = A.equals(B);
            if(flag == true)
              System.out.println("矩阵相等");
            if(flag == false)
               System.out.println("矩阵不相等");

            //修改A的第1行，第1列的对应元素
            A.setnumber(1,1,50);

            //取出A的第1行，第1列的那个元素
            double nu = A.getnumber(1,1);
            System.out.println("A[0][0]="+nu);
            System.out.println("已写入文件！");
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}