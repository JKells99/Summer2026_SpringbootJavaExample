package com.keyin.campusfoodreview.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRestRepository extends JpaRepository<User, Long> {

}
