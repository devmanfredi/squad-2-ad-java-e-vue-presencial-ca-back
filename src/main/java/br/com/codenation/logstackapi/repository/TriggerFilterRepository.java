package br.com.codenation.logstackapi.repository;

import br.com.codenation.logstackapi.model.entity.TriggerFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TriggerFilterRepository extends JpaRepository<TriggerFilter, UUID> {
}
