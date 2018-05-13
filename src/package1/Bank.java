package package1;
// Generated Dec 8, 2017 8:49:07 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bank generated by hbm2java
 */
@Entity
@Table(name = "Bank", catalog = "Deposits")
public class Bank implements java.io.Serializable {

	private int id;
	private String name;
	private boolean isState;
	private int rate;
	private Set<Program> programs = new HashSet<Program>(0);

	public Bank() {
	}

	public Bank(int id, String name, boolean isState, int rate) {
		this.id = id;
		this.name = name;
		this.isState = isState;
		this.rate = rate;
	}

	public Bank(int id, String name, boolean isState, int rate, Set<Program> programs) {
		this.id = id;
		this.name = name;
		this.isState = isState;
		this.rate = rate;
		this.programs = programs;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IsState", nullable = false)
	public boolean isIsState() {
		return this.isState;
	}

	public void setIsState(boolean isState) {
		this.isState = isState;
	}

	@Column(name = "Rate", nullable = false)
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
	public Set<Program> getPrograms() {
		return this.programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}

}