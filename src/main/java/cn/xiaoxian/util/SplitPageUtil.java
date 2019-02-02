package cn.xiaoxian.util;

public class SplitPageUtil {
	private Integer cp=2;
	private Integer ls=5;
	private String col;
	private String kw;

	public void setCp(String cp) {
		try {
			this.cp = Integer.parseInt(cp);
		} catch (Exception e) {
		}
	}

	public void setLs(String ls) {
		try {
			this.ls = Integer.parseInt(ls);
		} catch (Exception e) {
		}
	}

	public void setCol(String col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "SplitPageUtil [cp=" + cp + ", ls=" + ls + ", col=" + col + ", kw=" + kw + "]";
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public Integer getCurrentPage() {
		return this.cp;
	}

	public Integer getLineSize() {
		return this.ls;
	}

	public String getKeyWord() {
		return this.kw;
	}

	public String getColumn() {
		return this.col;
	}
}
