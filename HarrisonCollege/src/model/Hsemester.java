package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HSEMESTER database table.
 * 
 */
@Entity
@Table(name="Hsemester", schema="testuserdb")
@NamedQuery(name="Hsemester.findAll", query="SELECT h FROM Hsemester h")
public class Hsemester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(schema="testuserdb",name="HSEMESTER_SEMESTERCODE_GENERATOR",sequenceName="HSEMESTER_SEQ1",allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HSEMESTER_SEMESTERCODE_GENERATOR")
	private int semestercode;

	private BigDecimal hyear;

	private String semester;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hsemester")
	private List<Hclass> hclasses;

	public Hsemester() {
	}

	public int getSemestercode() {
		return this.semestercode;
	}

	public void setSemestercode(int semestercode) {
		this.semestercode = semestercode;
	}

	public BigDecimal getHyear() {
		return this.hyear;
	}

	public void setHyear(BigDecimal hyear) {
		this.hyear = hyear;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHsemester(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHsemester(null);

		return hclass;
	}

}