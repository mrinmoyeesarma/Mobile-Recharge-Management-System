package com.recharge.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recharge.admin.entity.RechargePlan;

@Repository
public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {

}
