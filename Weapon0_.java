package Game;

import java.util.Scanner;

public class Weapon0_{
    public class Weapon01 implements Weapon {
        String name;
        int level = 1;
        int exp;
        int expJudgment = 10;
        int a=10;//每一级经验梯度
        double attack;
        @Override
        public String getName() {
//            System.out.println("为你的武器取一个名字吧");
//            Scanner sc = new Scanner(System.in);
//            name = sc.next();
            name = "01";
            return name;
        }

        @Override
        public double getAttack() {
            attack = 10 * level;
            return attack;
        }

        @Override
        public void levelUp() {
            if(exp >= expJudgment){
                level ++;
                exp -= expJudgment;
                expJudgment += a;
                a *= 2;
            }
        }
    }
}
