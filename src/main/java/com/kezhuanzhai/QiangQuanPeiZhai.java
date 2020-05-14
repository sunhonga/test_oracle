package com.kezhuanzhai;

/**
 * @ClassName QiangQuanPeiZhai
 * @Description TODO
 * Author sunhong
 * Date 2020-3-16 11:21
 * 可转债抢权;安全垫的计算
 **/
public class QiangQuanPeiZhai {

     private static double peiGuMianZhi = 2.138;
     private static double closePrice = 10.05;
     private static double yiJiaLv = 0.2;


    public static void main(String[] args) {

        double sum = getSum(peiGuMianZhi);
        double anQudanDie = getAnQuanDian( sum, yiJiaLv, closePrice);
        System.out.println(anQudanDie);

    }

    private static double getAnQuanDian(double sum,double yiJiaLv,double closePrice) {

        return yiJiaLv*1000/(sum*closePrice);

    }


    public static double getSum(double peiGuMianZhi){

        for (int i = 100; i < 1000000 ; i=i+100) {
            if (peiGuMianZhi*i >= 1000) return i;
        }
        return 0;
    }
}
