package dev.bobscott.sfgpetclinic.services;

import dev.bobscott.sfgpetclinic.model.Owner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
