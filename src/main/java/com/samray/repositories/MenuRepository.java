package com.samray.repositories;

import com.samray.domains.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
public interface MenuRepository extends JpaRepository<Permission,Long>{
    @Query("select p from Permission p where p.pid=?1")
    List<Permission> findByPid(long pid);
}
