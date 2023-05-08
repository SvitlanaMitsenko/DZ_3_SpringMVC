package org.example.models;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class SimpleClass {

    public SimpleClass() {
    }
    public SimpleClass(int id) {
        this.id = id;
    }

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
