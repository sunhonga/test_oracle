package com.bond;

import org.joda.time.DateTime;

/**
 * 2019-8-13
 * ¥¥Ω®»À SunHong
 */
public class YeWu {

	private DateTime mrsj;
	private double sl;
	private double bdje;

	public DateTime getMrsj() {
		return mrsj;
	}

	public void setMrsj(DateTime mrsj) {
		this.mrsj = mrsj;
	}

	public double getSl() {
		return sl;
	}

	public void setSl(double sl) {
		this.sl = sl;
	}

	public double getBdje() {
		return bdje;
	}

	public void setBdje(double bdje) {
		this.bdje = bdje;
	}

	@Override
	public String toString() {
		return "YeWu{" +
				"mrsj=" + mrsj +
				", sl=" + sl +
				", bdje=" + bdje +
				'}';
	}
}
