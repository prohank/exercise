package competitive.leetcode.medium;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Date: 08-05-2020
 */
public class StockMaxProfit {
    public static void main(String[] args) {
        StockMaxProfit smp = new StockMaxProfit();
        System.out.println(smp.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); //7
        System.out.println(smp.maxProfit(new int[]{7, 1, 3, 5, 4, 6})); //6
        System.out.println(smp.maxProfit(new int[]{2, 1, 2, 0, 1})); //2
        System.out.println(smp.maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9})); //25
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        int buyPrice = -1;
        int sellPrice = -1;
        int canBuyAt = -1;
        int canSellAt = -1;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice == -1) {
                if (i != prices.length - 1 && prices[i + 1] > prices[i] && canBuyAt == -1) {
                    canBuyAt = i;
                } else if (canBuyAt != -1) {
                    buyPrice = prices[canBuyAt];
                }
            }
            if (buyPrice != -1) {
                if (i == prices.length - 1 || prices[i + 1] < prices[i])
                    sellPrice = prices[i];
                else if (prices[i + 1] > prices[i])
                    canSellAt = i + 1;
                else if (canSellAt != -1)
                    sellPrice = prices[canSellAt];
            }
            if (buyPrice != -1 && sellPrice != -1) {
                sum += sellPrice - buyPrice;
                canBuyAt = canSellAt = -1;
                buyPrice = sellPrice = -1;
            }
        }
        return sum;
    }
}

/* Other Solutions:

public int maxProfit(int[] prices) {
    int max_profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max_profit += prices[i] - prices[i-1];
            }
        }
        return max_profit;
    }

*/