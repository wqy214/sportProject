package cn.itcast;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.itcast.core.bean.user.Buyer;

/**	
 * 测试类  junit + Spring 
 * @author lx
 *
 */
public class TestJson {

	
	@Test
	public void testJSON() throws Exception {
		
		//Springmvc 课程时   @RequestBody   @ResponseBody   JSON与对象转换
		// OOM out of memery
		Buyer buyer = new Buyer();
		buyer.setUsername("范冰冰");
		ObjectMapper om = new ObjectMapper();
		//不要NULL 不要转了
		om.setSerializationInclusion(Include.NON_NULL);
		StringWriter w   = new StringWriter();
		om.writeValue(w, buyer);
		System.out.println(w.toString());
		
		//转回对象
		Buyer r = om.readValue(w.toString(), Buyer.class);
		
		System.out.println(r);
		
		
		
	}
}
