package com.minjin.portfolio.domain.repository

import com.minjin.portfolio.domain.entity.Achievement
import com.minjin.portfolio.domain.entity.Experience
import com.minjin.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}