package com.quiz.lesson07.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {

	//JPQL => Entity에 조회를하는 개념
	public List<RecruitEntity> findByCompanyId(int companyId); // 2번
	public List<RecruitEntity> findByPositionAndType(String position, String type); // 3번
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary); // 4번
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type); // 5번
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd); // 6번
	
	// native query => DB에 조회
	@Query(value = "select * from `recruit` "
			+ "where `deadline` > :deadline "
			+ "and `salary` >= :salary "
			+ "and type = :type "
			+ "order by `salary` DESC"
			, nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline, 
			@Param("salary") int salary,
			@Param("type") String type);
}
