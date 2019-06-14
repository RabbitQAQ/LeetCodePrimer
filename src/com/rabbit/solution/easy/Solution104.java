package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
    static int Goods_Compute(String activityStr, String itemStr,
                             String amountStr) {
        int result =0 ;
        if (activityStr != null && itemStr != null && amountStr != null) {
            String[] item_Str = itemStr.split(",");
            int[] item_prices = new int[item_Str.length];
            for (int i = 0; i < item_prices.length; i++) {
                item_prices[i]=Integer.valueOf(item_Str[i].trim());
            }
            Arrays.sort(item_prices);              //对输入的商品价格排序；
            int amountMoney = Integer.valueOf(amountStr);

            int act_num = activityStr.split(",").length;
            String[][] activitys = new String[act_num][2];
            for (int i = 0; i < activitys.length; i++) {
                activitys[i][0] = activityStr.split(",")[i].split("-")[0]; // 99 188 288
                activitys[i][1] = activityStr.split(",")[i].split("-")[1]; // 50 100 150
            }

            for (int i = 0; i < act_num; i++) {
                int tmp = getBuySum(activitys[i][0] ,activitys[i][1],amountMoney,item_prices);

                if(tmp > result)
                    result = tmp;
            }

            if(result == 0){
                for (int i = item_prices.length - 1; i >= 0 ; i--) {
                    if((result + item_prices[i]) > amountMoney)
                        continue;
                    result += item_prices[i];
                }
            }

        }
        return result;
    }

    private static int getBuySum(String activity_price, String discount_price,
                                 int amountMoney, int[] item_prices) {

        int act_price = Integer.valueOf(activity_price);
        int dis_price = Integer.valueOf(discount_price);
        if((act_price - dis_price) > amountMoney )
            return -1;

        int buy_sum=0;
        for (int i = item_prices.length - 1; i >= 0 ; i--) {
            if((buy_sum + item_prices[i]) > (amountMoney+dis_price))
                continue;
            buy_sum += item_prices[i];
        }

        return buy_sum;
    }

    public static void main(String[] args) {

    }
}
