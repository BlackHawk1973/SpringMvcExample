package org.top.springmvcexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Контроллер - класс, отвечающий за обработку входящих запросов
@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("time")
    public String time(Model model) {
        String currentTime = LocalDateTime.now().toString();
        //добавим значение текущего времени в модель представления
        model.addAttribute("nowTime", currentTime);
        return "time";
    }

    @GetMapping("info")
    public String info(Model model) {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        model.addAttribute("nowDate", currentDate);
        String osName = System.getProperty("os.name");
        model.addAttribute("osName", osName);
        String osVersion = System.getProperty("os.version");
        model.addAttribute("version", osVersion);
        String osArch = System.getProperty("os.arch");
        model.addAttribute("arch", osArch);
        String osUser = System.getProperty("user.name");
        model.addAttribute("user", osUser);
        return  "info";
    }
}
