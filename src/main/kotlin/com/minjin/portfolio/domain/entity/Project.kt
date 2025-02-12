package com.minjin.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null

    var name: String = name

    var description: String = description

    var startYear: Int = startYear

    var startMont: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(
        targetEntity = ProjectDetail::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    @JoinColumn(name = "project_id")
    var details: MutableList<ProjectDetail> = mutableListOf()

    // mappedBy : 연관관계의 주인
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var skills: MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }
        return "${endYear}.${endMonth}"
    }

    fun addDetails(details: MutableList<ProjectDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}