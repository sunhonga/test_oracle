package com.springtest.adapter;

/**
 * @ClassName BasketBallAdapter
 * @Description TODO
 * Author sunhong
 * Date 2020-3-28 15:38
 **/
public class BasketBallAdapter implements BallAdapter {
    @Override
    public boolean supportsBall(Ball ball) {
        return (ball instanceof BasketBall);
    }

    @Override
    public Park getBallPark(Ball ball) {
        return new BasketBallPark();
    }


}
