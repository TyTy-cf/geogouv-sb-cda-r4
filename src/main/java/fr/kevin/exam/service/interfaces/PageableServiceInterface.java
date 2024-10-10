package fr.kevin.exam.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageableServiceInterface<T> {

    Page<T> list(Pageable pageable);

}
