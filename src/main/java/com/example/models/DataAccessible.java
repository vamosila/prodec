package com.example.models;

import java.util.List;

public interface DataAccessible<T> {
    public List<T> index();
    public void store(T data);
    public void update(T data, int id);
    public void destroy(int id);
}
