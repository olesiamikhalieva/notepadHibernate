package com.controller;

import com.checkData.CheckData;
import com.entity.Notepad;
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
    private String errorMessage = null;
    private Notepad note;

    @Autowired
    private NotepadService notepadService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotepadList(Model model) {
        model.addAttribute("notepadList", notepadService.notepadList());
        model.addAttribute("notepadListModify", notepadService.modifyNotepadList());
        model.addAttribute("errorPhone", errorMessage);
        return "notepad";
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String serviceStudent(@ModelAttribute Notepad person, HttpServletRequest req) {
        note=person;
        if (req.getParameter("add") != null) {
            return "redirect:/add";
        }
        if (req.getParameter("del") != null) {
            return "redirect:/delete";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addNote() {
        errorMessage=null;
        if (CheckData.checkPhone(note) == 0) {
            notepadService.addPersonToNotepadList(note);
        } else {
            errorMessage = "Phone number is wrong!";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteNote() {
        errorMessage=null;
        if (CheckData.checkPhone(note) == 0) {
            notepadService.deletePersonFromNotepadList(note);
        } else {
            errorMessage = "Phone number is wrong!";
        }
        return "redirect:/";
    }


}
