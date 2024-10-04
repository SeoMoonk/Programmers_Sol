package interview.array;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

    //한 번의 거래로 낼 수 있는 최대 이익을 산출하라.

    public static void main(String[] args) {

        int[] price = new int[]{8, 1, 5, 3, 6, 4};
        int answer1 = maxProfit1(price);
        int answer2 = maxProfit2(price);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    static int maxProfit1(int[] prices) {

        int maxProfit = 0;

        //구매 시점 순회, 처음부터 끝까지 차례대로 반복한다.
        for (int i = 0; i < prices.length; i++) {
            //판매 시점 순회, 구매 다음부터 끝까지 차례대로 반복한다.
            for (int j = i + 1; j < prices.length; j++) {
                //판매 시점 가격에서 구매 시점 가격을 뺄 때 가장 높은 금액 찾기
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    static int maxProfit2(int[] prices) {

        //최대 이익은 9, 저점은 임시로 첫 번째 값으로 지정
        int maxProfit = 0, minPrice = prices[0];

        //현재 값을 우측으로 차례대로 이동하면서 계산
        for (int price : prices) {
            //지금까지 저점 계산
            minPrice = Math.min(minPrice, price);

            //현재 값과 저점의 차이가 최대 이익인 경우 교체
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}