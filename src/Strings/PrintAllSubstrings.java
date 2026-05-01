package Strings;

public class PrintAllSubstrings {
    public static void main(String[] args) {
        String s = "Gopi";

//        int i = 0;
//        while(i < s.length()){
//            int j = i;
//            while(j < s.length()){
//                System.out.println(s.substring(i, j+1));
//                j++;
//            }
//            i++;
//        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.print(s.substring(i, j+1)+ "\t");
            }
            System.out.println();
        }
    }
}
