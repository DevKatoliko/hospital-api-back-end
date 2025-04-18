package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name= "medical_exams")
public class MedicalExam implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String NULL_ERROR_PHYSICAL_EXAM = "É necessário que haja um exame físico!";
	public static final String NULL_ERROR_MEDICAL_RECORD= "O exame necessita de um prontuário associado!";
	public static final String NULL_ERROR_EXAM_DATE= "O exame necessita de uma data!";
	public static final String NULL_ERROR_COMPLEMENTARY_EXAMS= "Os exames complementares não podem ser nulos!";
	public static final String NULL_ERROR_DOCTOR_OBSERVATIONS= "As observações do médico não podem ser nulas!";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "physical_exam", nullable = false)
	private String physicalExam;
	@ElementCollection
	@CollectionTable(name = "complementary_exams", joinColumns = @JoinColumn(name = "medical_exam_id"))
	private Set<String> complementaryExams = new HashSet<>();
	@OneToOne(mappedBy = "medicalExam")
	private MedicalRecord medicalRecord;
	@Column(name = "exams_dates", nullable = false)
	private LocalDate examDate;
	private String methods; // The methods used to get the result for the exams
	@ElementCollection
	@CollectionTable(name="exam_measures_results", joinColumns = @JoinColumn(name = "medical_exam_id"))
	private Set<String> examMeasuresResult = new HashSet<>(); // Details of any measure taken in the exams (example: pressure, blood glucose level)
	@Column(name= "doctor_observations")
	private String doctorObservations; // Comments from the doctor about the exams
	@ElementCollection
	@CollectionTable(name = "exams_history", joinColumns = @JoinColumn(name = "medical_exam_id"))
	private Set<String> examsHistory = new HashSet<>(); // This will work as a log of the events in the medical exam
	protected MedicalExam() {}
	
	public MedicalExam( MedicalRecord medicalRecord, String physicalExam,Set<String> complementaryExams,String doctorObservations ,LocalDate examDate) {
		this.medicalRecord = Objects.requireNonNull(medicalRecord, NULL_ERROR_MEDICAL_RECORD);
		this.physicalExam = Objects.requireNonNull(physicalExam, NULL_ERROR_PHYSICAL_EXAM);
		this.complementaryExams = Objects.requireNonNull(complementaryExams, NULL_ERROR_COMPLEMENTARY_EXAMS);
		this.doctorObservations = Objects.requireNonNull(doctorObservations, NULL_ERROR_DOCTOR_OBSERVATIONS);
		this.examDate = Objects.requireNonNull(examDate, NULL_ERROR_EXAM_DATE);
	}

	public Long getId() {
		return id;
	}

	public String getPhysicalExam() {
		return physicalExam;
	}

	public void setPhysicalExam(String physicalExam) {
		this.physicalExam = Objects.requireNonNull(physicalExam, NULL_ERROR_PHYSICAL_EXAM);
	}

	public Set<String> getComplementaryExams() {
		return Collections.unmodifiableSet(complementaryExams);
	}

	public void addComplementaryExams(String complementaryExam) {
		this.complementaryExams.add(Objects.requireNonNull(complementaryExam));
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = Objects.requireNonNull(medicalRecord, NULL_ERROR_MEDICAL_RECORD);
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = Objects.requireNonNull(examDate, NULL_ERROR_EXAM_DATE);
	}

	public String getMethods() {
		return methods;
	}

	public void setMethods(String methods) {
		this.methods = methods;
	}

	public Set<String> getExamMeasuresResult() {
		return Collections.unmodifiableSet(examMeasuresResult);
	}

	public void addExamMeasureResult(String examMeasuresResult) {
		this.examMeasuresResult.add(Objects.requireNonNull(examMeasuresResult, "As medidas do exame não podem ser nulas!")) ;
	}

	public String getDoctorObservations() {
		return doctorObservations;
	}

	public void setDoctorObservations(String doctorObservations) {
		this.doctorObservations = Objects.requireNonNull(doctorObservations);
	}

	
	public Set<String> getExamsHistory() {
		return Collections.unmodifiableSet(examsHistory);
	}

	public void addExamHistory(String examsHistory) {
		this.examsHistory.add(Objects.requireNonNull(examsHistory)) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalExam other = (MedicalExam) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
