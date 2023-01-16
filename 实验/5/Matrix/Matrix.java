package Matrix;
public class Matrix{
    private int row;
    private int col;
    double [][]n = null;
    public Matrix(int a,int b){
        if(a > 0 && b > 0) {
            row = a;
            col = b;
            n = new double[row][col];
        }
        else{
             System.out.print("矩阵不成立！");
        }
    }

    public void setrow(int a){
        if(a > 0)
            row = a;
          else
             System.out.print("矩阵不成立！");
    }

    public int getrow(){
        return row;
    }

    public void setcol(int b){
         if(b>0)
              col = b;
         else
             System.out.print("矩阵不成立！");
    }

    public int getcol(){
        return col;
    }
    
    public void setnumber(int r,int c,double number){
        if(r <= row && c <= col)
            n[r-1][c-1] = number;
          else
             System.out.print("超出矩阵范围！");
    }

    public double getnumber(int r,int c){
        if(r > row || c > col) {
             System.out.print("超出矩阵范围！");
             System.exit(1);
        }
        return n[r-1][c-1];
    }

    public String toString() {
        String s = "";

        for(int i = 0; i < n.length; i++)
            for(int j = 0; j < n[i].length; j++) {
                s+=n[i][j];
                if(j < n[i].length)
                    s += " ";
                if(j == n[i].length-1)
                    s += "\n";
            }

        return s;
    }

    // 相加
    public Matrix plus(Matrix B) {
        if((row != B.row) || (col != B.col)){
            System.out.println("A不能与B运算");
            System.exit(1);
        }
        Matrix C = new Matrix(row,col);
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                C.n[i][j] = n[i][j] + B.n[i][j];

        return C;
    }

    // 相减
    public Matrix sub(Matrix B) {
        if((row != B.row) || (col != B.col)){
            System.out.println("A不能与B运算");
            System.exit(1);
        }

        Matrix D = new Matrix(row,col);

        for(int i = 0; i < row; i++)
            for(int j=0; j < col; j++)
                D.n[i][j] = n[i][j] - B.n[i][j];

        return D;
    }

    // 判断相等
    public Boolean equals(Matrix B) {
        Boolean flag = true;
        if((row != B.row) || (col != B.col))
            flag = false;
        else
            for(int i = 0; i < row; i++)
                for(int j=0; j < col; j++)
                    if(n[i][j] != B.n[i][j])
                        flag = false;

        return flag;
    }
}