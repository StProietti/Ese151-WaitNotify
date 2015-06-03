
public class Consumatore extends Thread {
	private Coda coda;

	public Consumatore(Coda coda) {
		this.coda = coda;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this.coda) {
				if (!this.coda.isVuota()) {
					Integer letto = null;
					letto = this.coda.rimuovi();
					System.out.println("Consumatore: letto elemento " + letto);
					this.coda.notify();
				} else {
					try {
						System.out.println("Consumatore: coda vuota. Attendo...");
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
