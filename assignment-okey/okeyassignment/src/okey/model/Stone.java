package okey.model;

public class Stone {


	//Taþ Adý
	String stoneName;
	//taþ Deðeri
	Integer stoneValue;
	//Okey midir?
	Boolean isOkey;
	//açýlan taþmýdýr.
	Boolean isOpened;
	boolean fakeOkey;

	Integer stoneColor;
	Integer stoneNumber;

	public Stone(String stoneName,Integer stoneValue,Boolean isOkey,Boolean isOpened,Integer stoneColor, Integer stoneNumber) {
		this.stoneName=stoneName;
		this.stoneValue=stoneValue;
		this.isOkey=isOkey;
		this.isOpened=isOpened;
		this.stoneColor=stoneColor;
		this.stoneNumber=stoneNumber;
	}
	public boolean isFakeOkey() {
		return fakeOkey;
	}
	public void setFakeOkey(boolean fakeOkey) {
		this.fakeOkey = fakeOkey;
	}
	public Boolean getIsOkey() {
		return isOkey;
	}
	public Integer getStoneColor() {
		return stoneColor;
	}
	public void setStoneColor(Integer stoneColor) {
		this.stoneColor = stoneColor;
	}
	public Integer getStoneNumber() {
		return stoneNumber;
	}
	public void setStoneNumber(Integer stoneNumber) {
		this.stoneNumber = stoneNumber;
	}
	public void setIsOkey(Boolean isOkey) {
		this.isOkey = isOkey;
	}
	public Boolean getIsOpened() {
		return isOpened;
	}
	public void setIsOpened(Boolean isOpened) {
		this.isOpened = isOpened;
	}
	public String getStoneName() {
		return stoneName;
	}
	public void setStoneName(String stoneName) {
		this.stoneName = stoneName;
	}
	public Integer getStoneValue() {
		return stoneValue;
	}
	public void setStoneValue(Integer stoneValue) {
		this.stoneValue = stoneValue;
	}

}
