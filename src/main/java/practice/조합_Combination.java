package practice;

public class 조합_Combination {
    
    static String[] arr = {"A", "B", "C", "D"};
    static int length;

    public static void main(String[] args) {

        length = arr.length;

        //1. 조합 반복문
        forCombination();

        System.out.println("---".repeat(10));
        
        //2. 중복 조합 반복문
        repetitionCombination();
    }
    
    static void forCombination() {

        for(int i=0; i<length; i++) {
            for(int j=i+1; j<length; j++) {
                System.out.println("%s %s".formatted(arr[i], arr[j]));
            }
        }
    }
    
    static void repetitionCombination() {
        
    }
    
}
