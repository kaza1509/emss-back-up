package com.capstone.backend.repository;

import com.capstone.backend.entity.Chapter;
import com.capstone.backend.entity.Class;
import com.capstone.backend.entity.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Page<Lesson> findLessonByNameContainsAndActiveTrue(String name, Pageable pageable);

    Optional<Lesson> findByIdAndActiveTrue(Long id);

    boolean existsLessonByChapterAndActiveTrue(Chapter chapter);

    @Query("select le from Lesson le join le.chapter cha where le.active = true and " +
            "cha.active = true and cha.id = :chapterId")
    public List<Lesson> findAllByChapterId(Long chapterId);
}
