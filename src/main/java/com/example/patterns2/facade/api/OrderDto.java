package com.example.patterns2.facade.api;

import com.example.patterns2.facade.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private final List<ItemDto> items = new ArrayList<>();

    public void addItem(final ItemDto item) {
        items.add(item);
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
