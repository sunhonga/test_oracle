package com.bond;

import org.joda.time.DateTime;


/**
 * 2019-8-13
 * ������ SunHong
 */
public class BondBase {

	//��Ϣ��ʼ��
	private DateTime jxqsr;

	// ��Ϣ��ֹ��
	private DateTime jxjzr;

	//Ʊ������
	private double rate;

	public double getPmje() {
		return pmje;
	}

	public void setPmje(double pmje) {
		this.pmje = pmje;
	}

	//Ʊ����
	private double pmje;

	//��Ϣ��ʽ       1����ƽ��ֵ��2����ʵ������
	private int jxfs;

	//��Ϣ����       0��ʵ������/365��Ϣ��1��ʵ��������Ϣ��2��ACT/360��Ϣ��3��30/360��Ϣ
	private int jxjc;

	//��ϢƵ��       1�긶;2���긶;3���ȸ�;4�¸�
	private int fxpl;

	//ծȯ��������


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
