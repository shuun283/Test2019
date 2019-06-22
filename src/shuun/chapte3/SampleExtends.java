package shuun.chapte3;

public class SampleExtends {

	public static void main(String[] args) {

	}

}

class ComputerLab extends ClassRoom {

	int totalComputers = 30;
	String labAssistant = "TBA";

	void printSeatInfo() {
		System.out.println("There are " + getTotalSears() + 
							" seats, and " + totalComputers + 
							" computers in this computer lab.");
	}

	public String getLabAssistant() {
		return labAssistant;
	}

	public void setLabAssistant(String labAssistant) {
		this.labAssistant = labAssistant;
	}
}