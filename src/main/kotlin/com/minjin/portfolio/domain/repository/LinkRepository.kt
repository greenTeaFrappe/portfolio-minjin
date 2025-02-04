package com.minjin.portfolio.domain.repository

import com.minjin.portfolio.domain.entity.Achievement
import com.minjin.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Link>

}