package com.erasmith.foodie.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	private T value;
    private List<String> errors;

    public T getValue() {
        return value;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void addError(String error) {
        if (errors == null)
            errors = new ArrayList<>();
        errors.add(error);
    }
}
