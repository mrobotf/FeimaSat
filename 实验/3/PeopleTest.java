class People {
    protected double weight, height;
    public void speakHello() {
        System.out.println("Who am I?");
    }
    public void averageHeight() {
        height = 173;
        System.out.println("average height:" + height);
    }
    public void averageWeight() {
        weight = 70;
        System.out.println("average weight:" + weight);
    }
}
class ChinaPeople extends People{
    @Override
    public void speakHello() {
        System.out.println("哈喽，我是中国人");
        super.speakHello();
    }
    @Override
    public void averageHeight() {
        height = 168.78;
        System.out.println("我们中国人的平均身高: " + height + " 厘米");
        super.averageHeight();
    }

    @Override
    public void averageWeight() {
        weight = 65;
        System.out.println("我们中国人的平均体重: " + weight + " 公斤");
        super.averageWeight();
    }
    public void chinaGongfu() {
        System.out.println("坐如钟，站如松，睡如弓");
    }
}
class AmericanPeople extends People {
    @Override
    public void speakHello() {
        System.out.println("Hello, I am American!");
        super.speakHello();
    }

    @Override
    public void averageHeight() {
        height = 170;
        System.out.println("averageHeight: " + height + "cm");
        super.averageHeight();
    }

    @Override
    public void averageWeight() {
        weight = 66;
        System.out.println("averageWeight: " + weight + "kg");
        super.averageWeight();
    }

    public void americanBoxing() {
        System.out.println("The straight, hook");
    }
}
class BeijingPeople extends ChinaPeople {
    @Override
    public void speakHello() {
        System.out.println("您好，俺是北京人");
        super.speakHello();
    }
    public void beijingOpera() {
        System.out.println("京剧");
    }
}
class PeopleTest {
    public static void main(String[] args) {
        ChinaPeople chinapeople = new ChinaPeople();
        AmericanPeople americanPeople = new AmericanPeople();
        BeijingPeople beijingPeople = new BeijingPeople();
        chinapeople.speakHello();
        americanPeople.speakHello();
        beijingPeople.speakHello();

        chinapeople.averageHeight();
        americanPeople.averageHeight();
        beijingPeople.averageHeight();

        chinapeople.averageWeight();
        americanPeople.averageWeight();
        beijingPeople.averageWeight();

        chinapeople.chinaGongfu();
        americanPeople.americanBoxing();
        beijingPeople.beijingOpera();
        beijingPeople.chinaGongfu();
    }
}