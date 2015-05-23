package springboot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.domain.Customer;
import springboot.form.CustomerForm;
import springboot.service.CustomerService;
import springboot.service.LoginUserDetails;

@Controller
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@ModelAttribute
	CustomerForm customerForm() {
		return new CustomerForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	String index(Model model) {
		model.addAttribute("customers", service.findAll());
		return "customers/index";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	String show(@PathVariable String id, Model model) {
		Customer customer = service.findById(Integer.valueOf(id));
		model.addAttribute("customer", customer);
		return "customers/show";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	String newCustomer() {
		return "customers/form";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	String edit(@PathVariable String id, CustomerForm customerForm) {
		Customer customer = service.findById(Integer.valueOf(id));
		BeanUtils.copyProperties(customer, customerForm);
		return "customers/form";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	String create(@Validated CustomerForm customerForm,
				  BindingResult result,
				  Model model,
				  @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerForm, customer);
		service.save(customer, loginUserDetails.getUser());
		return "redirect:/customers";
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.PUT)
	String update(@PathVariable String id,
				  @Validated CustomerForm customerForm,
				  BindingResult result,
				  Model model,
				  @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		Customer customer = service.findById(Integer.valueOf(id));
		BeanUtils.copyProperties(customerForm, customer);
		service.save(customer, loginUserDetails.getUser());
		return "redirect:/customers";
	}

}
