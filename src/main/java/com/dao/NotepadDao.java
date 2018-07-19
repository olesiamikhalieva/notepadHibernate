package com.dao;


import com.entity.Notepad;

import java.util.List;

public interface NotepadDao {
    List<Notepad> notepadList();
    void add(Notepad notepad);
    void delete(Notepad notepad);
}
