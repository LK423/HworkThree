package Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameRun {
    int step;
    double hp;
    double mp;
    double miss;
    double attack;
    double defend;
    int level = 1;
    int exp = 0;
    boolean isLive = true;
    static String name;
    String w_name;
    String role;

    public int start() {
        System.out.println("*--------------------------------------人物选择-------------------------------------------*");
        name = getName();
        getRole();
        if (role == "法师") {
            Character character = new Character();
            Character.Mages player
                    = new Character.Mages(name, role, hp, attack, defend, mp);
            showPlayer();
        } else if (role == "战士") {
            Character.Warrior player
                    = new Character.Warrior(name, role, hp, attack, defend, miss);
            showPlayer();
        }
        System.out.println("等级:" + level + " 经验:" + exp);
        System.out.println("角色选择完毕,请选择是否进入游戏(yes or no)");
        Scanner sc = new Scanner(System.in);
        String judgment = sc.next();
        if (judgment.equals("yes")||judgment.equals("YES")) {
            System.out.print("正在载入游戏");
            for (int i = 0; i < 6; i++) {
                int a = 1000;
                System.out.print(".");
                a -=100;
                try {
                    Thread.sleep(a);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("...");
            System.out.println("*--------------------------------------载入游戏---------------------------------------*");
            return 0;
        } else if (judgment.equals("no")||judgment.equals("NO")) {
            System.out.println("*-----------------------不敢相信," + name + ",你直接选择了离开-------------------------------*");
            return 1;
        } else {
            System.out.println("*----------------------------你要不要看看你输入了什么------------------------------------*");
            return 1;
        }
    }
    public String getName() {
        System.out.println("请输入角色姓名");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        return name;
    }

    public void getRole() {
        int a = 1;
        while (a == 1) {
            System.out.println("请选择角色职业" + '\n' + "法师:1   战士:2");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    role = "法师";
                    hp = 100;
                    mp = 500;
                    attack = 30;
                    defend = 5;
                    a = 2;
                    break;
                case 2:
                    role = "战士";
                    hp = 200;
                    attack = 20;
                    defend = 20;
                    miss = 10;
                    a = 2;
                    break;
                default:
                    System.out.println("检索职业失败");
                    System.out.println("请重新选择");
                    a = 1;
                    break;
            }
        }
    }

    public void showPlayer() {
        if (role == "法师") {
            System.out.println("角色名称:" + Character.CharacterInformation.name + " 职业:"
                    + Character.CharacterInformation.role + " hp:" + Character.CharacterInformation.hp + " mp:"
                    + Character.Mages.mp + " 攻击力:" + Character.CharacterInformation.attack + " 防御力:"
                    + Character.CharacterInformation.defend);
        } else if (role == "战士") {
            System.out.println("角色名称:" + Character.CharacterInformation.name + " 职业:"
                    + Character.CharacterInformation.role + " hp:" + Character.CharacterInformation.hp + " mp:"
                    + Character.Warrior.miss + " 攻击力:" + Character.CharacterInformation.attack + " 防御力:"
                    + Character.CharacterInformation.defend);
        }
    }



    public void game_run() {
        Weapon0_ weapon = new Weapon0_();
        Weapon0_.Weapon01 weapon01= weapon.new Weapon01();
        w_name = weapon01.getName();
        List<Enemy> enemy = new ArrayList<Enemy>();
        enemy.add(new Enemy.Monster(1));
        enemy.add(new Enemy.Monster(2));
        enemy.add(new Enemy.Monster(3));
        if(start() == 1) return;
        int round = 1;
        double injured;
        do {
            System.out.println("***第 " + round + " 回合***");
            round ++;
            System.out.println("*"+Character.CharacterInformation.name+"遇到了"+Enemy.type);
            System.out.print("[#]");
            showPlayer();
            System.out.println("[#]武器: "+w_name);
            Enemy.show();
            if (role == "法师") {
                injured = Character.Mages.fight();
            } else {
                injured = Character.Warrior.fight();
            }
            switch (Character.CharacterInformation.buff){
                case 0:
                case -1://晕眩
                    Enemy.Monster.hp -= GameUtil.getLoseLife(injured,Enemy.defend);
                    break;
                case -2://减防
                    Enemy.Monster.hp -= GameUtil.getLoseLife(injured,Enemy.defend);
                    Random r1 = new Random();
                    double a1 = r1.nextInt(4);
                    Enemy.defend -= Character.CharacterInformation.defend * a1/10;
                    System.out.println(Enemy.type+"防御力降低了");
                    break;
                case -3://增防
                    Random r2 = new Random();
                    double a2 = r2.nextInt(4);
                    Character.CharacterInformation.defend += Character.CharacterInformation.defend * a2/10;
                    break;
                case -100://使用武器
                    Enemy.hp -= GameUtil.getLoseLife(weapon01.getAttack(),Enemy.defend);
                    break;
                default:
                    break;
            }
            if (Character.CharacterInformation.buff != -1){
                Character.CharacterInformation.hp
                        -=GameUtil.getLoseLife(Enemy.counterAttack(),Character.CharacterInformation.defend);
                System.out.println(Character.CharacterInformation.name + "受到了"
                        + (Enemy.counterAttack() - Character.CharacterInformation.defend) + "的伤害");
            }
            if(Enemy.Monster.hp<=0){
                System.out.println("怪物死亡,本回合结束");
                Character.CharacterInformation.exp += 10;
                weapon01.exp += 10;
                System.out.println("角色获取了10经验");
                try {
                    weapon01.levelUp();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                round = 1;
            }else if(Character.CharacterInformation.hp<=0){
                System.out.println("你已经死亡,游戏结束");
            }
        } while (Character.CharacterInformation.hp >0);
    }
}