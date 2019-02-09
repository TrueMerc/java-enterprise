package ru.ryabtsev.enterprise.converter;


import ru.ryabtsev.enterprise.controller.administrator.CategoriesListEditController;
import ru.ryabtsev.enterprise.entity.Category;
import ru.ryabtsev.enterprise.repository.CategoryRepositoryBean;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="categoryConverter")
public class CategoryConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        ValueExpression vex =
                facesContext.getApplication().getExpressionFactory()
                        .createValueExpression(facesContext.getELContext(),
                                "#{categoriesListController}", CategoriesListEditController.class);

        CategoriesListEditController categories = (CategoriesListEditController)vex.getValue(facesContext.getELContext());

        Category category = categories.get(id);
        return (category != null) ? category : new Category();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Category)o).getId();
    }
}
