package com.springtest.adapter;

/**
 * @ClassName FootBallAdapter
 * @Description TODO
 * Author sunhong
 * Date 2020-3-28 15:34
 **/
public class FootBallAdapter implements BallAdapter {
    @Override
    public boolean supportsBall(Ball ball) {
        return (ball instanceof FootBall);
    }

    @Override
    public Park getBallPark(Ball ball) {
        return new FootBallPark();
    }


}
