
package fr.kevin.exam.repository.interfaces;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}
