import java.util.ArrayList;

public class Crew {
	ArrayList<Sailor> sailorList;
	public Crew() {
		sailorList=new ArrayList <Sailor>();
	}
	public void addCrewMember(Sailor sailor) {
		sailorList.add(sailor);
	}
	public String toString() {
		String output = "";
		for(Sailor s : sailorList) {
			output += s.getName() + " (" + s.getEmail() + ")\n";
		}
		return output;
	}

}
