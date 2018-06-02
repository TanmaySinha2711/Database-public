package edu.northeastern.cs5200;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class mycontroller {
	
	@Autowired
	HelloRepository hr;
	@RequestMapping("api/hello/insert")
	public HelloObject insertObject() {
		HelloObject obj = new HelloObject("hello tanmay sinha");
		hr.save(obj);
		return obj;
	}
	
	@RequestMapping("api/hello/insert/{msg}")
	public HelloObject insertMessage(@PathVariable("msg") String message) {
		HelloObject obj = new HelloObject(message);
		hr.save(obj);
		return obj;
	}
	
	@RequestMapping("api/hello/select/all")
	public List<HelloObject> selectObjects() {
		List<HelloObject> list_obj = (List<HelloObject>)hr.findAll();
		return list_obj;
	}
	
	@RequestMapping()
	public String helloBolLocal() {
		String str = "History is written by the victor. \nIf he wins and we die, his truth becomes written and ours is lost.\nBut only if he wins and we die.";
		return str;
	}
	
	@RequestMapping("api/hello/string")
	public String helloBol() {
		String str = "History is written by the victor. \nIf he wins and we die, his truth becomes written and ours is lost.\nBut only if he wins and we die.";
		return str;
	}
	
	@RequestMapping("api/hello/object")
	public HelloObject helloBolObj() {
		String str = "History is written by the victor. \nIf he wins and we die, his truth becomes written and ours is lost.\nBut only if he wins and we die.";
		HelloObject obj = new HelloObject(str);
		return obj;
	}
}
