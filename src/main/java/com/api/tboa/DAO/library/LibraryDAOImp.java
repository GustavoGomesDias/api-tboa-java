package com.api.tboa.DAO.library;

import com.api.tboa.DAO.generic.GenericDAOImp;
import com.api.tboa.models.LibraryModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class LibraryDAOImp extends GenericDAOImp<LibraryModel> implements LibraryDAO {
    public LibraryDAOImp() {
        super(LibraryModel.class);
    }
}
