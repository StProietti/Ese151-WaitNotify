import java.util.Vector;

public class Coda {
	private Vector<Integer> dati;
	private final int capacitaMassima;
	
	public Coda(int capacitaMassima) {
		this.capacitaMassima = capacitaMassima;
		this.dati = new Vector<Integer>();
	}
	
	public void accoda(Integer i) {
		this.dati.add(0, i);
	}
	
	public Integer rimuovi() {
		Integer r = null;
		r = this.dati.remove(this.dati.size()-1);
		return r;
	}
	
	public boolean isVuota() {
		boolean r;
		r = (this.dati.size() == 0);
		return r;
	}
	
	public boolean isPiena() {
		boolean r;
		r = (this.dati.size() == this.capacitaMassima);
		return r;
	}
}
