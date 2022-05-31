package com.api.tboa.DAO.book;

import com.api.tboa.DAO.generic.GenericDAOImp;
import com.api.tboa.models.BookModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BookDAOImp extends GenericDAOImp<BookModel> implements BookDAO {
    public BookDAOImp() {
        super(BookModel.class);
    }

}
