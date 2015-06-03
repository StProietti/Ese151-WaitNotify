
public class Produttore extends Thread {
	private Coda coda;
	private String nome;

	public Produttore(String nome, Coda coda) {
		this.coda = coda;
		this.nome = nome;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			
			synchronized (this.coda) {
				if (!this.coda.isPiena()) {
					i++;
					this.coda.accoda(i);
					System.out.println("Produttore " + this.nome + ": aggiunto elemento " + i);
					this.coda.notifyAll(); // notifica tutti i processi in attesa
				} else {
					try {
						System.out.println("Produttore " + this.nome + ": coda piena. Attendo...");
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
