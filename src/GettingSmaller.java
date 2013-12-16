import java.io.Serializable;


public class GettingSmaller implements BeltState,Serializable {
	Belt belt;
	public GettingSmaller(Belt belt) {
		this.belt = belt;
	}
	@Override
	public void change() {
		belt.makeItSmaller();
		if(belt.checkstdAndcurrentEndSmaller()) belt.setCurrentBeltState(belt.getTaller());
	}

}
