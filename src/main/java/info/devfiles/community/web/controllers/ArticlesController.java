package info.devfiles.community.web.controllers;

import javax.annotation.Resource;

import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.devfiles.community.entities.Article;

@Controller
public class ArticlesController {

	private SimpleMongoRepository<Article, String> articleRepository;
	
	@RequestMapping("/articles")
	public String index(Model model) {
		model.addAttribute("articles", getArticleRepository().findAll());
		return "articles/index";
	}

	public SimpleMongoRepository<Article, String> getArticleRepository() {
		return articleRepository;
	}

	@Resource(name="articleRepository")
	public void setArticleRepository(SimpleMongoRepository<Article, String> articleRepository) {
		this.articleRepository = articleRepository;
	}
	
}
