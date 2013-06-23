package com.oc.strutswithspring.action;

import com.oc.strutswithspring.domain.Employee;
import com.oc.strutswithspring.form.EmployeesForm;
import com.oc.strutswithspring.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class EmployeeAction extends DispatchAction {

    private static final Log LOG = LogFactory.getLog(EmployeeAction.class);

    private static final String EMPLOYEES = "employees";

    private static final String SUCCESS = "success";

    @Autowired
    private EmployeeService employeeService;

    public EmployeeAction() {
        LOG.debug("creating new EmployeeAction: " + this);
    }

    public ActionForward getEmployees(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOG.debug("getEmployees");
        populateEmployees(request);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward setUpForUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOG.debug("setUpForUpdate");
        EmployeesForm empForm = (EmployeesForm) form;
        empForm.setEmployees(employeeService.getAllEmployees());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOG.debug("update");
        EmployeesForm empForm = (EmployeesForm) form;
        employeeService.updateEmployees(empForm.getEmployees());
        populateEmployees(request);
        return mapping.findForward(SUCCESS);
    }

    private void populateEmployees(HttpServletRequest request) {
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute(EMPLOYEES, employees);
    }

}
