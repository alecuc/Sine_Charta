package beans;


public class testBeans {

	public static void main(String[] args) {
		
		Personaggio pg = new Personaggio();
		
		Mazzo mace = new Mazzo();
		
		System.out.println(mace.estraiPoker());
		System.out.println(mace.estraiPoker());
		System.out.println(mace.estraiPoker());
		System.out.println(mace.estraiPoker());
		
		mace.mischiaPoker();
		

		System.out.println(mace.estraiPoker());
		System.out.println(mace.estraiPoker());
		System.out.println(mace.estraiPoker());
		System.out.println(mace.estraiPoker());
		
		}

}
