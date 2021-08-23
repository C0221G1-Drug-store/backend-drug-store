public class Test {
    public static void main(String[] args) {
        String a = "";
        for(int i=1 ; i<= 5;i++){
            for (int j= i; j<=5 ; j++){
                System.out.print(j+ " ");
            }
            a += " ";
            System.out.println();
            System.out.print(a);
        }
    }
}
