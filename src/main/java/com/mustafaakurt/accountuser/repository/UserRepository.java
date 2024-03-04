package com.mustafaakurt.accountuser.repository;

import com.mustafaakurt.accountuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{


}
