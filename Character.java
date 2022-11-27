package Game;
//减防(-2) 眩晕(-1) 吸血 回血 增加防御力(-3) 武器(-10*)
import java.util.Random;
import java.util.Scanner;

public class Character {
    public abstract static class CharacterInformation {
        static String name;
        static String role;
        static double hp;//血条
        static double attack;//攻击力
        static double defend;//防御力
        static int buff = 0;//用于记录有特殊效果的攻击
        static int exp;
        public CharacterInformation(String name, String role, double hp, double attack, double defend) {
            this.name = name;
            this.role = role;
            this.hp = hp;
            this.attack = attack;
            this.defend = defend;
        }
        public void injured(double n){
        }
        public void addExp(double a){
        }
    }

    public static class Mages extends CharacterInformation {
        static double mp;
        public Mages(String name, String role, double hp, double attack, double defend, double mp) {
            super(name,role,hp,attack,defend);
            this.mp = mp;
        }
        public static double fight(){
            buff = 0;
            System.out.println("选择攻击方式"+'\n'
                    +"1.普通攻击/不消耗mp"+'\n'
                    +"2.晕眩,并造成攻击力随机比例的伤害/mp-5"+'\n'
                    +"3.降低防御力/mp-5"+'\n'
                    +"4.武器技能"+'\n'
                    +"其他.跳过回合");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n){
                case 1:
                    System.out.println(name+"使用了普通攻击");
                    buff = 0;
                    return attack;
                case 2:
                    mp -= 5;
                    double a1 = GameUtil.getNumber(1,10);
                    System.out.println(name+"使用了晕眩");
                    buff = -1;
                    return (attack*a1/10);
                case 3:
                    double a2 = GameUtil.getNumber(1,7);
                    mp -= 5;
                    buff =-2;
                    System.out.println(name+"决定破甲");
                    return (attack*a2/10);
                case 4:
                    System.out.println(name+"挥起了法杖");
                    buff = -100;
                    return 0;
                default:
                    return 0;
            }
        }
        public void injured(double n){
            hp -= n;
        }
        public void addExp(double a){
            exp += a;
        }
    }
    public static class Warrior extends CharacterInformation {
        static double miss;
        public Warrior(String name, String role, double hp, double attack, double defend, double miss) {
            super(name,role,hp,attack,defend);
            this.miss = miss;
        }
        public static double fight(){
            buff = 0;
            System.out.println("选择攻击方式"+'\n'
                    +"1.普通攻击/不消耗mp"+'\n'
                    +"2.使用重击/概率打出100%-200%攻击伤害"+'\n'
                    +"3.抗性增加"+'\n'
                    +"4.武器技能"+'\n'
                    +"其他.跳过回合");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n){
                case 1:
                    System.out.println(name+"使用了普通攻击");
                    return attack;
                case 2:
                    Random r = new Random();
                    double a = r.nextInt(10);
                    System.out.println(name+"使用了重击");
                    return (attack*(a+10)/10);
                case 3:
                    System.out.println(name+"决定再穿厚点");
                    buff = -3;
                    return 0;
                case 4:
                    System.out.println(name+"抄上了家伙");
                    buff = -100;
                    return 0;
                default:
                    return 0;
            }
        }
        public void injured(double n){
            hp -= n;
        }
        public void addExp(double a){
            exp += a;
        }
    }
}