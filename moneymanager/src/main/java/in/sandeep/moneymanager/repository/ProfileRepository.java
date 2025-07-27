package in.sandeep.moneymanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sandeep.moneymanager.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    //select * from tbl_profiles where email = ?
    Optional<ProfileEntity> findByEmail(String email);

     //search profile by email  is optional because if profile not present for email it should not give NullPointerException
    //select * from tbl_profiles where activation_token = ?
    Optional<ProfileEntity> findByActivationToken(String activationToken);
}

