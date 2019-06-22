package shuun.chapte3;

public class ClassRoom {

	private String roomNumver;
	private int totalSears = 60;
	private static int totalRooms = 0;

	public String getRoomNumver() {
		return roomNumver;
	}

	public void setRoomNumver(String roomNumver) {
		this.roomNumver = roomNumver;
	}

	public int getTotalSears() {
		return totalSears;
	}

	public void setTotalSears(int totalSears) {
		this.totalSears = totalSears;
	}

	public static int getTotalRooms() {
		return totalRooms;
	}

	public static void setTotalRooms(int totalRooms) {
		ClassRoom.totalRooms = totalRooms;
	}

}
