package ru.ryabtsev.enterprise.controller.administrator;


import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("administrationPageController")
@ViewScoped
@ManagedBean
@URLMapping(
        id = "admin",
        pattern = "/admin",
        viewId = "/WEB-INF/faces/admin.xhtml"
)
public class AdministrationPageController implements Serializable {}
