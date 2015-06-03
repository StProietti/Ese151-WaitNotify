
public class Ese151 {

	public static void main(String[] args) {
		Coda q = new Coda(5);
		Produttore pA = new Produttore("A", q);
		Produttore pB = new Produttore("B", q);
		Consumatore cA = new Consumatore("A", q);
		Consumatore cB = new Consumatore("C", q);
		Consumatore cC = new Consumatore("C", q);

		pA.start();
		pB.start();
		cA.start();
		cB.start();
		cC.start();
	}

}
