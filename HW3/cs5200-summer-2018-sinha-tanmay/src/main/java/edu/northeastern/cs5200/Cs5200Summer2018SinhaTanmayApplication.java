package edu.northeastern.cs5200;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cs5200Summer2018SinhaTanmayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Summer2018SinhaTanmayApplication.class, args);
		 
		//insert developers
		HwJdbcSinhaTanmay.addDevelopers();
		
		//insert websites
		HwJdbcSinhaTanmay.addWebsites();
		
		//insert pages
		HwJdbcSinhaTanmay.addPages();
		
		//insert widgets
		HwJdbcSinhaTanmay.addWidgets();
		
		//update queries
		
		//delete queries
		
	}
	
/*	////////////////functions to call developerDAO functions//////////////////////////////////
	public static void printAllDevelopers() {
		DeveloperDao dev = DeveloperDao.getInstance();
		Collection<Developer> devs = dev.findAllDevelopers();
		
		for(Developer d: devs) {
			System.out.println(d.getPerson_id()+"\t"+d.getUsername()+"\t"+d.getDeveloperKey());
		}
	}
	
	public static void printDeveloperById() {
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		Developer dev = dev_dao.findDeveloperById(12);
		
		System.out.println(dev.getPerson_id()+"\t"+dev.getUsername()+"\t"+dev.getDeveloperKey());
	}
	
	public static void printDeveloperByUsername() {
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		Developer dev = dev_dao.findDeveloperByUsername("alice");
		
		System.out.println(dev.getPerson_id()+"\t"+dev.getUsername()+"\t"+dev.getDeveloperKey());
	}
	
	public static void printDeveloperByCredentials() {
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		Developer dev = dev_dao.findDeveloperByCredentials("alice", "alice");
		
		System.out.println(dev.getPerson_id()+"\t"+dev.getUsername()+"\t"+dev.getDeveloperKey());
	}
	
	public static void addDeveloper() {
		Developer dev = new Developer(3, "Ramu", "Kaka", "ramu", "kaka", "ramu@gmail.com",
				null, null, null, "avx123", null);
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		dev_dao.createDeveloper(dev);
		printAllDevelopers();
	}
	
	public static void modifyDeveloper() {
		Developer dev = new Developer(3, "Bablu", "Dildaar", "bablu", "dildaar", "bablu@gmail.com",
				null, null, null, "avx234", null);
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		dev_dao.updateDeveloper(3, dev);
		printAllDevelopers();
	}
	
	public static void removeDeveloper() {
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		dev_dao.deleteDeveloper(3);
		printAllDevelopers();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	////website DAO
	public static void printAllWebsites() {
		WebsiteDao web_dao = WebsiteDao.getInstance();
		Collection<Website> webs = web_dao.findAllWebsites();
		
		for(Website w: webs) {
			System.out.println(w.getWebsite_id()+"\t"+w.getDeveloper_id()+"\t"+w.getName());
		}
	}
	
	public static void printAllWebsitesByDeveloper() {
		WebsiteDao web_dao = WebsiteDao.getInstance();
		Collection<Website> webs = web_dao.findWebsiteByDeveloperId(12);
		
		for(Website w: webs) {
			System.out.println(w.getWebsite_id()+"\t"+w.getDeveloper_id()+"\t"+w.getName());
		}
	}
	
	public static void printWebsitebyID() {
		WebsiteDao web_dao = WebsiteDao.getInstance();
		Website web = web_dao.findWebsiteById(123);
		
		System.out.println(web.getWebsite_id()+"\t"+web.getDeveloper_id()+"\t"+web.getName());
	}
	
	public static void addWebsite() {
		Website web = new Website(321, "pornhub", null, null, null, 69420,
				null, 0);
		WebsiteDao web_dao = WebsiteDao.getInstance();
		web_dao.createWebsiteForDeveloper(12, web);
		printAllWebsites();
	}
	
	public static void modifyWebsite() {
		Website web = new Website(321, "xvideos", "better than pornhub", null, null, 42069,
				null, 0);
		WebsiteDao web_dao = WebsiteDao.getInstance();
		web_dao.updateWebsite(321, web);
		printAllWebsites();
	}
	
	public static void removeWebsite() {
		WebsiteDao web_dao = WebsiteDao.getInstance();
		web_dao.deleteWebsite(321);;
		printAllWebsites();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	public static void printAllPages() {
		PageDao page_dao = PageDao.getInstance();
		Collection<Page> pages = page_dao.findAllPages();
		
		for(Page p: pages) {
			System.out.println(p.getPage_id()+"\t"+p.getWebsite_id()+"\t"+p.getTitle());
		}
	}
	*/
}
