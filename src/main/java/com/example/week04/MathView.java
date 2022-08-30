package com.example.week04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/calPage")
public class MathView extends VerticalLayout {
    private Button btn;
    public MathView() {
        btn = new Button("Summit");
        add(btn);
    }
}
