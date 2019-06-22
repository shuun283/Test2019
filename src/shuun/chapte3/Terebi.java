package shuun.chapte3;

public class Terebi {
int size; 
String color;
int voice;
int view;

protected void banGumi() {
	System.out.println("outview : " + view);
	}
protected void banGumi(int view) {
	System.out.println("outview : " + view);
}
protected void voiceChange() {
	System.out.println("outvoice : " + view);
}
protected void viewChange() {
	System.out.println("outview : " + view);
}

}
class blackTV extends Terebi{
	@Override
	protected void banGumi(int view) {
		
	}
}
class colorTV extends Terebi{
	@Override
	protected void banGumi(int view) {

	}
}
