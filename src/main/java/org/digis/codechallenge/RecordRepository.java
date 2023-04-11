package org.digis.codechallenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Integer> {
    List<Record> findByTitleContainingOrContentContaining(String text, String textAgain);

}
