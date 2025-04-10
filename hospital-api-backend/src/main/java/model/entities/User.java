package model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.RoleType;
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String uid;
	@Column(nullable = false)
	private String email;
	
	@Column(unique = true, nullable = false)
	private String login;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	protected User() {
		
	}
	
	public User(String uid,String email, String login, RoleType role) {
		this.email = Objects.requireNonNull(email, "O email não pode ser nulo!");
		this.login = Objects.requireNonNull(login,"O login não pode ser nulo!");
		this.uid = Objects.requireNonNull(uid, "Identificador para autenticação do usuário não pode ser nulo!");
		this.role = Objects.requireNonNull(role, "O papel do usuário não pode ser nulo!");
	}
	
	public Long getId() {
		return id;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = Objects.requireNonNull(email, "O email não pode ser nulo!");;
	}

	public String getLogin() {
		return login;
	}
	
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
        this.role = Objects.requireNonNull(role, "O papel do usuário não pode ser nulo!");
    }
	public Person getPerson() {
		return person;
	}
	  public void setPerson(Person person) {
	        this.person = Objects.requireNonNull(person, "A pessoa associada não pode ser nula!");
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
