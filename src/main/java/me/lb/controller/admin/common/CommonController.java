package me.lb.controller.admin.common;import javax.servlet.http.HttpSession;import me.lb.model.system.Emp;import me.lb.model.system.User;import me.lb.support.jackson.JsonWriter;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.ResponseBody;@Controllerpublic class CommonController {	@ResponseBody	@RequestMapping(value = "/getLoginInfo")	public String getLoginInfo(HttpSession session) {		try {			User u = (User) session.getAttribute("user");			return JsonWriter.getInstance().filter(User.class, "roles")					.filter(Emp.class, "org", "users").getWriter()					.writeValueAsString(u);		} catch (Exception e) {			e.printStackTrace();			return "{}";		}	}}