
public class ObjectsCrewProgram {
	public static void main(String[] args) {
		Sailor firstSailor = new Sailor("Frank", "frank@mail.com");
		Sailor secondSailor = new Sailor("Susan", "susan@mail.com");
		Sailor thirdSailor = new Sailor("John", "john@sailors.com");
		Sailor fourthSailor = new Sailor("Ann", "ann@sailors.com");
		
		Crew firstCrew = new Crew();
		Crew secondCrew = new Crew();
		
		firstCrew.addCrewMember(firstSailor);
		firstCrew.addCrewMember(secondSailor);
		firstCrew.addCrewMember(fourthSailor);
		secondCrew.addCrewMember(thirdSailor);
		secondCrew.addCrewMember(secondSailor);
		
		System.out.println("=== First crew ===\n" + firstCrew);
		System.out.println("=== Second crew ===\n" + secondCrew);
		secondSailor.setEmail("Susan@sailors.com");
		System.out.println("===Second crew ===\n" + secondCrew);
	}
}