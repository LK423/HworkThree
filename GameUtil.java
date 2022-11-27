package Game;


public class GameUtil {
    //求减少生命值的方法  方法用static 修饰 ，调用时 类名.方法名
    public static double getLoseLife(double attack,double defend){
        if(attack-defend > 0)
            return attack-defend;
        else{
            System.out.println("未能击破敌方装甲");
            return 0;
        }

    }
    //求a-b之间随机数方法
    public static int getNumber(int a,int b){
        //求任意两个数之间的随机数（int）
        return (int)(Math.random()*(b-a)+a);
    }
}
