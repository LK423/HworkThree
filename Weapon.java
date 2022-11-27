package Game;
/*
   public abstract static class weapons{
       static String name;
       static String skill_name;
       static int time;
       static double attack;
       public weapons(String name,String skill_name,double attack){
           this.name = name;
           this.skill_name = skill_name;
           this.attack = attack;
       }
       public double skill(){
           return attack;
       }
   }
   //法杖
   public static class weapons1 extends weapons{
       public weapons1(String name,String skill_name,double attack){
           super(name,skill_name,attack);
       }
   }
   //近战
   public static class weapons2 extends weapons{
       public weapons2(String name,String skill_name,double attack){
           super(name,skill_name,attack);
       }
   }
    */
public interface Weapon {
    String getName();
    double getAttack();
    void levelUp();
}
