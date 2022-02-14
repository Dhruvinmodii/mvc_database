package mvccrud.controller;

import java.util.List;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;

import org.apache.naming.ContextAccessController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import mvccrud.model.User;
import mvccrud.model.Userdao;


@Controller
public class ContactController {
	
	ApplicationContext context;
	

	@RequestMapping("/contact")
	public String showForm(Model m)
	{
		m.addAttribute("command",new User());
		return "contact";
	}
	
	/*
	@RequestMapping(path = "/processform" , method = RequestMethod.POST)
	public String handleForm(
			//Method 1 to get data in controller using RequestParam
			@RequestParam("email" ) String varemail ,
			@RequestParam("username") String varname ,
			@RequestParam("userpass") String varpass , Model model) 
	{

//		System.out.println("user email is "+varemail);
//		System.out.println("user name is " + varname);
//		System.out.println("user passeword is "+varpass);
		
		//method 2 model
		
//		User user = new User();
//		user.setEmail(varemail);
//		user.setUsername(varname);
//		user.setUserpass(varpass);
//		
//		System.out.println(user);
//		model.addAttribute("user", user);
		
		//process like add data into database.
		
		model.addAttribute("name" , varname);
		model.addAttribute("email" , varemail);
		model.addAttribute("password" , varpass);
		return "success";
	}*/
	
	//method 3 model attribute best way
//	@RequestMapping(path = "/processform" , method = RequestMethod.POST)
//	public String handleForm(@ModelAttribute User user , Model model) 
//	{
//		
//		System.out.println(user);
//		
//		return "success";
//	}
	@RequestMapping(path = "/processform" , method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user , Model m)
	{
		context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Userdao dao = context.getBean("dao",Userdao.class);
		dao.save(user);
		m.addAttribute("msg","insert sucessfully");
		return "success";
	}
	
	   
}
	
