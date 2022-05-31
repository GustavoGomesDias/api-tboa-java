package com.api.tboa.DAO.category;

import com.api.tboa.DAO.generic.GenericDAOImp;
import com.api.tboa.models.CategoryModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class CategoryDAOImp extends GenericDAOImp<CategoryModel> implements CategoryDAO {
    public CategoryDAOImp() {
        super(CategoryModel.class);
    }
}
