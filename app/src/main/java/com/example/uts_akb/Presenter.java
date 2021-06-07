package com.example.uts_akb;

public interface Presenter <T extends View> {
    void onAttach(T view);
    void onDetach();
}