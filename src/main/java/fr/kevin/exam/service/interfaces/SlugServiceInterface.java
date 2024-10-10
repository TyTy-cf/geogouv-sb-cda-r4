package fr.kevin.exam.service.interfaces;

public interface SlugServiceInterface<T> {

    T findBySlug(String slug);

}
