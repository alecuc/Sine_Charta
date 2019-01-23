package beans;

public class HaTable {

	private String username;
	private int idStoria;
	private boolean flagModeratore;
	
	public HaTable() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdStoria() {
		return idStoria;
	}

	public void setIdStoria(int idStoria) {
		this.idStoria = idStoria;
	}

	public boolean isFlagModeratore() {
		return flagModeratore;
	}

	public void setFlagModeratore(boolean flagModeratore) {
		this.flagModeratore = flagModeratore;
	}

	@Override
	public String toString() {
		return "HaTable [username=" + username + ", idStoria=" + idStoria + ", flagModeratore=" + flagModeratore + "]";
	}
	
	
}
