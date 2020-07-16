package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Bean.Book;
import mapper.bookMapper;

@Controller
public class login {
	
	@Autowired
	bookMapper bookMapper;
	
	@RequestMapping("login")
	//自动注入
	public String login(String username,String password,Model model) {
		
		//测试mybatis是否成功
		List<Book> books = bookMapper.findAll();
		for(Book book :books) {
			System.out.println(book.toString());
		}
		
		
		System.out.println(password+"  "+username);
		 model.addAttribute("books", books);
		
		return "index";//跳转到模板引擎下
	}
}
