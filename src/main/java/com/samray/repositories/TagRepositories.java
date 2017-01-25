package com.samray.repositories;

import com.samray.domains.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
@Repository
@Transactional
public interface TagRepositories extends JpaRepository<Tag,Long>{
}
