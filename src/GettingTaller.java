import java.io.Serializable;


public class GettingTaller implements BeltState ,Serializable{
	Belt belt;
	public GettingTaller(Belt belt) {
		this.belt= belt;
	}
	@Override
	public void change() {
		belt.makeItTaller();
		if(belt.checkstdAndcurrentEndTaller()) belt.setCurrentBeltState(belt.getSmaller());
	}

}
