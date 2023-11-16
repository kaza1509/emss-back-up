package com.capstone.backend.repository;

import com.capstone.backend.entity.BookVolume;
import com.capstone.backend.entity.Chapter;
import com.capstone.backend.model.dto.chapter.ChapterDTOResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    Page<Chapter> findChapterByNameContainsAndActiveTrue(String name, Pageable pageable);
    Optional<Chapter> findByIdAndActiveTrue(Long id);
    boolean existsChapterByBookVolumeAndActiveTrue(BookVolume bookVolume);

    @Query("select c from Chapter c join c.bookVolume bv where c.active = true " +
            "and bv.active = true and bv.id = :bookVolumeId")
    public List<Chapter> findAllByBookVolumeId(Long bookVolumeId);
}
