package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import Bean.Book;
//此处相当于mybatis的Mapper配置文件

@Mapper//注解方式
@Controller
public interface bookMapper {
	
	
	@Select("select * from book")
	public List<Book> findAll();
	
	
	
	
	
}
