  package com.br.adriano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.adriano.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u FROM User u WHERE u.userName =:userName")
	User findByuserName(@Param("userName") String userName);
	
//	@Query("select new com.br.adriano.domain.dto.response.UserResponse(u.id, u.userName, u.fullName,u.password, u.accountNonExpired, u.accountNonLocked, u.credentialsNonExpired, u.enabled)FROM User u WHERE u.userName =:userName")
//	Optional<UserResponse> findByuserName(@Param("userName") String userName);


}
