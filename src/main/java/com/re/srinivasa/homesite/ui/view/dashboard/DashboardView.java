package com.re.srinivasa.homesite.ui.view.dashboard;

import com.re.srinivasa.homesite.backend.service.CompanyService;
import com.re.srinivasa.homesite.backend.service.ContactService;
import com.re.srinivasa.homesite.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Map;

@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin CRM")
public class DashboardView extends VerticalLayout {

    private ContactService contactService;
    private CompanyService companyService;

    public DashboardView(ContactService contactService, CompanyService companyService) {
        this.contactService = contactService;
        this.companyService = companyService;
        addClassName("dashboard-view");
        add(getContactStats());
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

    private Component getContactStats() {
        Span stats = new Span(contactService.count() + " contacts");
        stats.addClassName("contact-stats");
        return stats;
    }

}