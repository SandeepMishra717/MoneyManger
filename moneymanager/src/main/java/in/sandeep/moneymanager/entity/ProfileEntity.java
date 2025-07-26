package in.sandeep.moneymanager.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//#JPA
@Entity // Marks this class as a JPA entity to be mapped to a database table
@Table(name="tbl_profiles") // Specifies the table name in the database; default would be class name

//lombok
@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-argument constructor
@Builder // Enables the builder pattern for object creation

public class ProfileEntity {

	@Id // Marks this field as the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto-generates the primary key using DB identity column
	private Long id;

	private String fullName;

	@Column(unique=true) // Ensures the 'email' column has unique values in the table
	private String email;

	private String password;

	private String profileImageUrl;

	@Column(updatable=false) // Prevents the value from being updated after the record is created
	@CreationTimestamp // Automatically sets the timestamp when the entity is persisted
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Boolean isActive;

	private String activationTaken;

	@PrePersist // Executes this method before the entity is persisted (saved) to the database. isActive=null shouldn't save in db . 
	public void prePersist() {
		if(this.isActive==null) {
			isActive = false;
		}
	}
}
