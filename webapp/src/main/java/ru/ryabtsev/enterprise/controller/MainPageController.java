package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("mainPageController")
@ViewScoped
@ManagedBean
@URLMapping(
        id = "index",
        pattern = "/index",
        viewId = "/WEB-INF/faces/index.xhtml"
)
public class MainPageController implements Serializable {
}
