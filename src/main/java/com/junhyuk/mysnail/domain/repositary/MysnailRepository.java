package com.junhyuk.mysnail.domain.repositary;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junhyuk.mysnail.domain.entity.MysnailEntity;

public interface MysnailRepository extends JpaRepository<MysnailEntity, Long> {
    Optional<MysnailEntity> findById(Long id);
}


