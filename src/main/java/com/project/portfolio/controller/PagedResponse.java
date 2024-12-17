package com.project.portfolio.controller.project.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> {
    private List<T> content; // Sayfadaki veriler
    private int page; // Mevcut sayfa numarası
    private int size; // Sayfa başına öğe sayısı
    private int totalPages; // Toplam sayfa sayısı
    private long totalElements; // Toplam öğe sayısı
    private boolean last; // Son sayfa kontrolü
}
