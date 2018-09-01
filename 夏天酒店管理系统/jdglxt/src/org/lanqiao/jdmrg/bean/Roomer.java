package org.lanqiao.jdmrg.bean;

import java.io.Serializable;

/**
 * 房客类
 * @author 9组
 *
 */
public class Roomer implements Serializable{
	/**账号*/
	private String accountNum;
	/**入住人姓名*/
	private String name;
	/**联系方式*/
	private String contact;
	/**房间号*/
	private String roomNo;
	/**类型*/
	private String roomType;
	/**价格*/
	private String roomPrice;
	/**入住时间*/
	private String firstTime;
	/**离开时间*/
	private String lastTime;
	/**入住天数*/
	private Integer dayNum;
	/**到店时间*/
	private String inTime;
	/**身份证*/
	private String id;
	/**订单状态*/
	private String roomerState;
	
	public Roomer() {}

	public Roomer(String accountNum, String name, String contact, String roomNo, String roomType, String roomPrice,
			String firstTime, String lastTime, Integer dayNum, String inTime, String id, String roomerState) {
		super();
		this.accountNum = accountNum;
		this.name = name;
		this.contact = contact;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.firstTime = firstTime;
		this.lastTime = lastTime;
		this.dayNum = dayNum;
		this.inTime = inTime;
		this.id = id;
		this.roomerState = roomerState;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getDayNum() {
		return dayNum;
	}

	public void setDayNum(Integer dayNum) {
		this.dayNum = dayNum;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomerState() {
		return roomerState;
	}

	public void setRoomerState(String roomerState) {
		this.roomerState = roomerState;
	}

	@Override
	public String toString() {
		return "Roomer [accountNum=" + accountNum + ", name=" + name + ", contact=" + contact + ", roomNo=" + roomNo
				+ ", roomType=" + roomType + ", roomPrice=" + roomPrice + ", firstTime=" + firstTime + ", lastTime="
				+ lastTime + ", dayNum=" + dayNum + ", inTime=" + inTime + ", id=" + id + ", roomerState=" + roomerState
				+ "]";
	}
	
	
}