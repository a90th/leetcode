package to.geekbang;

public class Lesson44_LetterOrDigit {

    public static void main(String[] args){
        String name="天生一对";
        System.out.println(name.length());
        for(int i=0;i<name.length();i++){
            if(Character.isLetterOrDigit(name.charAt(i))){
                System.out.println(name.charAt(i)+"is a letter");
            }
        }
    }
}
