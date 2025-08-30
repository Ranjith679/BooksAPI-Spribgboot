package com.projecthub.rk.Book_Management_App.repository;

import com.projecthub.rk.Book_Management_App.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book , Integer> {
}
