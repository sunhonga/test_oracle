package com.bond;

import org.joda.time.DateTime;


/**
 * 2019-8-13
 * 创建人 SunHong
 */
public class BondBase {

	//计息起始日
	private DateTime jxqsr;

	// 计息截止日
	private DateTime jxjzr;

	//票面利率
	private double rate;

	public double getPmje() {
		return pmje;
	}

	public void setPmje(double pmje) {
		this.pmje = pmje;
	}

	//票面金额
	private double pmje;

	//计息方式       1代表平均值；2代表实际天数
	private int jxfs;

	//计息基础       0按实际天数/365计息；1按实际天数计息；2按ACT/360计息；3按30/360计息
	private int jxjc;

	//付息频率       1年付;2半年付;3季度付;4月付
	private int fxpl;

	//债券其他属性


	public DateTime getJxqsr() {
		return jxqsr;
	}

	public void setJxqsr(DateTime jxqsr) {
		this.jxqsr = jxqsr;
	}

	public DateTime getJxjzr() {
		return jxjzr;
	}

	public void setJxjzr(DateTime jxjzr) {
		this.jxjzr = jxjzr;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getJxfs() {
		return jxfs;
	}

	public void setJxfs(int jxfs) {
		this.jxfs = jxfs;
	}

	public int getJxjc() {
		return jxjc;
	}

	public void setJxjc(int jxjc) {
		this.jxjc = jxjc;
	}

	public int getFxpl() {
		return fxpl;
	}

	public void setFxpl(int fxpl) {
		this.fxpl = fxpl;
	}

	@Override
	public String toString() {
		return "BondBase{" +
				"jxqsr=" + jxqsr +
				", jxjzr=" + jxjzr +
				", rate=" + rate +
				", jxfs=" + jxfs +
				", jxjc=" + jxjc +
				", fxpl=" + fxpl +
				'}';
	}
}
