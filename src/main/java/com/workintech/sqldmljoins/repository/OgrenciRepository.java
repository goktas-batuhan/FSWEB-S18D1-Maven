package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    String QUESTION_2 = "SELECT o.* FROM ogrenci as o INNER JOIN islem as i ON o.ogrno = i.ogrno";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findStudentsWithBook();

    String QUESTION_3 = "SELECT o.* FROM ogrenci as o LEFT JOIN islem as i ON o.ogrno = i.ogrno WHERE i.ogrno IS NULL";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<Ogrenci> findStudentsWithNoBook();

    String QUESTION_4 = "SELECT o.sinif, count(i.kitapno) FROM ogrenci as o INNER JOIN islem as i ON o.ogrno = i.ogrno WHERE (o.sinif = '10A' OR o.sinif='10B') GROUP BY o.sinif";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<KitapCount> findClassesWithBookCount();

    String QUESTION_5 = "SELECT count(*) FROM ogrenci";
    @Query(value = QUESTION_5, nativeQuery = true)
    Integer findStudentCount();

    String QUESTION_6 = "SELECT count(DISTINCT ad) FROM ogrenci";
    @Query(value = QUESTION_6, nativeQuery = true)
    Integer findUniqueStudentNameCount();

    String QUESTION_7 = "SELECT ad, count(ad) FROM ogrenci GROUP BY ad";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<StudentNameCount> findStudentNameCount();

    String QUESTION_8 = "SELECT sinif, count(sinif) FROM ogrenci GROUP BY sinif";
    @Query(value = QUESTION_8, nativeQuery = true)
    List<StudentClassCount> findStudentClassCount();

    String QUESTION_9 = "SELECT o.ad, o.soyad, count(i.kitapno) FROM ogrenci as o INNER JOIN islem as i ON o.ogrno = i.ogrno GROUP BY o.ad, o.soyad";
    @Query(value = QUESTION_9, nativeQuery = true)
    List<StudentNameSurnameCount> findStudentNameSurnameCount();
}
