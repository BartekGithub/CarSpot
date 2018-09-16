package pl.coderslab.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Column(unique=true)
	private String username;
	
	@NotBlank
	@Email
	@Column(unique=true)
	private String email;
	
	@NotBlank
	@Size(min=2)
	private String password;
	
	private String salt;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Car> cars;

	//@NotBlank
	private boolean enabled;
	
	
	public User() {
		
	}

	public User(String username, String email, String password, boolean enabled) {
		
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		

		this.password=password;
		
	}
	
	public void setPassword() {
		
		this.password = "";
		
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
