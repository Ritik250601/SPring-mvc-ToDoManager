package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ToDoDao;
import com.entities.Todo;

@Controller
public class HomeCtrl {

	@RequestMapping("/home")
	public String home(Model model) {
		String page = "home";		
		//Getting from ToDoDao
		ToDoDao td = new ToDoDao();
		List<Todo> lst = td.getTodo();
		
		model.addAttribute("todos", lst);	
		model.addAttribute("page", page);
		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model model) {
		Todo t = new Todo();
		model.addAttribute("page", "add");
		model.addAttribute("todo", t);
		return "home";
	}

	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo, Model model) {
		model.addAttribute("page", "home");
		todo.setTodoDate(new Date());
		System.out.println(todo);
		ToDoDao td = new ToDoDao();
		boolean result = td.saveTodo(todo);
		
		if(result) {
			model.addAttribute("msg", "successfully addded");			
		}
		else {
			model.addAttribute("msg", "Something went Wrong");
		}

	

		return "home";
	}

}
