package com.capstone.backend.repository;

import com.capstone.backend.entity.BookSeries;
import com.capstone.backend.entity.BookVolume;
import com.capstone.backend.entity.Subject;
import com.capstone.backend.model.dto.bookvolume.BookVolumeDTOResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookVolumeRepository extends JpaRepository<BookVolume, Long> {
//    Page<BookVolume> findBookVolumeByNameContainsAndActiveTrue(String name, Pageable pageable);
    Optional<BookVolume> findByIdAndActiveTrue(Long id);

    @Query("select bv from BookVolume bv join bv.bookSeriesSubject bss join bss.subject s " +
            "where bv.active = true and bss.active = true and s.active = true and s.id = :subjectId and bss.bookSeries.id = :bookSeriesId")
    public List<BookVolume> findAllBySubjectId(Long subjectId, Long bookSeriesId);
//    boolean existsBookVolumeBySubjectAndActiveTrue(Subject subject);
}

