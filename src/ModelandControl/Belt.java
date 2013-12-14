package ModelandControl;

public class Belt {
	// belt is the line which the plates walks on and fall off it 
	int start, end;
	int number_of_the_paltes_on_the_belt;
	public Belt(int start, int end) {
		this.start = start;
		this.end   = end;
		number_of_the_paltes_on_the_belt = 0;
	}
	
	public int getPlatesNumber() {return number_of_the_paltes_on_the_belt;}
	public void setPlatesNumber(int plates) {number_of_the_paltes_on_the_belt = plates;}
	
}
