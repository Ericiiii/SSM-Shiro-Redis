package com.mayday.service.impl;

import com.mayday.dao.BookDao;
import com.mayday.model.AppointmentModel;
import com.mayday.model.BookModel;
import com.mayday.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao  bookDao;

    public BookModel getOne(long bookId) {
        return bookDao.getOne(bookId);
    }

    public List<BookModel> getAllBook() {
        return bookDao.getAllBook();
    }

    public AppointmentModel appointment(long bookId, long studentId) {
        return null;
    }
}
