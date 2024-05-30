package com.example.MultipleDatabase.BookRepo;

import com.example.MultipleDatabase.Bookmodel.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
