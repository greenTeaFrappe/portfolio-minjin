package com.minjin.portfolio.domain.repository

import com.minjin.portfolio.domain.entity.Achievement
import com.minjin.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectRepository : JpaRepository<Project, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Project>
}