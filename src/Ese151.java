
public class Ese151 {

	public static void main(String[] args) {
		Coda q = new Coda(5);
		Produttore p = new Produttore(q);
		Consumatore c = new Consumatore(q);

		p.start();
		c.start();
	}

}
