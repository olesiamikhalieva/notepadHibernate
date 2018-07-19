package com.service;


import com.entity.Notepad;

import java.util.List;

public interface NotepadService {

    List<Notepad> notepadList();

    void addPersonToNotepadList(Notepad notepad);

    void deletePersonFromNotepadList(Notepad notepad);

    List<Notepad> modifyNotepadList();
}
