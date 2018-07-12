package pl.marcelbaungardt.naukatheamleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marcelbaungardt.naukatheamleaf.model.Article;


@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("title", "Dodawanie artykulu");
        model.addAttribute("article",new Article());
        return "index";
    }

    @PostMapping(path = "/add")
    public String addArticle(Model model, @ModelAttribute Article article){
        if (checkNotNull(article)) {
            model.addAttribute("article",article);
            return "article";
        }
        else{
            return "redirect:/error";
        }
    }

    @GetMapping(path = "/error")
    public String error(){
        return "error";
    }

    private boolean checkNotNull(Article article) {
        return article.getAuthor()!=null && article.getContent()!=null && article.getTitle()!=null;

    }
}
