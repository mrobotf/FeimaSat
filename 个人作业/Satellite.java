import java.util.*;

/**
 * 卫星信息：
 * 卫星ID、卫星名称、卫星轨道半径、卫星状态
 *
 * 包含卫星操作：
 * 修改信息、注册新卫星、休眠、激活卫星、删除卫星
 */
public class Satellite {

    Scanner inforIn = new Scanner(System.in);
    CheckOut Sat = new CheckOut();

    public void setSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 修改卫星信息
        System.out.print("请输入要修改卫星的 COSPARID: ");
        String Change = inforIn.next().toUpperCase();
        String temp = new String();
        
        Change = Sat.StrElementRCheck(id, Change, false); // 检查是否存在该卫星
        int index = id.indexOf(Change);

        System.out.print("请输入要修改卫星的属性\n1.COSPARID    2.卫星名称    3.轨道半径\n");
        temp = inforIn.next();
        // 检查输入
        while(temp.matches(".*[^0-9].*") || Integer.parseInt(temp) > 3 || Integer.parseInt(temp) < 1) {
            System.out.println("请输入整数 1 或 2 或 3");
            temp = inforIn.next();
        }

        String strChange = new String();
        switch(Integer.parseInt(temp)) {
            case 1:
                // 修改 COSPARID
                System.out.println("将卫星 COSPARID 修改为：");
                strChange = inforIn.next().toUpperCase();
                while(true) {
                    strChange = Sat.StrElementRCheck(id, strChange, true);
                    if(Sat.IDCheckRule(id, strChange)) {
                        System.out.println("请重新输入符合规定的 COSPARID");
                    }
                    else break;
                    strChange = inforIn.next();
                }
                Sat.ElementOpCheck(Change.equals(id.set(index, strChange)));
                break;

            case 2:
                // 修改 卫星名称
                System.out.println("将卫星名称修改为：");
                strChange = inforIn.next().toUpperCase();
                strChange = Sat.StrElementRCheck(name, strChange, true);
                Sat.ElementOpCheck(name.get(index).equals(name.set(index, strChange)));
                break;

            case 3:
                // 修改 轨道半径
                System.out.println("将卫星轨道修改为：");
                double tempOrbit;
                tempOrbit = inforIn.nextDouble();
                while(Sat.OrbitCheckRule(orbit, tempOrbit)) {
                    System.out.println("输入的轨道半径非法，请重新输入：");
                    tempOrbit = inforIn.nextDouble();
                }
                Sat.ElementOpCheck(orbit.get(index).equals(orbit.set(id.indexOf(Change), tempOrbit)));
                break;

            default:
                break;
        }
    }

    public void SignupSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 注册新卫星
        System.out.println("输入注册信息");
        String changeStr = new String();
        double changeDou;

        // 注册 COSPARID
        System.out.print("COSPARID: ");
        changeStr = inforIn.next().toUpperCase();

        while(true) {
            changeStr = Sat.StrElementRCheck(id, changeStr, true);
            if(Sat.IDCheckRule(id, changeStr)) {
                System.out.println("请重新输入符合规定的 COSPARID");
            }
            else break;
            changeStr = inforIn.next().toUpperCase();
        }
        Sat.ElementOpCheck(id.add(changeStr));

        // 注册 卫星名称
        System.out.print("卫星名称：");
        changeStr = inforIn.next().toUpperCase();
        changeStr = Sat.StrElementRCheck(name, changeStr, true);
        Sat.ElementOpCheck(name.add(changeStr));

        // 注册 轨道半径
        System.out.print("轨道半径：");
        changeDou = inforIn.nextDouble();
        while(Sat.OrbitCheckRule(orbit, changeDou)) {
            System.out.println("输入的轨道半径非法，请重新输入：");
            changeDou = inforIn.nextDouble();
        }
        Sat.ElementOpCheck(orbit.add(changeDou));

        // 注册 运行状态
        System.out.print("卫星运行状态( true 为可用，false 为休眠)：");
        while(true) {
            String temp = inforIn.next();
            boolean flag = false;
            switch (temp) {
                case "true":
                    avl.add(true);
                    flag = true;
                    break;
                case "false":
                    avl.add(false);
                    flag = true;
                    break;
                default:
                    System.out.println("请重新输入: ");
                    break;
            }
            Sat.ElementOpCheck(flag);
            if(flag) break;
        }
    }


    public void LockSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl){
        // 休眠卫星
        System.out.println("输入要休眠的卫星的 COSPARID: ");
        String idLock = inforIn.next();

        while(true) {
            idLock = Sat.StrElementRCheck(id, idLock, false);
            if(!avl.get(id.indexOf(idLock))) {
                System.out.println("该卫星已休眠，请重新输入 COSPARID: ");
                idLock = inforIn.next();
            }
            else break;
        }
        Sat.ElementOpCheck(avl.set(id.indexOf(idLock.toUpperCase()), false));
    }

    public void ActivateSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 激活卫星
        System.out.println("输入要激活卫星的 COSPARID: ");
        String idAct = inforIn.next();

        while(true) {
            idAct = Sat.StrElementRCheck(id, idAct, false);
            if(avl.get(id.indexOf(idAct))) {
                System.out.println("该卫星已激活，请重新输入，COSPARID: ");
                idAct = inforIn.next();
            }
            else break;
        }
        Sat.ElementOpCheck(!avl.set(id.indexOf(idAct.toUpperCase()), true));
    }

    public void DelSat(ArrayList<String> id, ArrayList<String> name, ArrayList<Double> orbit, ArrayList<Boolean> avl) {
        // 删除卫星
        System.out.println("通过卫星名称删除，COSPARID: ");
        String idDel = inforIn.next().toUpperCase();
        String check = new String();
        
        idDel =  Sat.StrElementRCheck(id, idDel, false);
        int index = id.indexOf(idDel);

        check = id.remove(index);
        name.remove(index);
        orbit.remove(index);
        avl.remove(index);
        Sat.ElementOpCheck(check.equals(idDel));
    }
}