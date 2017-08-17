package com.mayday.service;

import com.mayday.model.AppointmentModel;
import com.mayday.model.BookModel;

import java.util.List;

public interface BookService {

    // 查询一本图书
    BookModel getOne(long bookId);

    //查询所有图书
    List<BookModel> getAllBook();

    //预约图书
    AppointmentModel appointment(long bookId,long studentId);

}
