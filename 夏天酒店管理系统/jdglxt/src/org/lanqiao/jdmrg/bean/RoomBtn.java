package org.lanqiao.jdmrg.bean;

import javax.swing.JButton;

/**
 * 房间按钮类
 * @author 9组
 *
 */
public class RoomBtn extends JButton{
	/**房间号*/
	private String roomNo;
	/**类型*/
	private String roomType;
	/**价格*/
	private Integer roomPrice;
	/**状态*/
	private String roomState;
	/**按钮宽*/
	private Integer btnWidth = 105;
	/**按钮高*/
	private Integer btnHeight = 80;
	/**入住时间*/
	private String firstTime;
	/**离开时间*/
	private String lastTime;
	
	public RoomBtn() {}
	
	public RoomBtn(int x, int y,String s,String roomState) {
		this.setSize(btnWidth, btnHeight);
		this.setLocation(x, y);
		this.roomNo = s;
		this.roomState = roomState;
		this.setText(this.roomNo);
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

	public Integer getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomState() {
		return roomState;
	}

	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}

	public Integer getBtnWidth() {
		return btnWidth;
	}

	public void setBtnWidth(Integer btnWidth) {
		this.btnWidth = btnWidth;
	}

	public Integer getBtnHeight() {
		return btnHeight;
	}

	public void setBtnHeight(Integer btnHeight) {
		this.btnHeight = btnHeight;
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

	
}
