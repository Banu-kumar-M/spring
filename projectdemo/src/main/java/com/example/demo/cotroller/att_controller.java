package com.example.demo.cotroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.connection.connection;
import com.example.demo.dao.AttendanceRepo;
import com.example.demo.dao.EmpRepo;
import com.example.demo.model.attendance;
import com.example.demo.model.emp;

@Controller
public class att_controller {


	@Autowired
	EmpRepo repo1;
	
	@Autowired
	AttendanceRepo repo2;
	
	@RequestMapping("/")
	public String test()
	{
		return "index-admin.jsp";
	}
		
	@RequestMapping("/add")
	public ModelAndView show_attendance(@RequestParam("date") String date)
	{
	
		List<emp> emp1 = new ArrayList<emp>();
		emp1= repo1.findAll();
		List<attendance> att = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		
		
		for(emp e1 : emp1)
		{
			int eid = e1.getEid();
			String name=e1.getEname();
			String status = "Pending";
			
			attendance a1 = new attendance(eid,date,name,status);
			att.add(a1);
			
		}
		
		for(attendance a : att)
		{
			repo2.save(a);
		}
		
		mv.addObject("date", date);
		mv.setViewName("add_date.jsp");
	   
		return mv;
		
	}
	
	
	@RequestMapping("/mark")
	public ModelAndView mark(@RequestParam("eid") int eid1, @RequestParam("date") String date1, @RequestParam("radio") String radio1)
	{
		connection con = new connection();
		
		con.update(eid1, date1, radio1);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("date", date1);
		mv.setViewName("add_date.jsp");
	   
		return mv;
	
	}
	
	@RequestMapping("/display")
	public String adding()
	{
		
		return "display.jsp";
		
	}
	
	@RequestMapping("/updateSalary")
	public String updateSalary(@RequestParam("eid") int eid1, @RequestParam("salary") int salary)
	{
		connection con = new connection();
		
		con.updateSalary(eid1, salary);
		
		
		return "updatesalary.jsp";
	}
}
