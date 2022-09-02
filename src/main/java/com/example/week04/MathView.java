package com.example.week04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "/index1")
public class MathView extends FormLayout {
    private TextField n1, n2, ans;
    private Button plus, minus, divide, multi, mod, max;
//    private Button btn;
    public MathView() {
        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        ans = new TextField("Answer");
        plus = new Button("+");
        minus = new Button("-");
        divide = new Button("/");
        multi = new Button("x");
        mod = new Button("Mod");
        max = new Button("Max");

        HorizontalLayout h = new HorizontalLayout();
        VerticalLayout v = new VerticalLayout();

        h.add(plus, minus, multi, divide, mod, max);
        v.add(n1, n2, h, ans);
        add(v);

        plus.addClickListener(event -> {
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

                    ans.setValue(out);
        });

        minus.addClickListener(event -> {
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });

        divide.addClickListener(event -> {
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });

        multi.addClickListener(event -> {
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });

        mod.addClickListener(event -> {
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });

        max.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", n1.getValue());
            formData.add("n2", n2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
    }
}
