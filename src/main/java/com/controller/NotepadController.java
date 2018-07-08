package com.controller;

import com.model.Person;
import com.service.NotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class NotepadController {

    @Autowired
    private NotepadService notepadService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotepadList(Model model) {
        model.addAttribute("notepadList", notepadService.notepadList());
        model.addAttribute("notepadListModify", notepadService.notepadListModify());
        return "notepad";
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String serviceStudent(@ModelAttribute Person person, HttpServletRequest req) {
        if (req.getParameter("add") != null) {
            notepadService.addPersonToNotepadList(person);
        }
        if (req.getParameter("del") != null) {
            notepadService.deletePersonFromNotepadList(person);
        }
        return "redirect:/";
    }
}
