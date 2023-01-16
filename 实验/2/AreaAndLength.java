class Trangle {
    double sideA, sideB, sideC, area, length;
    boolean flag;
    public Trangle(double a, double b, double c) {
        if(a+b>c && a+c>b && b+c>a) {
            this.sideA = a;
            this.sideB = b;
            this.sideC = c;
            flag = true;
        } else {
            flag = false;
        }
    }
    public double getLength() {
        length = sideA + sideB + sideC;
        return length;
    }
    public double getArea() {
        if(flag) {
            double p = (sideA + sideB + sideC)/2.0;
            area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
            return area;
        } else {
            System.out.println("不是三角形");
            return 0;
        }
    }
    public void setABC(double a, double b, double c) {
        if(a+b>c && a+c>b && b+c>a) {
            sideA = a;
            sideB = b;
            sideC = c;
            flag = true;
        } else {
            sideA = sideB = sideC = 0;
            flag = false;
        }
    }
}
class Lader {
    double above, bottom, height, area;
    Lader(double a, double b, double h) {
        above = a;
        bottom = b;
        height = h;
    }
    public double getArea() {
        area = (above+bottom)*height/2;
        return area;
    }
}
class Circle {
    double radius, area;
    Circle(double r) {
        if(r > 0) radius = r;
        else radius = 0;
    }
    double getArea() {
        return Math.PI * radius * radius;
    }
    double getLength() {return 2 * Math.PI * radius;}
    void setRadius(double newRadius) {
        if(newRadius > 0) radius = newRadius;
        else radius = 0;
    }
    double getRadius() {return radius;}
}

public class AreaAndLength {
    public static void main(String[] args) {
        double length, area;
        Circle circle = null;
        Trangle trangle = null;
        Lader lader = null;
        circle = new Circle(3);
        trangle = new Trangle(3, 4, 5);
        lader = new Lader(4, 8, 5);

        length = circle.getLength();
        System.out.println("圆的周长：" + length);
        area = circle.getArea();
        System.out.println("圆的面积" + area);

        length = trangle.getLength();
        System.out.println("三角形的周长：" + length);
        area = trangle.getArea();
        System.out.println("三角形的面积" + area);
        
        area = lader.getArea();
        System.out.println("梯形的面积" + area);

        trangle.setABC(12, 34, 1);
        area = trangle.getArea();
        System.out.println("三角形的面积" + area);
        length = trangle.getLength();
        System.out.println("三角形的周长：" + length);

    }
}