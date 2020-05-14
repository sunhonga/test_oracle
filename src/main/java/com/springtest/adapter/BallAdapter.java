package com.springtest.adapter;

public interface BallAdapter extends Ball{


    boolean supportsBall(Ball ball);

    Park getBallPark(Ball ball);
}
