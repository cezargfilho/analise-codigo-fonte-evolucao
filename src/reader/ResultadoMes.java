package reader;

/**
 * @author cezar-filho Metodos Get e Set NAO DEFAULT
 */
public class ResultadoMes implements Comparable<ResultadoMes> {

	private int numeroMes;
	private int loc;
	private int qtdFunction;
	private int qtdStruct;
	private int qtdIMPL;
	
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

	public int getQtdFunction() {
		return qtdFunction;
	}

	public void setQtdFunction(int qtdFunction) {
		this.qtdFunction += qtdFunction;
	}

	public int getQtdStruct() {
		return qtdStruct;
	}

	public void setQtdStruct(int qtdStruct) {
		this.qtdStruct += qtdStruct;
	}

	public int getQtdIMPL() {
		return qtdIMPL;
	}

	public void setQtdIMPL(int qtdIMPL) {
		this.qtdIMPL += qtdIMPL;
	}

}
