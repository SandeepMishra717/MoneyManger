package in.sandeep.moneymanager.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//#JPA
@Entity
@Table(name="tbl_profiles")// if no table name then default name will be Entity(className)
//lambok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileEntity {
     
	@Id
	@GeneratedValue(strategy=Gene)
	private Long id;
	private String fullName;
	@Column(unique=true)
	private String email;
	private String password;
	private String profileImageUrl;
	@Column(updatable=false)  //dont't to update time of obj saved in db
	@CreationTimestamp
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Boolean isActive;
	private String activationTaken;

//before saving obj into database we want to run this method so that isActive value null not store in db ,if user log in with email it true otherwise false
@PrePersist
public void prePersist() {
		if(this.isActive==null) {
			isActive= false;
		}
	}
	
}
