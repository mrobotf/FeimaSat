import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.*;

class Matrix {
    private int x, y;   // x: 行数   y: 列数
    private Float data[][];

    public Matrix(int x, int y, Float data[][]){
        this.x = x;   this.y = y;
        this.data = data;
    }

    public Matrix(int x, int y) {
        this.x = x;   this.y = y;
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                this.data[i][j] = Float.valueOf(0);
    }

    public Matrix() { }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Float[][] getData() {
        return data;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setData(Float[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuffer context = new StringBuffer();
        context.append("Matrix{" + "x=" + x + ", y=" + y + ", data=");
        for(int i = 0; i < x; i++) {
            context.append(Arrays.toString(data[i]));
        }
        context.append('}');
        String contextString = context.toString();
        return contextString;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return x == matrix.x && y == matrix.y && Arrays.equals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(x, y);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}

class NumFilter {
    // 判断是否为浮点数或整数
    public static float numberFloat(String i) {
        String pattern = "^(\\-|\\+)?\\d+(\\.\\d+)?$";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean isMatch = Pattern.matches(pattern, i);
            if(isMatch)
                break;
            System.out.println("请重新输入: ");
            i = scanner.next();
        }
        return Float.parseFloat(i);
    }

    // 判断是否为正整数
    public static int numberInt(String i) {
        String pattern =  "^[0-9]*[1-9][0-9]*$";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean isMatch = Pattern.matches(pattern, i);
            if(isMatch)
                break;
            System.out.println("输入不是整数，请重新输入");
            i = scanner.next();
        }
        return Integer.parseInt(i);
    }
}

// 矩阵运算
class MatrixOp{

    // 矩阵加法
    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix matrix = new Matrix();
        if(!(m1.getX() == m2.getX() && m1.getY() == m2.getY())) {
            System.out.println("矩阵行列不相同");
            return matrix;
        }

        int x = m1.getX();
        int y = m1.getY();
        matrix.setX(x);
        matrix.setY(y);
        Float data[][] = new Float[x][y];
        Float data1[][] = m1.getData();
        Float data2[][] = m2.getData();
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++) {
                data[i][j] = data1[i][j] + data2[i][j];
            }
        matrix.setData(data);
        return matrix;
    }

    // 矩阵减法，m = m1 - m2
    public static Matrix sub(Matrix m1, Matrix m2) {
        Matrix matrix = new Matrix();
        if(!(m1.getX() == m2.getX() && m1.getY() == m2.getY())) {
            System.out.println("矩阵行列不相同");
            return matrix;
        }

        int x = m1.getX();
        int y = m1.getY();
        matrix.setX(x);
        matrix.setY(y);
        Float data[][] = new Float[x][y];
        Float data1[][] = m1.getData();
        Float data2[][] = m2.getData();
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++) {
                data[i][j] = data1[i][j] - data2[i][j];
            }
        matrix.setData(data);
        return matrix;
    }
}

class PointTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Matrix m1 = inputMatrix(scanner);
        Matrix m2 = inputMatrix(scanner);
        Matrix m3 = new Matrix();

        scanner.close();

        m3 = MatrixOp.add(m1, m2);
        System.out.println(m3);

        m3 = MatrixOp.sub(m1, m2);
        System.out.println(m3);
    }

    // 输入矩阵信息
    public static Matrix inputMatrix(Scanner scanner) {
        System.out.println("先输入 x 和 y（行数和列数）, 再输入矩阵数据, 一行输完后再输入下一行, 全部输入完后回车");

        Matrix matrix = new Matrix();
        try {
            int x = NumFilter.numberInt(scanner.next());
            int y = NumFilter.numberInt(scanner.next());
            Float data[][] = new Float[x][y];

            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    data[i][j] = NumFilter.numberFloat(scanner.next());

            matrix.setY(y);
            matrix.setX(x);
            matrix.setData(data);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            return matrix;
        }
    }
}