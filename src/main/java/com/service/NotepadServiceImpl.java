package com.service;

import com.dao.NotepadDao;
import com.entity.Notepad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotepadServiceImpl implements NotepadService{

    @Autowired
    private NotepadDao notepadDao;


    @Override
    public List<Notepad> notepadList() {
        return notepadDao.notepadList();
    }

    @Override
    public void deletePersonFromNotepadList(Notepad person){
        notepadDao.delete(person);
    }

    @Override
    public void deletePersonFromNotepadListById(long id) {
        notepadDao.deleteById(id);
    }

    @Override
    public List<Notepad> modifyNotepadList() {
        return notepadDao.notepadList();
    }

    @Override
    public void addPersonToNotepadList(Notepad notepad) {
        notepadDao.add(notepad);
    }
}
