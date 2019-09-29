package reader;

/**
 * @author cezar-filho
 * Metodos Get e Set NAO DEFAULT
 */
public class ResultadoMes implements Comparable<ResultadoMes> {

	private int numeroMes;
	private int loc;
	private int qtdClasses;
	private int qtdMetodos;
	private int qtdClasseDeus;
	private int qtdMetodoDeus;

	@Override
	public int compareTo(ResultadoMes outroMes) {
		if (this.numeroMes < outroMes.getNumeroMes()) {
			return -1;
		}
		if (this.numeroMes > outroMes.getNumeroMes()) {
			return 1;
		}
		return 0;
	}

	public int getNumeroMes() {
		return numeroMes;
	}

	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc += loc;
	}

	public int getQtdClasses() {
		return qtdClasses;
	}

	public void setQtdClasses(int qtdClasses) {
		this.qtdClasses += qtdClasses;
	}

	public int getQtdMetodos() {
		return qtdMetodos;
	}

	public void setQtdMetodos(int qtdMetodos) {
		this.qtdMetodos += qtdMetodos;
	}

	public int getQtdClasseDeus() {
		return qtdClasseDeus;
	}

	public void setQtdClasseDeus(int qtdClasseDeus) {
		this.qtdClasseDeus += qtdClasseDeus;
	}

	public int getQtdMetodoDeus() {
		return qtdMetodoDeus;
	}

	public void setQtdMetodoDeus(int qtdMetodoDeus) {
		this.qtdMetodoDeus += qtdMetodoDeus;
	}

}
