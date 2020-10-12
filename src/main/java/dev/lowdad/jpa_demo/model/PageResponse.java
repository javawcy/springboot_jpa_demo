package dev.lowdad.jpa_demo.model;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
public class PageResponse<T> {

    private Integer index;
    private Long count;
    private List<T> records;

    public PageResponse() {
    }

    public PageResponse(Page<T> page) {
        this.index = page.getNumber();
        this.count = page.getTotalElements();
        this.records = page.stream().collect(Collectors.toList());
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
