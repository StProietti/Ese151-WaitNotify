
public class Consumatore extends Thread {
	private Coda coda;
	private String nome;

	public Consumatore(String nome, Coda coda) {
		this.coda = coda;
		this.nome = nome;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this.coda) {
				if (!this.coda.isVuota()) {
					Integer letto = null;
					letto = this.coda.rimuovi();
					System.out.println("Consumatore " + this.nome + ": letto elemento " + letto);
					this.coda.notifyAll(); // notifica tutti i processi in attesa
				} else {
					try {
						System.out.println("Consumatore " + this.nome + " coda vuota. Attendo...");
						this.coda.wait();
					}
					catch(InterruptedException ie) {
						System.err.println("Qualcosa è andato storto. " + ie.getMessage());
					}
				}
			}
		}
	}
}
