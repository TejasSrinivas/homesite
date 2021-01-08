package com.re.srinivasa.homesite.ui;

import com.re.srinivasa.homesite.backend.entity.Company;
import com.re.srinivasa.homesite.backend.entity.Contact;
import com.re.srinivasa.homesite.backend.service.ContactService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private ContactService contactService;
    private Grid<Contact> grid = new Grid<>(Contact.class);

    private TextField filterText = new TextField();

    public MainView(ContactService contactService) {
        this.contactService = contactService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureFilter();

        add(filterText, grid);
        updateList();
    }

    private void updateList() {
        grid.setItems(contactService.findAll(filterText.getValue()));
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("company");
        grid.setColumns("firstName", "lastName", "email", "status");
        grid.addColumn(contact -> {
            Company company = contact.getCompany();
            return company == null ? "-" : company.getName();
        }).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }


    private void configureFilter() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
    }
}
