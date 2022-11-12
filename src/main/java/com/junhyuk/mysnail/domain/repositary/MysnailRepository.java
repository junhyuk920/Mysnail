package com.junhyuk.mysnail.domain.repositary;


import org.springframework.data.jpa.repository.JpaRepository;

import com.junhyuk.mysnail.domain.entity.MysnailEntity;

public interface MysnailRepository extends JpaRepository<MysnailEntity, Long> {
}


