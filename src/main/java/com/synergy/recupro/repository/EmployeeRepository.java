package com.synergy.recupro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.synergy.recupro.model.Employee;

@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	Employee findByEmployeeId(Long id);

	@PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
	@Override
	public List<Employee> findAll();

	@PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
	@Override
	public Optional<Employee> findById(Long id);

	@PreAuthorize("hasAnyRole('USER', 'ADMIN','RECRUITMENT_LEAD')")
	@Override
	public <S extends Employee> List<S> findAll(Example<S> example);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Employee> S save(S entity);

	@PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
	@Override
	public <S extends Employee> List<S> saveAll(Iterable<S> entities);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void delete(Employee entity);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteAll();

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteById(Long id);
}
