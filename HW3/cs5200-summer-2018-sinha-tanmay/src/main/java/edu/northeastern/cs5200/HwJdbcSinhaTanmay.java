package edu.northeastern.cs5200;

import java.util.Collection;

import edu.northeastern.cs5200.dao.*;
import edu.northeastern.cs5200.models.*;

public class HwJdbcSinhaTanmay {
	
	public static void printAllDevelopers() {
		DeveloperDao dev = DeveloperDao.getInstance();
		Collection<Developer> devs = dev.findAllDevelopers();
		
		for(Developer d: devs) {
			System.out.println(d.getPerson_id()+"\t"+d.getUsername()+"\t"+d.getDeveloperKey());
		}
	}
	
	public static void addDevelopers() {
		Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com",
				null, null, null, "4321rewq", null);
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com",
				null, null, null, "5432trew", null);
		Developer charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "charlie@garcia.com",
				null, null, null, "6543ytre", null);
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		dev_dao.createDeveloper(alice);
		dev_dao.createDeveloper(bob);
		dev_dao.createDeveloper(charlie);
		printAllDevelopers();
	}
	
	public static void printAllWebsites() {
		WebsiteDao web_dao = WebsiteDao.getInstance();
		Collection<Website> webs = web_dao.findAllWebsites();
		
		for(Website w: webs) {
			System.out.println(w.getWebsite_id()+"\t"+w.getDeveloper_id()+"\t"+w.getName());
		}
	}
	
	public static void addWebsites() {
		Website facebook = new Website(123, "Facebook", "an online social media and social networking service",
				new java.sql.Date(System.currentTimeMillis()), null, 1234324,
				null, 0);
		Website twitter = new Website(234, "Twitter", "an online social media and social networking service",
				new java.sql.Date(System.currentTimeMillis()), null, 4321543,
				null, 0);
		Website wiki = new Website(345, "Wikipedia", "a free online encyclopedia\r\n", 
				new java.sql.Date(System.currentTimeMillis()), null, 3456654,
				null, 0);
		Website cnn = new Website(456, "CNN", "an American basic cable and satellite television news channel",
				new java.sql.Date(System.currentTimeMillis()), null, 6543345,
				null, 0);
		Website cnet = new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				new java.sql.Date(System.currentTimeMillis()), null, 5433455,
				null, 0);
		Website gizmodo = new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",
				new java.sql.Date(System.currentTimeMillis()), null, 4322345,
				null, 0);
		
		WebsiteDao web_dao = WebsiteDao.getInstance();
		
		web_dao.createWebsiteForDeveloper(12, facebook);
		web_dao.createWebsiteForDeveloper(23, twitter);
		web_dao.createWebsiteForDeveloper(34, wiki);
		web_dao.createWebsiteForDeveloper(12, cnn);
		web_dao.createWebsiteForDeveloper(23, cnet);
		web_dao.createWebsiteForDeveloper(34, gizmodo);
		
		addWebsiteRoles();
		
		printAllWebsites();
	}
	
	public static void addWebsiteRoles() {
		RoleDao role_dao = RoleDao.getInstance();
		
		role_dao.assignWebsiteRole(12, 123, 1, "Owner");
		role_dao.assignWebsiteRole(23, 123, 2, "Editor");
		role_dao.assignWebsiteRole(34, 123, 3, "Admin");
		
		role_dao.assignWebsiteRole(23, 234, 4, "Owner");
		role_dao.assignWebsiteRole(34, 234, 5, "Editor");
		role_dao.assignWebsiteRole(12, 234, 6, "Admin");
		
		role_dao.assignWebsiteRole(34, 345, 7, "Owner");
		role_dao.assignWebsiteRole(12, 345, 8, "Editor");
		role_dao.assignWebsiteRole(23, 345, 9, "Admin");
		
		role_dao.assignWebsiteRole(12, 456, 10, "Owner");
		role_dao.assignWebsiteRole(23, 456, 11, "Editor");
		role_dao.assignWebsiteRole(34, 456, 12, "Admin");
		
		role_dao.assignWebsiteRole(23, 567, 13, "Owner");
		role_dao.assignWebsiteRole(34, 567, 14, "Editor");
		role_dao.assignWebsiteRole(12, 567, 15, "Admin");
		
		role_dao.assignWebsiteRole(34, 678, 16, "Owner");
		role_dao.assignWebsiteRole(12, 678, 17, "Editor");
		role_dao.assignWebsiteRole(23, 678, 18, "Admin");
	}
	
	public static void printAllPages() {
		PageDao page_dao = PageDao.getInstance();
		Collection<Page> pages = page_dao.findAllPages();
		
		for(Page p: pages) {
			System.out.println(p.getPage_id()+"\t"+p.getWebsite_id()+"\t"+p.getTitle());
		}
	}
	
	public static void addPages() {
		PageDao page_dao = PageDao.getInstance();
		
		Page home = new Page(123, "Home", "Landing page", 
				new java.sql.Date(System.currentTimeMillis()), null,
				123434,
			null, 0);
		Page about = new Page(234, "About", "Website description", 
				new java.sql.Date(System.currentTimeMillis()), null,
				234545,
			null, 0);
		Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", 
				new java.sql.Date(System.currentTimeMillis()), null,
				345656,
			null, 0);
		Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", 
				new java.sql.Date(System.currentTimeMillis()), null,
				456776,
			null, 0);
		Page profile = new Page(567, "Profile", "Users can configure their personal information", 
				new java.sql.Date(System.currentTimeMillis()), null,
				567878,
			null, 0);
		
		page_dao.createPageForWebsite(567, home);
		page_dao.createPageForWebsite(678, about);
		page_dao.createPageForWebsite(345, contact);
		page_dao.createPageForWebsite(456, preferences);
		page_dao.createPageForWebsite(567, profile);
		
		addPageRoles();
		
		printAllPages();
	}
	
	public static void addPageRoles() {
		RoleDao role_dao = RoleDao.getInstance();
		
		role_dao.assignPageRole(12, 123, 1, "Editor");
		role_dao.assignPageRole(23, 123, 2, "Reviewer");
		role_dao.assignPageRole(34, 123, 3, "Writer");
		
		role_dao.assignPageRole(23, 234, 4, "Editor");
		role_dao.assignPageRole(34, 234, 5, "Reviewer");
		role_dao.assignPageRole(12, 234, 6, "Writer");
		
		role_dao.assignPageRole(34, 345, 7, "Editor");
		role_dao.assignPageRole(12, 345, 8, "Reviewer");
		role_dao.assignPageRole(23, 345, 9, "Writer");
		
		role_dao.assignPageRole(12, 456, 10, "Editor");
		role_dao.assignPageRole(23, 456, 11, "Reviewer");
		role_dao.assignPageRole(34, 456, 12, "Writer");
		
		role_dao.assignPageRole(23, 567, 13, "Editor");
		role_dao.assignPageRole(34, 567, 14, "Reviewer");
		role_dao.assignPageRole(12, 567, 15, "Writer");
	}
	
	public static void printAllWidgets() {
		WidgetDao widget_dao = WidgetDao.getInstance();
		Collection<Widget> widgets = widget_dao.findAllWidgets();
		
		for(Widget w: widgets) {
			System.out.println(w.getWidget_id()+"\t"+w.getPage_id()+"\t"+w.getName());
		}
	}
	
	public static void addWidgets() {
		HeadingWidget heading1 = new HeadingWidget(123, "head123", 0, 0, "omae wa mou shindeiru", "nani?",
				"heading", 0, 123, 0);
		HeadingWidget heading2 = new HeadingWidget(234, "head345", 0, 0, "omae wa mou shindeiru", "nani?",
				"heading", 1, 345, 0);
		HtmlWidget html1 = new HtmlWidget(345, "post234", 0, 0, "omae wa mou shindeiru", "nani?",
				"<p>Lorem</p>", 0, 234, "html");
		HtmlWidget html2 = new HtmlWidget(456, "intro456", 0, 0, "omae wa mou shindeiru", "nani?",
				"<h1>Hi</h1>", 2, 345, "html");
		YouTubeWidget yt = new YouTubeWidget(567, "video456", 400, 300, "omae wa mou shindeiru", "nani?", 
				null, 0, 456, "https://youtu.be/h67VX51QXiQ", true, true);
		ImageWidget img = new ImageWidget(678, "image345", 50, 100, "omae wa mou shindeiru", "nani?",
				null, 3, 345, "/img/567.png");
		
		WidgetDao wid_dao = WidgetDao.getInstance();
		
		wid_dao.createHeadingWidgetForPage(123, heading1);
		wid_dao.createHeadingWidgetForPage(345, heading2);
		wid_dao.createHtmlWidgetForPage(234, html1);
		wid_dao.createHtmlWidgetForPage(345, html2);
		wid_dao.createImageWidgetForPage(345, img);
		wid_dao.createYoutubeWidgetForPage(456, yt);
		
		printAllWidgets();
	}
	
	public static void executeUpdates() {
		//update 1
		
		//update 2
		int cnet_id = 0;
		WebsiteDao web_dao = WebsiteDao.getInstance();
		Collection<Website> webs = web_dao.findAllWebsites();
		
		//fetch cnet's id
		for(Website w:webs) {
			if(w.getName().equals("CNET")) {
				cnet_id = w.getWebsite_id();
				break;
			}
		}
		
		//find cnet's pages
		PageDao page_dao = PageDao.getInstance();
		Collection<Page> pages = page_dao.findPagesForWebsite(cnet_id);
		
		//update title
		for(Page p: pages) {
			p.setTitle("CNET-"+p.getTitle());
			page_dao.updatePage(p.getPage_id(), p);
		}
		
		//update 3////////////////////////////////
		
		//fetch cnet's homepage id
		int homepage_id = 0;
		for(Page p: pages) {
			if(p.getTitle().equals("Home")) {
				homepage_id = p.getPage_id();
				break;
			}
		}
		
		DeveloperDao dev_dao = DeveloperDao.getInstance();
		Collection<Developer> devs = dev_dao.findAllDevelopers();
		
		int charlie_id = 0;
		int bob_id = 0;
		
		//fetch bob's and charlie's id
		for(Developer d: devs) {
			if(d.getUsername().equals("charlie"))
				charlie_id = d.getPerson_id();
			if(d.getUsername().equals("bob"))
				bob_id = d.getPerson_id();
		}
		
		RoleDao role_dao = RoleDao.getInstance();
		Collection<Role> roles = role_dao.findAllPageRoles();
		
		//fetch their roles
		Role charlie_role = null, bob_role = null;
		for(Role r :roles) {
			if(r.getDeveloper_id() == charlie_id && r.getPage_id() == homepage_id) {
				charlie_role.setDeveloper_id(charlie_id);
				charlie_role.setPage_id(homepage_id);
				charlie_role.setRole(r.getRole());
				charlie_role.setRole_id(r.getRole_id());
			}
			if(r.getDeveloper_id() == bob_id && r.getPage_id() == homepage_id) {
				bob_role.setDeveloper_id(bob_id);
				bob_role.setPage_id(homepage_id);
				bob_role.setRole(r.getRole());
				bob_role.setRole_id(r.getRole_id());
			}
		}
		
		//delete previous roles
		role_dao.deletePageRole(charlie_role.getDeveloper_id(), charlie_role.getPage_id(),
				charlie_role.getRole_id());
		role_dao.deletePageRole(bob_role.getDeveloper_id(), bob_role.getPage_id(),
				bob_role.getRole_id());
		
		//swap roles
		Role temp = charlie_role;
		charlie_role = bob_role;
		bob_role = temp;
		
		//insert new roles
		role_dao.assignPageRole(charlie_role.getDeveloper_id(), charlie_role.getPage_id(),
				charlie_role.getRole_id(), charlie_role.getRole());
		role_dao.assignPageRole(bob_role.getDeveloper_id(), bob_role.getPage_id(),
				bob_role.getRole_id(), bob_role.getRole());
	}
	
	public static void executeDeletes() {
		
		//delete 1//////////////////////////////////
		
		//get contact page id
		PageDao page_dao = PageDao.getInstance();
		int contact_Id = 0;
		
		Collection<Page> pages = page_dao.findAllPages();
		for(Page p: pages) {
			if(p.getTitle().equals("Contact")) {
				contact_Id = p.getPage_id();
				break;
			}
		}
		
		//find widgets for this page
		WidgetDao wid_dao = WidgetDao.getInstance();
		Collection<Widget> widgets = wid_dao.findWidgetsForPage(contact_Id);
		
		//find the latest widget
		int del_wid_id = 0;
		int max_order = 0;
		
		for(Widget w: widgets) {
			if(w.getOrder() > max_order) {
				max_order = w.getOrder();
				del_wid_id = w.getWidget_id();
			}
		}
		
		//delete that widget
		wid_dao.deleteWidget(del_wid_id);
		
		//delete 2/////////////////////////
		
		//get wikipedia's id
		WebsiteDao web_dao = WebsiteDao.getInstance();
		Collection<Website> webs = web_dao.findAllWebsites();
		
		int wiki_id = 0;
		for(Website w: webs) {
			if(w.getName().equals("Wikipedia")) {
				wiki_id = w.getWebsite_id();
				break;
			}
		}
		
		pages = page_dao.findPagesForWebsite(wiki_id);
		java.sql.Date latest_date = java.sql.Date.valueOf("2002-02-23");
		int del_page_id = 0;
		for(Page p: pages) {
			if(latest_date.compareTo(p.getUpdated()) < 0) {
				latest_date = p.getUpdated();
				del_page_id = p.getPage_id();
			}
		}
		
		page_dao.deletePage(del_page_id);
		
		//delete 3////////////////////////////////
		
		//find cnet id
		int cnet_id = 0;
		for(Website w: webs) {
			if(w.getName().equals("CNET")) {
				cnet_id = w.getWebsite_id();
				break;
			}
		}
		
		//cascade delete will be performed as sql tables implement 
		//on delete cascade for all foreign key references
		web_dao.deleteWebsite(cnet_id);
	}
	
}
