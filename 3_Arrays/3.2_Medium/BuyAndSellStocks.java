public class BuyAndSellStocks {
    //Brute force solution
//    public static int maxProfitFunc(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++) {
//                int profit = prices[j] - prices[i];
//                max = Math.max(max,profit);
//            }
//        }
//        return max;
//    }

//    //Optimal
//    public static int maxProfitFunc(int[] prices){
//        int i=0,j=0;
//        int maxProfit=0;
//        while(j<prices.length){
//            int profit = prices[j] - prices[i];
//            if(profit >= 0){
//                j++;
//            }else{
//                i++;
//            }
//            maxProfit = Math.max(maxProfit,profit);
//        }
//        return maxProfit;
//    }

    //Optimal DP
    public static int maxProfitFunc(int[] prices){
        int maxProfit=0;
        int minimal = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minimal;
            maxProfit = Math.max(profit,maxProfit);
            minimal = Math.min(minimal,prices[i]);
        }
        return maxProfit;
    }



    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfitFunc(prices));
    }
}

