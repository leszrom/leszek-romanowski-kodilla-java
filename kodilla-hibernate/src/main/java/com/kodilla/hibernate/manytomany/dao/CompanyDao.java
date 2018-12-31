package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> retrieveCompaniesThatNamesStartWith(@Param("FIRSTCHARS") String firsChars);

    @Query
    List<Company>retrieveCompaniesWithFirstThreeChars(@Param("CHARS") String threeChars);

    @Query
    List<Company> retrieveCompaniesThatNamesContainString(@Param("ARG") String anyString);
}
