package com.ytm;



/**
 * 2019-8-13
 * 创建人 SunHong
 * 平均值计息
 */
public class PingjunYTM extends AbstractYTM {

	public PingjunYTM() {
		super();

	}

	/**
	 * 计算实际收益率公式：0=Z0(1+y)^n + M(y-i0)((1+y)^n-1)/y
	 * z0:初始溢折价
	 * y:实际收益率
	 * M：面值
	 * i0：日票面利率
	 */
	@Override
	public double ytm() {
		//getJxXingxi();
		double y =0;

		int i = 1;
		double rate = bondAndYeWu.bondBase.getRate();
		int fxpl = bondAndYeWu.bondBase.getFxpl();
		double mianzhi = bondAndYeWu.bondBase.getPmje();
		double bdje = bondAndYeWu.yeWu.getBdje();
		double sl = bondAndYeWu.yeWu.getSl();
		double i0 = rate/fxpl;				//票面利率除以付息频率
		int n = Integer.valueOf(linkedList.get(0).split("\t\t")[1]);   //业务日期到计息截止日的天数
		int ll_size = linkedList.size();
		while (i++ <= diedaicishu){
			y = (chushiMax+chushiMin)/2/36500;              //初始到期收益率
			//左边
			double zuobian = 0;
			double youbian = 0;
			zuobian =bdje/sl*Math.pow(1+y,n);
			for(int j =0 ;j < ll_size;j++){
				String[] strs = linkedList.get(j).split("\t\t");
				Integer[] ints = new Integer[]{Integer.valueOf(strs[0])*100,Integer.valueOf(strs[1])};
				if(j == ll_size-1){
					youbian = youbian + mianzhi*(y - i0/ints[0])*(Math.pow(1+y,ints[1])-1)/y;
					break;
				}
				String[] strs2 = linkedList.get(j+1).split("\t\t");
				Integer[] ints2 = new Integer[]{Integer.valueOf(strs2[0])*100,Integer.valueOf(strs2[1])};
				youbian = youbian+mianzhi*(y - i0/ints[0])*(Math.pow(1+y,ints[1])-Math.pow(1+y,ints2[1]))/y;
			}
			if (Math.abs(zuobian+youbian) < Math.pow(0.1,blws)){break;}
			if (zuobian+youbian<0){
				chushiMin = (chushiMin+chushiMax)/2;
			}else if(zuobian+youbian>0){
				chushiMax = (chushiMin+chushiMax)/2;
			}else {
				return y;
			}

		}
		return y;
	}
}
