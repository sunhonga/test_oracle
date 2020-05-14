import java.util.Date;

/**
 * 2019-8-1
 * ¥¥Ω®»À SunHong
 */
public class HzjkQs {

	private String fzdm;
	private Date fdate;
	private String fszsh;
	private String fywbz;
	private String fsetcode;

	public String getFzdm() {
		return fzdm;
	}

	public void setFzdm(String fzdm) {
		this.fzdm = fzdm;
	}

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	public String getFszsh() {
		return fszsh;
	}

	public void setFszsh(String fszsh) {
		this.fszsh = fszsh;
	}

	public String getFywbz() {
		return fywbz;
	}

	public void setFywbz(String fywbz) {
		this.fywbz = fywbz;
	}

	public String getFsetcode() {
		return fsetcode;
	}

	public void setFsetcode(String fsetcode) {
		this.fsetcode = fsetcode;
	}

	@Override
	public String toString() {
		return "HzjkQs{" +
				"fzdm='" + fzdm + '\'' +
				", fdate=" + fdate +
				", fszsh='" + fszsh + '\'' +
				", fywbz='" + fywbz + '\'' +
				", fsetcode='" + fsetcode + '\'' +
				'}';
	}

	public HzjkQs() {
	}
}
