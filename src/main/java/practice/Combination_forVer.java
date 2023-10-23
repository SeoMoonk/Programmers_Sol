package practice;

public class Combination_forVer {

    static String[] arr = {"A", "B", "C"};
    static String[] arr2 = {"A", "B", "C"};

    public static void main(String[] args) {

        //조합 반복문 (3C2)
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.printf("%s %s", arr[i], arr[j]);
                System.out.println();
            }
        }

        System.out.println("---".repeat(30));

        //중복 조합 반복문 (3C2)
        //단, 주의할점 -> 0번과 1번의 선택이 같을 수 있다는 것이지, AB와 BA 둘 다 허용하는 것이 아니다.
        for(int i=0; i<arr2.length; i++) {
            for(int j=i; j<arr.length; j++) {
                System.out.printf("%s %s", arr[i], arr[j]);
                System.out.println();
            }
        }
    }

}
