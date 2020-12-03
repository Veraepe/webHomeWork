package vo;

public class City {
		
	private int provinceCode;
	private String provinceName;
	private int cityCode;
	private String cityName;
	
	
	
	public City() {
		super();
	}



	public City(int provinceCode, String provinceName, int cityCode, String cityName) {
		super();
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}



	public int getProvinceCode() {
		return provinceCode;
	}



	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}



	public String getProvinceName() {
		return provinceName;
	}



	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}



	public int getCityCode() {
		return cityCode;
	}



	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}



	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	@Override
	public String toString() {
		return "City [provinceCode=" + provinceCode + ", provinceName=" + provinceName + ", cityCode=" + cityCode
				+ ", cityName=" + cityName + "]";
	}
	
}
