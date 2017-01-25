package com.samray.repositories;

import com.samray.domains.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/9/17
 */
@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Long>{
    Page<Post> findByEnable(boolean enable, Pageable pageable);
    @Query("select p from Post p where p.enable=?1 order by p.createAt desc  ")
    List<Post> findByEnable(boolean enable);
}
