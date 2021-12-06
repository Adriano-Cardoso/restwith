package com.br.adriano.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.adriano.domain.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Optional<Profile> findByName(String profile);

}
