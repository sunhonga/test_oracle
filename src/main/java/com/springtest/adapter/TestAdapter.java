package com.springtest.adapter;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestAdapter
 * @Description TODO
 * Author sunhong
 * Date 2020-3-28 15:42
 * 适配器练习
 * spring中的AOP的advice中有使用。
 **/
public class TestAdapter {



    private static final List<BallAdapter> adapters = new ArrayList<>(3);
    private static final List<Park> parks = new ArrayList<>(3);

    public static void main(String[] args) {

        adapters.add(new BasketBallAdapter());
        adapters.add(new FootBallAdapter());


        Ball ball = new BasketBall();
        for (BallAdapter adapter : adapters) {
            if (adapter.supportsBall(ball)) {
                parks.add(adapter.getBallPark(ball));
            }
        }
        System.out.println(":ss");
    }

    public  void  registerAdvisorAdapter(BallAdapter adapter) {
    }
}
