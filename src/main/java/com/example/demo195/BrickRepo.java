package com.example.demo195;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrickRepo extends JpaRepository<Brick, Long> {
}
