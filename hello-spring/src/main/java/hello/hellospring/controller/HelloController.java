package hello.hellospring.controller;


import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hallo")
    public String hello(Model model){
        model.addAttribute("data","asdf!!");
        return "hello";
    }
    @GetMapping("hi")
    public String hi(Model model){
        model.addAttribute("date","시볼");
        return "test/hi";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name,@RequestParam(value = "boy") String boy,Model model){
        model.addAttribute("name",name);
        model.addAttribute("boy",boy);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name,Model model){
        model.addAttribute("name",name);

        return "<h1>"+name+"hello</h1>";
    }

    @GetMapping("hello-api")
    @ResponseBody()
    public Hello helloApi(@RequestParam("name") String name,@RequestParam("addres") String addres,@RequestParam("hakbun") String hakbun){
        Hello hello = new Hello();
        Baby baby = new Baby();
        baby.setHakbun(hakbun);
        hello.setName(name);
        hello.setAddres(addres);
        hello.setBaby(baby);
        return hello;

    }

    static class Hello{
        private String name;
        private Baby baby;

        public Baby getBaby() {
            return baby;
        }

        public void setBaby(Baby baby) {
            this.baby = baby;
        }

        public String getAddres() {
            return addres;
        }

        public void setAddres(String addres) {
            this.addres = addres;
        }

        private String addres;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    static class Baby{
        private String hakbun;


        public String getHakbun() {
            return hakbun;
        }

        public void setHakbun(String hakbun) {
            this.hakbun = hakbun;
        }
    }


}
