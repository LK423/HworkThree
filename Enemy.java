package Game;

public class Enemy {
    static String type;// 名称
    static double hp;// 生命值
    static boolean isLive;// 是否活着
    static double attack;// 攻击力
    static double defend;// 防御力
    int maxLife;//最大生命
    double miss;// 躲避系数
    // 受伤
//    public static void injured() {
//        int n = GameUtil.getNumber(1,101);
//        if (n < miss) {
//            System.out.println("[#]"+"没打到");
//            return;
//        }
//        System.out.println("[#]"+type + ":受伤");
//        // 生命值减少
//        double loseLife = GameUtil.getLoseLife(Character.CharacterInformation.fight(), defend);
//        // double loseLife=g.getLoseLife(h.attack, defend);
//        // double loseLife=h.attack-defend;
//        hp -= loseLife;// life=life-30;
//        // 判断生命值是否小于0
//        if (hp < 0) {
//            hp = 0;
//            dead();// 死亡
//        } else {
//            show();// 显示状态
//        }
//    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public double getLife() {
        return hp;
    }


    public void setLife(int life) {
        this.hp = life;
    }


    public boolean isLive() {
        return isLive;
    }


    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }


    public double getAttack() {
        return attack;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }


    public double getDefend() {
        return defend;
    }


    public void setDefend(int defend) {
        this.defend = defend;
    }


    public double getMaxLife() {
        return maxLife;
    }


    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }


    public double getMiss() {
        return miss;
    }


    public void setMiss(int miss) {
        this.miss = miss;
    }


     //还击
    public static double counterAttack() {
        System.out.println(type+"发起了反击");
        return attack;
    }
    // 死亡
    public void dead() {
        isLive = false;
        System.out.println("[#]" + type + "挂了");
    }
    // 显示状态
    public static void show() {
        if(isLive){
            System.out.println("[#]"+type + " 生命值是：" + hp + " 存活");
        }else{
            System.out.println("[#]"+type + " 生命值是：" + hp + " 死亡");
        }
    }
    public static class Monster extends Enemy{
        public Monster(int t) {
            switch (t) {
                case 1:
                    this.setType("mon1tr");
                    this.setLife(100);
                    this.setAttack(10);
                    this.setDefend(20);
                    this.setMiss(20);
                    break;
                case 2:
                    this.setType("mon2tr");
                    this.setLife(200);
                    this.setAttack(15);
                    this.setDefend(25);
                    this.setMiss(30);
                    break;
                case 3:
                    this.setType("mon4tr");
                    this.setLife(300);
                    this.setAttack(35);
                    this.setDefend(10);
                    this.setMiss(60);
                    break;
                case 4:
                    this.setType("mon5tr");
                    this.setLife(500);
                    this.setAttack(20);
                    this.setDefend(60);
                    this.setMiss(70);
                    break;
                case 5:
                    this.setType("mon6tr");
                    this.setLife(400);
                    this.setAttack(35);
                    this.setDefend(30);
                    this.setMiss(70);
                    break;
                default:
                    System.out.println("error01");
                    break;
            }
            this.setLive(true);
            this.setMaxLife((int) this.getLife());
            //maxLife=life;
        }
    }
}