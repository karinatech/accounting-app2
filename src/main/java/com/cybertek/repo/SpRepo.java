package com.cybertek.repo;

import com.cybertek.entity.Sp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpRepo extends JpaRepository<Sp,Integer> {
}
