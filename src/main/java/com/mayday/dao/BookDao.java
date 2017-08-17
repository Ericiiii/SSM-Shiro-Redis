package com.mayday.dao;

import com.mayday.model.AppointmentModel;
import com.mayday.model.BookModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookDao {

    //查询一本图书
    BookModel getOne(long bookId);

    //查询所有图书
    List<BookModel>  getAllBook();

    //预约图书
    AppointmentModel appoinment(long bookId, long studentId);
}
