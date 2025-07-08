package me.app.customers.service;

import me.app.customers.domain.model.Occupation;

public interface OccupationService {

    public Iterable<Occupation> getAll();

    public Occupation findById(Long id);

    public Occupation create(Occupation occupation);

    public Occupation update(Long id, Occupation occupation);

    public void delete(Long id);
}
